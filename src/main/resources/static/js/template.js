$(function() {

	$( "#slider-range" ).slider({
		range: true,
		min: 1,
		max: 999,
		values: [ 1, 4909 ],
		slide: function( event, ui ) {
			$( "#amount" ).val( "R$ " + ui.values[ 0 ] + " - R$ " + ui.values[ 1 ] );

			$("#minval").val(ui.values[ 0 ]);

			$("#maxval").val(ui.values[ 1 ]);
		}
	});

	$( "#amount" ).val( "R$ " + $( "#slider-range" ).slider( "values", 0 ) +
		" - R$ " + $( "#slider-range" ).slider( "values", 1 ) );

	var inputDemaisFotos = '<input type="file" class="input-field" name="imagens" accept="image/*"/>'
	var labelDemaisFotos = $('#fotos-label');

	$('#btn-fotos').click(function() {
		$(labelDemaisFotos).append($(inputDemaisFotos));
	});

});

$(document).ready(function(){
	$('.image-pagination').slick({
		dots: true,
		infinite: true,
		speed: 300,
		slidesToShow: 1,
		adaptiveHeight: true
	});
});