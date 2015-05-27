import static org.junit.Assert.*;

import org.junit.Test;

public class SigmoidNeuronTest {
	public SigmoidNeuron neuron;

	@Test
	public void testComputeActivation() {
		double[] weights = { 1, 2 };
		InputNeuron a = new InputNeuron();
		InputNeuron b = new InputNeuron();
		a.setActivation(2);
		b.setActivation(1);
		Neuron[] inputArray = { a, b };
		neuron = new SigmoidNeuron(inputArray, weights);
		neuron.updateActivation();
		assertEquals(0.98201379003, neuron.getActivation(), .0001);
	}

	@Test
	public void testGetDelta() {
		InputNeuron a = new InputNeuron();
		Neuron[] input = { a, a };
		double[] weight = { 2, 3 };
		neuron = new SigmoidNeuron(input, weight);
		neuron.setDelta(1.2);
		assertEquals(1.2, neuron.getDelta(), .001);
	}

}
