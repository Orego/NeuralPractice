/**Input Neuron*/
public class InputNeuron implements Neuron {

	private double activation; 
	
	@Override
	public double getActivation() {
		return activation;
	}

	@Override
	public void setActivation(double act) {
		activation = act;
	}
	
	@Override
	public String toString(){
		return "Activation of Input Neuron = " + activation + "\n";
	}
}
