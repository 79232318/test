/**  
* @Title: SingleLinkedList.java  
* @Package com.链表.无头单向非循环  
* @Description: TODO(用一句话描述该文件做什么)  
* @author wangtz  
* @date 2019年9月29日  
* @version V1.0  
*/  
package com.链表.无头单向非循环;

import java.util.LinkedList;

import com.dingtalk.api.request.OapiChatSendRequest.Link;

/**  
* <p>Description: </p>
* @ClassName: SingleLinkedList  
* @author wangtz  
* @date 2019年9月29日    
*/
public class SingleLinkedList {

	private LinkedNode head = null;
	
	public void addFirst(int elem) {
		LinkedNode node = new LinkedNode(elem);

		if(this.head == null) {
			this.head = node;
			return;
		}
		node.next = this.head;//将第一个变成第二个
		this.head = node;//插入第一个
		return;
	}
	
	public void display() {
		System.out.print("[");
		for(LinkedNode node = this.head; node != null; node = node.next) {
			System.out.print(node.data);
			if(node.next != null) {
				System.out.print(",");
			}
		}
		System.out.println("]");
	}

	public void addLast(int elem) {
		LinkedNode node = new LinkedNode(elem);
		if(this.head == null) {
			this.head = node;
			return;
		}
		LinkedNode lastNode = this.head;
		while(lastNode.next != null) {
			lastNode = lastNode.next;
		}
		lastNode.next = new LinkedNode(elem);
		return;
		
	}
	
	public int size() {
		int size = 0;
		for(LinkedNode node = this.head; node != null; node = node.next) {
			size++;
		}
		return size;
	}
	public void addIndex(int index , int elem) {
		int len = size();
		if(index < 0 || index > len) {
		     new RuntimeException("下标越界");
		}
		if(index == 0) {
			addFirst(elem);
			return;
		}
		if(index == len) {
			addLast(elem);
			return;
		}
		LinkedNode prev = getIndexPos(index - 1);
		LinkedNode node = new LinkedNode(elem);
		node.next = prev.next;
		prev.next = node;
	    
		return;
		
	}
	public LinkedNode getIndexPos(int index){
		LinkedNode node = this.head;
		for (int i = 0; i < index; i++) {
			node = node.next;
		}
		return node;
	}
    public boolean contains(int toFind) {
        // 直接遍历链表, 依次比较每个元素就行了
        for (LinkedNode cur = this.head;
                cur != null; cur = cur.next) {
            if (cur.data == toFind) {
                return true;
            }
        }
        return false;
    }
    public void romove(int toremove){
    	if(this.head == null) {
    		new RuntimeException("为空");
    	}
    	if(this.head.data == toremove) {
    		this.head = this.head.next;
    		return;
    	}
    	LinkedNode node = searchPrev(toremove);
    	node.next = node.next.next;
    }
    //找到删除元素的前一个位置
    public LinkedNode searchPrev(int toremove){
    	 for(LinkedNode node = this.head; node != null; node =node.next) {
    		 if(node.next.data == toremove) {
    			 return node;
    		 }
    	 }
    	 return null;
    }
    //删除链表中所有的key
    public void romoveAllKey(int toremove){
        if(this.head == null){
            return;
        }
        for(LinkedNode cur = this.head;cur != null;
            cur = cur.next){
            if(cur.data == toremove){
                romove(toremove);
            }
        }
    }

}
class LinkedNode{
	public int data;
	public LinkedNode next = null;
	
	public LinkedNode(int date) {
		this.data = date;
	}
	
	
}