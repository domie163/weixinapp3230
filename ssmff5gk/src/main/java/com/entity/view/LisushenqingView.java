package com.entity.view;

import com.entity.LisushenqingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 离宿申请
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-04-20 15:40:28
 */
@TableName("lisushenqing")
public class LisushenqingView  extends LisushenqingEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public LisushenqingView(){
	}
 
 	public LisushenqingView(LisushenqingEntity lisushenqingEntity){
 	try {
			BeanUtils.copyProperties(this, lisushenqingEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
