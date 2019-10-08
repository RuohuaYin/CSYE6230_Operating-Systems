class CopyListWithRandomPointer{
  public Node copyRandomList(Node head) {
        Node dummy = new Node(0);
        Node cur = dummy;
        Node curOld = head;
        Map<Integer, Node> map = new HashMap<>();
        while(curOld != null){
            Node newNode = new Node(curOld.val, null, null);
            map.put(newNode.val, newNode);
            cur.next = newNode;
            cur = cur.next;
            curOld = curOld.next;
        }
        curOld = head;
        while(curOld != null){
            Node curNode = map.get(curOld.val);
            if(curOld.random != null){
                curNode.random = map.get(curOld.random.val);
            }
            curOld = curOld.next;
        }
        return dummy.next;
    }
}
