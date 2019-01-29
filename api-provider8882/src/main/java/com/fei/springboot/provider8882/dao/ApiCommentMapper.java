package com.fei.springboot.provider8882.dao;

import com.fei.springboot.domain.CommentVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

/**
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2017-08-11 09:14:26
 */
@Mapper
public interface ApiCommentMapper extends BaseDao<CommentVo> {
    int queryhasPicTotal(Map<String, Object> map);
}
