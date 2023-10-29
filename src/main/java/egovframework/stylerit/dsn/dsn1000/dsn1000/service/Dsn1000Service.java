package egovframework.stylerit.dsn.dsn1000.dsn1000.service;

import java.util.ArrayList;

/**
 * @Class Name : Dsn1000Service.java
 * @Description : 디자이너 소개 관련 Service Class
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
 */

public interface Dsn1000Service {

	//디자이너 정보 조회
	ArrayList<Dsn1000VO> selectDsnInfoAjax(String S_LOC_CD) throws Exception;

}
