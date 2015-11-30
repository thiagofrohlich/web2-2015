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
		parameters = '?edit=true&id=';
		
		id = $(this).parent().children('#id').val();
		
		parameters += $.trim(id);
		url = window.location.href;
		if(url.indexOf('?') >= 0) {
			url = url.substring(0, url.indexOf('?'));
		}
		
		window.location.replace(url+parameters);
		
	});
	
	$('.delete-atendimento').click(function() {
		parameters = '?delete=true&id=';
		
		id = $(this).parent().children('#id').val();
		
		del = confirm('Deletar registro?');
		if(del) {
			parameters += id;
			url = window.location.href;
			if(url.indexOf('?') >= 0) {
				url = url.substring(0, url.indexOf('?'));
			}
			
			window.location.replace(url+parameters);
		}
		
	});
	
	edit = getUrlParameter('edit');
	if(edit != null && edit == 'true') {
		showFormPessoa();
		populateFormAtendimento();
	}
	
});

function getUrlParameter(sParam) {
    var sPageURL = decodeURIComponent(window.location.search.substring(1)),
        sURLVariables = sPageURL.split('&'),
        sParameterName,
        i;

    for (i = 0; i < sURLVariables.length; i++) {
        sParameterName = sURLVariables[i].split('=');

        if (sParameterName[0] === sParam) {
            return sParameterName[1] === undefined ? true : sParameterName[1];
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