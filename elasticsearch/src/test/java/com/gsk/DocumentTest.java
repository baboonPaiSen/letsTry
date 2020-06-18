package com.gsk;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gsk.pojo.ElasticSearchTestUser;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.document.DocumentField;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.rest.RestStatus;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
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



    /*POST /test1/type1/1
        {
        "name":"郝丽娜",
        "age": 18
        }*/
    /**
     * //TODO创建文档
     * @author ShangKun
     * @date 2020/6/17 20:52
     */
    @Test
    public void testCreateDocument() throws IOException{
        // 创建请求
        IndexRequest indexRequest = new IndexRequest("haolina");



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
     * //TODO批量加入
     * @author ShangKun
     * @date 2020/6/18 19:48
     */

    @Test
    public void testBulkInsertDocument() throws IOException{
        BulkRequest bulkRequest = new BulkRequest();
        bulkRequest.timeout(TimeValue.timeValueSeconds(60));

        ArrayList<Object> objects = new ArrayList<>();
        for (int i = 0; i < objects.size(); i++) {
            //  id 不设置就是默认
            bulkRequest.add(
                    new IndexRequest("bulk").id(""+(i+1))
                            .source(objectMapper.writeValueAsString(objects.get(i)),XContentType.JSON));
        }

        BulkResponse response = client.bulk(bulkRequest, RequestOptions.DEFAULT);

        // 查询是否失败 False  代表成功
        boolean b = response.hasFailures();
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






    /*      Get  geshangkun/user/1      */
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
     * //TODO复杂查询
     * @author ShangKun
     * @date 2020/6/18 20:10
     * //Todo  question :  why -> query : name  in chinese  can not find  correct result
     */

    @Test
    public void testComplexSearchDocument() throws IOException{

        SearchRequest searchRequest = new SearchRequest("haolina");


        // 匹配条件
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder()
                .query(QueryBuilders.termQuery("name", "haolina"));
        searchSourceBuilder.timeout(TimeValue.timeValueSeconds(60));

        searchRequest.source(searchSourceBuilder);
//        new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
//        new SearchSourceBuilder().query(QueryBuilders.boolQuery());



        //  分页  query.from();
        //   query.size()
        SearchResponse response = client.search(searchRequest, RequestOptions.DEFAULT);

        SearchHits hits = response.getHits();
        for (SearchHit documentFields : hits) {
            System.out.println(documentFields.getSourceAsMap());
        }
        System.out.println(objectMapper.writeValueAsString(hits));
    }


    /**
     * //TODO更新文档
     * @author ShangKun
     * @date 2020/6/17 21:07
     */
    /*POST /test1/type1/1/_update
    {
        "doc":{
        "name":"变种郝丽娜"
       }
        }*/

    @Test
    public void testUpdateDocument() throws IOException{

        UpdateRequest request = new UpdateRequest("haolina", "1");

        //   timeout数据量越大，这里要设置的越大，超过了这个时间还没执行完就不执行了
        request.timeout(TimeValue.timeValueSeconds(1));
        ElasticSearchTestUser user = new ElasticSearchTestUser();
        user.setName("郝丽娜1号");
        // 同上述DOC
        UpdateRequest doc = request.doc(objectMapper.writeValueAsString(user), XContentType.JSON);

        UpdateResponse update = client.update(request, RequestOptions.DEFAULT);

        //查询更新状态
        RestStatus status = update.status();

    }

    /*    Delete  /test1/type1/1   */
    /**
     * //TODO删除文档
     * @author ShangKun

     * @return void
     * @date 2020/6/18 19:42
     */
    @Test
    public void testDeleteDocument() throws IOException{
        DeleteRequest request = new DeleteRequest("haolina", "1");
        DeleteResponse response = client.delete(request, RequestOptions.DEFAULT);
        RestStatus status = response.status();

    }


}
