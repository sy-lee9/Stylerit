package egovframework.stylerit.rsv.rsv1000.rsv1000.web;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.stylerit.rsv.rsv1000.rsv1000.service.Rsv1000Service;

/**
 * @Class Name : Rsv1000Controller.java
 * @Description : 예약 관련 Controller Class
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
public class Rsv1000Controller {

	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Resource(name="rsv1000Service")
	private Rsv1000Service rsv1000Service;
	
	/**
	 * 메뉴 페이지로 이동 
	 * @return String - 메뉴 페이지
	 */
	@RequestMapping(value = "/rsv/rsv1000/rsv1000/selectRsv1000View.do")
	public String selectRsv1000View(Model model) throws Exception {				
		//GNV Type
		model.addAttribute("page", "rsv");
		return "rsv/rsv1000/rsv1000/rsv1000";
	}
	
	
	
	
	
	
	
	
	
	
	
}
