package binarytree;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int x) {
        this.val = x;
    }
}
