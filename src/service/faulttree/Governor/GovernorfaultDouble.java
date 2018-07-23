package service.faulttree.Governor;
import service.faulttree.FloatTreement;
public class GovernorfaultDouble {
	
	//压油管漏气
	public int Airleak(long time,int No){
		int flag =0;
		if(No==1){
		FloatTreement float345=new FloatTreement();
		double p1=float345.FloatTree(345, time, 800, 800);
		if((1-p1)>0.3){
			flag=1;
		}else {
			flag=0;
		}
		return flag;
		}else if(No==2){
			FloatTreement float564=new FloatTreement();
			double p1=float564.FloatTree(564, time, 800, 800);
			if((1-p1)>0.3){
				flag=1;
			}else {
				flag=0;
			}
			return flag;
		}else if(No==3){
			FloatTreement float783=new FloatTreement();
			double p1=float783.FloatTree(783, time, 800, 800);
			if((1-p1)>0.3){
				flag=1;
			}else {
				flag=0;
			}
			return flag;
		}else if(No==4){
			FloatTreement float1000=new FloatTreement();
			double p1=float1000.FloatTree(1000, time, 800, 800);
			if((1-p1)>0.3){
				flag=1;
			}else {
				flag=0;
			}
			return flag;
		}else {
			flag=0;
			return flag;
		}
			}
				
	
	//耗油速度偏大
	public int OilSpill(long time,int No){
		int flag=0;
		if(No==1){
			FloatTreement float345=new FloatTreement();
			flag=float345.DoubleTree(345, time);
			return flag;
		}else if(No==2){
			FloatTreement float564=new FloatTreement();
			flag=float564.DoubleTree(564, time);
			return flag;
		}else if(No==3){
			FloatTreement float783=new FloatTreement();
			flag=float783.DoubleTree(783, time);
			return flag;
		}else if(No==4){
			FloatTreement float1000=new FloatTreement();
			flag=float1000.DoubleTree(1000, time);
			return flag;
	}else{
    	flag=0;
		return flag;
}
		
	}
	
	//大油量偏低
	public int PreviewLow(long time,int No){
		int flag=0;
		if(No==1){
			FloatTreement float345=new FloatTreement();
			flag=float345.PreviewTree(345, time);
			return flag;
		}else if(No==2){
			FloatTreement float564=new FloatTreement();
			flag=float564.PreviewTree(564, time);
			return flag;
		}else if(No==3){
			FloatTreement float783=new FloatTreement();
			flag=float783.PreviewTree(783, time);
			return flag;
		}else if(No==4){
			FloatTreement float1000=new FloatTreement();
			flag=float1000.PreviewTree(1000, time);
			return flag;
	}else{
    	flag=0;
		return flag;
}
	}
}