package com.hemebiotech.analytics;

import java.util.List;

/**
 * Anything that will read symptom data from a source
 * The important part is, the return value from the operation, which is a list of strings,
 * that may contain many duplications
 * 
 * The implementation does not need to order the list
 * 
 */

	// access file
	// read file line by line
	// make sure to not have duplicates
	// return list of string


public interface ISymptomReader {
	/**
	 * If no data is available, return an empty List
	 * 
	 * @return a raw listing of all Symptoms obtained from a data source, 
	 * duplicates are possible/probable
	 */
	List<String> GetSymptoms ();
	
	// if no data/ empty file return empty list
	// take care of duplicates
	// return list of string
}
