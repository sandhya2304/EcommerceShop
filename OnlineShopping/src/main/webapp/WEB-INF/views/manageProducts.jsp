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
                    action="${contextRoot }/manage/products" method="POST" enctype="multipart/form-data" >

						
						<div class="form-group">
							<label class="control-label col-md-4">Enter the Name:</label>
							<div class="col-md-8">
								<s:input class="form-control" type="text" path="name" id="name"
									placeholder="Enter the product name" />
									<s:errors path="name" cssClass="help-block" element="em" />
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-4">Enter the Brand</label>
							<div class="col-md-8">
								<s:input class="form-control" type="text" path="brand" id="brand"
									placeholder="Enter the brand name" />
								<s:errors path="brand" cssClass="help-block" element="em" />
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-4">Description</label>
							<div class="col-md-8">
								<s:textarea class="form-control" rows="4"  path="description" id="description" placeholder="write description"></s:textarea>
								<s:errors path="description" cssClass="help-block" element="em" />
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-4">Enter Unit Price</label>
							<div class="col-md-8">
								<s:input class="form-control" type="number" path="unitPrice" id="unitPrice"
									placeholder="Enter the product unitPrice" />
									<s:errors path="unitPrice" cssClass="help-block" element="em" />
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-4">Enter the quantity</label>
							<div class="col-md-8">
								<s:input class="form-control" type="number" path="quantity" id="quantity"
									placeholder="Enter the product quantity" />
									<s:errors path="quantity" cssClass="help-block" element="em" />
							</div>
						</div>
						
						
						<div class="form-group">
							<label class="control-label col-md-4" for="file">Enter the Image</label>
							<div class="col-md-8">
								<s:input class="form-control" type="file" path="file" id="file"
									 />
									 
									<s:errors path="file" cssClass="help-block" element="em" />
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
								
								<c:if test="${product.id == 0 }">
								  
								  <div class="text-right">
								  <br/>
									
									<button type="button" class="btn btn-info btn-sm" data-toggle="modal" 
									     data-target="#myModal">Add Category</button>
									
									
								</c:if>	
								
								</div>
								
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
   
   <!-- admin data table -->

<div class="row">

  <div class="col-xs-12">
  
  
  </div>
  
   <div class="col-xs-12">
   
      
      <!-- product table for admin -->
     
           <table id="adminProductsTable" class="table table-condensed table-bordered">
            
            <thead>					
					<tr>					
						<th>Id</th>
						<th>&#160;</th>
						<th>Name</th>
						<th>Brand</th>
						<th>Qty. Avail</th>
						<th>Unit Price</th>
						<th>Activate</th>				
						<th>Edit</th>
					</tr>					
				</thead>
			
           
           <tfoot>
					<tr>					
						<th>Id</th>
						<th>&#160;</th>
						<th>Name</th>
						<th>Brand</th>
						<th>Qty. Avail</th>
						<th>Unit Price</th>
						<th>Activate</th>				
						<th>Edit</th>
					</tr>									
				</tfoot>
				
         </table>
  </div>
  
  
  
 <div class="modal fade"   id="myModal"  role="dialog" tabindex="-1">
    <div class="modal-dialog" role="document">
    
         <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
         <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Add new Category</h4>     
      </div>
      <div class="modal-body">
        <!-- category form -->
         
         <s:form id="categoryForm" modelAttribute="category" action="${contextRoot}/manage/category"
          method="POST" class="form-horizontal">
						<div class="form-group">
							<label class="control-label col-md-4">Enter the Name:</label>
							<div class="col-md-8">
								<s:input class="form-control" type="text" path="name" id="category_name"
									placeholder="Enter the category name" />
								
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-4">Enter the Description:</label>
							<div class="col-md-8">
								<s:textarea class="form-control" rows="5" cols="" path="description" id="category_description"
									placeholder="Enter the category description" ></s:textarea>
								
							</div>
						</div>
						<div class="form-group">
							
							<div class="col-md-8 col-md-offset-4">
								<input type="submit" value="Add Category" class="btn btn-primary" /> 
								
						</div>
						</div>


					</s:form>
        
        
      </div>
      
      
    </div>  
      

 </div>
  

</div>


</div>