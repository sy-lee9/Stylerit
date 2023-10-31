package egovframework.stylerit.adm.adm1000.adm1100.adm1100.service.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import egovframework.stylerit.adm.adm1000.adm1100.adm1100.service.Adm1100DAO;
import egovframework.stylerit.adm.adm1000.adm1100.adm1100.service.Adm1100Service;

/**
 * @Class Name : Adm1100ServiceImpl.java
 * @Description : 메뉴 관리 관련 Business Implement Class
 * @Modification Information
 * @
 * @   수정일         수정자                     수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2023.10.25      이수연                      최초생성
 *
 * @author 이수연
 * @since 2023.10.25 
 * @version 1.0
 * @see
 */

@Service("adm1100Service")
public class Adm1100ServiceImpl extends EgovAbstractServiceImpl implements Adm1100Service {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Resource(name="adm1100DAO")
	private Adm1100DAO adm1100DAO;
	
	/**
	 * 메뉴 순서 업데이트
	 * @param Map - 샵 코드 & 변경된 메뉴 순서
	 * @return int - 업데이트 된 row 수
	 */
	@Override
	public int updateMenuSequenceAjax(Map<String, Object> paramMap) {
		return adm1100DAO.updateMenuSequenceAjax(paramMap);
	}


}
