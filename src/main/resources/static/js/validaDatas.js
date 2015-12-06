$(document).ready(function(){
	
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
	
	$("#dataInicio").ready(function(){
		verificarDataInicio();
	});
	
	$("#dataInicio").blur(function(){
		verificarDataInicio();
	});
	
	$("#dataInicio").change(function(){
		verificarDataInicio();
	});
	
	$("#dataFim").blur(function(){
			verificarDataFim();
		});

	$("#dataFim").change(function(){
		verificarDataFim();
	});
	
	$("#dataFim").ready(function(){
		verificarDataFim();
	});
	
});