package com.example.mysite.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.dto.JSONResult;
import com.example.mysite.service.UserService;
import com.example.mysite.vo.UserVo;

@Controller("userApiController")
@RequestMapping("/user/api")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@ResponseBody
	@RequestMapping("/checkemail")
	public JSONResult checkEmail(@RequestParam(value="email", required=true, defaultValue="") String email) {
		boolean exist = userService.existEmail(email);
		return JSONResult.success(exist);
	}
	@ResponseBody
	@RequestMapping("/logincheck")
	public JSONResult checkEmail(UserVo uservo) {
		if(null!=userService.loginCheck(uservo))
		return JSONResult.success(true);
		else 
		return JSONResult.success(false);
	}
}
