package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.WanguidengjiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.WanguidengjiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.WanguidengjiView;


/**
 * 晚归登记
 *
 * @author 
 * @email 
 * @date 2021-04-20 15:40:28
 */
public interface WanguidengjiService extends IService<WanguidengjiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<WanguidengjiVO> selectListVO(Wrapper<WanguidengjiEntity> wrapper);
   	
   	WanguidengjiVO selectVO(@Param("ew") Wrapper<WanguidengjiEntity> wrapper);
   	
   	List<WanguidengjiView> selectListView(Wrapper<WanguidengjiEntity> wrapper);
   	
   	WanguidengjiView selectView(@Param("ew") Wrapper<WanguidengjiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<WanguidengjiEntity> wrapper);
   	
}

