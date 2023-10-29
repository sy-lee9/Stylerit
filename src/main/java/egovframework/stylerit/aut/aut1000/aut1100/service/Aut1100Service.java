package egovframework.stylerit.aut.aut1000.aut1100.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
 * @Class Name : Aut1100Service.java
 * @Description : 회원가입 관련 Service Class
 * @Modification Information
 * @
 * @   수정일         수정자                     수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2023.10.04     이수연                      최초생성
 *
 * @author 이수연
 * @since 2023.10.04
 * @version 1.0
 * @see
 */

public interface Aut1100Service {

	//이메일 중복 확인
	String mailOverlayChkAjax(String email) throws Exception;

	//회원가입
	String joinAjax(Map<String, Object> paramMap, HttpServletRequest req);

	
	
}
