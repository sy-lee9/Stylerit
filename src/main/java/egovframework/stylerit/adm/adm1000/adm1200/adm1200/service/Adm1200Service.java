package egovframework.stylerit.adm.adm1000.adm1200.adm1200.service;

import java.util.Map;

import org.springframework.web.servlet.ModelAndView;

/**
 * @Class Name : Adm1200Service.java
 * @Description : 회원 관리 관련 Service Class
 * @Modification Information
 * @
 * @   수정일         수정자                     수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2023.10.23      이수연                      최초생성
 *
 * @author 이수연
 * @since 2023.10.23 
 * @version 1.0
 * @see
 */

public interface Adm1200Service {

	//멤버 정보 리스트 조회
	ModelAndView selectMemberInfo(Map<String, Object> params);
	
	
	
}
