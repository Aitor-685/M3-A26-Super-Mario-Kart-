fun main() {
    val personatges = arrayOf(
        Character("Lleugers","Toad, Baby Mario, koopa Troopa", "Baixa", "Alta", "Baix", "Alt", "Alta"),
        Character("Mitjans","Mario, Luigi, Peach, Daisy", "Mitjana", "Mitjana", "Mitjà", "Mitjà", "Mitjana"),
        Character("Pesats","Bowser,Wario, Donkey Kong", "Alta", "Baixa", "Alt", "Baix", "Mitjana")
    )

    println("*************************************************************************************")
    println("Bienvenido al codigo, escoge alguna de la opcines que quieras, un gusto en conocerlo.")
    println("*************************************************************************************")
    //La lista con las opciones que puede escojer el usuario
    while (true) {
        println("--- Menú ---")
        println("a. Mostrar taula")
        println("b. Mostrar personatges")
        println("c. Mostrar categories")
        println("d. Mostrar personatges segons")
        println("e. Cercar personatge")
        println("f. Sortir")
        print("Escull una opció: ")

        //Depenent de la opcion que tries et tornarà un valor o un altre
        when (readlnOrNull()?.trim()?.lowercase()) {
            "a" -> mostrarTaula(personatges)
            "b" -> mostrarPersonatges(personatges)
            "c" -> mostrarCategories(personatges)
            "d" -> mostrarPersonatgesPer(personatges)
            "f" -> {
                println("Sortint del programa.")
                break
            }
            else -> println("Opció no vàlida. Torna-ho a intentar.")
        }
    }
}

data class Character(
    val Categoria: String,
    val Personatges: String,
    val Velocitat: String,
    val Acceleracio: String,
    val Pes: String,
    val Maneig: String,
    val Adherencia: String
)

fun mostrarTaula(personatges: Array<Character>) {
    println("Categoria\tPersonatges\tVelocitat\tAcceleració\tPes\tManeig\tAdherència")
    personatges.forEach {
        println("${it.Categoria}\t${it.Personatges}\t${it.Velocitat}\t${it.Acceleracio}\t${it.Pes}\t${it.Maneig}\t${it.Adherencia}")
    }
}

fun mostrarPersonatges(personatges: Array<Character>) {
    personatges.forEach {
        println(it.Personatges)
    }
}

fun mostrarCategories(personatges: Array<Character>) {
    personatges.forEach {
        println(it.Categoria)
    }
}

fun mostrarPersonatgesPer(personatges: Array<Character>) {
    while (true) {
        println("--- Menú de Personatges segons ---")
        println("i. Velocitat")
        println("ii. Acceleració")
        println("iii. Pes")
        println("iv. Maneig")
        println("v. Adherència")
        println("vi. Sortir")
        print("Escull una opció: ")

        when (readlnOrNull()) {
            "i" -> {
                println("Personatges\tVelocitat")
                personatges.forEach {
                    println("${it.Personatges}\t${it.Velocitat}")
                }
            }

            "ii" -> {
                println("Personatges\tAcceleració")
                personatges.forEach {
                    println("${it.Personatges}\t${it.Acceleracio}")
                }
            }

            "iii" -> {
                println("Personatges\tPes")
                personatges.forEach {
                    println("${it.Personatges}\t${it.Pes}")
                }
            }

            "iv" -> {
                println("Personatges\tManeig")
                personatges.forEach {
                    println("${it.Personatges}\t${it.Maneig}")
                }
            }

            "v" -> {
                println("Personatges\tAdherència")
                personatges.forEach {
                    println("${it.Personatges}\t${it.Adherencia}")
                }
            }

            "vi" -> {
                println("Tornant al menú principal...")
                break
            }

            else -> println("Opció no vàlida. Torna-ho a intentar.")
        }
    }
}
