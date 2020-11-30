package lambdasinaction.chap9;

/**
 * 9.4.3 冲突及如何显式地消除歧义
 *
 * @param null
 * @return 
 * @throw 
 *
 * @author wangyh2
 * @since  2020/11/25 13:19 
 */
public class Ambiguous{

    public static void main(String... args) {
        new C().hello();
    }

    static interface A{
        public default void hello() {
            System.out.println("Hello from A");
        }
    }

    static interface B {
        public default void hello() {
            System.out.println("Hello from B");
        }
    }

    static class C implements B, A {
        @Override
        public void hello(){
//            A.super.hello();
            System.out.println("Hello from C ");
        }
    }
}
