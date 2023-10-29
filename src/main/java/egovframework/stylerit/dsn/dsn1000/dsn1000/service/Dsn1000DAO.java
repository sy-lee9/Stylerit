package egovframework.stylerit.dsn.dsn1000.dsn1000.service;

import java.util.ArrayList;

import org.egovframe.rte.psl.dataaccess.mapper.Mapper;

/**
 * @Class Name : Dsn1000DAO.java
 * @Description : 디자이너 소개 관련 DAO Interface
 * @Modification Information
 *
 *        수정일                수정자                     수정내용
 * ----------------    ------------    ---------------------------
 *     2023.10.19             이수연                     최초 생성
 *
 * @author  이수연
 * @since 2023.10.19
 * @version 1.0
 * @see
 * 
 */

@Mapper("dsn1000DAO")
public interface Dsn1000DAO {

	/**
	 * 디자이너 정보 조회
	 * @param String - 샵 코드
	 * @return HashMap<String, Object> - 디자이너 정보 리스트
	 */
	ArrayList<Dsn1000VO> selectDsnInfoAjax(String S_LOC_CD) throws Exception;

	
	
}
