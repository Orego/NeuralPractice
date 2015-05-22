/** Sigmoid Neuron */
public class SigmoidNeuron implements Neuron {

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

	/** Returns array of Neurons */
	public Neuron[] getInputs() {
		return inputs;
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
		weights = w;
	}

	public void updateInput(double newAct, int number) {
		inputs[number].setActivation(newAct);
	}

}
