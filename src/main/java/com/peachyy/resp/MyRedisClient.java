package com.peachyy.resp;

/**
 * @author Xs.Tao
 */
public class MyRedisClient {

    private SocketManager socketManager;
    public static final String CRCT="\r\n";

    public MyRedisClient(SocketManager socketManager){
        this.socketManager=socketManager;
    }

    public String get(String key){
        StringBuilder builder = new StringBuilder();
        builder.append("*2")
                .append(CRCT)
                .append("$")
                .append("GET".length())
                .append(CRCT)
                .append("GET")
                .append(CRCT)
                .append("$")
                .append(key.getBytes().length)
                .append(CRCT)
                .append(key)
                .append(CRCT);
        String r=socketManager.sendPacket(builder.toString());
        return r;
    }
    public String set(String key,String value){
        StringBuilder builder = new StringBuilder();
        builder.append("*3")
                .append(CRCT)
                .append("$")
                .append("SET".length())
                .append(CRCT)
                .append("SET")
                .append(CRCT)
                .append("$")
                .append(key.getBytes().length)
                .append(CRCT)
                .append(key)
                .append(CRCT)
                .append("$")
                .append(value.getBytes().length)
                .append(CRCT)
                .append(value)
                .append(CRCT);
        String r=socketManager.sendPacket(builder.toString());
        return r;
    }

    public String del(String key){
        StringBuilder builder = new StringBuilder();
        builder.append("*2")
                .append(CRCT)
                .append("$")
                .append("DEL".length())
                .append(CRCT)
                .append("DEL")
                .append(CRCT)
                .append("$")
                .append(key.getBytes().length)
                .append(CRCT)
                .append(key)
                .append(CRCT);
        String r=socketManager.sendPacket(builder.toString());
        return r;
    }

    public String exists(String key){
        StringBuilder builder = new StringBuilder();
        builder.append("*2")
                .append(CRCT)
                .append("$")
                .append("EXISTS".length())
                .append(CRCT)
                .append("EXISTS")
                .append(CRCT)
                .append("$")
                .append(key.getBytes().length)
                .append(CRCT)
                .append(key)
                .append(CRCT);
        String r=socketManager.sendPacket(builder.toString());
        return r;
    }
}
