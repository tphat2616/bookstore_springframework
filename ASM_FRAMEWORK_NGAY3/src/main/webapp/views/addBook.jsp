<%-- 
    Document   : addBook
    Created on : Jun 27, 2017, 8:03:01 PM
    Author     : KhuongND
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%> 
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link href="resources/themes/lbd/assets/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<script src="resources/themes/lbd/assets/js/jquery-1.10.2.js" type="text/javascript"></script>
<!--<script src="resources/themes/lbd/assets/js/moment.js" type="text/javascript"></script>
<link href="resources/themes/lbd/assets/css/bootstrap-datetimepicker.min.css" rel="stylesheet" type="text/css"/>
<script src="resources/themes/lbd/assets/js/bootstrap-datetimepicker.min.js" type="text/javascript"></script>-->
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quản lý thư viên sách</title>
    </head>
    <body>
        <div class="col-md-12" style="text-align:center">
            <c:choose>

                <c:when test = "${not empty book.id}">
                    <spring:url var="addBookUrl" value="update-book"/>
                    <c:set var = "title" value = "Cập nhật sách"/>
                    <c:set var = "titleBtn" value = "Cập nhật"/>
                </c:when>
                <c:otherwise>
                    <spring:url var="addBookUrl" value="create-book"/> 
                    <c:set var = "title" value = "Tạo mới sách"/>
                    <c:set var = "titleBtn" value = "Tạo mới"/>
                </c:otherwise>
            </c:choose>

            <h1 style="margin-top:10px"> <c:out value = "${title}"/></h1>
            <div class="col-md-4">
            </div>
            <div class="col-md-4" style="text-align: left">

                <form:form class="form-horizontal" method="POST" modelAttribute="book" action="${addBookUrl}">
                    <label>Tên sách</label>
                    <form:hidden path="id"/>
                    <form:input path="name" type="text" class="form-control" id="name" placeholder="Nhập tên"/>
                    <label>Tác giả</label>
                    <form:input path="author" type="text" class="form-control" id="author" placeholder="Nhập tên tác giả"/>
                    <label>Ngày</label>
                    <form:input path="release_date" type="text" class="form-control" id="release_date" placeholder="Nhập ngày"/>
                    <div class="row" style="margin-top: 10px">
                        <a href="home" class="btn btn-default pull-left">Trở về</a>
                        <input type="submit" class="btn btn-primary pull-right" value="<c:out value = "${titleBtn}"/>">
                    </div>

                </form:form>

            </div>
            <div class="col-md-4">
            </div>
        </div>
    </body>
</html>
