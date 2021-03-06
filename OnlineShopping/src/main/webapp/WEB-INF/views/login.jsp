
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://www.springframework.org/tags"  prefix="spring" %>


<h1></h1>
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
     
   	<!-- Navigation -->
	    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	        <div class="container">
	            <!-- Brand and toggle get grouped for better mobile display -->
	            <div class="navbar-header">
	                <a class="navbar-brand" href="${contextRoot}/home">Online Shopping</a>
	            </div>
			</div>
		</nav>		

    <!-- page content -->
    
   
		<!-- Page Content -->

		<div class="content">
			
   <div class="container">
    
   	<c:if test="${not empty msg}">
		<div class="row">
			<div class="col-xs-12 col-md-offset-2 col-md-8">
				<div class="alert alert-danger fade in">${msg}</div>
			</div>
		</div>
	</c:if>
         
   	<c:if test="${not empty logout}">
		<div class="row">
			<div class="col-xs-12 col-md-offset-2 col-md-8">
				<div class="alert alert-success">${logout}</div>
			</div>
		</div>
	</c:if>
       
    <div class="row">
     
     <div class="col-md-offset-3 col-md-6">
      
      <div class="panel panel-primary">
       
       <div class="panel-heading">
        <h4>Login</h4>
       </div>
       
       <div class="panel-body">
        <form action="${contextRoot}/login" method="POST" class="form-horizontal"
         id="loginForm"
        >
         <div class="form-group">
          <label for="username" class="col-md-4 control-label">Email: </label>
          <div class="col-md-8">
           <input type="text" name="username" id="username" class="form-control"/>
          </div>
         </div>
         <div class="form-group">
          <label for="password" class="col-md-4 control-label">Password: </label>
          <div class="col-md-8">
           <input type="password" name="password" id="password" class="form-control"/>
          </div>
         </div>
         <!-- csrf -->
         <div class="form-group">
          <div class="col-md-offset-4 col-md-8">
           <input type="hidden" name="${_csrf.parameterName}"
												value="${_csrf.token}" /> 
												
           <input type="submit" value="Login" class="btn btn-primary"/>
           
         
           
          </div>
         </div>
        </form>
       
       </div>
       <div class="panel-footer">
       	<div class="text-right">
       		New User - <a href="${contextRoot}/register">Register Here</a>
       	</div>
       </div>
      
      </div> 
    
     </div>
     
    </div>    

       
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
    
    
   
    
    <!-- self coded javascript -->

		<script src="${js }/myapp.js"></script>
    
    </div>

</body>

</html>
