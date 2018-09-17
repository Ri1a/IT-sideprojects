$(document).ready(function() {
	$("body").css({ "padding": "30px" });
	$(".maintext").css({ "color": "#0769AA" });
	$("#footer").css({ "font-weight": "bold" });
	$("#mainheader").on("click", function() {
		$(this).css({ "border": "solid", "border-color": "#0769AA" });
		$(".maintext").css({ "font-size": "20px"});
	});
});