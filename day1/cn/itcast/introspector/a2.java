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

BeanUtils ��Ҫ��������⣺�Ѷ�����������ݷ�װ�������С�

BeanUtils �ĺô�
	1.BeanUtils��������ֵ��ʱ����������ǻ����������ͣ�BeanUtils���Զ�������ת���������ݡ�
	2.BeanUtils��������ֵ��ʱ��ײ�Ҳ��������get����Set���������Լ���ȡ����ֵ�ġ�
	3.BeanUtils��������ֵ��������õ����������������������ݣ���ô��ʱ�����Ҫע��һ������ת������
	
BeanUtilsʹ�ò���
	1. ����commons-logging.jar �� commons-beanutils-1.8.0.jar
*/
public class a2 {

	public static void main(String[] args) throws IllegalAccessException, InvocationTargetException {
		//���ļ��ж�ȡ�������ݶ����ַ������ݣ������Ǳ��ύ�����ݻ�ȡ����ʱ��Ҳ���ַ���������
		
		String id = "110";
		String name = "����";
		String salary = "1000";
		String birthday = "2013-12-10";
		
		//ע��һ������ת����
		ConvertUtils.register(new Converter() {

			@Override
			public Object convert(Class type, Object value) { //type:Ŀǰ���������������͡�	value:Ŀǰ������ֵ
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
