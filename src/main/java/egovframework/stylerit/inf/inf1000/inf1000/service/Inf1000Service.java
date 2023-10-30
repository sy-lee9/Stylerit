package egovframework.stylerit.inf.inf1000.inf1000.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import egovframework.stylerit.dsn.dsn1000.dsn1000.service.Dsn1000VO;

/**
 * @Class Name : Inf1000Service.java
 * @Description : 샵소개 관련 Service Class
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
 */

public interface Inf1000Service {

	//샵 정보 조회
	Map<String, Object> selectShopInfo(String s_LOC_CD);

}
