package lambdasinaction.chap9;

/**
 * 9.4 菱形继承问题
 *
 * @param null
 * @return 
 * @throw 
 *
 * @author wangyh2
 * @since  2020/11/25 13:16 
 */
public class Diamond{

    public static void main(String...args){
        new D().hello();
    }

    static interface A{
        public default void hello(){
            System.out.println("Hello from A");
        }
    }

    static interface B extends A { }

    static interface C extends A {
    }

    static class D implements B, C {

    }
}
