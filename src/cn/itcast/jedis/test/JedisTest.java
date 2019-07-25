package cn.itcast.jedis.test;

import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.Map;
import java.util.Set;

/**
 * 快速使用
 */
public class JedisTest {

    @Test
    public void test1(){
        //1.获取连接
        Jedis jedis = new Jedis("localhost",6379);//跟空参效果一样

        //2.操作
        jedis.set("username", "zhangsan");
        //3.关闭连接
        jedis.close();

    }


    @Test
    public void test2(){
        Jedis jedis = new Jedis("localhost",6379);//跟空参效果一样
        jedis.set("username", "zhangsan");
        String username = jedis.get("username");
        System.out.println(username);


        jedis.close();

    }

    @Test
    public void test3(){
        Jedis jedis = new Jedis("localhost",6379);//跟空参效果一样
        jedis.hset("user", "name", "Andy");
        jedis.hset("user", "age", "20");
        jedis.hset("user", "gender", "male");

        //获取hash
        String gender = jedis.hget("user", "gender");
        System.out.println(gender);

        Map<String, String> user = jedis.hgetAll("user");
        System.out.println(user);
//        使用keyset遍历集合  拿出来每个键
        Set<String> strings = user.keySet();
        for (String key : strings) {
            String value  = user.get(key);
            System.out.println(key+"::"+value);
        }


        jedis.close();

    }
}
