package lambdasinaction.chap9;


import java.util.Arrays;
import java.util.List;

/**
 * 9.1.1 游戏
 *
 * @param null
 * @return 
 * @throw 
 *
 * @author wangyh2
 * @since  2020/11/25 10:55 
 */
public class Game {

    public static void main(String...args){
        List<Resizable> resizableShapes =
                Arrays.asList(new Square(),
                        new Triangle(), new Ellipse());
        Utils.paint(resizableShapes);
    }
}

