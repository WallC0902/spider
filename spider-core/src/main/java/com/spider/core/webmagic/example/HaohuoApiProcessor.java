package com.spider.core.webmagic.example;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.spider.core.webmagic.Page;
import com.spider.core.webmagic.Site;
import com.spider.core.webmagic.Spider;
import com.spider.core.webmagic.pipeline.HaohuoApiPipeline;
import com.spider.core.webmagic.processor.PageProcessor;

/**
 * Created by wangchangpeng on 2018/11/14.
 */
public class HaohuoApiProcessor implements PageProcessor {

    private static final String HAOHUO_API = "https://haohuo.snssdk.com/product/ajaxstaticitem?id=";

    @Override
    public void process(Page page) {
        JSONObject jsonObject = JSON.parseObject(page.getRawText());
        page.putField("data",jsonObject.get("data"));
    }


    @Override
    public Site getSite() {
        return  Site.me().setRetryTimes(3).setTimeOut(1000).setSleepTime(1000);
    }

    /**
     * 主方法
     */
    public static void main(String[] args) {
        String busId = "3307877227840040744";

        Spider.create(new HaohuoApiProcessor())
                .addUrl(HAOHUO_API + busId)
                .addPipeline(new HaohuoApiPipeline("D:\\logs\\toutiao\\webmagic-crawler-file"))
                .run();
    }
}
