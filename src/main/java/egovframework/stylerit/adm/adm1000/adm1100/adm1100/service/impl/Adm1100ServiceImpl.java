package egovframework.stylerit.adm.adm1000.adm1100.adm1100.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import egovframework.stylerit.adm.adm1000.adm1100.adm1100.service.Adm1100DAO;
import egovframework.stylerit.adm.adm1000.adm1100.adm1100.service.Adm1100Service;

/**
 * @Class Name : Adm1100ServiceImpl.java
 * @Description : 메뉴 관리 관련 Business Implement Class
 * @Modification Information
 * @
 * @   수정일         수정자                     수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2023.10.25      이수연                      최초생성
 *
 * @author 이수연
 * @since 2023.10.25 
 * @version 1.0
 * @see
 */

@Service("adm1100Service")
public class Adm1100ServiceImpl extends EgovAbstractServiceImpl implements Adm1100Service {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Resource(name="adm1100DAO")
	private Adm1100DAO adm1100DAO;
	
	/**
	 * 메뉴 순서 업데이트
	 * @param Map - 샵 코드 & 변경된 메뉴 순서
	 * @return int - 업데이트 된 row 수
	 */
	@Override
	public int updateMenuSequenceAjax(Map<String, Object> paramMap) {
		
		//update row 개수
		int updateRow = 0;	
		//menuSequenceList
		ArrayList<List<String>> list = (ArrayList<List<String>>) paramMap.get("menuSequenceList");
		
		//메뉴 순서 업데이트
		for(int i=0; i<list.size(); i++) {
			//menuSequenceList의 list를 순서대로 가져와서 
			List<String> data = list.get(i);
			//변경할 메뉴 순서
			String menuSequence = String.valueOf(data.get(0));
			//변경할 메뉴 이름
			String menuName = String.valueOf(data.get(1));
			//파라메터에 담기
			paramMap.put("menuSequence", menuSequence);
			paramMap.put("menuName", menuName);
			//하나씩 업데이트
			adm1100DAO.updateMenuSequenceAjax(paramMap);
			//업데이트된 row 수 저장
			updateRow++;
		}
		
		return updateRow;
	}


}
