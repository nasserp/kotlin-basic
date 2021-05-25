fun main() {
    val list = listOf("Ko", "Ja",null)
    list
        .filterNotNull()
//        .first()
//        .last()
//        .findLast{it.startsWith("J")}.orEmpty()
        //.filter{it.startsWith("k")}
       // .map{it.length}
        //.take(1)
        //.takeLast(3)
        .associate { it to it.length  }
        .forEach { println("${it.key}, ${it.value}") }


}