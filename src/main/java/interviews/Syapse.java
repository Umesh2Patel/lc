package interviews;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;

import org.json.simple.*;
import org.json.simple.parser.*;

public class Syapse {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.out.print (getCountries("un", 400));
	}

static int getCountries(String s , int p) throws Exception{

if ( s==null || s.length()==0 || p > Integer.MAX_VALUE || p < Integer.MIN_VALUE){
throw new IllegalArgumentException();
}

return getCountriesHelper(s,p);
}


static int getCountriesHelper(String s ,int p) throws Exception{

String url = "https://jsonmock.hackerrank.com/api/countries/search?name="+s;

int countryCount = 0;
    
    URL obj = new URL(url);
    HttpURLConnection con = (HttpURLConnection) obj.openConnection();

    // optional default is GET
    con.setRequestMethod("GET");

    BufferedReader in = new BufferedReader(
     new InputStreamReader(con.getInputStream()));
    String inputLine;
    StringBuffer response = new StringBuffer();

    while ((inputLine = in.readLine()) != null) {
      response.append(inputLine);
    }
    
	in.close();
	
	JSONParser parser = new JSONParser();
	JSONObject data = (JSONObject) parser.parse(response.toString());
	
	JSONArray countries = (JSONArray) data.get("data");
	
	
	Iterator<JSONObject> iterator = countries.iterator();
	while (iterator.hasNext()) {
	JSONObject jsonObject = iterator.next();
	int currentPopulation = (int)(long) jsonObject.get("population");
	
	if(currentPopulation > p){
	countryCount++;
	}
	
	
	}
	
	
	return countryCount;
	}
    
}