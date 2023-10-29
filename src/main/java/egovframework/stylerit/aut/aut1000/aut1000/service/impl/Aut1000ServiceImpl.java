package egovframework.stylerit.aut.aut1000.aut1000.service.impl;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.egovframe.rte.fdl.cryptography.EgovPasswordEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import egovframework.stylerit.aut.aut1000.aut1000.service.Aut1000DAO;
import egovframework.stylerit.aut.aut1000.aut1000.service.Aut1000Service;
import egovframework.stylerit.aut.aut1000.aut1000.service.Aut1000VO;

/**
 * @Class Name : Cmmn1000ServiceImpl.java
 * @Description : 로그인 관련 Business Implement Class
 * @Modification Information
 * @
 * @   수정일         수정자                     수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2023.09.11     이수연                      최초생성
 *
 * @author 이수연
 * @since 2023.09.11
 * @version 1.0
 * @see
 */

@Service("aut1000Service")
public class Aut1000ServiceImpl extends EgovAbstractServiceImpl implements Aut1000Service {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Resource(name="aut1000DAO")
	private Aut1000DAO aut1000DAO;
	
	// 비밀번호 암호화 서비스     
	@Autowired
    EgovPasswordEncoder egovPasswordEncoder;
	
	/**
	 * 로그인 정보 확인 및 세션 저장
	 * @param Map - authChk, email, id, pw
	 * @return String - 로그인 성공 여부
	 */
	@Override
	public String loginAjax(Map<String, String> paramMap, HttpSession session) throws Exception {
		
		//로그인 성공 여부 확인 메세지
		String msg = "false";
		
		//사용자 권한 확인
		String autChk = paramMap.get("autChk");
		
		//사용자 입력 정보를 담을 VO
		Aut1000VO aut1000VO = null;
		
		//autChk 값이 member일 경우
		if(autChk != null && autChk.equals("member")) {			

			//가입된 회원 정보가 있는지 조회
			aut1000VO = aut1000DAO.selectMemberInfoChk(paramMap);
			
			//가입된 회원 정보가 존재하면
			if(aut1000VO != null) {
								
				//사용자 입력 비밀번호
				String plainPw = (String) paramMap.get("pw");
				//암호화된 비밀번호
				String encodedPw = aut1000VO.getM_PW();			

				//비밀번호 일치 여부 확인
				boolean isMatched = egovPasswordEncoder.checkPassword(plainPw, encodedPw);
				
				if(isMatched) {
					
					//msg 값을 true로 반환
					msg = "true";				
					
					//로그인 상태 세션에 저장(로그인 여부, 회원상태, 회원권한, 회원명)
					session.setAttribute("login", "member");
					session.setAttribute("M_ST", aut1000VO.getM_ST());
					session.setAttribute("M_AUTR_CD", aut1000VO.getM_AUTR_CD());
					session.setAttribute("M_NM", aut1000VO.getM_NM());
					
				}
								
			}else {
				//일치하는 정보가 없으면 msg 값을 false로 반환
				msg = "false";
			}				
			
		//autChk 값이 designer일 경우	
		} else if(autChk != null && autChk.equals("designer")) {

			//등록된 디자이너 정보가 있는지 조회
			aut1000VO = aut1000DAO.selectDsnInfoChk(paramMap);
			
			//등록된 디자이너 정보가 존재하면
			if(aut1000VO != null) {
				
				//사용자 입력 비밀번호
				String plainPw = (String) paramMap.get("pw");
				//암호화된 비밀번호
				String encodedPw = aut1000VO.getD_PW();			

				//비밀번호 일치 여부 확인
				boolean isMatched = egovPasswordEncoder.checkPassword(plainPw, encodedPw);
				
				if(isMatched) {

					//msg 값을 true로 반환
					msg = "true";				
					
					//로그인 상태 세션에 저장(로그인 여부, 지점코드, 직급, 권한, 디자이너명)
					session.setAttribute("login", "designer");
					session.setAttribute("S_LOC_CD", aut1000VO.getS_LOC_CD());
					session.setAttribute("D_POS_CD", aut1000VO.getD_POS_CD());
					session.setAttribute("D_AUTR_CD", aut1000VO.getD_AUTR_CD());
					session.setAttribute("D_NM", aut1000VO.getD_NM());
										
				}
				
			}else {
				//일치하는 정보가 없으면 msg 값을 false로 반환
				msg = "false";
			}	
			
		}
		
		return msg;
	}



}
