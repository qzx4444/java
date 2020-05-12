package cn.qi.main;

import java.util.List;
import java.util.Scanner;

import cn.qi.bean.Yuser;
import cn.qi.dao.YuserDao;
import cn.qi.dao.YuserDaoImpl;

public class MyMain {
	public static void main(String[] args) {
		YuserDao yuserdao = new YuserDaoImpl();
		while (true) {
			System.out.println("欢迎使用本信息管理系统");
			System.out.println("请按提示操作");
			System.out.println("a.查询全部 b.根据编号进行查询");
			System.out.println("c.根据编号删除 d.根据编号修改");
			System.out.println("e.添加信息 ;任意单个字符退出");

			Scanner sc = new Scanner(System.in);
			String msg = sc.next();
			if (msg.length() > 1) {
				System.out.println("请您正常输入");
			} else {
				char c = msg.charAt(0);

				switch (c) {
				case 'a':
					List<Yuser> users = yuserdao.selectAll();
					for (Yuser u : users) {
						System.out.println("编号：" + u.getUid() + "  姓名：" + u.getUname() + "  年龄：" + u.getAge() + "  性别"+ u.getGender());
					}
					break;
				case 'b':
					System.out.println("请您输入编号");
					int uid = sc.nextInt();
					Yuser u = yuserdao.selectOneByUid(uid);
					if (u == null) {
						System.out.println("您输入的编号不合法");
					} else {
						System.out.println("编号：" + u.getUid() + "姓名：" + u.getUname() + "年龄：" + u.getAge() + "性别" + u.getGender());
					}
					break;
				case 'c':
					System.out.println("请您输入编号");
					int duid = sc.nextInt();
					int dc = yuserdao.delectOneByUid(duid);
					System.out.println("删除了" + dc + "条记录");
					break;
				case 'd':
					Yuser iu = new Yuser();
					System.out.println("请输入各项信息：");
					System.out.println("uid:");
					iu.setUid(sc.nextInt());
					System.out.println("uname:");
					iu.setUname(sc.next());
					System.out.println("age:");
					iu.setAge(sc.nextInt());
					System.out.println("gender:");
					iu.setGender(sc.next());
					int ic = yuserdao.updateOneByUid(iu);
					System.out.println("修改了" + ic + "条数据");
					break;
				case 'e':
					Yuser uu = new Yuser();
					System.out.println("请输入各项信息：");
					System.out.println("uid:");
					uu.setUid(sc.nextInt());

					Yuser chaxunUser = yuserdao.selectOneByUid(uu.getUid());
					if (chaxunUser == null) {
						System.out.println("uname:");
						uu.setUname(sc.next());
						System.out.println("age:");
						uu.setAge(sc.nextInt());
						System.out.println("gender:");
						uu.setGender(sc.next());
						int uc = yuserdao.insertOne(uu);
						System.out.println("修改了" + uc + "条数据");
					}
					else
					{
						System.out.println("输入的uid已经存在，请重新选择操作");
					}
					break;
				default:
					System.out.println("您已退出本系统，期待下次与您再次见面！");
					System.exit(0);
				}
			}

		}
	}

}
