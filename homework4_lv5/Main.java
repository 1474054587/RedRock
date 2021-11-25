package homework4_lv5;

public class Main {
    public static void main(String[] args){
        /*
        之所以写成一坨shit，是因为最近太忙了，没有看课件，
        然后作业题目交代的也不是很清楚，看到链表、ArrayList、Iterator，就开撸了，
        等到我搞明白题目要我干什么的时候我已经撸进去一大半了，所以就这样吧，
        大致就是写了个链表，实现了基本的增删查改，
        内部有一个没什么功能的迭代器，实现了Iterator接口(只实现了最基本的方法)，
        所以大概勉强能当ArrayList用吧，也能迭代输出。
         */
        MyArrayList<Object> a = new MyArrayList();
        a.add("1");//在 a 末尾添加 1，a 现在为：1
        a.addFirst("2");//在 a 开头添加 2，a 现在为：2,1
        System.out.println(a.getIndex("2"));//打印 2 在 a 中的索引，输出：0
        a.add("3",1);//在 a 第 1 项添加 3，a 现在为：2,3,1
        System.out.println(a.get(2));//打印 a 的索引 2，输出：1
        System.out.println(a.getSize());//打印 a 的元素个数，输出：3
        a.set("3",2);//将 a 的索引 2 修改为 3，a 现在为：2,3,3
        a.remove("3");//删除 a 中第一个 3，a 现在为：2,3
        a.removeFirst();//删除 a 的第一个元素，a 现在为：3
        a.remove();//删除 a 中最后一个元素，a 现在为：null
        System.out.println(a.isEmpty());//打印 a 是否为空，输出：true
        a.add("1");a.add("2");a.add("3");a.add("4");//a 现在为：1,2,3,4
        a.remove(2);//删除 a 的索引 2，a 现在为：1,2,4
        MyArrayList.MyIterator b = a.iterator();//将 a 传入 迭代器
        while (b.hasNext()) {
            System.out.println(b.get());//打印当前节点
            System.out.println(b.next());//迭代，并打印下一节点，
        }
        a.clear();//清空，a 现在为：null
        System.out.println(a.isEmpty());//打印 a 是否为空
        /*
        测试输出结果：
        0
        1
        3
        true
        1
        2
        2
        4
        true
         */
    }
}
