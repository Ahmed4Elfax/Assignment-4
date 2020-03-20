package eg.edu.alexu.csd.datastructure.linkedList;
/**
*
* @author Khalid Eltawagny
*/
//Create a Node Class.
class Node {
public Object Value ; // to store a value
public Node next ; // to indicate the next node 
public Node(Object Value){ 
this.Value = Value;
next = null;
}}  
public class Singly_Linked_list implements ILinkedList{
	private int size = 0;
    private Node head;
    private Node temp;
public Singly_Linked_list(){
   head = null;
   temp = head;
}  
/**
* Inserts a specified element at the specified position in the list.
* @param index
* @param element
*/
@Override
public void add(int index, Object element){
    if (index > size || element == null || index < 0){
    throw new RuntimeException("Enter a valid inputs");
    }else{
    Node NewNode = new Node(element);
    if (index == 0){
        NewNode.next = head;
        head = NewNode;
    }else if (head == null){
        head = NewNode;
        NewNode.next = null;
    
    }else {
        temp = head;
        for (int i=1;i<index;i++){
            temp = temp.next;
        }
        NewNode.next = temp.next;
        temp.next=NewNode;
    }
    size++;
    }
}
/**
* Inserts the specified element at the end of the list.
* @param element
*/
@Override
public void add(Object element){
    if (element != null){
    Node NewNode = new Node(element);
    if (head == null){
    head=NewNode;
    NewNode.next=null;
    }else {
        temp=head;
        for(;temp.next != null;){
        temp=temp.next;
        }
        NewNode.next=null;
        temp.next = NewNode;
    }
    size++;
    }else {
    throw new RuntimeException("Enter a valid inputs");
    } 
}
/**
* @param index
* @return the element at the specified position in this list.
*/
@Override
public Object get(int index){
    if (index > size || index < 0){
    throw new RuntimeException("Enter a valid inputs");
    }else {
    temp = head;
    for (int i=0;i<index;i++){
    temp=temp.next;
    }
    return temp.Value;
    }
}
/**
 * * Replaces the element at the specified position in this list with the
* specified element.
* @param index
* @param element
*/
 @Override
 public void set(int index, Object element){
    if (index > size || element == null || index < 0){
    throw new RuntimeException("Enter a valid inputs");
    }else{
    temp=head;
    for (int i=0;i<index;i++){
    temp=temp.next;
    }
    temp.Value=element;
    }           
 }
 /**
* Removes all of the elements from this list.
*/
 @Override
 public void clear(){
     head = null;
     size = 0;
 }
 /**
* @return true if this list contains no elements.
*/
 @Override
 public boolean isEmpty(){
 return (head == null);
 }
 /**
* Removes the element at the specified position in this list.
* @param index
*/
 @Override
 public void remove(int index){
    if (index > size || index < 0){
    throw new RuntimeException("Enter a valid inputs");
    }else {
    if (size == 1){
    head = null;
    }else if (index == 0){
    head = head.next;
    }else {
    temp=head;
    for (int i=1;i<index;i++){
    temp=temp.next;
    }
    temp.next=temp.next.next;
    }
    size--;
    }
 
 }
 /**
* @return the number of elements in this list.
*/
 @Override
public int size(){
return size;
}
/**
* @param fromIndex
* @param toIndex
* @return a view of the portion of this list between the specified
* fromIndex and toIndex, inclusively.
*/
@Override
public ILinkedList sublist(int fromIndex, int toIndex){
    if (fromIndex >=size || fromIndex < 0 || toIndex>=size || toIndex<0){
    throw new RuntimeException("Enter a valid inputs");
    }else {
    Singly_Linked_list sub_list = new Singly_Linked_list();
    temp=head;
    for (int i=0 ; i<fromIndex;i++){
    temp=temp.next;
    }
    for (int i=fromIndex;i<=toIndex;i++){
        sub_list.add(temp.Value);
        temp=temp.next;
    }
    return sub_list;
    }
}
/**
* @param o
* @return true if this list contains an element with the same value as the
* specified element.
*/
@Override
public boolean contains(Object o){
boolean Isfound = false;
if (o!=null){
    temp=head;
    while (!Isfound && temp!=null){
    if (temp.Value == o){
        Isfound = true; 
        break;
    }else {temp=temp.next;}
    }
  }
    return Isfound;
 }

public Object[] listToArr(Singly_Linked_list list) {
	Object[] arr = new Object [list.size()];
	for (int i=0;i<list.size();i++) {
		arr[i]=list.get(i);
	}
	return arr;
}

public Singly_Linked_list arrToList (Object[] arr) {
	Singly_Linked_list list = new Singly_Linked_list();
	for (int i=0;i<arr.length;i++) {
		list.add(arr[i]);
	}
	return list;
}
}
