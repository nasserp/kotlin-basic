import java.util.*

/*Companion Object شی همراه  */


interface IdProvider{
   fun getId():String
}


class Entity(val id:String){

//    companion object  {
//        fun create()=Entity("id")
//    }

    companion object Factory : IdProvider {
        const val id = "id"
        fun create()=Entity(id)

        override fun getId(): String {
            return "123"
        }
    }
}


/* Object Declaration
* Threat Safe Single  */
object EntityFactoryB{
    fun create()=EntityB("id","nasser")
}

class EntityB(val id:String, val name:String){
    override fun toString(): String {
        return "id:$id name:$name"
    }
}


/*Enum*/
enum class EntityType{
    HELP, EASY, MEDIUM, HARD;

    fun getFormattedName()= name.lowercase(Locale.getDefault())
        .replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
}

object EntityFactoryC{
    fun create(type: EntityType) :EntityC {
        val id=UUID.randomUUID().toString()
        val name=when(type){
            EntityType.EASY -> type.name
            EntityType.MEDIUM -> type.getFormattedName()
            EntityType.HARD -> "Hard"
            EntityType.HELP -> "Help"
        }
        return EntityC(id,name)
    }
}

class EntityC(val id:String, val name:String){
    override fun toString(): String {
        return "id:$id name:$name"
    }
}


/* sealed class*/
sealed class EntityD(){
    object Help: EntityD() {
        val name="Help"
    }
    data class Easy(val id:String, val name:String): EntityD()
    data class Medium(val id:String, val name:String): EntityD()
    data class Hard(val id:String, val name:String , val multiplier :Float): EntityD()
}

object EntityFactoryD{
    fun create(type: EntityType) :EntityD {
        val id=UUID.randomUUID().toString()
        val name=when(type){
            EntityType.EASY -> type.name
            EntityType.MEDIUM -> type.getFormattedName()
            EntityType.HARD -> "Hard"
            EntityType.HELP -> type.getFormattedName()
        }
        return when(type){
            EntityType.EASY -> EntityD.Easy(id, name)
            EntityType.MEDIUM -> EntityD.Medium(id, name)
            EntityType.HARD -> EntityD.Hard(id, name, 2f)
            EntityType.HELP -> EntityD.Help
        }
    }
}

fun EntityD.Medium.printInfo(){
    println("medium class: $id")
}
val EntityD.Medium.info: String
    get() = "some info"


fun main(){
    //val entity=Entity("id")
    //val entity=Entity.create();
    val entity=Entity.Factory.create();
    println(Entity.id)
    println(Entity.getId())

    val entityB=EntityFactoryB.create();
    println(entityB)


    val mediumEntity=EntityFactoryC.create(EntityType.MEDIUM)
    println(mediumEntity)

    val entityD=EntityFactoryD.create(EntityType.EASY)
    val entityE=EntityD.Easy("id","name")
    val entityECopy=entityE.copy(name="name2")
    val msg=when(entityD){
        is EntityD.Easy -> "easy class"
        is EntityD.Medium -> "Medium class"
        is EntityD.Hard -> "Hard class"
        is EntityD.Help -> "Help class"
    }
    println(msg)

    val entityDMedium=EntityD.Medium("id1","name1");
    entityDMedium.printInfo()
    println(entityDMedium.info)
}




