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
		<title>Menu</title>
		<style>
			.lsy-inner-page{
				margin: 10% 20%;
			}
			
			p{
				display: inline;
			}
			
		    .list-unstyled{
			    margin-top: 11px;
		    }
		    		        
	        .col-lg-8{
	        	width: 690px!important;	        	
			    padding-left: 18%;
	        }
	        
	        .mb-0{
	            display: inline;
	        }
	            
            .text-body-secondary{
            	float: right;
            }
            li{
            	cursor: pointer;
            }
		</style>
	</head>
	<body>
		<!-- GNV 영역 -->
		<div>
			<jsp:include page="../../../mainGnv.jsp" />
		</div>
		<!-- /GNV 영역 -->
		
		<!-- 메뉴 영역 -->
		<div class="lsy-inner-page-menu">
		
			<!-- 메뉴 분류 출력 영역 -->
			<ul class="nav nav-underline lsy-nav-underline">
				<li class="nav-item nav-link link-body-emphasis" data-tab-target="all">전체</li>
				<c:forEach items="${menuList}" var="menu">					
					<li class="nav-item nav-link link-body-emphasis" data-tab-target="${menu.MN_CL_CD}">${menu.MN_NM}</li>
				</c:forEach>
			</ul>
			<!-- /메뉴 분류 출력 영역 -->
	        
        	<!-- 메뉴 리스트 출력 영역 -->
	        <ul class="list-unstyled" id="list">

	        </ul>	        
        	<!-- /메뉴 리스트 출력 영역 -->
        	
        </div>
        <!-- /메뉴 출력 영역 -->
	</body>
	<script>
	
		//페이지 최초 로딩 시 전체 메뉴 리스트 출력
		listCall('all');
	
		//메뉴 클릭 시 실행되는 함수
		$('li').click(function(){

			//기존에 활성화되어있던 메뉴 비활성화
		    $('li.active').removeClass('active');
			
			//선택된 메뉴의 data 가져오기
			var selectMenu = $(this).attr('data-tab-target');
			//해당 메뉴 활성화
			$(this).addClass('active');		
			
			//선택된 메뉴 리스트 호출
			listCall(selectMenu);
			
		});
		
	
		//메뉴 리스트 불러오기
		function listCall(selectMenu){
			
			$.ajax({
			type:'post',
			url:'/mn/mn1000/mn1000/selectMnListAjax.do',
			data:{
			 'selectMenu':selectMenu
			},  
			dataType:'json', 
			success:function(data){
				//반환된 메뉴 리스트로 메뉴 정보 출력
				listPrint(data.menuList);
			
			},
			error:function(e){
				console.log(e);
				alert('오류가 발생했습니다. 잠시 후 다시 시도해주세요.');
			}
		   });
		}

		
		//메뉴 리스트 출력
		function listPrint(list) {

		    var content = '';
		    
		    //리스트에 담긴 정보가 없을 경우
		    if (list.length === 0) {
		        $('#list').empty();
				$('#list').append(content);
		        return;
		    }
		   
		    //리스트 출력
		    list.forEach(function(item) {
		    	
		    	content += '<li class="gap-3 align-items-start align-items-lg-center text-decoration-none border-top lsy-menu-gap">'
               	 		 +  '<div class="col-lg-8">'
	               	     +  '<h6 class="mb-0 lsy-title-font">'+item.mn_NM+'</h6>'
	               	  	 +  '<small class="text-body-secondary">'+item.mn_PR+'원</small>'
		        		 +  '</div>'
          	 		 	 +  '</li>';

		    });
		    
		    //list 영역 비워준 후
		    $('#list').empty();
		    //출력
			$('#list').append(content);
		}
	
	</script>
</html>