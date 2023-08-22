package com.foobar.generator;

/**
 * 入口类
 */
/*二元一次方程*/

import java.util.Scanner;

public class Sample2 {
    public static void main(String[] args) {


        /*
         *  0.9980 = 8k + c
            0.9 = 24k + c
         *
         * 2x+2y=10
         * 3x+4y=18
         */
        double x,y;
//      double a1=2,b1=2,c1=10;
//      double a2=3,b2=4,c2=18;
        Scanner in=new Scanner(System.in);
        System.out.println("对照格式输入：a1X+b1Y=c1  a2X+b2Y=c2");
        System.out.print("请输入a1的值：");
        double a1=in.nextDouble();
        System.out.print("请输入b1的值：");
        double b1=in.nextDouble();
        System.out.print("请输入c1的值：");
        double c1=in.nextDouble();
        System.out.print("请输入a2的值：");
        double a2=in.nextDouble();
        System.out.print("请输入b2的值：");
        double b2=in.nextDouble();
        System.out.print("请输入c2的值：");
        double c2=in.nextDouble();
        double j,k,l;
        j=a2/a1;    //j==1.5
        a1=a1*j;    //a1==3
        b1=b1*j;    //b1==3
        c1=c1*j;    //c1==15
        k=c2-c1;
        l=b2-b1;
        y=k/l;
        x=(c2-b2*y)/a2;
        System.out.println("x="+x);
        System.out.println("y="+y);

    }

}
