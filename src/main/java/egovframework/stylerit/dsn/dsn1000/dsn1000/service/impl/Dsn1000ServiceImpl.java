package egovframework.stylerit.dsn.dsn1000.dsn1000.service.impl;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import egovframework.stylerit.dsn.dsn1000.dsn1000.service.Dsn1000DAO;
import egovframework.stylerit.dsn.dsn1000.dsn1000.service.Dsn1000Service;
import egovframework.stylerit.dsn.dsn1000.dsn1000.service.Dsn1000VO;

/**
 * @Class Name : Dsn1000ServiceImpl.java
 * @Description : 디자이너 소개 관련 Business Implement Class
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

@Service("dsn1000Service")
public class Dsn1000ServiceImpl extends EgovAbstractServiceImpl implements Dsn1000Service {

	Logger logger = LoggerFactory.getLogger(getClass());

	@Resource(name="dsn1000DAO")
	private Dsn1000DAO dsn1000DAO;
	
	/**
	 * 디자이너 정보 조회
	 * @param String - 샵 코드
	 * @return HashMap<String, Object> - 디자이너 정보 리스트
	 */
	@Override
	public ArrayList<Dsn1000VO> selectDsnInfoAjax(String S_LOC_CD) throws Exception {
		return dsn1000DAO.selectDsnInfoAjax(S_LOC_CD);
	}
	

}
