package blh.action.predict;

public enum itemConvert {
//枚举类型转换
	B14B("油路压力"), LQLL("冷却水流量"),SW("水温"), YWEI("油位"),U18V("磨损"),
	LG0C("出口油温"), B144("水导X轴振摆速率"), B145("水导Y轴振摆速率"), B146("水导Z轴振摆速率");	
	
	private String system;

		itemConvert(String system) {
			this.system = system;
		}

		public String getitem() {
			return system;
		}

	}

