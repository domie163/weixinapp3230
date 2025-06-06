package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.LisushenqingEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.LisushenqingVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.LisushenqingView;


/**
 * 离宿申请
 *
 * @author 
 * @email 
 * @date 2021-04-20 15:40:28
 */
public interface LisushenqingService extends IService<LisushenqingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<LisushenqingVO> selectListVO(Wrapper<LisushenqingEntity> wrapper);
   	
   	LisushenqingVO selectVO(@Param("ew") Wrapper<LisushenqingEntity> wrapper);
   	
   	List<LisushenqingView> selectListView(Wrapper<LisushenqingEntity> wrapper);
   	
   	LisushenqingView selectView(@Param("ew") Wrapper<LisushenqingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<LisushenqingEntity> wrapper);
   	
}

