package nettyiopackage;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

import java.util.logging.Logger;

/**
 * @author: Bruce Zhao
 * @email: zhzh402@163.com
 * @date: 2018/3/21 19:23
 */
public class NettyTimeClientHandler extends ChannelHandlerAdapter {
    private static final Logger logger = Logger.getLogger(NettyTimeClientHandler.class.getName());

    private int counter;
    private byte[] req;

    public NettyTimeClientHandler() {
        req = ("QUERY TIME ORDER" + System.getProperty("line.separator")).getBytes();

    }

    public void channelActive(ChannelHandlerContext ctx){
        ByteBuf message = null;
        for(int i = 0; i < 100; i++){
            message = Unpooled.buffer(req.length);
            message.writeBytes(req);
            ctx.writeAndFlush(message);
        }
    }

    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception{
        String body = (String) msg;
        System.out.println("Now is: " + body + ", counter is: " + ++counter);
        /*ByteBuf buf = (ByteBuf) msg;
        byte[] req = new byte[buf.readableBytes()];
        buf.readBytes(req);
        String body = new String(req, "utf-8");
        System.out.println("Now is: " + body + ", counter is: " + ++counter);*/
    }

    public void exceptionCaugh(ChannelHandlerContext ctx, Throwable cause){
        logger.warning("Unexpected exception from downstream: " + cause.getMessage());
        ctx.close();
    }
}
