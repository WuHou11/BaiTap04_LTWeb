<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<html>
<head>
<title>User/Admin Home</title>
<style>
body {
    font-family: Arial, sans-serif;
    margin: 20px;
    background: #fff;
}

h2 {
    text-align: center;
}

a {
    text-decoration: none;
    margin: 0 10px;
    color: black;
}

table {
    width: 80%;
    margin: 20px auto;
    border-collapse: collapse;
    border: 1px solid #000;
}

th, td {
    border: 1px solid #000;
    padding: 8px;
    text-align: center;
}

.btn {
    padding: 4px 8px;
    border: 1px solid #000;
    border-radius: 3px;
    font-size: 13px;
    background: none;
    color: black;
}
</style>
</head>
<body>
    <h2>Trang Home (User)</h2>
    <div style="text-align: center;">
        <a href="${pageContext.request.contextPath}/category/list" class="btn">Quản lý Category</a>
        <a href="${pageContext.request.contextPath}/logout" class="btn">Thoát</a>
    </div>

    <table>
        <tr>
            <th>ID</th>
            <th>Tên</th>
            <th>Người tạo</th>
        </tr>
        <c:forEach var="c" items="${categories}">
            <tr>
                <td>${c.cateId}</td>
                <td>${c.cateName}</td>
                <td>${c.user.username}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
