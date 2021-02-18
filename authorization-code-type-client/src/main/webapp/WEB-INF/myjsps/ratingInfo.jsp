<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JLC Bookstore</title>
<style>
	div,table{
		font-size: 25px;
	}
</style>
</head>
<body>
<div align="center">
	<h2>JLCBookStoreWeb - An OAuth2 Client</h2>
	<h3>Book Rating Information</h3>
	<table class="table">
	<tr>
		<td><b>UserId</b></td>
		<td><b>BookId</b></td>
		<td><b>Rating</b></td>
		<td><b>Review</b></td>
		</tr>
		<c:forEach var="myratingInfo" items="${myRatingList}">
			<tr>
			<td>${myratingInfo.userId}</td>
			<td>${myratingInfo.bookId}</td>
			<td>${myratingInfo.rating}</td>
			<td>${myratingInfo.review}</td>
			</tr>
		</c:forEach>
	</table>
</div>
<div align="center">
<h3><a href="/">Go to home</a></h3>
</div>
</body>
</html>