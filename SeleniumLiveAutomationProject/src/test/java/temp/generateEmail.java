package temp;

import java.util.Date;

public class generateEmail {

	public static void main(String[] args) {
		Date date=new Date();
		//System.out.print(date);
		String dateString = date.toString();	
		String noSpaceDateString = dateString.replaceAll(" ","");
		String noSpaceandColonDateString = noSpaceDateString.replaceAll("\\:", "");
		//System.out.print(noSpaceandColonDateString);
		String emailWithTimeStamp = noSpaceandColonDateString+"@gmail.com";
		System.out.println(emailWithTimeStamp);

	}

}
