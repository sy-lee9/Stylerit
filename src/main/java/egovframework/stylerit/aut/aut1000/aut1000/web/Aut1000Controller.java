package egovframework.stylerit.aut.aut1000.aut1000.web;

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

import egovframework.stylerit.aut.aut1000.aut1000.service.Aut1000Service;

/**
 * @Class Name : Aut1000Controller.java
 * @Description : 로그인 관련 Controller Class
 * @Modification Information
 * @
 * @   수정일         수정자                     수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2023.10.06     이수연                     최초생성
 *
 * @author 이수연
 * @since 2023.10.06
 * @version 1.0
 * 
 */

@Controller
public class Aut1000Controller {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Resource(name="aut1000Service")
	private Aut1000Service aut1000Service;
	
	/**
	 * 로그인 페이지로 이동 
	 * @return String - 로그인 페이지
	 */
	@RequestMapping(value = "/aut/aut1000/aut1000/selectAut1000View.do")
	public String selectAut1000View() throws Exception {		
		return "aut/aut1000/aut1000/aut1000";
	}
	
	/**
	 * 로그인 정보 확인 및 세션 저장
	 * @param Map - authChk, email, id, pw
	 * @return String - 리턴 Url
	 */
	@RequestMapping(value = "/aut/aut1000/aut1000/loginAjax.do")
	@ResponseBody
	public String loginAjax(@RequestParam Map<String, String> paramMap, Model model, HttpSession session) throws Exception {	
		return aut1000Service.loginAjax(paramMap,session);	
	}
	
	/**
	 * 로그아웃 및 세션 정보 삭제	 * 
	 * @return String - 리턴 Url
	 */
	@RequestMapping(value = "/aut/aut1000/aut1000/logout.do")
	public String logout(HttpSession session) throws Exception {		
			
			session.invalidate();
		
		return "redirect:/";
	}

}
