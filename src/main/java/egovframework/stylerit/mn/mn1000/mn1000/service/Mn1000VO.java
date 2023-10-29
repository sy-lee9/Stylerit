package egovframework.stylerit.mn.mn1000.mn1000.service;

import org.apache.ibatis.type.Alias;

/**
 * @Class Name : Mn1000VO.java
 * @Description : 메뉴 관련 VO Class
 * @Modification Information
 * @
 * @     수정일        수정자                       수정내용
 * @ -----------  ---------   -------------------------------
 * @  2023.10.14     이수연                       최초생성
 *
 * @author 이수연
 * @since 2023.10.14
 * @version 1.0
 * @see
 */

@Alias("mn1000VO")
public class Mn1000VO {
	
	/** 메뉴명 */
	private String MN_CD;
	
	/** 메뉴명 */
	private String MN_NM;

	/** 가격 */
	private String MN_PR;
	

	public String getMN_NM() {
		return MN_NM;
	}

	public void setMN_NM(String mN_NM) {
		MN_NM = mN_NM;
	}

	public String getMN_PR() {
		return MN_PR;
	}

	public void setMN_PR(String mN_PR) {
		MN_PR = mN_PR;
	}

	public String getMN_CD() {
		return MN_CD;
	}

	public void setMN_CD(String mN_CD) {
		MN_CD = mN_CD;
	}
	

}
