package com.javaex.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	public String add(@ModelAttribute GuestVo guestVo) {
			
		System.out.println("등록");
				
		GuestDao guestDao = new GuestDao();
		guestDao.addGuest(guestVo);
		
		return "redirect:/guest/addlist";
		
	}
	
	//삭제 폼
	@RequestMapping(value ="/deleteForm{no}", method = {RequestMethod.GET, RequestMethod.POST})
	public String deleteForm(@PathVariable("no") int no, Model model) {
		
		System.out.println("삭제 폼");
		System.out.println(no);
		
		model.addAttribute("no", no);
		
		return "deleteForm";
	}
	
	
	//삭제
	@RequestMapping(value="/delete/{no}", method = {RequestMethod.GET, RequestMethod.POST})
	public String delete(@ModelAttribute GuestVo guestVo) {
		
		System.out.println("삭제");
		
		GuestDao guestDao = new GuestDao();
		guestDao.guestDelete(guestVo);
		
			return "redirect:/guest/addlist";
			
		
	}

}
