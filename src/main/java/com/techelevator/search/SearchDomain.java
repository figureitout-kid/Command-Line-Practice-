package com.techelevator.search;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The Search Domain is a list of files to be read and indexed by the Search Engine.
 * 
 * Folders are NOT recursively searched. 
 */
public class SearchDomain {

	private String folder;
	private static List<String> files;
	
	/**
	 * Create a Search Domain of a folder
	 * 
	 * @param folder
	 * @throws SearchDomainException
	 */
	public SearchDomain(String folder) throws SearchDomainException {
		this.folder = folder;
		this.files = buildDomain();
	}
	
	public String getFolder() {
		return folder;
	}

	public static List<String> getFiles() {
		return files;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		for (String file : files) {
			sb.append(file);
			sb.append("\n");
		}
		return sb.toString();
	}
	
	/**
	 * Folders are NOT recursively searched.
	 * 
	 * @return
	 * @throws SearchDomainException
	 */
	private List<String> buildDomain() throws SearchDomainException {
		List<String> files = new ArrayList<>();
		// Step Three: Complete the buildDomain method
		try {
			File folderNew = new File(folder);
		if (folderNew.exists() && folderNew.isDirectory()) {
			File[] folderFiles = folderNew.listFiles();
			if (folderFiles != null){
				for (File file : folderFiles) {
					if (file.isFile()) {
//						we had get name here, only copying the name of the files not the actual file contents
						files.add(file.getPath());
					}
				}
			}
		}
		} catch (Exception e){
			throw new SearchDomainException("Error building domain." + e.getMessage());
		}
		return files;
	}
}
