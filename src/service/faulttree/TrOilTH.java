package service.faulttree;
import service.faulttree.BoolTree;
public class TrOilTH {

//变压器油温高

	public double getTrOilTH(long time) {

		BoolTree bool214 = new BoolTree();
		double U1 = bool214.BooleanTree(214, time);
		return U1;
	}
}