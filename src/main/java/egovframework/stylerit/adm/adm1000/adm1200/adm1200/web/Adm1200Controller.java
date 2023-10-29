package egovframework.stylerit.adm.adm1000.adm1200.adm1200.web;

import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import egovframework.stylerit.adm.adm1000.adm1200.adm1200.service.Adm1200Service;

/**
 * @Class Name : Adm1200Controller.java
 * @Description : 회원 관리 관련 Controller Class
 * @Modification Information
 * @
 * @   수정일         수정자                     수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2023.10.23     이수연                     최초생성
 *
 * @author 이수연
 * @since 2023.10.23 
 * @version 1.0
 * 
 */

@Controller
public class Adm1200Controller {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Resource(name="adm1200Service")
	private Adm1200Service adm1200Service;
	
	/**
	 * 회원 관리 페이지로 이동
	 * @return : 회원 관리 페이지
	 */
	@RequestMapping(value = "/adm/adm1000/adm1200/selectAdm1200View.do")
	public String selectAdm1200View(Model model) throws Exception {	
		return "redirect:/adm/adm1000/adm1200/selectMemberInfo.do";
	}
	
	/**
	 * 멤버 정보 리스트 조회
	 * @param Map<String, Object> - pageNo, memberState, searchValue
	 * @return String - 회원 관리 페이지
	 */
	@RequestMapping(value = "/adm/adm1000/adm1200/selectMemberInfo.do")
	public ModelAndView selectMemberInfo(@RequestParam Map<String, Object> params) throws Exception {	
		return adm1200Service.selectMemberInfo(params);
	}
	

}
