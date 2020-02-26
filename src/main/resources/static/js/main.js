/**
 * author-Rahul Talreja Yojana Project Manager
 */
function openNav() {
	document.body.style.backgroundColor = "rgba(0,0,0,0.4)";
	if(sessionStorage.getItem("user_id")!==null){
		document.getElementById("managerSidenav").style.width = "180px";
	}
	else{
		document.getElementById("homeSidenav").style.width = "180px";
	}
	document.getElementById("pictures").style.opacity = "0.5";
}

function closeNav() {
	document.getElementById("homeSidenav").style.width = "0";
	document.getElementById("managerSidenav").style.width = "0";
	document.body.style.backgroundColor = "white";
	document.getElementById("pictures").style.opacity = "1";
}
function loginCheck() {
	$("#requiredMessage").hide();
	console.log(sessionStorage.getItem("user_id"));
	var user_id = $('#user_id').val();
	var user_pwd = $('#user_pwd').val();
	if (user_id === "" || user_pwd === "") {
		$('#requiredMessage').show(500);
	} else {
		$.ajax({
			url : 'loginCheck.html',
			method : 'POST',
			data : {
				user_id : user_id,
				user_pwd : user_pwd
			},
			success : function(resultText) {
//				console.log(resultText);
				if (resultText == "OK") {
					sessionStorage.setItem("user_id", user_id);
					$(location).attr('href', 'manager.html')
				} else {
//					console.log(resultText);
					$('#errorMessage').show(500);
				}
			},
			error : function(jqXHR, exception) {
				console.log(exception);
				$('#errorMessage').show(500);
			}
		});
	}

}
function checkSession(){
	console.log(sessionStorage.getItem("user_id"));
	$("#user_id").text(sessionStorage.getItem("user_id"));
	if(sessionStorage.getItem("user_id")!==null){
		$("#logged").show();
	}
}
function registerUser() {
	$("#requiredMessage").hide();
	var user_id = $('#user_id').val();
	console.log(user_id);
	var user_pwd = $('#user_pwd').val();
	var cnf_user_pwd = $('#cnf_user_pwd').val();
	var user_name = $('#user_name').val();
	var user_mail = $('#user_mail').val();
	var user_gender = $("input[name='gender']:checked").val();
	console.log(user_gender);
	var user_pic = $('#user_pic').val();
	if (user_id === "" || user_pwd === "" || cnf_user_pwd === ""
			|| user_name === "" || user_mail === "" || user_gender == null) {
		$('#requiredMessage').show(500);
		if (user_id === "") {
			$("#user_id").css("background-color", "red");
		}
		if (user_name === "") {
			$("#user_name").css("background-color", "red");
		}
		if (user_pwd === "") {
			$("#user_pwd").css("background-color", "red");
		}
		if (cnf_user_pwd === "") {
			$("#cnf_user_pwd").css("background-color", "red");
		}
		if (user_name === "") {
			$("#user_name").css("background-color", "red");
		}
		if (user_mail === "") {
			$("#user_mail").css("background-color", "red");
		}
		if(user_gender==null) {
			$(".icon-gender").css("background", "red");
		}
	} else {
		$("#resgistrationForm").submit();
	}
}
function changeBackground(){
	$(".icon-gender").css("background", "lightgray");
}
function changeIdColor(){
	$("#user_id").css("background","white");
}
function changeNameColor(){
	$("#user_name").css("background","white");
}
function changeEmailColor(){
	$("#user_mail").css("background","white");
}
function changePasswordColor(){
	$("#user_pwd").css("background","white");
	$("#cnf_user_pwd").css("background","white");
	if($("#user_pwd").val()!==$("#cnf_user_pwd").val()){
		$("#user_pwd").css("background","red");
		$("#cnf_user_pwd").css("background","red");
	}
}
function changeConfirmPasswordColor(){
	$("#user_pwd").css("background","white");
	$("#cnf_user_pwd").css("background","white");
	if($("#user_pwd").val()!==$("#cnf_user_pwd").val()){
		$("#user_pwd").css("background","red");
		$("#cnf_user_pwd").css("background","red");
	}
}
function registerProject(){
	var proj_name = $('#proj_name').val();
	var proj_desc = $('#proj_desc').val();
	var proj_duration = $('#proj_duration').val();
	var proj_manager = $('#projectManager').val();
	var proj_pic = $('#proj_pic').val();
	console.log(proj_manager);
	$("#newProjectForm").submit();
}
function logout(){
	console.log("Clearing Session Info");
	sessionStorage.clear();
	$(location).attr('href', 'logout.html')
	
}
function updateProject(){
	
	var proj_id = $('#proj_id').val();
	var proj_name = $('#proj_name').val();
	var proj_desc = $('#proj_desc').val();
	var proj_duration = $('#proj_duration').val();
	var proj_manager = $('#projectManager').val();
	var proj_pic = $('#proj_pic').val();
	console.log(proj_manager);
	$("#updateProjectForm").submit();
}
function updateTask(){
	$("#updateTaskForm").submit();
}

function registerTask(){
	
	$("#newTaskForm").submit();
}
function redirect(page){
	location.href = page;
}