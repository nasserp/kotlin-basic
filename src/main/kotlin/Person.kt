class Person(val firstName: String = "nasser", val lastName: String = "panjehpoor") {

    init {
        println("init 1")
    }

    internal var nickName: String? = null
        set(value) {
            field = value
            println("The nickName is $field")
        }
        get() {
            return field
        }

}