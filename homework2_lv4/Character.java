package homework2_lv4;

//角色父类
class Character {
    //名称
    private String name;
    //血量
    private int hp;
    //最大血量
    private int hpMax;
    //攻击力
    private int atk;
    //防御力
    private int def;
    //武器
    private int weapon;
    //是否胜利
    private boolean winOrNot;
    //初始化变量
    public Character() {
        hp = 0;
        hpMax = 0;
        atk = 0;
        /*
        本游戏中，伤害=攻击力/防御力
        因此防御力初始值为1，即代表无防御力
         */
        def = 1;
        //任意不为1.2.3.4.5的武器，代表无武器
        weapon = 0;
    }
    //属性赋值：初始值+输入值
    public void create(String a,int b,int c){
        name = a;
        hp += b;
        hpMax += b;
        atk += c;
        //如血量，攻击力小于等于0，为防止战斗无法进行或无法停止，改为1
        if (hp<=0){hp=1;hpMax=1;}
        if (atk<=0){atk=1;}
        //选择武器
        chooseWeapon(weapon);
    }
    //get方法：获取名称
    public String getName(){
        return name;
    }
    //get方法：获取血量
    public int getHp(){
        return hp;
    }
    //set方法：设置防御力
    public void setDef(int h){
        //为防止伤害为负，防御力禁止小于1
        if (h>=1){def = h;}
    }
    //set方法：设置武器
    public void setWeapon(int m){
        weapon = m;
    }
    //get方法：获取是否胜利
    public boolean getWinOrNot(){
        return winOrNot;
    }
    //set方法：设置是否胜利
    public void setWinOrNot(boolean n){
        winOrNot = n;
    }
    //attack方法：将自身名称，血量传递给beAttacked方法
    public void attack(Character one){
        one.beAttacked(name,atk);
    }
    //beAttacked方法：被攻击
    public void beAttacked(String oneName,int oneAtk){
        //血量减少：攻击者攻击力/自身防御力
        hp -= oneAtk/def;
        //判断剩余血量
        if (hp>0){
            //角色未死亡，则输出战斗信息
            System.out.println(oneName+"攻击了"+name+"，造成了"+oneAtk/def
                    +"点伤害，"+name+"剩余"+hp+"点生命。");
        }else {
            //角色死亡，则输出死亡信息
            System.out.println(oneName+"攻击了"+name+"，造成了"+oneAtk/def
                    +"点伤害,"+oneName+"杀死了"+ name+"!");
            //判断角色是否有复活甲
            if(weapon == 5){
                //如果有复活甲，复活甲消失，恢复满血，输出复活信息
                System.out.println(name+"使用了复活甲，恢复满血！");
                resurrection();
                weapon = 0;
            }else {
                //如果无复活甲，判断是否胜利为否
                winOrNot = false;
            }
        }
    }
    //复活方法
    public void resurrection(){
        //血量变为最大血量，即为复活
        hp = hpMax;
    }
    //选择武器方法
    public void chooseWeapon(int weapon){
        //判断武器种类，增加相应血量，如无武器或武器不增加属性，结束
        switch (weapon){
            case 1:
                atk += 10;
                break;
            case 2:
                def += 10;
                break;
            case 3:
                atk += 20;
                break;
            case 4:
                def += 20;
                break;
        }
    }
}
