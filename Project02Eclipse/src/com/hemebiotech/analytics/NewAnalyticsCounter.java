package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class NewAnalyticsCounter {
	//
	
	public static void main(String[] args) throws Exception {		
		
		ReadSymptomDataFromFile testRun = new ReadSymptomDataFromFile("Project02Eclipse/symptoms.txt");
		
		List<String> bla = testRun.GetSymptoms();
		
		Map<String, Integer> blu = testRun.countSymptomOccurrence(bla);
		
		testRun.writeSymtomAndOccurrencesInFile(blu);
		
	}


}