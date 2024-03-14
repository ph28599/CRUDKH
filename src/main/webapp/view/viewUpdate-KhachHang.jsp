<%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 11/30/2023
  Time: 12:42 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
<form action="/khach-hang/update?id=${kh.id}" method="post">
    <%--    <div class="mb-3">--%>
    <%--        <label class="form-label">id</label>--%>
    <%--        <input class="form-control" name="id" value="${kh.id}">--%>
    <%--    </div>--%>
    <div class="mb-3">
        <label class="form-label">ten</label>
        <input class="form-control" name="ten" value="${kh.ten}">
    </div>
    <div class="mb-3">
        <label class="form-label">sdt</label>
        <input class="form-control" name="sdt" value="${kh.sdt}">
    </div>
    <div class="mb-3">
        <label class="form-label">ngay sinh</label>
        <input class="form-control" name="ngaySinh" value="${kh.ngaySinh}">
    </div>
    <div class="mb-3">
        <label class="form-label">dia chi</label>
        <input class="form-control" name="diaChi" value="${kh.diaChi}">
    </div>
    <div class="mb-3">
        <label class="form-label">mat khau</label>
        <input class="form-control" name="matKhau" value="${kh.matKhau}">
    </div>
    <button type="submit">update</button>
</form>
</body>
</html>
