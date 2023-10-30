package egovframework.stylerit.usr.usr1000.usr1000.web;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.stylerit.usr.usr1000.usr1000.service.Usr1000Service;

/**
 * @Class Name : Usr1000Controller.java
 * @Description : 회원정보 관련 Controller Class
 * @Modification Information
 * @
 * @   수정일         수정자                     수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2023.10.06     이수연                      최초생성
 *
 * @author 이수연
 * @since 2023.10.06
 * @version 1.0
 * @see
 *
 */

@Controller
public class Usr1000Controller {	

	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Resource(name="usr1000Service")
	private Usr1000Service usr1000Service;
	
	/**
	 * 마이페이지로 이동 
	 * @return String - 마이페이지
	 */
	@RequestMapping(value = "/usr/usr1000/usr1000/selectUsr1000View.do")
	public String selectUsr1000View() throws Exception {		
		return "usr/usr1000/usr1000/usr1000";
	}

}
