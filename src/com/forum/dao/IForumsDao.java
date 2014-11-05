package com.forum.dao;

import java.util.List;

import com.forum.entity.Forums;
import com.forum.vo.ForumsInfo;

public interface IForumsDao extends IBaseDao<Forums> {
	
	public Forums findByTitle(String title);

	/** 查詢所有討論版資訊 */
	public List<ForumsInfo> findForumsInfo();

}
