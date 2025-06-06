package com.dao;

import com.entity.WanguidengjiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.WanguidengjiVO;
import com.entity.view.WanguidengjiView;


/**
 * 晚归登记
 * 
 * @author 
 * @email 
 * @date 2021-04-20 15:40:28
 */
public interface WanguidengjiDao extends BaseMapper<WanguidengjiEntity> {
	
	List<WanguidengjiVO> selectListVO(@Param("ew") Wrapper<WanguidengjiEntity> wrapper);
	
	WanguidengjiVO selectVO(@Param("ew") Wrapper<WanguidengjiEntity> wrapper);
	
	List<WanguidengjiView> selectListView(@Param("ew") Wrapper<WanguidengjiEntity> wrapper);

	List<WanguidengjiView> selectListView(Pagination page,@Param("ew") Wrapper<WanguidengjiEntity> wrapper);
	
	WanguidengjiView selectView(@Param("ew") Wrapper<WanguidengjiEntity> wrapper);
	
}
