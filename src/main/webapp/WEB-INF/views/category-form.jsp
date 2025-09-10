<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<html>
<head>
<title>Category Form</title>
<style>
body {
	font-family: Arial, sans-serif;
	padding: 20px;
}

h2 {
	text-align: center;
}

form {
	border: 1px solid #000;
	padding: 15px;
	width: 300px;
	margin: auto;
}

label {
	display: block;
	margin-bottom: 6px;
}

input[type="text"] {
	width: 95%;
	padding: 5px;
	margin-bottom: 10px;
	border: 1px solid #000;
}

.buttons {
	display: flex;
	gap: 10px;
}

input[type="submit"], .cancel-btn {
	padding: 5px 10px;
	border: 1px solid #000;
	background: #fff;
	cursor: pointer;
	text-decoration: none;
	color: #000;
}
</style>
</head>
<body>

	<h2>${category != null ? "Edit Category" : "Add Category"}</h2>

	<form method="post"
		action="${pageContext.request.contextPath}/category/${category != null ? "edit" : "add"}">

		<c:if test="${category != null}">
			<input type="hidden" name="cateId" value="${category.cateId}" />
		</c:if>

		<label for="cate_name">Tên Category:</label> <input type="text"
			id="cateName" name="cateName"
			value="${category != null ? category.cateName : ''}" required />


		<div class="buttons">
			<input type="submit" value="Save" /> <a
				href="${pageContext.request.contextPath}/category/list"
				class="cancel-btn">Cancel</a>
		</div>
	</form>

</body>
</html>
