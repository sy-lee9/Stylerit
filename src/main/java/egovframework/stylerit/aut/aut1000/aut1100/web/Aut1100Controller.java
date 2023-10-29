package egovframework.stylerit.aut.aut1000.aut1100.web;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import egovframework.stylerit.aut.aut1000.aut1100.service.Aut1100Service;

/**
 * @Class Name : Aut1100Controller.java
 * @Description : 회원가입 관련 Controller Class
 * @Modification Information
 * @
 * @   수정일         수정자                     수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2023.10.04     이수연                     최초생성
 *
 * @author 이수연
 * @since 2023.10.04
 * @version 1.0
 * 
 */

@Controller
public class Aut1100Controller {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Resource(name="aut1100Service")
	private Aut1100Service aut1100Service;
	
	//메일 전송 관련 서비스
	@Autowired
	private MailSender mailSender;

	//message-common
	@Autowired 
	ReloadableResourceBundleMessageSource ms;
	
	
	/**
	 * 회원가입 페이지로 이동
	 * @return String - 리턴 Url
	 */
	@RequestMapping(value = "/aut/aut1000/aut1100/selectAut1100View.do")
	public String selectAut1100View() throws Exception {		
		return "aut/aut1000/aut1100/aut1100";
	}
	
	/**
	 * 이메일 중복 확인
	 * @param String - email
	 * @return String - 중복된 이메일 갯수
	 */
	@RequestMapping(value = "/aut/aut1100/aut1100/mailOverlayChkAjax.do")
	@ResponseBody
	public String mailOverlayChkAjax(@RequestParam String email) throws Exception {		
		return aut1100Service.mailOverlayChkAjax(email);
	}
	

	/**
	 * 인증번호 발송
	 * @param String - email
	 * @return String - 이메일 인증번호
	 */
	@RequestMapping(value = "/aut/aut1100/aut1100/sendAuthNumAjax.do")
	@ResponseBody
	public String sendAuthNum(@RequestParam String email) throws Exception {	

		//인증번호 길이
		int authNum_length = 10;

		//인증번호
		String authNum = "";

		//랜덤 인증번호 생성
		for(int i = 0; i < authNum_length; i++) {
			int randNum = (int) (Math.random() * 10);
			authNum += randNum;
		}
		
		//message에 넣을 인증번호
		Object [] args = {authNum};
		
		try {
			
			//메일 전송 서비스
			SimpleMailMessage mailMsg = new SimpleMailMessage();			

			//발송하는 메일 주소
			String fromAddress = ms.getMessage("mail.fromAddress", null, null);
			//메일 제목
			String title = ms.getMessage("mail.title", null, null);
			//메일 내용
			String content = ms.getMessage("mail.content", args, null);
			
			if(fromAddress != null && title != null && content != null) {

				//메일 정보 담기
				mailMsg.setFrom(fromAddress);
				mailMsg.setSubject(title);
				mailMsg.setText(content);
				mailMsg.setTo(email);
				
				//메일 전송
				mailSender.send(mailMsg);
			}			
			
		} catch (Exception e) {
			System.out.println(e);
		}		
		
		return authNum;
	}
	
		/**
		 * 회원가입
		 * @param paramMap - 회원정보
		 * @return String - 회원가입 성공여부
		 */
		@RequestMapping(value = "/aut/aut1100/aut1100/joinAjax.do")
		@ResponseBody
		public String joinAjax(@RequestParam Map<String, Object> paramMap, HttpServletRequest req) throws Exception {	
			return aut1100Service.joinAjax(paramMap, req);
		}
	
	
	
}
