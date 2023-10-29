<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<!-- 반응형 메타 태그 -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Bootstrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
<!-- Custom styles for this template -->
<link href="https://fonts.googleapis.com/css?family=Playfair&#43;Display:700,900&amp;display=swap" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="/css/egovframework/sign-in.css" rel="stylesheet">
<link href="/css/egovframework/lsy-style.css" rel="stylesheet">

<script src="https://code.jquery.com/jquery-3.6.3.min.js"></script>
<title>Sign in</title>
<style>
	@media (min-width: 370px;) {
      .form-signin {
        width: 370px;
      }
    }
	.form-signin {
	    max-width: 390px;
		margin: 12% 40%;
	}	
	.form-floating{
		margin-bottom: 10px;
	}
</style>
</head>
<body> 
	<!-- GNV 영역 -->
	<div>
		<jsp:include page="../../../mainGnv.jsp" />
	</div>	
	<!-- /GNV 영역 -->
	
	<!-- 로그인 정보 입력창 -->
	<div>
		<main class="form-signin w-100">
			<label for="memberRadio">회원</label>
		    <input type="radio" id="memberRadio" name="loginAut" value="member" checked/>
		    <label for="designerRadio">디자이너</label>
		    <input type="radio" id="designerRadio" name="loginAut" value="designer"/>
		
			<div class="form-floating lsy-content-font" id="loginMember">
				<input type="email" class="form-control" id="email" name="email" placeholder="name@example.com">
				<label for="email">이메일</label>
			</div>
			<div class="form-floating lsy-content-font" id="loginDesigner" hidden="true">
				<input type="text" class="form-control" id="id" name="id" placeholder="id">
				<label for="id">아이디</label>
			</div>
			
			<div class="form-floating lsy-content-font">
				<input type="password" class="form-control" id="pw" name="pw" placeholder="Password">
				<label for="pw">비밀번호</label>
			</div>	    
			<button class="btn btn-outline-secondary w-100 py-2 lsy-title-font" id="signInBtn" type="button" onclick="signIn()" >로그인</button>
		</main>
	</div>
	<!-- /로그인 정보 입력창 -->
	
</body>
<script>	

	//선택한 로그인 권한에 맞춰 로그인 양식을 변경하는 이벤트
	$('input[type="radio"]').change(function(){
		
		//로그인 권한 확인
		var autChk =  $('input[name="loginAut"]:checked').val();
		
		if(autChk == 'member'){ //회원 로그인일 경우
			//이메일 입력창 노출 & 아이디 입력창 숨김
			$('#loginMember').attr("hidden", false);
			$('#loginDesigner').attr("hidden", true);
		} else if(autChk == 'designer'){ //디자이너 로그인일 경우
			//아이디 입력창 노출 & 이메일 입력창 숨김
			$('#loginMember').attr("hidden", true);
			$('#loginDesigner').attr("hidden", false);
		}
		
	})
	
	//이메일 형식 유효성 검사 
	function mailFormCheck(email){
	   var form = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
	   return form.test(email);
	}
	
	//로그인 요청 AJAX
	function signIn(){
		
		//로그인 권한 확인
		var autChk =  $('input[name="loginAut"]:checked').val();	
		
		//사용자 입력 정보(email or id, password)
		var email = $('#email').val();
		var id = $('#id').val();
		var pw = $('#pw').val();
		
		if(autChk == 'member' && email == ''){ //회원 로그인일 경우 이메일 입력 여부 확인
			alert('이메일을 입력해주세요.');
		} else if(autChk == 'member' && !mailFormCheck(email)){ //이메일 형식 유효성 검사
			alert('올바르지 않은 이메일 형식입니다.');		
			$('#email').focus();	
		} else if(autChk == 'designer' && id == ''){ //디자이너 로그인일 경우 아이디 입력 여부 확인
			alert('아이디를 입력해주세요.');
			$('#id').focus();	
		} else if($('#pw').val() == ''){ //비밀번호 입력 여부 확인
			alert('비밀번호를 입력해주세요.');
			$('#pw').focus();	
		} else{	//모든 조건에 충족할 경우 로그인 요청
			$.ajax({
				type:'post',
				url:'/aut/aut1000/aut1000/loginAjax.do',
				data:{
					'autChk':autChk
					,'email':email
					,'id':id
					,'pw':pw
					},
				dataType:'json',
				success:function(data){
					if(data == true) { //로그인에 성공할 경우 메인페이지로 이동
						location.href = "/";
					} else{ //일치하는 정보가 없는 경우
						alert("가입되지 않은 정보이거나 비밀번호가 틀립니다. \r\n 입력한 정보를 다시 확인해주세요.");
					}						
				},
				error:function(e){
					console.log(e);
					alert('오류가 발생했습니다. 잠시 후 다시 시도해주세요.');
				}
			});
		}	

	}



</script>
</html>