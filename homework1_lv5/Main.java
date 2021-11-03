package homework1_lv5;

public class Main {
    public static void main(String[] args){
        ASimpleArrayList list= new ASimpleArrayList();
        list.add("红岩网校Android");
        list.remove(0);
        list.add(0,"加油冲冲冲！");
        System.out.println(list.get(0));
        System.out.println("list内拥有："+list.size()+"个元素");
    }
}
