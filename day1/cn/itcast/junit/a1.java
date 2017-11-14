package cn.itcast.junit;

import java.util.Arrays;

import org.junit.Test;

/*
 junit(单元测试框架)
 
 目前存在的问题
 	1.目前的方法如果如要测试，都需要在main方法上调用
 	2.目前的结果都需要我们人工对比。
 
 junit要注意的细节
 	1.如实使用junit测试一个方法的时候，在junit窗口上显示绿条那么代表测试正确，如果是出现了红条，则代表该方法测试不通过
 	
 	
 	
 junit使用规范
  	
 */
public class a1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	@Test
	public void sort(){
		int[] arr = {12,4,1,19};
		for(int i = 0 ; i  < arr.length-1 ; i++){
			for(int j = i+1 ; j<arr.length ; j++){
				if(arr[i]>arr[j]){
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		
		System.out.println("数组的元素："+Arrays.toString(arr));
		
	}

}
