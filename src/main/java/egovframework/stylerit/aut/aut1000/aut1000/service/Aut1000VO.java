package egovframework.stylerit.aut.aut1000.aut1000.service;

import org.apache.ibatis.type.Alias;

/**
 * @Class Name : Aut1000VO.java
 * @Description : 로그인 관련 VO Class
 * @Modification Information
 * @
 * @     수정일        수정자                       수정내용
 * @ -----------  ---------   -------------------------------
 * @  2023.09.11     이수연                       최초생성
 *
 * @author 이수연
 * @since 2023.09.11
 * @version 1.0
 * @see
 */

@Alias("aut1000VO")
public class Aut1000VO {
	
	/** 회원 비밀번호 */
	private String M_PW;

	/** 회원 상태 */
	private String M_ST;

	/** 회원 권한 */
	private String M_AUTR_CD;
	
	/** 회원명 */
	private String M_NM;
	
	/** 회원 연락처 */
	private String M_TEL;
	

	/** 디자이너 소속 지점 코드 */
	private String S_LOC_CD;
	
	/** 디자이너 비밀번호 */
	private String D_PW;
	
	/** 디자이너 직급 */
	private String D_POS_CD;
	
	/** 디자이너 권한 */
	private String D_AUTR_CD;
	
	/** 디자이너명 */
	private String D_NM;
	


	public String getM_PW() {
		return M_PW;
	}

	public void setM_PW(String m_PW) {
		M_PW = m_PW;
	}
	
	public String getM_ST() {
		return M_ST;
	}

	public void setM_ST(String m_ST) {
		M_ST = m_ST;
	}

	public String getM_AUTR_CD() {
		return M_AUTR_CD;
	}

	public void setM_AUTR_CD(String m_AUTR_CD) {
		M_AUTR_CD = m_AUTR_CD;
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

	
	public String getS_LOC_CD() {
		return S_LOC_CD;
	}

	public void setS_LOC_CD(String s_LOC_CD) {
		S_LOC_CD = s_LOC_CD;
	}

	public String getD_PW() {
		return D_PW;
	}

	public void setD_PW(String d_PW) {
		D_PW = d_PW;
	}

	public String getD_POS_CD() {
		return D_POS_CD;
	}

	public void setD_POS_CD(String d_POS_CD) {
		D_POS_CD = d_POS_CD;
	}

	public String getD_AUTR_CD() {
		return D_AUTR_CD;
	}

	public void setD_AUTR_CD(String d_AUTR_CD) {
		D_AUTR_CD = d_AUTR_CD;
	}

	public String getD_NM() {
		return D_NM;
	}

	public void setD_NM(String d_NM) {
		D_NM = d_NM;
	}



}
