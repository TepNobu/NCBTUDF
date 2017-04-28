package wl.ncb.tudf.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CompareTextFilesDiff {

	public CompareTextFilesDiff() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) throws IOException
    {    
    System.out.println("Hello World..");
    try {
  	File hpText = new File("C:\\NCBWL\\CompareTextFile\\hp_no\\HpNo.txt");
    BufferedReader readerFind = new BufferedReader(new FileReader(hpText));
    
	/*Output for line Diff*/
	File tempFileLineDiff = new File("C:\\NCBWL\\CompareTextFile\\OUTPUT\\myTempFileLineDiff.txt");
	File tempFileLineSame = new File("C:\\NCBWL\\CompareTextFile\\OUTPUT\\myTempFileLineSame.txt");
	File tempHpNoDiff = new File("C:\\NCBWL\\CompareTextFile\\OUTPUT\\myTempHpNoDiff.txt");
	

    BufferedWriter writer = new BufferedWriter(new FileWriter(tempFileLineDiff,true));
    BufferedWriter  writerSame = new BufferedWriter(new FileWriter(tempFileLineSame,true));
    BufferedWriter  writerHpNoDiff = new BufferedWriter(new FileWriter(tempHpNoDiff,true));
    
    
    String lineFind = readerFind.readLine();
    int lineNo = 1;
    int cnthp_diff=0;
    int cnthp_same=0;
    
    while (lineFind != null)
    {
    	
       System.out.println("Line num:"+lineNo+">>"+lineFind);
       /*
        * 
        * todo*/
       

      try {
    	   /*Input*/
    	    File oracleText = new File("C:\\NCBWL\\CompareTextFile\\oracle\\TUCRS-WL-2017-02.txt");
    		File foxproText = new File("C:\\NCBWL\\CompareTextFile\\foxpro\\TUCRS-WL-2017-02.txt");
    	

   	         
 		        BufferedReader reader1 = new BufferedReader(new FileReader(oracleText));
 		        BufferedReader reader2 = new BufferedReader(new FileReader(foxproText));

 		        String line1 = reader1.readLine();
 		         
 		        String line2 = reader2.readLine();
 		     
 		        String line1temp="";
 		        String line2temp="";
 		         
 		        boolean areEqual = true;
 		         
 		        int lineNum = 1;
   
 		        while (line1 != null || line2 != null)
 		        {
 		        	// System.out.println("Line1:"+line1+"Line2"+line2);
 		        	
 		        if(line1 != null){
 		         if(line1.contains(lineFind)){
 		        	line1temp = line1;
 		        	line1=null;
 		       // 	System.out.println("line1 have"+line1temp+" same content."+lineFind);
 	               }
 		        }
 		         if(line2 != null){
 		          if(line2.contains(lineFind)){
 		        	line2temp = line2;
 		        	line2=null;
 		        	//System.out.println("line2 have"+line2temp+" same content."+lineFind);
 	               }
 		         }
 		        	
 		         
 		   
 		             
 		            line1 = reader1.readLine();
 		             
 		            line2 = reader2.readLine();
 		             

 		            lineNum++;
 		        
 		        }//end while()
 		        
 		       if(!line1temp.isEmpty()&&!line2temp.isEmpty()){
 		    	   
 		    	    if(! line1temp.equalsIgnoreCase(line2temp)){

		        	 System.out.println("File1 has "+line1temp+" and File2 has "+line2temp+" at line "+lineNo);
		        	 writer.write("#FileOracle has >>"+line1temp+" and FileFoxpro has >>"+line2temp+ System.getProperty("line.separator"));
		        	 writerHpNoDiff.write(lineFind+ System.getProperty("line.separator"));
		        	 
		        	 cnthp_diff++;
 		    	    }else
	 		    	    {
	 		    	    	System.out.println("Two files have same content.");	
	 		    	        writerSame.write("#FileOracle has >>"+line1temp+" and FileFoxpro has >>"+line2temp+ System.getProperty("line.separator"));
	 		    	       cnthp_same++;
	 		    	    }
 		    	    }
 		      line1temp="";
 		      line2temp="";
 		         

 		       // writer.close(); 
 		     //   writerSame.close();
 		        
 		        reader1.close();
 		         
 		        reader2.close();
 	        System.out.println("--- File End ---");
    } catch (FileNotFoundException e) {
        //do something clever with the exception
  	  System.out.println("--- FileNotFoundException ---");
    } catch (IOException e) {
        //do something clever with the exception
  	  System.out.println("--- IOException ---");
    }//end try()
   
   /*end todo*/
  	lineFind = readerFind.readLine();
  	
      lineNo++;
      
  }//end while()
    writer.write("#Total Diff >> "+cnthp_diff+" records");
    writerSame.write("#Total Same >>"+cnthp_same+" records");
     
     writer.close(); 
     writerSame.close();
     writerHpNoDiff.close();
     readerFind.close();
     
  System.out.println("--- Find Complete---");
  } catch (FileNotFoundException e) {
      //do something clever with the exception
	  System.out.println("--- FileNotFoundException Find Hp_no---");
  } catch (IOException e) {
      //do something clever with the exception
	  System.out.println("--- IOException ---");
  }//end try()
    
    }

}
