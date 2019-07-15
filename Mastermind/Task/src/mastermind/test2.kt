package mastermind

/*fun main() {
    val list = listOf("Sergio", "Sebastian", "Ana", "Andres", "Pedro", "José", "Julio")

    val res = list.groupBy { it[0] }

    println(list)
    println(res)

    val otherList = listOf(listOf(1, 3, 6), listOf(3, 9, 8))
    val l = otherList.flatten()
    println(l)
}*/

enum class Gender { MALE, FAMALE }

data class Hero(val name: String, val age: Int, val gender: Gender?)

fun groupBy(heroes: List<Hero>) {
    val mapByAge = heroes.groupBy { it.age }
    val (age, group) = mapByAge.maxBy { (_, group) -> group.size }!!
    println(age)
}

fun partition(heroes: List<Hero>) {
    val (youngest, oldest) = heroes.partition { it.age < 30 }
}

fun filter(heroes: List<Hero>) {
    val count = heroes.filter { it.age < 30 }.size
    println(count)
}

fun map(heroes: List<Hero>) {
    val count = heroes.map { it.age }.distinct().size
    println(count)
}

fun associate(heroes: List<Hero>) {
    val mapByName = heroes.associate { it.name to it.age }
    println(mapByName.getOrElse("unknown") { 0 })
}

fun associateBy(heroes: List<Hero>) {
    val mapByName = heroes.associateBy { it.name }
    val unknownHero = Hero("Unkown", 0, null)

    println(mapByName["Frenchy"]?.age)
    println(mapByName.getOrElse("unkown") { unknownHero }.age)
}

fun locura(heroes: List<Hero>) {

    val allPossiblePairs = heroes
            .flatMap { first ->
                heroes.map { second -> first to second }
            }

    val (oldets, youngest) = allPossiblePairs
            .maxBy { it.first.age - it.second.age }!!

    println(oldets.name)
}

fun containsZero(list: List<Int>): Boolean {
    list.forEach {
        if (it == 0) return true
    }

    return false
}

fun duplicateNonZero(list: List<Int>): List<Int> {
    return list.flatMap {
        if (it == 0)
            listOf()
        else
            listOf(it, it)
    }
}

fun main() {
    val heroes = listOf(
            Hero("The Captain", 60, Gender.MALE),
            Hero("Frenchy", 42, Gender.MALE),
            Hero("The Kid", 9, null),
            Hero("Lady Lauren", 29, Gender.FAMALE),
            Hero("First Mate", 29, Gender.MALE),
            Hero("Sir Stephen", 37, Gender.MALE))

    // locura(heroes)
    // associateBy(heroes)
    //associate(heroes)

    val f1: () -> Int? = { null }
    val f2: (() -> Int)? = { 3 }

    val res = f2

    println(f1)
    val list = listOf(1, 3, 6, 9, 0, 7)
    println(containsZero(list))

    val duplicate = list.flatMap l@{
        if (it == 0) return@l listOf<Int>()
        listOf(it, it)
    }

    println(duplicateNonZero(listOf(3, 0, 5)))
}