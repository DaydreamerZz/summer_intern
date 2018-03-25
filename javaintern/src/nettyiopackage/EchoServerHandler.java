package nettyiopackage;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelHandlerInvoker;
import io.netty.util.concurrent.EventExecutorGroup;

/**
 * @author : Bruce Zhao
 * @email : zhzh402@163.com
 * @date : 2018/3/25 19:09
 * @desc :
 */
public class EchoServerHandler extends ChannelHandlerAdapter {
    int counter = 0;

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        /*String body = (String) msg;
        System.out.println("This is" + ++counter + "times receive client msg: " + body);
        body += "$_";
        ByteBuf echo = Unpooled.copiedBuffer(body.getBytes());
        ctx.writeAndFlush(echo);*/
        System.out.println("Receive client: " + msg);
    }


    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
