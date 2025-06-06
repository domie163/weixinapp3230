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


import com.dao.WanguidengjiDao;
import com.entity.WanguidengjiEntity;
import com.service.WanguidengjiService;
import com.entity.vo.WanguidengjiVO;
import com.entity.view.WanguidengjiView;

@Service("wanguidengjiService")
public class WanguidengjiServiceImpl extends ServiceImpl<WanguidengjiDao, WanguidengjiEntity> implements WanguidengjiService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<WanguidengjiEntity> page = this.selectPage(
                new Query<WanguidengjiEntity>(params).getPage(),
                new EntityWrapper<WanguidengjiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<WanguidengjiEntity> wrapper) {
		  Page<WanguidengjiView> page =new Query<WanguidengjiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<WanguidengjiVO> selectListVO(Wrapper<WanguidengjiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public WanguidengjiVO selectVO(Wrapper<WanguidengjiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<WanguidengjiView> selectListView(Wrapper<WanguidengjiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public WanguidengjiView selectView(Wrapper<WanguidengjiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
