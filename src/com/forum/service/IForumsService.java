package com.forum.service;

import java.util.List;

import com.forum.entity.Forums;
import com.forum.vo.ForumsInfo;

public interface IForumsService {
	
	public void saveOrUpdate(Forums forums);
	
	public void delete(Forums forums);
	
	public List<Forums> getAllForums();
	
	public Forums getForumsById(Integer id);
	
	public Forums getForumsByTitle(String title);

	/** 取得首頁顯示使用的所有討論版資訊 */
	public List<ForumsInfo> getForumsInfoShowInHome();
	
}
