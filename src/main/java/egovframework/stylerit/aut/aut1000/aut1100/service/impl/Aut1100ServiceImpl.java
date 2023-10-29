package egovframework.stylerit.aut.aut1000.aut1100.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.egovframe.rte.fdl.cryptography.EgovPasswordEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Service;

import egovframework.stylerit.aut.aut1000.aut1100.service.Aut1100DAO;
import egovframework.stylerit.aut.aut1000.aut1100.service.Aut1100Service;

/**
 * @Class Name : Aut1100ServiceImpl.java
 * @Description : 회원가입 관련 Business Implement Class
 * @Modification Information
 * @
 * @   수정일         수정자                     수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2023.10.04     이수연                      최초생성
 *
 * @author 이수연
 * @since 2023.10.04
 * @version 1.0
 * @see
 */

@Service("aut1100Service")
public class Aut1100ServiceImpl extends EgovAbstractServiceImpl implements Aut1100Service {

	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Resource(name="aut1100DAO")
	private Aut1100DAO aut1100DAO;
	
	//message
	@Autowired 
	ReloadableResourceBundleMessageSource ms;
	
	//비밀번호 암호화 서비스
	@Autowired
    EgovPasswordEncoder egovPasswordEncoder;

	/**
	 * 이메일 중복 확인
	 * @param String - email
	 * @return int - 중복된 이메일 갯수
	 */
	@Override
	public String mailOverlayChkAjax(String email) throws Exception{
		//이메일 중복확인 결과를 담을 result 변수
		String result = "";
		int row = 0;
		
		//이메일 중복 조회 및 일치하는 이메일 갯수 반환  
		try {
			row = aut1100DAO.mailOverlayChkAjax(email);
		} catch (Exception e) {
			System.out.println(e);
		}

		//중복된 이메일이 없을 경우
		if(row == 0) {
			result = "true";
		}else { //중복된 이메일이 존재할 경우
			result = "false";
		}
		
		return result;
	}
	
	/**
	 * 회원가입
	 * @param paramMap - 회원정보
	 * @return String - 회원가입 성공여부
	 */
	@Override
	public String joinAjax(Map<String, Object> paramMap, HttpServletRequest req) {
		
		//회원가입 성공여부
		String msg = "false";	
		
		//파마메터 값이 들어올 경우 메서드 실행
		if(paramMap != null) {
			
			//사용자 입력 비밀번호
			String plainPw = (String) paramMap.get("pw");
			//암호화된 비밀번호
			String encodedPw = egovPasswordEncoder.encryptPassword(plainPw);			
			paramMap.put("encodedPw", encodedPw);
			
			//사용자 IP
			String cltIp = req.getRemoteAddr();	
			paramMap.put("cltIp", cltIp);

			try {
				
				int row = aut1100DAO.joinAjax(paramMap);
				
				if(row == 1) {
					msg = "true";
				}else {
					msg = ms.getMessage("join.false", null, null);
				}
				
			} catch (Exception e) {
				System.out.println(e);
			}
		
		}
		
		return msg;
	}


	

}
