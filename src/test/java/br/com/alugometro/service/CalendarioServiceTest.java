package br.com.alugometro.service;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class CalendarioServiceTest {

	@Test
	public void converteStringParaDateComSucesso() {
		// Arrange
			String data = "2015-10-10";
			Calendar dataEsperada = Calendar.getInstance();
			dataEsperada.set(2015, 9, 10, 0, 0, 0);
			
		// Act
			Date dataObtida = new Date();
			try {
				dataObtida = CalendarioService.converterStringParaDate(data);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		// Assert
			assertEquals(dataEsperada.getTime().toString(), dataObtida.toString());
	}
	
	@Test
	public void converteDateParaStringComSucesso() {
		// Arrange
			Calendar calendario = Calendar.getInstance();
			calendario.set(2015, 9, 10, 0, 0, 0);
			
			Date data = calendario.getTime();
			
			String dataEsperada = "2015-10-10";
		// Act
			String dataObtida = CalendarioService.converterDateParaString(data);
			
		// Assert
			assertEquals(dataEsperada, dataObtida);
	}
	
	@Test
	public void data10102015Tem10DiasDeDiferençaParaData20102015(){
		// Arrage
		Calendar calendario = Calendar.getInstance();
		
		calendario.set(2015, 9, 10, 0, 0, 0);
		Date data10102015 = calendario.getTime();
		
		calendario.set(2015, 9, 20, 0, 0, 0);
		Date data20102015 = calendario.getTime();
		
		Long quantidadeEsperada = 10L;
		
		// Act
		Long quantidadeObtida = CalendarioService.obterDiasDeDiferenca(data10102015, data20102015);
		
		// Assert
		assertEquals(quantidadeEsperada, quantidadeObtida);
	}
	
	@Test
	public void aoReceberDataMenor10102015EDataMaior09102015DataMenorFica08102015(){
		// Arrange
		Calendar calendario = Calendar.getInstance();
		
		calendario.set(2015, 9, 10, 0, 0, 0);
		Date dataMenor = calendario.getTime();
		
		calendario.set(2015, 9, 9, 0, 0, 0);
		Date dataMaior = calendario.getTime();
		
		String[] datasEsperadas = new String[2];
		datasEsperadas[0] = "2015-10-08";
		datasEsperadas[1] = "2015-10-09";
		
		// Act
		String[] datasObtidas = new String[2];
		try {
			datasObtidas = CalendarioService.verificarDatas(dataMenor, dataMaior);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Assert
		assertEquals(datasEsperadas[0], datasObtidas[0]);
	}
}
