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
		<title>Reservation</title>
		<style>
			.lsy-inner-page{
				text-align: center;
			}
			.rsv-btn{
			    --bs-btn-padding-x: 2.75rem;
			    --bs-btn-padding-y: 2rem;
			    --bs-btn-font-size: 1.5rem;
			    --bs-btn-line-height: 1.5;
				width: 19%;
    			height: 15%;
   			    margin: 15% 5%;
   			    color: var(--lsy-color-darkgray);
		    }
		</style>
	</head>
	<body>
	
			<!-- GNV 영역 -->
			<div>
				<jsp:include page="../../../mainGnv.jsp" />
			</div>
			<!-- /GNV 영역 -->
			
			<!-- 예약 버튼 영역 -->
			<div class="lsy-inner-page">
				<!-- id, name으로 줄 수 없을 때 class->class가 css가 적용된 class와 css가 적용되지 않고 이벤트 선택자로 사용하기위한 class는 구분되어야 한다. -->			
				<!-- rsv-btn : 선택자 class -->
				<button class="btn rsv-btn btn-outline-secondary align-items-center lsy-title-font" type="button">
					회원 예약
					<svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-arrow-right-short" viewBox="0 0 16 16">
						<path fill-rule="evenodd" d="M4 8a.5.5 0 0 1 .5-.5h5.793L8.146 5.354a.5.5 0 1 1 .708-.708l3 3a.5.5 0 0 1 0 .708l-3 3a.5.5 0 0 1-.708-.708L10.293 8.5H4.5A.5.5 0 0 1 4 8z"/>
					</svg>
				</button>
				<button class="btn rsv-btn btn-outline-secondary align-items-center lsy-title-font" type="button">
					비회원 예약 
					<svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-arrow-right-short" viewBox="0 0 16 16">
						<path fill-rule="evenodd" d="M4 8a.5.5 0 0 1 .5-.5h5.793L8.146 5.354a.5.5 0 1 1 .708-.708l3 3a.5.5 0 0 1 0 .708l-3 3a.5.5 0 0 1-.708-.708L10.293 8.5H4.5A.5.5 0 0 1 4 8z"/>
					</svg>
				</button>
				<button class="btn rsv-btn btn-outline-secondary align-items-center lsy-title-font" type="button">
					비회원 예약 조회
					<svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-arrow-right-short" viewBox="0 0 16 16">
						<path fill-rule="evenodd" d="M4 8a.5.5 0 0 1 .5-.5h5.793L8.146 5.354a.5.5 0 1 1 .708-.708l3 3a.5.5 0 0 1 0 .708l-3 3a.5.5 0 0 1-.708-.708L10.293 8.5H4.5A.5.5 0 0 1 4 8z"/>
					</svg>
				</button>
			</div>
			<!-- /예약 버튼 영역 -->
			
	</body>
	<script></script>
</html>