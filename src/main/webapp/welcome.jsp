<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<!DOCTYPE html>
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Home</title>
	<!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css">
        
</head>
<body>
	<div class="container">
		<h1> Hello, click button to continue!</h1>
		<html:link page="/all-user.do"><button>Manage User</button></html:link>
	</div>
</body>
</html>


