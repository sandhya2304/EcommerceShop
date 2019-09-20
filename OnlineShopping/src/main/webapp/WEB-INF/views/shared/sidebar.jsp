
<p class="lead"> <span style="color: red;">Categories</span></p>
 <div class="list-group">
 
 <c:forEach items = "${categories }" var="c">
 
	<a style="color: blue;" href="${contextRoot}/show/category/${c.id }/products" class="list-group-item" id="a_${c.name }">${c.getName() }</a>
</c:forEach>	  
	  
 </div>