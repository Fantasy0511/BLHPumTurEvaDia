package service;

import java.util.List;

import dao.members.Member;
import dao.members.MemberDao;
import tool.easyui.Table;

/**
 * member的服务类，生成适合table的json格式
 * 
 * @author wuyue
 *
 */
public class MemberService {
	private Table memberTable;

	public Table getMemberTable() {
		String[] headers = { "id", "name", "age", "part" };
		memberTable = new Table(headers);
		MemberDao mDao = new MemberDao();
		List<Member> mList = mDao.findAllMember();
		memberTable.withBeanRow(mList);
		return memberTable;

	}
}
