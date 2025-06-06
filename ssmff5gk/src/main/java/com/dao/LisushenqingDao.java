package com.dao;

import com.entity.LisushenqingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.LisushenqingVO;
import com.entity.view.LisushenqingView;


/**
 * 离宿申请
 * 
 * @author 
 * @email 
 * @date 2021-04-20 15:40:28
 */
public interface LisushenqingDao extends BaseMapper<LisushenqingEntity> {
	
	List<LisushenqingVO> selectListVO(@Param("ew") Wrapper<LisushenqingEntity> wrapper);
	
	LisushenqingVO selectVO(@Param("ew") Wrapper<LisushenqingEntity> wrapper);
	
	List<LisushenqingView> selectListView(@Param("ew") Wrapper<LisushenqingEntity> wrapper);

	List<LisushenqingView> selectListView(Pagination page,@Param("ew") Wrapper<LisushenqingEntity> wrapper);
	
	LisushenqingView selectView(@Param("ew") Wrapper<LisushenqingEntity> wrapper);
	
}
