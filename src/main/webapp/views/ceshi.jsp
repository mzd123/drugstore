<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<h2>上传多个文件 实例</h2>
<form action="/add_product" method="post" enctype="multipart/form-data">
    <input type="text" name="productName" value="测试">
    <input type="text" name="productPrice" value="20">
    <input type="text" name="productDescription" value="测试使用">
    <input type="text" name="productNumber" value="100">
    <input type="text" name="classId" value="1">
    <p>主图片:<input type="file" name="image">
    <p>选择文件:<input type="file" name="images">
    <p>选择文件:<input type="file" name="images">
    <p>选择文件:<input type="file" name="images">
    <p><input type="submit" value="提交">
</form>
</body>
</html>
