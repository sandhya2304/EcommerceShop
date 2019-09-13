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
	 
});