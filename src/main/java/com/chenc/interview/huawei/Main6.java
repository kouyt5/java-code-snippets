package com.chenc.interview.huawei;

public class Main6 {
    public static void main(String[] args) {
        Node node1 = new Node();
        node1.val = 2;
        node1.next = new Node();
        node1.next.val = 4;
        node1.next.next = new Node();
        node1.next.next.val = 3;
        Node node2 = new Node();
        node2.val = 5;
        node2.next = new Node();
        node2.next.val = 6;
        node2.next.next = new Node();
        node2.next.next.val = 4;
        Node node = solve(node1, node2);
        System.out.println(node);
    }

    public static Node solve(Node node1, Node node2) {
        // int res = 0;
        Node resNode = new Node();
        Node head = resNode;
        int jinwei = 0;
        int i = 0;
        Node last = new Node();
        while (node1!=null && node1!=null) {
            int tmp = node1.val + node2.val + jinwei;
            // int curr += Math.pow(10, i) * (tmp % 10);
            resNode.val = tmp % 10;
            last = resNode;
            resNode.next = new Node();
            resNode = resNode.next;
            jinwei = tmp / 10;
            i++;
            node1 = node1.next;
            node2 = node2.next;
        }

        while (node1 == null && node2!=null) {
            int tmp = node2.val + jinwei;
            // res += Math.pow(10, i) * (tmp % 10);
            resNode.val = tmp % 10;
            last = resNode;
            resNode.next = new Node();
            resNode = resNode.next;
            jinwei = tmp / 10;
            node2 = node2.next;
            i++;
        }
        while (node2 == null && node1!=null) {
            int tmp = node1.val + jinwei;
            resNode.val = tmp % 10;
            last = resNode;
            resNode.next = new Node();
            resNode = resNode.next;
            jinwei = tmp / 10;
            node1 = node1.next;
            i++;
        }
        if (jinwei > 0) {
            resNode.val = jinwei;
            resNode.next = new Node();
            resNode = resNode.next;
        }
        last.next = null;
        return head;
    }

    static class Node {
        Node next;
        int val;
    }
}
