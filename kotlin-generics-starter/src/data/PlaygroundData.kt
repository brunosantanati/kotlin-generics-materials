package data

open class Animal(open val id: Int, open val name: String)

data class Dog(override val id: Int, override val name: String, val furColor: FurColor) : Animal(id, name)

data class Cat(override val id: Int, override val name: String, val eyesColor: EyesColor) : Animal(id, name)

abstract class Bird(override val id: Int, override val name: String, open val featherColor: FeatherColor) : Animal(id, name)

data class Canary(override val id: Int, override val name: String, override val featherColor: FeatherColor, val tweetPitch: Int) : Bird(id, name, featherColor)

data class Eagle(override val id: Int, override val name: String, override val featherColor: FeatherColor, val maxSpeed: Float) : Bird(id, name, featherColor)

data class Penguin(override val id: Int, override val name: String, override val featherColor: FeatherColor, val age: Int) : Bird(id, name, featherColor)

enum class FurColor {
    WHITE, BLACK, BROWN, SPOTTED, PATCHED
}

enum class EyesColor {
    BLUE, GREEN, BROWN, YELLOWISH
}

enum class FeatherColor {
    YELLOW, RED, GREEN, WHITE
}
