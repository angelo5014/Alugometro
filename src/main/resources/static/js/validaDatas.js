$(document).ready(function(){
	
	function validarPeriodo(){
		var dataInicio = $("#dataInicio").val();
		var dataFim = $("#dataFim").val();
		var idAnuncio = $("#idAnuncio").val();
		
		$.ajax({
		    url: '/reserva/verificardisponibilidade?idAnuncio=' +idAnuncio+ '&dataInicio=' +dataInicio+ '&dataFim=' +dataFim,
		    type: 'GET',
		    success: function(data){ 
		    	$("#dataInicio").val(data[0]);
		    	$("#dataFim").val(data[1]);
		    }
		});
	}
	
	function verificarDataInicio(){
		var dataInicio = moment( $("#dataInicio").val(), 'YYYY-MM-DD' );
		var dataFim = moment( $("#dataFim").val(), 'YYYY-MM-DD' );
		
		if(dataInicio >= dataFim){
			dataFim.add(-1, 'days');
			
			$("#dataInicio").val(dataFim.format('YYYY-MM-DD'));
		}
	}
	
	function verificarDataFim(){
		var dataInicio = moment( $("#dataInicio").val(), 'YYYY-MM-DD' );
		var dataFim = moment( $("#dataFim").val(), 'YYYY-MM-DD' );
		
		if(dataFim <= dataInicio){
			dataInicio.add(+1, 'days');
			
			$("#dataFim").val(dataInicio.format('YYYY-MM-DD'));
		}
	}
	
	function validacoesDataInicio(){
		verificarDataInicio();
		validarPeriodo();
	}
	
	function validacoesDataFim(){
		verificarDataFim();
		validarPeriodo();
	}
	
	$("#dataInicio").blur(function(){
		validacoesDataInicio();
	});
	
	$("#dataInicio").change(function(){
		validacoesDataInicio();
	});
	
	$("#dataFim").blur(function(){
		validacoesDataFim();
		});

	$("#dataFim").change(function(){
		validacoesDataFim();
	});
	
});