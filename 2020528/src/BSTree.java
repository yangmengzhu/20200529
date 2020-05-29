/*
 *
 * @program: 2020528
 * @description
 * 二叉搜索树
 * @author: mrs.yang
 * @create: 2020 -05 -28 20 :16
 */


public  class BSTree {
    public static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node(int val) {
            this.val = val;
        }
    }
    //插入元素
    public Node root=null;
    public boolean insert(int data){
        Node node=new Node(data);
        if(root==null){
            root=node;
            return true;
        }
        Node cur=root;
        Node parent=null;
        while(cur!=null){
            if(cur.val==data){
                return false;
            }else if(cur.val<data){
                parent=cur;
                cur=cur.right;
            }else{
                parent=cur;
                cur=cur.left;
            }
        }
        //cur为空，找到了data的位置，判断插入到左边还是右边
        if(parent.val<data){
            parent.right=node;
        }else{
            parent.left=node;
        }
        return true;
    }
    //遍历二叉树
    public void preorder(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.val+" ");
        preorder(root.left);
        preorder(root.right);
    }
    //中序遍历
    public void inorder(Node root){
        if(root==null){
            return;
        }
        inorder(root.left);
        System.out.print(root.val+" ");
        inorder(root.right);
    }
    //查找元素
    public Node search(int data){
        if(root==null){
            return null;
        }
        Node cur=root;
        while(cur!=null){
            if(cur.val==data){
                return cur;
            }else if(cur.val<data){
                cur=cur.right;
            }else{
                cur=cur.left;
            }
        }
        return null;
    }
    //删除元素
    public boolean remove(int key){
        Node cur=root;
        Node parent=null;
        while(cur!=null){
            if(cur.val==key){
                removeCur(parent,cur);
                return true;
            }else if(cur.val<key){
                parent=cur;
                cur=cur.right;
            }else{
                parent=cur;
                cur=cur.left;
            }
        }
        return false;
    }
    public void removeCur(Node parent,Node cur){
        //1.cur.left==null
        if(cur.left==null){
            if(cur==root){
                root=cur.right;
            }else if(cur==parent.left){
                parent.left=cur.right;
            }else{
                parent.right=cur.right;
            }
        }else if(cur.right==null){  //2.cur.right==null
            if(cur==root){
                root=cur.left;
            }else if(cur==parent.left){
                parent.left=cur.left;
            }else{
                parent.right=cur.left;
            }
        }else{ //3.cur.left!=null&&cur.right!=null
            Node targetParent=cur;
            Node target=cur.right;
            while(target.left!=null){
                targetParent=target;
                target=target.left;
            }
            cur.val=target.val;
            //删除target
            if(target==targetParent.left){
                targetParent.left=target.right;
            }else{//target.left的左边为空
                targetParent.right=target.right;
            }
        }
    }
  }
