package cn.Object;

class shallowCloneExample implements Cloneable{

    private int[] arr;

    public shallowCloneExample() {
        arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
    }

    public void set(int index, int value) {
        arr[index] = value;
    }

    public int get(int index) {
        return arr[index];
    }

    @Override
    protected shallowCloneExample clone() throws CloneNotSupportedException {
        return (shallowCloneExample) super.clone();
    }
}



/*
* 2. 浅拷贝

拷贝对象和原始对象的引用类型引用同一个对象。
* */
public class clone_shallowCloneExample {

    public static void main(String[] args) {
        shallowCloneExample e1 = new shallowCloneExample();
        shallowCloneExample e2 = null;
        try {
            e2 = e1.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        e1.set(2, 222);
        System.out.println(e2.get(2)); // 222
    }

}
