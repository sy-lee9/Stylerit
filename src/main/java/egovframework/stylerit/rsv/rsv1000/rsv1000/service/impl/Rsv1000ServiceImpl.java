package egovframework.stylerit.rsv.rsv1000.rsv1000.service.impl;

import javax.annotation.Resource;

import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import egovframework.stylerit.rsv.rsv1000.rsv1000.service.Rsv1000DAO;
import egovframework.stylerit.rsv.rsv1000.rsv1000.service.Rsv1000Service;

/**
 * @Class Name : Rsv1000ServiceImpl.java
 * @Description : 예약 관련 Business Implement Class
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

@Service("rsv1000Service")
public class Rsv1000ServiceImpl extends EgovAbstractServiceImpl implements Rsv1000Service {

	Logger logger = LoggerFactory.getLogger(getClass());

	@Resource(name="rsv1000DAO")
	private Rsv1000DAO rsv1000DAO;
	
	/**
	 * 디자이너 정보 조회
	 * @param String - 샵 코드
	 * @return HashMap<String, Object> - 디자이너 정보 리스트
	 */
	

}
