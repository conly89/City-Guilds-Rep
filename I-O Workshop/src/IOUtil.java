import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;


public class IOUtil {
	/*
	 * This method will open a file that the user chooses,
	 * then store the data from the file into a StringBuffer.
	 */
	public static StringBuffer openFile(){
		StringBuffer fileContents = new StringBuffer();//Declares the String buffer to hold text in the text file.
		JFileChooser chooser = new JFileChooser();//Declares the JFileChooser object to let the user choose their file.
		FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES","txt","text");
		
		chooser.setFileFilter(filter);//Adds the fileNameExtensionFilter into the JFileChooser
		chooser.showOpenDialog(null);//Displays an open dialog window.
		
		File targetFile = chooser.getSelectedFile();//Assigns the chosen file to the variable targetFile.
		
		try {
			Scanner myScanner = new Scanner(targetFile);//Declares and instantiates our Scanner object for reading the file.
			while(myScanner.hasNextLine()){//Our loop will check to ensure there is a line there.
				//This line of code takes the nextLine of text from the file and appends it to our StringBuffer.
				fileContents.append(myScanner.nextLine() + "\r\n");
			
			}
			myScanner.close();//Closes our scanner object so that we're not wasting resources.
		}catch(NullPointerException event){
			System.out.println("We've encountered a NullPointerException");
			event.printStackTrace();
		} catch (FileNotFoundException event) {
			System.out.println("We've encountered a FileNotFoundException");
			event.printStackTrace();
		}
		
		return new StringBuffer(fileContents);//Returns a new StringBuffer item which will contain the text from the file.
	}
	/*
	 * This method will save a String the user sends as a parameter,
	 * to a file that the user chooses.
	 */
	public static void saveFile(String targetData){
		JFileChooser chooser2 = new JFileChooser();//Declares the JFileChooser object to let the user chose their file.
		chooser2.showOpenDialog(null);//Displays a save dialog window for the user to select a save path.
	
		String fileName = "";
		
		try{
			fileName = chooser2.getSelectedFile().toString();//Creates a String object with the path and name of the file.
			if(!fileName.endsWith(".txt")){
				fileName = fileName + ".txt";//This if statement ensures that we save the file as a .txt file
			}
		}catch(NullPointerException event){
			System.out.println("We've encountered a FileNotFoundException");
			event.printStackTrace();
		}
		
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));//Creates our writer object
			writer.write(targetData);//Writes the String passed in as an argument to the file we specified earlier.
			writer.close();//Closes our BufferedWriter object so that we are not wasting resources.
		} catch(NullPointerException event){
			System.out.println("We've encountered an NullPointerException");
			event.printStackTrace();
		}catch (IOException event) {
			System.out.println("We've encountered an IOException");
			event.printStackTrace();
		}
	}
}
