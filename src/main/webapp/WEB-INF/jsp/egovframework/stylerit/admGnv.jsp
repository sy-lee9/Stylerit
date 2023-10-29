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
		<link href="/css/egovframework/gnv.css" rel="stylesheet">
		<link href="/css/egovframework/lsy-style.css" rel="stylesheet">
		
		<script src="https://code.jquery.com/jquery-3.6.3.min.js"></script>
		<title>Administration GNV</title>
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
						<a class="blog-header-logo text-body-emphasis text-decoration-none" href="/">Stylerit</a>
					</div>
					<!-- /메인 로고 및 메인페이지 이동 링크 -->
					
					<!-- 로그인 박스 영역 -->
					<div class="col-4 d-flex justify-content-end align-items-center lsy-justify-content-end">      	
						<c:choose>
					        <c:when test="${!sessionScope.login.equals('')}">
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
			<!-- /관리자 타이틀 및 로그인/회원가입/로그아웃 화면 영역 -->
			
			<!-- 관리자 페이지 GNV 영역 -->
			<div class="nav-scroller py-1 mb-3 border-bottom" id="menuBottomDiv">
				<nav class="nav nav-underline justify-content-between lsy-nav-underline">					
					<a class="nav-item nav-link link-body-emphasis" href="javascript:void(0)" data-menu-type="infAdm">소개 관리</a>
					<a class="nav-item nav-link link-body-emphasis" href="javascript:void(0)" data-menu-type="mnAdm">메뉴 관리</a>
					<a class="nav-item nav-link link-body-emphasis" href="javascript:void(0)" data-menu-type="mbAdm">회원 관리</a>
					<a class="nav-item nav-link link-body-emphasis" href="javascript:void(0)" data-menu-type="dsnAdm">디자이너 관리</a>
					<a class="nav-item nav-link link-body-emphasis" href="javascript:void(0)" data-menu-type="rsvAdm">예약 관리</a>
					<a class="nav-item nav-link link-body-emphasis" href="javascript:void(0)" data-menu-type="rvwAdm">리뷰 관리</a>
			    </nav>
			</div>
			<!-- /관리자 페이지 GNV 영역 -->
		</div>
		
	</body>
	<script>
	
		//이동한 페이지
		var page = "${page}";
		
		//현재 페이지에 따라 메뉴바 active 설정
		if(page == '' || page == 'infAdm'){
			$("#menuBottomDiv .nav-item[data-menu-type='infAdm']").addClass('active');		
		}else if(page == 'mnAdm'){
			$("#menuBottomDiv .nav-item[data-menu-type='mnAdm']").addClass('active');		
		}else if(page == 'mbAdm'){
			$("#menuBottomDiv .nav-item[data-menu-type='mbAdm']").addClass('active');		
		}else if(page == 'dsnAdm'){
			$("#menuBottomDiv .nav-item[data-menu-type='dsnAdm']").addClass('active');		
		}else if(page == 'rsvAdm'){
			$("#menuBottomDiv .nav-item[data-menu-type='rsvAdm']").addClass('active');		
		}else if(page == 'rvwAdm'){
			$("#menuBottomDiv .nav-item[data-menu-type='rvwAdm']").addClass('active');		
		}
		
		//메뉴바 선택 시 이동 URL 
		$("#menuBottomDiv .nav-item").click(function(){
			
			//data-option
			var menuType = $(this).data("menu-type");
			
			if(menuType == '' || menuType == 'infAdm'){
				location.href="/adm/adm1000/adm1000/selectAdm1000View.do";
			}else if(menuType == 'mnAdm'){
				location.href="/adm/adm1000/adm1100/selectAdm1100View.do";
			}else if(menuType == 'mbAdm'){
				location.href="/adm/adm1000/adm1200/selectAdm1200View.do";
			}else if(menuType == 'dsnAdm'){
				location.href="/adm/adm1000/adm1300/selectAdm1300View.do";
			}else if(menuType == 'rsvAdm'){
				location.href="/adm/adm1000/adm1400/selectAdm1400View.do";
			}else if(menuType == 'rvwAdm'){
				location.href="/adm/adm1000/adm1500/selectAdm1500View.do";
			}
			
		});
	
	</script>
</html>