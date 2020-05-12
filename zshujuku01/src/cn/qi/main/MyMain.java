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
			System.out.println("��ӭʹ�ñ���Ϣ����ϵͳ");
			System.out.println("�밴��ʾ����");
			System.out.println("a.��ѯȫ�� b.���ݱ�Ž��в�ѯ");
			System.out.println("c.���ݱ��ɾ�� d.���ݱ���޸�");
			System.out.println("e.�����Ϣ ;���ⵥ���ַ��˳�");

			Scanner sc = new Scanner(System.in);
			String msg = sc.next();
			if (msg.length() > 1) {
				System.out.println("������������");
			} else {
				char c = msg.charAt(0);

				switch (c) {
				case 'a':
					List<Yuser> users = yuserdao.selectAll();
					for (Yuser u : users) {
						System.out.println("��ţ�" + u.getUid() + "  ������" + u.getUname() + "  ���䣺" + u.getAge() + "  �Ա�"+ u.getGender());
					}
					break;
				case 'b':
					System.out.println("����������");
					int uid = sc.nextInt();
					Yuser u = yuserdao.selectOneByUid(uid);
					if (u == null) {
						System.out.println("������ı�Ų��Ϸ�");
					} else {
						System.out.println("��ţ�" + u.getUid() + "������" + u.getUname() + "���䣺" + u.getAge() + "�Ա�" + u.getGender());
					}
					break;
				case 'c':
					System.out.println("����������");
					int duid = sc.nextInt();
					int dc = yuserdao.delectOneByUid(duid);
					System.out.println("ɾ����" + dc + "����¼");
					break;
				case 'd':
					Yuser iu = new Yuser();
					System.out.println("�����������Ϣ��");
					System.out.println("uid:");
					iu.setUid(sc.nextInt());
					System.out.println("uname:");
					iu.setUname(sc.next());
					System.out.println("age:");
					iu.setAge(sc.nextInt());
					System.out.println("gender:");
					iu.setGender(sc.next());
					int ic = yuserdao.updateOneByUid(iu);
					System.out.println("�޸���" + ic + "������");
					break;
				case 'e':
					Yuser uu = new Yuser();
					System.out.println("�����������Ϣ��");
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
						System.out.println("�޸���" + uc + "������");
					}
					else
					{
						System.out.println("�����uid�Ѿ����ڣ�������ѡ�����");
					}
					break;
				default:
					System.out.println("�����˳���ϵͳ���ڴ��´������ٴμ��棡");
					System.exit(0);
				}
			}

		}
	}

}
