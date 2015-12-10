$(document).ready(function() {
	
	$('#cadastrar-button').click(function() {
		showFormTipo();
	});
	
	$('#reset-button').click(function() {
		$('#form-pessoa').addClass("hide");
		$('#table').removeClass("hide");
	});
	
	$('.edit-tipo').click(function() {
		parameters = 'http://localhost:8080/cruel-client/pages/TipoCliente?action=edit&id=';
		
		tr = $(this).parent().parent();
		td = $(tr).children().eq(0);
		
		parameters += $.trim($(td).text());
		url = window.location.href;
		if(url.indexOf('?') >= 0) {
			url = url.substring(0, url.indexOf('?'));
		}
		window.location.replace(parameters);
		
	});
	
	$('.delete-tipo').click(function() {
		parameters = 'http://localhost:8080/cruel-client/pages/TipoCliente?action=delete&id=';
		
		desc = $(this).parent().parent().children().eq(1).text();
		codigo = $(this).parent().parent().children().eq(0).text();
		
		del = confirm('Quer mesmo deletar '+ codigo + ' / ' + desc + ' ?');
		
		if(del) {
			parameters += codigo;
			url = window.location.href;
			if(url.indexOf('?') >= 0) {
				url = url.substring(0, url.indexOf('?'));
			}
			
			window.location.replace(parameters);
		}
		
	});
	
	edit = getUrlParameter('edit');
	if(edit != null && edit == 'edit') {
		showFormTipo();
	}
	
});

function getUrlParameter(sParam) {
    var sPageURL = decodeURIComponent(window.location.search.substring(1)),
        sURLVariables = sPageURL.split('&'),
        sParameterName,
        i;

    for (i = 0; i < sURLVariables.length; i++) {
        sParameterName = sURLVariables[i].split('=');

        if (sParameterName[1] === sParam) {
            return sParameterName[1] === undefined ? 'edit' : sParameterName[1];
        }
    }
};

function showFormTipo() {
	$('#table').addClass("hide");
	$('#form-pessoa').removeClass("hide");
};

function populateFormTipo() {
	$('#codigo').val("1");
	$('#descricao').val("Tipo1");
};
