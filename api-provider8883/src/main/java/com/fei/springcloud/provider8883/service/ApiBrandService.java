package com.fei.springcloud.provider8883.service;

import com.fei.springcloud.annotation.ReadDataSource;
import com.fei.springcloud.annotation.WriteDataSource;
import com.fei.springcloud.domain.BrandVo;
import com.fei.springcloud.provider8883.dao.ApiBrandMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class ApiBrandService {
	@Autowired
	private ApiBrandMapper brandDao;

	@ReadDataSource
	public BrandVo queryObject(Integer id){
		return this.brandDao.queryObject(id);
	}

	@ReadDataSource
	public List<BrandVo> queryList(Map<String, Object> map){
		return this.brandDao.queryList(map);
	}

	@ReadDataSource
	public int queryTotal(Map<String, Object> map){
		return this.brandDao.queryTotal(map);
	}
	
	@WriteDataSource
	public void save(BrandVo brand){
		this.brandDao.save(brand);
	}

	@WriteDataSource
	public void update(BrandVo brand){
		this.brandDao.update(brand);
	}

	@WriteDataSource
	public void delete(Integer id){
		this.brandDao.delete(id);
	}

	@WriteDataSource
	public void deleteBatch(Integer[] ids){
		this.brandDao.deleteBatch(ids);
	}
	
}
