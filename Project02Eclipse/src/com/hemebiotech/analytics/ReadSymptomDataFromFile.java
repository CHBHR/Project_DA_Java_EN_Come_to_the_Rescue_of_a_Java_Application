package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * Simple brute force implementation
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath;
	
	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 */
	public ReadSymptomDataFromFile (String filepath) {
		this.filepath = filepath;
	}
	
	@Override
	public List<String> GetSymptoms() {
		ArrayList<String> result = new ArrayList<String>();
		
		if (filepath != null) {
			try {
				BufferedReader reader = new BufferedReader (new FileReader(filepath));
				String line = reader.readLine();
				
				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}

	/**
	 * 
	 * Counts the number of occurrences of the symptoms in listSymptoms and returns map
	 * 
	 * @param a string list
	 * 
	 * @return a map of symptoms<String> and number of occurrences<Integer>
	 */
	@Override
	public Map<String, Integer> countSymptomOccurrence(List<String> listSymptom) {
		
		Map<String, Integer> SymptomOccurrence = new HashMap<String, Integer>();
		
		for (String i : listSymptom) {
			Integer j = SymptomOccurrence.get(i);
			SymptomOccurrence.put(i, (j==null)? 1: j+1);
		}
		return SymptomOccurrence;
	}

	/**
	 * 
	 */
	@Override
	public boolean ecrireSymptomeOccuranceDansFichier(Map<String, Integer> SymptomOccurrence) {
		// for(int i=0, max=hashmap.size(); i<max, i<n; i++) { ... }

		
		return false;
	}

}
