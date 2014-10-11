package com.templateMVC.proj1;

import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.templateMVC.proj1.loginService;
import com.templateMVC.proj1.Domain.Products;
import com.templateMVC.proj1.Domain.User;

@Controller
@SessionAttributes("username")
@RequestMapping(value="/")
public class HelloController {
	
	protected static Logger logger = Logger.getLogger("controller");

	
	@RequestMapping(value="/Apply")
	public ModelAndView getForm(){
		
		ModelAndView model = new ModelAndView("Welcome");
		return model;	
	}
	
	@RequestMapping(value="/Login")
	public ModelAndView login(){
		
		ModelAndView model = new ModelAndView("Form");
		return model;	
	}
	
	@RequestMapping(value="/signIn" , method = RequestMethod.POST)
	public ModelAndView submitForm(@RequestParam String username, @RequestParam String password,@Context HttpServletRequest req) throws SQLException, UnknownHostException{
		//ModelAndView model_fail = new ModelAndView("LoginFailure");
	
		loginService ls = new loginService();
		ModelAndView model2 = new ModelAndView("LoginFailure");
		
		if(ls.isValidUser(username,password)){
		ModelAndView model = new ModelAndView("CatgoryScreen");
		HttpSession session= req.getSession(true);
		session.setAttribute("username", username);
		
			return model;
		}
		
		else
			return model2;
	}
	
	@RequestMapping(value="/Category1")
	public ModelAndView getApparel_dpt() throws UnknownHostException{
		getMongoConnection conn = new getMongoConnection();
		ArrayList<Products> prod_list = new ArrayList<Products>();
		System.out.println("Controller Testing: before getConn()");
		prod_list = conn.getConn();
		ModelAndView model = new ModelAndView("Catalogue");
		model.addObject("list", prod_list);
		return model;		
	}  		
	
	@RequestMapping(value="/reg")
	public ModelAndView signUp(){
		
		ModelAndView model = new ModelAndView("SignUp");
		return model;	
	}
	
	@RequestMapping(value="/signUp" , method = RequestMethod.POST)
	public ModelAndView register(@RequestParam String fname, @RequestParam String lname,
			@RequestParam String user, @RequestParam String password){
		
		ModelAndView model = new ModelAndView("Form");
		
		signUpUser sup = new signUpUser();
		sup.signUp(fname,lname,user,password);
		return model;
	}
	
	@RequestMapping(value="/cart/product/{objectkey}" , method = RequestMethod.POST)
	public ModelAndView addToCart(@RequestParam Products product,
			@RequestParam String username, @PathParam("objectkey") String productname,HttpSession session) throws UnknownHostException, SQLException{
		System.out.println("");
		System.out.println("In the shopping cart..");
		
		//MongoDB Connect
		getMongoConnection conn2 = new getMongoConnection();
		conn2.getProduct(productname);
		
		//MySQL Connect
		DBOperation op = new DBOperation();
		User user = (User) session.getAttribute("username");
		op.insertProduct(user, product);
		
		ModelAndView model = new ModelAndView("Welcome");
		return model;
	}
}
