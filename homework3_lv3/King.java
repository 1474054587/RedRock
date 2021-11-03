package homework3_lv3;

//国王类-实现类-继承People类
class King extends People{
    //构造时传入国王名称
    public King(String name){
        this.name = name;
    }
    @Override
    public void review(){
        System.out.println(name+"国王开始阅兵");
        //遍历数组，每个士兵回应
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
}