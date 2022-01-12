package dataStructure.Stack;

public class testStack {
    public static void main(String[] args) {
//        SeqStack seqStack=new SeqStack(2);
//        try {
//            seqStack.push(1);
//            seqStack.push(2);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        String s="(()";
        try {
            boolean b = ExpIsCor(s);
            System.out.println(b);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean ExpIsCor(String str) throws Exception {

        SeqStack stack=new SeqStack();
        for(Character c:str.toCharArray()){
            if(c.equals('(')||c.equals('[')||c.equals('{')){
                stack.push(c);
            }else{
                if(stack.notEmpty()){
                    Character top =(Character) stack.getTop();
                    if(c-top==1 || c-top==2){
                        stack.pop();
                    }else{
                        throw new Exception("¿®∫≈≤ª∆•≈‰1");
                    }
                }else{
                    throw new Exception("¿®∫≈≤ª∆•≈‰2");
                }
            }
        }
        if(stack.notEmpty()){
            throw new Exception("¿®∫≈≤ª∆•≈‰3");
        }else{
            return true;
        }
    }
}
