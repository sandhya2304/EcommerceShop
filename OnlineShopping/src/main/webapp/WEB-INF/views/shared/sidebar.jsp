
<p class="lead">Shop Name</p>
 <div class="list-group">
 
 <c:forEach items = "${categories }" var="c">
 
	<a href="${contextRoot}/show/category/${c.id }/products" class="list-group-item" id="a_${c.name }">${c.getName() }</a>
</c:forEach>	  
	  
 </div>