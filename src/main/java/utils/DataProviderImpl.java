package utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Data DataProvider Impl
 * 
 * @author nihuaiqing
 */
public class DataProviderImpl implements IData{
	
	protected String defaultPath =System.getProperty("user.dir")+ "/tool/";
	
	protected int start = 1;
	
	protected int max = Integer.MAX_VALUE;
	
	protected List<Object[]> data = new ArrayList<Object[]>();
	
	/**
	 * ���ļ��л�ȡ����
	 * @param caseName ���ݼ�����
	 * @param dataFile �����ļ�
	 */
	
	public Object[][] getData(String caseName, String dataFile) {
		generateData(caseName, dataFile);
		return generateArrayData();
	}

	/**
	 * ���ļ��л�ȡ����
	 * @param caseName ���ݼ�����
	 * @param dataFile �����ļ�
	 * @param startRowNum ��ʼ�����ݼ�¼��Ĭ��Ϊ1
	 */
	
	public Object[][] getData(String caseName, String dataFile, int startRowNum) {
		start = startRowNum;
		return getData(caseName, dataFile);
	}

	/**
	 * ���ļ��л�ȡ����
	 * @param caseName ���ݼ�����
	 * @param dataFile �����ļ�
	 * @param startRowNum ��ʼ�����ݼ�¼��Ĭ��Ϊ1
	 * @param Length ��ȡ���ݵĳ��ȣ�Ĭ��Ϊȫ����������ʼ����
	 */
	
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

	/**
	 * ������ļ�������Ҫ��д�������
	 */
	protected void generateData(String caseName, String dataFile) {}
   /**
    * ��listת��Ϊ��������
    * @return
    */
	
	protected Object[][] generateArrayData() {
		int i = 0;
		Object[][] o = new Object[data.size()][];
		for (Object[] oo : data) {
			o[i++] = oo;
		}
		data.clear();
		return o;
	}
}
