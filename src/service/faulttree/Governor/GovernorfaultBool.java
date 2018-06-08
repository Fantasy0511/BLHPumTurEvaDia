package service.faulttree.Governor;
import service.faulttree.BoolTree;

public class GovernorfaultBool {
	
	
	//剪断销故障
	public double getShearpinfault(long time,int No){
		if(No==1){
			BoolTree bool130=new BoolTree();
			double p1=bool130.BooleanTree(130,time);	
			return 1-p1;
		}else if(No==2){
			BoolTree bool450=new BoolTree();
			double p1=bool450.BooleanTree(450,time);
			return 1-p1;
		}else if(No==3){
			BoolTree bool775=new BoolTree();
			double p1=bool775.BooleanTree(775,time);
			return 1-p1;
		}else if(No==4){
			BoolTree bool1083=new BoolTree();
			double p1=bool1083.BooleanTree(1083,time);
			return 1-p1;
		}else{
			double p1=0;
		return p1;
		}
}
	
	//集油箱油位偏高
	public double gettankoilhigh(long time,int No){
		if(No==1){
			BoolTree bool215=new BoolTree();
			double p1=bool215.BooleanTree(215,time);
				return p1;
		}else if(No==2){
			BoolTree bool536=new BoolTree();
			double p1=bool536.BooleanTree(536,time);
			return p1;
		}else if(No==3){
			BoolTree bool861=new BoolTree();
			double p1=bool861.BooleanTree(861,time);
			return p1;
		}else if(No==4){
			BoolTree bool1180=new BoolTree();
			double p1=bool1180.BooleanTree(1180,time);
			return p1;
		}else{
			double p1=0;
		return p1;
		}
}
	
	//集油箱油位偏低
		public double gettankoillow(long time,int No){
			if(No==1){
				BoolTree bool217=new BoolTree();
				double p1=bool217.BooleanTree(217,time);
					return p1;
			}else if(No==2){
				BoolTree bool538=new BoolTree();
				double p1=bool538.BooleanTree(538,time);
				return p1;
			}else if(No==3){
				BoolTree bool863=new BoolTree();
				double p1=bool863.BooleanTree(863,time);
				return p1;
			}else if(No==4){
				BoolTree bool1182=new BoolTree();
				double p1=bool1182.BooleanTree(1182,time);
				return p1;
			}else{
				double p1=0;
			return p1;
			}
	}
	
		//压力油罐油位偏高
				public double getPressuretankoilhigh(long time,int No){
					if(No==1){
						BoolTree bool195=new BoolTree();
						double p1=bool195.BooleanTree(195,time);
							return p1;
					}else if(No==2){
						BoolTree bool514=new BoolTree();
						double p1=bool514.BooleanTree(514,time);
						return p1;
					}else if(No==3){
						BoolTree bool840=new BoolTree();
						double p1=bool840.BooleanTree(840,time);
						return p1;
					}else if(No==4){
						BoolTree bool1160=new BoolTree();
						double p1=bool1160.BooleanTree(1160,time);
						return p1;
					}else{
						double p1=0;
					return p1;
					}
			}
				
				//压力油罐油位偏低
				public double getPressuretankoillow(long time,int No){
					if(No==1){
						BoolTree bool196=new BoolTree();
						double p1=bool196.BooleanTree(196,time);
							return p1;
					}else if(No==2){
						BoolTree  bool515=new BoolTree ();
						double p1=bool515.BooleanTree(515,time);
						return p1;
					}else if(No==3){
						BoolTree bool841=new BoolTree();
						double p1=bool841.BooleanTree(841,time);
						return p1;
					}else if(No==4){
						BoolTree bool1161=new BoolTree();
						double p1=bool1161.BooleanTree(1161,time);
						return p1;
					}else{
						double p1=0;
					return p1;
					}
			}
				
				//调速器补气系统气压罐压力高
				public double getFilltankpressurehigh(long time,int No){
					if(No==1){
						BoolTree bool207=new BoolTree();
						double p1=bool207.BooleanTree(207,time);
							return p1;
					}else if(No==2){
						BoolTree bool526=new BoolTree();
						double p1=bool526.BooleanTree(526,time);
						return p1;
					}else if(No==3){
						BoolTree bool852=new BoolTree();
						double p1=bool852.BooleanTree(852,time);
						return p1;
					}else if(No==4){
						BoolTree bool1172=new BoolTree();
						double p1=bool1172.BooleanTree(1172,time);
						return p1;
					}else{
						double p1=0;
					return p1;
					}
			}
				
				//调速器补气系统气压罐压力低
				public double getFilltankpressurelow(long time,int No){
					if(No==1){
						BoolTree bool208=new BoolTree();
						double p1=bool208.BooleanTree(208,time);
							return p1;
					}else if(No==2){
						BoolTree bool527=new BoolTree();
						double p1=bool527.BooleanTree(527,time);
						return p1;
					}else if(No==3){
						BoolTree bool853=new BoolTree();
						double p1=bool853.BooleanTree(853,time);
						return p1;
					}else if(No==4){
						BoolTree bool1173=new BoolTree();
						double p1=bool1173.BooleanTree(1173,time);
						return p1;
					}else{
						double p1=0;
					return p1;
					}
			}


}