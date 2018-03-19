package netty.nio;

import java.io.IOException;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

/**
 * @author: Bruce Zhao
 * @email: zhzh402@163.com
 * @date: 2018/3/19 20:16
 */
public class TimeClientHandle implements Runnable {
    private String host;
    private int port;
    private Selector selector;
    private SocketChannel socketChannel;
    private volatile boolean stop;

    public TimeClientHandle(String host, int port) {
        this.host = host;
        this.port = port;

        try {
            selector = Selector.open();
            socketChannel = SocketChannel.open();
            socketChannel.configureBlocking(false);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    @Override
    public void run() {
        try{
            doConnect();
        } catch (IOException e){
            e.printStackTrace();
            System.exit(1);
        }

    }

    private void doConnect() throws IOException{


    }
}
