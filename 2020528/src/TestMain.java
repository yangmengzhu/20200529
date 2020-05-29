/*
 * @program: 2020528
 * @description
 * @author: mrs.yang
 * @create: 2020 -05 -28 22 :37
 */

public class TestMain {
    public static void main(String[] args) {
        BSTree bsTree=new BSTree();
        int[] arr={7,2,9,18,56,15,3};
        for (int i:arr) {
            bsTree.insert(i);
        }
        bsTree.preorder(bsTree.root);
        System.out.println();
        bsTree.inorder(bsTree.root);
        System.out.println(bsTree.search(19));
        bsTree.remove(18);
        bsTree.preorder(bsTree.root);
    }
}
