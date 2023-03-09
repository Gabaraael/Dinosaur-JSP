package br.edu.ifms.util;

import java.text.SimpleDateFormat;
import java.util.Date;


public class ManipulacaoData {
	
	public static Date convertStringToDate(String data) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
		Date date = null;
		
		 try {
			 date = dateFormat.parse(data);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		 return date;
		
	}
}
