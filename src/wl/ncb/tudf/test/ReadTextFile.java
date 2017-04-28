package wl.ncb.tudf.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class ReadTextFile {

	public static void main(String[] args) throws IOException
    {    
		// BufferedReader reader2 = new BufferedReader(new FileReader("C:\\NCBWL\\CompareTextFile\\foxpro\\TUCRS-WL-2017-02.txt"));
		File oracleText = new File("C:\\NCBWL\\CompareTextFile\\oracle\\TUCRS-WL-2017-02.txt");
		//File oracleText = new File("C:\\NCBWL\\CompareTextFile\\foxpro\\TUCRS-WL-2017-02.txt");
		File tempFile = new File("C:\\NCBWL\\CompareTextFile\\myTempFile.txt");
      try {
	        BufferedReader reader1 = new BufferedReader(new FileReader(oracleText));
	      BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
	      
	       // BufferedReader reader2 = new BufferedReader(new FileReader("C:\\NCBWL\\CompareTextFile\\foxpro\\TUCRS-WL-2017-02.txt"));
	         
	     /*   BufferedReader reader1 = new BufferedReader(new FileReader("C:\\NCBWL\\CompareTextFile\\oracle\\TUCRS-WL-201701.txt"));
	        
	        BufferedReader reader2 = new BufferedReader(new FileReader("C:\\NCBWL\\CompareTextFile\\foxpro\\TUCRS-WL-2017-01.txt"));
	        */
	        String lineOracle = reader1.readLine();
	         
	        //String line2 = reader2.readLine();
	         
	        boolean areEqual = true;
	         
	        int lineNum = 1;
	        String lineToRemove = "1-01-200001";
	       // String currentLine;
	        while (lineOracle != null)
	        {
	           
	             
	            lineOracle = reader1.readLine();
	             

	            lineNum++;
	        //trim newline when comparing with lineToRemove
                String trimmedLine = lineOracle.trim();
                //if(trimmedLine.equals(lineToRemove)){
             if(trimmedLine.contains(lineToRemove)){
                    writer.write(lineOracle+ System.getProperty("line.separator"));
                    break;
               }

                   //  writer.write(lineOracle + System.getProperty("line.separator"));
                
	         /*   if (lineNum==900){
	            	
	            	
	                break;
	            }*/
	        }
	         
	       
	            System.out.println("Line num:"+lineNum+">>"+lineOracle);
	        
	        writer.close(); 
	        reader1.close();
	         
        System.out.println("--- File End ---");
        boolean successful = tempFile.renameTo(oracleText);
      } catch (FileNotFoundException e) {
          //do something clever with the exception
    	  System.out.println("--- FileNotFoundException ---");
      } catch (IOException e) {
          //do something clever with the exception
    	  System.out.println("--- IOException ---");
      }
    }

}
