package homework1_lv5;

//该类主要实现了ArrayList主要的几个方法：add(),remove(),size(),get()
class ASimpleArrayList {
    //声明一个object类型数组
    private Object [] list;
    //声明数组内元素个数
    private int size;
    //声明一个构造方法（听说构造方法自己写会比较规范，但是java不是有缺省构造器吗？）
    public ASimpleArrayList(){
        list = new Object[10];
        size = 0;
    }
    //add方法：添加新元素（选择加入位置）
    public void add(int index,Object newElement){
        //数组满时，自动扩容至原长度两倍
        if (size == list.length){
            Object [] newList = new Object[list.length*2];
            for(int i=0;i<size;i++){
                newList[i] = list[i];
            }
            list = newList;
        }
        //将新元素添加到数组中
        list[index] = newElement;
        //元素个数加1
        size++;
    }
    //add方法：添加新元素（自动在最后添加）
    public void add(Object newElement){
        //数组满时，自动扩容至原长度两倍
        if (size == list.length){
            Object [] newList = new Object[list.length*2];
            for(int i=0;i<size;i++){
                newList[i] = list[i];
            }
            list = newList;
        }
        //将新元素添加到数组中
        list[size+1] = newElement;
        //元素个数加1
        size++;
    }
    //remove方法：删除元素
    public void remove(int index){
        //判断输入值是否符合要求
        if(index > size) {
            System.out.println("注意，你的请求不合法！");
        }else if(index >= 0){
            //删除：将删除元素后的元素依次向前移1位
            for (int x = index; x<(size-1);x++){
                list[x] = list[x + 1];
            }
            list[size] = 0;
            //元素个数减1
            size--;
        }else{
            System.out.println("注意，你的请求不合法！");
        }
    }
    //get方法：返回输入位置数组的值
    public Object get(int index){
        //判断输入值是否符合要求
        if (index > size){
            System.out.println("注意，你的请求不合法！");
        }else if (index >= 0) {
            //返回输入位置数组的值
            return list[index];
        }else {
            System.out.println("注意，你的请求不合法！");
        }
        return 0;
    }
    //size方法：返回数组内元素个数
    public int size(){
        return size;
    }
}

