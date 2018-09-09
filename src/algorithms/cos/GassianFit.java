package algorithms.cos;
import java.util.ArrayList;

import org.apache.commons.math3.fitting.GaussianCurveFitter;
import org.apache.commons.math3.fitting.WeightedObservedPoints;
import org.apache.commons.math3.stat.descriptive.moment.Mean;

import com.fasterxml.jackson.core.format.InputAccessor.Std;

/**
 * 由一组数据拟合高斯分布
 * @author lh
 * */
public class GassianFit {
	private double[] nums;
	private double mean=0;
	private double std=0;
	public GassianFit(double[] nums){
		this.nums = nums;
		this.fit();
	}
	public GassianFit(ArrayList<Double> nums){
		this.nums = new double[nums.size()];
		for(int i=0;i<nums.size();i++){
			this.nums[i]=nums.get(i);
		}
		this.fit();
	}
	/**
	 * 获得输入数据的均值、标准差
	 * 
	 * */
	private void fit(){
		for(int i=0;i<nums.length;i++){
			mean += nums[i];
		}
		mean = mean/nums.length;
		for(int i=0;i<nums.length;i++){
			std += (nums[i]-mean)*(nums[i]-mean);
		}
		std = std/nums.length;
		std = Math.sqrt(std);
	}
	public double getProb(double x){
		return 1/(Math.sqrt(2*Math.PI)*std)*Math.exp(-Math.pow(x-mean, 2)/2/std/std);
	}
	
    public static void main(String[] args) {
    	double[] nums={2,2,3,1};
    	GassianFit gFit= new GassianFit(nums);
    	System.out.println(gFit.mean);
    	System.out.println(gFit.std);
        System.out.println(gFit.getProb(1.5));
    }
}
