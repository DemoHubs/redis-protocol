package com.peachyy.resp.test;

import com.peachyy.resp.MyRedisClient;
import com.peachyy.resp.SocketManager;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * String 相关测试
 * @author Xs.Tao
 */
public class StringTest {


    private MyRedisClient client=null;

    private String host="127.0.0.1";
    private int port=6379;
    @Before
    public void setUp(){
        SocketManager manager=new SocketManager(host,port);
        client=new MyRedisClient(manager);
    }

    /**
     * set test peachyy
     */
    @Test
    public void StringSeTest(){
        String str=client.set("test","peachyy");
        Assert.assertNotNull(str);
    }

    /**
     * get test
     */
    @Test
    public void StringGetTest(){
        String str=client.get("test");
        Assert.assertNotNull(str);
    }

    /**
     * del test
     */
    @Test
    public void StringDelTest(){
        String str=client.del("test");
        Assert.assertNotNull(str);
    }

    /**
     * exists test
     */
    @Test
    public void StringExistsTest(){
        String str=client.exists("test");
        Assert.assertNotNull(str);
    }
}
