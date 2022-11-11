package com.restassureddemo.complexpojo;

import java.util.ArrayList;
import java.util.List;

public class HealthCarePojo {
	
	private List<Problems> problems = new ArrayList<Problems>();

	public List<Problems> getProblems() {
		return problems;
	}

	public void setProblems(List<Problems> problems) {
		this.problems = problems;
	}

}
