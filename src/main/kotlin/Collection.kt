fun main() {

    val arrString= arrayOf("nasse","omid")
    for (str in arrString){
        println(str)
    }
    arrString.forEach { println(it) }

    arrString.forEachIndexed { index, s -> println("index is $index and str is $s")  }

    val interesting= listOf("nass","5")
    for (i in interesting){
        println(i)
    }

    val map= mapOf("1" to "1","2" to "2", 3 to 3)
    for (k in map.keys){
        println(k)
    }
    for (v in map.values){
        println(v)
    }
    for ((k,v) in map){
        println("$k *** $v")
    }
    map.forEach{ (k, v) ->  println("$k --- $v")}

    val mutableThing= mutableListOf<String>("na","eh")
    mutableThing.add("fi")
    for (m in mutableThing){
        println("++ $m")
    }

    val myArray= arrayOf("nass","firpp")
    sayGreeting("omin","ehsan")
    sayGreeting(*myArray)
    sayHello("b")

    val person=Person("naser","panj")



}