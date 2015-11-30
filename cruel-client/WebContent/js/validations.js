$(document).ready(function() {
	
	$('#form-pessoa').on('change', '.no-blank', function(event) {
		validateBlank($(this));
	});
	
	$('#form-pessoa').on('change', '.cpf', function(event) {
		validarCPF($(this));
	});
	
	$('#form-pessoa').on('change', '.email', function(event) {
		isEmail($(this));
	});
	
	$('#form-pessoa').on('change', '.currency', function(event) {
		validateCurrency($(this));
	});
	
	$('#form-pessoa').on('keyup', '.only-numeric', function(event) {
		$(this).val($(this).val().replace(/\D/g,''));
	});
	
	$('#form-pessoa').on('keyup', '.currency', function(event) {
		$(this).val($(this).val().replace(/[^0-9$.,]/g, ''));
	});
	
	$('body').on('submit', '#form-pessoa', function(event) {
		valid = true;
		
		$('#form-pessoa :input').each(function() {
//			Blank
			if($(this).hasClass('no-blank')) {
				
				if(!validateBlank($(this))) {
					valid = false;
				}
				
			}
			
//			CPF
			if($(this).hasClass('cpf')) {
				
				if(!validarCPF($(this))) {
					valid = false;
				}
				
			}
			
//			Email
			if($(this).hasClass('email')) {
				
				if(!isEmail($(this))) {
					valid = false;
				}
				
			}
			
		})
		
		if(!valid) {
			alert('Formulário contêm erros!');
		}
		return valid;
			
	});
	
	function validateBlank(field) {
		valid = true;
		value = $(field).val();
		if(value == null || $.trim(value) == "") {
			valid = false;
		}
		
		if(valid) {
			$(field).parent().removeClass('has-error');
			$(field).parent().addClass('has-success');
		} else {
			$(field).parent().removeClass('has-success');
			$(field).parent().addClass('has-error');
		}
		
		return valid;
	}
	
	function validarCPF(field){
		valid = true;
		value = $(field).val();
		 //get input
		 if(value){
			   var input=value.toString();
			 
			   var numeros=[];
			   var pesos_A=[10,9,8,7,6,5,4,3,2];
			   var pesos_B=[11,10,9,8,7,6,5,4,3,2];
			   var sum=0;
			   var x1=0;
			   var x2=0;
	
			   for(var i=0;i<9 && i<input.length;i++){
			     var digito=input[i]
			     sum=sum+digito*pesos_A[i];
			   }
	
			   //calcula digito 1
			   var mod=sum%11;
			   if(mod>=2){
			     x1=11-mod;
			   }
	
			   //calcula digito 2
			   sum=0;
			   for(var i=0;i<10 && i<input.length;i++){
			     sum=sum+input[i]*pesos_B[i];
			   }
	
			   var mod=sum%11;
			   if(mod>=2){
			     x2=11-mod;
			   }
		 
			   if(x1==input[9] && x2==input[10]){
				   valid = true;
			   }else{
				   valid = false;
			   }
		   }else{
			   valid = false;
		   }
		 
		if(valid) {
			$(field).parent().removeClass('has-error');
			$(field).parent().addClass('has-success');
		} else {
			$(field).parent().removeClass('has-success');
			$(field).parent().addClass('has-error');
		}

		 
		 return valid;
		};
		
		function isEmail(field) {
			var regex = /^([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+\.)+([a-zA-Z0-9]{2,4})+$/;
			value = $(field).val();
			valid = regex.test(value);
			
			if(valid) {
				$(field).parent().removeClass('has-error');
				$(field).parent().addClass('has-success');
			} else {
				$(field).parent().removeClass('has-success');
				$(field).parent().addClass('has-error');
			}
			
			return valid;
		}
		
				
});