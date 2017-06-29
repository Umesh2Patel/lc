package leetcode.com.qa;

public class OmnitureConstants {
	public static final String regexForEqualMatch = "Server Call|Site Section|Page Name|Product|Events Of Product|prop1|prop4|prop6|prop32|eVar2|eVar19|eVar21";
	public static final String regexForContains = "Events|prop5|prop41|prop60|eVars|eVar1|eVar11|eVar35|eVar75";
	public static final String regexForProduct = "Products";
	public static boolean omnitureAdobeExtension = false;
	public static final int PAGE_LOAD_TIMEOUT_IN_SECONDS = 60;
	public static final String regexForLogHolder  = "(.*)Report Suite ID(.*)|(.*)Page Name(.*)|(.*)Site Section(.*)|(.*)Server(.*)";
	public static final String regexForLogFilter = "(.*)Uncaught SyntaxError(.*)|(.*)TypeError(.*)|(.*)Uncaught ReferenceError(.*)|(.*)oops_page_1(.*)|(.*)This request has been blocked(.*)|(.*)XMLHttpRequest(.*)|(.*)Implement automated anomaly detection Slack app(.*)|(.*)Adobe Marketing Cloud(.*)|(.*)Recommendations(.*)|(.*)AMC Organisation ID(.*)|(.*)AMC Visitor ID(.*)|(.*)Legacy Analytics ID(.*)|(.*)formatAdobeAnalyticsPixel(.*)|(.*)Failed to load resource(.*)|(.*)CUSTOM LINK(.*)";
//	public static final String regexForDataValidationKeys = "(.*)Adobe Analytics Server Call #(.*)|(.*)\"Site Section(.*)|(.*)\"Page Name(.*)|(.*)Current URL(.*)|(.*)\"Events(.*)|(.*)Products(.*)|(.*)eVar1 (.*)|(.*)eVar2 (.*)|(.*)eVar11(.*)|(.*)eVar19(.*)|(.*)eVar21(.*)|(.*)eVar35(.*)|(.*)eVar75(.*)|(.*)prop1 (.*)|(.*)prop4 (.*)|(.*)prop5 (.*)|(.*)prop6 (.*)|(.*)prop32(.*)|(.*)prop41(.*)|(.*)prop60(.*)"; 
	public static final String regexForDataValidationKeys = "(.*)Adobe Analytics Server Call #(.*)|(.*)Site Section       : (.*)|(.*)Page Name          : (.*)|(.*)Current URL(.*)|(.*)Events             : (.*)|(.*)Products\\s+:(.*)|(.*)eVar1 (.*)|(.*)eVar2 (.*)|(.*)eVar11(.*)|(.*)eVar19(.*)|(.*)eVar21(.*)|(.*)eVar35(.*)|(.*)eVar75(.*)|(.*)prop1 (.*)|(.*)prop4 (.*)|(.*)prop5 (.*)|(.*)prop6 (.*)|(.*)prop32(.*)|(.*)prop41(.*)|(.*)prop60(.*)"; 
	public static final String adobeAnalyticsServerCall = "Adobe Analytics Server Call";
	public static final String directory = "omnitureUtilities";	
	
	public static final String logEntryFilter1 = "chrome-extension://bdingoflfadhnjohjaplginnpjeclmof/cs.js";
	public static final String logEntryFilter2 = "59:12";
	public static final String logEntryFilter3 = "53:11";
	public static final String logEntryFilter4 = "60:13";
	public static final String logEntryFilter5 = "\"";
	public static final String logEntryFilter6 = "\\\\n";
	public static final String logEntryFilter7 = "[\r\n]+";
	public static final String logEntryFilter8 = "Products           :     #";
	
	public static final String regexQuantity = ".*\\s+Quantity\\s+:+\\s+.*";
	public static final String regexPrice = ".*\\s+Price\\s+:+\\s+.*";
	public static final String regexEvents = ".*\\s+Events\\s+:+\\s+.*";
	public static final String regexeVars = ".*\\s+eVars\\s+:+\\s+.*";
	
	
	
}
