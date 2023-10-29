package egovframework.stylerit.mn.mn1000.mn1000.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import egovframework.stylerit.mn.mn1000.mn1000.service.Mn1000Service;
import egovframework.stylerit.mn.mn1000.mn1000.service.Mn1000VO;

/**
 * @Class Name : Mn1000Controller.java
 * @Description : 메뉴 관련 Controller Class
 * @Modification Information
 * @
 * @   수정일         수정자                     수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2023.10.14     이수연                     최초생성
 *
 * @author 이수연
 * @since 2023.10.14
 * @version 1.0
 * 
 */

@Controller
public class Mn1000Controller {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Resource(name="mn1000Service")
	private Mn1000Service mn1000Service;
	
	/**
	 * 메뉴 페이지로 이동 
	 * @return String - 메뉴 페이지
	 */
	@RequestMapping(value = "/mn/mn1000/mn1000/selectMn1000View.do")
	public String selectMn1000View(HttpSession session, Model model) throws Exception {			
		
		//GNV Type
		model.addAttribute("page", "mn");
		
		/* 메뉴 분류 조회 */
		//해당 샵 코드 가져오기
		String S_LOC_CD = (String) session.getAttribute("S_LOC_CD");
		
		//조회된 메뉴 분류 
		ArrayList<Map<String, String>> menuList = mn1000Service.selectMnClList(S_LOC_CD);	
		model.addAttribute("menuList", menuList);
		
		return "mn/mn1000/mn1000/mn1000";
	}
	
	/**
	 * 메뉴 리스트 조회
	 * @param String - 선택된 메뉴
	 * @return HashMap<String, Object> - 메뉴 리스트
	 */
	@RequestMapping(value = "/mn/mn1000/mn1000/selectMnListAjax.do")
	@ResponseBody
	public Map<String, Object> selectMnListAjax(@RequestParam String selectMenu, HttpSession session) throws Exception {		
		
		//쿼리문 조회를 위한 정보가 담길 map
		Map<String, String> paramMap = new HashMap<String, String>();
		//view로 내려보낼 list가 담길 map
		Map<String, Object> map = new HashMap<String, Object>();
		
		//해당 샵 코드 가져오기
		String S_LOC_CD = (String) session.getAttribute("S_LOC_CD");
		
		//선택된 메뉴 & 샵 코드 담기
		paramMap.put("selectMenu", selectMenu);
		paramMap.put("S_LOC_CD", S_LOC_CD);
		
		//조회된 메뉴 리스트 
		ArrayList<Mn1000VO> list = mn1000Service.selectMnListAjax(paramMap);	
		//map에 담아서 반환
		map.put("menuList", list);
		
		return map;
	}
	
	
	
	
	
	
	
}
