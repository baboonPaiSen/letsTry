package com.gsk.util;

import com.gsk.pojo.Content;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * @description: TODO
 * @date: 2020/6/22 20:07
 * @author: ShangKun
 * @version: 2.0.0
 */
public  class HtmlParseUtil {

    public static List<Content> parse(String keyword) throws IOException {
        String url  = "https://search.jd.com/Search?keyword="+keyword+"&enc=utf-8";
        // 解析网页
        Document parse = Jsoup.parse(new URL(url), 30000);
        // 所有在JS中可以用的方法这里都可以用
        Element goodsList = parse.getElementById("J_goodsList");
        String html = goodsList.html();

        // 获取所有的LI标签
        Elements element = goodsList.getElementsByTag("li");
        List<Content> contents = new ArrayList<>();
        for (Element li : element) {
            String image = li.getElementsByTag("img").eq(0).attr("src");
            String price = li.getElementsByClass("p-price").eq(0).text();
            String name = li.getElementsByClass("p-name").eq(0).text();
            String shop = li.getElementsByClass("p-shop").eq(0).text();
            Content content = new Content();
            content.setImage(image);
            content.setName(name);
            content.setPrice(price);
            content.setShop(shop);
            System.out.println(image);
            System.out.println(price);
            System.out.println(name);
            System.out.println(shop);
            System.out.println("______________________________________________");
            contents.add(content);
        }
        return  contents;
    }
}
