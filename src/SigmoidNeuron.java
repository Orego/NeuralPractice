/** Sigmoid Neuron */
public class SigmoidNeuron implements Neuron {

	// array of doubles for weights
	// array of neurons for input
	// activation

	private double activation;
	private double[] weights;
	private Neuron[] inputs;
	private double delta; 
	private int inputSize;

	public double getActivation() {
		return activation;
	}

	public void setActivation(double act) {
		activation = act;
	}

	/** Computes and sets activation from inputs & weights using sigmoid function */
	public double computeActivation() {
		double x = 0;
		for (int i=0; i<inputSize; i++){
			x += (weights[i]) * (inputs[i].getActivation());
		}
		return sigmoid(x);
	}

	/**Sets the double array of weights*/
	public void setWeights(double w[]) {
		weights = w;
	}

	/**returns array of weights*/
	public double[] getWeights() {
		return weights;
	}

	/**Sets the Neuron array of inputs*/
	public void setInputs(Neuron[] i) {
		inputs = i;
	}
	
	public void updateInput(double newAct, int number){
		inputs[number].setActivation(newAct);
	}
	
	/**Returns array of Neurons*/
	public Neuron[] getInputs() {
		return inputs;
	}

	/**Returns f(x) where f(x) = 1/(1+(e^-x))*/
	private double sigmoid(double x) {
		return 1/(1+ (Math.exp(-x)));
	}
	
	/**returns double Delta value for this Neuron*/
	public double getDelta(){
		return delta;
	}
	
	/**Sets double delta value*/
	public void setDelta(double d){
		delta = d;
	}
	
	/**returns int number of inputs for this Neuron*/
	public int getInputSize(){
		return inputSize;
	}
	
	/**Sets int number of inputs*/
	public void setInputSize(int s){
		inputSize = s;
	}	
	

}
