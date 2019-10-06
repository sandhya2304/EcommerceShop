package com.shop.OnlineShopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.shop.OnlineShopping.service.CartService;


@Controller
@RequestMapping("/cart")
public class CartController
{
	@Autowired
	private CartService cartService;
	
	
	@RequestMapping(value="/show")
	public ModelAndView showCart(@RequestParam(name="result",required = false)String result)
	{
		ModelAndView mv =new ModelAndView("page");
		
		if(result != null)
		{
			
			switch(result)
			{
			
			case "updated":
				mv.addObject("msg","cartline has been updated");
				break;
			case "error":
				mv.addObject("msg","something went wrong");
				break;
			case "deleted":
				mv.addObject("msg","deleted cartLine");
				break;
			case "added":
				mv.addObject("msg","cartLine added");
				break;
			case "maximum":
				mv.addObject("msg","cartLine has reached to maximum count");
				break;
			case "unavailable":
				mv.addObject("msg","product qty not avialable");
				break;
			}
			
		}
		
		mv.addObject("title","user cart");
		mv.addObject("userClickShowCart",true);
		mv.addObject("cartLines",cartService.getCartLines());
		
		return mv;
	}
	
	@RequestMapping(value="/{cartLineId}/update")
	public String updateCart(@PathVariable int cartLineId,@RequestParam int count)
	{
		String response = cartService.manageCartLine(cartLineId,count);
		
		
		return "redirect:/cart/show?"+response;
	}
	
	

	@RequestMapping(value="/{cartLineId}/delete")
	public String deleteCart(@PathVariable int cartLineId)
	{
		String response = cartService.deleteCartLine(cartLineId);
		
		
		return "redirect:/cart/show?"+response;
	}
	
	
	@RequestMapping(value="/add/{productId}/product")
	public String addCart(@PathVariable int productId)
	{
		String response = cartService.addCartLine(productId);
		
		
		return "redirect:/cart/show?"+response;
	}
	
	
	
	
	
	
	
	
	

}
