package com.locker.filemanager.utility;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.locker.filemanager.FileManagementInterface;

public class FileUtility {

	/**
	 * search for all the files that are found under default directory and sub-directory
	 * @param fileName
	 * @return
	 */
	public List<String> searchfile(String searchName) {
		List<String> filteredFileNames = new ArrayList<>();
		List<String> allFileNames = listfiles();
		
		for(String fileName: allFileNames) {
			if(fileName.contains(searchName)) {
				filteredFileNames.add(fileName);
			}
		}
		return filteredFileNames;
	}
	
	/**
	 * List all the files under the default directory
	 * @return
	 */
	public List<String> listfiles() {
		List<String> fileNames = new ArrayList<>();
		File[] files = new File(FileManagementInterface.directoryPath).listFiles();

		for (File file : files) {
		    if (file.isFile()) {
		    	fileNames.add(file.getName());
		    }
		}
		return fileNames;
	}
	
	/**
	 * Add a file name in the default directory
	 * @param fileName
	 * @return
	 */
	public boolean addfile(String fileName) {
		boolean fileAdded = false;
		return fileAdded;
	}

	/**
	 * This method will be used for deleting a particular file from a directory
	 * @param fileName
	 * @return true - if successfully deleted
	 */
	public boolean deletefile(String fileName) {
		boolean fileDeleted = false;
		return fileDeleted;
	}
}
