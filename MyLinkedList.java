
class Node{
    public int val;
    public Node next;

    public Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }
}
class MyLinkedList {
    public Node head;
    public int size;

    /** Initialize your data structure here. */
    public MyLinkedList() {

    }

    //打印
    public void disPlay(){
        Node cur = this.head;
        for (int i = 0; i < this.size; i++) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
    }
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index < 0 || index >= this.size) return -1;
        Node cur = this.head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.val;

    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node tmp = new Node(val,this.head);
        this.head = tmp;
        this.size++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        if(this.size == 0) {
            this.head = new Node(val,null);
            this.size++;
            return;
        }
        Node tmp = this.head;
        while(tmp.next != null) {
            tmp = tmp.next;

        }
        tmp.next = new Node(val,null);
        this.size++;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index < 0 || index > this.size) return;
        if(index == 0) {
            addAtHead(val);
            return;
        }
        if(index == this.size) {
            addAtTail(val);
            return;
        }
        Node tmp = this.head;
        for (int i = 0; i < index - 1; i++) {
            tmp = tmp.next;
        }
        Node newNode = new Node(val,tmp.next);
        tmp.next = newNode;
        this.size++;


    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index >= this.size || index < 0) return;
        if(index == 0){
            this.head = this.head.next;
            this.size--;
            return;
        }
        Node tmp = this.head;
        for (int i = 0; i < index - 1; i++) {
            tmp = tmp.next;
        }
        tmp.next = tmp.next.next;
        this.size--;
        return;
    }

    public static void main(String[] args) {
        MyLinkedList myList = new MyLinkedList();
        myList.addAtHead(2);
        myList.addAtHead(1);
        myList.addAtTail(3);
        myList.addAtTail(4);
        myList.addAtIndex(3,7);
//        myList.deleteAtIndex(0);
        myList.deleteAtIndex(4);
        myList.disPlay();
        System.out.println();
        System.out.println(myList.get(2));

    }
}

