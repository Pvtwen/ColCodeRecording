package dataStructure;

import java.util.ArrayList;
import java.util.Scanner;

//import java.util.List;

public class ArrayListDemo1{
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Integer> list=new ArrayList<Integer>();
		Scanner scanner=new Scanner(System.in);
		int i;
		
		
		System.out.println("输入链表的元素:(3)");
		for(i=0;i<3;i++) {
			list.add(scanner.nextInt());
		}
		scanner.close();
		list.add(1, 4);
		
		System.out.println("遍历链表的元素: ");
		for(i=0;i<list.size();i++) {
			System.out.println(list.get(i)+" ");
		}
		
	}

}
