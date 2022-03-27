package com.locker.filemanager.client;

import java.util.List;
import java.util.Scanner;

import com.locker.filemanager.utility.FileUtility;

public class LockedMeClient {

	public static void main(String[] args) {
		StringBuilder str = new StringBuilder();
		String newLine = "\n";
		
		str.append("Hello Everyone!!").append(newLine);
		str.append("This is the prototype application developed for Lockers Pvt Ltd").append(newLine).append(newLine);
		
		str.append("Application Name: File Management").append(newLine);
		str.append("Developed By : Neelkanth Tripathi").append(newLine).append(newLine);

		FileUtility fileUtility = new FileUtility();
		
		System.out.println(str.toString());
		
		while(true) {
			StringBuilder menuItems = new StringBuilder(newLine);
			menuItems.append("************************************************").append(newLine);
			menuItems.append("Please enter one of the below options").append(newLine);
			menuItems.append("1. Retrieve all files in ascending order").append(newLine);
			menuItems.append("2. Search for files").append(newLine);
			menuItems.append("3. Add a file").append(newLine);
			menuItems.append("4. Delete a file").append(newLine);
			menuItems.append("5. Exit").append(newLine);
			menuItems.append("************************************************");
			System.out.println(menuItems);
			
			Scanner sc= new Scanner(System.in);
			String choiceStr = sc.next();
			int choice = 0;

			try {
				choice = Integer.parseInt(choiceStr);
			}catch(Exception ex) {}
			
			switch(choice) {
				case 1: 
					try {
						List<String> sortedFiles = fileUtility.listfiles();
						System.out.println("Below are all the files in a sorted order:");
						for(String eachFile: sortedFiles) {
							System.out.println(eachFile);
						}
					}catch(Exception ex) {
						System.out.println(ex.getMessage());
					}
					break;
				case 2:
					System.out.println("Alright! Lets search");
					System.out.println("Enter the name of the file that you intend to search:");
					String searchCriteria = sc.next();
					List<String> searchedFiles = fileUtility.searchfile(searchCriteria);
					if(!searchedFiles.isEmpty()) {
						System.out.println("Below are the files that matched your search criteria - "+searchCriteria+" :");
						for(String eachFile: searchedFiles) {
							System.out.println(eachFile);
						}
					}else {
						System.out.println("Sorry! I couldnt find any files that contain the characters - "+searchCriteria);
					}
					break;
				case 3:
					System.out.println("Enter the name of a file that you want to add: ");
					String newFileName = sc.next();
					try {
						boolean addFileSuccess = fileUtility.addfile(newFileName);
						if(addFileSuccess) {
							System.out.println("File has been added to "+FileUtility.directoryPath);
						}else {
							System.out.println("Sorry there was an issue in adding the file");
						}
					}catch(Exception ex) {
						System.out.println(ex.getMessage());
					}
					break;
				case 4:
					System.out.println("Enter the full name of the file that you wish to delete: ");
					String deleteFileName = sc.next();
					try {
						boolean deleteFileSuccess = fileUtility.deletefile(deleteFileName);
						if(deleteFileSuccess) {
							System.out.println("File " +deleteFileName+ " has been deleted from "+FileUtility.directoryPath);
						}else {
							System.out.println("Sorry there was an issue in deleting the file");
						}
					}catch(Exception ex) {
						System.out.println(ex.getMessage());
					}
					break;
				case 5:	
					System.out.println("Ok Goodbye!!");
					sc.close();
					System.exit(0);
				default:
					System.out.println("Sorry! Your choice wasnt in the menu list");
					System.out.println("Please enter your choice again");
			}
		}
	}

}
