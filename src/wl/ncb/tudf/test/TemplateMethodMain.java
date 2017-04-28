package wl.ncb.tudf.test;

public class TemplateMethodMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         CSVDataParser csvDataParser= new CSVDataParser();
         csvDataParser.parseDataAndGenerateOutput();
         
         System.out.println("**************************");
         DatabaseDataParser databaseDataParser= new DatabaseDataParser();
         databaseDataParser.parseDataAndGenerateOutput();
	}

}
