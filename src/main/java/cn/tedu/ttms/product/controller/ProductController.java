package cn.tedu.ttms.product.controller;

import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/product")
@RequiresAuthentication
public class ProductController {
	 /**产品列表页面*/
	 @RequestMapping("/listUI")
	 public String listUI(){
		 return "product/product_list";
	 }
}
