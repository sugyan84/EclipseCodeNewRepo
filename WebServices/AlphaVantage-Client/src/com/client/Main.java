package com.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;

import org.json.JSONArray;
import org.json.JSONObject;

public class Main
{
	private static String link = "https://www.alphavantage.co/query?function=DIGITAL_CURRENCY_INTRADAY&symbol=BTC&market=USD&apikey=0VSFQZVXRVE3RT5G";

	public static void main(String[] args)
	{
		Client client = ClientBuilder.newClient();

		WebTarget target = client.target(link);

		Builder b = target.request();

		String response = b.get(String.class);

		System.out.println("|" + response + "|");

	}
}
