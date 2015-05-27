import static org.junit.Assert.*;

import org.junit.Test;

public class SigmoidNeuronTest {

	public SigmoidNeuron neuron;

	@Test
	public void testComputeActivation() {
		InputNeuron a = new InputNeuron();
		InputNeuron b = new InputNeuron();
		a.setActivation(2);
		b.setActivation(1);
		neuron = new SigmoidNeuron(new Neuron[] {a, b}, new double[] {1, 2});
		neuron.updateActivation();
		assertEquals(0.98201379003, neuron.getActivation(), .0001);
	}

	@Test
	public void testUpdateDelta() {
		InputNeuron a = new InputNeuron();
		neuron = new SigmoidNeuron(new Neuron[] {a, a}, new double[] {2, 3});
		neuron.setActivation(0.1);
		neuron.updateDelta(1);
		assertEquals(0.081, neuron.getDelta(), .0001);
	}

}
