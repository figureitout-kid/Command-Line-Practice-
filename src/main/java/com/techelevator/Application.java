package com.techelevator;


import com.techelevator.search.SearchDomain;
import com.techelevator.search.SearchEngine;
import com.techelevator.util.TELog;

import java.util.List;

import static com.techelevator.util.TELog.log;

public class Application {

	public static void main(String[] args) {
		
		try {

			// Step Two: Create TELog, and log the start of the application.
			//
			TELog.log("Search application started");
			
			
			
			// Step Four: Instantiate a Search Domain
			//
			SearchDomain searchDomain = new SearchDomain("data");
			TELog.log("SearchDomain created: " + searchDomain.toString());

			
			// Step Six: Single word search
			//
			SearchEngine searchEngine = new SearchEngine(searchDomain);
			searchEngine.indexFiles();

			String searchWord = "squirrel";
			List<String> searchResults = searchEngine.search(searchWord);


			// made forloop without j-- *********************
			if (searchResults.isEmpty()){
				System.out.println("No matching files found for word: " + searchWord);
			}
			else {
				System.out.println("Matching files found for word: " + searchWord);
				for (String fileName : searchResults){
					System.out.println(fileName);
				}
			}

			
			
			// Step Seven: Multiple word search
			//
			
			
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
