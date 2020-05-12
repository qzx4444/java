package cn.qi.dao;

import java.util.List;

import cn.qi.bean.Yuser;

public interface YuserDao {
	List<Yuser> selectAll();
	Yuser selectOneByUid(int uid);
	int delectOneByUid(int uid);
	int updateOneByUid(Yuser yuser);
	int insertOne(Yuser yuser);
	

}
