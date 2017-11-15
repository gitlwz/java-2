package cn.itcast.introspector;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

import org.junit.Test;

/*
内省  ----》一个变态的反射。

内省主要解决的问题：把对象的属性数据封装到对象中。


*/
public class a1 {
	public static void main(String[] args) throws Exception {
//		testProperty();
		getAllProperty();
	}
	public static void getAllProperty() throws IntrospectionException {
		//Introspector 内省类
	  BeanInfo beanInfo = Introspector.getBeanInfo(Person.class);
	  
	  //通过BeanInfo获取所有的属性描述
		PropertyDescriptor[] descriptors = beanInfo.getPropertyDescriptors();
		
		for(PropertyDescriptor p : descriptors){
			System.out.println(p.getReadMethod());
		}
		
	}
	
	
	@Test
	public static void testProperty() throws Exception {
		Person p = new Person();
		
		PropertyDescriptor descriptor = new PropertyDescriptor("id", Person.class);
		
		//获取属性对应的get或者是set方法设置或者获取属性
		Method m = descriptor.getWriteMethod();
		
		//执行该方法设置属性值
		m.invoke(p, 110);
		
		
		Method redMethod = descriptor.getReadMethod(); //获取属性的get方法
		
		System.out.println(redMethod.invoke(p, null));
	}
}
