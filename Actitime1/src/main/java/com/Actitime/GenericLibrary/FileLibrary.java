package com.Actitime.GenericLibrary;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileLibrary {
	/**
	 * this method is a generic method used to read data from property file
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String getPropertydata(String key) throws IOException {
		//FileInputStream fis = new FileInputStream("./TestData/commondata1.property");
		FileInputStream fis = new FileInputStream("./TestData/acttime.property");
		Properties p = new Properties();
		p.load(fis);
		String data = p.getProperty(key);
		return data;
	}
	/**
	 * this method is a generic method used to read data from excel file.
	 * @param sheet
	 * @param row
	 * @param cell
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String getExcelData(String sheet, int row, int cell) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./TestData/Testdata1.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
		return data;	
	}
				


}
