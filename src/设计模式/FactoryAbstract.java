package 设计模式;

/**
 * 工厂抽象类
 */
public class FactoryAbstract {
    interface AbstractProductA {
        void methodA();
    }

    interface AbstractProductB {
        void methodB();
    }

    class ConcreteProductA1 implements AbstractProductA {
        @Override
        public void methodA() {
            System.out.println("使用产品A1");
        }
    }

    class ConcreteProductA2 implements AbstractProductA {
        @Override
        public void methodA() {
            System.out.println("使用产品A2");
        }
    }

    class ConcreteProductB1 implements AbstractProductB {
        @Override
        public void methodB() {
            System.out.println("使用产品B1");
        }
    }

    class ConcreteProductB2 implements AbstractProductB {
        @Override
        public void methodB() {
            System.out.println("使用产品B2");
        }
    }

    abstract class AbstractFactory {
        abstract AbstractProductA createProductA();
        abstract AbstractProductB createProductB();
    }

    class ConcreteFactory1 extends AbstractFactory {
        @Override
        AbstractProductA createProductA() {
            return new ConcreteProductA1();
        }

        @Override
        AbstractProductB createProductB() {
            return new ConcreteProductB1();
        }
    }

    class ConcreteFactory2 extends AbstractFactory {
        @Override
        AbstractProductA createProductA() {
            return new ConcreteProductA2();
        }

        @Override
        AbstractProductB createProductB() {
            return new ConcreteProductB2();
        }
    }

    public static void main(String[] args) {
        AbstractFactory factory1 = new FactoryAbstract().new ConcreteFactory1();
        AbstractProductA productA1 = factory1.createProductA();
        productA1.methodA();
        AbstractProductB productB1 = factory1.createProductB();
        productB1.methodB();

        AbstractFactory factory2 = new FactoryAbstract().new ConcreteFactory2();
        AbstractProductA productA2 = factory2.createProductA();
        productA2.methodA();
        AbstractProductB productB2 = factory2.createProductB();
        productB2.methodB();
    }
}
