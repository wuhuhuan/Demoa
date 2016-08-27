package utils;

import java.util.ArrayList;
import java.util.List;


public class DataProviderImpl implements IData{
	
	protected String defaultPath =System.getProperty("user.dir")+ "/tool/";
	
	protected int start = 1;
	
	protected int max = Integer.MAX_VALUE;
	
	protected List<Object[]> data = new ArrayList<Object[]>();
	
	
	
	public Object[][] getData(String caseName, String dataFile) {
		generateData(caseName, dataFile);
		return generateArrayData();
	}

	
	
	public Object[][] getData(String caseName, String dataFile, int startRowNum) {
		start = startRowNum;
		return getData(caseName, dataFile);
	}

	
	
	public Object[][] getData(String caseName, String dataFile,
			int startRowNum, int Length) {
		max = startRowNum + Length;
		return getData(caseName, dataFile, startRowNum);
	}

	public String getDefaultPath() {
		return defaultPath;
	}

	public void setDefaultPath(String defaultPath) {
		this.defaultPath = defaultPath;
	}

	
	protected void generateData(String caseName, String dataFile) {}
 
	protected Object[][] generateArrayData() {
		int i = 0;
		Object[][] o = new Object[data.size()][];
		for (Object[] oo : data) {
			o[i++] = oo;
		}
		data.clear();
		return o;
	}

public static void main(String[]args){
	
}

}