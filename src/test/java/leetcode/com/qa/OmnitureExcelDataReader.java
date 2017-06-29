package leetcode.com.qa;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Color;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.walmart.qa.samsclub.omniture.constants.OmnitureConstants;

public class OmnitureExcelDataReader {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(OmnitureExcelDataReader.class);
	
	public static final boolean OMNITURE = true;
//	public static final String KEYNAMES = getExpectedValuesFromExcel(3);
	public static int SheetNumber = 0;
	
	//color coding
	public static final String orange = "FFFFC000";
	
	static int presentRowNum = 1;	
	public static final ArrayList<String> keyNamesList = new ArrayList<String>();
	public static ArrayList<String> exceptedValuesforPresentStepList = new ArrayList<String>();
	public static final ArrayList<String> actionList = new ArrayList<String>();
	
//	public static String excelFilePath2 = "src\\test\\resources\\data\\mqa\\ui\\CartAndCheckoutEndToEndTestData\\QA-Adobe-Regression 3.2.xlsx";
	public static String excelFilePath;
	public static String excelFilePath3 = "src"+File.separator+"test"+File.separator+"resources"+File.separator+"data"+File.separator+"mqa"+File.separator+"ui"+File.separator+"CartAndCheckoutEndToEndTestData"+File.separator+"QA-Adobe-Regression 3.3.xlsx";
	public static FileInputStream fis = null;
	
	public static int getNumberOfSheets(File file){
		LOGGER.info("Entering Method getNumberOfSheets");
		int totalSheets = 0;
		try{
			fis = new FileInputStream(file);
			// Using XSSF for xlsx format, for xls use HSSF
            Workbook workbook = new XSSFWorkbook(fis);
            totalSheets = workbook.getNumberOfSheets();
            for (int sheet=0; sheet < totalSheets; sheet++){
            	LOGGER.info(workbook.getSheetName(sheet));
            }
            
		}catch (FileNotFoundException e) {
			e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
		return totalSheets;
	}
	public static List<Sheet> getNamesOfSheets(File file){
		LOGGER.info("Entering Method getNumberOfSheets");
		int totalSheets = 0;
		List<Sheet> sList = new ArrayList<Sheet>();
		try{
			fis = new FileInputStream(file);
			// Using XSSF for xlsx format, for xls use HSSF
            Workbook workbook = new XSSFWorkbook(fis);
            totalSheets = workbook.getNumberOfSheets();
            for (int sheetIndex=0; sheetIndex < totalSheets; sheetIndex++){
            	LOGGER.info(workbook.getSheetName(sheetIndex));
            	sList.add(workbook.getSheetAt(sheetIndex));
            }
            
		}catch (FileNotFoundException e) {
			e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
		return sList;
	}
	
	public static ArrayList<String> getKeyNamesListFromExcel(Sheet sheet, File file) {
		LOGGER.info("Entering Method getKeyNamesListFromExcel");
		int rowNum = 0;
		try{
			fis = new FileInputStream(file);
			// Using XSSF for xlsx format, for xls use HSSF
            Workbook workbook = new XSSFWorkbook(fis);           
            Row row = sheet.getRow(rowNum);
            Iterator<Cell> cellIterator = row.cellIterator();
            while (cellIterator.hasNext()) {
            	Cell cell = cellIterator.next();
            	if (cell.getColumnIndex() < 7 ){
            		continue;
            	}else{
            	keyNamesList.add(cell.getStringCellValue());
            	}
//            	if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {            		
//            		keyNamesList.add(String.valueOf(cell.getNumericCellValue()));
//                } else if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
//                	keyNamesList.add(cell.getStringCellValue());
//                }else if (cell.getCellType() == Cell.CELL_TYPE_FORMULA && cell.getCachedFormulaResultType() == Cell.CELL_TYPE_STRING) {
//                	keyNamesList.add(cell.getStringCellValue());
//                }
            }
		}catch (FileNotFoundException e) {
			e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
		LOGGER.info("Exiting Method getKeyNamesListFromExcel");
		return keyNamesList;
	}
	
	
	public static ArrayList<String> getExpectedValuesFromExcel(int rowNum, Sheet sheet, File file) {
		LOGGER.info("Entering Method getExpectedValuesFromExcel");
//		rowNum = rowNum+3;
		try{
			fis = new FileInputStream(file);
			// Using XSSF for xlsx format, for xls use HSSF
            Workbook workbook = new XSSFWorkbook(fis);
            Row row = sheet.getRow(rowNum);
            Iterator<Cell> cellIterator = row.cellIterator();
            while (cellIterator.hasNext()) {
            	Cell cell = cellIterator.next();
            	if (cell.getColumnIndex() < 7 ){
            		continue;
            	}else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
            		exceptedValuesforPresentStepList.add(String.valueOf((int)cell.getNumericCellValue()));
                } else if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
                	exceptedValuesforPresentStepList.add(cell.getStringCellValue());
                } else if (cell.getCellType() == Cell.CELL_TYPE_BLANK) {
                	exceptedValuesforPresentStepList.add(null);
                }else if (cell.getCellType() == Cell.CELL_TYPE_FORMULA && cell.getCachedFormulaResultType() == Cell.CELL_TYPE_NUMERIC) {
                	if((int)cell.getNumericCellValue() != 0){
                		exceptedValuesforPresentStepList.add(String.valueOf((int)cell.getNumericCellValue()));
                	}else{
                		exceptedValuesforPresentStepList.add(null);
                	} 	
                }else if (cell.getCellType() == Cell.CELL_TYPE_FORMULA && cell.getCachedFormulaResultType() == Cell.CELL_TYPE_STRING) {
                	exceptedValuesforPresentStepList.add(cell.getStringCellValue());
                }
            }

		}catch (FileNotFoundException e) {
			e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		
		return exceptedValuesforPresentStepList;
	}
	
	public static ArrayList<String> getActionsFromExcel(Sheet sheet, File file) {
		LOGGER.info("Entering Method getActionsFromExcel");
		try{
			fis = new FileInputStream(file);
			// Using XSSF for xlsx format, for xls use HSSF
            Workbook workbook = new XSSFWorkbook(fis);
            Iterator<Row> rowIterator = sheet.rowIterator();
            while(rowIterator.hasNext()){
            	Row row = rowIterator.next();
            	Cell cellAction = row.getCell(3);
            	CellStyle style = cellAction.getCellStyle();
            	Color color = style.getFillForegroundColorColor();
            	if (renderColor(color).equals(orange)){
            		break;            		
            	}else if (cellAction == null || cellAction.getRowIndex() < 1 || cellAction.getCellType() == Cell.CELL_TYPE_BLANK){
            		continue;
            	}/*else if (cellAction.getRowIndex() < 4){
            		LOGGER.info("Row index :" + cellAction.getRowIndex());
            		continue;
            	}*/else if (cellAction.getCellType() == Cell.CELL_TYPE_STRING){
            		actionList.add(cellAction.getStringCellValue());
            	} else 	if (cellAction.getCellType() == Cell.CELL_TYPE_FORMULA && cellAction.getCachedFormulaResultType() == Cell.CELL_TYPE_STRING) {
            		actionList.add(cellAction.getStringCellValue());
            	}else{
            		System.out.println("Delet the empty cells");
            	}
            }
		}catch (FileNotFoundException e) {
			e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }		
		return actionList;
	}

	public static String excelDataReader(String columName, int rowNum, Sheet sheet, File file) {
		LOGGER.info("Entering Method excelDataReader for :" + columName);
		rowNum = rowNum+1;
		String cellData = null;
		Cell cellAction;
		try{
			fis = new FileInputStream(file);
			// Using XSSF for xlsx format, for xls use HSSF
            Workbook workbook = new XSSFWorkbook(fis); 
            Row row = sheet.getRow(rowNum);
            switch(columName){
            case "Server Call":
            	cellAction = row.getCell(7);
            	int  cellDataInt = (int)cellAction.getNumericCellValue();
            	return String.valueOf(cellDataInt);
            case "Element Type":
            	cellAction = row.getCell(6);
                return cellAction.getStringCellValue();
            case "Values":
            	cellAction = row.getCell(5);
                return cellAction.getStringCellValue();
            case "Element":
            	cellAction = row.getCell(4);
                return cellAction.getStringCellValue();
            case "Action":
            	cellAction = row.getCell(3);
                return cellAction.getStringCellValue();
            }
              
		}catch (FileNotFoundException e) {
			e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
		return cellData;
	}

	private static String renderColor(Color color) {
	       if(color instanceof HSSFColor) {
	          return ((HSSFColor)color).getHexString();
	       } else if(color instanceof XSSFColor) {
	          return ((XSSFColor)color).getARGBHex();
	       } else {
	          return "(none)";
	       }
	    }
}
