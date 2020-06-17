package com.gsk;

import java.util.Arrays;
import java.util.Date;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gsk.pojo.ElasticSearchTestUser;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.document.DocumentField;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.rest.RestStatus;
import org.elasticsearch.search.fetch.subphase.FetchSourceContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.Map;

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


    /**
     * //TODO创建文档
     * @author ShangKun
     * @date 2020/6/17 20:52
     */
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
        // 此处演示FastJson
        String fastJson = JSON.toJSONString(user);
        ElasticSearchTestUser elasticSearchTestUser = JSON.parseObject(fastJson, ElasticSearchTestUser.class);
        indexRequest.source(objectMapper.writeValueAsString(user), XContentType.JSON);


        //  向索引库内添加文档
        IndexResponse indexResponse = client.index(indexRequest, RequestOptions.DEFAULT);

        System.out.println(indexResponse);

    }


    /**
     * //TODO查询文档是否存在
     * @author ShangKun
     * @date 2020/6/17 20:53
     */
    @Test
    public void testExistDocument() throws IOException{
        GetRequest request = new GetRequest("haolina", "1");

        // 不获取 _sources上下文了

        request.fetchSourceContext(new FetchSourceContext(false));

        // 过滤字段
        request.storedFields("name");

        boolean exists = client.exists(request, RequestOptions.DEFAULT);


    }

    /**
     * //TODO查询文档
     * @author ShangKun
     * @date 2020/6/17 20:58
     */
    @Test
    public void testSearchDocument() throws IOException{

        GetRequest request = new GetRequest("haolina", "1");

        GetResponse response = client.get(request, RequestOptions.DEFAULT);
        // 获取各种信息都可以在这里找到
        Map<String, Object> source = response.getSource();
        String sourceAsString = response.getSourceAsString();

    }


    /**
     * //TODO更新文档
     * @author ShangKun
     * @date 2020/6/17 21:07
     */

    @Test
    public void testUpdateDocument() throws IOException{

        UpdateRequest request = new UpdateRequest("haolina", "1");
        request.timeout(TimeValue.timeValueSeconds(1));
        ElasticSearchTestUser user = new ElasticSearchTestUser();
        user.setName("郝丽娜1号");

        UpdateRequest doc = request.doc(objectMapper.writeValueAsString(user), XContentType.JSON);

        UpdateResponse update = client.update(request, RequestOptions.DEFAULT);
        RestStatus status = update.status();

    }
}
