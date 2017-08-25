/**
 * Created by hanzihao on 2017/8/25.
 */
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        return toBST(head, null);
    }
    private TreeNode toBST (ListNode head, ListNode tail) {
        if (head == tail) return null;
        ListNode shorter = head;
        ListNode longer = head;
        while (longer != tail && longer.next != tail) {
            longer = longer.next.next;
            shorter = shorter.next;
        }
        TreeNode tree = new TreeNode(shorter.val);
        tree.left = toBST(head, shorter);
        tree.right = toBST(shorter.next, tail);
        return tree;
    }
}
