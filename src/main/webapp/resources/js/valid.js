$(function(){
	$(".register input[type=password]").tipTip({activation: "focus", defaultPosition: "right"});

	$(".register input[type=password]").focusout(function() {
		if($(this).val() != '' && $(this).val().length < 6) {
			$(this).attr('style','border: 1px solid #b94a48;');
			$(".register input[type=submit]").attr('disabled','true');
		}
		else
		{
			$(this).removeAttr('style');
			$(".register input[type=submit]").removeAttr('disabled');
		}
	});

	$('.register input[type=submit]').click(function(e) {
		if($("input[name=name]").val().length == 0) 
			err = true;
		if($("input[name=surname]").val().length == 0) 
			err = true;
		if($("input[name=login]").val().length == 0) 
			err = true;
		if($("input[name=email]").val().length == 0) 
			err = true;
		if($("input[name=password]").val().length == 0) 
			err = true;
		if($("select[name=year]").val().length == 0) 
			err = true;
		if($("select[name=month]").val().length == 0) 
			err = true;
		if($("select[name=day]").val().length == 0) 
			err = true;
		if(!$("#sex_1").checked && !$("#sex_2").checked) 
			err = true;
	});
});