<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
		<link href="/css/egovframework/lsy-style.css" rel="stylesheet">
		
		<script src="https://code.jquery.com/jquery-3.6.3.min.js"></script>
		<title>Information</title>
		<style>
			.lsy-title-font{
				margin-top: 8%;
			}
			
			.lsy-content-font{
				font-size: 20px !important;
			}
			
			.order-md-2{				
			    padding-left: 14% !important;
			    padding-top: 1%! important;
			}
		</style>
	</head>
	<body>
		
		<!-- GNV 영역 -->
		<div>
			<jsp:include page="../../../mainGnv.jsp" />
		</div>
		<!-- /GNV 영역 -->
		
		<!-- 샵 정보 출력 영역 -->
		<div class="row featurette lsy-inner-page">
			<div class="col-md-7 order-md-2">
			    <p class="lsy-title-font">휴일</p>  
			    <p>${shopInfo.S_CLS_DAY}</p>
			    
			    <p class="lsy-title-font">영업시간</p>  
			    <p>${shopInfo.S_OP_H}:00 ~ ${shopInfo.S_CLS_H}:00</p>
			    
			    <p class="lsy-title-font">대표번호</p>  
			    <p id='tel'>  </p>
			    
			    <p class="lsy-title-font">주소</p>  					    
			    <p>${shopInfo.S_ADR}</p>
			    <br>
			    <p class="lsy-content-font">${shopInfo.S_INTR}</p>
			</div>
			<div class="col-md-5 order-md-1">
				<img width="500" height="500" src="/photo/shopLogo.png">
			</div>
		</div>
		<!-- /샵 정보 출력 영역 -->
    
	</body>
	<script>

	
		//샵 전화번호에 '-' 추가하기
		var tel = "${shopInfo.S_TEL}";
		var setTel = '';
	    
	    // 전화번호 앞자리
	    var tel1 = tel.slice(0, -7);
	    setTel += tel1+'-';

	    // 전화번호 중간자리
	    var tel2 = tel.substring(2, 5);
	    setTel += tel2+'-';

	    // 전화번호 뒷자리
	    var tel3 = tel.substring(5, 9);
	    setTel += tel3;
	    
	    //전화번호 값 넣기
	    $(document).ready(function() {
            $('#tel').text(' '+setTel);
        });
	    
	</script>
</html>