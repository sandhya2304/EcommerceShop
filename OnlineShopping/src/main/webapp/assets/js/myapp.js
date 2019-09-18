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
	
	
	
	 
});