package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

/**
 * Anything that will read symptom data from a source
 * The important part is, the return value from the operation, which is a list of strings,
 * that may contain many duplications
 * 
 * The implementation does not need to order the list
 * 
 */
public interface ISymptomReader {
	/**
	 * If no data is available, return an empty List
	 * 
	 * @return a raw listing of all Symptoms obtained from a data source, 
	 * duplicates are possible/probable
	 */
	List<String> GetSymptoms ();
	
	/**
	 * 
	 * Transforms the raw listing into a map with the symptoms and number of occurrences
	 * 
	 * @param listSymptom raw listing from GetSymptoms
	 * @return 
	 */
	Map<String, Integer>  countSymptomOccurrence (List<String> listSymptom);
	
	/**
	 * 
	 * Writes the final list into a file
	 * 
	 * @param laMap 
	 * @return 
	 */
	boolean ecrireSymptomeOccuranceDansFichier(Map<String, Integer> laMap);
}
