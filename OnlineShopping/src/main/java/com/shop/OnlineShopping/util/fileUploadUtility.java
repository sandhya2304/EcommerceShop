package com.shop.OnlineShopping.util;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

public class fileUploadUtility 
{
	private static final Logger logger= LoggerFactory.getLogger(fileUploadUtility.class);
	
	private static String abs_path = "C:\\Users\\SONY\\git\\EcommerceShop\\OnlineShopping\\src\\main\\webapp\\assets\\images\\";
	
	private static String real_path = "";

	public static void uploadFile(HttpServletRequest request, MultipartFile file, String code) 
	{
		real_path = request.getSession().getServletContext().getRealPath("/assets/images/");
		
		logger.info("about real path");
		
		//to make sure all directory exist
		//if not then create
		
		if(!new File(abs_path).exists())
		{
			new File(abs_path).mkdirs();
		}
		
		
		if(!new File(real_path).exists())
		{
			new File(real_path).mkdirs();
		}
		
		try
		{
			//server upload
			file.transferTo(new File(real_path+code+".jpg"));
			//project directory
			file.transferTo(new File(abs_path+code+".jpg"));
			
		}catch(Exception e)
		{
			
		}
	}

}
