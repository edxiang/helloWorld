package redis;


import redis.clients.jedis.Jedis;

/**
 * Created by edxiao.zeng on 2017/6/21.
 */
public class RedisTest {
    public static void main(String[] args){
        Jedis jedis = new Jedis("localhost");
        System.out.println("Server is running: "+jedis.ping());
    }
}
