package ds.leetcode.linkedlist;

/**
 * Created by AmitAgarwal on 5/7/20.
 */
public class ListNode {

    public int data;
    public ListNode next = null;
    public ListNode previous = null;
    public ListNode current;



    public ListNode(){

    }

    public ListNode(int val){
        this.data = val;
    }

    public ListNode(int val, ListNode next) {
        this.data = val;
        this.next = next;
    }

}
