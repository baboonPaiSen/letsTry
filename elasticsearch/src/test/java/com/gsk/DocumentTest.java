package com.gsk;

import java.util.Arrays;
import java.util.Date;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gsk.pojo.ElasticSearchTestUser;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

/**
 * @description: TODO文档测试
 * @date: 2020/6/17 19:39
 * @author: ShangKun
 * @version: 2.0.0
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class DocumentTest {

    @Qualifier("restHighLevelClient")
    @Autowired
    private RestHighLevelClient client;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testCreateDocument() throws IOException{
        // 创建请求
        IndexRequest indexRequest = new IndexRequest("haolina");

        // post /haolina/_doc/1

        indexRequest.id("1");
        indexRequest.timeout(TimeValue.timeValueSeconds(1));

        ElasticSearchTestUser user = new ElasticSearchTestUser();
        user.setName("郝丽娜");
        user.setAge(18);
        user.setBirthday(new Date());
        user.setFavorites(Arrays.asList("学习","玩手机","洗碗"));
        String fastJson = JSON.toJSONString(user);
        indexRequest.source(objectMapper.writeValueAsString(user), XContentType.JSON);


        //  向索引库内添加文档
        IndexResponse indexResponse = client.index(indexRequest, RequestOptions.DEFAULT);

        System.out.println(indexResponse);

    }

}
