package egovframework.stylerit.adm.adm1000.adm1200.adm1200.service;

import java.util.List;
import java.util.Map;

import org.egovframe.rte.psl.dataaccess.mapper.Mapper;

/**
 * @Class Name : Adm1200DAO.java
 * @Description : 회원 관리 관련 DAO Class
 * @Modification Information
 *
 *         수정일                수정자                     수정내용
 *  ----------------    ------------    ---------------------------
 *      2023.10.23             이수연                     최초 생성
 *
 * @author  이수연
 * @since 2023.10.23 
 * @version 1.0
 * @see
 * 
 */

@Mapper("adm1200DAO")
public interface Adm1200DAO {

	/**
	 * 전체 회원정보 수 조회
	 * @param Map<String, Object> - pageNo, memberState, searchValue
	 * @return int - 전체 회원정보 수
	 */
	int selectTotalMemberCnt(Map<String, Object> params);


	/**
	 * 멤버 정보 리스트 조회
	 * @param Map<String, Object> - pageNo, memberState, searchValue
	 * @return String - 회원 관리 페이지
	 */
	List<Adm1200VO> selectMemberInfo(Map<String, Object> params);


	
	
	
}
