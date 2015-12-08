$(document).ready(function() {
	
	$('#cadastrar-button').click(function() {
		showFormTip();
	});
	
	$('#reset-button').click(function() {
		$('#form-tip').addClass("hide");
		$('#table').removeClass("hide");
	});
	
	$('.edit-tip').click(function() {
		parameters = "http://localhost:8080/cruel-client/pages/TipoIngrediente?action=edit&id=";
		
		tr = $(this).parent().parent(); //5
		td = $(tr).children().eq(0);
		
		parameters += $.trim($(td).text());
		url = window.location.href;
		if(url.indexOf("?") >= 0) {
			url = url.substring(0, url.indexOf("?"))
		}
		showFormTip();
		window.location.replace(parameters);
	});
	

	
	edit = getUrlParameter('edit');
	if(edit != null && edit == 'edit') {
		showFormTip();
	}
	
	$('.delete-tip').click(function() {
		parameters = 'http://localhost:8080/cruel-client/pages/TipoIngrediente?action=delete&id=';
		
		id = $(this).parent().parent().children().eq(0).text();
		nome = $(this).parent().parent().children().eq(1).text();
		
		
		del = confirm('Quer mesmo deletar '+ nome +  ' ?');
		
		if(del) {
			parameters += id;
			url = window.location.href;
			if(url.indexOf('?') >= 0) {
				url = url.substring(0, url.indexOf('?'));
			}
			
			window.location.replace(parameters);
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

        if (sParameterName[1] === sParam) {
            return sParameterName[1] === undefined ? 'edit' : sParameterName[1];
        }
    }
};

function showFormTip() {
	$('#table').addClass("hide");
	$('#form-tip').removeClass("hide");
};



function populateFormTip() {
	$('#nome').val("Carne");
	
	
};

