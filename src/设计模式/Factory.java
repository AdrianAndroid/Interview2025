package 设计模式;

public class Factory {
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

    abstract class _Factory {
        public abstract Product createProduct();
    }

    class ConcreteFactoryA extends _Factory {
        @Override
        public Product createProduct() {
            return new ConcreteProductA();
        }
    }

    class ConcreteFactoryB extends _Factory {
        @Override
        public Product createProduct() {
            return new ConcreteProductB();
        }
    }

    public static void main(String[] args) {

        _Factory factoryA = new Factory().new ConcreteFactoryA();
        _Factory factoryB = new Factory().new ConcreteFactoryB();

        Product productA = factoryA.createProduct();
        Product productB = factoryB.createProduct();

        productA.use();
        productB.use();
    }
}
