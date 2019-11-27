public class Main {

    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        int[] nums = {5, 3, 6, 8, 4, 2};
        for (int num: nums)
            bst.add(num);

        bst.preOrder();
        System.out.println("\n");

        bst.preOrderNR();
        System.out.println("\n");

        // 二分搜索树中序遍历结果即为树中元素以升序排列的结果
        bst.InOrder();
        System.out.println("\n");

        // 后序遍历应用：为二分搜索树释放内存
        bst.postOrder();
        System.out.println("\n");
    }
}
