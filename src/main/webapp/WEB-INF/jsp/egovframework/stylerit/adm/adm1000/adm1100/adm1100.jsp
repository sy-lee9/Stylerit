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
				
		<!-- Dragula -->
		<script src="https://cdnjs.cloudflare.com/ajax/libs/dragula/3.7.3/dragula.min.js" type="text/javascript"></script>
		
		<script src="https://code.jquery.com/jquery-3.2.1.min.js" type="text/javascript"></script>
		<title>Menu Administration</title>
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
            
            .table{
           	    text-align: center;
    			width: 70%!important;
    			margin-inline: auto;
    			margin-top: 30px;
            }
            
            tr{
            	height: 100px;
            	vertical-align: middle;
            }
            

			td.move {
			  cursor: grab;
			}
            
			.gu-mirror {
			  position: fixed !important;
			  margin: 0 !important;
			  color: orangered;
			  z-index: 9999 !important;
			  opacity: 0.8;
			}
			
			.gu-hide {
			  display: none !important;
			}
			
			.gu-unselectable {
			  -webkit-user-select: none !important;
			  -moz-user-select: none !important;
			  -ms-user-select: none !important;
			  user-select: none !important;
			}
			
			.gu-transit {
			  opacity: 0.2;
			}
			
		</style>
	</head>
	<body>
		<!-- GNV 영역 -->
		<div>
			<jsp:include page="../../../admGnv.jsp" />
		</div>
		<!-- /GNV 영역 -->
		
		<!-- 메뉴 영역 -->
		<div class="lsy-inner-page">
		
			<!-- 메뉴 분류 출력 영역 -->
			<ul class="nav nav-underline lsy-nav-underline">
				<li class="nav-item nav-link link-body-emphasis" data-tab-target="all">전체</li>
				<c:forEach items="${menuList}" var="menu">					
					<li class="nav-item nav-link link-body-emphasis" data-tab-target="${menu.MN_CL_CD}">${menu.MN_NM}</li>
				</c:forEach>
			</ul>
			<!-- /메뉴 분류 출력 영역 -->
	        
        	<!-- 메뉴 리스트 출력 영역 -->
	        <table class="table">
				<thead>
		            <tr>
		              <th>메뉴명</th>
		              <th>가격</th>
		              <th></th>
		            </tr>
				</thead>
	          	<tbody id="list">
	          		
				</tbody>
	        </table> 
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
		    	
		    	content += '<tr>'
               	 		 +  '<td>'+item.mn_NM+'</td>'
	               	     +  '<td>'+item.mn_PR+'</td>'
	               	     +  '<td class="move">≡</td>'
	               	  	 +  '</tr>';			        
					        
		    });
		    
		    //list 영역 비워준 후
		    $('#list').empty();
		    //출력
			$('#list').append(content);

			//드래그 활성화
			setDragula();
			
		    //드래그 영역 설정
			$(document).on('mousemove', 'td', function() {
			    // Move 영역이 아니면 Drag 되지 않음
			    if (!$(this).hasClass('move')) {
			      drake.cancel();
			    }
			});
		}
		
		
		//dragula 설정을 담을 변수
		var drake;

		//드래그 활성화
		function setDragula() {
			
			//드래그 가능 영역 선택 및 설정 
			drake = dragula([document.getElementById('list')], {
				//해당 영역 드래그 시 복사 기능 해제
				copy: false,
				//설정 영역 벗어날 경우 원래 자리로 복구
				revertOnSpill: true,
				//설정 영역 벗어나도 삭제하지 않음
				removeOnSpill: false
		  	})
			
		};
				

		//메뉴 순서 DB에 저장
		
		
		
	</script>
</html>