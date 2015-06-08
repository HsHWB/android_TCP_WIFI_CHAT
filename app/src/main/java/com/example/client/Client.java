package com.example.client;

import com.example.utils.Constant;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import android.os.Handler;
import android.os.Message;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by root on 17/05/15.
 */
public class Client {

    //服务器端口
    private static final int SERVICE_PORT = Constant.SERVICE_PORT;
    private static final String SERVICE_HOST = Constant.SERVICE_HOST;
    private BufferedReader br;
    private PrintWriter pw;
    private Socket socket;
    private String getMsg;//get message from server
    private String pullMsg = "";//send to server
    private Thread mThread;

    /**
     * 传入端口以及客户聊天对应的textview
     * @param port
     * @param editText
     */
    public Client(String port, EditText editText){
        //Socket实例化，连接服务器
        try {
            socket = new Socket(Constant.SERVICE_HOST, Constant.SERVICE_PORT);
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
            mThread = new Thread(mRunnable);
            mThread.start();//查看服务器是否推了信息过来
        }catch (IOException e){
            System.out.println("Service ");
        }

    }

    private Runnable mRunnable = new Runnable() {
        @Override
        public void run() {
            while(true){
                try{
                    if ( (getMsg = br.readLine()) != null ){
                        pullMsg += getMsg;
                        System.out.println("Client  pullMsg == " + pullMsg +"    are you ok");
                    }else{
                        break;
                    }
                }catch (IOException e){
                    e.printStackTrace();
                }
            }

            if (pullMsg != null){
                Message msg = new Message();
                msg.what = 0x123;
                mHandler.sendMessage(msg);
            }
        }
    };

    public void msgToService(String msg){
        pw.print(msg);
        pw.flush();//刷新缓冲区马上发送服务端
        if ( !mThread.isAlive() ){//如果在创建客户端对象的时候服务器没有首先推送过来则线程不会终止
            mThread = new Thread(mRunnable);
            mThread.start();
        }
    }

    public int getSERVICE_PORT(){
        return SERVICE_PORT;
    }

    public String getServiceHost(){
        return SERVICE_HOST;
    }

    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg){

            if (msg.what == 0x123){
                mThread = null;
            }

        }
    };

}
