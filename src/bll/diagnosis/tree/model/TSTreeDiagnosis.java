/*package bll.diagnosis.tree.model;

import java.util.ArrayList;
import java.util.List;

import bll.diagnosis.tree.test.dataread;
import util.PathUtil;

public class TSTreeDiagnosis {
	int jzgk;// 机组工况（0停机1开机2...）
	List<Long> T;// 时间
	int dyfkbj; // 导叶开度反馈故障，开关量
	List<Double> dyfk; // 导叶开度反馈值
	List<Double> kdgd;// 机组导叶开度给定值
	List<Double> y;// 机组导叶开度实际值
	List<Double> jlqxc;// 主接力器行程
	List<Double> f;// 机组频率
	int modeset;// 调节模式设定值，开关量
	int modestate;// 调节模式状态值，开关量
	List<Double> pf;// 功率反馈值
	List<Double> wp;// 网频值
	List<Double> unitloadset;// 机组负荷给定值
	List<Double> unitload;// 机组负荷实际值
	int sdzt;// 锁定状态，开关量
	List<Double> pt;// 压油罐油压
	int ptHAlarm;// 压油罐油压高报警，开关量
	int ptLAlarm;// 压油罐油压低报警，开关量

	public TSTreeDiagnosis tstreeanalysis() {

		TSTreeDiagnosis datas = new TSTreeDiagnosis();
		datas.T = new ArrayList<Long>();
		datas.dyfk = new ArrayList<Double>();
		datas.kdgd = new ArrayList<Double>();
		datas.unitloadset = new ArrayList<Double>();
		datas.unitload = new ArrayList<Double>();
		datas.pt = new ArrayList<Double>();
		datas.pf = new ArrayList<Double>();

		for (long i = 0; i < 70; i++) {
			datas.T.add(i);
			datas.dyfk.add((double) 1);
			datas.kdgd.add((double) 0.2);
			datas.unitloadset.add((double) 0.1);
			datas.unitload.add((double) 0.1);
			datas.pt.add(0.5);
			datas.pf.add((double) 0.5);
		}
		datas.dyfkbj = 1;
		datas.jzgk = 1;
		datas.sdzt = 0;
		datas.ptHAlarm = 0;
		datas.ptLAlarm = 1;
		datas.modeset = 0;
		datas.modestate = 1;
		/*
		 * 擦 这个路径问题费我一个钟头 tomcat——webapps——项目名——文件路径
		 * 在Javaweb项目中，文件是发布到服务器的，路径不能写死没否则找不到文件
		 * 想要将数局发布到服务器上data应该在webContent目录下
		 * @ wu
		 *//*
		 String filePath = "bll\\diagnosis\\tree\\model";
//		String filePath = PathUtil.getWebRealBasePath() + "data/tree/";
		System.out.println(filePath);
		datas.f = dataread.readTxtFile(filePath + "频率.txt");
		datas.wp = dataread.readTxtFile(filePath + "频率.txt");
		datas.dyfk = dataread.readTxtFile(filePath + "开度.txt");
		datas.y = dataread.readTxtFile(filePath + "开度.txt");

		return datas;
	}

	public static void main(String[] args) {

		TSTreeDiagnosis datas = new TSTreeDiagnosis().tstreeanalysis();

		for (int i = 0; i < datas.f.size(); i++) {
			System.out.print(datas.T.get(i) + "   ");
			System.out.print(datas.f.get(i) + "   ");
			System.out.print(datas.y.get(i) + "   ");
			System.out.println(datas.jzgk);
		}
		String filePath = PathUtil.getWebRealBasePath() + "/data/assess/";
		System.out.println(filePath);
		System.out.println(datas.T.size());
	}

}*/
