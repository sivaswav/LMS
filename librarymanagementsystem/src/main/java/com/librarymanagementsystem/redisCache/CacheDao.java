package com.librarymanagementsystem.redisCache;

import redis.clients.jedis.Jedis;

public class CacheDao {
   private static Jedis jd;
    static{
        try{
        jd=new Jedis("localhost", 6379);
        System.out.println(jd.ping());}
        catch(Exception e){
            System.err.println(e.getMessage());
            System.exit(-1);
        }
    }
    public static Jedis getJedisConn(){
        return jd;
    }
}