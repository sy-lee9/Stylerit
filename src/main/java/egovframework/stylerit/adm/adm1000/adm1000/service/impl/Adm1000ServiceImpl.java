package egovframework.stylerit.adm.adm1000.adm1000.service.impl;

import javax.annotation.Resource;

import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import egovframework.stylerit.adm.adm1000.adm1000.service.Adm1000DAO;
import egovframework.stylerit.adm.adm1000.adm1000.service.Adm1000Service;

/**
 * @Class Name : Adm1000ServiceImpl.java
 * @Description : 소개 관리 관련 Business Implement Class
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

@Service("adm1000Service")
public class Adm1000ServiceImpl extends EgovAbstractServiceImpl implements Adm1000Service {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Resource(name="adm1000DAO")
	private Adm1000DAO adm1000DAO;
	
	
	

}
