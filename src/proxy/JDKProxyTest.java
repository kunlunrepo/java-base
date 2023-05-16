package proxy;

import proxy.service.Dinner;
import proxy.service.impl.Person;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * description :
 *
 * @author kunlunrepo
 * date :  2023-05-16 20:33
 */
public class JDKProxyTest {
    public static void main(String[] args) {
        Dinner dinner = new Person("张三");

        // 通过Proxy动态代理获得一个代理对象，在代理对象中，对某个方法进行增强
        ClassLoader classLoader = dinner.getClass().getClassLoader();

        Class<?>[] interfaces = dinner.getClass().getInterfaces(); // 被代理对象所实现的所有接口
        InvocationHandler handler = new InvocationHandler() { // 处理类
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable { // 代理对象调用任何方法时，都会触发invoke方法的执行
                Object res = null;
                if ("eat".equals(method.getName())){
                    System.out.println("饭前洗手"); // 前置增强
                    res = method.invoke(dinner, args);
                    System.out.println("饭后刷碗"); // 后置增强
                } else {
                    // 如果是其他方法，那么正常执行就可以了
                    res = method.invoke(dinner, args);
                }
                return res;
            }
        };

        Dinner dinner1 = (Dinner) Proxy.newProxyInstance(classLoader, interfaces, handler);
        dinner1.eat("面包");
    }
}
