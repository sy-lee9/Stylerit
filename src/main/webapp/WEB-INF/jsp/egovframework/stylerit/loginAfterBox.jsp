<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>

<!-- Custom styles for this template -->
<link href="https://fonts.googleapis.com/css?family=Playfair&#43;Display:700,900&amp;display=swap" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="/css/lsy-style.css" rel="stylesheet">

<div id="loginBox">
	<c:if test="${sessionScope.M_AUTR_CD == 'MEMBER'}">
		반가워요 <b>${sessionScope.M_NM}</b>님! 
		<a class="btn btn-sm btn-outline-secondary btn-outline-secondary.lsy-btn-outline-secondary" href="<spring:message code='logout.redirectURL'></spring:message>">로그아웃</a>
	</c:if>
	<c:if test="${sessionScope.D_AUTR_CD == 'DESIGNER' || sessionScope.D_AUTR_CD == 'ADMIN'}">
		반가워요 <b>${sessionScope.D_NM}</b> 디자이너님!
		<a class="btn btn-sm btn-outline-secondary btn-outline-secondary.lsy-btn-outline-secondary" href="<spring:message code='logout.redirectURL'></spring:message>">로그아웃</a>
	</c:if>
	<c:if test="${sessionScope.D_AUTR_CD == 'ADMIN'}">
		<a class="btn btn-sm btn-outline-secondary btn-outline-secondary.lsy-btn-outline-secondary" href="<spring:message code='adm.mainPageURL'></spring:message>" style='color: red;'>관리자 페이지</a>
	</c:if>
</div>
