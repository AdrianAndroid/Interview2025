package 设计模式;

public class Proxy {
    interface Subject {
        void request();
    }

    static class RealSubject implements Subject {
        @Override
        public void request() {
            System.out.println("RealSubject request");
        }
    }

    static class ProxySubject implements Subject {
        private RealSubject realSubject;

        @Override
        public void request() {
            if (realSubject == null) {
                realSubject = new RealSubject();
            }
            realSubject.request();
        }
    }

    public static void main(String[] args) {
        ProxySubject subject = new ProxySubject();
        subject.request();
    }
}
