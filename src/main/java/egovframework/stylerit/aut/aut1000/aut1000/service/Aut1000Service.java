package egovframework.stylerit.aut.aut1000.aut1000.service;

import java.util.Map;

import javax.servlet.http.HttpSession;

/**
 * @Class Name : Cmmn1000Service.java
 * @Description : 로그인 관련 Service Class
 * @Modification Information
 * @
 * @   수정일         수정자                     수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2023.09.11     이수연                      최초생성
 *
 * @author 이수연
 * @since 2023.09.11
 * @version 1.0
 * @see
 */

public interface Aut1000Service {
	
	//로그인 정보 확인 및 세션 저장
	String loginAjax(Map<String, String> paramMap, HttpSession session) throws Exception;
	
}
