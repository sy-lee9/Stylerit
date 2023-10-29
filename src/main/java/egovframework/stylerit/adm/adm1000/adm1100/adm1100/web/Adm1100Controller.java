package egovframework.stylerit.adm.adm1000.adm1100.adm1100.web;

import java.util.ArrayList;
import java.util.HashMap;
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

import egovframework.stylerit.adm.adm1000.adm1100.adm1100.service.Adm1100Service;
import egovframework.stylerit.mn.mn1000.mn1000.service.Mn1000Service;
import egovframework.stylerit.mn.mn1000.mn1000.service.Mn1000VO;

/**
 * @Class Name : Adm1100Controller.java
 * @Description : 메뉴 관리 관련 Controller Class
 * @Modification Information
 * @
 * @   수정일         수정자                     수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2023.10.25     이수연                     최초생성
 *
 * @author 이수연
 * @since 2023.10.25 
 * @version 1.0
 * 
 */

@Controller
public class Adm1100Controller {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Resource(name="adm1100Service")
	private Adm1100Service adm1100Service;

	/* 메뉴 관련 서비스 */
	@Resource(name="mn1000Service")
	private Mn1000Service mn1000Service;
	
	/**
	 * 메뉴 관리 페이지로 이동
	 * @return : 메뉴 관리 페이지
	 */
	@RequestMapping(value = "/adm/adm1000/adm1100/selectAdm1100View.do")
	public String selectAdm1100View(HttpSession session, Model model) throws Exception {	
		
		//GNV Type
		model.addAttribute("page", "mnAdm");
		
		/* 메뉴 분류 조회 */
		//해당 샵 코드 가져오기
		String S_LOC_CD = (String) session.getAttribute("S_LOC_CD");
		
		//조회된 메뉴 분류 
		ArrayList<Map<String, String>> menuList = mn1000Service.selectMnClList(S_LOC_CD);	
		model.addAttribute("menuList", menuList);
		
		return "adm/adm1000/adm1100/adm1100";
	}
	

	/**
	 * 메뉴 순서 업데이트
	 * @param String - 선택된 메뉴
	 * @return int - 성공여부
	 */
	@RequestMapping(value = "/adm/adm1100/adm1100/updateMenuOderAjax.do")
	@ResponseBody
	public String updateMenuOderAjax(HttpSession session, @RequestParam String selectMenuCode) throws Exception {		
		
		//성공 여부
		String success = "";
		
		//쿼리문 조회를 위한 정보가 담길 map
		Map<String, String> paramMap = new HashMap<String, String>();
		
		//해당 샵 코드 가져오기
		String S_LOC_CD = (String) session.getAttribute("S_LOC_CD");
		
		//선택된 메뉴 & 샵 코드 담기
		paramMap.put("selectMenuCode", selectMenuCode);
		paramMap.put("S_LOC_CD", S_LOC_CD);
		
		//조회된 메뉴 리스트 
		int row = adm1100Service.updateMenuOderAjax(paramMap);	
		
		return success;
	}
	
	
	
	
}
