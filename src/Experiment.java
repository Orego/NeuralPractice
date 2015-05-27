public class Experiment {
		
	public static void main(String[] args) {
		Network or = new Network();	
		double[][] training = {{0,0}, {1,0}, {0,1}, {1,1}};
		double[] trainingCorrect = {1, 0, 1, 1};
		int updates = 10000;
		for (int i = 0; i < updates; i++) {
			int k = (int)(Math.random() * training.length);
			or.train(trainingCorrect[k], training[k]);
			for (int j = 0; j < training.length; j++){
				System.out.print(or.test(training[j]) + "\t");
			}
			System.out.println();
		}
	}	
		
}