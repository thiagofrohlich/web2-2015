$(document).ready(function() {
	
	$('#cadastrar-button').click(function() {
		showFormPessoa();
	});
	
	$('#reset-button').click(function() {
		$('#form-pessoa').addClass("hide");
		$('#table').removeClass("hide");
		$('#data').attr("disabled", "disabled");
	});
	
	$('.edit-atendimento').click(function() {
		parameters = 'http://localhost:8080/cruel-client/pages/Atendimento?action=edit&id=';
		
		tr = $(this).parent().parent(); //5
		td = $(tr).children().eq(0);
		
		parameters += $.trim($(td).text());
		url = window.location.href;
		if(url.indexOf('?') >= 0) {
			url = url.substring(0, url.indexOf('?'));
		}
		window.location.replace(parameters);
		showFormTip();
		
	});
	
	$('.delete-atendimento').click(function() {
		parameters = 'http://localhost:8080/cruel-client/pages/Atendimento?action=delete&id=';
		
		id = $(this).parent().parent().children().eq(0).text();
		nome = $(this).parent().parent().children().eq(1).text();
		
		del = confirm('Deletar registro?');
		if(del) {
			parameters += id;
			url = window.location.href;
			if(url.indexOf('?') >= 0) {
				url = url.substring(0, url.indexOf('?'));
			}
			
			window.location.replace(parameters);
		}
		
	});
	
	edit = getUrlParameter('edit');
	if(edit != null && edit == 'edit') {
		showFormPessoa();
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

function showFormPessoa() {
	$('#table').addClass("hide");
	$('#form-pessoa').removeClass("hide");
};

function populateFormAtendimento() {
	$('#categoria').val("Tipo1");
	$('#data').val("01/01/2015 00:00:00");
	$('#data').removeAttr("disabled");
	$('#valor').val("99,99");
};