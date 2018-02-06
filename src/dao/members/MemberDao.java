package dao.members;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.jdbc.Work;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import util.HibernateFactory;

/**
 * @author wuyue
 *
 */
// * hibernate Dao
// * hibernate 小测试
// * 看书hibernate《精通 Hibernate：Java 对象持久化技术详解》
public class MemberDao extends HibernateFactory {
	// 根据class生成数据库中对应的表
	public void exportDB() {
		SchemaExport export = new SchemaExport(
				HibernateFactory.getConfiguration());
		export.create(true, true);
	}

	// 保存一个member
	public void saveMember() {
		Session session = getSessionFactory().openSession();
		Member member = new Member(1, "武越越", 25, "master");
		Member member2 = new Member(2, "刘涵", 25, "bll");
		Member member3 = new Member(3, "万俊逸", 25, "front");
		Member member4 = new Member(4, "单亚辉", 25, "report");
		session.save(member);
		session.save(member2);
		session.save(member3);
		session.save(member4);
		session.beginTransaction().commit();
	}

	// 删除一个member
	public void deleteMember(int id) {
		Session session = getSessionFactory().openSession();
		Member member = (Member) session.get(Member.class, id);
		session.delete(member);
	}

	// 获取一个member
	public Member getMember(int id) {
		Session session = getSessionFactory().openSession();
		Member member = (Member) session.get(Member.class, 1);
		return member;
	}

	// hibernate 的检索方式
	public Member findMemberByName(String string) {
		Session session = getSessionFactory().openSession();
		Query query = session.createQuery("from Member where name=:name");
		return (Member) query.setString("name", "武越越").list().get(0);
	}

	// hibernate 的检索方式
	public List<Member> findAllMember() {
		Session session = getSessionFactory().openSession();
		Query query = session.createQuery("from Member");
		return query.list();
	}

	// 测试是否连接成功
	public void testDoWork() {
		Session session = getSessionFactory().openSession();
		session.doWork(new Work() {

			@Override
			public void execute(Connection connection) throws SQLException {
				System.out.println(connection);
				// 调用存储过程
			}
		});
	}

	public static void main(String[] args) {
		MemberDao mDao = new MemberDao();
		mDao.exportDB();
		mDao.saveMember();
		// Member member = mDao.getMember(1);
		// System.out.println(mDao.findMemberByName("武越越").toString());
		System.out.println(mDao.findAllMember().toString());
	}
}
