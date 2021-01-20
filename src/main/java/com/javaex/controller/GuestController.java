package com.javaex.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.dao.GuestDao;
import com.javaex.vo.GuestVo;

@Controller
@RequestMapping(value="/guest")
public class GuestController {
	
	//피드
	//생성자
	//메소드 g/s
	
	//리스트
	@RequestMapping(value="/addlist", method = {RequestMethod.GET, RequestMethod.POST})
	public String addlist(Model model) {
		System.out.println("방명록");
		
		GuestDao guestDao = new GuestDao();
		List<GuestVo> guestList = guestDao.getGuestList();
		System.out.println(guestList.toString());
		
		model.addAttribute("gList", guestList);
		
		return "addlist";
		
		
	}
	
	//등록
	@RequestMapping(value="/add", method = {RequestMethod.GET, RequestMethod.POST})
	public String add(@RequestParam("name") String name,
					  @RequestParam("password") String password,
					  @RequestParam("content") String content) {
		
		System.out.println("등록");
		System.out.println(name + ", " + password + ", " + content);
		
		GuestVo guestVo = new GuestVo(name, password, content);
		
		GuestDao guestDao = new GuestDao();
		guestDao.addGuest(guestVo);
		
		return "redirect:/guest/addlist";
		
	}
	
	//삭제 폼
	@RequestMapping(value ="/deleteForm", method = {RequestMethod.GET, RequestMethod.POST})
	public String deleteForm(@RequestParam("no") int no) {
		
		System.out.println("삭제 폼");
		System.out.println(no);
		
		return "deleteForm";
	}
	
	
	//삭제
	@RequestMapping(value="/delete", method = {RequestMethod.GET, RequestMethod.POST})
	public String delete(@RequestParam("no") int no,
						 @RequestParam("password") String password) {
		
		System.out.println("삭제");
		
		GuestDao guestDao = new GuestDao();
		int count = guestDao.guestDelete(no, password);
		
		if(count == 1) {
			return "redirect:/guest/addlist";
		} else {
			System.out.println("비밀번호 불일치");
			
			return "deleteFrom"; 
		}

	}

}
