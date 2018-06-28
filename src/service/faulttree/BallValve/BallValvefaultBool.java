package service.faulttree.BallValve;
import service.faulttree.BoolTree;
public class BallValvefaultBool {
	
	//压力油罐油压低
	public double getPressuretankpressurelow(long time,int No){
		if(No==1){
			BoolTree bool222=new BoolTree();
			double p1=bool222.BooleanTree(222,time);
				return p1;
		}else if(No==2){
			BoolTree bool545=new BoolTree();
			double p1=bool545.BooleanTree(545,time);
			return p1;
		}else if(No==3){
			BoolTree bool868=new BoolTree();
			double p1=bool868.BooleanTree(868,time);
			return p1;
		}else if(No==4){
			BoolTree bool1187=new BoolTree();
			double p1=bool1187.BooleanTree(1187,time);
			return p1;
		}else{
			double p1=0;
		return p1;
		}
	}
	
	//压力油罐油位高
	public double gettankoilhigh(long time,int No){
		if(No==1){
			BoolTree bool225=new BoolTree();
			double p1=bool225.BooleanTree(225,time);
				return p1;
		}else if(No==2){
			BoolTree bool548=new BoolTree();
			double p1=bool548.BooleanTree(548,time);
			return p1;
		}else if(No==3){
			BoolTree bool871=new BoolTree();
			double p1=bool871.BooleanTree(871,time);
			return p1;
		}else if(No==4){
			BoolTree bool1190=new BoolTree();
			double p1=bool1190.BooleanTree(1190,time);
			return p1;
		}else{
			double p1=0;
		return p1;
		}
	}
	
	//压力油罐油位低
	public double gettankoillow(long time,int No){
		if(No==1){
			BoolTree bool224=new BoolTree();
			double p1=bool224.BooleanTree(224,time);
				return p1;
		}else if(No==2){
			BoolTree bool547=new BoolTree();
			double p1=bool547.BooleanTree(547,time);
			return p1;
		}else if(No==3){
			BoolTree bool870=new BoolTree();
			double p1=bool870.BooleanTree(870,time);
			return p1;
		}else if(No==4){
			BoolTree bool1189=new BoolTree();
			double p1=bool1189.BooleanTree(1189,time);
			return p1;
		}else{
			double p1=0;
		return p1;
		}
	}
	
}
