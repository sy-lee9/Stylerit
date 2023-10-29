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
		<title>Designer</title>
		<style>
			.g-4, .gy-4 {
			    --bs-gutter-x: 7.5rem !important;
			    
			}
			.content{
				margin-top: 5%;
			}
		</style>
	</head>
	<body>
		<!-- GNV 영역 -->
		<div>
			<jsp:include page="../../../mainGnv.jsp" />
		</div>
		<!-- /GNV 영역 -->
		
		<!-- 디자이너 정보 영역 -->
		<div class="row row-cols-1 row-cols-lg-3 align-items-stretch g-4 py-5 lsy-inner-page" id="list">
			
		</div>
		<!-- /디자이너 정보 영역 -->
	</body>
	<script>
	
		listCall();
	
		//디자이너 정보 불러오기
		function listCall(){
			
			$.ajax({
			type:'post',
			url:'/dsn/dsn1000/dsn1000/selectDsnInfoAjax.do',
			dataType:'json', 
			success:function(data){
				//디자이너 정보 출력
				listPrint(data.dsnInfo);
			
			},
			error:function(e){
				console.log(e);
				alert('오류가 발생했습니다. 잠시 후 다시 시도해주세요.');
			}
		   });
		}
	
		
		//디자이너 정보 출력
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
		    	
		    	content += '<div class="col">'
		 				 +  '<div class="card card-cover overflow-hidden text-bg-dark rounded-4 shadow-lg">'
	               	     +  '<img width="auto" height="300" src="/photo/'+item.d_PT+'">'
	               	  	 +  '</div>'
		        		 +  '<div class="content">'
	      	 		 	 +  '<h3 class="lsy-title-font">'+item.d_NM+' '+item.d_POS_CD+'</h3>'
	      	 		 	 +  '<p class="review">⭐'+item.rv_RT+'  리뷰 '+item.rv_CNT+'</p>'
	      	 		 	 +	'<p class="lsy-content-font">'+item.d_INTR+'</p>'
	      	 		 	 +	'</div>'
	      	 		 	 +	'</div>';
	
		    });
		    
		    //list 영역 비워준 후
		    $('#list').empty();
		    //출력
			$('#list').append(content);
		}
	
	</script>
</html>