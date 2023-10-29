package egovframework.stylerit.mn.mn1000.mn1000.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import egovframework.stylerit.mn.mn1000.mn1000.service.Mn1000DAO;
import egovframework.stylerit.mn.mn1000.mn1000.service.Mn1000Service;
import egovframework.stylerit.mn.mn1000.mn1000.service.Mn1000VO;

/**
 * @Class Name : Mn1000ServiceImpl.java
 * @Description : 메뉴 관련 Business Implement Class
 * @Modification Information
 * @
 * @   수정일         수정자                     수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2023.10.14     이수연                      최초생성
 *
 * @author 이수연
 * @since 2023.10.14
 * @version 1.0
 * @see
 */

@Service("mn1000Service")
public class Mn1000ServiceImpl extends EgovAbstractServiceImpl implements Mn1000Service {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Resource(name="mn1000DAO")
	private Mn1000DAO mn1000DAO;

	/**
	 * 메뉴 분류 조회
	 * @param Map - 샵 코드
	 * @return List<Mn1000VO> - 메뉴 분류
	 */
	@Override
	public ArrayList<Map<String, String>> selectMnClList(String S_LOC_CD) {
		return mn1000DAO.selectMnClList(S_LOC_CD);
	}
	
	/**
	 * 메뉴 리스트 조회
	 * @param Map - 선택된 메뉴, 샵 코드
	 * @return ArrayList<Mn1000VO> - 메뉴명, 가격
	 */
	@Override
	public ArrayList<Mn1000VO> selectMnListAjax(Map<String, String> paramMap) throws Exception {
		return 	mn1000DAO.selectMnListAjax(paramMap);
	}


	
	

}
