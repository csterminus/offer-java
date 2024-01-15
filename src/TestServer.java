//import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
//import org.apache.mina.core.service.IoHandlerAdapter;
//import org.apache.mina.core.session.IoSession;
//import org.apache.mina.filter.codec.ProtocolCodecFilter;
//import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
//import org.apache.mina.transport.socket.SocketAcceptor;
//import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
//
//import java.io.IOException;
//import java.net.InetSocketAddress;
//
//
//public class TestServer {
//    public static void main(String[] args) {
//        //NIO模式
//        SocketAcceptor acceptor = new NioSocketAcceptor();
//        //创建一个过滤器
//        DefaultIoFilterChainBuilder chainBuilder = acceptor.getFilterChain();
//        //设定一个过滤器，读取数据
//        chainBuilder.addLast("myChain",new ProtocolCodecFilter(new TextLineCodecFactory()));
//        //设置服务器的消息处理器
//        acceptor.setHandler(new MinaServerHandle());
//        int port = 8080;
//        try{
//            acceptor.bind(new InetSocketAddress(port));
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//        System.out.println("MINA服务器已经开启，端口号:"+port);
//    }
//}
//
//class MinaServerHandle extends IoHandlerAdapter{
//    @Override
//    public void sessionOpened(IoSession session) throws Exception {
//        super.sessionOpened(session);
//        System.out.println(session.getRemoteAddress() + "已连接");
//    }
//
//    @Override
//    public void sessionClosed(IoSession session) throws Exception {
//        System.out.println("会话结束");
//    }
//
//    @Override
//    public void messageReceived(IoSession session, Object message) throws Exception {
//        super.messageReceived(session, message);
//        System.out.println(message);
//        session.write("hello");
//    }
//}
