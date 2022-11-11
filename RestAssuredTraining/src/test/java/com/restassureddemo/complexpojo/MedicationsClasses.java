package com.restassureddemo.complexpojo;

import java.util.ArrayList;
import java.util.List;

public class MedicationsClasses {
	
	private List<ClassName> classname = new ArrayList<ClassName>();
	public List<ClassName> getClassname() {
		return classname;
	}
	public void setClassname(List<ClassName> classname) {
		this.classname = classname;
	}
	public List<ClassName2> getClassname2() {
		return classname2;
	}
	public void setClassname2(List<ClassName2> classname2) {
		this.classname2 = classname2;
	}
	private List<ClassName2> classname2 = new ArrayList<ClassName2>();
	

}
