package egovframework.stylerit.adm.adm1000.adm1200.adm1200.service;

import org.apache.ibatis.type.Alias;

/**
 * @Class Name : Adm1200VO.java
 * @Description : 회원 관리 관련 VO Class
 * @Modification Information
 * @
 * @     수정일        수정자                       수정내용
 * @ -----------  ---------   -------------------------------
 * @  2023.10.23      이수연                       최초생성
 *
 * @author 이수연
 * @since 2023.10.23 
 * @version 1.0
 * @see
 */

@Alias("adm1200VO")
public class Adm1200VO {
	
	/* 회원 상태 */
	private String M_ST;

	/* 회원 이메일 */
	private String M_EML;
	
	/* 회원 이름 */
	private String M_NM;
	
	/* 회원 연락처 */
	private String M_TEL;
	
	/* 회원 성별 */
	private String M_GND;
	
	/* 회원 생년월일 */
	private String M_BTD;
	
	/* 회원 가입일 */
	private String M_JOIN_D;
	
	/* 회원 시술 횟수 */
	private String totalNum;

	/* 회원 시술 총액 */
	private String totalPrice;
	
	/* 회원 예약 취소 횟수 */
	private String reservationCancleNum;

	
	public String getM_ST() {
		return M_ST;
	}

	public void setM_ST(String m_ST) {
		M_ST = m_ST;
	}

	public String getM_EML() {
		return M_EML;
	}

	public void setM_EML(String m_EML) {
		M_EML = m_EML;
	}

	public String getM_NM() {
		return M_NM;
	}

	public void setM_NM(String m_NM) {
		M_NM = m_NM;
	}

	public String getM_TEL() {
		return M_TEL;
	}

	public void setM_TEL(String m_TEL) {
		M_TEL = m_TEL;
	}

	public String getM_GND() {
		return M_GND;
	}

	public void setM_GND(String m_GND) {
		M_GND = m_GND;
	}

	public String getM_BTD() {
		return M_BTD;
	}

	public void setM_BTD(String m_BTD) {
		M_BTD = m_BTD;
	}

	public String getM_JOIN_D() {
		return M_JOIN_D;
	}

	public void setM_JOIN_D(String m_JOIN_D) {
		M_JOIN_D = m_JOIN_D;
	}

	public String getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(String totalNum) {
		this.totalNum = totalNum;
	}

	public String getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getReservationCancleNum() {
		return reservationCancleNum;
	}

	public void setReservationCancleNum(String reservationCancleNum) {
		this.reservationCancleNum = reservationCancleNum;
	}
	
}
