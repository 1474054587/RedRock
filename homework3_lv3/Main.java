package homework3_lv3;

//主类
public class Main {
    public static void main(String[] args) {
        /*
        基础版：
        需要创建实现类
        从抽象类People继承King类、Soldier类
         */
        //声明国王类，士兵类
        King king1 = new King("BoJi");
        Soldier a = new Soldier("a");
        Soldier b = new Soldier("b");
        //将士兵类添加到对应国王类的动态数组中
        king1.addSolider(a);
        king1.addSolider(b);
        //国王阅兵
        king1.review();
        //将士兵类从国王类动态数组中删除
        king1.removeSolider(b);
        //再次阅兵，b士兵不再回应
        king1.review();

        /*
        进阶1：
        使用匿名内部类,无需创建实现类
        直接调用抽象类People
         */
        People king2 = new People(){
            @Override
            public void review(){
                System.out.println("Dodge国王开始阅兵");
                for (People soldier: arrayList){
                    soldier.response();
                }
            }
            @Override
            public void addSolider(People solider){
                arrayList.add(solider);
            }
            @Override
            public void removeSolider(People soldier){
                arrayList.remove(soldier);
            }
        };
        People c = new People() {
            @Override
            public void response() {
                name = "c";
                System.out.println(name+"向国王问好");
            }
        };
        king2.addSolider(c);
        king2.review();
    }
}