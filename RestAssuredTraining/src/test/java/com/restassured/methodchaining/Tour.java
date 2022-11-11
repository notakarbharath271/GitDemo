package com.restassured.methodchaining;

public class Tour {
	
	String palce ;
	String modeoftravel;
	public String getPalce() {
		return palce;
	}
	public Tour setPalce(String palce) {
		this.palce = palce;
		return this;
	}
	public String getModeoftravel() {
		return modeoftravel;
	}
	public Tour setModeoftravel(String modeoftravel) {
		this.modeoftravel = modeoftravel;
		return this;
	}
	
	public void whereAreYouGoing() {
		System.out.println("I am going to "+getPalce()+ " by "+getModeoftravel());
		
	}
	public static void main(String[] args) {
		
		Tour tour = new Tour();
		tour.setPalce("Kanipakam");
		tour.setModeoftravel("Car");
	
		tour.whereAreYouGoing();
		
		//method chaining
		// to achieve method chaining we can do some modification in the setter methods i.e. the methods should return class name
		
		tour.setPalce("Tirumula").setModeoftravel("Bus").whereAreYouGoing();

	}

}
