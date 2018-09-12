package blh.action.predict;

public enum itemConvert {
//枚举类型转换
	B14B("308"), LQLL("331"),SW("1076"), YWEI("309"),U18V("306"),
	LG0C("1097"), B144("328"), B145("329"), B146("330");	
	
	private String system;

		itemConvert(String system) {
			this.system = system;
		}

		public String getitem() {
			return system;
		}

	}

