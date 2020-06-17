package com.gsk;


import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@SpringBootTest
@RunWith(SpringRunner.class)
public class IndexTest {


    @Qualifier("restHighLevelClient")
    @Autowired
    private RestHighLevelClient client;


    /**
     * //TODO創建索引
     * @author ShangKun
     * @date 2020/6/17 18:34
     */
    @Test
    public void testCreateIndex() throws IOException {
        // 新增对象
        CreateIndexRequest createIndexRequest = new CreateIndexRequest("haolina");

        // 执行请求
        CreateIndexResponse createIndexResponse = client.indices().create(createIndexRequest, RequestOptions.DEFAULT);


        System.out.println(createIndexResponse);
    }


    /**
     * //TODO获取是否存在
     * @author ShangKun
     * @date 2020/6/17 19:30
     */
    @Test
    public void getIndex() throws IOException{
        GetIndexRequest request = new GetIndexRequest("haolina");
        boolean exists = client.indices().exists(request, RequestOptions.DEFAULT);

    }

}