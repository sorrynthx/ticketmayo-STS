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

/****************************************************************
 * submitPost(url, params)
 *  : 동적으로 form 생성하여 post 전달
 * examples  :
 * var mapData = {'name1':'value1', 'name2':'value2'}
 * submitPost('/abc', mapData); -> /abc 경로로 mapData post 전송 
 * 
 ****************************************************************/
function submitPost(url, params) {
	var form = document.createElement("form");
    form.setAttribute("charset", "UTF-8");
    form.setAttribute("method", "POST");  //Post 방식
    form.setAttribute("action", url); //요청 보낼 주소

    for(var key in params) {
		var hiddenField = document.createElement("input");
    	hiddenField.setAttribute("type", "hidden");
    	hiddenField.setAttribute("name", key);
    	hiddenField.setAttribute("value", params[key]);
    	form.appendChild(hiddenField);
	}

    document.body.appendChild(form);
	form.submit();
}