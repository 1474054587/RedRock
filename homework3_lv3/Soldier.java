package homework3_lv3;

//士兵类-实现类-继承People类
class Soldier extends People{
    //构造时传入士兵名称
    public Soldier(String name){
        this.name = name;
    }
    @Override
    public void response(){
        System.out.println(name+"向国王问好");
    }
}