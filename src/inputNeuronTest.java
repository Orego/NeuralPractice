import static org.junit.Assert.*;
import org.junit.Test;


public class inputNeuronTest {
	public InputNeuron neuron = new InputNeuron();

	@Test
	/**Tests both set and get*/
	public void testGetActivation() {
		neuron.setActivation(5.0);
		assertEquals(5.0, neuron.getActivation(), .001);
		neuron.setActivation(-1.1);
		assertEquals(-1.1, neuron.getActivation(), .001);
	}


}
