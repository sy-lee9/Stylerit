package egovframework.stylerit.adm.adm1000.adm1100.adm1100.service;

import java.util.List;
import java.util.Map;

import org.egovframe.rte.psl.dataaccess.mapper.Mapper;

/**
 * @Class Name : Adm1100DAO.java
 * @Description : 메뉴 관리 관련 DAO Class
 * @Modification Information
 *
 *         수정일                수정자                     수정내용
 *  ----------------    ------------    ---------------------------
 *      2023.10.25             이수연                     최초 생성
 *
 * @author  이수연
 * @since 2023.10.25 
 * @version 1.0
 * @see
 * 
 */

@Mapper("adm1100DAO")
public interface Adm1100DAO {

	//메뉴 순서 업데이트
	int updateMenuSequenceAjax(Map<String, Object> paramMap);



	
	
	
}
