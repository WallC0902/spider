package com.spider.core.webmagic.pipeline;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.spider.core.webmagic.ResultItems;
import com.spider.core.webmagic.Task;
import com.spider.core.webmagic.utils.FilePersistentBase;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

/**
 * Created by wangchangpeng on 2018/11/14.
 */
public class HaohuoApiPipeline  extends FilePersistentBase implements Pipeline {

    private Logger LOGGER = LoggerFactory.getLogger(getClass());

    private String filePath;

    HaohuoApiPipeline() {
    }

    public HaohuoApiPipeline(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void process(ResultItems resultItems, Task task) {
        JSONObject jsonObject = resultItems.get("data");
        try {
            FileUtils.writeByteArrayToFile(new File(filePath + File.separator+System.currentTimeMillis()+".json"),
                    jsonObject.toJSONString().getBytes());



            System.out.println("商品名称:->" + jsonObject.get("name"));
            System.out.println("销量:->" + jsonObject.get("sell_num"));
            System.out.println("店铺名:->" + jsonObject.get("shop_name"));
            System.out.println("最高价:->" + jsonObject.get("sku_max_price"));
            System.out.println("打折价:->" + jsonObject.get("discount_price"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
