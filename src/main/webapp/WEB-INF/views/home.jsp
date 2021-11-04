<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
	<title>Home</title>
	
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<p>${message }</p>
 <%-- ${} : EL request.getAtttribute("serverTime")은 애트리뷰트 --%>
 <hr>
 <ul>
 	<li><a href="/">그냥 슬래쉬</a></li>
 	<li><a href="/day3">/day3</a></li>
 	<li><a href="test">homecontroller test</a></li>
 	<li><a href="hello">homecontroller hello</a></li>
 	<li><a href="regist">homecontroller form 입력</a></li>
 </ul>
 <ul>
 	<li><a href="list?page=23">파라미터 테스트 list?page=23</a></li>
 	<li><a href="list?page=">파라미터 테스트 list?page=</a></li>
 	<li><a href="list">파라미터 테스트 page 파라미터 없을때</a></li>
 </ul>
 <ul>
 	<li><a href="getone?idx=33">파라미터 테스트 getone?idx=33</a></li>
 	<li><a href="getone?idx=">파라미터 테스트 getone?idx=</a></li>
 	<li><a href="getone">파라미터 테스트 getone 파라미터 없을때</a></li>
 </ul>
 <ul>
 	<li><a href="param2?idx=23&search=호호호">파라미터 두개 받아오기</a><br></li>
 	<li><a href="paramn?page=6&idx=23&name=hong&search=호호호&cnt=23">파라미터 여러개 받아오기</a><br></li>
 	<li><a href="param?action=delete">파라미터로 request매핑하기</a></li>
 	<li><a href="param?action=insert">파라미터로 request매핑하기</a></li>
 	<li><a href="param">파라미터로 request매핑하기_오류 예상</a></li>
 </ul>
 
 <ul>
 	<li><a href="mv">모델 앤 뷰</a></li>
 	<li><a href="redirect">redirect hello</a></li>
 	<li><a href="redirect2">redirect2 getone with idx</a></li>
 </ul>
</body>
</html>
