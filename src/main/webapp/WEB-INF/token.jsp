<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Token Post</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
</head>
<body>

<form name="myRedirectForm" id="myRedirectForm" action="https://login.microsoftonline.com/542e52ae-1078-46e7-87d2-15622a28f967/oauth2/token" method="post">
  <input name="grant_type" type="hidden" value="authorization_code" />
  <input name="code" type="hidden" value="<%= session.getAttribute("code") %>" />
  <input name="scope" type="hidden" value="patient/*.read" />
  <input name="redirect_uri" type="hidden" value="http://localhost:8080/Project1/postAuth" />
  <input name="response_mode" type="hidden" value="form_post" />
  <input name="client_id" type="hidden" value="86480a3c-2736-4983-ad11-15f2ce4430c7" />
  <input name="resource" type="hidden" value="https://dev-gehccloud.com/fhirapiserver" />
  <input name="state" type="hidden" value="34555" />
  <input name="client_secret" type="hidden" value="65Z3ap5XqNA0h6rPA/ZcrWl7RITPgChC56vkdXs8ykc=" />
    <noscript>
        <input type="submit" value="Click here to continue" />
    </noscript>
</form>
<script type="text/javascript">

    $(document).ready(function() {
    	var formData = JSON.stringify($("#myRedirectForm").serializeArray());
        document.myRedirectForm.submit();
    });

</script>
<p>Test</p>

</body>
</html>