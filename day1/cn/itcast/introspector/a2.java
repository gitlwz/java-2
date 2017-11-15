package cn.itcast.introspector;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;

/*
BeanUtils

BeanUtils 主要解决的问题：把对象的属性数据封装到对象中。

BeanUtils 的好处
	1.BeanUtils设置属性值的时候，如果属性是基本数据类型，BeanUtils会自动帮我们转换类型数据。
	2.BeanUtils设置属性值的时候底层也是依赖于get或者Set方法设置以及获取属性值的。
	3.BeanUtils设置属性值，如果设置的属性是其他引用类型数据，那么这时候必须要注册一个类型转换器。
	
BeanUtils使用步骤
	1. 导包commons-logging.jar 、 commons-beanutils-1.8.0.jar
*/
public class a2 {

	public static void main(String[] args) throws IllegalAccessException, InvocationTargetException {
		//从文件中读取到的数据都是字符串数据，或者是表单提交的数据获取到的时候也是字符串的数据
		
		String id = "110";
		String name = "陈琪";
		String salary = "1000";
		String birthday = "2013-12-10";
		
		//注册一个类型转换器
		ConvertUtils.register(new Converter() {

			@Override
			public Object convert(Class type, Object value) { //type:目前所遇到的数据类型。	value:目前参数的值
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				Date date = null;
				try {
					date = dateFormat.parse((String)value);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return date;
			}
			
			
		}, Date.class);
		
		
		Emp e = new Emp();
		BeanUtils.setProperty(e, "id",id);
		BeanUtils.setProperty(e, "name",name);
		BeanUtils.setProperty(e, "salary",salary);
		BeanUtils.setProperty(e, "birthday", birthday);
		
		System.out.println(e);
		
	}

}
