package leetcode.com.qa;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Nullable;

import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Predicate;
import com.walmart.qa.samsclub.omniture.constants.OmnitureConstants;



/**
 * Utility methods for omiture classes for getting data from Chrome-browser console.
 *
 * @author vn0u7yz(Umesh Khunt)
 *
 */
public class ConsoleUtil {
	 static String resultMessage;	
	 static String subString = "chrome-extension://bdingoflfadhnjohjaplginnpjeclmof/cs.js";
	 static String pageNameSubString = "Page Name          :";
	 static String siteSectionString = "Site Section       :";
	 static String eventsSubString = "Events             : ";
	 static String currentURLString = "Current URL";
	 static String productString = "Products           : " ;
	 static LogEntries logEntries;
	 static int serverCall = 0;
	 static String currentURLValue = null;	
	 static String previousPageURLValue = null;
	 static int serverCall1 = 0;
	 static String currentURLValue1 = null;	
	 static String previousPageURLValue1 = null;
	 static String pageName = null;
	 static String siteSection = null;
	 static String events = null;
	 static int product = 0;
	 static String products = null;
	 static String Products = null;
	 static String eventsOfProduct = null;
	 static String eVars = null;
	 static String eVar1 = null;
	 static String eVar2 = null;
	 static String eVar11 = null;
	 static String eVar19 = null;
	 static String eVar21 = null;
	 static String eVar35 = null;
	 static String eVar75 = null;
	 static String prop1 = null;
	 static String prop4 = null;
	 static String prop5 = null;
	 static String prop6 = null;
	 static String prop32 = null;
	 static String prop41 = null;
	 static String prop60 = null;
	 static boolean serverCallwithCurrentURL = true;
//	 static int step;
	 Map<String, String> mapData = new HashMap<String, String>();
	
	 private static final Logger          LOGGER = LoggerFactory.getLogger(ConsoleUtil.class);

	 public static Map<String, String> getDataInfoV3(WebDriver driver, int rowNum, Sheet sheet, File file) throws InterruptedException{
		 LOGGER.info("Entering into the getDataInfoV3 method");
		 int askedServerCall = Integer.valueOf(OmnitureExcelDataReader.excelDataReader("Server Call", rowNum, sheet, file));
		 waitForPageLoad1(driver);
		 Thread.sleep(2000);
		 logEntries = null;
		 logEntries = driver.manage().logs().get(LogType.BROWSER);
//		 printLogs(logEntries, rowNum+1);
		 return dataSortingFromLogV1(logEntries, askedServerCall, rowNum+1 );	
	 }
	 
	 private static Map<String, String> dataSortingFromLogV1(LogEntries logEntries1, int askedServerCall, int step) {
		 LOGGER.info("Entering into the method dataSortingFromLogV1 to save the logs for step "+ step);
		 String pageNameHolder = null;
		 String siteSectionHolder = null;
		 ArrayList<OmnitureProduct> productlist = null;
		 OmnitureProduct product1 = null;
		 ArrayList<String> logHolder=new ArrayList<String>();
		 Map<String, String> dataMap = new HashMap<String, String>();
		 for (LogEntry entry : logEntries1) { 
			 String logEntry = entry.getMessage();
			 if (logEntry.matches(OmnitureConstants.regexForDataValidationKeys) || logEntry.contains(productString)){
				 if (logEntry.contains(OmnitureConstants.adobeAnalyticsServerCall)){					 
					 logEntry = cutLogMesseage(logEntry);
					 logEntry = logEntry.substring(logEntry.indexOf("#")+1, logEntry.indexOf("#")+3).trim();
					 serverCall = Integer.valueOf(logEntry);
					 serverCallwithCurrentURL = false;
					 continue;
				 }else if(logEntry.contains(pageNameSubString)){
					 pageNameHolder = getValueFromLogEntry(logEntry);
					 logHolder.add(pageNameSubString +"          :" + pageNameHolder);					 
				 }else if (logEntry.contains(siteSectionString)){
					 siteSectionHolder = getValueFromLogEntry(logEntry);
					 logHolder.add(siteSectionString +"       :" + siteSectionHolder);					 
				 }else if(logEntry.contains(currentURLString)){					 
					 currentURLValue = logEntry;
					 if(currentURLValue.equals(previousPageURLValue) && serverCallwithCurrentURL){						 
						serverCall++;						
//						LOGGER.info("-------------------------------------");
//						LOGGER.info("Adobe Analytics Server Call #"+serverCall);
					 }else if (serverCallwithCurrentURL){
						previousPageURLValue = currentURLValue;
						serverCall = 1;
//						LOGGER.info("-------------------------------------");
//						LOGGER.info("Adobe Analytics Server Call #"+serverCall);							
					 }
					if (serverCall == askedServerCall){
						LOGGER.info("datamap debuging --->");
						for(String key : dataMap.keySet()){
							LOGGER.info( key +" : " +dataMap.get(key));
						}
						LOGGER.info("Clearing datamap as new server call matched");
						dataMap.clear();
						dataMap.put("Server Call", String.valueOf(serverCall));
						dataMap.put("Page Name", pageNameHolder);
						dataMap.put("Site Section", siteSectionHolder);
//						for(String backLog: logHolder){
//							LOGGER.info(backLog);
//						}
						logHolder.clear();					 
					 }else{				
						 logHolder.clear();
						 continue;
					 }
				 }else if(logEntry.contains(eventsSubString) && serverCall == askedServerCall){
							events = getValueFromLogEntry(logEntry); 
							dataMap.put("Events", events);
				 }else if(logEntry.contains(productString) && serverCall == askedServerCall){
					 Products = getValueFromLogEntry(logEntry, products);
					 LOGGER.info("Debugging LE***:" +Products);
				 	 dataMap.put("Products", Products);
					 /*if (!logEntry.contains("Events") && logEntry.contains("eVars")){
					 	Products = getValueFromLogEntry(logEntry, products);
				 		dataMap.put("Products", Products);
						product = getProductValue(logEntry);
						dataMap.put("Product", String.valueOf(product));							
					 }else if(logEntry.contains("Events") && logEntry.contains("eVars") && !logEntry.contains("Quantity   :") && !logEntry.contains("Price      :")){
						Products = getValueFromLogEntry(logEntry, products);
				 		dataMap.put("Products", Products);
			 			productlist = getProductValueList(logEntry);
			 			product1 = productlist.get(0);
			 			product = product1.product;
			 			dataMap.put("Product", String.valueOf(product));
			 			eventsOfProduct = product1.events;
			 			dataMap.put("Events Of Product", eventsOfProduct);
			 			eVars = product1.eVars;
			 			dataMap.put("eVars", eVars);				 			
				 	 }else if(logEntry.contains("Quantity   :") && logEntry.contains("Price      :")){
				 		Products = getValueFromLogEntry(logEntry, products);
				 		dataMap.put("Products", Products);				 		 
					 }*/
				 }else if(logEntry.contains("eVar1 ") && serverCall == askedServerCall){
			 			eVar1 = getValueFromLogEntry(logEntry); 
			 			dataMap.put("eVar1", eVar1);				 		
				 }else if(logEntry.contains("eVar2 ") && serverCall == askedServerCall){
			 			eVar2 = getValueFromLogEntry(logEntry); 
			 			dataMap.put("eVar2", eVar2);			 		
				 }else if(logEntry.contains("eVar11") && serverCall == askedServerCall){
			 			eVar11 = getValueFromLogEntry(logEntry); 
			 			dataMap.put("eVar11", eVar11);
				 }else if(logEntry.contains("eVar19") && serverCall == askedServerCall){
			 			eVar19 = getValueFromLogEntry(logEntry); 
			 			dataMap.put("eVar19", eVar19);
				 }else if(logEntry.contains("eVar21") && serverCall == askedServerCall){
			 			eVar21 = getValueFromLogEntry(logEntry); 
			 			dataMap.put("eVar21", eVar21);
				 }else if(logEntry.contains("eVar35") && serverCall == askedServerCall){
			 			eVar35 = getValueFromLogEntry(logEntry);
			 			dataMap.put("eVar35", eVar35);
				 }else if(logEntry.contains("eVar75") && serverCall == askedServerCall){
			 			eVar75 = getValueFromLogEntry(logEntry); 
			 			dataMap.put("eVar75", eVar75);
				 }else if(logEntry.contains("prop1 ") && serverCall == askedServerCall){
			 			prop1 = getValueFromLogEntry(logEntry);
			 			dataMap.put("prop1", prop1);
				 }else if(logEntry.contains("prop4 ") && serverCall == askedServerCall){
			 			prop4 = getValueFromLogEntry(logEntry); 
			 			dataMap.put("prop4", prop4);
				 }else if(logEntry.contains("prop5 ") && serverCall == askedServerCall){
			 			prop5 = getValueFromLogEntry(logEntry); 
			 			dataMap.put("prop5", prop5);
				 }else if(logEntry.contains("prop6 ") && serverCall == askedServerCall){
			 			prop6 = getValueFromLogEntry(logEntry);
			 			dataMap.put("prop6", prop6);
				 }else if(logEntry.contains("prop32") && serverCall == askedServerCall){
			 			prop32 = getValueFromLogEntry(logEntry);
			 			dataMap.put("prop32", prop32);
				 }else if(logEntry.contains("prop41") && serverCall == askedServerCall){
			 			prop41 = getValueFromLogEntry(logEntry); 
			 			dataMap.put("prop41", prop41);
				 }else if(logEntry.contains("prop60") && serverCall == askedServerCall){
			 			prop60 = getValueFromLogEntry(logEntry); 
			 			dataMap.put("prop60", prop60);
				 }
		 }
		}
	 return dataMap;
	 }

	 private static String getValueFromLogEntry(String logEntry) {
		logEntry = cutLogMesseage(logEntry);
		String[] arrayOflogEntry = logEntry.split(" : ");
		return arrayOflogEntry[1].trim();
	 }
	 
	 private static String getValueFromLogEntry(String logEntry, String products) {
			logEntry = cutLogMesseage(logEntry);
			logEntry = logEntry.replaceAll(OmnitureConstants.logEntryFilter8, "").trim();
			return logEntry.trim();
		 }

	 private static ArrayList<OmnitureProduct> getProductValueList(String logEntry) {
		 LOGGER.info("Entering into the getProductValueList method");
		ArrayList<OmnitureProduct> productList = new ArrayList<OmnitureProduct>();
		String productsMessage = cutLogMesseage(logEntry);
//		LOGGER.info("\"Products           : #" + productsMessage);
		List<String> al = Arrays.asList(productsMessage.split("#"));
		int counter = 0;
        for(String s: al){
        	counter ++;
        	String product = null;
        	String event = null;
        	String evars = null;
        	int indexCounter = 0;
        	for(int i = 0; i < s.length(); i++){
        		if(s.charAt(i) == ':'){
        			indexCounter++;
        			if(indexCounter == 1){
        				product = s.substring(i+1, s.indexOf("Events")).trim();
        			} 
        			else if (indexCounter == 2){
        				event = s.substring(i+1, s.indexOf("eVars")).trim();
        			} 
        			else if (indexCounter == 3){
        				evars = s.substring(i+1, s.length()).trim();
        			}
        		}
        	}
        	OmnitureProduct prod = new OmnitureProduct(Integer.valueOf(product),event,evars); 
        	productList.add(prod);
        }
		return productList;
	}

	 private static int getProductValue(String logEntry) {
		 LOGGER.info("Entering into the getProductValue method");
		logEntry = cutLogMesseage(logEntry);
		return Integer.valueOf(logEntry.substring(17, logEntry.indexOf("eVars")).trim());
	}

	 public static void printLogs(LogEntries logEntries, int step){
		 LOGGER.info("Entering into the method printLogs for step :" +step);
		 ArrayList<String> logHolder=new ArrayList<String>();
		 
			for (LogEntry entry : logEntries) {
				String logEntry = entry.getMessage();
				String log = cutLogMesseage(logEntry);						
				if(log.matches(OmnitureConstants.regexForLogHolder)){					
					logHolder.add(log);
				}else if(log.contains(currentURLString)){
					currentURLValue1 = entry.getMessage();
					if(currentURLValue1.equals(previousPageURLValue1)){
						serverCall1++;
						LOGGER.info("-------------------------------------");
						LOGGER.info("Adobe Analytics Server Call #"+serverCall1);
						LOGGER.info("-------------------------------------");
						for(String backLog: logHolder){
							LOGGER.info(backLog);
						}
						logHolder.clear();
						LOGGER.info(log);
					}else{
						previousPageURLValue1 = currentURLValue1;
						serverCall1 = 1;
						LOGGER.info("-------------------------------------");
						LOGGER.info("Adobe Analytics Server Call #"+serverCall1);
						LOGGER.info("-------------------------------------");
						for(String backLog: logHolder){
							LOGGER.info(backLog);
						}
						logHolder.clear();
						LOGGER.info(log);
					}
				}else if(!log.matches(OmnitureConstants.regexForLogFilter)) {
					LOGGER.info(log);
				}
			}			
	 }
			
	 
	 private static String cutLogMesseage(String logEntry) {	
		logEntry = logEntry.replaceAll(OmnitureConstants.logEntryFilter1, "").trim();
		logEntry = logEntry.replaceAll(OmnitureConstants.logEntryFilter2, "").trim();
		logEntry = logEntry.replaceAll(OmnitureConstants.logEntryFilter3, "").trim();
		logEntry = logEntry.replaceAll(OmnitureConstants.logEntryFilter4, "").trim();
		logEntry = logEntry.replaceAll(OmnitureConstants.logEntryFilter5, "").trim();
		logEntry = logEntry.replaceAll(OmnitureConstants.logEntryFilter6, "").trim();
		logEntry = logEntry.replaceAll(OmnitureConstants.logEntryFilter7, "").trim();
		return logEntry;
	}

	public static void waitForPageLoad1(WebDriver driver) {
			try {
				new WebDriverWait(driver,
						OmnitureConstants.PAGE_LOAD_TIMEOUT_IN_SECONDS)
						.until(new Predicate<WebDriver>() {
							@Override
							public boolean apply(@Nullable WebDriver input) {
								if (input == null) {
									return false;
								}
								Object resp = ((JavascriptExecutor) input)
										.executeScript("return document.readyState=='complete'");
								if (resp instanceof Boolean && ((Boolean) resp)) {
									return true;
								}
								return false;
							}
						});
			} catch (Exception e) {
				LOGGER.warn("Exception waiting for page to load: {}", e);
				LOGGER.info("Exiting Method waitForPageLoad");
			}
		}
	 	 
}
