using System.ComponentModel.Design;

namespace AlgAndDsProblems.problems
{
    public class BinarySearchTree
    {
        public TreeNode Insert(TreeNode root, int data)
        {
            if (root == null)
            {
                return new TreeNode(data);
            }
            else
            {
                TreeNode cur;
                if (data <= root.data)
                {
                    cur = Insert(root.left, data);
                    root.left = cur;
                }
                else
                {
                    cur = Insert(root.right, data);
                    root.right = cur;
                }

                return root;
            }
        }

        public int GetHeight(TreeNode root)
        {
            if (root == null || (root.left == null && root.right == null)) return 0;
            else
            {
                return GetHeightAux(root, 0);
            }
        }

        private int GetHeightAux(TreeNode treeNode, int height)
        {
            if (treeNode.left == null && treeNode.right == null) return height;
            else if (treeNode.left != null) return GetHeightAux(treeNode.left, height + 1);
            else return GetHeightAux(treeNode.right, height + 1);
        }
    }

    public class TreeNode
    {
        public TreeNode left, right;
        public int data;

        public TreeNode(int data)
        {
            this.data = data;
            left = right = null;
        }
    }
}