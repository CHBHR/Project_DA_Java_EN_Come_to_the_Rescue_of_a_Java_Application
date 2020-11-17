package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
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
	
	public ReadSymptomDataFromFile (String filepath) {
		this.filepath = filepath;
	}
	
	public ReadSymptomDataFromFile() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 */
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
		
		Map<String, Integer> symptomOccurrence = new HashMap<String, Integer>();
		
		for (String i : listSymptom) {
			Integer j = symptomOccurrence.get(i);
			symptomOccurrence.put(i, (j==null)? 1: j+1);
		}
		return symptomOccurrence;
	}

	/**
	 * 
	 * Write the result in a new text file
	 * 
	 */
	@Override
	public boolean writeSymtomAndOccurrencesInFile(Map<String, Integer> symptomOccurrence) {
		
		try {
			FileWriter writer = new FileWriter ("Project02Eclipse/testResult.out");
			
			for (Map.Entry<String,Integer> entry : symptomOccurrence.entrySet()) { 
				writer.write(entry.getKey() + " : " + entry.getValue() + "\n");
			}
			
			writer.close();
		}catch(FileNotFoundException e) {
			System.out.printf("ERROR - A %s occured: \n \t %s \n", e.getClass().toString(), e.getMessage());
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.printf("fini !");
		return true;
		
	}
	
	

}
