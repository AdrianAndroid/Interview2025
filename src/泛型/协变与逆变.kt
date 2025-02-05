package 泛型

// 定义一个协变的泛型接口
interface Producer<out T> {
    fun produce(): T
}

// 实现 Producer 接口
class StringProducer : Producer<String> {
    override fun produce(): String {
        return "Hello, Kotlin!"
    }
}

fun main() {
    val stringProducer: Producer<String> = StringProducer()
    // 协变允许将 Producer<String> 赋值给 Producer<Any>
    val anyProducer: Producer<Any> = stringProducer
    val result: Any = anyProducer.produce()
    println(result)

    val anyConsumer: Consumer<Any> = AnyConsumer()
    // 逆变允许将 Consumer<Any> 赋值给 Consumer<String>
    val stringConsumer: Consumer<String> = anyConsumer
    stringConsumer.consume("Hello")
}

// 定义一个逆变的泛型接口
interface Consumer<in T> {
    fun consume(item: T)
}

// 实现 Consumer 接口
class AnyConsumer : Consumer<Any> {
    override fun consume(item: Any) {
        println("Consumed: $item")
    }
}