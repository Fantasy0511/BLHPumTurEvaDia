package bll.diagnosis.tree.model;


public class FaultTreeResult {
	public boolean[] fault=new boolean[18];
	public String[] shape=new String[18];
	public FaultTreeResult() {
		// TODO Auto-generated constructor stub
		for (int i = 0; i < 18; i++) {
			fault[i]=false;
			
		}
//		fault[3]=true;
//		fault[5]=true;
//		fault[17]=true;
	}
}
