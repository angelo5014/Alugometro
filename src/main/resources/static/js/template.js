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

	var divDemaisFotos = $('#fotos-div');
	var labelDemaisFotos = '<label><span>Demais Fotos:</span><input type="file" data-max-size="5242880" class="upload-file input-field" name="imagens" accept="image/*" /></label>';

	$('#btn-fotos').click(function() {
		$(divDemaisFotos).append($(labelDemaisFotos));
	});

	$('.image-pagination').slick({
		dots: true,
		infinite: true,
		speed: 300,
		slidesToShow: 1,
		adaptiveHeight: true
	});

	// Scritp paginação ajax
	/*
	var jsonFotos = '/anuncio/rest/';
	var idAnuncio = $('#idAnuncio').val();
	var image = '<img class="image-details" />';

	var fotos = $.getJSON(jsonFotos + idAnuncio, function(data) {
		var length = data.length;
		console.log(length);
		for (var i = 0; i < length; i++) {
			$('#image-pagination').append($('<div></div>')
				.append($(image).attr('src', data[i].urlFoto))
				);
		}
	});
*/

});
