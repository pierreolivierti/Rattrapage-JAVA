package controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Utilities {
	
	// Method that load an image with a given path
	public static String loadFileAsString(String path) {
		StringBuilder builder = new StringBuilder();
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			String line;
			while((line = br.readLine()) != null) {
				builder.append(line + "\n");		// Storing file content in one string
			}
			br.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
		return builder.toString();
	}
	
	// Method that parse a string in an int
	public static int parseInt(String number){
		try{
			return Integer.parseInt(number);
		}catch(NumberFormatException e){
			e.printStackTrace();
			return 0;
		}
	}
}
