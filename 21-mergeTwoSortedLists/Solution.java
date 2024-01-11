class Solution {

  private class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    if(list1 == null && list2 == null){
        return null;
    }

    ListNode newList = new ListNode();
    ListNode tail = newList;

    while (list1 != null && list2 != null) {

      if (list1.val <= list2.val) {
        tail.val = list1.val;
        tail.next = new ListNode();
        tail = tail.next;
        list1 = list1.next;

      } else{
        tail.val = list2.val;
        tail.next = new ListNode();
        tail = tail.next;
        list2 = list2.next;       
      }
      
    }

    if (list1 == null && list2 != null) {
      tail.val = list2.val;
      tail.next = list2.next;
    }else if(list2 == null && list1 != null ){
      tail.val = list1.val;
      tail.next = list1.next;

    }

    return newList;
        
  }

    private void printList(ListNode list){
      while (list != null) {
        System.out.println(list.val);
      }
    }
  

    public static void main(String[] args) {


    }
}