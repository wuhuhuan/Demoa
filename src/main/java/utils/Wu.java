package utils;

import java.lang.reflect.Method;


import org.testng.annotations.DataProvider;

public class Wu {
	@DataProvider(name="csv")
	protected Object[][] csvDate(Method m){
		return new CsvDataProvider().getData("data.csv","");
	}
}
