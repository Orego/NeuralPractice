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

}
