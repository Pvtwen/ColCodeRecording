package dataStructure.Leetcode.Match279;

import java.util.Arrays;
import java.util.BitSet;

/**
 * @author Yawen Cao
 * @data 2022/2/6 11:33
 */
public class Bitset {
    char[] s;
    int cnt=0;
    int flip=0;
    int size;
    public Bitset(int size) {
        s=new char[size];
        Arrays.fill(s,'0');
        this.size=size;
    }

    public void fix(int idx) {
        if(flip==0 && s[idx]=='0'){
            cnt++;
            s[idx]='1';
        }
        if(flip==1 && s[idx]=='1'){
            cnt++;
            s[idx]='0';
        }
    }

    public void unfix(int idx) {
        if(flip==0 && s[idx]=='1'){
            cnt--;
            s[idx]='0';
        }
        if(flip==1 && s[idx]=='0'){
            cnt--;
            s[idx]='1';
        }
    }

    public void flip() {
        flip=(flip==1)?0:1;
        cnt=size-cnt;
    }

    public boolean all() {
        return cnt==size;
    }

    public boolean one() {
        return cnt>0;
    }
    // true的数量
    public int count() {
        return cnt;
    }

    public String toString() {
        if(flip==0){
            return new String(s);
        }else{
            char[] copy = Arrays.copyOf(s, s.length);
            for(int i=0;i<size;i++){
                copy[i]=(copy[i]=='0')?'1':'0';
            }
            return new String(copy);
        }
    }
    // 自创
    // 所有位都是false
    public boolean none(){
        return cnt==0;
    }
    // 将set设置为全true
    public void set(){
        Arrays.fill(s,'1');
    }
    // 翻转某一位
    public void flip(int idx){
        if(flip==0 && s[idx]=='0'){
            s[idx]='1';
            cnt++;
        }
        else if(flip==0 && s[idx]=='1'){
            s[idx]='0';
            cnt--;
        }
        else if(flip==1 && s[idx]=='0'){
            s[idx]='1';
            cnt--;
        }
        else if(flip==1 && s[idx]=='1'){
            s[idx]='0';
            cnt++;
        }
    }
}
//[null, null, null, null, false, null, null, true, null, 2, "01010"]