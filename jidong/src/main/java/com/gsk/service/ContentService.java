package com.gsk.service;

import com.gsk.pojo.Content;
import com.gsk.util.HtmlParseUtil;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.TimeValue;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @description: TODO
 * @date: 2020/6/22 20:59
 * @author: ShangKun
 * @version: 2.0.0
 */
public class ContentService {

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    public Boolean parseContent(String keywords) throws Exception{
        List<Content> parse = HtmlParseUtil.parse(keywords);
        BulkRequest bulkRequest = new BulkRequest();
        bulkRequest.timeout(TimeValue.timeValueMinutes(2));
        return true;
    }
}
