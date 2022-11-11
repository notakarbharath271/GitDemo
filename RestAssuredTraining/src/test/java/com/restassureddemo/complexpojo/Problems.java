package com.restassureddemo.complexpojo;

import java.util.ArrayList;
import java.util.List;

public class Problems {
	
  private List<Diabete> diabetes = new ArrayList<Diabete>();
  private List<Asthma> asthma = new ArrayList<Asthma>();
  
  
  public List<Diabete> getDiabetes() {
	return diabetes;
}
public void setDiabetes(List<Diabete> diabetes) {
	this.diabetes = diabetes;
}
public List<Asthma> getAsthma() {
	return asthma;
}
public void setAsthma(List<Asthma> asthma) {
	this.asthma = asthma;
}


}
