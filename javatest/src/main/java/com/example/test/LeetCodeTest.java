package com.example.test;

import java.util.ArrayList;
import java.util.List;

public class LeetCodeTest {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public static boolean isPalindrome(ListNode head) {
        List<ListNode> listNodes = new ArrayList<>();
        while (head != null) {
            listNodes.add(head);
            head = head.next;
        }
        if (listNodes.size() == 0 || listNodes.size() == 1) {
            System.out.printf("0");
            return true;
        }
        for (int i = 0; i < listNodes.size() / 2; i++) {
            if (listNodes.get(i).val != listNodes.get(listNodes.size() - i-1).val) {
                System.out.printf("1");
                return false;
            }
        }
        System.out.printf("2");
        return true;
    }

    public static void main(String[] args) {
//        ListNode listNode = new ListNode(1);
//        listNode.next = new ListNode(2);
        isPalindrome(null);
    }
}
