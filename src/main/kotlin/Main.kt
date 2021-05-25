
const val name: String = "nate"
var greeting: String? = "hello"

fun main() {
    println("Hello Kotlin")
    println(name)
    greeting = null
    when (greeting) {
        null -> println("Hi Kotli")
        else -> println(greeting)
    }
    val greetingToPrint=when(greeting){
        null->"Hi"
        else->greeting

    }
    println(greetingToPrint)
    val greetingToPrint2=if(greeting ==null) "Hi" else greeting
    println(greetingToPrint2)
    println(getGreeting(null))
    println(getGreeting("Greeting1"))


    val person=Person("naser","panj")



}

fun getGreeting(world:String?):String=world?:"Hi"

fun sayHello(x:String="a", y:String="b"){
 println("$x$y")
}
fun sayGreeting(vararg params : String){
    params.forEach { println(it) }
}