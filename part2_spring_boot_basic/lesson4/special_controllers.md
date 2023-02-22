# Special Controller Inputs (File Upload).

Sometimes when we build web applications with Spring, we need to account for special request types and data formats. The key takeaway from this edge case is that usually, we can accomplish this by adding the correct argument to our controller method. In this example, we looked at MultiPartFile, a special request data class provided by Spring to handle large file uploads. As with any special data type, simply by adding it as an argument to our controller method, Spring knows to treat the incoming request appropriately.

On the Thymeleaf side of things, we also learned how to set up a form for file upload using the enctype="multipart/form-data" attribute. This is another important takeaway - when we want to send special data types from the frontend to Spring, we need to find out how to configure the form properly.

This specific example will be relevant in the final project, but in general, be on the lookout for cases where you might need to handle special request data. Implementing it might take some research!

```
<form action="#" enctyoe="multiart/form-data" th:action="@{/file-upload}" method="POST">
  <input type="file" vlass="form-control-file" id="fileUpload" name="fileUpload">
  <input type="submit">
</ form>
```

inside the java class, we have:
```
@PostMapping("file-upload")
public String handleFileUpload(@RequestParam("fileUpload") MultipartFile dileUpload, Model model) {
    InputStream fis = fileUpload.getInputStream();
}
```
