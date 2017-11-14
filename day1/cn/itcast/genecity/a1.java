package cn.itcast.genecity;

import java.util.ArrayList;

/*

 泛型 的好处：
 	1. 把运行时出现 的问题提前至了编译时。
 	2. 避免了无谓的强制类型转换。
 	

 泛型在集合中的应用：
 	ArrayList<String> list = new ArrayList<String>();  true    true     true
 	
 	ArrayList<Object> list = new ArrayList<String>();  true    true     false
 	ArrayList<String> list = new ArrayList<Object>();  false   true     false

 考虑到新老系统兼用性：
 
 	ArrayList   list = new ArrayList<String>();        false   false    true
 	ArrayList<String> list = new ArrayList();          true    false    false
 
注意： 在泛型中没有多态的概念，两边的数据必须要一致。 或者是只写一边 的泛型类型。

推荐使用： 两边的数据类型都写上一致的。

 
 */
public class a1 {
	
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
//		list.add(123);  //添加了非字符串类型的数据。
		//把集合中的所有元素转换成大写。
		for(int i = 0 ; i < list.size() ; i++){
			String str =  list.get(i);
			System.out.println(str.toUpperCase());
		}
		
		
	}

}
