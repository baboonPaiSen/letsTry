package com.gsk.send;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;




@SpringBootTest
@RunWith(SpringRunner.class)
public class SendTest {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Test
    public  void  helloWorld(){

        String msg = "這是一条测试消息";

        //指定routingKey
        amqpTemplate.convertAndSend("helloWorld",msg);
    }


    /*能者多劳，公平消费*/
    @Test
    public  void  work(){

        String msg = "這是一条测试消息";
        for (int i = 0; i < 10; i++) {
            amqpTemplate.convertAndSend("work",msg+i);
        }

    }



    /*广播，将消息交给所有绑定到交换机的队列*/
    @Test
    public  void  fanout(){

        String msg = "這是一条广播消息";
        for (int i = 0; i < 10; i++) {
            System.out.println(msg+i);
            amqpTemplate.convertAndSend("fanout","",msg+i);
        }

    }

    /*定向，把消息交给符合指定routing key 的队列式*/
    @Test
    public  void  direct(){

        String msg = "這是一条广播消息";


        amqpTemplate.convertAndSend("directs","info",msg);
        amqpTemplate.convertAndSend("directs","error",msg);


    }

    /*Topic：通配符，把消息交给符合routing pattern（路由模式） 的队列*/
    @Test
    public  void  topic(){

        String msg = "這是一条测试消息";

        //指定routingKey
        amqpTemplate.convertAndSend("spring.test.exchange","b.1",msg);
//        amqpTemplate.convertAndSend("spring.test.exchange","b.qqea.qqea","b.qqea.qqea");
    }



}