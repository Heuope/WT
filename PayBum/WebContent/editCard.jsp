<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Edit product</title>
	</head>
	<body>
		<h3>Edit product</h3>
		<form method="post">
			<input type="hidden" value="${card.id}" name="id" />
			
			<label>Number</label><br>
			<input name="number" value="${card.number}" /><br><br>
			<label>C</label><br>
			<input name="cvv" value="${card.cvv}" /><br><br>
			<label>Month</label><br>
			<input name="month" value="${card.month}" /><br><br>
			<label>Year</label><br>
			<input name="year" value="${card.year}" /><br><br>
			
			<input type="submit" value="Send" />
		</form>
	</body>
</html>