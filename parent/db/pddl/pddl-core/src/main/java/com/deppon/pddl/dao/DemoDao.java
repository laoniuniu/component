package com.deppon.pddl.dao;

import com.deppon.pddl.client.model.DemoDO;


public interface DemoDao {
    int deleteByPrimaryKey(Long id);

    int insert(DemoDO record);

    int insertSelective(DemoDO record);

    DemoDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DemoDO record);

    int updateByPrimaryKeyWithBLOBs(DemoDO record);

    int updateByPrimaryKey(DemoDO record);
}