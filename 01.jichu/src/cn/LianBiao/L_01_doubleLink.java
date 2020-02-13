package cn.LianBiao;

public class L_01_doubleLink<T> {
    //表头
    private DNode<T> mHead;
    //节点个数
    private int mCount;

    //双向链表对应的结构体
    private class DNode<T>{
        public DNode prev;
        public DNode next;
        public T value;

        public DNode(DNode prev, DNode next, T value) {
            this.prev = prev;
            this.next = next;
            this.value = value;
        }
    }
    //构造函数
    public L_01_doubleLink() {
        mHead = new DNode<T>(null,null,null);
        mHead.prev = mHead.next = mHead;
        //初试化节点个数
        mCount = 0;
    }
    //返回节点个数
    public int size(){
        return mCount;
    }

    //返回链表是否为空
    public boolean isEmpty(){
        return mCount == 0;
    }
    // 获取第index 位置的节点
    public DNode<T> getNode(int index){
        if(index<0 || index>= mCount){
            throw  new IndexOutOfBoundsException();
        }
        //正向查找
        if(index <= (mCount >>1)){
            DNode<T> node = mHead.next;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node;
        }else {
            //反向查找
            DNode<T> rnode = mHead.prev;
            int rindex = mCount - index - 1;
            for (int i = 0; i < rindex; i++) {
                rnode = rnode.prev;
            }
            return rnode;
        }
    }
    //获取index位置节点的值
    public T get(int index){
        return  getNode(index).value;
    }

    //获取第一个节点的值
    public  T getFirst(){
        return getNode(0).value;
    }
    //获取最后一个节点的值
    public T getLast(){
        return getNode(mCount-1).value;
    }




}
