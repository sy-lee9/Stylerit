<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
		<link href="/css/egovframework/gnv.css" rel="stylesheet">
		<link href="/css/egovframework/lsy-style.css" rel="stylesheet">
		
		<script src="https://code.jquery.com/jquery-3.6.3.min.js"></script>
		<title>Main GNV</title>
		<style>
		
			@media (min-height: 85px) {
		      .border-bottom lh-1 py-3 border-bottom.lsy-border-bottom {
		        height: 85px;
		      }
		    }
			
		    @media (min-height: 70px) {
		      .nav-scroller {
		        height: 70px;
		      }
		    }
		
			.nav-scroller {
			  position: relative;
			  z-index: 2;
			  overflow-y: hidden;
			}
		
		    .nav-scroller .nav {
		      display: flex;
		      flex-wrap: nowrap;
		      padding-bottom: 1rem;
		      margin-top: -1px;
		      overflow-x: auto;
		      text-align: center;
		      white-space: nowrap;
		      -webkit-overflow-scrolling: touch;
		    }
		    
		</style>
	</head>
	<body>
		<div class="container">
		
			<!-- 홈페이지 타이틀 및 로그인/회원가입/로그아웃 화면 영역 -->
			<header class="border-bottom lh-1 py-3">
				<div class="row flex-nowrap justify-content-between align-items-center">
					<!-- 메인 로고 및 메인페이지 이동 링크 -->
					<div class="col-4 text-center lsy-text-center">
						<a class="blog-header-logo text-body-emphasis text-decoration-none" href="<spring:message code='mainPageURL'></spring:message>">Stylerit</a>
					</div>
					<!-- /메인 로고 및 메인페이지 이동 링크 -->
					
					<!-- 로그인 박스 영역 -->
					<div class="col-4 d-flex justify-content-end align-items-center lsy-justify-content-end">      	
				 
						<c:choose>
					        <c:when test="${sessionScope.login != null}">
					            <jsp:include page="loginAfterBox.jsp" />
					        </c:when>
					        <c:otherwise>
					            <jsp:include page="loginBeforeBox.jsp" />            
					        </c:otherwise>
					    </c:choose>
					</div>
					<!-- /로그인 박스 영역 -->
				</div>
			</header>
			<!-- /홈페이지 타이틀 및 로그인/회원가입/로그아웃 화면 영역 -->
			
			<!-- 메인 GNV 영역 -->
			<div class="nav-scroller py-1 mb-3 border-bottom" id="menuBottomDiv">
				<nav class="nav nav-underline justify-content-between lsy-nav-underline">
					<a class="nav-item nav-link link-body-emphasis" href="javascript:void(0)" data-menu-type="inf">소개</a>
					<a class="nav-item nav-link link-body-emphasis" href="javascript:void(0)" data-menu-type="mn">메뉴</a>
					<a class="nav-item nav-link link-body-emphasis" href="javascript:void(0)" data-menu-type="dsn">디자이너</a>
					<a class="nav-item nav-link link-body-emphasis" href="javascript:void(0)" data-menu-type="rsv">예약</a>
					<a class="nav-item nav-link link-body-emphasis" href="javascript:void(0)" data-menu-type="rvw">리뷰</a>
					<a class="nav-item nav-link link-body-emphasis" href="javascript:void(0)" data-menu-type="usr">마이페이지</a>
			    </nav>
			</div>
			<!-- /메인 GNV 영역 -->
			
		</div>
	</body>
	<script>
	
		//이동한 페이지
		var page = "${page}";
		
		//현재 페이지에 따라 메뉴바 active 설정
		if(page == '' || page == 'inf'){
			$("#menuBottomDiv .nav-item[data-menu-type='inf']").addClass('active');		
		}else if(page == 'mn'){
			$("#menuBottomDiv .nav-item[data-menu-type='mn']").addClass('active');		
		}else if(page == 'dsn'){
			$("#menuBottomDiv .nav-item[data-menu-type='dsn']").addClass('active');		
		}else if(page == 'rsv'){
			$("#menuBottomDiv .nav-item[data-menu-type='rsv']").addClass('active');		
		}else if(page == 'rvw'){
			$("#menuBottomDiv .nav-item[data-menu-type='rvw']").addClass('active');		
		}else if(page == 'usr'){
			$("#menuBottomDiv .nav-item[data-menu-type='usr']").addClass('active');		
		}
	
		
		//메뉴바 선택 시 이동 URL 
		$("#menuBottomDiv .nav-item").click(function(){
			
			//data-option
			var menuType = $(this).data("menu-type");
			
			if(menuType == '' || menuType == 'inf'){
				location.href="/inf/inf1000/inf1000/selectInf1000View.do";
			}else if(menuType == 'mn'){
				location.href="/mn/mn1000/mn1000/selectMn1000View.do";
			}else if(menuType == 'dsn'){
				location.href="/dsn/dsn1000/dsn1000/selectDsn1000View.do";
			}else if(menuType == 'rsv'){
				location.href="/rsv/rsv1000/rsv1000/selectRsv1000View.do";
			}else if(menuType == 'rvw'){
				location.href="/rvw/rvw1000/rvw1000/selectRvw1000View.do";
			}else if(menuType == 'usr'){
				location.href="/usr/usr1000/usr1000/selectUsr1000View.do";
			}
			
		});
		
	</script>
</html>