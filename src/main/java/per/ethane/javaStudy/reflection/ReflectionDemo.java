package per.ethane.javaStudy.reflection;

import org.springframework.security.core.parameters.P;

/**
 * java 反射
 * 获取字节码对象的三种方式
 *
 * @author sen li
 * @version 1.0.0
 * @date 2021/8/10 20:09
 **/
public class ReflectionDemo {
    public static void main(String[] args) throws ClassNotFoundException {
        /*
        方式一：Class.forName("全类名")
        此方式对应源代码阶段。将字节码文件加载进内存，返回Class对象。多用于配置文件，将类名定义在配置文件中，读取文件，加载类。
         */
        Class cls1 = Class.forName("per.ethane.javaStudy.reflection.Person");
        System.out.println(cls1);

        /*
        方式二: 类名.class
        此方式对应类对象阶段。通过类名的属性class来获取。多用于参数的传递。
         */
        Class cls2 = Person.class;
        System.out.println(cls2);

        /*
        方式三: 对象.getClass()
        此方式对应运行时阶段。getClass()方法在Object类中定义，所有对象均有此方法
         */
        Person person = new Person();
        Class cls3 = person.getClass();
        System.out.println(cls3);

        //比较是否对象相同
        System.out.println(cls1 == cls2);
        System.out.println(cls2 == cls3);
    }
}
