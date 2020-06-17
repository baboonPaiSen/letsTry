package com.gsk.linstener;


import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @description: TODO
 * @date: 2020/6/5 11:32
 * @author: ShangKun
 * @version: 2.0.0
 */
@Component
@Slf4j
public class Listener {

    @Autowired
    private StringRedisTemplate redisTemplate;



    @RabbitListener(queues = "helloWorld")
    public  void  helloWorld(String msg){

        log.error("收到MQ消息::{}",msg);

    }

    /*work模型*/
    @RabbitListener(queues = "work")
    public  void  work(String msg){

        log.error("收到MQ消息::{}",msg);

    }

    @RabbitListener(queues = "work")
    public  void  work2(String msg){

        log.error("收到MQ消息::{}",msg);

    }

    /*广播*/
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue,
            exchange = @Exchange(value = "fanout" ,type = ExchangeTypes.FANOUT)
    ))
    public  void  fanout(String msg){

        log.error("收到MQ消息::{}",msg);

    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue,
            exchange = @Exchange(value = "fanout" ,type = ExchangeTypes.FANOUT)
    ))
    public  void  fanout2(String msg){

        log.error("收到MQ消息::{}",msg);

    }



    /*Direct*/
    //value = @Queue 表示临时队列
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue,
            exchange = @Exchange(value = "directs" ,type = ExchangeTypes.DIRECT),
            key = {"error"}
    ))
    public  void  direct(String msg){

        log.error("收到error消息::{}",msg);

    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue,
            exchange = @Exchange(value = "directs" ,type = ExchangeTypes.DIRECT),
            key = {"info"}
    ))
    public  void  direct2(String msg){

        log.error("收到info消息::{}",msg);

    }







    /*Topic #表示匹配多个，*表示匹配不多不少正好一个  */
    @RabbitListener(bindings =@QueueBinding(
            /*设置是否持久化， 设置是否自动删除队列*/
            value =@Queue(value ="spring.test.queue",durable = "true"),
            exchange = @Exchange(value = "spring.test.exchange",type = ExchangeTypes.TOPIC),
            key = {"a.#"}

    ))
    public  void topic(String msg){
        log.error("收到topic消息::{}",msg);
    }

    /*第二个TOPIC监听*/
    @RabbitListener(bindings =@QueueBinding(
            value =@Queue(value ="spring.test.queue2",durable = "true"),
            exchange = @Exchange(value = "spring.test.exchange",type = ExchangeTypes.TOPIC),
            key = {"b.*"}

    ))
    public  void topic2(String msg) throws  Exception{

        String s = redisTemplate.opsForValue().get("spring.test.queue2");
        if (StringUtils.isBlank(s)){
            redisTemplate.opsForValue().set("spring.test.queue2","1");
        }else {
            redisTemplate.opsForValue().set("spring.test.queue2",String.valueOf(Integer.valueOf(s)+1),60L, TimeUnit.MINUTES);
        }

        Thread.sleep(1000L);
        throw new RuntimeException("测试异常");


    }


}
