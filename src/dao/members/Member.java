package dao.members;

/**
 * 系统项目成员 测试hibernate
 * bean格式
 * @author wuyue
 *
 */
public class Member {
	private int id;
	private String name;
	private int age;
	private String part;

	public Member() {
		super();
	}

	public Member(String name, int age, String part) {
		super();
		this.name = name;
		this.age = age;
		this.part = part;
	}

	public Member(int id, String name, int age, String part) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.part = part;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", name=" + name + ", age=" + age
				+ ", part=" + part + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPart() {
		return part;
	}

	public void setPart(String part) {
		this.part = part;
	}

}
