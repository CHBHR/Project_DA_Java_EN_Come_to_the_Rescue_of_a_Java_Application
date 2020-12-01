package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.hemebiotech.analytics.exception.StreamUnclosableException;
import com.hemebiotech.analytics.exception.WriterUnclosableException;

/**
 * Simple brute force implementation
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {
	
	public ReadSymptomDataFromFile() {
	}
	
	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 * @throws IOException 
	 */
	@Override
	public List<String> GetSymptoms(String filepath) throws StreamUnclosableException {
		
		ArrayList<String> result = new ArrayList<String>();
		
		if (filepath != null) {
						
			try {
				BufferedReader reader = new BufferedReader (new FileReader(filepath)); //peut lever une exception type 'file not found'
				String line = reader.readLine(); //peut lever une IOException
				
				while (line != null) {
					result.add(line);
					line = reader.readLine();
					// ajouter un timer pour faire planter mon code
				}
				try {
					reader.close();
				} catch(IOException e) {
					throw new StreamUnclosableException("Le stream ne s'est pas fermé correctement");
				}
				
			} catch (FileNotFoundException s) {
				s.getMessage();
				System.out.println("Le fichier n'a pas été trouvé");
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("le fichier ne peut pas être lu");
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
		
		Map<String, Integer> symptomOccurrence = new TreeMap<String, Integer>();
		
		for (String symptom : listSymptom) {
			int occurences = Collections.frequency(listSymptom, symptom);
			symptomOccurrence.put(symptom, occurences);
		}

		return symptomOccurrence;
	}

	/**
	 * 
	 * Write the result in a new text file
	 * 
	 */
	@Override
	public boolean writeSymtomAndOccurrencesInFile(Map<String, Integer> symptomOccurrence) throws WriterUnclosableException {
		
		try {
			FileWriter writer = new FileWriter ("Project02Eclipse/result.out"); // fileNotFoundException Peut être une exception fait maison
			
			for (Map.Entry<String,Integer> entry : symptomOccurrence.entrySet()) {
				writer.write(entry.getKey() + " : " + entry.getValue() + "\n");
			}
			try {
				writer.close();
			} catch(IOException e) {
				throw new WriterUnclosableException("Writer ne s'est pas fermé correctement");
			}
		
		}catch(FileNotFoundException s) {
			s.getMessage();
			System.out.println("Le fichier n'a pas été trouvé");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.printf("fini !");
		
		return true;
	}

}
