<html>
<body>
	<h1>JAX-RS Upload Form</h1>
 
	
	<form action="rest/file/pojo/upload" method="post" enctype="multipart/form-data">
 
	   <p>
		Select a file for UploadFileService1 resource : <input type="file" name="uploadedFile" size="50" />
	   </p>
 
 		File name : <input type="text" value="" name ="filename"/>
	   <input type="submit" value="Upload It" />
	</form>
 
</body>
</html>