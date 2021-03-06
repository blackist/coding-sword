package concurrent.c7_communicate;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * TODO ${TODO}
 *
 * @author LiangLiang.Dong<liangl.dong @ qq.com>
 * @since 2019/7/18 23:28.
 */
public class Pipe {

    public static void main(String[] args) throws IOException {
        PipedWriter out = new PipedWriter();
        PipedReader in = new PipedReader();
        out.connect(in);
        Thread printThread = new Thread(new Print(in), "PrintThread");
        printThread.start();
        int receive = 0;
        try {
            while ((receive = System.in.read()) != -1) {
                out.write(receive);
            }
        } catch (Exception e) {

        } finally {
            out.close();
        }
    }

    static class Print implements Runnable {
        private PipedReader in;
        public Print(PipedReader in) {
            this.in = in;
        }

        @Override
        public void run() {
            int receive = 0;

            try {
                while ((receive = in.read()) != -1) {
                    System.out.println((char) receive);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
