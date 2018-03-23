package netty.faio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author: Bruce Zhao
 * @email: zhzh402@163.com
 * @date: 2018/3/17 12:01
 */
public class TimeServer {
    public static void main(String[] args) throws IOException {
        int port = 8080;
        if(args != null && args.length > 0){
            try{
                port = Integer.parseInt(args[0]);
            }catch (NumberFormatException e){
                e.printStackTrace();
            }
        }

        ServerSocket server = null;
        try{
            server = new ServerSocket(port);
            System.out.println("FIO Time server started in port: " + port);
            TimeServerHandlerExecutePool executePool = new TimeServerHandlerExecutePool(50, 1000);

            Socket socket = null;
            while (true){
                socket = server.accept();
                executePool.execute(new TimeServerHandler(socket));
//                new Thread(new TimeServerHandler(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(server != null){
                System.out.println("Time server closed");
                server.close();
                server = null;
            }
        }
    }
}
