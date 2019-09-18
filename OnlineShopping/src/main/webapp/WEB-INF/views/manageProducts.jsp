<%@ taglib uri="http://www.springframework.org/tags/form" prefix="s" %>

<div class="container">

   <div class="row">
   
   
   
   <c:if test="${not empty msg }">
   
   
   <div class="col-xs-12">
   
      <div class="alert alert-success alert-dismissible">
      
         <button type="button" class="close" data-dismiss="alert">&times;</button>
      
            ${msg }
      
      </div>
     
   </div>
   
   </c:if>
   
      <div class="col-md-offset-2 col-md-8">
        
         <div class="panel panel-primary">
         
            <div class="panel-heading">
            
               <h4>Product Management</h4>
            
            </div>
            <div class="panel-body">
            
              <!-- form elements -->
              <s:form class="form-horizontal" modelAttribute="product" 
                    action="${contextRoot }/manage/products" method="POST">

						
						<div class="form-group">
							<label class="control-label col-md-4">Enter the Name:</label>
							<div class="col-md-8">
								<s:input class="form-control" type="text" path="name" id="name"
									placeholder="Enter the product name" />
									<em class="help-bloack">Plz Enter Product name</em>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-4">Enter the Brand</label>
							<div class="col-md-8">
								<s:input class="form-control" type="text" path="brand" id="brand"
									placeholder="Enter the brand name" />
									<em class="help-bloack">Plz Enter the Brand</em>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-4">Description</label>
							<div class="col-md-8">
								<s:textarea class="form-control" rows="4"  path="description" id="description" placeholder="write description"></s:textarea>
									<em class="help-bloack">Plz Enter Product name</em>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-4">Enter Unit Price</label>
							<div class="col-md-8">
								<s:input class="form-control" type="number" path="unitPrice" id="unitPrice"
									placeholder="Enter the product unitPrice" />
									<em class="help-bloack">Plz Enter Product unitPrice</em>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-4">Enter the quantity</label>
							<div class="col-md-8">
								<s:input class="form-control" type="number" path="quantity" id="quantity"
									placeholder="Enter the product quantity" />
									<em class="help-bloack">Plz Enter Product quantity</em>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-4">Select Catgeory</label>
							<div class="col-md-8">
								<s:select class="form-control"  path="categoryId" id="categoryId"
								  items="${categories }"
								  itemLabel="name"
								  itemValue="id"
								/>
								
									
									
							</div>
						</div>

						<div class="form-group">
							
							<div class="col-md-offset-4 col-md-8">
								<input class="btn btn-primary" type="submit" name="submit" id="submit"
								 value="submit"	/>
									
								<s:hidden path="id"/>	
								<s:hidden path="code"/>	
								<s:hidden path="supplierId"/>	
								<s:hidden path="active"/>	
								<s:hidden path="purchases"/>	
								<s:hidden path="views"/>	
							</div>
						</div>
			</s:form>
            </div>
         
         </div>
      
      
      </div>
   
   </div>


</div>