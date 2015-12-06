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
	
	public static String[] verificarDatas(Date dataMenor, Date dataMaior) throws ParseException{
		String[] retorno = new String[2];
		retorno[0] = converterDateParaString(dataMenor);
		retorno[1] = converterDateParaString(dataMaior);
		
		Calendar dataInicio = Calendar.getInstance();
		dataInicio.setTime(dataMenor);
		
		Calendar dataFim = Calendar.getInstance();
		dataFim.setTime(dataMaior);
		
		if(dataInicio.compareTo(dataFim) >= 0){
			Calendar novaData = dataFim;
			novaData.add(Calendar.DAY_OF_YEAR, -1);
			
			dataInicio.setTime(novaData.getTime());
			
			retorno[0] = converterDateParaString(dataInicio.getTime());
			
		}else if (dataFim.compareTo(dataInicio) <= 0){
			Calendar novaData = dataInicio;
			novaData.add(Calendar.DAY_OF_YEAR, +1);
			
			dataFim.setTime(novaData.getTime());
			retorno[1] = converterDateParaString(dataFim.getTime());
		}
		
		return retorno;
	}
}
