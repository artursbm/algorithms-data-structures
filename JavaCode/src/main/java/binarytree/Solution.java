package binarytree;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderTraversal(root, result);
        return result;
    }

    public void inorderTraversal(TreeNode root, List<Integer> result) {
        if(root == null) {
            return ;
        }
        if(root.left == null && root.right == null) {
            result.add(root.val);
        }
        if(root.left != null) {
            inorderTraversal(root.left, result);
        }
        if(root.right != null){
            inorderTraversal(root.right, result);
        }
    }
}
