import java.util.*;
public class Student_Management_System {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int [][] array = new int [3][2];
        int [][] y = new int [3][2];
        int index = 0;
        int index1 = 0;
        boolean a = true;
        while(a){
            System.out.println("*********************************************");
            System.out.println("欢迎使用学生管理系统（伪）");
            System.out.println("该系统由没Offer没竞赛没科研没规划的双非本科");
            System.out.println("逃课挂科延毕绩点2.0没什么存在感的重邮学子姜同远ctrlc+v");
            System.out.println("1：录入学生信息");
            System.out.println("2：查找学生信息");
            System.out.println("3：修改学生信息");
            System.out.println("4：删除学生信息");
            System.out.println("5：退出");
            System.out.print("请输入功能代码：");
            int tag = sc.nextInt();
            switch(tag){
                case 1:
                    System.out.println("请输入学号");
                    int count = sc.nextInt();
                    boolean b = false;
                    for(int i = 0;i<index;i++){
                        if(array[i][0]==count){
                            b = true;
                            break;
                        }
                    }
                    if(index==array.length - 2){
                        int [][]x=new int[array.length*2][2];
                        for(int i=0;i<index;i++){
                            x[i]=array[i];
                        }array = x;
                    }
                    if(!b){
                        System.out.println("请输入学生姓名");
                        int pwd = sc.nextInt();
                        array[index][0]=count;
                        array[index][1]=pwd;
                        index++;
                        System.out.println("录入成功！");
                        break;
                    }else{
                        System.out.println("该生信息已存在，请重新录入");
                    }
                    break;
                case 2:
                    System.out.println("请输入要查找的学生学号");
                    count = sc.nextInt();
                    for(int i=0;i<index;i++){
                        if(array[i][0]==count){
                            System.out.println("学号：" + array[i][0]);
                            System.out.println("姓名：" + array[i][1]);
                            break;
                        }else if(i+1==index){
                            System.out.println("学号不存在，请重新输入");
                        }else{
                            continue;
                        }
                    }
                    break;
                case 3:
                    System.out.println("请输入要修改信息的学号");
                    count = sc.nextInt();
                    boolean l = false;
                    for(int i=0;i<index;i++){
                        if(array[i][0]==count){
                            l = true;
                            System.out.println("请输入原来学生姓名");
                            int pwd = sc.nextInt();
                            if(array[i][0]==count&&array[i][1]==pwd){
                                System.out.println("请输入要修改的学生姓名");
                                int pwd1 = sc.nextInt();
                                if(pwd == pwd1){
                                    System.out.println("与原学生姓名一致，请重新输入");
                                    break;
                                }else{
                                    array[i][1]=pwd1;
                                    System.out.println("修改成功！");
                                    break;
                                }
                            }
                        }
                    }if(!l){
                    System.out.println("该学号不存在，请输入正确的学号");
                }
                    break;
                case 4:
                    System.out.println("请输入要删除的学号");
                    count = sc.nextInt();
                    boolean c = false;
                    for(int i = 0;i<index;i++){
                        if(array[i][0]==count){
                            array[i][0]=0;
                            array[i][1]=0;
                            c = true;
                            break;
                        }
                    }
                    if(!c){
                        System.out.println("该学号不存在");
                    }else{
                        System.out.println("你已成功将该生踢出重邮了！");
                    }
                    break;
                case 5:
                    a = false;
                    return;
                default:
                    System.out.println("无法识别的命令");
                    break;
            }
        }
    }
}