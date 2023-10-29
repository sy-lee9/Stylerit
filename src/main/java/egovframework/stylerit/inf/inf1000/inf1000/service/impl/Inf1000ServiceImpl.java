package egovframework.stylerit.inf.inf1000.inf1000.service.impl;

import javax.annotation.Resource;

import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import egovframework.stylerit.inf.inf1000.inf1000.service.Inf1000DAO;
import egovframework.stylerit.inf.inf1000.inf1000.service.Inf1000Service;

/**
 * @Class Name : Inf1000ServiceImpl.java
 * @Description : 샵소개 관련 Business Implement Class
 * @Modification Information
 * @
 * @   수정일         수정자                     수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2023.10.20     이수연                      최초생성
 *
 * @author 이수연
 * @since 2023.10.20
 * @version 1.0
 * @see
 */

@Service("inf1000Service")
public class Inf1000ServiceImpl extends EgovAbstractServiceImpl implements Inf1000Service {

	Logger logger = LoggerFactory.getLogger(getClass());

	@Resource(name="inf1000DAO")
	private Inf1000DAO inf1000DAO;
	
	/**
	 * 디자이너 정보 조회
	 * @param String - 샵 코드
	 * @return HashMap<String, Object> - 디자이너 정보 리스트
	 */
	

}
