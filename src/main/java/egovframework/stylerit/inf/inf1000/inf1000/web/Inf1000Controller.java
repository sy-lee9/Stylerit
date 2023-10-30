package egovframework.stylerit.inf.inf1000.inf1000.web;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.stylerit.inf.inf1000.inf1000.service.Inf1000Service;

/**
 * @Class Name : Inf1000Controller.java
 * @Description : 샵소개 관련 Controller Class
 * @Modification Information
 * @
 * @   수정일         수정자                     수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2023.10.20     이수연                      최초생성
 *
 * @author 이수연
 * @since 2023.10.20
 * @version 1.0
 * @see
 *
 */

@Controller
public class Inf1000Controller {

	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Resource(name="inf1000Service")
	private Inf1000Service inf1000Service;
	
	/**
	 * 샵소개 페이지로 이동 
	 * @return String - 샵소개 페이지
	 */
	@RequestMapping(value = "/")
	public String main(HttpSession session, Model model) throws Exception {		
		return "redirect:/inf/inf1000/inf1000/selectInf1000View.do";
	}
	
	/**
	 * 샵소개 페이지로 이동 
	 * @return String - 샵소개 페이지
	 */
	@RequestMapping(value = "/inf/inf1000/inf1000/selectInf1000View.do")
	public String selectInf1000View(HttpSession session, Model model) throws Exception {		
		
		//해당 샵 코드 세션에 저장
		session.setAttribute("S_LOC_CD", "1");
		
		//해당 샵 코드 가져오기
		String S_LOC_CD = (String) session.getAttribute("S_LOC_CD");
		
		//조회된 샵 정보
		Map<String, Object> shopInfo = inf1000Service.selectShopInfo(S_LOC_CD);	
		model.addAttribute("shopInfo", shopInfo);
		
		//GNV Type
		model.addAttribute("page", "inf");
		return "inf/inf1000/inf1000/inf1000";
	}
	
	
	
	
	
	
	
	
	
	
	
}
