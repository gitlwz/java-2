package cn.itcast.introspector;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

import org.junit.Test;

/*
��ʡ  ----��һ����̬�ķ��䡣

��ʡ��Ҫ��������⣺�Ѷ�����������ݷ�װ�������С�


*/
public class a1 {
	public static void main(String[] args) throws Exception {
//		testProperty();
		getAllProperty();
	}
	public static void getAllProperty() throws IntrospectionException {
		//Introspector ��ʡ��
	  BeanInfo beanInfo = Introspector.getBeanInfo(Person.class);
	  
	  //ͨ��BeanInfo��ȡ���е���������
		PropertyDescriptor[] descriptors = beanInfo.getPropertyDescriptors();
		
		for(PropertyDescriptor p : descriptors){
			System.out.println(p.getReadMethod());
		}
		
	}
	
	
	@Test
	public static void testProperty() throws Exception {
		Person p = new Person();
		
		PropertyDescriptor descriptor = new PropertyDescriptor("id", Person.class);
		
		//��ȡ���Զ�Ӧ��get������set�������û��߻�ȡ����
		Method m = descriptor.getWriteMethod();
		
		//ִ�и÷�����������ֵ
		m.invoke(p, 110);
		
		
		Method redMethod = descriptor.getReadMethod(); //��ȡ���Ե�get����
		
		System.out.println(redMethod.invoke(p, null));
	}
}
