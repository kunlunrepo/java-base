package collect;

import java.util.Stack;

/**
 * description :
 *
 * @author kunlunrepo
 * date :  2023-05-16 13:33
 */
public class StackTest {

    public static void main(String[] args) {
        // stack是vector的子类
        System.out.println("--------栈--------");
        Stack s = new Stack();
        s.add("A");
        s.add("B");
        s.add("C");
        s.add("D");
        System.out.println("栈：" + s);
        System.out.println("栈是否为空：" + s.empty());
        System.out.println("查看栈顶的数据，但是不移除：" + s.peek() + s.peek());
        System.out.println("栈：" + s);
        System.out.println("查看栈顶的数据，但是移除：" + s.pop() + s.pop());
        System.out.println("栈：" + s);
        s.push("E"); // 和add方法执行的功能一样，就是返回值不同
        System.out.println("栈：" + s);
    }
}
