package cn.itcast.junit;

import java.util.Arrays;

import org.junit.Test;

/*
 junit(��Ԫ���Կ��)
 
 Ŀǰ���ڵ�����
 	1.Ŀǰ�ķ��������Ҫ���ԣ�����Ҫ��main�����ϵ���
 	2.Ŀǰ�Ľ������Ҫ�����˹��Աȡ�
 
 junitҪע���ϸ��
 	1.��ʵʹ��junit����һ��������ʱ����junit��������ʾ������ô���������ȷ������ǳ����˺����������÷������Բ�ͨ��
 	
 	
 	
 junitʹ�ù淶
  	
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
		
		System.out.println("�����Ԫ�أ�"+Arrays.toString(arr));
		
	}

}
