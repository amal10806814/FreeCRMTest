package testUtil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestDataClass {

	public static String[][] getDataFromExcel(String fileName , String sheetname) throws IOException
	{
	
		FileInputStream fis = new FileInputStream(fileName);
		
		XSSFWorkbook w = new XSSFWorkbook(fis);
	
		XSSFSheet sheet = w.getSheet(sheetname);
	
		int rowCount = sheet.getLastRowNum();
		int cellCount = sheet.getRow(0).getLastCellNum();
	
		String[][] arrayExcelData = new String[rowCount][cellCount];
	
		for(int i=0; i< rowCount ; i++)
		{
			
			for(int j = 0 ; j<cellCount ;j++)
					{
					arrayExcelData[i][j] = sheet.getRow(i+1).getCell(j).toString();			
					}
		}
		
		return arrayExcelData;
	
		
	}

}
