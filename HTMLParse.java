package Parser;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.*;

public class HTMLParse {
	
	public HTMLParse(String semester, ArrayList<String> dept) {
		
		ArrayList<String> catalog = new ArrayList<String>();
		
		try {
			
			for (int i = 0; i < dept.size(); i++) {
				
				//https://admin.washcoll.edu/schedules/16FAschedules.html
				URL url = new URL("https://admin.washcoll.edu/schedules/" + semester + "schedules.html");
				Scanner f_in = new Scanner(url.openStream());
				
				String currentDept = dept.get(i);
				String temp;
				
				f_in.useDelimiter("<PRE>"); //TODO: change?
				while (f_in.hasNext()) {
					//System.out.println(f_in.next());
					temp = f_in.next();
					if (temp.contains(currentDept)) {

					
					}
				}
				
				f_in.close();
			}
			
	
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public static void main(String[] args) {
		ArrayList<String> depts = new ArrayList<String>();
		depts.add("ANTHROPOLOGY");
;		HTMLParse test = new HTMLParse("17FA", depts);
	}
}
