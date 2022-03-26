package com.locker.filemanager.client;

import java.io.File;
import java.util.ArrayList;
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
		
		str.append("Please enter one of the below options").append(newLine);
		str.append("1. Search for files").append(newLine);
		str.append("2. Add a file").append(newLine);
		str.append("3. Delete a file").append(newLine);

		FileUtility fileUtility = new FileUtility();
		
		System.out.println(str.toString()+fileUtility.listfiles());
		
		Scanner sc= new Scanner(System.in); 
	}

}
