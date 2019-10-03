
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://www.springframework.org/tags"  prefix="spring" %>



<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />


<c:set var="contextRoot" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    
    
     <meta name="_csrf" content="${_csrf.token}">
     <meta name="_csrf_header" content="${_csrf.headerName}">

    <title>  Online Shopping -${title }</title>
    
    <script>
       window.menu = '${title}';
       
       window.contextRoot = '${contextRoot}';
    </script>

    <!-- Bootstrap core CSS -->
    <link href="${css }/bootstrap.css" rel="stylesheet">

      <!-- boottsrap theme -->
    <!--  <link href="${css}/bootstrap-readable-theme.css" rel="stylesheet">  -->
    
    
     <!--datatable Bootstrap core CSS -->
    <link href="${css }/dataTables.bootstrap.css" rel="stylesheet">

    <!-- Add custom CSS here -->
    <link href="${css}/myapp.css" rel="stylesheet">
    
  
</head>

<body>

<div class="wrapper">

    <!-- navigation -->
     
      <%@ include file="./shared/navbar.jsp" %>
    
    <!-- page content -->
    
    <div class="content">
      <!-- home  -->
      <c:if test="${userClickHome ==true }">
          <%@ include file="./home.jsp" %>
       </c:if>
       
       <!-- load when about -->
       <c:if test="${userClickAbout ==true }">
          <%@ include file="./about.jsp" %>
       </c:if>
       
         <!-- load when contact -->
       <c:if test="${userClickContact ==true }">
          <%@ include file="./contact.jsp" %>
       </c:if>
       
       
         <!-- load when products and category -->
       <c:if test="${userClickAllProducts == true or userClickCategoryProducts == true }">
          <%@ include file="./listProducts.jsp" %>
       </c:if>
       
         <!-- load when single product -->
       <c:if test="${userClickShowSingleProduct ==true }">
          <%@ include file="./singleProduct.jsp" %>
       </c:if>
       
       
          
         <!-- load when manage product -->
       <c:if test="${userClickWhenManageProduct ==true }">
          <%@ include file="./manageProducts.jsp" %>
       </c:if>
       
       
       </div>      
   
    <!-- /.container -->

     <%@ include file="./shared/footer.jsp" %>
   <!-- footer -->
    <!-- /.container -->
    
   
     <!-- custom javascript -->
   

    <!-- JavaScript -->
    <script src="${js}/jquery.js"></script>
    
    
    <!-- jquery validator -->
      <script src="${js}/jquery.validate.js"></script>
    
    
    <script src="${js}/bootstrap.js"></script>
    
    
    <!-- datable plugin -->
     <script src="${js}/jquery.dataTables.js"></script>
     
     <!-- datable plugin -->
     <script src="${js}/dataTables.bootstrap.js"></script>
     
     <!-- bootbox plugin -->
     <script src="${js}/bootbox.min.js"></script>
 
    <!-- self coded javascript -->

		<script src="${js }/myapp.js"></script>
    
    </div>

</body>

</html>
