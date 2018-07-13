<%-- 
    Document   : listEmployee
    Created on : Jun 18, 2017, 3:23:57 PM
    Author     : KhuongND
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<div class="row" style="text-align:center">
    <h3 style="text-transform: uppercase">Lịch sử mượn sách</h3>
</div>
<c:if test="${not empty listHistory}">
    <table class="table table-hover table-striped">
        <thead>
            <tr>
                <th>Mã</th>
                <th>Tên Sách</th>
                <th>Người Mượn</th>
                <th>Ngày mượn</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="h" items="${listHistory}">
                <tr>
                    <td>${h.currBook.id}</td>
                    <td>${h.currBook.name} </td>
                    <td>${h.userName}</td>
                    <td>${h.borrowDate}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</c:if>