package leetcode.com.qa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Nullable;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Predicate;
import com.walmart.qa.samsclub.constants.UITestConstants;


public class ConsoleUtilitiesOld {

	 static String resultMessage;	
	 static String subString = "chrome-extension://bdingoflfadhnjohjaplginnpjeclmof/cs.js";
	 static String pageNameSubString = "\"Page Name";
	 static String siteSectionString = "\"Site Section";
	 static String eventsSubString = "\"Events";
	 static String currentURLString = "Current URL";
	 static String productString = "Products" ;
	 static LogEntries logEntries;
	 static String currentURLValue = null;	
	 static String previousPageURLValue = null;
	 static int serverCall = 0;
	 static String pageName = null;
	 static String siteSection = null;
	 static String events = null;
	 static int product = 0;
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
	 static OmnitureData data;
	 Map<String, String> mapData = new HashMap<String, String>();
	
	 private static final Logger          LOGGER = LoggerFactory.getLogger(ConsoleUtilitiesOld.class);
//	 protected static UIConnector uiConnector;
	 public static String getLogs(WebDriver driver) throws InterruptedException {
			Thread.sleep(3000);
			logEntries = driver.manage().logs().get(LogType.BROWSER);
			Map<String, String> map = new HashMap<String, String>();
			for (LogEntry entry : logEntries) {            
				String message = entry.getMessage();
				
			//Adobe Analytics Server Call #
			if (message.contains(currentURLString)){
				currentURLValue = message;
				if(currentURLValue.equals(previousPageURLValue)){
					serverCall++;
					LOGGER.info("Adobe Analytics Server Call #"+serverCall);
				} else{
					previousPageURLValue = currentURLValue;
					serverCall = 1;
					LOGGER.info("Adobe Analytics Server Call #"+serverCall);
				}	
			}
				
			int startIndexOfValue = 0;	
			int startIndexOfKey = 0;
			int EndingIndexOfValue = 0;
			if ((message.contains("\"")) && (message.contains(subString)) && (message.contains(pageNameSubString))){
				LOGGER.info(entry.getMessage());
				int counter = 0;
				
				for (int i = 0; i < message.length(); i++){
					if(message.charAt(i) == '"'){
						counter ++;
//							if (counter == 1 ){
//								startIndexOfKey = i;
//							}
						if (counter == 2 ){
							EndingIndexOfValue = i;
						}								
					}
								
					
				}
				
				if (message.contains(": ")){
					startIndexOfValue = message.indexOf(": ");
				int counter1= 0;
//					startIndexOfKey = 0;
	            if(message != null){
	                for(int i1 = 0; i1 < message.length(); i1++){
	                    if(message.charAt(i1) == ' '){
	                     counter1 ++;
	                     if (counter1 == 2 ){
	                    	 startIndexOfKey = i1;                     
	                     }
	                    }  
	                }
	           
	            }
	            String valueOfmessage = message.substring(startIndexOfValue+2, EndingIndexOfValue);
				String keyOfMessage = message.substring(startIndexOfKey + 2 , startIndexOfValue);
				map.put(keyOfMessage.trim(), valueOfmessage.trim());
				resultMessage = map.get("Page Name"); 
				}
			}				
       }
		return resultMessage;
		//clear the console logs
		}
	 
	 // Method to handle products values.
	 
	 public static void getProductInfo(WebDriver driver) throws InterruptedException{
		    logEntries = null;
			Thread.sleep(3000);
			logEntries = driver.manage().logs().get(LogType.BROWSER);
			for (LogEntry entry : logEntries) {    
				String productsMessage = entry.getMessage();
				
				//Adobe Analytics Server Call #
				if (productsMessage.contains(currentURLString)){
					currentURLValue = productsMessage;
					if(currentURLValue.equals(previousPageURLValue)){
						serverCall++;
						LOGGER.info("Adobe Analytics Server Call #"+serverCall);
					} else{
						previousPageURLValue = currentURLValue;
						serverCall = 1;
						LOGGER.info("Adobe Analytics Server Call #"+serverCall);
					}	
				}
				
				String subString = "Products" ;
				if (productsMessage.contains(subString)){
					LOGGER.info(productsMessage);
//					ArrayList<String> items = (ArrayList)Arrays.asList(productsMessage.split(":"));
					List<String> items = Arrays.asList(productsMessage.split("\\s*:\\*"));
				       for(String str : items)
				       {
				           LOGGER.info(str);
				       }
				}				
			}		 
		LOGGER.info("Returning from method"); 
	 }
	 
	 public static ArrayList<OmnitureProduct> getProductInfoV1(WebDriver driver) throws InterruptedException{	
		  Thread.sleep(2000);
		  LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
		  ArrayList<OmnitureProduct> productList = new ArrayList<OmnitureProduct>();
			for (LogEntry entry : logEntries) {    
				String productsMessage = entry.getMessage();
				if (productsMessage.contains(productString)){
					productsMessage = productsMessage.replaceAll("\\\\n", "");
					LOGGER.info(productsMessage);
					productsMessage = productsMessage.replaceFirst("chrome-extension://bdingoflfadhnjohjaplginnpjeclmof/cs.js 59:12 \"Products           :     #", "");
					LOGGER.info(productsMessage);
					List<String> al = Arrays.asList(productsMessage.split("#"));
					int counter = 0;
			        for(String s: al){
//				        	LOGGER.info(s);
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
			        LOGGER.info("Total number of products: " + productList.size());
				}	
			}
		return productList;
	 }

	 
	 
	 public static OmnitureData getDataInfoV1(WebDriver driver, int askedServerCall) throws InterruptedException{
		 Thread.sleep(3000);
		 logEntries = driver.manage().logs().get(LogType.BROWSER);
		 for (LogEntry entry : logEntries) { 
			 String logEntry = entry.getMessage();
			 LOGGER.info(logEntry);
			if (logEntry.contains(pageNameSubString) || logEntry.contains(currentURLString) || logEntry.contains(eventsSubString) || logEntry.contains(productString)){

			//PageName				
			if (logEntry.contains(pageNameSubString)){
				LOGGER.info(logEntry);
				logEntry = logEntry.replaceFirst("chrome-extension://bdingoflfadhnjohjaplginnpjeclmof/cs.js 59:12 \"Page Name          :", "");
				pageName = logEntry.substring(1, logEntry.indexOf("\"")).trim();
			}
			
		    //Adobe Analytics Server Call #
			else if (logEntry.contains(currentURLString) && askedServerCall != serverCall){
				currentURLValue = logEntry;
				LOGGER.info(logEntry);
				if(currentURLValue.equals(previousPageURLValue)){
					serverCall++;
					LOGGER.info("Adobe Analytics Server Call #"+serverCall);
				} else{
					previousPageURLValue = currentURLValue;
					serverCall = 1;
					LOGGER.info("Adobe Analytics Server Call #"+serverCall);
				}	
			 }
			
			//events	
			if (serverCall == askedServerCall && logEntry.contains(eventsSubString)){
					logEntry = logEntry.replaceFirst("chrome-extension://bdingoflfadhnjohjaplginnpjeclmof/cs.js 59:12 \"Events             :", "");
					events = logEntry.substring(1, logEntry.indexOf("\"")).trim();
				}
									
			//Product
			if(serverCall == askedServerCall && logEntry.contains(productString)){
					logEntry = logEntry.replaceAll("\\\\n", "");
					LOGGER.info(logEntry);
					logEntry = logEntry.replaceFirst("chrome-extension://bdingoflfadhnjohjaplginnpjeclmof/cs.js 59:12 \"Products           :     #", "");
					LOGGER.info(logEntry);
					if(!logEntry.contains("Events") && logEntry.contains("eVars")){
						product = Integer.valueOf(logEntry.substring(17, logEntry.indexOf("eVars")).trim());
					}	        			 		       
				} 	
			data  = new OmnitureData(serverCall, pageName, null, events, product, eventsOfProduct, eVars, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
			}
		}		 
		return data;			 
	 }
	 
	 public static OmnitureData getDataInfoV2(WebDriver driver, int askedServerCall) throws InterruptedException{
		 waitForPageLoad1(driver);
//		 Thread.sleep(3000);
		 logEntries = driver.manage().logs().get(LogType.BROWSER);
//		 printLogs(logEntries);
		 return dataSortingFromLogV0(logEntries, askedServerCall);
	 }
	 public static Map<String, String> getDataInfoV3(WebDriver driver, int askedServerCall) throws InterruptedException{
		 waitForPageLoad1(driver);
		 LogEntries logEntries1 = driver.manage().logs().get(LogType.BROWSER);
		 printLogs(logEntries1);
		 return dataSortingFromLogV1(logEntries1, askedServerCall);	
	 }
	 
	 private static Map<String, String> dataSortingFromLogV1(LogEntries logEntries1, int askedServerCall) {
		 String pageNameHolder = null;
		 String siteSectionHolder = null;
		 ArrayList<OmnitureProduct> productlist = null;
		 OmnitureProduct product1 = null;
		 ArrayList<String> logHolder=new ArrayList<String>();
		 Map<String, String> dataMap = new HashMap<String, String>();

		 for (LogEntry entry : logEntries1) { 
			 String logEntry = entry.getMessage();			 
			 if ( logEntry.contains(siteSectionString)|| logEntry.contains(pageNameSubString) || logEntry.contains(currentURLString) || logEntry.contains(eventsSubString) || logEntry.contains(productString)||
					 logEntry.contains("eVar1 ")||logEntry.contains("eVar2 ")||logEntry.contains("eVar11")||logEntry.contains("eVar19")||logEntry.contains("eVar21")||logEntry.contains("eVar35")||logEntry.contains("eVar75")||
					 logEntry.contains("prop1 ")||logEntry.contains("prop4 ")||logEntry.contains("prop5 ")||logEntry.contains("prop6 ")||logEntry.contains("prop32")||logEntry.contains("prop41")||logEntry.contains("prop60")){
				 if (logEntry.contains(pageNameSubString)){
					 logEntry = logEntry.replaceFirst("chrome-extension://bdingoflfadhnjohjaplginnpjeclmof/cs.js 59:12 \"Page Name          :", "");
					 pageNameHolder = logEntry.substring(1, logEntry.indexOf("\"")).trim();
					 logHolder.add(pageNameSubString +"          :" +logEntry);					 
				 }else if (logEntry.contains(siteSectionString)){
					 logEntry = logEntry.replaceFirst("chrome-extension://bdingoflfadhnjohjaplginnpjeclmof/cs.js 59:12 \"Site Section       :", "");
					 siteSectionHolder = logEntry.substring(1, logEntry.indexOf("\"")).trim();
					 logHolder.add(siteSectionString +"       :" + logEntry);					 
				 }else if(logEntry.contains(currentURLString)){					 
					 currentURLValue = logEntry;
					 if(currentURLValue.equals(previousPageURLValue)){
						serverCall++;
						LOGGER.info("-------------------------------------");
						LOGGER.info("Adobe Analytics Server Call #"+serverCall);
					 }else{
						previousPageURLValue = currentURLValue;
						serverCall = 1;
						LOGGER.info("-------------------------------------");
						LOGGER.info("Adobe Analytics Server Call #"+serverCall);							
					 }
					if (serverCall == askedServerCall){
						dataMap.clear();
						dataMap.put("Server Call", String.valueOf(serverCall));
						dataMap.put("Page Name", pageNameHolder);
						dataMap.put("Site Section", siteSectionHolder);
						for(String backLog: logHolder){
							LOGGER.info(backLog);
						}
						logHolder.clear();					 
					 }else{				
						 logHolder.clear();
						 continue;
					 }
				 }else if(logEntry.contains(eventsSubString) && serverCall == askedServerCall){
							events = getValueFromLogEntry(logEntry); 
							dataMap.put("Events", events);
				 }else if(logEntry.contains(productString) && serverCall == askedServerCall){
					 if (!logEntry.contains("Events") && logEntry.contains("eVars")){
							product = getProductValue(logEntry);
							dataMap.put("Product", String.valueOf(product));
							}
					 else if(logEntry.contains("Events") && logEntry.contains("eVars") && !logEntry.contains("Quantity   :") && !logEntry.contains("Price      :")){
				 			productlist = getProductValueList(logEntry);
				 			product1 = productlist.get(0);
				 			product = product1.product;
				 			dataMap.put("Product", String.valueOf(product));
				 			eventsOfProduct = product1.events;
				 			dataMap.put("Events Of Product", eventsOfProduct);
				 			eVars = product1.eVars;
				 			dataMap.put("eVars", eVars);				 			
				 			}
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

	 private static OmnitureData dataSortingFromLogV0(LogEntries logEntries2, int askedServerCall) {
		 String pageNameHolder = null;
		 String siteSectionHolder = null;
		 ArrayList<OmnitureProduct> productlist = null;
		 OmnitureProduct product1 = null;
		 ArrayList<String> logHolder=new ArrayList<String>();
		 data = null;

		 for (LogEntry entry : logEntries) { 
			 String logEntry = entry.getMessage();			 
			 if ( logEntry.contains(siteSectionString)|| logEntry.contains(pageNameSubString) || logEntry.contains(currentURLString) || logEntry.contains(eventsSubString) || logEntry.contains(productString)||
					 logEntry.contains("eVar1 ")||logEntry.contains("eVar2 ")||logEntry.contains("eVar11")||logEntry.contains("eVar19")||logEntry.contains("eVar21")||logEntry.contains("eVar35")||logEntry.contains("eVar75")||
					 logEntry.contains("prop1 ")||logEntry.contains("prop4 ")||logEntry.contains("prop5 ")||logEntry.contains("prop6 ")||logEntry.contains("prop32")||logEntry.contains("prop41")||logEntry.contains("prop60")){
				 if (logEntry.contains(pageNameSubString)){
					 logEntry = logEntry.replaceFirst("chrome-extension://bdingoflfadhnjohjaplginnpjeclmof/cs.js 59:12 \"Page Name          :", "");
					 pageNameHolder = logEntry.substring(1, logEntry.indexOf("\"")).trim();
					 logHolder.add(pageNameSubString +"          : " +logEntry);
				 }else if (logEntry.contains(siteSectionString)){
					 logEntry = logEntry.replaceFirst("chrome-extension://bdingoflfadhnjohjaplginnpjeclmof/cs.js 59:12 \"Site Section       :", "");
					 siteSectionHolder = logEntry.substring(1, logEntry.indexOf("\"")).trim();
					 logHolder.add(siteSectionString +"       : " + logEntry);
				 }else if(logEntry.contains(currentURLString)){					 
					 currentURLValue = logEntry;
					 if(currentURLValue.equals(previousPageURLValue)){
						serverCall++;
						LOGGER.info("-------------------------------------");
						LOGGER.info("Adobe Analytics Server Call #"+serverCall);
					 }else{
						previousPageURLValue = currentURLValue;
						serverCall = 1;
						LOGGER.info("-------------------------------------");
						LOGGER.info("Adobe Analytics Server Call #"+serverCall);							
					 }
					if (serverCall == askedServerCall){
						pageName = pageNameHolder;
						siteSection = siteSectionHolder;
						data  = new OmnitureData(serverCall, pageName, siteSection, events, product, eventsOfProduct, 
			 					eVars, eVar1, eVar2, eVar11, eVar19, eVar21, eVar35, 
								eVar75, prop1, prop4, prop5, prop6, prop32, prop41, prop60);
						for(String backLog: logHolder){
							LOGGER.info(backLog);
						}
						logHolder.clear();					 
					 }else{
						 logHolder.clear();
						 continue;
					 }
				 }else if(logEntry.contains(eventsSubString) && serverCall == askedServerCall){
							events = getValueFromLogEntry(logEntry); 
							data  = new OmnitureData(serverCall, pageName, siteSection, events, product, eventsOfProduct, 
				 					eVars, eVar1, eVar2, eVar11, eVar19, eVar21, eVar35, 
									eVar75, prop1, prop4, prop5, prop6, prop32, prop41, prop60);
				 }else if(logEntry.contains(productString) && serverCall == askedServerCall){
					 if (!logEntry.contains("Events") && logEntry.contains("eVars")){
							product = Integer.valueOf(getProductValue(logEntry));
							data  = new OmnitureData(serverCall, pageName, siteSection, events, product, eventsOfProduct, 
				 					eVars, eVar1, eVar2, eVar11, eVar19, eVar21, eVar35, 
									eVar75, prop1, prop4, prop5, prop6, prop32, prop41, prop60);
							}
					 else if(logEntry.contains("Events") && logEntry.contains("eVars") && !logEntry.contains("Quantity   :") && !logEntry.contains("Price      :")){
				 			productlist = getProductValueList(logEntry);
				 			product1 = productlist.get(0);
				 			product = product1.product;
				 			eventsOfProduct = product1.events;
				 			eVars = product1.eVars;
				 			data  = new OmnitureData(serverCall, pageName, siteSection, events, product, eventsOfProduct, 
				 					eVars, eVar1, eVar2, eVar11, eVar19, eVar21, eVar35, 
									eVar75, prop1, prop4, prop5, prop6, prop32, prop41, prop60);
				 			}
				 }else if(logEntry.contains("eVar1 ") && serverCall == askedServerCall){
			 			eVar1 = getValueFromLogEntry(logEntry); 
			 			data  = new OmnitureData(serverCall, pageName, siteSection, events, product, eventsOfProduct, 
			 					eVars, eVar1, eVar2, eVar11, eVar19, eVar21, eVar35, 
								eVar75, prop1, prop4, prop5, prop6, prop32, prop41, prop60);				 		
				 }else if(logEntry.contains("eVar2 ") && serverCall == askedServerCall){
			 			eVar2 = getValueFromLogEntry(logEntry); 
			 			data  = new OmnitureData(serverCall, pageName, siteSection, events, product, eventsOfProduct, 
			 					eVars, eVar1, eVar2, eVar11, eVar19, eVar21, eVar35, 
								eVar75, prop1, prop4, prop5, prop6, prop32, prop41, prop60);				 		
				 }else if(logEntry.contains("eVar11") && serverCall == askedServerCall){
			 			eVar11 = getValueFromLogEntry(logEntry); 
			 			data  = new OmnitureData(serverCall, pageName, siteSection, events, product, eventsOfProduct, 
			 					eVars, eVar1, eVar2, eVar11, eVar19, eVar21, eVar35, 
								eVar75, prop1, prop4, prop5, prop6, prop32, prop41, prop60);
				 }else if(logEntry.contains("eVar19") && serverCall == askedServerCall){
			 			eVar19 = getValueFromLogEntry(logEntry); 
			 			data  = new OmnitureData(serverCall, pageName, siteSection, events, product, eventsOfProduct, 
			 					eVars, eVar1, eVar2, eVar11, eVar19, eVar21, eVar35, 
								eVar75, prop1, prop4, prop5, prop6, prop32, prop41, prop60);
				 }else if(logEntry.contains("eVar21") && serverCall == askedServerCall){
			 			eVar21 = getValueFromLogEntry(logEntry); 
			 			data  = new OmnitureData(serverCall, pageName, siteSection, events, product, eventsOfProduct, 
			 					eVars, eVar1, eVar2, eVar11, eVar19, eVar21, eVar35, 
								eVar75, prop1, prop4, prop5, prop6, prop32, prop41, prop60);
				 }else if(logEntry.contains("eVar35") && serverCall == askedServerCall){
			 			eVar35 = getValueFromLogEntry(logEntry);
			 			data  = new OmnitureData(serverCall, pageName, siteSection, events, product, eventsOfProduct, 
			 					eVars, eVar1, eVar2, eVar11, eVar19, eVar21, eVar35, 
								eVar75, prop1, prop4, prop5, prop6, prop32, prop41, prop60);
				 }else if(logEntry.contains("eVar75") && serverCall == askedServerCall){
			 			eVar75 = getValueFromLogEntry(logEntry); 
			 			data  = new OmnitureData(serverCall, pageName, siteSection, events, product, eventsOfProduct, 
			 					eVars, eVar1, eVar2, eVar11, eVar19, eVar21, eVar35, 
								eVar75, prop1, prop4, prop5, prop6, prop32, prop41, prop60);
				 }else if(logEntry.contains("prop1 ") && serverCall == askedServerCall){
			 			prop1 = getValueFromLogEntry(logEntry);
			 			data  = new OmnitureData(serverCall, pageName, siteSection, events, product, eventsOfProduct, 
			 					eVars, eVar1, eVar2, eVar11, eVar19, eVar21, eVar35, 
								eVar75, prop1, prop4, prop5, prop6, prop32, prop41, prop60);
				 }else if(logEntry.contains("prop4 ") && serverCall == askedServerCall){
			 			prop4 = getValueFromLogEntry(logEntry); 
			 			data  = new OmnitureData(serverCall, pageName, siteSection, events, product, eventsOfProduct, 
			 					eVars, eVar1, eVar2, eVar11, eVar19, eVar21, eVar35, 
								eVar75, prop1, prop4, prop5, prop6, prop32, prop41, prop60);
				 }else if(logEntry.contains("prop5 ") && serverCall == askedServerCall){
			 			prop5 = getValueFromLogEntry(logEntry); 
			 			data  = new OmnitureData(serverCall, pageName, siteSection, events, product, eventsOfProduct, 
			 					eVars, eVar1, eVar2, eVar11, eVar19, eVar21, eVar35, 
								eVar75, prop1, prop4, prop5, prop6, prop32, prop41, prop60);
				 }else if(logEntry.contains("prop6 ") && serverCall == askedServerCall){
			 			prop6 = getValueFromLogEntry(logEntry);
			 			data  = new OmnitureData(serverCall, pageName, siteSection, events, product, eventsOfProduct, 
			 					eVars, eVar1, eVar2, eVar11, eVar19, eVar21, eVar35, 
								eVar75, prop1, prop4, prop5, prop6, prop32, prop41, prop60);
				 }else if(logEntry.contains("prop32") && serverCall == askedServerCall){
			 			prop32 = getValueFromLogEntry(logEntry);
			 			data  = new OmnitureData(serverCall, pageName, siteSection, events, product, eventsOfProduct, 
			 					eVars, eVar1, eVar2, eVar11, eVar19, eVar21, eVar35, 
								eVar75, prop1, prop4, prop5, prop6, prop32, prop41, prop60);
				 }else if(logEntry.contains("prop41") && serverCall == askedServerCall){
			 			prop41 = getValueFromLogEntry(logEntry); 
			 			data  = new OmnitureData(serverCall, pageName, siteSection, events, product, eventsOfProduct, 
			 					eVars, eVar1, eVar2, eVar11, eVar19, eVar21, eVar35, 
								eVar75, prop1, prop4, prop5, prop6, prop32, prop41, prop60);
				 }else if(logEntry.contains("prop60") && serverCall == askedServerCall){
			 			prop60 = getValueFromLogEntry(logEntry); 
			 			data  = new OmnitureData(serverCall, pageName, siteSection, events, product, eventsOfProduct, 
			 					eVars, eVar1, eVar2, eVar11, eVar19, eVar21, eVar35, 
								eVar75, prop1, prop4, prop5, prop6, prop32, prop41, prop60);
				 }
		 }
		}
	 return data;
	 }

	 
	

	 private static String getValueFromLogEntry(String logEntry) {
		logEntry = logEntry.replaceFirst("chrome-extension://bdingoflfadhnjohjaplginnpjeclmof/cs.js 59:12 ", "");
		LOGGER.info(logEntry);		
		return logEntry.substring(logEntry.indexOf(":")+1, logEntry.lastIndexOf("\"")).trim();
	}

	 private static ArrayList<OmnitureProduct> getProductValueList(String logEntry) {
		ArrayList<OmnitureProduct> productList = new ArrayList<OmnitureProduct>();
		String productsMessage = logEntry;
		productsMessage = productsMessage.replaceAll("\\\\n", "");
		productsMessage = productsMessage.replaceFirst("chrome-extension://bdingoflfadhnjohjaplginnpjeclmof/cs.js 59:12 \"Products           :     #", "");
		LOGGER.info("\"Products           :     #" + productsMessage);
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
		logEntry = logEntry.replaceAll("\\\\n", "");
		logEntry = logEntry.replaceFirst("chrome-extension://bdingoflfadhnjohjaplginnpjeclmof/cs.js 59:12 \"Products           :     #", "");
		LOGGER.info("\"Products           :     #" + logEntry);
		return Integer.valueOf(logEntry.substring(17, logEntry.indexOf("eVars")).trim());
	}

	 public static void printLogs(LogEntries logEntries){
		 ArrayList<String> logHolder=new ArrayList<String>();
		 int serverCall = 0;
		 String currentURLValue = null;	
		 String previousPageURLValue = null;
			for (LogEntry entry : logEntries) { 
				String log = entry.getMessage().replaceAll("chrome-extension://bdingoflfadhnjohjaplginnpjeclmof/cs.js 59:12", "").trim();
				if(log.contains("Report Suite ID")|| log.contains("Page Name")|| log.contains("Site Section")||log.contains("Server")){					
					logHolder.add(log);
				}else if(log.contains(currentURLString)){
					currentURLValue = entry.getMessage();
					if(currentURLValue.equals(previousPageURLValue)){
						serverCall++;
						LOGGER.info("-------------------------------------");
						LOGGER.info("Adobe Analytics Server Call #"+serverCall);
						LOGGER.info("-------------------------------------");
						for(String backLog: logHolder){
							LOGGER.info(backLog);
						}
						logHolder.clear();
						LOGGER.info(log);
					}else{
						previousPageURLValue = currentURLValue;
						serverCall = 1;
						LOGGER.info("-------------------------------------");
						LOGGER.info("Adobe Analytics Server Call #"+serverCall);
						LOGGER.info("-------------------------------------");
						for(String backLog: logHolder){
							LOGGER.info(backLog);
						}
						logHolder.clear();
						LOGGER.info(log);
					}
				}else{
					LOGGER.info(log);
				}
			}
			serverCall = 1;
			previousPageURLValue = null;
			currentURLValue = null;			
	 }
	 
	 public static void printLogs(WebDriver driver) throws InterruptedException {
		Thread.sleep(3000);
		logEntries = driver.manage().logs().get(LogType.BROWSER);
		ArrayList<String> logHolder=new ArrayList<String>();
		for (LogEntry entry : logEntries) { 
			String log = entry.getMessage().replaceAll("chrome-extension://bdingoflfadhnjohjaplginnpjeclmof/cs.js 59:12", "").trim();
			if(log.contains("Report Suite ID")|| log.contains("Page Name")|| log.contains("Site Section")||log.contains("Server")){					
				logHolder.add(log);
			}else if(log.contains(currentURLString)){
				currentURLValue = entry.getMessage();
				if(currentURLValue.equals(previousPageURLValue)){
					serverCall++;
					LOGGER.info("-------------------------------------");
					LOGGER.info("Adobe Analytics Server Call #"+serverCall);
					LOGGER.info("-------------------------------------");
					for(String backLog: logHolder){
						LOGGER.info(backLog);
					}
					logHolder.clear();
					LOGGER.info(log);
				}else{
					previousPageURLValue = currentURLValue;
					serverCall = 1;
					LOGGER.info("-------------------------------------");
					LOGGER.info("Adobe Analytics Server Call #"+serverCall);
					LOGGER.info("-------------------------------------");
					for(String backLog: logHolder){
						LOGGER.info(backLog);
					}
					logHolder.clear();
					LOGGER.info(log);
				}
			}else{
				LOGGER.info(log);
			}
			
		}
				
	 }
			
	 
	 public static void waitForPageLoad1(WebDriver driver) {
			try {
				new WebDriverWait(driver,
						UITestConstants.PAGE_LOAD_TIMEOUT_IN_SECONDS)
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
