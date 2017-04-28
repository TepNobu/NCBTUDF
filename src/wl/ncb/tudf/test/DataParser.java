package wl.ncb.tudf.test;

public abstract class DataParser {

	   public void parseDataAndGenerateOutput()
	   {
		   readData();
		   processData();
		   writeData();
	   }
	   //This methods will be implemented by its subclass
	   abstract void readData();
	   abstract void processData();
	   
	   //We have to write output in  csv file so this step will be same for all subclasses
	   public void writeData(){
		   System.out.println("Output Generated,Writing to CSV");
	   }
}
