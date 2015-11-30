$(document).ready(function() {
	
	$('#cadastrar-button').click(function() {
		showFormIng();
	});
	
	$('#reset-button').click(function() {
		$('#form-ing').addClass("hide");
		$('#table').removeClass("hide");
	});
	
	$('.edit-ing').click(function() {
		parameters = "?edit=true&id=";
		
		tr = $(this).parent().parent(); //5
		td = $(tr).children().eq(0);
		
		parameters += $.trim($(td).text());
		url = window.location.href;
		if(url.indexOf("?") >= 0) {
			url = url.substring(0, url.indexOf("?"))
		}
		
		window.location.replace(url+parameters);
		
	});
	

	
	edit = getUrlParameter('edit');
	if(edit != null && edit == 'true') {
		showFormIng();
		populateFormIng();
	}
	
	$('.delete-ing').click(function() {
		parameters = '?delete=true&id=';
		
		nome = $(this).parent().parent().children().eq(0).text();
		tipo = $(this).parent().parent().children().eq(1).text();
		
		del = confirm('Quer mesmo deletar '+ nome + ' / ' + tipo + ' ?');
		
		if(del) {
			parameters += tipo;
			url = window.location.href;
			if(url.indexOf('?') >= 0) {
				url = url.substring(0, url.indexOf('?'));
			}
			
			window.location.replace(url+parameters);
		}
		
	});
	
	
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

function showFormIng() {
	$('#table').addClass("hide");
	$('#form-ing').removeClass("hide");
};



function populateFormIng() {
	$('#tipo').val("Carne");
	$('#nome').val("Bife");
	$('#descricao').val("Bife grelhado");
	
};

