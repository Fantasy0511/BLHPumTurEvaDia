package blh.action.datamine.history;

public enum SystemConvert {

	ball("球阀系统"), Exc("发电机及励磁系统"), Gov("调速器系统"), Transfer("主变系统"), Pum("水泵水轮机");
	private String system;

	SystemConvert(String system) {
		this.system = system;
	}

	public String getSystem() {
		return system;
	}

	public static void main(String[] args) {

		System.out.println(SystemConvert.ball.getSystem());
		System.out.println(SystemConvert.valueOf("ball").getSystem());
	}
}
