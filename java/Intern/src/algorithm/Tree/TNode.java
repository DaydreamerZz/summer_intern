package algorithm.Tree;

/**
 * @author: Bruce Zhao
 * @email: zhzh402@163.com
 * @date: 2018/3/19 21:39
 */
public class TNode {
    public int value;
    public TNode lchild;
    public TNode rchild;

    public TNode(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public TNode getLchild() {
        return lchild;
    }

    public void setLchild(TNode lchild) {
        this.lchild = lchild;
    }

    public TNode getRchild() {
        return rchild;
    }

    public void setRchild(TNode rchild) {
        this.rchild = rchild;
    }
}
