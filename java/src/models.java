class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode constructTree(Integer[] nums) {
        int n = nums.length;
        TreeNode[] nodes = new TreeNode[n];
        for (int i = 0; i < n; i++) {
            if (nums[i] == null) {
                nodes[i] = null;
            } else {
                nodes[i] = new TreeNode(nums[i]);
            }
        }

        for (int i = 0; i < n; i++) {
            if (nodes[i] != null) {
                int l = 2 * i + 1;
                int r = 2 * i + 2;

                if (l < n) {
                    nodes[i].left = nodes[l];
                }
                if (r < n) {
                    nodes[i].right = nodes[r];
                }
            }

        }
        return nodes[0];
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}