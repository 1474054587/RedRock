package homework2_lv4;

//英雄子类
class Hero extends Character {
    //是否胜利初始化为是
    public Hero() {
        setWinOrNot(true);
    }
    //英雄属性赋值
    public void heroCreate(int d,int e){
        setDef(d);
        setWeapon(e);
    }
}