package utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Parameterisation {
	

	public static String getSheetExcel(String sheetName, int row, int cell) throws EncryptedDocumentException, IOException
	{
		FileInputStream FIS=new FileInputStream("E:\\eclipse_workspace\\Naaptol\\src\\main\\resources\\Naptol_Excel.xlsx");
	
	String value=WorkbookFactory.create(FIS).getSheet(sheetName).getRow(row).getCell(cell).getStringCellValue();
	
	return value;
	}


}
