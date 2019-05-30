package java7.nio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.NetworkInterface;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.SocketOption;
import java.net.StandardProtocolFamily;
import java.net.StandardSocketOptions;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.channels.DatagramChannel;
import java.nio.channels.FileChannel;
import java.nio.channels.MembershipKey;
import java.nio.channels.NetworkChannel;
import java.nio.channels.spi.SelectorProvider;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.PosixFileAttributes;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class FilePath {

    public static void main(String[] args) {
        multicastChannel();
    }

    public static void multicastChannel() {
        try {
            NetworkInterface networkInterface = NetworkInterface.getByName("eth0");
            System.out.println(networkInterface);
            // open channel
            DatagramChannel dc = DatagramChannel.open(StandardProtocolFamily.INET);
            // set channel multicast
            dc.setOption(StandardSocketOptions.SO_REUSEADDR, true);
            dc.bind(new InetSocketAddress(8080));
            dc.setOption(StandardSocketOptions.IP_MULTICAST_IF, networkInterface);
            // join group 多播地址 https://www.xuebuyuan.com/914776.html
            InetAddress group = InetAddress.getByName("224.0.0.1");
            MembershipKey key = dc.join(group, networkInterface);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void networkChannel() {
        SelectorProvider provider = SelectorProvider.provider();
        try {
            NetworkChannel socketChannel = provider.openSocketChannel();
            SocketAddress address = new InetSocketAddress(3080);
            socketChannel = socketChannel.bind(address);
            Set<SocketOption<?>> options = socketChannel.supportedOptions();
            System.out.println(options);
            socketChannel.setOption(StandardSocketOptions.IP_TOS, 3);
            boolean keepAlive = socketChannel.getOption(StandardSocketOptions.SO_KEEPALIVE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * CompletionHandler
     */
    public static void ioCallback() {
        Path path = Paths.get("D:\\Projects\\WebDev\\coding-sword\\src\\main\\java\\java7\\nio\\NIO-README.md");
        try {
            AsynchronousFileChannel channel = AsynchronousFileChannel.open(path);
            ByteBuffer buffer = ByteBuffer.allocate(1_000);
            channel.read(buffer, 0, buffer, new CompletionHandler<Integer, ByteBuffer>() {
                @Override
                public void completed(Integer result, ByteBuffer attachment) {
                    System.out.println("Byte read: " + result);
                }

                @Override
                public void failed(Throwable exc, ByteBuffer attachment) {
                    exc.printStackTrace();
                }
            });
            System.out.println("Other Task...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * future
     */
    public static void ioFuture() {
        Path path = Paths.get("D:\\Projects\\WebDev\\coding-sword\\src\\main\\java\\java7\\nio\\NIO-README.md");
        try {
            AsynchronousFileChannel channel = AsynchronousFileChannel.open(path);
            ByteBuffer buffer = ByteBuffer.allocate(1_000);
            Future<Integer> result = channel.read(buffer, 0);
            while (!result.isDone()) {
                System.out.println("Waiting...");
            }
            System.out.println("Byte read: " + result.get());
        } catch (IOException | InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    public static void fileChannel() {
        Path path = Paths.get("D:\\Projects\\WebDev\\coding-sword\\src\\main\\java\\java7\\nio\\NIO-README.md");
        ByteBuffer buffer = ByteBuffer.allocate(50);
        try {
            FileChannel channel = FileChannel.open(path, StandardOpenOption.READ);
            channel.read(buffer, channel.size() - 50);

            Charset charset = Charset.forName("UTF-8");
            CharsetDecoder decoder = charset.newDecoder();
            CharBuffer charBuffer = decoder.decode(buffer);
            System.out.println(charBuffer.flip().toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * WatchService 监测目录变化
     */
    public static void fileWatch() {
        boolean shutdown = false;
        try {
            WatchService watcher = FileSystems.getDefault().newWatchService();
            Path dir = FileSystems.getDefault().getPath("D:\\Projects\\WebDev\\coding-sword\\src\\main\\java\\java7\\nio\\");
            WatchKey key = dir.register(watcher, StandardWatchEventKinds.ENTRY_MODIFY);
            while (!shutdown) {
                key = watcher.take();
                for (WatchEvent<?> event : key.pollEvents()) {
                    if (event.kind() == StandardWatchEventKinds.ENTRY_MODIFY) {
                        System.out.println("Modified!");
                    }
                }
                key.reset();
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 带缓冲区的读取器和写入器
     */
    public static void fileReadWrite() {
        Path path = Paths.get("D:\\Projects\\WebDev\\coding-sword\\src\\main\\java\\java7\\nio\\NIO-README.md");
        System.out.println("===========> BufferedReader");
        try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("===========> BufferedWriter");
        try (BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8, StandardOpenOption.APPEND)) {
            writer.append("\nTest Writer\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 简化文件读取
        try {
            List<String> lines = Files.readAllLines(path);
            System.out.println(lines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 文件复制、删除、属性等文件处理
     */
    public static void filePermissions() {
        Path path = Paths.get("D:\\Projects\\WebDev\\coding-sword\\src\\main\\java\\java7\\nio\\NIO-README.md");
        try {
            PosixFileAttributes attr = Files.readAttributes(path, PosixFileAttributes.class);
            Set<PosixFilePermission> posixFilePermissions = attr.permissions();
            posixFilePermissions.clear();

            String owner = attr.owner().getName();
            String perms = PosixFilePermissions.toString(posixFilePermissions);
            System.out.format("%s %s%n", owner, perms);

            posixFilePermissions.add(PosixFilePermission.OWNER_READ);
            posixFilePermissions.add(PosixFilePermission.GROUP_READ);
            posixFilePermissions.add(PosixFilePermission.OTHERS_READ);
            posixFilePermissions.add(PosixFilePermission.OWNER_WRITE);

            Files.setPosixFilePermissions(path, posixFilePermissions);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void fileAttributes() {
        Path file = Paths.get("D:\\Projects\\WebDev\\coding-sword\\src\\main\\java\\java7\\nio\\NIO-README.md");
        try {
            System.out.println(Files.getLastModifiedTime(file));
            System.out.println(Files.getOwner(file).getName());
            System.out.println(Files.isSymbolicLink(file));
            System.out.println(Files.readAttributes(file, "*"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void copyFile() {
        Path source = Paths.get("D:\\Projects\\WebDev\\coding-sword\\src\\main\\java\\java7\\nio\\NIO-README.md");
        Path target = Paths.get("D:\\Projects\\WebDev\\coding-sword\\src\\main\\java\\java7\\nio\\NIO-READ.md");
        try {
            if (Files.exists(source)) {
                Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createFile() {
        Path file = Paths.get("D:\\Projects\\WebDev\\coding-sword\\src\\main\\java\\java7\\nio\\NIO-README.md");
        try {
            if (!Files.exists(file)) {
                Files.createFile(file);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deleteFile() {
        Path path = Paths.get("D:\\Projects\\WebDev\\coding-sword\\src\\main\\java\\java7\\nio\\NIO-README.md");
        try {
            if (Files.exists(path)) {
                Files.delete(path);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 遍历目录树
     */
    public static void dirTraverseTree() {
        Path dir = Paths.get("D:\\Projects\\WebDev\\coding-sword\\src");
        try {
            Files.walkFileTree(dir, new FindJavaVisitor());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 遍历目录树
     */
    private static class FindJavaVisitor extends SimpleFileVisitor<Path> {
        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            if (file.toString().endsWith(".java")) {
                System.out.println(file.getFileName());
            }
            return FileVisitResult.CONTINUE;
        }
    }

    /**
     * 遍历路径下文件
     */
    public static void dirTree() {
        Path dir = Paths.get("D:\\Projects\\WebDev\\coding-sword\\src\\main\\java\\java7\\nio");
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir, "*.java")) {
            for (Path entry : stream) {
                System.out.println(entry.getFileName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void path() {
        File file = new File("Listing.txt");
        Path listing = file.toPath();
        System.out.println(listing.toAbsolutePath());
        file = listing.toFile();
//        System.out.println(listing.toRealPath());

        // 转换Path
        Path prefix = Paths.get("D:\\Projects\\java");
        File logConfig = new File("conf\\conf.properties");
        Path logPath = prefix.resolve(logConfig.toPath());
        System.out.println(logPath.toAbsolutePath());

        Path logConf = Paths.get("D:\\Projects\\java\\log\\conf\\conf.properties");
        Path logDir = prefix.relativize(logConf);
        System.out.println(logDir.toAbsolutePath());
    }

}
