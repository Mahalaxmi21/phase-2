<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<hr>
        <h3>Ecommerce Laptop Details..</h3>
<hr>
<jsp:useBean id="ProductBean" class="ecommerce.ProductBean" scope="session"></jsp:useBean>

        Product Id:    <jsp:getProperty name="productBean" property="productId" />  <br>
        Product Name:    <jsp:getProperty name="productBean" property="productName" />  <br>
        Product Price:    <jsp:getProperty name="productBean" property="price" />  <br>
<hr>

 <h3>ConsumerGoods Mobile Details..</h3>
<hr>
<jsp:useBean id="Mobiles" class="consumer.Mobiles" scope="session"></jsp:useBean>
        Product Id:    <jsp:getProperty name="mobiles" property="productId" />  <br>
        Product Name:    <jsp:getProperty name="mobiles" property="productName" />  <br>
        Product Price:    <jsp:getProperty name="mobiles" property="price" />  <br>
        <hr>
</body>
</html>