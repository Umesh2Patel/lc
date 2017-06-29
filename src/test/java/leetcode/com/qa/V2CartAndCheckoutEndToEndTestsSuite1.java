package leetcode.com.qa;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.walmart.qa.core.annotations.TestInfo;
import com.walmart.qa.core.enums.TestPriority;
import com.walmart.qa.core.testinv.TestcaseInventoryType;
import com.walmart.qa.samsclub.base.SamsGenericTest;
import com.walmart.qa.samsclub.chalet.ui.constants.CommonChaletUITestConstants;
import com.walmart.qa.samsclub.common.ui.helper.UITestHelper;
import com.walmart.qa.samsclub.constants.TestGroup;
import com.walmart.qa.samsclub.dataprovider.DataGenerator;
import com.walmart.qa.samsclub.dataprovider.DataProviderArguments;
import com.walmart.qa.samsclub.estore.chalet.ui.pageobject.ProductDescriptionPage;
import com.walmart.qa.samsclub.estore.chalet.ui.pageobject.ProductListingPage;
import com.walmart.qa.samsclub.estore.chalet.ui.pageobject.V2CartPage;
import com.walmart.qa.samsclub.estore.chalet.ui.pageobject.V2CartPage.CartLinkOrButton;
import com.walmart.qa.samsclub.estore.chalet.ui.pageobject.V2CheckoutPage;
import com.walmart.qa.samsclub.estore.chalet.ui.pageobject.V2GlobalNavigationHeaderPage;
import com.walmart.qa.samsclub.estore.chalet.ui.pageobject.V2GlobalNavigationHeaderPage.GlobalHeaderLink;
import com.walmart.qa.samsclub.estore.chalet.ui.pageobject.V2ThankYouPage;
import com.walmart.qa.samsclub.estore.chalet.ui.pageobject.V2header.ShopByDepartmentFlyoutPage;
import com.walmart.qa.samsclub.estore.chalet.ui.pageobject.checkout.CheckoutPaymentPage;
import com.walmart.qa.samsclub.estore.chalet.ui.pageobject.checkout.ReviewPlaceOrderPage;
import com.walmart.qa.samsclub.estore.chalet.ui.pageobject.checkout.ShipPage;
import com.walmart.qa.samsclub.estore.chalet.ui.pageobject.checkout.ShipPage.PageFunction;
import com.walmart.qa.samsclub.estore.old.ui.pageobject.SignInPage;
import com.walmart.qa.samsclub.exceptions.SamsException;
import com.walmart.qa.samsclub.omniture.constants.OmnitureConstants;
import com.walmart.qa.samsclub.omniture.utilities.ConsoleUtil;
import com.walmart.qa.samsclub.omniture.utilities.ListFilesUtil;
import com.walmart.qa.samsclub.omniture.utilities.OmnitureActions;
import com.walmart.qa.samsclub.omniture.utilities.OmnitureExcelDataReader;
import com.walmart.qa.samsclub.omniture.utilities.OmnitureProduct;

/**
 * This class represents a testing class to validate the Cart and checkout End to End  functionality
 *  * 
 * @author Umesh Khunt
 * @version 1.0
 */

public class V2CartAndCheckoutEndToEndTestsSuite1 extends SamsGenericTest {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(V2CartAndCheckoutEndToEndTestsSuite1.class);
    private WebDriver webDriver;
    public boolean islocalrun;
    int totalSheets;
    File[] fList;
    List<Sheet> sList;
    ArrayList<String> keyNamesList;
    ArrayList<String> actionList;
	/**
	 * This method is needed if you are using a UI connector to open a ui page
	 * to do some actions
	 * 
	 * @param testMethod
	 *            Method
	 * @param context
	 *            ITestContext
	 * @param methodParams
	 *            Object[]
	 * @throws SamsException
	 */
	@BeforeMethod(alwaysRun = true)
	protected void beforeTest(Method testMethod, ITestContext context,
			Object[] methodParams) throws SamsException {
		this.basePage = openBaseUrl();
		fList = ListFilesUtil.getFilesList(OmnitureConstants.directory);
	}
		
	/**
	 * This method sets the jession Id and cookie values sent from parameters file
	 * @param jSessionId
	 * @throws SamsException
	 */
	protected void setCookie(String jSessionId) throws SamsException {
		String cookies = "JSESSIONID="+ jSessionId;
		cookies += ","+cookieString;
		new UITestHelper().setSamsCookieAndRefreshPage(basePage, cookies,
				this.domain);
	}	
	
	/**
	 * This test is for conventional purchase scenario to utilize with Omniture test with excel reader
	 * 
	 * 
	 * @param jSessionId
	 * @throws SamsException
	 * @throws IOException 
	 */
	@TestInfo(testArea = "V2CartAndCheckoutEndToEndTests", testcaseInvType = TestcaseInventoryType.TestRail, testSuiteId = "1428", testId = "C213895, C213882, C214019", testLocation = "", testOwner = "vn0u7yz", priority = TestPriority.P2)
	@Parameters({ "omnitureAdobeExtension" })
	@Test(enabled = true)
	public void e2eCoventionalPurchaseShipOnlineOmniture()
			throws InterruptedException, SamsException, IOException {
		softAssert = new SoftAssert();

		ProductListingPage plppage = getPage(ProductListingPage.class);
		plppage.getBrowserType();

		webDriver = plppage.getConnector().getWebDriver();	
		for (File file : fList){
			if(!file.getName().contains("Adobe-Analytics-Debugger_v1.3.crx")){
			 LOGGER.info("-------------------------------------");
			 LOGGER.info("Entering the excel file: " + file);
	//			 totalSheets = OmnitureExcelDataReader.getNumberOfSheets(file);
			 sList = OmnitureExcelDataReader.getNamesOfSheets(file);
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
				 
			 }
			 sList.clear();
			 LOGGER.info("Exiting the excel file: " + file);
			 LOGGER.info("-------------------------------------");
			}
		}
		//Validate all data
		softAssert.assertAll();
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
		String regexForProduct = OmnitureConstants.regexForProduct;
					 
		ArrayList<String> expectedValuesforPresentStepList = OmnitureExcelDataReader.getExpectedValuesFromExcel(presentStep, sheet, file);
		//debugging code
//		LOGGER.info("datamap --->");
//		for(String key : dataMap1.keySet()){
//			LOGGER.info( key +" : " +dataMap1.get(key));
//		}
		LOGGER.info("expectedValuesforPresentStepList --->");
		for(int i =0; i< expectedValuesforPresentStepList.size(); i++){
			LOGGER.info(keyNamesList.get(i) +" : "+expectedValuesforPresentStepList.get(i));
		}
		
		for (int i =0; i< expectedValuesforPresentStepList.size(); i++){
			if (dataMap1.get(keyNamesList.get(i)) == null && (expectedValuesforPresentStepList.get(i) != null)){
				LOGGER.error(keyNamesList.get(i) +" is expected but not present for step " + presentStep + "--sheet--" + sheet.getSheetName() + "--excel file--" + file + "\n");
				softAssert.assertNotNull(dataMap1.get(keyNamesList.get(i)), keyNamesList.get(i) +" is expected but not present for step " + presentStep  + "--sheet--" + sheet.getSheetName() + "--excel file--" + file + "\n");
			}else if (keyNamesList.get(i).matches(regexForContains) && (expectedValuesforPresentStepList.get(i) != null)){
				softAssert.assertTrue(dataMap1.get(keyNamesList.get(i)).matches(expectedValuesforPresentStepList.get(i)), "Verification failed for " +keyNamesList.get(i)+" for step " + presentStep + "--sheet--" + sheet.getSheetName() + "--excel file--" + file + "\n");
			}else if (keyNamesList.get(i).matches(regexForEqualMatch) && (expectedValuesforPresentStepList.get(i) != null)){
				softAssert.assertEquals(dataMap1.get(keyNamesList.get(i)), expectedValuesforPresentStepList.get(i), "Verification failed for " +keyNamesList.get(i)+" for step " + presentStep + "--sheet--" + sheet.getSheetName() + "--excel file--" + file + "\n");
			}else if (keyNamesList.get(i).matches(regexForProduct) && (expectedValuesforPresentStepList.get(i) != null)){
				LOGGER.info("actualProducts: -->" +dataMap1.get(keyNamesList.get(i)));
				List<String> actualProductslist = Arrays.asList(dataMap1.get(keyNamesList.get(i)).split("#"));
				ArrayList<String> actualProductslistFormated = new ArrayList<String>();
				actualProductslistFormated = getFormatedAcutalproductList(actualProductslist);
				List<String> expectedProductslist = Arrays.asList(expectedValuesforPresentStepList.get(i).split(","));
				for(String expectedProduct : expectedProductslist){
					String expectedProductID = expectedProduct.substring(1, expectedProduct.indexOf(";" , 2)).trim();
					for (String actualProduct : actualProductslistFormated){
						String actualProductID = actualProduct.substring(1, actualProduct.indexOf(";" , 2));
						if (expectedProductID.equals(actualProductID)){
							Map<String, String> actualProductDataMap = putValuesInProductMap(actualProduct);
							Map<String, String> expectedProductDataMap = putValuesInProductMap(expectedProduct);
							for(String key : expectedProductDataMap.keySet()){
								if(!expectedProductDataMap.get(key).isEmpty() && !key.equals("eVars") &&  !key.equals("Events") )
								softAssert.assertEquals(actualProductDataMap.get(key), expectedProductDataMap.get(key), "Verification failed for "+ key + " of Product: " +expectedProductDataMap.get("Product")+" for step " + presentStep + "--sheet--" + sheet.getSheetName() + "--excel file--" + file + "\n" );
								else if(!expectedProductDataMap.get(key).isEmpty() && (key.equals("eVars") || key.equals("Events")))
									softAssert.assertTrue(stringsMatches(actualProductDataMap.get(key), expectedProductDataMap.get(key)), "Verification failed for "+ key + " of Product: " +expectedProductDataMap.get("Product")+" for step " + presentStep + "--sheet--" + sheet.getSheetName() + "--excel file--" + file + "\n");
									
							}							
						}
					}
				}
				
			}
		}
		
		expectedValuesforPresentStepList.clear();
//		softAssert.assertAll();
		LOGGER.info("Data validation is done for step " + presentStep + "--sheet--" + sheet.getSheetName() +  "--excel file--" + file );
		return Collections.emptyMap();
	}
	
	private boolean stringsMatches(String actualData, String expectedData) {
		List<String> expectedDatalist = Arrays.asList(expectedData.split("\\|"));
		List<String> actualDatalist = Arrays.asList(actualData.split("\\|"));
		boolean matchFound = false;
		if(actualDatalist.size() != expectedDatalist.size())
		return matchFound;
		
		for(String data : expectedDatalist){
			data = ".*"+ data+ ".*";
			matchFound = actualData.matches(data);
			if(!matchFound)
				return matchFound;
		}
		return matchFound;
	}
	
	private ArrayList<String> getFormatedAcutalproductList(
			List<String> actualProductslist) {
		ArrayList<String> actualProductslistFormated = new ArrayList<String>();
		for (String product: actualProductslist){
			
			if (product.contains("Category   : ")){
				product = product.replaceFirst("\\d+\\s+Category\\s+:+\\s+", ";");
				product = product.replaceFirst("\\s+Product\\s+:+\\s+", "");
			} 
			else
				product = ";" +product;
			product = product.replaceFirst("\\d+\\s+Product\\s+:+\\s+", "");
			
			if (product.contains(" Quantity   : "))
				product = product.replaceFirst("\\s+Quantity\\s+:+\\s+", ";");
			else
				product = product.replaceFirst(" ", ";");
			
			if (product.contains(" Price      : "))
				product = product.replaceFirst("\\s+Price\\s+:+\\s+", "; ");
			else
				product = product.replaceFirst(" ", ";");
			
			if (product.contains(" Events     : "))
				product = product.replaceFirst("\\s+Events\\s+:+\\s+", ";");
			else
				product = product.replaceFirst(" ", ";");
			
			if (product.contains(" eVars      : "))
				product = product.replaceFirst("\\s+eVars\\s+:+\\s+", ";").trim();
			else
				product = product.replaceFirst(" ", ";").trim();					
			actualProductslistFormated.add(product);
		}
		return actualProductslistFormated;
	}

	private Map<String, String> putValuesInProductMap(String product) {
		List<String> productList = Arrays.asList(product.split(";"));
		Map<String, String> productDataMap = new HashMap<String, String>();
		for(int i1 = 0; i1 < productList.size(); i1++ ){
			if (i1==0)
				productDataMap.put("Category", productList.get(i1));
			else if(i1==1)
				productDataMap.put("Product", productList.get(i1));
			else if(i1==2)
				productDataMap.put("Quantity", productList.get(i1));
			else if(i1==3)
				productDataMap.put("Price", productList.get(i1));
			else if(i1==4)
				productDataMap.put("Events", productList.get(i1));
			else if(i1==5)
				productDataMap.put("eVars", productList.get(i1));	
		}
		return productDataMap;
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
	
}

	
		
