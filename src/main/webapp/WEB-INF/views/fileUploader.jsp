<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8"%>
<html>
<head>

    <title>Title</title>
</head>
<body>
<form method="POST" action="uploadImage" enctype="multipart/form-data">
    File to upload: <input type="file" name="file"><br />

    <input type="submit" value="Upload">
    Press here to upload the file!
</form>
</body>
</html>