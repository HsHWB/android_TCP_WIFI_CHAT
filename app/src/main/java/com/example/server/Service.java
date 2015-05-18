package com.example.server;

import com.example.utils.Constant;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 此class含有main方法不适合在android上运行，要javac运行然后android运行Client端
 * Created by root on 17/05/15.
 */
public class Service {
//    /**
//     * 服务器端口
//     */
//    private static final int SERVER_PORT = Constant.SERVICE_PORT;
//    /**
//     * 存储所有客户端Socket连接对象
//     */
//    private static List<Socket> mClientList = new ArrayList<Socket>();
//    /**
//     * 线程池
//     */
//    private ExecutorService mExecutorService;
//    /**
//     * ServerSocket对象
//     */
//    private ServerSocket mServerSocket;
//
//    public Service(){
//        try{
//            //设置服务器端口
//            mServerSocket = new ServerSocket(SERVER_PORT);
//            //创建一个线程池
//            mExecutorService = Executors.newCachedThreadPool();
//            //用来临时保存客户端连接的Socket对象
//            Socket client = null;
//            while (true){
//                //接收客户连接并添加到list中
//                client = mServerSocket.accept();
//                mClientList.add(client);
//                //开启一个客户端线程
//                mExecutorService.execute(new ThreadServer(client));
//            }
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//    }
//
//    //每个客户端单独开启一个线程
//    static class ThreadServer implements Runnable {
//
//        private Socket mSocket;
//        private BufferedReader br;
//        private PrintWriter pw;
//        private String msg;
//
//        public ThreadServer (Socket socket) throws IOException{
//            this.mSocket = socket;
//            br = new BufferedReader(new InputStreamReader(mSocket.getInputStream()));
//            msg = "user: "+this.mSocket.getInetAddress()+" come total:"+mClientList.size();
//            sendMessage();
//        }
//
//        @Override
//        public void run() {
//            try{
//                while ((msg = br.readLine()) != null){
//                    if (msg.trim().equals("bye")){
//                        //当一个客户端退出时
//                        mClientList.remove(mSocket);
//                        br.close();
//                        pw.close();
//                        msg = "user : "+this.mSocket.getInetAddress()+" exit total : "+mClientList.size();
//                        mSocket.close();
//                        sendMessage();
//                        break;
//                    }
//                    else{
//                        msg = mSocket.getInetAddress()+":"+msg;
//                        sendMessage();
//                    }
//                }
//            }catch (IOException e){
//                e.printStackTrace();
//            }
//        }
//
//        //发送消息给所有客户端
//        private  void sendMessage() throws IOException {
//
//            for (Socket client : mClientList){
//                pw = new PrintWriter(client.getOutputStream(), true);
//                pw.println("Server   :"+msg);
//            }
//
//        }
//
//    }
//
//    /**
//     * 开启服务器
//     * @param args
//     */
//    public static void main(String[] args){
//        new Service();
//    }

}
