package algorithms.fpgrowth;

import java.sql.SQLException;
import java.util.ArrayList;





import java.util.HashMap;

import org.apache.batik.ext.awt.image.DiscreteTransfer;

import dao.impl.ReadData;
import util.DataInfo;
import util.DataUtils;
import util.TypeNums;


/**
 * 数据离散化供数据挖掘算法使用
 * @author lh
 * */
public class DataDiscrete {
	
	/**
	 * 离散化bool表里读出的数据
	 * */
	private HashMap<String, DataInfo> maps;
	public DataDiscrete() throws ClassNotFoundException, SQLException{
		ReadData readDB = new ReadData();
		this.maps = readDB.queInfo();
	}
	
	/**
	 * 离散化开关量，返回是否出现报警
	 * */
	public int boolDiscrete(DataUtils data){
		//bool表里读出的数据只有01,若data.value中含有1则离散化为1
		int rs = 0;
		for(Double value:data.getValue()) {
			if (value==1.0){
				rs = 1;
				return rs;
			}
		}
		return rs;
	}
	/**
	 * 离散化开关量，返回报警出现次数
	 * */
	public int boolCounter(DataUtils data){
		//bool表里读出的数据只有01,若data.value中含有1则离散化为1
		int rs = 0;
		for(Double value:data.getValue()) {
			if (value==1.0){
				rs = rs+1;
			}
		}
		return rs;
	}
	
	
	/**
	 * 离散模拟量
	 * 越限分析
	 * */
	public int LimiteAanlysis(DataUtils data){
		//首先获得data的数据源信息
		String typeid = data.getType()+data.getId();
		DataInfo datainfo = this.maps.get(typeid);
		int HH = datainfo.getHHLimite();//高高报警
		int LL = datainfo.getLLLimite();//低低报警
		int H = datainfo.getHLimite();//高报警
		int L = datainfo.getLLimite();//低报警
		int Limiteflag = 0;
		for(Double value:data.getValue()){
			//判断是否越限,[hh,h,l,ll]按位置1,1100：高高报，0100：高报，0010：低报，0001：低低报，0000：正常
			if(value>H){
//				Limiteflag = Limiteflag|4;
				Limiteflag = 1;
				break;//下面判断高高报和低低报的暂时不采纳，只用高低报应该够用
//				if(value>HH){
//					Limiteflag = Limiteflag|8;
//					break;
//				}
				
			}
			if(value<L){
//				Limiteflag = Limiteflag|2;
				Limiteflag = -1;
				break;
//				if(value<LL){
//					Limiteflag = Limiteflag|1;
//					break;
//				}
			}			
		}
		return Limiteflag;
		
	}
	/**
	 * 返回模拟量 越限次数
	 * */
	public int LimiteCounter(DataUtils data){
		int rs = 0;
		//首先获得data的数据源信息
		String typeid = data.getType()+data.getId();
		DataInfo datainfo = this.maps.get(typeid);
		int H = datainfo.getHLimite();//高报警
		int L = datainfo.getLLimite();//低报警
		for(Double value:data.getValue()){
			if(value>H){
				rs = rs+1;
			}
			if(value<L){
				rs = rs+1;
			}			
		}
		return rs;
		
	}
	/**
	 * 离散模拟量
	 * 趋势分析
	 * */
	public int trendAnalysis(DataUtils data){
		ArrayList<Long> time = data.getTime();
		ArrayList<Double> value = data.getValue();
		if (time.size()>0){
			double xi, yi, xy=0, x=0, y=0, xx=0;
			long x0 = data.getTime().get(0);
			for(int i=0;i<value.size();i++){
				xi = (double)(value.get(i)-x0);
				yi = time.get(i);
				xy = xy+xi*yi;
				x = x+xi;
				y = y+yi;
				xx = xx+xi*xi;
			}
			//最小二乘求斜率
			double k = (value.size()*xy-x*y)/(value.size()*xx-x*x);
			if (k>0){
				return 1;
			}else if(k<0){
				return -1;
			}else{
				return 0;
			}
		}
		return 0;
			
	}

	
	
	
	/**
	 * 还原离散后的代码对应的测点,得到type+id+越限/变高/...
	 * */
	public String restoreID(int code){
		int boolnums=TypeNums.BOOL.getNums(), doublenums=TypeNums.DOUBLE.getNums(),floatnums=TypeNums.FLOAT.getNums();
		
		int index = Math.abs(code);
		String type = "";
		int id = 0;
		String status = "";
		if(index>boolnums*10){//乘以10的是在bool之后，大于25680
			id = index/10;
			if(code<0){
				status = "升高";
			}else{
				status = "降低";
			}
			if(id-boolnums<=doublenums){
				type = "double";
			}else{
				type = "float";
			}
		}else{//25680以内的则可能是上面的任何一种
			id = index;
			if(id<=boolnums){
				type = "bool";
				status = "报警";
			}else if(id>boolnums && id<=boolnums+doublenums){
				type = "double";
			}else{
				type = "float";
			}
			if(code<0){
				status = "过低";
			}else{
				status = "过高";
			}
		}
		if(id>boolnums && id<=boolnums+doublenums){
			id = id-boolnums;
		}else if(id>boolnums+doublenums){
			id = id-boolnums-doublenums;
		}
		;
		return type+id+"  "+this.maps.get(type+id).getPosition()+"."+this.maps.get(type+id).getDescription()+"_"+status;
	}

}
