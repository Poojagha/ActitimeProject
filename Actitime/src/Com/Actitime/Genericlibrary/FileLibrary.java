package Com.Actitime.Genericlibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileLibrary {
	
	/**
	 * This method is a non static which is use to read the data from property file
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String readDataFromProperty(String key) throws IOException {
		FileInputStream fis=new FileInputStream("./TestData/commondata.propery");
		Properties p=new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;
		
		
	}
	/**
	 * this method is non static method which is use to read the data from excel sheet
	 * @param sheetname
	 * @param row
	 * @param cell
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	public String readDataFromExcelFile(String sheetname,int row,int cell) throws EncryptedDocumentException, IOException {
		FileInputStream fis1=new FileInputStream("./TestData/ActitimeTestdata.xlsx");
				Workbook wb = WorkbookFactory.create(fis1);
				String value = wb.getSheet(sheetname).getRow(row).getCell(cell).getStringCellValue();
				return value;
	}

}
