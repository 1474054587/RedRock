package homework2_lv4;

import java.util.Random;
import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        //实例化对象
        Scanner sc = new Scanner(System.in);
        Hero yourHero = new Hero();
        Enemy yourEnemy = new Enemy();
        Random rand = new Random();
        //输入英雄，小兵属性
        System.out.println("请输入英雄属性：");
        System.out.print("名称：");
        String a = sc.next();
        System.out.print("生命：");
        int b = sc.nextInt();
        System.out.print("攻击力：");
        int c = sc.nextInt();
        System.out.print("防御力：");
        int d = sc.nextInt();
        System.out.println("请输入小兵属性：");
        System.out.print("名称：");
        String f = sc.next();
        System.out.print("生命：");
        int g = sc.nextInt();
        System.out.print("攻击力：");
        int h = sc.nextInt();
        System.out.println("在开始战斗前，你可以穿戴一件装备：");
        System.out.println("1.木剑：攻击+10");
        System.out.println("2.布甲：防御+10");
        System.out.println("3.铁剑：攻击+20");
        System.out.println("4.铁甲：防御+20");
        System.out.println("5.复活甲：死亡后可消耗复活甲满血复活");
        System.out.print("请选择装备编号：");
        int e = sc.nextInt();
        System.out.println("输入1进入困难模式，否则为普通模式");
        int x = sc.nextInt();
        //如果进入困难模式，小兵攻击+20
        if (x == 1){
            yourEnemy.chooseWeapon(3);
        }
        //属性赋值
        yourHero.heroCreate(d,e);
        yourHero.create(a,b,c);
        yourEnemy.create(f,g,h);
        //生成从0到4的随机数，加1即为小兵数量
        int enemyNumber = rand.nextInt(5)+1;
        System.out.println(yourHero.getName()+"遭遇了"+enemyNumber+"名"+yourEnemy.getName()+"，战斗一触即发！");
        //游戏为回合制，i为回合数
        int i = 1;
        //战斗，小兵数量为0或英雄死亡：结束
        while (enemyNumber != 0 && yourHero.getWinOrNot()) {
            //循环攻击直到有角色死亡
            while (yourHero.getHp() > 0 && yourEnemy.getHp() > 0) {
                //英雄先手
                if (i % 2 != 0) {
                    //英雄每回合攻击一次
                    yourHero.attack(yourEnemy);
                } else {
                    //每个小兵每回合攻击一次，如英雄战败，停止攻击
                    for (int j = 0; j<enemyNumber && yourHero.getWinOrNot(); j++){
                        yourEnemy.attack(yourHero);
                    }
                }
                //一方攻击后，回合数加1
                i++;
            }
            /*
            循环结束说明有角色死亡
            如果死亡为小兵，将小兵复活，小兵数量减1，即相当于杀死一个小兵
            如果死亡为英雄，战斗结束，以下两行代码无意义，无影响，因此未使用if判断
             */
            yourEnemy.resurrection();
            enemyNumber -= 1;
        }
        //判断是否胜利
        if(yourHero.getWinOrNot()){
            System.out.println("恭喜你取得了胜利！");
        }else {
            System.out.println("你失败了。");
        }
    }
}