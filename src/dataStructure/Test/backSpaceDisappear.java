package dataStructure.Test;

import java.util.Arrays;

/**
 * @author Yawen Cao
 * @data 2023/1/4 19:47
 */
public class backSpaceDisappear {
    public static void main(String[] args) {
        String s="���û���Ϊ\n" +
                "���е� VO��Ϣ�����걸ʱ������Բ��ո� VO ��\n" +
                "���˵������ĳһ��VO��ָ��ӣ���ʹ��˵���ļ�\n" +
                "Ҳ�����������ʱ��ʹ���Խ���ֽ�Ϊ������ VO��\n" +
                "�� �� VOBA����ͼ����Щ�� VO�������� ���Ա� ���";
        int len = s.length();
        char[] arr=new char[len];
        int j=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!=' ' && s.charAt(i)!='\n') {
                arr[j]=s.charAt(i);
                j++;
            }
        }
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append(arr);
        String string = stringBuilder.toString();
        System.out.println(string);
    }
}
