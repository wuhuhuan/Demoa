package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;



public class CsvDataProvider extends DataProviderImpl{
public final char SEPARATE = '|'; 
public final String ANNOTATION="#";
	
	
	@Override
    protected void generateData(String caseName, String dataFile) {
		List<String[]> csvList = getCSVList(caseName,dataFile);
        if (csvList.equals(null) || csvList.size() == 0) {
            return;
        }
        for (int i = 1; i <= csvList.size(); i++) {
        	 if (i >= start && i <= max) {
        		 String[] line = csvList.get(i-1);
        		 data.add(line);
        	 }
        }
		}
	
	
	@SuppressWarnings("resource")
	private List<String[]> getCSVList(String caseName,String dataFile){
		List<String[]> csvList = new ArrayList<String[]>();
		try {
			CSVReader reader = new CSVReader(new InputStreamReader(new FileInputStream(defaultPath+dataFile+File.separator+caseName),"GBK"),SEPARATE);
			String[] line=null;
			while ((line=reader.readNext())!=null) {
			
				if(line.length==1&&line[0].isEmpty()||line[0].startsWith(ANNOTATION)){
					continue;
				}
				csvList.add(line);
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return csvList;
	}
	public static void main(String[]args){
		
	}
}
