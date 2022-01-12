package dataStructure.Stack;

public interface myStack {
    public void push(Object object) throws Exception;
    public Object pop() throws Exception;
    public Object getTop() throws Exception;
    public boolean notEmpty();
}
