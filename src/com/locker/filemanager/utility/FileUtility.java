package com.locker.filemanager.utility;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class FileUtility {

	public static final String directoryPath = "C:\\resources";
	/**
	 * search for all the files that are found under default directory and sub-directory
	 * @param fileName
	 * @return
	 */
	public List<String> searchfile(String searchName) {
		List<String> filteredFileNames = new ArrayList<>();
		List<String> allFileNames = null;
		try {
			allFileNames = listfiles();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		for(String fileName: allFileNames) {
			if(fileName.toLowerCase().contains(searchName.toLowerCase())) {
				filteredFileNames.add(fileName);
			}
		}
		return filteredFileNames;
	}
	
	/**
	 * List all the files under the default directory
	 * @return
	 */
	public List<String> listfiles() throws Exception {
		List<String> fileNames = new ArrayList<>();
		File[] files = new File(directoryPath).listFiles();

		if(files==null) {
			throw new Exception("Sorry!! The directory "+directoryPath+" doesnt seem to exist. Please create the directory to proceed");
		}
		for (File file : files) {
		    if (file.isFile()) {
		    	fileNames.add(file.getName());
		    }
		}
		if(!fileNames.isEmpty()) {
			Collections.sort(fileNames, String.CASE_INSENSITIVE_ORDER);
		}else {
			throw new Exception("Sorry!! The directory "+directoryPath+" doesnt have any files currently");
		}
		
		return fileNames;
	}
	
	/**
	 * Add a file name in the default directory
	 * @param fileName
	 * @return
	 */
	public boolean addfile(String fileName) throws Exception{
		boolean fileAdded = false;
	    try {
	    	File myFile = new File(directoryPath, fileName);
	    	if(!myFile.exists()) {
	    		fileAdded = myFile.createNewFile();
			}else {
				throw new Exception("Sorry!! A file by the name "+fileName+" already exists in directory "+directoryPath);
			}
	    } catch (IOException e) {
	        //e.printStackTrace();
	        fileAdded = false;
	    }
		return fileAdded;
	}

	/**
	 * This method will be used for deleting a particular file from a directory
	 * @param fileName
	 * @return true - if successfully deleted
	 */
	public boolean deletefile(String fileName) throws Exception{
		boolean fileDeleted = false;
		try {
			File myFile = new File(directoryPath, fileName);
			if(myFile.exists()) {
				fileDeleted = myFile.delete();
			}else {
				throw new Exception("Sorry!! "+fileName+" doesnt exist in directory "+directoryPath);
			}
	    } catch (SecurityException e) {
	        e.printStackTrace();
	    	fileDeleted = false;
	    }
		
		return fileDeleted;
	}
}
