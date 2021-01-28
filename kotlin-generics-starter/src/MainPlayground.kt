import data.*


public fun main() {

    val dog1: Animal = Dog(id = 0, name = "Swift", furColor = FurColor.BLACK)
    val dog2: Dog = Dog(id = 1, name = "Stu", furColor = FurColor.PATCHED)
    val cat1: Animal = Cat(id = 3, name = "Tuno", eyesColor = EyesColor.GREEN)

    val animal: Animal = cat1


    var dogList: List<Dog> = listOf()
    var animalList: List<Animal> = dogList   //This assignation is not valid in Java (not covariant)

    var dogMutableList: MutableList<Dog> = mutableListOf()
    var animalMutableList: MutableList<Animal> = dogMutableList   //This assignation fails as in Java (invariant)







    println("Done!")

}