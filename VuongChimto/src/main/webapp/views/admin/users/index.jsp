<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>

<c:if test="${empty ds}">
    <p class="alert alert-warning">
        Vui Lòng Thêm Mới Dữ Liệu
    </p>
</c:if>
<c:if test="${!empty ds}">
    <p class="alert alert-success">
        Data OK
    </p>
    <table class="table table-success table-striped">
        <thead>
        <tr>
            <th scope="col">Name</th>
            <th scope="col">Address</th>
            <th scope="col">Phone</th>
            <th scope="col">Email</th>
            <th scope="col">Password</th>
            <th scope="col">Gender</th>
<%--            <th scope="col">Custommer</th>--%>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${ds}" var="user">
            <tr>
                <td>${user.hoTen}</td>
                <td>${user.diaChi}</td>
                <td>${user.sdt}</td>
                <td>${user.email}</td>
                <td>${user.password}</td>
                    <%--           <td>${user.gender==true ? "Boy" : "Girl"}</td>--%>
                <td>
                    <c:choose>
                        <c:when test="${user.gioiTinh==1}">Boy</c:when>
                        <c:when test="${user.gioiTinh==0}">Girl</c:when>
                        <c:otherwise>-</c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <td>
            <a  class="btn btn-primary" href="/VuongChimto/edit?id=${user.id}" href="">cap nhat</a>
            </td>
            <td>
            <a class="btn btn-primary" href="/VuongChimto/delete?id=${user.id}" href="">xoa</a>
            </td>
        </c:forEach>
        </tbody>
    </table>
</c:if>