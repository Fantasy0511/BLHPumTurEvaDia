package blh.action.predict;

public enum itemConvert {
//枚举类型转换
	B14B("527"), LQLL("331"),SW("1076"), YWEI("309"),U18V("525"),
	LG0C("1097"), B144("777"), B145("778"), B146("779");	
	
	private String system;

		itemConvert(String system) {
			this.system = system;
		}

		public String getitem() {
			return system;
		}

	}

