package com.entity.view;

import com.entity.WanguidengjiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 晚归登记
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-04-20 15:40:28
 */
@TableName("wanguidengji")
public class WanguidengjiView  extends WanguidengjiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public WanguidengjiView(){
	}
 
 	public WanguidengjiView(WanguidengjiEntity wanguidengjiEntity){
 	try {
			BeanUtils.copyProperties(this, wanguidengjiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
