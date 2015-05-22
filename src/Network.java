import java.util.Random;

public class Network {
	InputNeuron bias = new InputNeuron();
	InputNeuron a = new InputNeuron();
	InputNeuron b = new InputNeuron();
	SigmoidNeuron output = new SigmoidNeuron();
	double learningRate = 1;
	double weightMin = -1;
	double weightMax = 1;


	public Network(){
		output.setInputSize(3);
		bias.setActivation(1);								//Set bias activation to 1
		double[] weightArray = new double [output.getInputSize()];
		for(int i = 0; i < 3; i++){
			weightArray[i] = rand();						//Initialize Weights
		}
		output.setWeights(weightArray);
		Neuron[] inputs= {a, b, bias};
		output.setInputs(inputs);
	}

	/**Returns a random double within specified range*/
	public double rand(){
		Random rand = new Random();
		return  weightMin + (weightMax - weightMin) * rand.nextDouble();
	}
	
	/**Calculates and returns the delta value (double) for output neuron*/
	public double calculateDeltaOutput(double correct){
//		System.out.println(correct + " " + (output.getActivation() * (1 - output.getActivation()) * (correct - output.getActivation())));
		return (output.getActivation() * (1 - output.getActivation()) * (correct - output.getActivation()));
	}
	
	public double calculateDeltaHidden(double correct){

		return (output.getActivation() * (1 - output.getActivation()) * (correct - output.getActivation()));
	}
	
	/**Updates weights based on previously determined delta from output*/
	public void updateWeights(){
		double[] temp = output.getWeights(); 
		Neuron[] tempNeuron = output.getInputs();
		for(int i = 0; i < output.getInputSize(); i++){
			temp[i] += learningRate * (tempNeuron[i].getActivation()) * output.getDelta();
			System.out.println("  weight " + tempNeuron[i].getActivation() + " " + temp[i]);
		}
		output.setWeights(temp);
	}
	
	
	
}