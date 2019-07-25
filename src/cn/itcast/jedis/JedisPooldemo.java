package cn.itcast.jedis;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisPooldemo {
    @Test
    public void test001(){
        //0.创建一个配置对象
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(50);
        config.setMaxIdle(10);

        //1.创建连接池对象
        JedisPool jedisPool = new JedisPool(config,"localhost",6379);

        //2.获取连接
        Jedis jedis = jedisPool.getResource();

        //3.使用
        jedis.set("msg", "hh");

        //4.关闭，归还到连接池中
        jedis.close();

    }



}
