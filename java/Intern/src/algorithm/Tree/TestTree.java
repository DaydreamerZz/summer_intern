package algorithm.Tree;

import static java.lang.System.out;
/**
 * @author: Bruce Zhao
 * @email: zhzh402@163.com
 * @date: 2018/3/19 21:40
 */
public class TestTree {
    public static void main(String[] args){
        /*
                 -1
               3     6
             2  4   5  7
         */
        TNode root = new TNode(-1);
        TNode node3 = new TNode(3);
        TNode node6 = new TNode(6);
        root.lchild = node3;
        root.rchild = node6;

        out.println(root.lchild.getValue());
    }
}
