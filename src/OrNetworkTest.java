import static org.junit.Assert.*;

import org.junit.Test;

public class OrNetworkTest {

	public Network or = new Network();

	@Test
	public void testRand() {
		for (int i=0; i<100; i++){
			double x = or.rand();
			assertTrue((x < or.weightMax) && (x > or.weightMin));
		}
	}

	@Test
	public void testCalculateDeltaOutput() {
		or.a.setActivation(1);
		or.b.setActivation(0);
		or.bias.setActivation(1);
		double[] testWeights = {1, 1, 1};
		or.output.setWeights(testWeights);
		or.output.setInputSize(3);
		Neuron[] testInput = {or.a, or.b, or.bias};
		or.output.setInputs(testInput);
		or.output.setActivation(or.output.computeActivation());
		or.output.setDelta(or.calculateDeltaOutput(1));
		assertEquals(or.output.getDelta(), 0.0125155, .001);
	}

	
}
