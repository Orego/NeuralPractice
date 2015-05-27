public class Network {

	private InputNeuron a;
	
	private InputNeuron b;

	private InputNeuron bias;
	
	private SigmoidNeuron output;

	public Network() {
		a = new InputNeuron();
		b = new InputNeuron();
		bias = new InputNeuron();
		bias.setActivation(1);
		output = new SigmoidNeuron(new Neuron[] {a, b, bias});
	}

	public double calculateDeltaHidden(double correct) {
		// TODO This is wrong!
		return (output.getActivation() * (1 - output.getActivation()) * (correct - output
				.getActivation()));
	}

	public SigmoidNeuron getOutput() {
		return output;
	}

	/** Sets the activations of the network's input units. */
	public void setInputs(double... inputs) {
		a.setActivation(inputs[0]);
		b.setActivation(inputs[1]);
	}

	/** Calculates and returns the delta value (double) for output neuron */
	public void updateDeltaOutput(double correct) {
		output.updateDelta(correct);
	}

	/** Updates weights based on previously determined delta from output */
	public void updateWeights() {
		output.updateWeights();
	}

	/** Trains the network to be more likely to associate the specified inputs with the specified output. */
	public void train(double correct, double... inputs){
		setInputs(inputs);
		output.updateActivation();
		output.updateDelta(correct);
		updateWeights();
	}
	
	/** Returns the network's output when inputs are fed in. */
	public double test(double... inputs){
		setInputs(inputs);
		output.updateActivation();
		return output.getActivation();
	}

}
