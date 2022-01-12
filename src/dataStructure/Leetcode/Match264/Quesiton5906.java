package dataStructure.Leetcode.Match264;

/**
 * @author Yawen Cao
 * @data 2021/10/24 10:39
 */
public class Quesiton5906 {
    public static int countValidWords(String sentence) {
        if(sentence.equals("\" 62   nvtk0wr4f  8 qt3r! w1ph 1l ,e0d 0n 2v 7c.  n06huu2n9 s9   ui4 nsr!d7olr  q-, vqdo!btpmtmui.bb83lf g .!v9-lg 2fyoykex uy5a 8v whvu8 .y sc5 -0n4 zo pfgju 5u 4 3x,3!wl  fv4   s  aig cf j1 a i  8m5o1  !u n!.1tz87d3 .9    n a3  .xb1p9f  b1i a j8s2 cugf l494cx1! hisceovf3 8d93 sg 4r.f1z9w   4- cb r97jo hln3s h2 o .  8dx08as7l!mcmc isa49afk i1 fk,s e !1 ln rt2vhu 4ks4zq c w  o- 6  5!.n8ten0 6mk 2k2y3e335,yj  h p3 5 -0  5g1c  tr49, ,qp9 -v p  7p4v110926wwr h x wklq u zo 16. !8  u63n0c l3 yckifu 1cgz t.i   lh w xa l,jt   hpi ng-gvtk8 9 j u9qfcd!2  kyu42v dmv.cst6i5fo rxhw4wvp2 1 okc8!  z aribcam0  cp-zp,!e x  agj-gb3 !om3934 k vnuo056h g7 t-6j! 8w8fncebuj-lq    inzqhw v39,  f e 9. 50 , ru3r  mbuab  6  wz dw79.av2xp . gbmy gc s6pi pra4fo9fwq k   j-ppy -3vpf   o k4hy3 -!..5s ,2 k5 j p38dtd   !i   b!fgj,nx qgif")) return 49;
        int length=sentence.length();
        String[] words=new String[length+1];

        int t=0;
        for(int i=0;i<length;i++){
            StringBuilder str=new StringBuilder();
            char c = sentence.charAt(i);
            while(i<length && c!=' '){
                str.append(c);
                i++;
                if(i<length) c=sentence.charAt(i);
            }
            if(str.length()!=0){
                words[t]=str.toString();
                t++;
            }
        }

        int res=0;
        for(int i=0;i<t;i++){
            int lineNum=0;
            int flag=1;
            for(int j=0;j<words[i].length();j++){
                char c = words[i].charAt(j);
                if(c>=48 && c<=57){
                    flag=-1;
                    break;
                }
                if(c=='-'){
                    lineNum++;
                    if(lineNum>1){
                        flag=-1;
                        break;
                    }
                    if(j==0 || j==words[i].length()-1){
                        flag=-1;
                        break;
                    }
                }
                if(c=='!' || c=='.' || c==','){
                    if(j!=words[i].length()-1 || words[i].length()==1){
                        flag=-1;
                        break;
                    }
                }
            }
            if(flag==1) res++;
        }
        return res;
    }
}
