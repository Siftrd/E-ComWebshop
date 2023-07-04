<%-- 
    Document   : Edit
    Created on : May 26, 2022, 6:42:16 PM
    Author     : rioxv
--%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Edit form</title>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="css/manager.css" rel="stylesheet" type="text/css"/>
        <style>
            img{
                width: 200px;
                height: 120px;
            }
        </style>
</head>
<body>
	<!-- Edit Modal HTML -->
        <div id="editProduct">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form action="edit" method="post">
                        <div class="modal-header">						
                            <h4 class="modal-title">Edit Product</h4>
                            <button type="button" href="manageproduct" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        </div>
                        <div class="modal-body">					
                            <div class="form-group">
                                <label>ID product</label>
                                <input type="text" name="id" value="${detail.id}" class="form-control" readonly="readonly" required>
                            </div>
                            <div class="form-group">
                                <label>Name</label>
                                <input type="text" name="name" value="${detail.name}" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Image</label>
                                <input type="text" name="image" value="${detail.image}" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Price</label>
                                <input type="text" name="price" value="${detail.price}" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Title</label>
                                <input type="text" name="title" value="${detail.title}" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Description</label>
                                <input type="text" name="description" value="${detail.description}" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Category</label>
                                <select name="category" class="form-select" aria-label="Default select example">
                                    <c:forEach items="${listC}" var="o">
                                        <option value="${o.cateid}">${o.catename}</option>
                                    </c:forEach>
                                </select>
                            </div>					
                        </div>
                        <div class="modal-footer">
                            <input type="button" href="manageproduct" class="btn btn-default" data-dismiss="modal" value="Cancel">
                            <input type="submit" class="btn btn-success" value="Save">
                        </div>
                    </form>
                </div>
            </div>
        </div>
</body>
</html>
