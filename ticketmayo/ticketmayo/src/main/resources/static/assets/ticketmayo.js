// async(JSON) no loading img
function ajaxCall4Json(apiURL, request, method, callback){
	$.ajax({
		url : apiURL,
		headers: {'Content-Type': 'application/json; charset=utf-8'},
		type : method,
		crossDomain : true,
		dataType : "json",
		async : true,
		data : JSON.stringify(request),
		success : function(result) {
			callback(result);
		},
		error:function(request,status,error) {
			alert('예상하지 못한 에러가 발생하였습니다.\n관리자에게 문의바랍니다.');
		},
		beforeSend:function() {
    	},
		complete:function() {
    	},
		timeout: 60000
	});
}