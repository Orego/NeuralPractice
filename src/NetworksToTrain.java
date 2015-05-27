
public class NetworksToTrain {
	
	private Network or;
	int passes = 10000;
//	private Network and; 
	
	public static void main(String[] args) {
		new NetworksToTrain().run();
	}
		
	private void run(){
		or = new Network();	
		double[][] training = {{0,0}, {1,0}, {0,1}, {1,1}};
		double[] trainingCorrect = {1, 0, 1, 1};
//		double errorSum = 1;
		for (int i = 0; i < passes; i++){
			int k = (int)(Math.random() * 4);
			train(training[k][0], training[k][1], trainingCorrect[k]);
//			errorSum = train(training[0][0], training[0][1], trainingCorrect[0]);	
////			System.out.println("First Error Sum: " + errorSum);
//			errorSum += train(training[1][0], training[1][1], trainingCorrect[1]);
//			errorSum += train(training[2][0], training[2][1], trainingCorrect[2]);
//			errorSum += train(training[3][0], training[3][1], trainingCorrect[3]);
////			System.out.println("Error Sum: " + errorSum);
		}
		for (int i = 0; i < 4; i++){
			System.out.println(test(training[i][0], training[i][1]));
		}
	}	
		
	private double train(double one, double two, double correct){
		or.setInputs(one, two);
		or.output.updateActivation();
		or.output.updateDelta(correct);
		or.updateWeights();
//		for (int i = 0; i < or.output.getInputSize(); i++){
//			System.out.print(or.output.getWeights()[i] + " ");
//		}
//		System.out.println();
		or.output.updateActivation();
		return or.output.getDelta();
	}
	
	private double test(double one, double two){
		or.setInputs(one, two);
		or.output.updateActivation();
		return or.output.getActivation();
	}
}
