package com.spider.business.repostory.mapper;

import com.spider.business.repostory.MyBatisRepository;
import com.spider.common.bean.HaohuoCommodity;

import java.util.List;

@MyBatisRepository
public interface HaohuoCommodityMapper {
    int deleteByPrimaryKey(Long id);

    int insert(HaohuoCommodity record);

    HaohuoCommodity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(HaohuoCommodity record);

    int updateByProductIdSelective(HaohuoCommodity record);

    List<HaohuoCommodity> query(HaohuoCommodity banner);
}