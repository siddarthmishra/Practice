package com.javaconceptoftheday.inheritance;
class A1
{
    int i = 1212;
}
 
class B1 extends A1
{
    A1 a;
 
    public B1(A1 a)
    {
        this.a = a;
    }
}
 
public class Example4
{
    public static void main(String[] args)
    {
        A1 a = new A1();
 
        B1 b = new B1(a);
 
        System.out.println(a.i);
 
        System.out.println(b.i);
 
        System.out.println(b.a.i);
 
        b.a.i = 2121;
 
        System.out.println("--------");
 
        System.out.println(a.i);
 
        System.out.println(b.i);
    }
}