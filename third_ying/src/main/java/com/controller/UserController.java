package com.controller;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.ExpiredCredentialsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bean.User;
import com.dao.UserDao;
import com.util.CryptographyUtil;

@Controller
@RequestMapping("/user")
public class UserController {

//	@RequestMapping("/login")
//	public String login(){
//		return "index";
//	}
	
	@Autowired
	private UserDao userDao;
	
	@RequestMapping("/toMain")
	public String toMain(User user,HttpServletRequest request,Model model){
		String msg="";
		String name=user.getUname();
		String password=user.getPassword();
		System.out.println(name+"---------"+password);
		Subject subject=SecurityUtils.getSubject();
		UsernamePasswordToken token=new UsernamePasswordToken(name,CryptographyUtil.md5(user.getPassword(), "javamd"));
		try {
			subject.login(token);
			Session session=subject.getSession();
			session.setAttribute("name", user.getUname());
			Set<String> set=userDao.getRolesByUserName(name);
			String url=null;
			for (String string : set) {
				url=string;
				System.out.println(string);
				if(url!=null){
					break;
				}
				
			}
			if(url!=null){
				 model.addAttribute("string", url); 
				 System.out.println(url);
				 return "success";
			}
			
			
		} catch (IncorrectCredentialsException e) {  
	        msg = "登录密码错误. Password for account " + token.getPrincipal() + " was incorrect.";  
	        model.addAttribute("message", msg);  
	        System.out.println(msg);  
	    } catch (ExcessiveAttemptsException e) {  
	        msg = "登录失败次数过多";  
	        model.addAttribute("message", msg);  
	        System.out.println(msg);  
	    } catch (LockedAccountException e) {  
	        msg = "帐号已被锁定. The account for username " + token.getPrincipal() + " was locked.";  
	        model.addAttribute("message", msg);  
	        System.out.println(msg);  
	    } catch (DisabledAccountException e) {  
	        msg = "帐号已被禁用. The account for username " + token.getPrincipal() + " was disabled.";  
	        model.addAttribute("message", msg);  
	        System.out.println(msg);  
	    } catch (ExpiredCredentialsException e) {  
	        msg = "帐号已过�? the account for username " + token.getPrincipal() + "  was expired.";  
	        model.addAttribute("message", msg);  
	        System.out.println(msg);  
	    } catch (UnknownAccountException e) {  
	        msg = "帐号不存�? There is no user with username of " + token.getPrincipal();  
	        model.addAttribute("message", msg);  
	        System.out.println(msg);  
	    } catch (UnauthorizedException e) {  
	        msg = "您没有得到相应的授权�? + e.getMessage()";  
	        model.addAttribute("message", msg);  
	        System.out.println(msg);  
	    }  
		
		return "index";
	}
}
