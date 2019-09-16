$(function(){
	
	switch(menu)
	{
	
	case 'About Us':
		$('#about').addClass('active');
		break;
	case 'Contact':
		$('#contact').addClass('active');
		break;
	default:
		$('#home').addClass('active');
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
		    		data: 'quantity'
		    	},
		    	{
		    		data: 'id',
		    		bSortable: false,
		    		mRender: function(data,type,row){
		    		
		    			var str = '';
		    			str += '<a href="'+window.contextRoot+'/show/'+data+'/product" class="btn btn-primary"><span class="glyphicon glyphicon-eye-open"></span></a> &nbsp;';                            
		    			str += '<a href="'+window.contextRoot+'/cart/add/'+data+'/product" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart"</a>';     
		    		
		    		return str;
		    		
		    		}	
		    	}
	  	
		    ]
			
			
			
			
		});
		
		
	  }
	
	
	 
});