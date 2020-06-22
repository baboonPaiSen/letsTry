package com.gsk.config;

/**
 * @description: ElasticSearch配置
 * @date: 2020/6/17 17:45
 * @author: ShangKun
 * @version: 2.0.0
 */


import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ElasticSearchClientConfig {

    @Bean
    public  RestHighLevelClient restHighLevelClient(){

        return new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost("127.0.0.1",9200,"http")
                )
        );


    }


}
