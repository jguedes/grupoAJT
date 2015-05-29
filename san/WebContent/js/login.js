/**
 * João Guedes, 28 de maio de 2015.
 */

function configurarLoginPage() {
	
	$("#btnLogar").click(function() {
		$.ajax({
			url : "CamadaController",
			async : false,
			type : "POST",
			data : {
				service : "autenticarUser",
				email : $("#email").val(),
				senha : $("#senha").val()
			},
			success : function(page_resultadoDaAutenticacao) {
				open(page_resultadoDaAutenticacao,'_self');
			}
		});
	});
	
}