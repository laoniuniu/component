package com.ddbschedule.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ddbschedule.mapper.TbUserCopyMapper;
import com.ddbschedule.mapper.TbUserMapper;
import com.ddbschedule.pojo.TbUser;
import com.ddbschedule.pojo.TbUserCopy;
import com.ddbschedule.pojo.TbUserExample;
import com.ddbschedule.pojo.TbUserExample.Criteria;
import com.ddbschedule.service.CopyService;

@Service
public class CopyServiceImpl implements CopyService {

	@Autowired
	private TbUserMapper userMapper;
	
	@Autowired
	private TbUserCopyMapper userCopyMapper;
	@Override
	public TbUser getUser(long id) {
		TbUserExample example = new TbUserExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(id);
		List<TbUser> list = userMapper.selectByExample(example);
		if(list != null && list.size() > 0){
			TbUser user = list.get(0);
			return user;
		}
		return null;
	}
	@Override
	public int insertUser(TbUser tbUser) {
		String str = JsonUtils.objectToJson(tbUser);
		TbUserCopy copyUser = JsonUtils.jsonToPojo(str, TbUserCopy.class);
		return userCopyMapper.insert(copyUser);
	}

}
