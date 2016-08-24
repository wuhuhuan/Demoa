package test;

import java.io.UnsupportedEncodingException;

import org.testng.annotations.Test;


import utils.Wu;



public class test1 extends Wu{
	
	@Test
 	public void f() throws UnsupportedEncodingException {
		String a="\u7B80\u4F53\u4E2D\u6587";
		String b=new String(a.getBytes("UTF-8"),"UTF-8");
		System.out.println(b);
		
	}
  

}
