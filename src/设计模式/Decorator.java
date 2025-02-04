package 设计模式;

public class Decorator {
    interface Subject{
        void request();
    }

    static class RealSubject implements Subject{
        @Override
        public void request() {
            System.out.println("RealSubject request");
        }
    }

    static class DecoratorSubject implements Subject{
        private RealSubject realSubject;
        @Override
        public void request() {
            if(realSubject == null){
                realSubject = new RealSubject();
            }
            System.out.println("代理主题预处理请求");
            realSubject.request();
            System.out.println("代理主题后续处理请求");
        }
    }

    public static void main(String[] args) {
        DecoratorSubject subject = new DecoratorSubject();
        subject.request();
    }
}
