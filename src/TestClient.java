//import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
//import org.apache.mina.core.future.ConnectFuture;
//import org.apache.mina.core.service.IoHandlerAdapter;
//import org.apache.mina.core.session.IoSession;
//import org.apache.mina.filter.codec.ProtocolCodecFilter;
//import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
//import org.apache.mina.transport.socket.nio.NioSocketConnector;
//
//import java.net.InetSocketAddress;
//
//public class TestClient {
//    public static void main(String[] args) {
//        NioSocketConnector connector = new NioSocketConnector();
//        DefaultIoFilterChainBuilder chainBuilder = connector.getFilterChain();
//        chainBuilder.addLast("myChina", new ProtocolCodecFilter(new TextLineCodecFactory()));
//        connector.setHandler(new MinaClientHandle());
//        connector.setConnectTimeoutCheckInterval(3000);
//
//        //连接服务器
//        ConnectFuture connectFuture = connector.connect(new InetSocketAddress("localhost",8080));
//        connectFuture.awaitUninterruptibly();
//        String msg = "client";
//        connectFuture.getSession().write(msg);
//        //等待服务端关闭连接
//        connectFuture.getSession().getCloseFuture().awaitUninterruptibly();
//        connector.dispose();
//    }
//}
//
//class MinaClientHandle extends IoHandlerAdapter{
//    @Override
//    public void sessionOpened(IoSession session) throws Exception {
//        super.sessionOpened(session);
//        System.out.println("已连接");
//    }
//
//    @Override
//    public void sessionClosed(IoSession session) throws Exception {
//        super.sessionClosed(session);
//        System.out.println("已关闭");
//    }
//
//    @Override
//    public void messageReceived(IoSession session, Object message) throws Exception {
//        super.messageReceived(session, message);
//        System.out.println("服务器返回消息"+message);
//    }
//}
