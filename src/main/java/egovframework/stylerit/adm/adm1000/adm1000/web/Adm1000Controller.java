package egovframework.stylerit.adm.adm1000.adm1000.web;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.stylerit.adm.adm1000.adm1000.service.Adm1000Service;

/**
 * @Class Name : Adm1000Controller.java
 * @Description : 소개 관리 관련 Controller Class
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
public class Adm1000Controller {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Resource(name="adm1000Service")
	private Adm1000Service adm1000Service;
	
	/**
	 * 소개 관리 페이지로 이동
	 * @return : 샵소개 관리 페이지
	 */
	@RequestMapping(value = "/adm/adm1000/adm1000/selectAdm1000View.do")
	public String selectAdm1000View() throws Exception {		
		return "adm/adm1000/adm1000/adm1000";
	}
	

}
