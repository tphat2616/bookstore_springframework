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

<!--<script src="resources/themes/lbd/assets/js/moment.js" type="text/javascript"></script>
<link href="resources/themes/lbd/assets/css/bootstrap-datetimepicker.min.css" rel="stylesheet" type="text/css"/>
<script src="resources/themes/lbd/assets/js/bootstrap-datetimepicker.min.js" type="text/javascript"></script>-->
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="resources/themes/lbd/assets/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <script src="resources/themes/lbd/assets/js/jquery-1.10.2.js" type="text/javascript"></script>
        <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        <title>Mượn sách</title>
    </head>
    <body>
        <div class="col-md-12" style="text-align:center">
            <div class="col-md-4">
            </div>
            <div class="col-md-4" style="text-align: left">
                <spring:url var="saveBorrowBookUrl" value="save-borrow-book"/> 
                <form:form class="form-horizontal" method="POST" modelAttribute="book" action="${saveBorrowBookUrl}">

                    <label>Tên người mượn</label>
                    <form:input path="userName" type="text" class="form-control" id="userName" placeholder="Nhập tên người mượn sách"/>
                    <label>Ngày mượn</label>
                    <form:input path="borrowDate" type="text" class="form-control" id="datepicker" placeholder="Nhập ngày mượn"/>
                    <div class="row" style="margin-top: 10px">
                        <form:hidden path="idBook"/>
                        <a href="home" class="btn btn-default pull-left">Trở về</a>
                        <input type="submit" class="btn btn-primary pull-right" value="Lưu lại"/>
                    </div>

                </form:form>

            </div>
            <div class="col-md-4">
            </div>
        </div>
    </body>
    <script>
        $(function () {
            $("#datepicker").datepicker({dateFormat: 'dd/mm/yy'});
        });
    </script>
</html>
