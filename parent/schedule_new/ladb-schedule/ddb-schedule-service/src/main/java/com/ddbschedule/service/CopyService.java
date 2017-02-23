package com.ddbschedule.service;

import java.util.List;

import com.ddbschedule.pojo.TbUser;

public interface CopyService {
	TbUser getUser(long id);
	int insertUser(TbUser tbUser);
}
