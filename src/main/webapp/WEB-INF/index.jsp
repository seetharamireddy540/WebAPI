<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Token Post</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
</head>
<body>

<form name="myRedirectForm" id="myRedirectForm" action="http://localhost:8080/Project2/LaunchServlet" method="post">
    <input name="accessToken" type="hidden" value="<%= session.getAttribute("accessToken") %>" />
    <input name="phone" type="hidden" value="9898989898" />
    <noscript>
        <input type="submit" value="Click here to continue" />
    </noscript>
</form>
<script type="text/javascript">

    $(document).ready(function() {
    	var formData = JSON.stringify($("#myRedirectForm").serializeArray());
    	alert(formData);
        document.myRedirectForm.submit();
    });

</script>
<p>Test</p>

</body>
</html>