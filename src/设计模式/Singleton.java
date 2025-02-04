package 设计模式;

/**
 * 饿汉式
 */
public class Singleton {
    public static Singleton instance = new Singleton();
    private Singleton(){}

    public static Singleton getInstance() {
        return instance;
    }
}
