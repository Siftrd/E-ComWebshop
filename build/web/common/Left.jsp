<%-- 
    Document   : Left
    Created on : April 25, 2022, 2:57:59 PM
    Author     : rioxv
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="col-sm-3">
    <div class="card bg-light mb-3">
        <div class="card-header bg-primary text-white text-uppercase"><i class="fa fa-list"></i> Categories</div>
        <ul class="list-group button-dark category_block">
            <c:forEach items="${listC}" var="o">
                <li class="list-group-item  text-white ${chk == o.cateid ?"active":""}"><a href="category?cateID=${o.cateid}">${o.catename}</a></li>               
                </c:forEach>
        </ul>
    </div>
    <div class="card bg-light mb-3">
        <div class="card-header bg-success text-white text-uppercase">Newest product</div>
        <div class="card-body">
            <img class="img-fluid" src="${p.image}" />
            <h4 class="card-title show_txt"><a href="detail?pid=${p.id}" title="View Product">${p.name}</a></h4>
            <p class="card-text">${p.title}</p>
            <p class="bloc_left_price">${p.price} $</p>
        </div>
    </div>
</div>