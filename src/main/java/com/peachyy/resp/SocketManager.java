package com.peachyy.resp;

import java.io.IOException;
import java.net.Socket;

/**
 * @author Xs.Tao
 */
public class SocketManager {
    private Socket socket;

    private String host;
    private int port;

    public void setHost(String host) {
        this.host = host;
    }

    public void setPort(int port) {
        this.port = port;
    }
    public SocketManager(){
        try {
            socket=new Socket(host,port);
        } catch (IOException e) {
            System.err.println(String.format("连接redis失败 %s:$s",host,port)+e.getMessage());
        }
    }
    public SocketManager(String host, int port){
        try {
            this.host=host;
            this.port=port;
            socket=new Socket(host,port);
        } catch (IOException e) {
            System.err.println(String.format("连接redis失败 %s:$s",host,port)+e.getMessage());
        }
    }

    public String sendPacket(String packet){
        System.out.println("发送报文->"+packet);
        try {
            socket.getOutputStream().write(packet.getBytes());
        } catch (IOException e) {
            System.err.println("发送报文请求失败 "+e.getMessage());
        }
        byte[] bytes = new byte[1024];
        try {
            socket.getInputStream().read(bytes);
        } catch (IOException e) {
            System.err.println("读取返回报文失败 "+e.getMessage());
        }
        String respR=new String(bytes);
        System.out.println("返回报文 <-  "+respR);
        return respR;
    }
}
