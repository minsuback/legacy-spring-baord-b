$(function() {
	
	$('li').removeClass('active');
	
	var url = document.URL;
	if (url.indexOf('/board/') >= 0) {
		$('#board-li').addClass('active');
	}
	
});