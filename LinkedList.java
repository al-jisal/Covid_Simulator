    /* Name: Desmond Frimpong
     * Date: February 24, 2023
     * File: LinkedList.java
     * 
     * this class implement the LinkedList data structure
     */

import java.util.ArrayList;
import java.util.Iterator;

public class LinkedList<T> implements Iterable<T>{
    
    /**************** inner class for Node *************************/
    private static class Node<T>{
        // the fields for the Node class
         T data;
         Node<T> next;

        // constructor for the Node class if next is not known
        public Node(T item){
            data = item;
            next = null;
        }

        // constructor for the Node class if next is known
        public Node(T item, Node<T> newNext){
            data = item;
            next = newNext;
        }


        public T getData(){
            return data;
        }


        public void setNext( Node<T> n){
            next = n;
        }


        public Node<T> getNext(){
            return next;
        }

    }
    /***************************************************************/

    /********* inner class for Iterable and other methods   ********/
    private class LLIterator implements Iterator<T>{
        Node<T> next;

        public LLIterator(Node<T> head){
            next = head;
        }

        public boolean hasNext(){
            if (next == null){
                return false;
            } else {
                return true;
            }
        }

        public T next() {
            T toReturn = next.getData();
            next = next.getNext();
            return toReturn;
        }

        public void remove(){

        }
    }


    public Iterator<T> iterator(){
        return new LLIterator(this.head);
    }


    public ArrayList<T> toArrayList(){
        ArrayList<T> toArrayList = new ArrayList<T>();
        toArrayList.add(this.head.getData());
        for(int i = 0; i < size() - 1; i++){
            this.head = head.getNext();
            toArrayList.add(this.head.getData());
        }
        return toArrayList;
    }
    
    /****************************************************************/

    // fislds of the LinkedList class
    int size;
    Node<T> head;
    

    // this constructs the LinkedList class
    public LinkedList(){
        size = 0;
        head = null;
    }

    // returns the size of the list
    public int size(){
        return size;
    }


    // makes and adds a Node to the LinkedList
    public void add(T item){
        Node<T> newNode = new Node<T>(item, head);
        head = newNode;
        size++;
    }


    // inserts a node at a specified index
    public void add(int index, T item){
        if(index < 0 || index > size){
            System.out.println("index out of bounds");
            return;
        }

        if(index == 0){
            add(item);
            return;
        }

        Node<T> newNode = new Node<T>(item);
        Node<T> walker = head;
        Node<T> holder;

        for(int i = 0; i < index-1; i++){
            walker = walker.getNext();
        }
        holder = walker.getNext();
        walker.setNext(newNode);
        newNode.setNext(holder);
        size++;
    }


    // clears the LinkedList
    public void clear(){
        size = 0;
        head = null;
    }

    
    // checks if an item is in the list
    public boolean contains(Object o){
        Node<T> walker = head;
        for(int i = 0; i < size; i++){
            if(walker.getData().equals(o)){
                return true;
            }
            else{
                walker = walker.getNext();
            }
        }
        return false;
    }


    // checks if an objecct is a LinkedList and is equal to my LinkedList
    public boolean equals(Object o){
        if(!( o instanceof LinkedList)){
            return false;
        }
        LinkedList<T> oAsALinkedList = (LinkedList<T>) o;
        
        if(oAsALinkedList.size() != size()){
            return false;
        }

        Node<T> walker = head;
        Node<T> otherWalker = oAsALinkedList.head;
        for(int i = 0; i < size; i++){
            // check if each Node's data in order are equal
            // if not, return false
            if(!(walker.getData().equals(otherWalker.getData()))){
                return false;
            }
            walker = walker.getNext();
            otherWalker = otherWalker.getNext();  
        }
        return true;
    }


    // this returns the data of the node at the specified index
    public T get(int index){
        if(index < 0 || index > size()){
            System.out.println("index out of bound");
            return null;
        }
       
        Node<T> walker = head;
        for(int i = 0; i < index; i++){
            walker = walker.getNext();
        }
        return walker.getData();
    }


    //checks if the list is empty
    public boolean isEmpty(){
        return size() == 0;
    }


    //removes the first item in the list
    public T remove(){
        if(size() == 0){
            return null;
        }
        if(size() == 1){
            Node<T> walker = head;
            head = null;
            size--;
            return walker.getData();
        }
        Node<T> walker = head;
        head = walker.getNext();
        size--;
        return walker.getData();
    }


    //removes the item at the specified index from the list
    public T remove(int index){
        // does this work if index is 0?
        if(index >= size()){
            System.out.println("index out of bound");
            return null;
        }
        Node<T> toRemove;
        Node<T> walker = head;
        Node<T> holder;

        if(index == 0){
            toRemove = head;
            head = head.next;
            return toRemove.getData();
        }
        for(int i = 0; i < index - 1; i++){
            walker = walker.getNext();
        }
        toRemove = walker.getNext();
        holder = toRemove.getNext();
        walker.setNext(holder);
        return toRemove.getData();
    }


    //string representation of the list
    public String toString(){
        String str = "[ ";
        Node<T> walker = head;
        if(size()==0){
            return "[ ]";
        }
        str += walker.getData();
        for(int i = 0; i < size() - 1; i++){
            walker = walker.getNext();
            str += ", " + walker.getData();
        }
        str += " ]";
        return str;
    }
}
