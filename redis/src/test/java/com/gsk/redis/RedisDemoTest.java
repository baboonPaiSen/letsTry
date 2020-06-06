package com.gsk.redis;

import com.gsk.pojo.Student;
import com.gsk.util.JsonUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;


@SpringBootTest
@RunWith(SpringRunner.class)
public class RedisDemoTest {

    @Autowired
    private  StringRedisTemplate  template;

    private static final String  PRE = "RedisStringDemo:";
    private static final String  LIST = "RedisLISTDemo:";
    private static final String  SET = "RedisSETDemo:";
    private static final String  ZSET = "RedisZSETDemo:";
    private static final String  HASH = "RedisHASHDemo:";

    @Test
    public   void  string(){
        template.opsForValue().set(PRE,String.valueOf(11));
    }

    @Test
    public  void getString(){
        BoundValueOperations<String, String> operations = template.boundValueOps(PRE);
        /*取法A*/
        String s = operations.get();
        /*这里可以直接做加减操作*/
        operations.increment(-1);
        /*获取过期时间*/
        Long expire = template.getExpire(PRE, TimeUnit.SECONDS);

        /*取法B*/
        String s1 = template.opsForValue().get(PRE);
    }

    @Test
    public  void set(){
        template.opsForSet().add(SET, "1","2","3");

        Set<String> members = template.opsForSet().members(SET);
        /*判断是否存在某个元素*/
        Boolean member = template.opsForSet().isMember(SET, "1");
    }


    @Test
    public  void zSet(){


        template.opsForZSet().add(ZSET,"1",1D);
        template.opsForZSet().add(ZSET,"2",2D);

        Set<String> range = template.opsForZSet().range(ZSET, 0L, -1L);


    }

    @Test
    public  void list(){


        template.opsForList().leftPush(LIST,"JAVA");
        template.opsForList().leftPush(LIST,"PYTHON");
        template.opsForList().leftPush(LIST,"C++");
        template.opsForList().rightPush(LIST,"最后加入");

        List<String> range = template.opsForList().range(LIST, 0, -1);


    }


    @Test
    public  void hashKey(){


        HashOperations<String, String, String> operations = template.opsForHash();

        Student student = new Student();
        student.setStudentName("张三");
        student.setAge(0);

        Student student1 = new Student();
        student1.setStudentName("李四");
        student1.setAge(0);


        operations.put(HASH, "ClassA",JsonUtils.serialize(student));
        operations.put(HASH, "ClassB",JsonUtils.serialize(student1));


        BoundHashOperations<String, Object, Object> operation = template.boundHashOps(HASH);


        Set<Object> keys = operation.keys();

        List<Object> values = operation.values();

        String classA = operation.get("ClassA").toString();

        Student parse = JsonUtils.parse(classA, Student.class);
    }



}