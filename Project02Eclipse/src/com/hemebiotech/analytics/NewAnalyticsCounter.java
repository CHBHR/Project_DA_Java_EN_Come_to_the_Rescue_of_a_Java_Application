package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.hemebiotech.analytics.exception.StreamUnclosableException;
import com.hemebiotech.analytics.exception.WriterUnclosableException;

public class NewAnalyticsCounter {
	
	public static void main(String[] args) {
		
		List<String> listeDesSymptomes = new ArrayList<String>();
		
		ReadSymptomDataFromFile nouvelleInstance = new ReadSymptomDataFromFile();
		
		try {
		listeDesSymptomes = nouvelleInstance.GetSymptoms("Project02Eclipse/symptoms.txt");
		}catch(StreamUnclosableException e){
			e.printStackTrace();
		}
		
		Map<String, Integer> mapDesSymptomes = nouvelleInstance.countSymptomOccurrence(listeDesSymptomes);
		
		try {
			nouvelleInstance.writeSymtomAndOccurrencesInFile(mapDesSymptomes);
		}catch(WriterUnclosableException e) {
			e.printStackTrace();
		}
		
		
	}

}