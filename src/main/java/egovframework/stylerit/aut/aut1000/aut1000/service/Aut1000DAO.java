package egovframework.stylerit.aut.aut1000.aut1000.service;

import java.util.Map;

import org.egovframe.rte.psl.dataaccess.mapper.Mapper;

/**
 * @Class Name : Aut1000DAO.java
 * @Description : 로그인 관련 DAO Interface
 * @Modification Information
 *
 *         수정일                수정자                     수정내용
 *  ----------------    ------------    ---------------------------
 *      2023.09.11             이수연                     최초 생성
 *
 * @author  이수연
 * @since 2023.09.11
 * @version 1.0
 * @see
 * 
 */

@Mapper("aut1000DAO")
public interface Aut1000DAO {
	
	/**
	 * 가입된 회원 정보 조회
	 * @param Map - authChk, email, id, pw
	 * @return VO - 회원 정보가 담긴 Inf1000VO
	 */
	Aut1000VO selectMemberInfoChk(Map paramMap) throws Exception;

	//등록된 디자이너 정보 조회
	Aut1000VO selectDsnInfoChk(Map<String, String> paramMap) throws Exception;

}
