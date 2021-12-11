package src;
import org.json.simple.*;
import org.json.simple.parser.*;
import java.io.*;


public class Prova {
	
	String file_name;
	JSONObject jsonObject;
	
	public Prova (String file_name) {
		this.file_name=file_name;
	};
	
	
	public void loadData () throws FileNotFoundException, IOException, ParseException {
		JSONParser jsonParser = new JSONParser();
		Object obj = jsonParser.parse(new FileReader (this.file_name));
		this.jsonObject = (JSONObject) obj;
	}
	
	public JSONArray getInformation () {
		java.util.Iterator iterator =  this.jsonObject.values().iterator();
		JSONArray information = (JSONArray)iterator.next();
		return information;
	}
	
	

     public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		Prova jsonTest = new Prova("file.json");
		jsonTest.loadData();
		for (int i=0;jsonTest.getInformation()!=null;i++ ) System.out.println (jsonTest.getInformation().get(i));
    	} 
}


		



