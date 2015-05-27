/** Sigmoid Neuron */
public class SigmoidNeuron implements Neuron {

	/** Learning rate used in updating weights. */
	public static final double LEARNING_RATE = 1.0;
	
	/** Returns f(x) where f(x) = 1/(1+(e^-x)) */
	private static double sigmoid(double x) {
		return 1 / (1 + Math.exp(-x));
	}

	/** Output of this neuron. */
	private double activation;

	/** Delta value for backpropagation. */
	private double delta;

	/** Neurons providing input to this neuron. */
	private Neuron[] inputs;

	/** Weights from inputs to this neuron. */
	private double[] weights;

	/** Constructor that initializes the values of inputs and weights */
	public SigmoidNeuron(Neuron[] inputs, double[] weights){
		this.inputs = inputs;
		this.weights = weights;
	}

	/**
	 * Computes and sets activation from inputs & weights using sigmoid function
	 */
	public double computeActivation() {
		double x = 0;
		for (int i = 0; i < inputs.length; i++) {
			x += (weights[i]) * (inputs[i].getActivation());
		}
		return sigmoid(x);
	}

	@Override
	public double getActivation() {
		return activation;
	}

	/** returns double Delta value for this Neuron */
	public double getDelta() {
		return delta;
	}

	/** returns int number of inputs for this Neuron */
	public int getInputSize() {
		return inputs.length;
	}

	/** returns array of weights */
	public double[] getWeights() {
		return weights;
	}

	@Override
	public void setActivation(double act) {
		activation = act;
	}

	/** Sets double delta value */
	public void setDelta(double d) {
		delta = d;
	}

	/** Sets the Neuron array of inputs */
	public void setInputs(Neuron[] i) {
		inputs = i;
	}

	/** Sets the double array of weights */
	public void setWeights(double w[]) {
		// TODO Break this up into two methods, clearWeights and updateWeights
		weights = w;
	}

	public void updateInput(double newAct, int number) {
		inputs[number].setActivation(newAct);
	}
	
	/** Updates the weights into this neuron, assuming delta has already been set. */
	public void updateWeights() {
		for (int i = 0; i < inputs.length; i++) {
			weights[i] += LEARNING_RATE * (inputs[i].getActivation())
					* delta;
		}
	}

}
