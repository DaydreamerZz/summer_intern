package netty.nettyio;

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

    private final ByteBuf firstMessage;


    public NettyTimeClientHandler() {
        byte[] req = "QUERY TIME ORDER".getBytes();
        firstMessage = Unpooled.buffer(req.length);
        firstMessage.writeBytes(req);
    }

    public void channelActive(ChannelHandlerContext ctx){
        ctx.writeAndFlush(firstMessage);
    }

    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception{
        ByteBuf buf = (ByteBuf) msg;
        byte[] req = new byte[buf.readableBytes()];
        buf.readBytes(req);
        String body = new String(req, "utf-8");
        System.out.println("Now is: " + body);
    }

    public void exceptionCaugh(ChannelHandlerContext ctx, Throwable cause){
        logger.warning("Unexpected exception from downstream: " + cause.getMessage());
        ctx.close();
    }
}
