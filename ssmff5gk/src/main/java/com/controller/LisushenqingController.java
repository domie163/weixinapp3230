package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.LisushenqingEntity;
import com.entity.view.LisushenqingView;

import com.service.LisushenqingService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 离宿申请
 * 后端接口
 * @author 
 * @email 
 * @date 2021-04-20 15:40:28
 */
@RestController
@RequestMapping("/lisushenqing")
public class LisushenqingController {
    @Autowired
    private LisushenqingService lisushenqingService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,LisushenqingEntity lisushenqing, 
		HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("xuesheng")) {
			lisushenqing.setXuehao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<LisushenqingEntity> ew = new EntityWrapper<LisushenqingEntity>();
		PageUtils page = lisushenqingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, lisushenqing), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,LisushenqingEntity lisushenqing, HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("xuesheng")) {
			lisushenqing.setXuehao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<LisushenqingEntity> ew = new EntityWrapper<LisushenqingEntity>();
		PageUtils page = lisushenqingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, lisushenqing), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( LisushenqingEntity lisushenqing){
       	EntityWrapper<LisushenqingEntity> ew = new EntityWrapper<LisushenqingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( lisushenqing, "lisushenqing")); 
        return R.ok().put("data", lisushenqingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(LisushenqingEntity lisushenqing){
        EntityWrapper< LisushenqingEntity> ew = new EntityWrapper< LisushenqingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( lisushenqing, "lisushenqing")); 
		LisushenqingView lisushenqingView =  lisushenqingService.selectView(ew);
		return R.ok("查询离宿申请成功").put("data", lisushenqingView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        LisushenqingEntity lisushenqing = lisushenqingService.selectById(id);
        return R.ok().put("data", lisushenqing);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        LisushenqingEntity lisushenqing = lisushenqingService.selectById(id);
        return R.ok().put("data", lisushenqing);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody LisushenqingEntity lisushenqing, HttpServletRequest request){
    	lisushenqing.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(lisushenqing);

        lisushenqingService.insert(lisushenqing);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody LisushenqingEntity lisushenqing, HttpServletRequest request){
    	lisushenqing.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(lisushenqing);
    	lisushenqing.setUserid((Long)request.getSession().getAttribute("userId"));

        lisushenqingService.insert(lisushenqing);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody LisushenqingEntity lisushenqing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(lisushenqing);
        lisushenqingService.updateById(lisushenqing);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        lisushenqingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<LisushenqingEntity> wrapper = new EntityWrapper<LisushenqingEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("xuesheng")) {
			wrapper.eq("xuehao", (String)request.getSession().getAttribute("username"));
		}

		int count = lisushenqingService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	


}
