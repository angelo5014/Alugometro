package br.com.alugometro.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarioService {
	
	private static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	
	public static Date converterStringParaDate(String data) throws ParseException{
		return formatter.parse(data);
	}
	
	public static String converterDateParaString(Date data){
		return formatter.format(data);
	}
	
	public static int obterDiasDeDiferenca(Date dataInicial, Date dataFinal){
		Calendar dataInicio = Calendar.getInstance();
		dataInicio.setTime(dataInicial);
		
		Calendar dataFim = Calendar.getInstance();
		dataFim.setTime(dataFinal);
		
		return dataFim.get(Calendar.DAY_OF_YEAR) - dataInicio.get(Calendar.DAY_OF_YEAR);
	}
}
