package egovframework.stylerit.aut.aut1000.aut1100.service;

import java.util.Map;

import org.egovframe.rte.psl.dataaccess.mapper.Mapper;

/**
 * @Class Name : Aut1100DAO.java
 * @Description : 회원가입 관련 DAO Interface
 * @Modification Information
 *
 *         수정일                수정자                     수정내용
 *  ----------------    ------------    ---------------------------
 *      2023.10.04             이수연                     최초 생성
 *
 * @author  이수연
 * @since 2023.10.04
 * @version 1.0
 * @see
 * 
 */

@Mapper("aut1100DAO")
public interface Aut1100DAO {	
	
	/**
	 * 이메일 중복 확인
	 * @param String - email
	 * @return int - 중복된 이메일 갯수
	 */
	int mailOverlayChkAjax(String email) throws Exception;

	/**
	 * 회원가입
	 * @param paramMap - 회원정보
	 * @return int - 회원가입 성공여부
	 */
	int joinAjax(Map<String, Object> paramMap);
	
}
