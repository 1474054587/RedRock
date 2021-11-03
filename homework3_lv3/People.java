package homework3_lv3;

import java.util.ArrayList;
//适配器-抽象类-实现Parade接口
abstract class People implements Parade{
    //阅兵方法
    public void review(){}
    //回应方法
    public void response(){}
    //添加士兵方法
    public void addSolider(People solider){}
    //删除士兵方法
    public void removeSolider(People solider){}
    public String name;
    //创建动态数组来保存国王拥有的所有士兵
    ArrayList<People> arrayList = new ArrayList<>();
}
