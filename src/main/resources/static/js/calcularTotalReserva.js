$(document).ready(function(){
	
	function obterTotal(){
		var dataInicio = $("#dataInicio").val();
		var dataFim = $("#dataFim").val();
		var diaria =  $("#diaria").val();
			
			$.ajax({
			    url: '/reserva/calculartotal?dataInicio=' +dataInicio+ '&dataFim=' +dataFim+ '&diaria=' +diaria,
			    type: 'GET',
			    success: function(data){ 
			    	$("#exibicaoTotal").text(data);
			    	$("#total").val(data);
			    }
			});
	}
	
	$("#dataInicio").change(function(){
		obterTotal()
	});
	
	$("#dataFim").change(function(){
		obterTotal()
	});
	
	
	
	
});