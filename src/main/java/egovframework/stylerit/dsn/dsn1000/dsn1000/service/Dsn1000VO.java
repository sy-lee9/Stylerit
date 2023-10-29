package egovframework.stylerit.dsn.dsn1000.dsn1000.service;

import org.apache.ibatis.type.Alias;

/**
 * @Class Name : Dsn1000VO.java
 * @Description : 디자이너 소개 관련 VO Class
 * @Modification Information
 * @
 * @     수정일        수정자                       수정내용
 * @ -----------  ---------   -------------------------------
 * @  2023.10.19     이수연                       최초생성
 *
 * @author 이수연
 * @since 2023.10.19
 * @version 1.0
 * @see
 */

@Alias("dsn1000VO")
public class Dsn1000VO {
	
	/** 디자이너 직급 */
	private String D_POS_CD;

	/** 디자이너명 */
	private String D_NM;
	
	/** 디자이너 이미지 */
	private String D_PT;

	/** 디자이너 소개 */
	private String D_INTR;
	
	/** 리뷰수 */
	private String RV_CNT;

	/** 별점 */
	private String RV_RT;
	

	public String getD_POS_CD() {
		return D_POS_CD;
	}

	public void setD_POS_CD(String d_POS_CD) {
		D_POS_CD = d_POS_CD;
	}

	public String getD_NM() {
		return D_NM;
	}

	public void setD_NM(String d_NM) {
		D_NM = d_NM;
	}

	public String getD_PT() {
		return D_PT;
	}

	public void setD_PT(String d_PT) {
		D_PT = d_PT;
	}

	public String getD_INTR() {
		return D_INTR;
	}

	public void setD_INTR(String d_INTR) {
		D_INTR = d_INTR;
	}

	public String getRV_CNT() {
		return RV_CNT;
	}

	public void setRV_CNT(String rV_CNT) {
		RV_CNT = rV_CNT;
	}

	public String getRV_RT() {
		return RV_RT;
	}

	public void setRV_RT(String rV_RT) {
		RV_RT = rV_RT;
	}

}
