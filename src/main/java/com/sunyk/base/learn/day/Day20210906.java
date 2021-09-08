package com.sunyk.base.learn.day;

public class Day20210906 {
    private int a = 4;
    private  String This;
    private  String _this;


    
    /** 
    * @Description: 变量的作用域 ，在jvm运行过程中：先找同一作用域的变量，再找上一级作用域的变量，直到找到一个为止
    * @Param:  
    * @return:  
    * @Author: sun彦坤
    * @Date: 2021/9/6 
    */ 
    public void  testParam(){
         int a = 3;
        System.out.println(a);
        System.out.println(this.a);
        System.out.println(Day20210906.this.a);
    }
    public static void main(String[] args) {
       Day20210906 day20210906 = new Day20210906();
       day20210906.testParam();
    }


    public String getThis() {
        return This;
    }


    /**
    * @Description: 当成员变量名与方法形参名不一致时，不用添加this（地址指向）,因为可以明确是赋值给成员变量
    * @Param:
    * @return:
    * @Author: sun彦坤
    * @Date: 2021/9/6
    */
    public void setThis(String aThis) {
        This = aThis;
    }

    public String get_this() {
        return _this;
    }


    /**
    * @Description: 当成员变量名与方法形参名一致时，需要添加this指明地址，防止发生形参赋值给同作用域形参的情况；
    * @Param:
    * @return:
    * @Author: sun彦坤
    * @Date: 2021/9/6
    */
    public void set_this(String _this) {
        this._this = _this;
    }
    
    
    
    /** 
    * @Description: idea添加快捷键的步骤：setting -> editor -> live templates
    * @Param:  
    * @return:  
    * @Author: sun彦坤
    * @Date: 2021/9/6 
    */ 
}
