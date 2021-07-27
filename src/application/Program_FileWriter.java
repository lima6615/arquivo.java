package application;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Program_FileWriter {


	public static void main(String[] args) {
		
		
		String [] vect = new String[]{"good morning","Good Afternoon","Good night"};
		
		String path = "c://windows//temp//teste.txt";
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(path))){
			for(String c : vect) {
				bw.write(c);
		        bw.newLine();
			}
		}catch(IOException e) {
			System.out.println("Error: "+ e.getMessage());
		}
	}
}
