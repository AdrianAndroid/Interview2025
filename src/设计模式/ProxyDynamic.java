package 设计模式;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ProxyDynamic {
    interface Subject {
        void doSomething();
    }

    class RealSubject implements ProxyDynamic.Subject {

        @Override
        public void doSomething() {
            System.out.println("RealSubject doSomething");
        }

    }

    class DynamicProxyHandler implements InvocationHandler {
        private Object object;

        public DynamicProxyHandler(Object object) {
            this.object = object;
        }

        @Override
        public Object invoke(Object proxy, java.lang.reflect.Method method, Object[] args) throws Throwable {
            System.out.println("代理主题预处理请求");
            Object result = method.invoke(object, args);
            System.out.println("代理主题后续处理请求");
            return result;
        }
    }

    /**
     * 主函数，程序入口
     *
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        // 创建真实主题对象
        RealSubject realSubject = new ProxyDynamic().new RealSubject();
        // 创建动态代理处理器，传入真实主题对象
        DynamicProxyHandler handler = new ProxyDynamic().new DynamicProxyHandler(realSubject);
        // 使用Proxy类的静态方法newProxyInstance创建代理对象
        // 第一个参数是类加载器，第二个参数是接口数组，第三个参数是调用处理器
        Subject subject = (Subject) Proxy.newProxyInstance(
                realSubject.getClass().getClassLoader(),
                realSubject.getClass().getInterfaces(),
                handler);
        // 通过代理对象调用真实主题的方法
        subject.doSomething();
    }

}
