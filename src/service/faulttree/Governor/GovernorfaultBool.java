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
				
				
				//油泵不能正常开启
				public double OilPFailure(long time,int No){
					if(No==1){
						BoolTree bool205=new BoolTree();
        				double p1=bool205.BooleanTree(205,time);
        				BoolTree bool202=new BoolTree();
        				double p2=bool202.BooleanTree(202,time);
        				p1=p1+p2;
        				if(p1>1){
        					p1=0.99;
        				}
        				return p1;
					}else if(No==2){
						BoolTree bool524=new BoolTree();
        				double p1=bool524.BooleanTree(524,time);
        				BoolTree bool521=new BoolTree();
        				double p2=bool521.BooleanTree(521,time);
        				p1=p1+p2;
        				if(p1>1){
        					p1=0.99;
        				}
        				return p1;
					}else if(No==3){
						BoolTree bool850=new BoolTree();
        				double p1=bool850.BooleanTree(524,time);
        				BoolTree bool847=new BoolTree();
        				double p2=bool847.BooleanTree(847,time);
        				p1=p1+p2;
        				if(p1>1){
        					p1=0.99;
        				}
        				return p1;
					}else if(No==4){
						BoolTree bool1170=new BoolTree();
        				double p1=bool1170.BooleanTree(1170,time);
        				BoolTree bool1167=new BoolTree();
        				double p2=bool1167.BooleanTree(1167,time);
        				p1=p1+p2;
        				if(p1>1){
        					p1=0.99;
        				}
        				return p1;
					}else{
						double p1=0;
						return p1;
					}
				}
				
				//油泵单位时间启动频繁
				public double  PumpEfficiency(long time,int No){
					if(No==1){
						BoolTree bool200=new BoolTree();
        				double p1=bool200.BooleanTree(200,time);
        				BoolTree bool203=new BoolTree();
        				double p2=bool203.BooleanTree(203,time);
        				p1=p1+p2;
        				return p1;
					}else if(No==2){
						BoolTree bool519=new BoolTree();
        				double p1=bool519.BooleanTree(519,time);
        				BoolTree bool522=new BoolTree();
        				double p2=bool522.BooleanTree(522,time);
        				p1=p1+p2;
        				return p1;
					}else if(No==3){
						BoolTree bool845=new BoolTree();
        				double p1=bool845.BooleanTree(545,time);
        				BoolTree bool848=new BoolTree();
        				double p2=bool848.BooleanTree(848,time);
        				p1=p1+p2;
        				return p1;
					}else if(No==4){
						BoolTree bool1165=new BoolTree();
        				double p1=bool1165.BooleanTree(1165,time);
        				BoolTree bool1168=new BoolTree();
        				double p2=bool1168.BooleanTree(1168,time);
        				p1=p1+p2;
        				return p1;
					}else{
						double p1=0;
						return p1;
					}
				}

}