package 泛型

fun main() {
    // 创建一个存储 Int 类型的容器实例
    val intContainer = Container(10)
    val intValue = intContainer.getItem()
    println("存储的整数是: $intValue")

    // 创建一个存储 String 类型的容器实例
    val stringContainer = Container("Hello, Kotlin!")
    val stringValue = stringContainer.getItem()
    println("存储的字符串是: $stringValue")


    val pair = Pair(1, "One")
    val firstValue = pair.getFirst()
    val secondValue = pair.getSecond()
    println("第一个元素: $firstValue，第二个元素: $secondValue")

    val book = Book("Kotlin in Action")
    val printer = Printer(book)
    printer.printItemInfo()
}

class Container<T>(private val item: T) {
    fun getItem(): T {
        return item
    }
}

class Pair<T, U>(private val first: T, private val second: U) {
    fun getFirst(): T {
        return first
    }

    fun getSecond(): U {
        return second
    }
}


// 定义一个接口
interface Printable {
    fun printInfo()
}

// 泛型类，要求类型参数 T 必须实现 Printable 接口
class Printer<T : Printable>(private val item: T) {
    fun printItemInfo() {
        item.printInfo()
    }
}

// 实现 Printable 接口的类
class Book(val title: String) : Printable {
    override fun printInfo() {
        println("Book title: $title")
    }
}
