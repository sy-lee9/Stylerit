package egovframework.stylerit.mn.mn1000.mn1000.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.egovframe.rte.psl.dataaccess.mapper.Mapper;

/**
 * @Class Name : Mn1000DAO.java
 * @Description : 메뉴 관련 DAO Interface
 * @Modification Information
 *
 *         수정일                수정자                     수정내용
 *  ----------------    ------------    ---------------------------
 *      2023.10.14            이수연                     최초 생성
 *
 * @author  이수연
 * @since 2023.10.14
 * @version 1.0
 * @see
 * 
 */

@Mapper("mn1000DAO")
public interface Mn1000DAO {

	/**
	 * 메뉴 분류 조회
	 * @param Map - 선택된 메뉴 & 샵 코드
	 * @return ArrayList<Mn1000VO> - 메뉴명, 가격
	 */
	ArrayList<Map<String, String>> selectMnClList(String S_LOC_CD);
	
	/**
	 * 메뉴 리스트 조회
	 * @param Map - 선택된 메뉴 & 샵 코드
	 * @return ArrayList<Mn1000VO> - 메뉴명, 가격
	 */
	ArrayList<Mn1000VO> selectMnListAjax(Map<String, String> paramMap) throws Exception;


	
	
	
}
