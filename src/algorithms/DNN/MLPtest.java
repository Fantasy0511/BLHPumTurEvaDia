package algorithms.DNN;


/**
 * 多分类任务测试
 * @author lh
 * */
public class MLPtest {
    public static void main(String args[])  
    {  
        //input  
        double[][] inputArray = new double[][]  
        {  
        { 0.0, 0.0 },  
        { 0.0, 1.0 },  
        { 1.0, 0.0 },  
        { 1.0, 1.0 } };  
      
        // desired output  
        double[][] desiredOutputArray = new double[][]  
        {  
        { 0.0,1.0},  
        { 0.0,1.0 },  
        { 1.0,0.0 },  
        { 1.0,0.0} };  
        MLP mlp = new MLP();  
        int[] layers = new int[]{2,4,2};
        mlp.initNeuralNet(layers);  
        int itrs=5000;
        double lr=0.8;
        double mom=0.3;
        mlp.train(inputArray,desiredOutputArray,itrs,lr,mom); 
        
        double[][] testArray = new double[][]  
	    {  
	    { 0.0, 0.0 },  
	    { 0.0, 1.0 },  
	    { 1.0, 0.0 },  
	    { 1.0, 1.0 } }; 
        double[][] pred = mlp.interrogate(testArray); 
    }
}
