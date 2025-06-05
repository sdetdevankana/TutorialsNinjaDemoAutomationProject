package utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

public class commonUtilities {
	public static String generateNewEmail()
	{
		Date date=new Date();
		String dateString = date.toString();	
		String noSpaceDateString = dateString.replaceAll(" ","");
		String noSpaceandColonDateString = noSpaceDateString.replaceAll("\\:", "");
		String emailWithTimeStamp = noSpaceandColonDateString+"@gmail.com";
		return emailWithTimeStamp;

	}
	
	public static Properties loadProperty()
	{
		Properties prop = new Properties();
		try {
		FileReader fr = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\projectData.properties");
		prop.load(fr);
		}catch(IOException e)
		{
			e.printStackTrace();
		}
		
		return prop;
	}

}
