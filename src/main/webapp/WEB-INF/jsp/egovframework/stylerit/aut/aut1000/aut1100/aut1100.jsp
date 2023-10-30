<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
		<link href="/css/sign-in.css" rel="stylesheet">
		<link href="/css/lsy-style.css" rel="stylesheet">
		
		<script src="https://code.jquery.com/jquery-3.6.3.min.js"></script>
		<title>Sign up</title>
		<style>
			@media (min-width: 370px;) {
		      .form-signin {
		        width: 370px;
		      }
		    }
			.form-signin {
			    max-width: 390px;
				margin: 6% 40%;
			}	
			.form-floating{
				margin-bottom: 10px;
			}
			input[type="number"]::-webkit-inner-spin-button {
		    -webkit-appearance: none;
			}
			#email{
				width: 73%;
				display: inline;
			}
			#authReq{
				height: 58px;
				margin-top: -21px;
			}
			p{
			    margin: 0% 0% 8% 74%;
		        font-size: 14px;
			}
			#esnInf{
		        color: red;
			}
			input[type="email"], input[type="[password]"], input[type="[number]"]{
				margin-bottom: 5px;
			}
		</style>
	</head>
	<body> 
		<!-- GNV 영역 -->
		<div>
			<jsp:include page="../../../mainGnv.jsp" />
		</div>
		<!-- /GNV 영역 -->
		
		<!-- 회원가입 정보 입력창 -->
		<div>
			<main class="form-signin w-100 ">
				<p id="esnInf">*필수 입력 항목</p>
	  				<h1 id="esnInf" class="h3 mb-3 fw-normal lsy-title-font">*이메일</h1>
				<div class="form-floating lsy-content-font">
					<input type="email" class="form-control" id="email" autocomplete="off">
					<label class="lsy-label-text" for="email">abcd@example.com</label>
					<button class="btn btn-outline-secondary lsy-title-font" id="authReq" type="button" onclick="authReq()">인증요청</button>
				</div>
				<div class="form-floating lsy-content-font">
					<input type="number" class="form-control" id="authNum" disabled="disabled">
					<label id="authChk_cnt" class="lsy-label-text" for="authNum">인증번호 입력</label>					
					<span id="authChk_msg"></span>				
				</div>
				<br>				
	   			<h1 id="esnInf" class="h3 mb-3 fw-normal lsy-title-font">*비밀번호</h1>
				<div class="form-floating lsy-content-font">
					<input type="password" class="form-control" id="pw" autocomplete="new-password">
					<label class="lsy-label-text" for="pw">8자리 이상/특수문자 ‘!, @, #, $, %, ^, &, *’ 사용 가능</label>			
					<span id="pwChk_msg"></span>				
				</div>
				<div class="form-floating lsy-content-font">
					<input type="password" class="form-control" id="pwChk" disabled="disabled">
					<label class="lsy-label-text" for="pwChk">비밀번호 확인</label>			
					<span id="pwEqChk_msg"></span>				
				</div>
				<br>
	   			<h1 id="esnInf" class="h3 mb-3 fw-normal lsy-title-font">*이름</h1>
				<div class="form-floating lsy-content-font">
					<input type="text" class="form-control" id="name">
					<label class="lsy-label-text" for="name">이름 입력</label>
				</div>
				<br>
	  			 	<h1 id="esnInf" class="h3 mb-3 fw-normal lsy-title-font">*휴대폰 번호</h1>
				<div class="form-floating lsy-content-font">
					<input type="number" class="form-control" id="phoneNum">
					<label class="lsy-label-text" for="phoneNum">숫자만 입력</label>
				</div>
				<br>
	   			<h1 class="h3 mb-3 fw-normal lsy-title-font">성별</h1>
				<div>
					<input type="radio" name="gender" value="male">남
					<input type="radio" name="gender" value="female">여	
				</div>
				<br>
	   			<h1 class="h3 mb-3 fw-normal lsy-title-font">생년월일</h1>
				<div class="form-floating lsy-content-font">
					<input type="number" class="form-control" id="bDay">
					<label class="lsy-label-text" for="bDay">8자리 숫자로 입력 ex) 20230101 </label>
				</div>
		    	<br>
				<button class="btn btn-outline-secondary w-100 py-2 lsy-title-font" type="button" onclick="join()">회원가입</button>
			</main>
		</div>
		<!-- /회원가입 정보 입력창 -->
	</body>
	<script>
	
		//전송된 이메일 인증번호
		var send_email_authNum = "";
		
		//이메일 인증번호 일치 여부
		var email_auth_chk = false;
		
		//비밀번호 유효성 검사 성공 여부
		var pw_vld_pas = false;

		//비밀번호 확인 일치 여부
		var pw_eq = false;
		
		//인증요청 버튼 활성화
		function authBtnAbl(){
			if($("#authReq").prop("disabled") == true){
				  $("#authReq").attr("disabled", false);
			}				
		}	
		
		//인증요청 버튼 비활성화
		function authBtnDabl(){
			if($("#authReq").prop("disabled") == false){
				$("#authReq").attr("disabled", true);
			}				
		}	
		
		
		//이메일 입력 시 실행되는 이벤트
		$('#email').click(function(e) {
			
			//입력된 이메일 값
			var email = $('#email').val();

			//전송된 인증번호가 있을 경우
			if(send_email_authNum != ''){
				
				//확인 컨펌창
				if(confirm('이메일을 다시 입력할 경우 인증 여부가 초기화 됩니다. \r\n 정말로 다시 입력하시겠습니까?')){
					
					//전송한 인증번호 및 입력한 인증번호, 이메일 인증 여부, 이메일 입력창 초기화 
					send_email_authNum = "";
					email_auth_chk = false;		
					$('#email').val('');
					$('#authNum').val('');

					//인증번호 입력창 정보 초기화
					$('#authChk_cnt').text("인증번호 입력");
					$('#authChk_msg').text("");
					$('#authNum').attr("disabled", true);
										
					//인증요청 버튼 활성화
					authBtnAbl();		
					
				}else {
					return false;
				}
				
			}
			
		});
	
		
		//이메일 형식 유효성 검사 
		function mailFormCheck(email){
		   var form = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
		   return form.test(email);
		}

					
		//이메일 중복 확인
		function mailOverlayChk(email) {
			
			var result = '';
			
			$.ajax({
				type:'post',
				url:'/aut/aut1100/aut1100/mailOverlayChkAjax.do',
				data:{
					'email':email
					},
				dataType:'json', 
			    async: false,
				success:function(data){
					result = data;
				},
				error:function(e){
					console.log(e);
					alert('오류가 발생했습니다. 잠시 후 다시 시도해주세요.');
				}
			});
			return result;
		}
		
		
		//인증요청 시 실행되는 메서드
		function authReq() {
			
			//입력된 이메일 값
			var email = $('#email').val();
			
			//이메일 형식 유효성 검사 
			if(mailFormCheck(email)){
				
				//메일 중복체크 		
				if(mailOverlayChk(email)){
					
					//인증번호 발송
					sendAuthNum(email);
					//인증번호 입력창 활성화
					$('#authNum').attr('disabled',false);
					
				}else { //메일 중복체크 false 반환 시
					alert("이미 가입된 이메일 입니다.");
				}
				
			}else { //이메일 형식 유효성 검사 false 반환 시
				alert("이메일 주소를 올바르게 입력해주세요.");
			}
			
		};
		
		
		//인증번호 발송
		function sendAuthNum(email){
			
			$.ajax({
				type:'post',
				url:'/aut/aut1100/aut1100/sendAuthNumAjax.do',
				data:{
					'email':email
					},
				dataType:'json', 
				success:function(data){
					if(data != null){
						alert('인증번호가 메일로 전송되었습니다. \r\n 인증번호를 확인해주세요.');
						//발송된 인증번호 저장
						send_email_authNum = data;
						//인증요청 버튼 비활성화
						authBtnDabl();
						//인증 유효시간 카운트 다운 실행
						countFn();
					}
				},
				error:function(e){
					console.log(e);
					alert('오류가 발생했습니다. 잠시 후 다시 시도해주세요.');
				}
			});
			
		}
		
		
		//인증번호 유효 시간 카운트다운	
		
		//유효시간
		var countTime = 60*3;
		//타이머
		var timer;
		
		//카운트다운 매서드
		function countFn(){		
			//interval 설정
			timer = setInterval(alertFunc,1000);
		}
		
		//카운트다운 출력 메서드
		function alertFunc(){
			
			//분
			var min = countTime / 60;
			min = Math.floor(min);
			
			//초
			var sec = countTime - (60*min);
			
			//남은 시간이 있을 경우 분단위 설정
			if(min.toString().length == 1){
				min = "0" + min;
			}

			//남은 시간이 있을 경우 초단위 설정
			if(sec.toString.length == 1 && sec < 10){
				sec = "0"+sec;
			}
			
			//카운트 시간 표출
			$('#authChk_cnt').text(min+" : "+sec);
			
			//시간 종료 시 interval 및 카운트 시간 초기화
			if(countTime == 0){
				clearInterval(timer);
				countTime = 60*3;
			}
			
			//countTime 1초씩 감소
			countTime--;					

			//인증 완료 시
			if(email_auth_chk == true){
				clearInterval(timer);
				$('#authChk_cnt').text("");
			}
			
			//유효시간 종료 시
			if(min == 0 && sec == 0){
				clearInterval(timer);

				//인증번호 초기화
				send_email_authNum = "";
				$('#authChk_msg').text("인증번호 유효시간이 초과 되었습니다. 다시 시도해주세요.");
				//인증요청 버튼 활성화
				authBtnAbl();
			}
			
		}
		
		
		//인증번호 일치여부 확인
		$('#authNum').on('keyup', function(){	
			
			//사용자 입력 인증번호
			var authNum = $('#authNum').val();
			
			//전송한 인증번호와 일치할 경우
			if(authNum == send_email_authNum){	
				//메세지 출력
				$('#authChk_msg').text("인증번호가 일치합니다.").css('color', 'darkgreen');
				//인증번호 일치 여부 true로 변경
				email_auth_chk = true;
				//인증요청 버튼 비활성화
				authBtnDabl();
				//인증번호 입력창 비활성화
				$('#authNum').attr('disabled',true);
			}else if(authNum != send_email_authNum){ //인증번호가 일치하지 않을 경우
				//메세지 출력
				$('#authChk_msg').text("인증번호가 일치하지 않습니다.").css('color', 'red');
			}
			
		});
				
		
		//비밀번호 유효성 검사
		$('#pw').on('keyup', function(){	

			//비밀번호 입력값
			var pw = $('#pw').val();
			//비밀번호 확인 입력값
			var pwChk = $('#pwChk').val();
			//비밀번호 일치여부
			pw_eq = false;
			
			//비밀번호 8자리 이상, 문자 및 숫자 포함 여부 확인
			if (pw.length < 8 || !/[!@#$%^&*]/.test(pw) || !/[a-zA-Z]/.test(pw) || !/\d/.test(pw) || /[ `()_+\-=\[\]{};':"\\|,.<>\/?~]/.test(pw)) {
				$('#pwChk_msg').text("비밀번호를 형식에 맞춰 입력해주세요.").css('color', 'red');
				//비밀번호 유효성 검사 실패
				pw_vld_pas = false;
				//비밀번호 확인 입력창 비활성화
				$('#pwChk').attr('disabled',true);
			}else if(pw.length >= 50){
				alert('비밀번호를 50자 미만으로 입력해주세요.');
				//비밀번호 유효성 검사 실패
				pw_vld_pas = false;
				//비밀번호 확인 입력창 비활성화
				$('#pwChk').attr('disabled',true);
			}else {
				$('#pwChk_msg').text("사용 가능한 비밀번호입니다.").css('color', 'darkgreen');
				//비밀번호 확인 입력창 활성화
				$('#pwChk').attr('disabled',false);
				//비밀번호 유효성 검사 통과
				pw_vld_pas = true;
				
				if(pwChk != ''){
					fn_pwChk();		
				}
			}
			
		});
		
		//비밀번호 일치여부 확인
		function fn_pwChk(){
			
			//비밀번호 입력값
			var pw = $('#pw').val();
			//비밀번호 확인 입력값
			var pwChk = $('#pwChk').val();
			
			if (pw != null && pwChk != null && pw == pwChk) {
				$('#pwEqChk_msg').text("비밀번호가 일치합니다.").css('color', 'darkgreen');
				pw_eq = true;
			}else {
				$('#pwEqChk_msg').text("비밀번호가 일치하지 않습니다.").css('color', 'red');
				pw_eq = false;
			}
			
		}
		
		//비밀번호 확인란 입력 시 일치여부 확인
		$('#pwChk').on('keyup', function(){	
			fn_pwChk();			
		});
		
		//특수문자 포함여부 확인
		function specialCharsChk(arg){
			  var specialChars = /[ `!@#$%^&*()_+\-=\[\]{};':"\\|,.<>\/?~]/;
			  specialChars.test(arg);
		}
		
		
		//회원가입 처리
		function join()	{
			
			//입력값 가져오기
			var email = $('#email').val();
			var pw = $('#pw').val();
			var name = $('#name').val();
			var phoneNum = $('#phoneNum').val();
			var gender = $('input[type="radio"]:checked').val();
			var bDay = $('#bDay').val();
			
			//비밀번호 일치여부 확인
			fn_pwChk();	
			
			if(email == '' || email == null){
				alert('이메일을 입력해주세요.');
				 $('#email').focus();
			}else if(!email_auth_chk){
				alert('이메일 인증을 완료해주세요.');
				 $('#email').focus();
			}else if(pw == '' || pw == null){
				alert('비밀번호를 입력해주세요.');
				 $('#pw').focus();
			}else if(!pw_vld_pas){
				alert('비밀번호를 형식에 맞춰 입력해주세요.');
				 $('#pw').focus();
			}else if(!pw_eq){
				alert('비밀번호가 일치하지 않습니다. \r\n 다시 확인해주세요.');
				 $('#pwChk').focus();
			}else if(name == '' || name == null){
				alert('이름을 입력해주세요.');
				 $('#name').focus();
			}else if(/\d/.test(name) || specialCharsChk(name)){
				alert('이름에 숫자 또는 특수문자를 포함할 수 없습니다.');
				 $('#name').focus();
			}else if(phoneNum == ''){
				alert('휴대폰 번호를 숫자로만 입력해주세요.');
				 $('#phoneNum').focus();
			}else if(/[+\-.]/.test(phoneNum)){
				alert('휴대폰 번호는 숫자로만 입력해주세요.');
				 $('#phoneNum').focus();
			}else if(bDay.length < 8 || bDay.length > 8){
				alert('생년월일은 8자리 숫자로만 입력해주세요.');
				 $('#bDay').focus();
			}else if(/[+\-.]/.test(bDay)){
				alert('생년월일은 8자리 숫자로만 입력해주세요.');
				 $('#bDay').focus();
			}else {
				
				//전송할 값 담기
				var params = {};
			    params.email = email;
			    params.pw = pw;
			    params.name = name;
			    params.phoneNum = phoneNum;
			    params.gender = gender;
			    params.bDay = bDay;

			    $.ajax({
					type:'post',
					url: '/aut/aut1100/aut1100/joinAjax.do',
					data: params,
					dataType:'json', 
				    async: false,
					success: function(data){
						if(data == true){
							alert('회원가입 되었습니다. \r\n 로그인 후 서비스를 이용해주세요.');
							location.href="<spring:message code='signIn.falseRedirectURL'></spring:message>";
						}else {
							alert(data);
						}
					},
					error: function(e){
						console.log(e);
						alert('오류가 발생했습니다. 잠시 후 다시 시도해주세요.');
					}
				});
			}
			 
		}	
	
	</script>
</html>