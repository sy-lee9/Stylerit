package egovframework.stylerit.dsn.dsn1000.dsn1000.web;

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
import org.springframework.web.bind.annotation.ResponseBody;

import egovframework.stylerit.dsn.dsn1000.dsn1000.service.Dsn1000Service;
import egovframework.stylerit.dsn.dsn1000.dsn1000.service.Dsn1000VO;

/**
 * @Class Name : Dsn1000Controller.java
 * @Description : 디자이너 소개 관련 Controller Class
 * @Modification Information
 * @
 * @   수정일         수정자                     수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2023.10.19     이수연                      최초생성
 *
 * @author 이수연
 * @since 2023.10.19
 * @version 1.0
 * @see
 *
 */

@Controller
public class Dsn1000Controller {

	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Resource(name="dsn1000Service")
	private Dsn1000Service dsn1000Service;
	
	/**
	 * 메뉴 페이지로 이동 
	 * @return String - 메뉴 페이지
	 */
	@RequestMapping(value = "/dsn/dsn1000/dsn1000/selectDsn1000View.do")
	public String selectDsn1000View(Model model) throws Exception {				
		//GNV Type
		model.addAttribute("page", "dsn");
		return "dsn/dsn1000/dsn1000/dsn1000";
	}
	
	/**
	 * 디자이너 정보 조회
	 * @return HashMap<String, Object> - 디자이너 정보 리스트
	 */
	@RequestMapping(value = "/dsn/dsn1000/dsn1000/selectDsnInfoAjax.do")
	@ResponseBody
	public Map<String, Object> selectDsnInfoAjax(HttpSession session) throws Exception {		
		
		//view로 내려보낼 list가 담길 map
		Map<String, Object> map = new HashMap<String, Object>();
		
		//해당 샵 코드 가져오기
		String S_LOC_CD = (String) session.getAttribute("S_LOC_CD");
		
		//조회된 디자이너 정보 리스트 
		ArrayList<Dsn1000VO> list = dsn1000Service.selectDsnInfoAjax(S_LOC_CD);	
		//map에 담아서 반환
		map.put("dsnInfo", list);
		
		return map;
	}
	
	
	
	
	
	
	
	
	
	
}
