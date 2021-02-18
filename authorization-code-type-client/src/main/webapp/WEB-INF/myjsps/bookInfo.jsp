<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JLC BookStore</title>
<style>
	div,table{
		font-size: 25px;
	}
</style>
</head>
<body>
	<div align="center">
		<h2>JLCBookStoreWeb - An OAuth2 Client</h2> 
		<h3>Book Price Information</h3>
		<table class="table">
			<tr>
			<td><b>BookId</b></td>
			<td>${mybookPriceInfo.bookId}</td>
			</tr>
			<tr>
			<td><b>Price</b></td>
			<td>${mybookPriceInfo.price}</td>
			</tr>
			<tr>
			<td><b>Offer</b></td>
			<td>${mybookPriceInfo.offer}</td>
			</tr>
		</table>
	</div>
	<div align="center">
	<h3><a href="/">Go to home</a></h3>
	</div>
</body>
</html>