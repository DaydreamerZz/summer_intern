package netty.tookit;

import io.netty.buffer.*;
import io.netty.channel.nio.AbstractNioByteChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.nio.Buffer;
import java.nio.ByteBuffer;

import static io.netty.buffer.ByteBufProcessor.FIND_CRLF;
import static java.lang.System.out;

/**
 * author : Bruce Zhao
 * email  : zhzh402@163.com
 * date   : 2018/4/8 12:57
 * desc   :
 */
public class ByteBufAndHelper {
    public static void main(String[] args){

        ByteBuffer buffer = ByteBuffer.allocate(10);
        buffer.put("Hello".getBytes());
        out.println(buffer.toString());
        buffer.flip();
        byte[] array = new byte[buffer.remaining()];
        out.println(buffer.toString());
        buffer.get(array);
        out.println(buffer.toString());
        out.println(new String(array));

        //buffer.clear();
        buffer.put("Wo".getBytes());
//        out.println(buffer.toString());


//        ByteBuf byteBuf = UnpooledHeapByteBuf
//        ByteBuf byteBuf = UnpooledDirectByteBuf


        ByteBufAllocator allocator = new PooledByteBufAllocator();

        ByteBufProcessor findCrlf = FIND_CRLF;


//        NioSocketChannel

        return;
    }
}
