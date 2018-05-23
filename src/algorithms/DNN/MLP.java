package algorithms.DNN;

import org.joone.engine.FullSynapse;
import org.joone.engine.LinearLayer;
import org.joone.engine.Monitor;
import org.joone.engine.NeuralNetEvent;
import org.joone.engine.NeuralNetListener;
import org.joone.engine.SigmoidLayer;
import org.joone.engine.SoftmaxLayer;
import org.joone.engine.learning.TeachingSynapse;
import org.joone.io.MemoryInputSynapse;
import org.joone.io.MemoryOutputSynapse;
import org.joone.net.NeuralNet;



/**
 * MLP，实现多分类任务
 * @author lh
 * */
public class MLP implements NeuralNetListener  
{  
    private NeuralNet nnet = null;  
    private MemoryInputSynapse inputSynapse, desiredOutputSynapse;  
    LinearLayer input;  
    SigmoidLayer hidden;
    SoftmaxLayer output;
    boolean singleThreadMode = true;  
    String inputColumnSelector="1";
    String outputColumnSelector="1";
  


  
    /** 
     * Method declaration 
     */  
    public void train(double[][] inputArray,double[][] desiredOutputArray,int itrs,double lr,double mom)  
    {  
  
        // set the inputs  
        inputSynapse.setInputArray(inputArray);  
        inputSynapse.setAdvancedColumnSelector(inputColumnSelector);  
        // set the desired outputs  
        desiredOutputSynapse.setInputArray(desiredOutputArray);  
        desiredOutputSynapse.setAdvancedColumnSelector(outputColumnSelector);  
  
        // get the monitor object to train or feed forward  
        Monitor monitor = nnet.getMonitor();  
  
        // set the monitor parameters  
        monitor.setLearningRate(lr);  
        monitor.setMomentum(mom);  
        monitor.setTrainingPatterns(inputArray.length);  
        monitor.setTotCicles(itrs);  
        monitor.setLearning(true);  
  
        long initms = System.currentTimeMillis();  
        // Run the network in single-thread, synchronized mode  
        nnet.getMonitor().setSingleThreadMode(singleThreadMode);  
        nnet.go(true);  
        System.out.println(" Total time=  "  
                + (System.currentTimeMillis() - initms) + "  ms ");  
    }  
  
    public double[][] interrogate(double[][] inputArray)  
    {  
  
    	double[][] output = new double[inputArray.length][];
        // set the inputs  
        inputSynapse.setInputArray(inputArray);  
        inputSynapse.setAdvancedColumnSelector(inputColumnSelector);  
        Monitor monitor = nnet.getMonitor();  
        monitor.setTrainingPatterns(inputArray.length);  
        monitor.setTotCicles(1);  
        monitor.setLearning(false);  
        MemoryOutputSynapse memOut = new MemoryOutputSynapse();  
        // set the output synapse to write the output of the net  
  
        if (nnet != null)  
        {  
            nnet.addOutputSynapse(memOut);  
            System.out.println(nnet.check());  
            nnet.getMonitor().setSingleThreadMode(singleThreadMode);  
            nnet.go();  
    
            for (int i = 0; i < inputArray.length; i++)  
            {  
            	output[i] = memOut.getNextPattern();  
            }  
            System.out.println(" Interrogating Finished ");  
        }  
        return output;
    }  
  
    /** 
     * Method declaration 
     */  
    protected void initNeuralNet(int[] layers)  
    {  
    	inputColumnSelector = inputColumnSelector+"-"+Integer.toString(layers[0]);
    	outputColumnSelector = outputColumnSelector+"-"+Integer.toString(layers[2]);
        // First create the three layers  
        input = new LinearLayer();  
        hidden = new SigmoidLayer();  
        output = new SoftmaxLayer();  
  
        // set the dimensions of the layers  
        input.setRows(layers[0]);  
        hidden.setRows(layers[1]);  
        output.setRows(layers[2]);  
  
        input.setLayerName(" L.input ");  
        hidden.setLayerName(" L.hidden ");  
        output.setLayerName(" L.output ");  
  
        // Now create the two Synapses  
        FullSynapse synapse_IH = new FullSynapse(); /* input -> hidden conn. */  
        FullSynapse synapse_HO = new FullSynapse(); /* hidden -> output conn. */  
  
        // Connect the input layer whit the hidden layer  
        input.addOutputSynapse(synapse_IH);  
        hidden.addInputSynapse(synapse_IH);  
  
        // Connect the hidden layer whit the output layer  
        hidden.addOutputSynapse(synapse_HO);  
        output.addInputSynapse(synapse_HO);  
  
        // the input to the neural net  
        inputSynapse = new MemoryInputSynapse();  
  
        input.addInputSynapse(inputSynapse);  
  
        // The Trainer and its desired output  
        desiredOutputSynapse = new MemoryInputSynapse();  
  
        TeachingSynapse trainer = new TeachingSynapse();  
  
        trainer.setDesired(desiredOutputSynapse);  
  
        // Now we add this structure to a NeuralNet object  
        nnet = new NeuralNet();  
  
        nnet.addLayer(input, NeuralNet.INPUT_LAYER);  
        nnet.addLayer(hidden, NeuralNet.HIDDEN_LAYER);  
        nnet.addLayer(output, NeuralNet.OUTPUT_LAYER);  
        nnet.setTeacher(trainer);  
        output.addOutputSynapse(trainer);  
        nnet.addNeuralNetListener(this);  
    }  
  
    public void cicleTerminated(NeuralNetEvent e)  
    {  
    }  
  
    public void errorChanged(NeuralNetEvent e)  
    {  
        Monitor mon = (Monitor) e.getSource();  
        if (mon.getCurrentCicle() % 100 == 0)  
            System.out.println(" Epoch:  "  
                    + (mon.getTotCicles() - mon.getCurrentCicle()) + "  RMSE: "  
                    + mon.getGlobalError());  
    }  
  
    public void netStarted(NeuralNetEvent e)  
    {  
        Monitor mon = (Monitor) e.getSource();  
        System.out.print(" Network started for  ");  
        if (mon.isLearning())  
            System.out.println(" training. ");  
        else  
            System.out.println(" interrogation. ");  
    }  
  
    public void netStopped(NeuralNetEvent e)  
    {  
        Monitor mon = (Monitor) e.getSource();  
        System.out.println(" Network stopped. Last RMSE= "  
                + mon.getGlobalError());  
    }  
  
    public void netStoppedError(NeuralNetEvent e, String error)  
    {  
        System.out.println(" Network stopped due the following error:  "  
                + error);  
    }  
  
}  
