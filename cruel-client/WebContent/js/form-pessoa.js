$(document).ready(function() {
	
	$('#cadastrar-button').click(function() {
		showFormPessoa();
	});
	
	$('#reset-button').click(function() {
		$('#form-pessoa').addClass("hide");
		$('#table').removeClass("hide");
	});
	
	$('.nutricionista-edit').click(function() {
		parameters = 'http://localhost:8080/cruel-client/pages/Nutricionista?action=edit&id=';
		
		tr = $(this).parent().parent();
		td = $(tr).children().eq(0);
		
		parameters += $.trim($(td).text());
		url = window.location.href;
		if(url.indexOf('?') >= 0) {
			url = url.substring(0, url.indexOf('?'));
		}
		showFormPessoa();
		window.location.replace(parameters);
		
	});
	
	$('.nutricionista-delete').click(function() {
		parameters = 'http://localhost:8080/cruel-client/pages/Nutricionista?action=delete&id=';
		
		id = $(this).parent().parent().children().eq(0).text();
		nome = $(this).parent().parent().children().eq(2).text();
		email = $(this).parent().parent().children().eq(1).text();
		
		del = confirm('Quer mesmo deletar '+ nome + ' / ' + email + ' ?');
		
		if(del) {
			parameters += id;
			url = window.location.href;
			if(url.indexOf('?') >= 0) {
				url = url.substring(0, url.indexOf('?'));
			}
			
			window.location.replace(parameters);
		}
		
	});
	
	$('.atendente-edit').click(function() {
		parameters = 'http://localhost:8080/cruel-client/pages/Atendente?action=edit&id=';
		
		tr = $(this).parent().parent();
		td = $(tr).children().eq(0);
		
		parameters += $.trim($(td).text());
		url = window.location.href;
		if(url.indexOf('?') >= 0) {
			url = url.substring(0, url.indexOf('?'));
		}
		showFormPessoa();
		window.location.replace(parameters);
		
	});
	
	$('.atendente-delete').click(function() {
		parameters = 'http://localhost:8080/cruel-client/pages/Atendente?action=delete&id=';
		
		id = $(this).parent().parent().children().eq(0).text();
		nome = $(this).parent().parent().children().eq(2).text();
		email = $(this).parent().parent().children().eq(1).text();
		
		del = confirm('Quer mesmo deletar '+ nome + ' / ' + email + ' ?');
		
		if(del) {
			parameters += id;
			url = window.location.href;
			if(url.indexOf('?') >= 0) {
				url = url.substring(0, url.indexOf('?'));
			}
			
			window.location.replace(parameters);
		}
		
	});
	
	$('.gerente-edit').click(function() {
		parameters = 'http://localhost:8080/cruel-client/pages/Gerente?action=edit&id=';
		
		tr = $(this).parent().parent();
		td = $(tr).children().eq(0);
		
		parameters += $.trim($(td).text());
		url = window.location.href;
		if(url.indexOf('?') >= 0) {
			url = url.substring(0, url.indexOf('?'));
		}
		showFormPessoa();
		window.location.replace(parameters);
		
	});
	
	$('.gerente-delete').click(function() {
		parameters = 'http://localhost:8080/cruel-client/pages/Gerente?action=delete&id=';
		
		id = $(this).parent().parent().children().eq(0).text();
		nome = $(this).parent().parent().children().eq(2).text();
		email = $(this).parent().parent().children().eq(1).text();
		
		del = confirm('Quer mesmo deletar '+ nome + ' / ' + email + ' ?');
		
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

function populateFormPessoa() {
	$('#nome').val("João da Silva");
	$('#cpf').val("12345678910");
	$('#endereco').val("Lugar nenhum");
	$('#telefone').val("4131234567");
	$('#email').val("joao.silva@email.com");
	$('#senha').val("12345678");
	$('#senha').attr("disabled", "disabled");
};

function populateNutricionista() {
	populateFormPessoa();
	$('#crn').val("11111");
};