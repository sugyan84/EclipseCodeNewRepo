package com.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;

import org.json.JSONArray;
import org.json.JSONObject;

public class Main
{
	// private static String link =
	// "https://www.alphavantage.co/query?function=DIGITAL_CURRENCY_INTRADAY&symbol=BTC&market=USD&apikey=0VSFQZVXRVE3RT5G";

	private static final String	functionStr	= "DIGITAL_CURRENCY_INTRADAY";
	private static final String	symbolStr	= "BTC";
	private static final String	marketStr	= "INR";
	private static final String	apikeyStr	= "0VSFQZVXRVE3RT5G";

	public static String		baseURI		= "https://www.alphavantage.co/query";

	public static void main(String[] args)
	{
		long start = System.currentTimeMillis();

		Client client = ClientBuilder.newClient();

		WebTarget target = client.target(baseURI).queryParam("function", functionStr).queryParam("symbol", symbolStr)
				.queryParam("market", marketStr).queryParam("apikey", apikeyStr).queryParam("interval", "1min");

		System.out.println("URI: |" + target.getUri() + "|");

		Builder b = target.request();

		String response = b.get(String.class);

		long end = System.currentTimeMillis();

		//System.out.println("|" + response + "|");

		double ans = (end - start);

		System.out.println("time taken: " + ans);

		JSONObject mainJSON = new JSONObject(response);

		JSONObject metaData = mainJSON.getJSONObject("Meta Data");

		String lastRefreshed = metaData.getString("7. Last Refreshed");

		//JSONObject lastRefreshedJSON = new JSONObject(lastRefreshed);

		JSONObject timeSeriesJSON = mainJSON.getJSONObject("Time Series (Digital Currency Intraday)");

		JSONObject latestTimeSeriesJSON = timeSeriesJSON.getJSONObject(lastRefreshed);

		String price = latestTimeSeriesJSON.getString("1a. price (" + marketStr + ")");
		
		String volume = latestTimeSeriesJSON.getString("2. volume");
		
		System.out.println("Result: Price= "+price+" & Volume= "+volume);

	}
}
