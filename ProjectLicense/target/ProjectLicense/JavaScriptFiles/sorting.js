$(document).ready(function() {
// Handler for .ready() called.

	color();

});

function color(){

	// add multiple select / deselect functionality
	$("#selectall").click(
			function() {
				$('.case').attr('checked', this.checked);
				$('.case').closest("tr").css("background-color",
						this.checked ? "#848EF5" : "");
			});

	// if all checkbox are selected, check the selectall checkbox
	// and viceversa
	$(".case").click(
			function() {
				$(this).closest("tr").css("background-color",
						this.checked ? "#848EF5" : "");
				if ($(".case").length == $(".case:checked").length) {
					$("#selectall").attr("checked", "checked");
				} else {
					$("#selectall").removeAttr("checked");
				}
			});			
				
}


function showHideDiv(id, action) {
	switch (id) {
	case 'showr':
		$("." + action).show();
		break;
	case 'hide':
		$("." + action).hide();
		break;
	default:
		break;
	}
}

function fnShowHide(who, id, page) {
	if ($("#" + id).is(':checked')) {
		$('.' + who).show();
		$.get('ControlerListProduct.aspx?status=show&accept=ajax&page=' + page + '&who='
				+ who, function(data) {
			$('.container--list').html(data);
			color();
		});

		$('#' + id).attr('checked', true);
	} else {
		$('.' + who).hide();
		$.get('ControlerListProduct.aspx?status=hide&accept=ajax&page=' + page + '&who='
				+ who, function(data) {
			$('.container--list').html(data);
			color();
		});
		$('#' + id).attr('checked', false);
	}
}
