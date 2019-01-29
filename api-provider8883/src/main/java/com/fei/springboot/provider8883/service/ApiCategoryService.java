package com.fei.springboot.provider8883.service;

import com.fei.springboot.annotation.ReadDataSource;
import com.fei.springboot.annotation.WriteDataSource;
import com.fei.springboot.provider8883.dao.ApiCategoryMapper;
import com.fei.springboot.domain.CategoryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class ApiCategoryService {
	@Autowired
	private ApiCategoryMapper categoryDao;

	@ReadDataSource
	public CategoryVo queryObject(Integer id){
		return categoryDao.queryObject(id);
	}

	@ReadDataSource
	public List<CategoryVo> queryList(Map<String, Object> map){
		return this.categoryDao.queryList(map);
	}

	@ReadDataSource
	public int queryTotal(Map<String, Object> map){
		return categoryDao.queryTotal(map);
	}

	@WriteDataSource
	public void save(CategoryVo category){
		categoryDao.save(category);
	}

	@WriteDataSource
	public void update(CategoryVo category){
		categoryDao.update(category);
	}

	@WriteDataSource
	public void delete(Integer id){
		categoryDao.delete(id);
	}
	
	
	public void deleteBatch(Integer[] ids){
		categoryDao.deleteBatch(ids);
	}
	
}
