package leetcode.com.qa;

import io.github.bonigarcia.wdm.ChromeDriverManager;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.walmart.qa.samsclub.omniture.constants.OmnitureConstants;
import com.walmart.qa.samsclub.omniture.utilities.ConsoleUtil;
import com.walmart.qa.samsclub.omniture.utilities.OmnitureActions;
import com.walmart.qa.samsclub.omniture.utilities.OmnitureExcelDataReader;

public class OmnitureTestSuites1 {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(OmnitureTestSuites1.class);
	protected SoftAssert softAssert;
	ArrayList<String> keyNamesList;
	private WebDriver webDriver = null;
	String baseURL = "https://major-qa-www.samsclub.com";
	DesiredCapabilities capabilities;
	ChromeOptions options;
	LoggingPreferences logPrefs;
	int totalSheets;
	ArrayList<String> actionList;
	File[] fList;
	List<Sheet> sList;
	
	@BeforeClass(enabled = false)
	public void ChromeDriverSetup(){
		LOGGER.info("Entering into ChromeDriverSetup");
		ChromeDriverManager.getInstance().setup();
	}

	@BeforeMethod
	public void beforeMethod() {
		LOGGER.info("Entering into beforeMethod");
//		keyNamesList = OmnitureExcelDataReader.getKeyNamesListFromExcel();
//		totalSheets = OmnitureExcelDataReader.getNumberOfSheets(file);
		capabilities = DesiredCapabilities.chrome();
		options = new ChromeOptions();
		logPrefs = new LoggingPreferences();
		options.addExtensions(new File("adobeanalyticsextension" + File.separator
				+ "Adobe-Analytics-Debugger_v1.3.crx"));
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		logPrefs.enable(LogType.BROWSER, Level.INFO);
		capabilities.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		webDriver = new ChromeDriver(capabilities);
		webDriver.get(baseURL);
		webDriver.manage().window().maximize();
	}

		
			
		@Test
		public void e2eCoventionalPurchaseShipOnlineOmniture2()
				throws InterruptedException, IOException {
			LOGGER.info("Entering into test e2eCoventionalPurchaseShipOnlineOmniture2");
			softAssert = new SoftAssert();
			
			 for (File file : fList){
				 LOGGER.info("-------------------------------------");
				 LOGGER.info("Entering the excel file: " + file);
				 for (Sheet sheet : sList){
					 LOGGER.info("-------------------------------------");
					 LOGGER.info("Entering sheet " + sheet.getSheetName());
					
					 // Getting KeyNames 
					 keyNamesList = OmnitureExcelDataReader.getKeyNamesListFromExcel(sheet, file);
				
					 //Action from Excel
					 executeActionsFromExcel(webDriver, sheet, file);
					
					 keyNamesList.clear();
					 LOGGER.info("Exiting from sheet " + sheet.getSheetName());
					 LOGGER.info("-------------------------------------");
					 
				 } //end of the for loop to iterate all sheets in workbook.
				 LOGGER.info("Exiting the excel file: " + file);
				 LOGGER.info("-------------------------------------");
			 }
			
			
			
			//assert all will conclude all the validation failed results after all sheets in workbook.
			softAssert.assertAll(); 
			
		}
	

		private void executeActionsFromExcel(WebDriver webDriver, Sheet sheet, File file) throws InterruptedException, IOException {
			actionList = OmnitureExcelDataReader.getActionsFromExcel(sheet, file);
			Map<String, String> dataMap; 		
			for(int i=0; i < actionList.size(); i++){
				switch (actionList.get(i)){
					case "loadBasePage":
						LOGGER.info("Entering step "+ (i+1));
						OmnitureActions.LoadBasePage(webDriver, i, sheet, file);
						dataMap = ConsoleUtil.getDataInfoV3(webDriver, i, sheet, file);
						redirectToDataValidation(dataMap, (i+1), sheet, file);
						break;
					case "Click":
						LOGGER.info("Entering step "+ (i+1));
						OmnitureActions.Click(webDriver, i, sheet, file);
						dataMap = ConsoleUtil.getDataInfoV3(webDriver, i, sheet, file);
						redirectToDataValidation(dataMap, (i+1), sheet, file);
						break;
					case "HoverorClick":
						LOGGER.info("Entering step "+ (i+1));
						OmnitureActions.HoverorClick(webDriver, i, sheet, file);
						dataMap = ConsoleUtil.getDataInfoV3(webDriver, i, sheet, file);
						redirectToDataValidation(dataMap, (i+1), sheet, file);
						break;
					case "SendKey":
						LOGGER.info("Entering step "+ (i+1));
						OmnitureActions.SendKey(webDriver, i, sheet, file);
						dataMap = ConsoleUtil.getDataInfoV3(webDriver, i, sheet, file);
						redirectToDataValidation(dataMap, (i+1), sheet, file);
						break;
					case "CheckBox":
						LOGGER.info("Entering step "+ (i+1));
						OmnitureActions.CheckBox(webDriver, i, sheet, file);
						dataMap = ConsoleUtil.getDataInfoV3(webDriver, i, sheet, file);
						redirectToDataValidation(dataMap, (i+1), sheet, file);
						break;
					case "KeyDown":
						LOGGER.info("Entering step "+ (i+1));
						OmnitureActions.KeyDown(webDriver, i, sheet, file);
						dataMap = ConsoleUtil.getDataInfoV3(webDriver, i, sheet, file);
						redirectToDataValidation(dataMap, (i+1), sheet, file);
						break;
				}
			}
			actionList.clear();
		}

	

	private Map<String, String> redirectToDataValidation(Map<String, String> dataMap1, int presentStep, Sheet sheet, File file) {
		
		LOGGER.info("Entering method to validate data for step " + presentStep + "--sheet--" + sheet.getSheetName() + "--excel file--" + file + "\n");
//		softAssert = new SoftAssert();
		if(dataMap1.isEmpty()){
	        LOGGER.error("data was null, but this is not allowed here at step " + presentStep + "--sheet--" + sheet.getSheetName() + "--excel file--" + file + "\n");
	        softAssert.assertNotNull(dataMap1, "data was null, but this is not allowed here at step " + presentStep + "--sheet--" + sheet.getSheetName() + "--excel file--" + file + "\n");
	        return Collections.emptyMap();
		  }
		String regexForEqualMatch = OmnitureConstants.regexForEqualMatch;
		String regexForContains = OmnitureConstants.regexForContains;
					 
		ArrayList<String> exceptedValuesforPresentStepList = OmnitureExcelDataReader.getExpectedValuesFromExcel(presentStep, sheet, file);
		
		for (int i =0; i< exceptedValuesforPresentStepList.size(); i++){
			if (dataMap1.get(keyNamesList.get(i)) == null && (exceptedValuesforPresentStepList.get(i) != null)){
				LOGGER.error(keyNamesList.get(i) +" is expected but not present for step " + presentStep + "--sheet--" + sheet.getSheetName() + "--excel file--" + file + "\n");
				softAssert.assertNotNull(dataMap1.get(keyNamesList.get(i)), keyNamesList.get(i) +" is expected but not present for step " + presentStep  + "--sheet--" + sheet.getSheetName() + "--excel file--" + file + "\n");
			}else if (keyNamesList.get(i).matches(regexForContains) && (exceptedValuesforPresentStepList.get(i) != null)){
				softAssert.assertTrue(dataMap1.get(keyNamesList.get(i)).matches(exceptedValuesforPresentStepList.get(i)), "Verification failed for " +keyNamesList.get(i)+" for step " + presentStep + "--sheet--" + sheet.getSheetName() + "--excel file--" + file + "\n");
			}else if (keyNamesList.get(i).matches(regexForEqualMatch) && (exceptedValuesforPresentStepList.get(i) != null)){
				softAssert.assertEquals(dataMap1.get(keyNamesList.get(i)), exceptedValuesforPresentStepList.get(i), "Verification failed for " +keyNamesList.get(i)+" for step " + presentStep + "--sheet--" + sheet.getSheetName() + "--excel file--" + file + "\n");
			}
		}
		
		exceptedValuesforPresentStepList.clear();
//		softAssert.assertAll();
		LOGGER.info("Data validation is done for step " + presentStep + "--sheet--" + sheet.getSheetName() +  "--excel file--" + file );
		return Collections.emptyMap();
	}
	
	@AfterMethod
	public void afterMethod() {
		webDriver.quit();
	}
}
