package egovframework.stylerit.adm.adm1000.adm1100.adm1100.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import egovframework.stylerit.adm.adm1000.adm1100.adm1100.service.Adm1100Service;
import egovframework.stylerit.mn.mn1000.mn1000.service.Mn1000Service;

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
	 * @param ArrayList - 변경된 메뉴 순서
	 * @return int - 성공여부
	 */
	@RequestMapping(value = "/adm/adm1100/adm1100/updateMenuSequenceAjax.do")
	@ResponseBody
	public String updateMenuSequenceAjax(HttpSession session, @RequestBody String param) throws Exception {		

		//순서 변경 성공 여부
		String success = "false";
		
		//json 형태의 값을 문자열 or 자바 객체 형태로 변환
		JSONParser jsonParser = new JSONParser();
		//json 형태의 array
		JSONArray jsonArray = null;
		try {
			//view에서 넘어온 json 형태의 파라메터를 array 형태로 변환
			jsonArray = (JSONArray) jsonParser.parse(param);		
		} catch (ParseException e) {
			e.printStackTrace();
		}

		//쿼리문 조회를 위한 정보가 담길 map
		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		//변경할 메뉴의 개수
		int listSize = jsonArray.size();
		logger.info("listSize : "+listSize);
		paramMap.put("listSize", listSize);		
		
		
		//paramMap에 변경된 메뉴 순서 담기
		paramMap.put("menuSequenceList", jsonArray);		

		//해당 샵 코드 가져오기
		String S_LOC_CD = (String) session.getAttribute("S_LOC_CD");
		//paramMap에 해당 샵 코드 담기
		paramMap.put("S_LOC_CD", S_LOC_CD);		
		
		if(paramMap != null) {
			
			try {
				//업데이트 된 row 수
				int row = adm1100Service.updateMenuSequenceAjax(paramMap);	
				
				//변경하려는 메뉴 개수와 update row 수가 일치할 경우
				if(listSize == row) {
					success = "true";
				}else { //일치하지 않을 경우
					success = "false";
				}
			}catch (Exception e) {
		    	e.printStackTrace(); 
				throw e;
			}
			
		}	
		
		return success;
	}
	
	
	
	
}
