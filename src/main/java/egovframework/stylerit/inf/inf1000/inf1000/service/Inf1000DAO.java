package egovframework.stylerit.inf.inf1000.inf1000.service;

import java.util.List;
import java.util.Map;

import org.egovframe.rte.psl.dataaccess.mapper.Mapper;

/**
 * @Class Name : Inf1000DAO.java
 * @Description : 샵소개 관련 DAO Interface
 * @Modification Information
 *
 *        수정일                수정자                     수정내용
 * ----------------    ------------    ---------------------------
 *     2023.10.20             이수연                     최초 생성
 *
 * @author  이수연
 * @since 2023.10.20
 * @version 1.0
 * @see
 * 
 */

@Mapper("inf1000DAO")
public interface Inf1000DAO {

	/**
	 * 샵 정보 조회
	 * @param String - 샵 코드
	 * @return HashMap<String, Object> - 샵 정보
	 */
	Map<String, Object> selectShopInfo(String s_LOC_CD);


	
	
}
