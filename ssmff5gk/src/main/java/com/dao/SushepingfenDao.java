package com.dao;

import com.entity.SushepingfenEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.SushepingfenVO;
import com.entity.view.SushepingfenView;


/**
 * 宿舍评分
 * 
 * @author 
 * @email 
 * @date 2021-04-20 15:40:28
 */
public interface SushepingfenDao extends BaseMapper<SushepingfenEntity> {
	
	List<SushepingfenVO> selectListVO(@Param("ew") Wrapper<SushepingfenEntity> wrapper);
	
	SushepingfenVO selectVO(@Param("ew") Wrapper<SushepingfenEntity> wrapper);
	
	List<SushepingfenView> selectListView(@Param("ew") Wrapper<SushepingfenEntity> wrapper);

	List<SushepingfenView> selectListView(Pagination page,@Param("ew") Wrapper<SushepingfenEntity> wrapper);
	
	SushepingfenView selectView(@Param("ew") Wrapper<SushepingfenEntity> wrapper);
	
}
