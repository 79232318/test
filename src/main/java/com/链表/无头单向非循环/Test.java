package com.链表.无头单向非循环;
public class Test {
    public static void main(String[] args){
        testAddFirst();
        testAddLast();
        testAddIndex();
        testremove();
        testRemoveAllKey();
    }
    public static void testAddFirst(){
        System.out.println("测试addfirst方法");
        SingleLinkedList linkedList = new SingleLinkedList();
        linkedList.addFirst(1);
        linkedList.addFirst(2);
        linkedList.addFirst(3);
        linkedList.addFirst(4);
        linkedList.display();
    }
    public static void testAddLast(){
        System.out.println("测试addLast方法");
        SingleLinkedList linkedList = new SingleLinkedList();
        linkedList.addLast(1);
        linkedList.addLast(2);
        linkedList.addLast(3);
        linkedList.display();
    }
    public static void testAddIndex(){
        System.out.println("测试addIndex方法");
        SingleLinkedList linkedList = new SingleLinkedList();
        linkedList.addFirst(1);
        linkedList.addFirst(2);
        linkedList.addLast(2);
        linkedList.addLast(3);
        linkedList.addIndex(4,5);
        linkedList.display();
        System.out.println(linkedList.contains(10));
    }
    public static void testremove(){
        System.out.println("测试remove");
        SingleLinkedList linkedList = new SingleLinkedList();
        linkedList.addFirst(1);
        linkedList.addFirst(2);
        linkedList.addLast(2);
        linkedList.addLast(3);
        linkedList.addIndex(2,5);
        linkedList.romove(5);
        linkedList.display();
    }
    public static void testRemoveAllKey(){
        System.out.println("测试removeallKesy");
        SingleLinkedList linkedList = new SingleLinkedList();
        linkedList.addFirst(1);
        linkedList.addFirst(1);
        linkedList.addLast(1);
        linkedList.addLast(1);
        linkedList.addIndex(2,1);
        linkedList.display();
        linkedList.romoveAllKey(1);
        linkedList.display();
    }
}

