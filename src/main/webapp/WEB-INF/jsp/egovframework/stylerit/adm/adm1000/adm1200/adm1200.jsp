<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
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
		<title>Member Administration</title>
		<style>
			
			svg{
				margin-right: 0.5rem!important;
    			margin-left: 0.5rem!important;
			}
			
			.selector{
				margin-left: 10px;
			    width: auto !important;
			}
			
			th, td{
				text-align: center!important;
			}
			
		</style>
	</head>
	<body>
		
		<!-- 관리 페이지 GNV 영역 -->
		<div>
			<jsp:include page="../../../admGnv.jsp" />
		</div>
		<!-- /관리 페이지 GNV 영역 -->

		<form id="listForm" method="post" action="">
			<input type="hidden" name="pageNo" value="">
			<input type="hidden" id="param1" name="memberState" value="">
			<input type="hidden" id="param2" name="searchValue" value="">	
		
		<!-- 회원 정보 리스트 영역 -->
		<div class="lsy-inner-page">
		
			<div class="row flex-nowrap justify-content-between align-items-center">
						
				<!-- 조회 할 회원상태 선택바 -->		
				<div class="selector">
			      	<select id="memberState">				
						<option value="DEFAULT">전체</option>
						<option value="ACT_MB">사용회원</option>
						<option value="DM_MB">휴먼회원</option>
						<option value="WTD_MB">탈퇴회원</option>	
						<option value="RT_MB">이용제한 회원</option>		
					</select>
				</div>
				<!-- /조회할 회원상태 선택바 -->
				
				<!-- 조회할 회원 이름 검색바 -->	
				<div class="d-flex align-items-center lsy-search-box">
					<input type="text" id="searchValue" placeholder="회원 이름 검색">
					<a class="link-secondary" href="javascript:void(0)" onclick="searchName()" aria-label="Search">
						<svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" class="mx-3" role="img" viewBox="0 0 24 24"><title>Search</title><circle cx="10.5" cy="10.5" r="7.5"/><path d="M21 21l-5.2-5.2"/></svg>
					</a>
				</div>
				<!-- /조회할 회원 이름 검색바 -->	
		    </div>
		
			<hr>
				
			<!-- 회원 정보 출력 영역 -->
	        <table class="table">
				<thead>
		            <tr>
		              <th>이용상태</th>
		              <th>이메일</th>
		              <th>이름</th>
		              <th>성별</th>
		              <th>생년월일</th>
		              <th>연락처</th>
		              <th>가입일</th>
		              <th>시술 횟수</th>
		              <th>이용금액</th>
		              <th>예약취소 횟수</th>
		            </tr>
				</thead>
	          	<tbody id="list">
	            	<c:forEach items="${memberInfoList}" var="info">
	            		<tr>
					        <td>${info.M_ST}</td>
					        <td>${info.M_EML}</td>
					        <td>${info.M_NM}</td>
					        <td>${info.M_GND}</td>
					        <td>${info.M_BTD}</td>
					        <td>${info.M_TEL}</td>
					        <td>${info.M_JOIN_D}</td>
					        <td>${info.totalNum}</td>
					        <td>${info.totalPrice}</td>
					        <td>${info.reservationCancleNum}</td>
				      	</tr>
	            	</c:forEach>
				</tbody>
	        </table>
			<!-- 회원 정보 출력 영역 -->
			
			
			<c:if test="${not empty paginationInfo}">
				<div id="paging">
					<ui:pagination paginationInfo = "${paginationInfo}" type="image" jsFunction="linkPage"/>
				</div>
			</c:if>

			
		</div>
		</form>
	</body>
	<script>
		
		var currentPageNo = ${pageNo};	
		 
		function linkPage(pageNo){

			var memberState = $('#memberState').val();
			var searchValue = $('#searchValue').val();
			
			$('input[name="pageNo"]').val(pageNo);
			$('input[name="memberState"]').val(memberState);
			$('input[name="searchValue"]').val(searchValue);
			$("#listForm").attr("action", "<c:url value='/adm/adm1000/adm1200/selectMemberInfo.do'/>");
			$("#listForm").submit();
			
		}

		
		$('#memberState').change(function(){
			linkPage(currentPageNo);
		});

		function searchName(){
			linkPage(currentPageNo);
		}
		
		// 엔터 키 누를 때 링크 동작 방지
		$('#searchValue').on("keydown", function(event) {
		    if (event.key === "Enter") {
		        event.preventDefault(); // 기본 동작 중지
		        searchName(); // 링크 클릭
		      }
		});
		
	</script>
</html>