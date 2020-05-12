package cn.qi.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.qi.bean.Yuser;
import cn.qi.util.DB;

public class YuserDaoImpl implements YuserDao {
	private DB  db= null;

	@Override
	public List<Yuser> selectAll() {
		this.db = new DB();
		String sql = "select *from yuser";
		ResultSet rs = db.mySelect(sql);
		List <Yuser> lists = new ArrayList<Yuser>();
		try {
			while(rs.next())
			{
				Yuser u = new Yuser();
				u.setAge(rs.getInt("uage"));
				u.setGender(rs.getString("gender"));
				u.setUid(rs.getInt("uid"));
				u.setUname(rs.getString("uname"));
				lists.add(u);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		db.close();
		return lists;
	}

	@Override
	public Yuser selectOneByUid(int uid) {
		this.db = new DB();
		String sql = "select *from yuser where uid ="+uid;
		ResultSet rs  =db.mySelect(sql);
		Yuser u = null;
		try {
			if(rs.next())
			{
				u = new Yuser();
				u.setAge(rs.getInt("uage "));
				u.setGender(rs.getString("gender"));
				u.setUid(rs.getInt("uid"));
				u.setUname(rs.getString("uname"));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		db.close();
		return u;
	}

	@Override
	public int delectOneByUid(int uid) {
		this.db = new DB();
		String sql = "delete from yuser wher uid "+uid;
		int c = db.myUpdate(sql);
		
		return c;
	}

	@Override
	public int updateOneByUid(Yuser yuser) {
		this.db = new DB();
		int c = 0;
		Yuser u = this.selectOneByUid(yuser.getUid());
		if(u!=null)
		{
			String sql="update yuser set uname='"+yuser.getUname()+"',uage='"+yuser.getAge()+"',gender='"+yuser.getGender()+"' where uid="+yuser.getUid();
			c=db.myUpdate(sql);
		}
		return c;
	}

	@Override
	public int insertOne(Yuser yuser) {
		this.db=new DB();
		Yuser u=this.selectOneByUid(yuser.getUid());
		int c=0;
		if(u==null)
		{
			String sql="insert into yuser values('"+yuser.getUid()+"','"+yuser.getUname()+"','"+yuser.getAge()+"','"+yuser.getGender()+"')";
			c=db.myUpdate(sql);
		}
		
		return c;
	}

}
