interface PersonInfoProvider{
    val providerInf:String

    fun printInfo(person :Person){
        println("printInfp")
    }
}

interface SessionInfoProvider {
    fun getSessionId(): String
}


open class BasicInfoProvider:PersonInfoProvider ,SessionInfoProvider{

    override val providerInf: String
        get() = "BssicInfoProvider"

    open val sessionIdPrefix = "Session"

    override fun printInfo(person: Person) {
        super.printInfo(person)
        println("assitional printInfo")
    }

    override fun getSessionId(): String {
       return sessionIdPrefix
    }
}


fun main(){
    val provider=BasicInfoProvider()
    provider.printInfo(Person())

    val providerF=FancyInfoProvider()
    println(providerF.providerInf)
    println(providerF.sessionIdPrefix)

    val providerO = object : PersonInfoProvider{
        override val providerInf: String
            get() = "New Info provider"

        fun getSessionId()="id"
    }
    providerO.getSessionId()

    checkTypes(provider)
}

fun checkTypes(infoProvider :PersonInfoProvider){
    if(infoProvider !is SessionInfoProvider){
        print("is not a session info provider")
    }else
    {
        println("is  a session info provider")
        (infoProvider as SessionInfoProvider).getSessionId()

    }

}

