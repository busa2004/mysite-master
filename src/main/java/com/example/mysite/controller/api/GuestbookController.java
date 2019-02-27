package com.example.mysite.controller.api;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.dto.JSONResult;
import com.example.mysite.service.GuestbookService;
import com.example.mysite.vo.GuestbookVo;

@Controller("guestbookApiController")
@RequestMapping("/guestbook/api")
public class GuestbookController {
	
	@Autowired
	private GuestbookService guestbookService;
	
	@ResponseBody
	@RequestMapping("/list")
	public JSONResult getList(long startNo) {
		return JSONResult.success(guestbookService.getMessageList(startNo));
	}
	@ResponseBody
	@RequestMapping("/delete")
	public JSONResult deleteMessage( GuestbookVo vo) {
		if(guestbookService.deleteMessage(vo))
		return JSONResult.success(vo.getNo());
		else
		return JSONResult.success(-1);
	}
	@ResponseBody
	@RequestMapping("/add")
	public JSONResult writeMessage( GuestbookVo vo) {
		return JSONResult.success(guestbookService.writeMessage(vo));
	}
}
