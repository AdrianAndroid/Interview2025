package 设计模式;

public class FactorySimple {
    public void main(String[] args) {
        System.out.println("Hello world!");
        ConcreteProductA concreteProductA = new ConcreteProductA();
        concreteProductA.use();
        ConcreteProductB concreteProductB = new ConcreteProductB();
        concreteProductB.use();


        Factory factory = new Factory();
        Product productA = factory.createProduct("A");
        productA.use();
        Product productB = factory.createProduct("B");
        productB.use();
    }

    abstract class Product {
        public abstract void use();
    }

    class ConcreteProductA extends Product {
        @Override
        public void use() {
            System.out.println("使用产品A");
        }
    }

    class ConcreteProductB extends Product {
        @Override
        public void use() {
            System.out.println("使用产品B");
        }
    }

    class Factory {
        public Product createProduct(String type) {
            if (type.equals("A")) {
                return new ConcreteProductA();
            } else if (type.equals("B")) {
                return new ConcreteProductB();
            } else {
                return null;
            }
        }
    }
}
