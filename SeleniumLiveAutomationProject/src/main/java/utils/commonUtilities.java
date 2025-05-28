package utils;

import java.util.Date;

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

}
