package com.restassureddemo.complexpojo;

import java.util.ArrayList;
import java.util.List;

public class Medication {
	
	private List<MedicationsClasses> medicationsClasses = new ArrayList<MedicationsClasses>();

	public List<MedicationsClasses> getMedicationsClasses() {
		return medicationsClasses;
	}

	public void setMedicationsClasses(List<MedicationsClasses> medicationsClasses) {
		this.medicationsClasses = medicationsClasses;
	}

}
