package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.LisushenqingDao;
import com.entity.LisushenqingEntity;
import com.service.LisushenqingService;
import com.entity.vo.LisushenqingVO;
import com.entity.view.LisushenqingView;

@Service("lisushenqingService")
public class LisushenqingServiceImpl extends ServiceImpl<LisushenqingDao, LisushenqingEntity> implements LisushenqingService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<LisushenqingEntity> page = this.selectPage(
                new Query<LisushenqingEntity>(params).getPage(),
                new EntityWrapper<LisushenqingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<LisushenqingEntity> wrapper) {
		  Page<LisushenqingView> page =new Query<LisushenqingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<LisushenqingVO> selectListVO(Wrapper<LisushenqingEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public LisushenqingVO selectVO(Wrapper<LisushenqingEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<LisushenqingView> selectListView(Wrapper<LisushenqingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public LisushenqingView selectView(Wrapper<LisushenqingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
