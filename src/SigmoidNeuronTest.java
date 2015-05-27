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
		neuron.setActivation(neuron.computeActivation());
		assertEquals(0.98201379003, neuron.getActivation(), .0001);
	}

	@Test
	public void testGetActivation() {
		InputNeuron a = new InputNeuron();
		Neuron[] input = { a, a };
		double[] weight = { 2, 3 };
		neuron = new SigmoidNeuron(input, weight);
		neuron.setActivation(5.0);
		assertEquals(5.0, neuron.getActivation(), .001);
		neuron.setActivation(-1.1);
		assertEquals(-1.1, neuron.getActivation(), .001);
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

	@Test
	public void testGetInputs() {
		InputNeuron a = new InputNeuron();
		InputNeuron b = new InputNeuron();
		a.setActivation(3);
		b.setActivation(4);
		Neuron[] inputArray = { a, b };
		double[] weight = { 5, 4 };
		neuron = new SigmoidNeuron(inputArray, weight);
		Neuron[] testInputArray = neuron.getInputs();
		for (int i = 0; i < neuron.getInputSize(); i++) {
			assertEquals(inputArray[i].getActivation(),
					testInputArray[i].getActivation(), .001);
		}
		InputNeuron c = new InputNeuron();
		InputNeuron d = new InputNeuron();
		c.setActivation(5);
		d.setActivation(6);
		Neuron[] inputArray2 = { a, b, c, d };
		double[] weight2 = { 5, 4, 6, 3 };
		neuron = new SigmoidNeuron(inputArray2, weight2);
		Neuron[] testInputArray2 = neuron.getInputs();
		for (int i = 0; i < neuron.getInputSize(); i++) {
			assertNotEquals(inputArray2[i].getActivation(), 0, .001);
			assertEquals(inputArray2[i].getActivation(),
					testInputArray2[i].getActivation(), .001);
		}
	}

	@Test
	public void testGetWeights() {
		// TODO Initialize weights and inputs in Neuron constructor
		InputNeuron a = new InputNeuron();
		InputNeuron b = new InputNeuron();
		Neuron[] inputArray = { a, b };
		double[] test = { 1, 2 };
		neuron = new SigmoidNeuron(inputArray, test);
		double[] testTwo = neuron.getWeights();
		for (int i = 0; i < neuron.getInputSize(); i++) {
			assertEquals(test[i], testTwo[i], .001);
			assertNotEquals(test[i], 5, .001);
		}
	}

}
