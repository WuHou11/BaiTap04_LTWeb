<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<html>
<head>
<title>Category List</title>
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
    <h2>Danh sách Category</h2>
    <div style="text-align: center;">
        <a href="${pageContext.request.contextPath}/category/add" class="btn">Thêm mới</a>
        <a href="${pageContext.request.contextPath}/logout" class="btn">Thoát</a>
    </div>

    <table>
        <tr>
            <th>ID</th>
            <th>Tên</th>
            <th>Người tạo</th>
            <th>Action</th>
        </tr>
        <c:forEach var="c" items="${categories}">
            <tr>
                <td>${c.cateId}</td>
                <td>${c.cateName}</td>
                <td>${c.user.username}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/category/edit?id=${c.cateId}" class="btn">Edit</a>
                    <a href="${pageContext.request.contextPath}/category/delete?id=${c.cateId}" 
                       onclick="return confirm('Xóa category này?')" class="btn">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
