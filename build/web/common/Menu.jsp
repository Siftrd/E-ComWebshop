<%-- 
    Document   : Menu 
    Created on : April 25, 2022, 2:59:20 PM
    Author     : rioxv
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<nav class="navbar navbar-expand-md navbar-dark bg-dark">
    <div class="container">
        <a class="navbar-brand" href="home">MINH BÙI</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse justify-content-end" id="navbarsExampleDefault">
            <ul class="navbar-nav m-auto">
                <c:if test="${sessionScope.acc.isSeller == 1}"> 
                    <li class="nav-item">
                    <a class="nav-link" href="manageproduct">Manager Product</a>
                </li>
                </c:if>
                <c:if test="${sessionScope.acc.isAdmin == 1}"> 
                    <li class="nav-item">
                    <a class="nav-link" href="#">Manager Account</a>
                </li>
                </c:if>
                <c:if test="${sessionScope.acc != null}"> 
                    <li class="nav-item">
                        <a class="nav-link" href="#">Hello ${sessionScope.acc.userName} </a>
                </li>
                    <li class="nav-item">
                        <a class="nav-link" href="logout">Logout</a>
                    </li>
                </c:if>
                <c:if test="${sessionScope.acc == null}"> 
                    <li class="nav-item">
                        <a class="nav-link" href="Login.jsp">Login</a>
                    </li>
                </c:if>
            </ul>

            <form action="search" method="post" class="form-inline my-2 my-lg-0">
                <div class="input-group input-group-sm">
                    <input value="${searchVal}" name="txt" type="text" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm" placeholder="Search...">
                    <div class="input-group-append">
                        <button type="submit" class="btn btn-secondary btn-number">
                            <i class="fa fa-search"></i>
                        </button>
                    </div>
                </div>
                <a class="btn btn-success btn-sm ml-3" href="showCart">
                    <i class="fa fa-shopping-cart"></i> Cart
                    <span class="badge badge-light">${cartList.size()}</span>
                </a>
            </form>
        </div>
    </div>
</nav>
<section class="jumbotron text-center">
    <div class="container">
        <h1 class="jumbotron-heading">SHOP GIÀY CHẤT LƯỢNG CAO  </h1>
        <p class="lead text-muted mb-0">ÔNG HOÀNG CHỐT DEAL, CHÚA TỂ BÁN GIÀY, HOÀNG TỬ BÁN DÉP  </p>
    </div>
</section>
