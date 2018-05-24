package test;

import java.util.Date;

import util.TimeUtils;

public class Test {
	public static void main(String[] args) {
		String paramter = "4号机组.球阀.主油回路.压力(float1001)";
		String deviceType = paramter.substring(0, paramter.indexOf("."));
		String deviceState = paramter.substring(paramter.indexOf(".") + 1,
				paramter.length());
		System.out.println(String.valueOf(TimeUtils.DatetoLong(new Date())));
	}
}
