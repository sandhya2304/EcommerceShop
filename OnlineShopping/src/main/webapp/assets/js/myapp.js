$(function(){
	
	switch(menu)
	{
	
	case 'About Us':
		$('#about').addClass('active');
		break;
	case 'Contact':
		$('#contact').addClass('active');
		break;
	case 'All Products':
		$('#listProduct').addClass('active');
		break;
	case 'manage Products':
		$('#manageProduct').addClass('active');
		break;
	default:
		if(menu == "Home") break;
		$('#listProducts').addClass('active');
	    $('#a_'+menu).addClass('active');
	    break;
	}
	
	/****************************************************************/
	
	//code for jquery data
	//creaet a dataset
	
	
	
	
	
	var $table = $('#productListTable');
	
	if($table.length)
	  {
		
		//console.log('inside the table');
		
		
		var jsonURL = '';
		if(window.categoryId == '')
		  {
			 
			jsonURL = window.contextRoot+'/json/data/all/Products';
			 
		  }
		else
			{
			
			jsonURL = window.contextRoot+'/json/data/category/'+window.categoryId+'/Products';
			
			}
		
		$table.DataTable({
			
			lengthMenu: [[3,5,10,-1],["three","five","ten","none"]], 
			pageLength: 5,
		    ajax: {
		    	url : jsonURL,
		    	dataSrc: ''	
		    },
		    columns: [
		    	{
		    		 data: 'code',
		    		 mRender: function(data,type,row){
		    			 
		    			 
		    			 return '<img src ="'+window.contextRoot+'/resources/images/'+data+'.jpg" class="dataTableImg"></img>'
		    		 }
		    	},
		    	{
		    		data: 'name'
		    	},
		    	{
		    		data: 'brand'
		    	},
		    	{
		    		data: 'unitPrice',
		    		mRender: function(data,type,row){
		    			return '&#8377; ' +data
		    		}
		    	},
		    	{
		    		data: 'quantity',
		    	   mRender: function(data,type,row){
				    		
		    		   if(data < 1)
		    			   {
		    			      return '<span style="color:red">Out Of Stock</span>' ;
		    			   }
		    		   return data;
		    			}
		    			
		    	},
		    	{
		    		data: 'id',
		    		bSortable: false,
		    		mRender: function(data,type,row){
		    		
		    			var str = '';
		    			str += '<a href="'+window.contextRoot+'/show/'+data+'/product" class="btn btn-primary"><span class="glyphicon glyphicon-eye-open"></span></a> &nbsp;';                            
		    			
		    			
		    			if(row.quantity < 1)
		    				{
		    				str += '<a href="javascript:void(0)" class="btn btn-success disabled"><span class="glyphicon glyphicon-shopping-cart"</a>';     
		    				}else
		    					{
		    					str += '<a href="'+window.contextRoot+'/cart/add/'+data+'/product" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart"</a>';     
		    					}
		    			
		    		
		    		return str;
		    		
		    		}	
		    	}
	  	
		    ]
			
			
			
			
		});
		
		
	  }
	//***********************************************************************
	//***********dismiss msg after the alert
	
	var $alert = $('.alert')
	{
		if($alert.length)
			{
			   setTimeout(function(){
				   
				   $alert.fadeOut('slow');
			   },3000)
			}
		
	}
	
	//**********************************************************************//
	
	
	//****************************************************************//
	//  data table for admin                            //
	//*****************************************************************//
	
	
	var $adminProducttable = $('#adminProductsTable');
	
	if($adminProducttable.length)
	  {
		
		//console.log('inside the table');
		
		
		var jsonURL =window.contextRoot+ '/json/data/admin/all/Products';
		
		
		$adminProducttable.DataTable({
			
			lengthMenu: [[10,30,50,-1],["ten","thrity","fiftry","none"]], 
			pageLength: 30,
		    ajax: {
		    	url : jsonURL,
		    	dataSrc: ''	
		    },
		    columns: [
		    	{
		    		data: 'id',
		    	},
		    	{
		    		 data: 'code',
		    		 mRender: function(data,type,row){
		    			 
		    			 
		    			 return '<img src ="'+window.contextRoot+'/resources/images/'+data+'.jpg" class="adminDataTableImg"></img>'
		    		 }
		    	},
		    	{
		    		data: 'name'
		    	},
		    	{
		    		data: 'brand'
		    	},
		    	
		    	{
		    		data: 'quantity',
		    	   mRender: function(data,type,row){
				    		
		    		   if(data < 1)
		    			   {
		    			      return '<span style="color:red">Out Of Stock</span>' ;
		    			   }
		    		   return data;
		    			}
		    			
		    	},
		    	{
		    		data: 'unitPrice',
		    		mRender: function(data,type,row){
		    			return '&#8377; ' +data
		    		}
		    	},
		    	{
		    		data: 'active',
		    		mRender: function(data,type,row){
		    			var str = '';
 
		    			str += '<label class="switch">'; 
	                    
		    			if(data)
		    				{
	                          str += '<input type="checkbox" checked="checked" value="'+row.id+'"/>';
		    				}
		    			else
		    				{
		    				str += '<input type="checkbox" value="'+row.id+'"/>';
		    				}
	                    str += '<div class="slider" ></div></label>';
	                      
	                    
	                return str;
		    			
		    		}	
		    	},
		    	{
		    		
		    		data: 'id',
		    		bSortable: false,
		    		mRender: function(data,type,row){
		    			
		    			var str = '';
		    			
		    			str += ' <a href="'+window.contextRoot+'/manage/'+data+'/product" class="btn btn-warning" >';
		                 str +=  '<span class="glyphicon glyphicon-pencil"></span></a>';
		                 
		    			
		                 return str;
		    		}
		    		
		    		
		    	}
	  	
		    ],
		    initComplete: function()
			{
		    	
		    	var api = this.api();
		    	api.$('.switch input[type="checkbox"]').on('change',function(){
		    		
		    		var checkbox = $(this);
		    		var checked = checkbox.prop('checked');
		    		var dMsg = (checked)? 'You want to activate the product?':
		    			                  'You want to deactivate the product?'
		    		
		    		var value = checkbox.prop('value');
		    		
		    		bootbox.confirm({
		    			size: 'medium',
		    			title: 'Product activation and Deactivation',
		    			message: dMsg,
		    			callback: function(confirmed){
		    				  if(confirmed)
		    				    {
		    					  console.log(value);
		    					  
		    					  var activationURL = window.contextRoot + '/manage/product/'+ value +'/activation';
		    					  
		    					  $.post(activationURL,function(data){
		    					
		    					  bootbox.alert({
		    						 size: 'large',
		    						 title: 'Information',
		    						 message: data
		    						  
		    					  });
		    					  
		    					  
		    					  });
		    					  
		    				    }
		    				  
		    					  else
		    						  {
		    						  checkbox.prop('checked',!checked);
		    						  }			  
		    			}
		    			
		    		});
		    		
		    		
		    		
		    	});
		    	
			}
			
			
			
		});
		
		
	  }
	
	
	
	
	
	
	
	
	
	
	
	
	//**************************************************************************
	
	 
});