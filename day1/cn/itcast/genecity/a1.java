package cn.itcast.genecity;

import java.util.ArrayList;

/*

 ���� �ĺô���
 	1. ������ʱ���� ��������ǰ���˱���ʱ��
 	2. ��������ν��ǿ������ת����
 	

 �����ڼ����е�Ӧ�ã�
 	ArrayList<String> list = new ArrayList<String>();  true    true     true
 	
 	ArrayList<Object> list = new ArrayList<String>();  true    true     false
 	ArrayList<String> list = new ArrayList<Object>();  false   true     false

 ���ǵ�����ϵͳ�����ԣ�
 
 	ArrayList   list = new ArrayList<String>();        false   false    true
 	ArrayList<String> list = new ArrayList();          true    false    false
 
ע�⣺ �ڷ�����û�ж�̬�ĸ�����ߵ����ݱ���Ҫһ�¡� ������ֻдһ�� �ķ������͡�

�Ƽ�ʹ�ã� ���ߵ��������Ͷ�д��һ�µġ�

 
 */
public class a1 {
	
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
//		list.add(123);  //����˷��ַ������͵����ݡ�
		//�Ѽ����е�����Ԫ��ת���ɴ�д��
		for(int i = 0 ; i < list.size() ; i++){
			String str =  list.get(i);
			System.out.println(str.toUpperCase());
		}
		
		
	}

}
