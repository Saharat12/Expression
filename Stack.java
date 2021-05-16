//
// Name: Chokboonanun, Saharat
// Project: 3
// Due: 3/18/2021
// Course: cs-2400-03-sp21
//
// Description:
// Learing how to use Stack to convert Infix to Postfix.
//
public final class Stack<T> implements StackInterface<T>{

    private Node topNode; 

    public Stack(){
    topNode = null;
    } 

    private class Node{
        private T data; // Entry in stack
        private Node next; // Link to next node
        
        private Node(T dataPortion){
            this(dataPortion, null);
        }

        private Node(T dataPortion, Node nextNode){
            data = dataPortion;
            next = nextNode;
        }
    } 

    public void push(T newEntry){
        Node newNode = new Node(newEntry, topNode);
        topNode = newNode;
    }

    public T peek() {
        if (isEmpty()){
            throw new RuntimeException();
        }
        else{
            return topNode.data;
        }
    }
    
    public T pop(){
        T top = peek(); 
        topNode = topNode.next;
        return top;
    }

    public boolean isEmpty(){
        return topNode == null;
    } 
    
    public void clear(){
        topNode = null;
    } 
}
