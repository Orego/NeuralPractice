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
	public void testUpdateDelta() {
		InputNeuron a = new InputNeuron();
		Neuron[] input = { a, a };
		double[] weight = { 2, 3 };
		neuron = new SigmoidNeuron(input, weight);
		neuron.setActivation(0.1);
		neuron.updateDelta(1);
		assertEquals(0.081, neuron.getDelta(), .0001);
	}

}
