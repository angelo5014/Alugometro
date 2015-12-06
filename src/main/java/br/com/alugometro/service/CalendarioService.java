package br.com.alugometro.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarioService {

	public static Date converterStringParaDate(String data){
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		try {
			date = (Date) formatter.parse(data);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	public static int obterDiasDeDiferenca(Date dataInicial, Date dataFinal){
		Calendar dataInicio = Calendar.getInstance();
		dataInicio.setTime(dataInicial);
		
		Calendar dataFim = Calendar.getInstance();
		dataFim.setTime(dataFinal);
		
		return dataFim.get(Calendar.DAY_OF_YEAR) - dataInicio.get(Calendar.DAY_OF_YEAR);
	}
}
