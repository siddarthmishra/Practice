package com.javaconceptoftheday.langclass;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
 
class MyClass
{
    int myField1;
     
    String myField2;
     
    int myMethod1()
    {
        return myField1;
    }
     
    String myMethod2()
    {
        return myField2;
    }
}
 
public class LangClass
{
    @SuppressWarnings("rawtypes")
	public static void main(String[] args) 
    {
        //Retrieving Class object associated with MyClass
         
        Class c = MyClass.class;
         
        String name = c.getName();    //Returns class name
         
        System.out.println(name);     //Output : pack1.MyClass
         
        Package packageName = c.getPackage();    //Returns package name
         
        System.out.println(packageName);     //Output : package pack1
         
        Field[] fields = c.getDeclaredFields();     //Returns declared fields
         
        for (int i = 0; i < fields.length; i++) 
        {
            System.out.println(fields[i]);
        }
         
        //        Output
         
        //        int pack1.MyClass.myField1
        //        java.lang.String pack1.MyClass.myField2
         
         
        Method[] methods = c.getDeclaredMethods();    //Returns methods of the class
         
        for (int i = 0; i < methods.length; i++)
        {
            System.out.println(methods[i]);
        }
         
        //        Output :
         
        //        java.lang.String pack1.MyClass.myMethod2()
        //        int pack1.MyClass.myMethod1()
         
        Constructor[] constructors = c.getDeclaredConstructors();   //Returns constructors of the class
         
        for (int i = 0; i < constructors.length; i++)
        {
            System.out.println(constructors[i]);        //Output : pack1.MyClass()
        }
         
        //Checking whether class is anonymous
         
        System.out.println(c.isAnonymousClass());    //Output : false
         
        //Checking whether class is enum
         
        System.out.println(c.isEnum());     //Output : false
         
        //Checking whether class is interface
         
        System.out.println(c.isInterface());     //Output : false
    }
}