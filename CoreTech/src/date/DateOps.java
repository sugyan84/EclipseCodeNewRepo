package date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateOps
{

	public static void main(String[] args) throws ParseException
	{
		// String to Date Conversion
		String strDate = "10/02/2017";
		SimpleDateFormat sDate = new SimpleDateFormat("dd/MM/yyyy");
		Date d1 = sDate.parse(strDate);

		System.out.println("Date 1: " + d1);

		// Date to String Conversion
		Date d2 = new Date(2017 - 1900, 01, 10);
		SimpleDateFormat sDate2 = new SimpleDateFormat("dd-MMM-yy EEEE");
		String srtDate2 = sDate2.format(d2);

		System.out.println("String Date: " + srtDate2);
		
		
		
		
		
		
		//Calender.......................................................
		Date date= new Date();
		Calendar c= Calendar.getInstance();
		c.setTime(date);
		
		
		System.out.println("Khali Date: |"+date+"|");
		System.out.println("Khali c: |"+c.getTime()+"|");
		
		 
		Calendar c2= Calendar.getInstance();
		c2.setTime(d2);
		
		if(c2.before(c))						//A way of date comparison
		{
			System.out.println("Past");
		}

	}

}
