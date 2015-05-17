package com.example.server;

import com.example.utils.Constant;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

/**
 * Created by root on 17/05/15.
 */
public class service {
    //服务器端口
    private static int SERVICE_PORT;
    private BufferedReader br;
    private PrintWriter pw;
    private Socket socket;

    public service(String port){
        //Socket实例化，连接服务器
        try {
            socket = new Socket(Constant.SERVICE_HOST, Constant.SERVICE_PORT);
        }catch (IOException e){
            System.out.println("Service ");
        }

    }

}
