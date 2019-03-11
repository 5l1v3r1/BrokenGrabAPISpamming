package xyz.un4.grab.brokenapi.model;

public class GrabRequest {

	private String targetNumber;
	private int delay;
	private int counter;
	private String method;
	public String getTargetNumber() {
		return targetNumber;
	}
	public void setTargetNumber(String targetNumber) {
		this.targetNumber = targetNumber;
	}
	public int getDelay() {
		return delay;
	}
	public void setDelay(int delay) {
		this.delay = delay;
	}
	public int getCounter() {
		return counter;
	}
	public void setCounter(int counter) {
		this.counter = counter;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	@Override
	public String toString() {
		return "GrabRequest [targetNumber=" + targetNumber + ", delay=" + delay + ", counter=" + counter + ", method="
				+ method + "]";
	}
	
	
	

}
