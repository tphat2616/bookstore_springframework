<%-- 
    Document   : home
    Created on : Jun 27, 2017, 7:01:54 PM
    Author     : KhuongND
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<link href="resources/themes/lbd/assets/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<script src="resources/themes/lbd/assets/js/jquery-1.10.2.js" type="text/javascript"></script>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quản lý thư viên sách</title>
    </head>
    <body>
        <div class="row col-md-12">
            <div class="pull-right">
                <a href="add-book">Add new</a>
            </div>

            <c:if test="${not empty listBooks}">
                <table class="table table-hover table-bordered">
                    <thead>
                        <tr>
                            <th>Mã số</th>
                            <th>Tên</th>
                            <th>Tác giả</th>
                            <th>Ngày</th>
                            <th>Control</th>
                        </tr>
                    </thead>
                    <c:forEach var="a" items="${listBooks}">
                        <tr>
                            <td>${a.id}</td>
                            <td><a href="edit-book?id=${a.id}">${a.name}</a></td>
                            <td>${a.author}</td>
                            <td>
                                <fmt:formatDate value="${a.release_date}" pattern="dd/MM/yyyy" />
                            </td>
                            <td><a href="borrow-book?idBook=${a.id}">Mượn Sách</a>|| <a href="#" onclick="loadListHistory(${a.id})">Lịch sử</a></td>
                        </tr>
                    </c:forEach>
                </table>
            </c:if>
        </div>
        <div class="row col-md-12">
            
            <div id="view-history">

            </div>

        </div>
    </body>
    <script>
        $(function () {
        });
        function loadListHistory(idBook) {
            $.ajax({
                type: "GET",
                url: "list-book-history?idBook=" + idBook,
                success: function (data) {
                    $("#view-history").html(data);
                }

            });
        }
    </script>
</html>
