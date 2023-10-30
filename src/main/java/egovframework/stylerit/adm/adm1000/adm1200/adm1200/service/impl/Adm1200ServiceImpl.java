package egovframework.stylerit.adm.adm1000.adm1200.adm1200.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.egovframe.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import egovframework.stylerit.adm.adm1000.adm1200.adm1200.service.Adm1200DAO;
import egovframework.stylerit.adm.adm1000.adm1200.adm1200.service.Adm1200Service;
import egovframework.stylerit.adm.adm1000.adm1200.adm1200.service.Adm1200VO;

/**
 * @Class Name : Adm1200ServiceImpl.java
 * @Description : 회원 관리 관련 Business Implement Class
 * @Modification Information
 * @
 * @   수정일         수정자                     수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2023.10.23      이수연                      최초생성
 *
 * @author 이수연
 * @since 2023.10.23 
 * @version 1.0
 * @see
 */

@Service("adm1200Service")
public class Adm1200ServiceImpl extends EgovAbstractServiceImpl implements Adm1200Service {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Resource(name="adm1200DAO")
	private Adm1200DAO adm1200DAO;

	/**
	 * 멤버 정보 리스트 조회
	 * @param Map<String, Object> - pageNo, memberState, searchValue
	 * @return String - 회원 관리 페이지
	 */
	@Override
	public ModelAndView selectMemberInfo(Map<String, Object> params) {
		
		ModelAndView mav = new ModelAndView("adm/adm1000/adm1200/adm1200");
		
		//GNV Type
		mav.addObject("page", "mbAdm");
		
		PaginationInfo paginationInfo = new PaginationInfo();
		
		//현재 페이지 번호
	    int pageNo = 1; 
	    //한 페이지에 나올 회원정보 수
	    int listScale = 5; 
	    //페이지 개수
	    int pageScale = 5; 
	    //전체 회원정보 갯수
        int totalList = adm1200DAO.selectTotalMemberCnt(params); 
	    
	    try {
	        if(params.size() > 0) {
	        	//현재 페이지 번호
	            pageNo = Integer.parseInt((String)params.get("pageNo"));
	        }

	        //PaginationRenderer로 보낼 값 저장 
	        paginationInfo.setCurrentPageNo(pageNo);
	        paginationInfo.setRecordCountPerPage(listScale); 
	        paginationInfo.setPageSize(pageScale); 
	        paginationInfo.setTotalRecordCount(totalList);

	        //시작 index
	        int startIndex = paginationInfo.getFirstRecordIndex(); 
	        //한 페이지에 나올 회원정보 수
	        int listSize = listScale; 
	        
	        params.put("startIndex", startIndex);
	        params.put("listSize", listSize);            
	        
	        //해당 페이지에 나올 회원정보 리스트
	        List<Adm1200VO> memberInfoList = adm1200DAO.selectMemberInfo(params); 	

	        mav.addObject("pageNo",pageNo);
	        mav.addObject("memberInfoList",memberInfoList);
	        mav.addObject("totalList",totalList);
	        mav.addObject("paginationInfo",paginationInfo);

	    } catch (Exception e) {
	    	e.printStackTrace(); 
			throw e;
	    }
		
		return mav;
	}
	

	
	

}
