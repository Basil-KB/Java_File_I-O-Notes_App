package com;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class NoteManager {
	  private String fileName;

	public NoteManager(String fileName) {
		this.fileName = fileName;
	}

	public void readNotes() {
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			String str;
			boolean empty=true;
			while((str=br.readLine())!=null) {
				System.out.println(str);
				empty = false;
			}
			if(empty) {
				System.out.println("No notes found.");
			}
			br.close();
		}catch (FileNotFoundException e) {			
			 System.out.println("No notes file found. Start by writing a note!");
		}catch(IOException e) { 
			 System.out.println("Error reading the file: " + e.getMessage());
		}
			
	}

	public void writeNote(Scanner scan) {
		 System.out.println("\nEnter your note (type 'END' on a new line to finish):");
		 StringBuilder note = new StringBuilder();
	     String line;
	     
	     while (!((line = scan.nextLine()).equalsIgnoreCase("END"))) {
	            note.append(line);
	            note.append("\n");
	     }
	     try {
	    	 FileWriter writer = new FileWriter(fileName,true);
	    	 writer.write(note.toString());
	    	 writer.write("-------------------\n");
	    	 System.out.println("Note saved!");
	    	 writer.close();
	     }catch(IOException e){
	    	 System.out.println("Error writing to file: " + e.getMessage());
	     }
	     
	}
	public void eraseNotes() {
	    try (FileWriter writer = new FileWriter(fileName)) {
	        // Writing nothing clears the file
	        System.out.println("All notes erased!");
	    } catch (IOException e) {
	        System.out.println("Error erasing notes: " + e.getMessage());
	    }
	}

}
