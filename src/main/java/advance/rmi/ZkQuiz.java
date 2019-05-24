package advance.rmi;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Collections;
import java.util.List;

public class ZkQuiz {

    static ZooKeeper zk;

    static {
        try {
            zk = new ZooKeeper(RmiConstants.URL, RmiConstants.TIME_OUT, null);
            Stat exists = zk.exists(RmiConstants.SERVICE_ROOT, false);
            if (exists == null) {
                zk.create(RmiConstants.SERVICE_ROOT, null, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void register(String host, String port) {
        try {
            String path = RmiConstants.SERVICE_ROOT + "/" + host + ":" + port;
            Stat exists = zk.exists(path, false);
            if (exists == null) {
                zk.create(path, null, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void handle(String path) throws RemoteException, NotBoundException {

        String host = path.substring(0, path.indexOf(":"));
        String port = path.substring(path.indexOf(":") + 1);
        String[] args = new String[]{host, port};
        Client.main(args);
    }

    public static void main(String[] args) throws AlreadyBoundException, RemoteException, NotBoundException {
        List<String> children = null;
        try {
            children = zk.getChildren(RmiConstants.SERVICE_ROOT, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assert children != null;

        for (int i = 0; i < 20; i++) {
            Collections.shuffle(children);
            String path = children.get(0);
            handle(path);
        }
    }
}
