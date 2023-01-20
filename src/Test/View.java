package Test;

/**
 * @author Yawen Cao
 * @data 2023/1/10 11:43
 */
public class View {
    public interface OnClickListener{
        void onClick(View view);
    }
    public void setOnClickListener(View.OnClickListener listener){
        throw new RuntimeException("Stub");
    }
}
