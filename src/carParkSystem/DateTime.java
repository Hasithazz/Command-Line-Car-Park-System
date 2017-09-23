package carParkSystem;

import java.text.DateFormat;
import java.text.SimpleDateFormat;


public class DateTime {

	void cost(String enddate, String date, String endTime, String time) {
		
		String[] enddateparts = enddate.split("/");
		int ey = Integer.parseInt(enddateparts[0]);
		int em = Integer.parseInt(enddateparts[1]);
		int ed = Integer.parseInt(enddateparts[2]);
		
		int ey2sec = ey*3600*24*365;
		int em2sec = em*3600*24*30;
		int ed2sec = ed*3600*24;
		
		String[] dateparts = date.split("/");
		int y = Integer.parseInt(dateparts[0]);
		int m = Integer.parseInt(dateparts[1]);
		int d = Integer.parseInt(dateparts[2]);
		
		String[]  endTimeParts = endTime.split("-");
		int eh = Integer.parseInt(endTimeParts[0]);
		int emin = Integer.parseInt(endTimeParts[1]);
		
		String[]  timeParts = time.split("-");
		int h = Integer.parseInt(timeParts[0]);
		int min = Integer.parseInt(timeParts[1]);
		
		int eh2sec = eh*3600;
		int emin2sec = emin*60;
		
		int h2sec = h*3600;
		int min2sec = min*60;
		
		int y2sec = y*3600*24*365;
		int m2sec = m*3600*24*30;
		int d2sec = d*3600*24;
		
		int allendsec = ey2sec+em2sec+ed2sec+eh2sec+emin2sec;
		int allsec = y2sec+m2sec+d2sec+h2sec+min2sec;
		int difference = allendsec-allsec;
		int cost = 0;
		
		if((difference)<=(3600*3)){
			cost = (difference/3600)*3;
		}else if((difference>3600*3)&&(difference<3600*24)){
			
			cost = 9+(difference-3600*3)/3600;
			
		}else{
			cost = (difference/(3600*24))*24;
		}
		
		System.out.println("Your Cost is = "+cost+"£");
	
	}	
	
}
	
	
	
	
	
	

