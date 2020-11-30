package lambdasinaction.chap9;

/**
 * 9.1.1 初始版本API
 *
 * @param null
 * @return 
 * @throw 
 *
 * @author wangyh2
 * @since  2020/11/25 10:52 
 */
public interface Resizable extends Drawable{
    public int getWidth();
    public int getHeight();
    public void setWidth(int width);
    public void setHeight(int height);
    public void setAbsoluteSize(int width, int height);
    //TODO: uncomment, read the README for instructions
    //public void setRelativeSize(int widthFactor, int heightFactor);
}

