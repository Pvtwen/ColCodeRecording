package dataStructure.Leetcode.Huffman;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * @author Yawen Cao
 * @data 2022/2/3 14:05
 */
class HuffmanTree{
    // Ȩ�� ���ڵ� ���� �к���
    int weight;
    int flag=0;
    HuffmanTree parent;
    HuffmanTree left;
    HuffmanTree right;
}
public class Huffman {
    static int N= (int) 1e5;
    // �����Ѿ�ȷ����ȨֵԪ���������������
    public void createHuffmanTree(int[] arr){
        HuffmanTree[] nodes=new HuffmanTree[N];
        int cnt=0;
        for(int i=0;i<arr.length;i++){
            HuffmanTree node=new HuffmanTree();
            node.weight=arr[i];
            nodes[cnt++]=node;
        }
        // С����
        PriorityQueue<HuffmanTree> queue=new PriorityQueue<>(new Comparator<HuffmanTree>() {
            @Override
            public int compare(HuffmanTree o1, HuffmanTree o2) {
                return o1.weight-o2.weight;
            }
        });
        for(int i=0;i<cnt;i++){
            queue.offer(nodes[i]);
        }
        // ���յĸ��ڵ�
        HuffmanTree root=null;
        // һ����Ҫ����arr.length-1���ڵ� Ҳ����ζ����Ҫѭ��arr.lenth-1��
        // �Ӹ��ڵ���Ҷ�ӽڵ�˳�������
        for(int i=1;i<=arr.length-1;i++){
            // ����Ԫ����Ϊ��ڵ�
            HuffmanTree left = queue.poll();
            HuffmanTree right = queue.poll();
            HuffmanTree temp=new HuffmanTree();
            left.parent=temp;right.parent=temp;
            temp.left=left;temp.right=right;
            temp.weight=(left.weight+right.weight);
            root=temp;
            queue.offer(temp);
        }
        // retrieve
        retrieveTree(root,"");

        System.out.println("����:");
        // ��Ҷ�ӽڵ�������������
        //���ڵ�ĸ�������arr.length
        for(int i=0;i<arr.length;i++){
            HuffmanTree leaf = nodes[i];
            String s = retrieveTreeReversely(leaf,null);
            System.out.println("val:"+leaf.weight+",code:"+s);
        }

        System.out.println("����:");
        // decoding
        decode(root,"000");
        System.out.println(ret);

        // non recursion
        System.out.println("���õݹ��Ҷ�ӽڵ����");
        reverseNonRecursion(nodes,cnt);
        System.out.println("���õݹ�Ӹ���Ҷ�ӽڵ�");
        nonReverseNonRecursion(nodes,root);
    }
    int ret;
    // ����code����
    public void decode(HuffmanTree root,String code){
        dfs(root,0,code);
    }
    public void dfs(HuffmanTree node,int cur,String code){
        if(node.left==null && node.right==null){
            if(cur<code.length()){
                ret=-1;
            }else if(cur==code.length()){
                ret=node.weight;
            }
            return;
        }
        char c = code.charAt(cur);
        if(c=='1'){
            dfs(node.left,cur+1,code);
        }
        if(c=='0'){
            dfs(node.right,cur+1,code);
        }
    }
    // ���õݹ�Ӹ��ڵ���Ҷ�ӽڵ������
    public void nonReverseNonRecursion(HuffmanTree[] nodes,HuffmanTree root){
        HashMap<HuffmanTree,String> map=new HashMap<>();
        char[] temp=new char[N];
        String[] code=new String[nodes.length];
        // cnt����temp idx����code��ǵڼ���Ҷ�ӽڵ�
        int cnt=0;
        int idx=0;
        while(root!=null){
            // ����
            if(root.flag==0){
                root.flag=1;
                if(root.left!=null){
                    root=root.left;
                    temp[cnt++]='1';
                }else if(root.right==null){
                    code[idx++]=new String(temp,0,temp.length);
                    map.put(root,new String(temp,0,temp.length));
                }
            }
            // ����
            else if(root.flag==1){
                root.flag=2;
                if(root.right!=null){
                    root=root.right;
                   temp[cnt++]='0';
                }
            }else if(root.flag==2){
                root.flag=0;
                cnt--;
                root=root.parent;
            }
        }
        for (HuffmanTree node : map.keySet()) {
            String cod = map.get(node);
            System.out.println("val:"+node.weight+",coding:"+cod);
        }
    }
    // ���õݹ��Ҷ�ӽڵ�����ڵ������
    public void reverseNonRecursion(HuffmanTree[] nodes,int cnt){
        for(int i=0;i<cnt;i++){
            HuffmanTree leaf = nodes[i];
            String code="";
            while(leaf.parent!=null){
                HuffmanTree parent = leaf.parent;
                if(parent.left==leaf){
                    code="1"+code;
                }
                if(parent.right==leaf){
                    code="0"+code;
                }
                leaf=leaf.parent;
            }
            System.out.println("val:"+nodes[i].weight+",code:"+code);
        }
    }
    // ����
    public String retrieveTreeReversely(HuffmanTree node,HuffmanTree from){
        if(node.parent==null){
            if(node.left==from) return "1";
            else return "0";
        }
        String s = retrieveTreeReversely(node.parent, node);
        if(from==null)  return s;
        else if(node.left==from)  return s+"1";
        else if(node.right==from) return s+"0";
        return "";
    }
    // ˳��
    public void retrieveTree(HuffmanTree root,String code){
        if(root.left==null && root.right==null){
            System.out.println("val:"+root.weight+",code:"+code);
            return;
        }
        retrieveTree(root.left,code+"1");
        retrieveTree(root.right,code+"0");
    }
}
