import java.util.Random;

public class Network {
	InputNeuron bias = new InputNeuron();
	InputNeuron a = new InputNeuron();
	InputNeuron b = new InputNeuron();
	SigmoidNeuron output;
	double weightMin = -1;
	double weightMax = 1;

	public Network() {
		bias.setActivation(1); // Set bias activation to 1
		Neuron[] inputs = { a, b, bias };
		double[] weightArray = new double[inputs.length];
		for (int i = 0; i < inputs.length; i++) {
			weightArray[i] = rand(); // Initialize Weights
		}
		output = new SigmoidNeuron(inputs, weightArray);
	}

	/** Returns a random double within specified range */
	public double rand() {
		Random rand = new Random();
		return weightMin + (weightMax - weightMin) * rand.nextDouble();
	}

	/** Calculates and returns the delta value (double) for output neuron */
	public void updateDeltaOutput(double correct) {
		output.updateDelta(correct);
	}

	public double calculateDeltaHidden(double correct) {
		// TODO This is wrong!
		return (output.getActivation() * (1 - output.getActivation()) * (correct - output
				.getActivation()));
	}

	/** Updates weights based on previously determined delta from output */
	public void updateWeights() {
		output.updateWeights();
	}

	public void setInputs(double one, double two) {
		a.setActivation(one);
		b.setActivation(two);
	}

}
