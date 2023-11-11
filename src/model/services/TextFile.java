/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.services;

/**
 *
 * @author drazc
 */

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;

import model.entities.Words;

public class TextFile {
    private static void verifyDel(String name) throws FileNotFoundException{

        File file = new File(name);

        if (file.exists()) {
        	deleteRecorder(name);
        }
    }
	
	public static boolean verify(String name) throws FileNotFoundException{

        File file = new File(name);

        if (file.exists()) {
        	return true;
        }
        else
        {
        	return false;
        }
    }
	
    private static PrintStream createRecorder(String name) throws FileNotFoundException{

        File file = new File(name);

        if (! file.exists()) {
         return new PrintStream (file);
        }
        else{
            return null;
        }
    }
    
    public static void writeInsert(Words word, String fin) throws FileNotFoundException, IOException{
    	String name;
    	switch(word.getLevel())
    	{
    	case 1:
    		name = Const.N1;
    		break;
    	case 2:
    		name = Const.N2;
    		break;
    	default:
    		name = Const.N3;
    	}
    	ArrayList<String> insert = readMultipleRecorder(name);
    	insert.add(word.toString() + fin);
    	verifyDel(name);
    	PrintStream rec = createRecorder(name);
 	   	for(String str : insert)
 	   	{
 		   rec.println(str);
 	   	}
        rec.close();
   } 
    
    
   
   public static void deleteRecorder(String name)
{
String fileName = name;
    // A File object to represent the filename
    File f;
    f = new File(fileName);
    /*if(flag == true){
    	f = new File(Constants.textFolder + fileName);	
    }
    else{
    	f = new File(Constants.textFolder2 + fileName);
    }*/

    // Make sure the file or directory exists and isn't write protected
    if (!f.exists())
      throw new IllegalArgumentException(
          "Delete: no such file or directory: " + fileName);

    if (!f.canWrite())
      throw new IllegalArgumentException("Delete: write protected: "
          + fileName);

    // If it is a directory, make sure it is empty
    if (f.isDirectory()) {
      String[] files = f.list();
      if (files.length > 0)
        throw new IllegalArgumentException(
            "Delete: directory not empty: " + fileName);
    }

    // Attempt to delete it
    boolean success = f.delete();
    if(success == true)
        System.out.print("");
    }
   
   public static ArrayList<String> readMultipleRecorder(String fileName)
  {
      ArrayList<String> lines = new ArrayList<>();
  try{
  // Open the file that is the first 
  // command line parameter
  FileInputStream fstream = new FileInputStream(fileName);
      try (DataInputStream in = new DataInputStream(fstream)) {
          BufferedReader br = new BufferedReader(new InputStreamReader(in));
          String strLine;
          //Read File Line By Line
          while ((strLine = br.readLine()) != null)   {
          // Print the content on the console
          lines.add(strLine);
          }
          br.close();
      }
    }catch (Exception e){//Catch exception if any
  //System.err.println("Error: " + e.getMessage());
    	return lines;
  }
  return lines;
  }
   
   public static ArrayList<String> readMultipleRecorder(String fileName, int block, int quant)
   {
       ArrayList<String> lines = new ArrayList<>();
   try{
   // Open the file that is the first 
   // command line parameter
   FileInputStream fstream = new FileInputStream(fileName);
       try (DataInputStream in = new DataInputStream(fstream)) {
           BufferedReader br = new BufferedReader(new InputStreamReader(in));
           String strLine;
           int init, fin, size = -1;
           //Read File Line By Line
           init = block*quant;
           fin = init+quant;
           while ((strLine = br.readLine()) != null)   {
           // Print the content on the console
        	   size++;
        	   if(size >= init && size < fin)
        	   {
        		   lines.add(strLine);
        	   }
        	   else
        	   {
        		   if(size >= fin)
        		   {
        			   break;
        		   }
        	   }
           //lines.add(strLine);
           }
           br.close();
       }
     }catch (Exception e){//Catch exception if any
   System.err.println("Error: " + e.getMessage());
   }
   return lines;
   }
   
   public static void writeRecorder(String number, String name) throws FileNotFoundException, IOException{
       verifyDel(name);
	   PrintStream rec = createRecorder(name);
       rec.print(number);
       rec.close();
       //System.out.println(recorder +" gravado com sucesso");
   } 
   
   
}
