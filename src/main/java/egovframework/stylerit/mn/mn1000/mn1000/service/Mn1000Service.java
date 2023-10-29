package egovframework.stylerit.mn.mn1000.mn1000.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Class Name : Mn1000Service.java
 * @Description : 메뉴 관련 Service Class
 * @Modification Information
 * @
 * @   수정일         수정자                     수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2023.10.14     이수연                      최초생성
 *
 * @author 이수연
 * @since 2023.10.14
 * @version 1.0
 * @see
 */

public interface Mn1000Service {

	//메뉴 분류 조회
	ArrayList<Map<String, String>> selectMnClList(String S_LOC_CD);
	
	//메뉴 리스트 조회
	ArrayList<Mn1000VO> selectMnListAjax(Map<String, String> paramMap) throws Exception;


	
	
	
}
