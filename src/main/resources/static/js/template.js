$(function() {

	$( "#slider-range" ).slider({
		range: true,
		min: 19,
		max: 4999,
		values: [ 99, 4909 ],
		slide: function( event, ui ) {
			$( "#amount" ).val( "R$ " + ui.values[ 0 ] + " - R$ " + ui.values[ 1 ] );

			$("#minval").val(ui.values[ 0 ]);

			$("#maxval").val(ui.values[ 1 ]);
		}
	});

	$( "#amount" ).val( "R$ " + $( "#slider-range" ).slider( "values", 0 ) +
		" - R$ " + $( "#slider-range" ).slider( "values", 1 ) );

});