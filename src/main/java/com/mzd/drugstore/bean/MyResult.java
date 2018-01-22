package com.mzd.drugstore.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//提供get/set
@Data
//提供所有有参数的构造的方法
@AllArgsConstructor
//提供无参数的构造方法 - - -如果类中含有final修饰的成员变量，是无法使用@NoArgsConstructor注解的。
@NoArgsConstructor
//@RequiredArgsConstructor - - -使用类中所有带有@NonNull注解的或者带有final修饰的成员变量生成对应的构造方法
public class MyResult {
    //状态码
    private String code;
    //信息
    private String message;
    //结果对象
    private Object result;
    //总共多少页
    private int pageNum;
}
