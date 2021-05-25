class FancyInfoProvider : BasicInfoProvider(){
    override val providerInf: String
        get() = "fancy info proveider"

    override fun printInfo(person: Person) {
        super.printInfo(person)
        println("Fancy Info")
    }

    override val sessionIdPrefix: String
        get() = "Fancy Session"
}