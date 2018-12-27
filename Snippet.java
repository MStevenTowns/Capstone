import java.net.*;
import java.io.*;

public class Snippet 
{
	public static void main(String[] args)
	{
		// base address for searching for a species
		// rank is a parameter for the web call
		// it will be used both for searching by common and scientific names
		String baseAddress = "http://api.gbif.org/v1/species/search?q=";
		String rank = "&rank=species";
		// test user query
		String[] query = {"American", "Alligator"};
		
		try
		{
			// initialize address, create connection
			URL fullAddress = new URL(baseAddress + query[0] + "%20" + query[1] + rank);
			HttpURLConnection connection = (HttpURLConnection) fullAddress.openConnection();
			//System.out.println(fullAddress);
			// get data from page, specifically the common name and scientific name
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

			String line;
			String text = "";
			// grab all results from request
			while((line = bufferedReader.readLine()) != null)
			{
				text += line;
			}

			bufferedReader.close();
			System.out.println(text);
		}
		catch(Exception e)
		{
			System.out.println("There was an error");
		}
	}
}
