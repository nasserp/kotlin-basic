//Advance functions

fun printFilterList(list: List<String>, predicate: ((String) -> Boolean)?) {
    list.forEach {
       if (predicate?.invoke(it)==true){
           println(it)
       }
    }
}

val predicate1: (String) -> Boolean = { it.startsWith("K") }

fun predicate2(): (String) -> Boolean = { it.startsWith("K") }



fun main(){
    val list = listOf("Kotlin", "java")
    printFilterList(list,predicate1)
    printFilterList(list,null)
    printFilterList(list,predicate2())
}