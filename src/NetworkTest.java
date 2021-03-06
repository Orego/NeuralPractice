import static org.junit.Assert.*;

import org.junit.Test;

public class NetworkTest {

	@SuppressWarnings("static-method")
	@Test
	public void testOr() {
		Network or = new Network();
		double[][] training = { { 0, 0 }, { 1, 0 }, { 0, 1 }, { 1, 1 } };
		double[] trainingCorrect = { 0, 1, 1, 1 };
		int updates = 10000;
		for (int i = 0; i < updates; i++) {
			int k = (int) (Math.random() * training.length);
			or.train(trainingCorrect[k], training[k]);
		}
		for (int i = 0; i < training.length; i++) {
			assertEquals(trainingCorrect[i], or.test(training[i]), 0.05);
		}
	}

}
