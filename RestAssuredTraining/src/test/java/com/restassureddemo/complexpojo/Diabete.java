package com.restassureddemo.complexpojo;

import java.util.ArrayList;
import java.util.List;

public class Diabete {
	
	private List<Medication> medication = new ArrayList<Medication>();
	public List<Medication> getMedication() {
		return medication;
	}
	public void setMedication(List<Medication> medication) {
		this.medication = medication;
	}
	public List<Labs> getLabs() {
		return labs;
	}
	public void setLabs(List<Labs> labs) {
		this.labs = labs;
	}
	private List<Labs> labs = new ArrayList<Labs>();
	
}
