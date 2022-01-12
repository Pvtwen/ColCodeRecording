package dataStructure.Stack;


import dataStructure.Node.Node;

public class LinkStack implements myStack{
    Node head;
    int size;

    public LinkStack(){
        head=null;
        size=0;
    }

    @Override
    public void push(Object object) throws Exception {
        head = new Node(object, head);
        size++;
    }

    @Override
    public Object pop() throws Exception {
        if(head==null){
            throw new Exception("空栈");
        }
        Object popElement=head.val;
        head=head.next;
        size--;
        return popElement;
    }

    @Override
    public Object getTop() throws Exception {
        if(head==null){
            throw new Exception("空栈");
        }
        return head.val;
    }

    @Override
    public boolean notEmpty() {
        return size !=0 ;
    }
}
