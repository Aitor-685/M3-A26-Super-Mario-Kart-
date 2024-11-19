data class Character(
    val Categoria: String,
    val Personatge: String,
    val Velocitat: String,
    val Acceleracio: String,
    val Pes: String,
    val Maneig: String,
    val Adherencia: String
)

fun main() {
    val personatges = arrayOf(
        Character("Lleugers", "Toad", "Baixa", "Alta", "Baix", "Alt", "Alta"),
        Character("Lleugers", "Baby Mario", "Baixa", "Alta", "Baix", "Alt", "Alta"),
        Character("Lleugers", "Koopa Troopa", "Baixa", "Alta", "Baix", "Alt", "Alta"),
        Character("Mitjans", "Mario", "Mitjana", "Mitjana", "Mitjà", "Mitjà", "Mitjana"),
        Character("Mitjans", "Luigi", "Mitjana", "Mitjana", "Mitjà", "Mitjà", "Mitjana"),
        Character("Mitjans", "Peach", "Mitjana", "Mitjana", "Mitjà", "Mitjà", "Mitjana"),
        Character("Mitjans", "Daisy", "Mitjana", "Mitjana", "Mitjà", "Mitjà", "Mitjana"),
        Character("Pesats", "Bowser", "Alta", "Baixa", "Alt", "Baix", "Mitjana"),
        Character("Pesats", "Wario", "Alta", "Baixa", "Alt", "Baix", "Mitjana"),
        Character("Pesats", "Donkey Kong", "Alta", "Baixa", "Alt", "Baix", "Mitjana")
    )

    println("*************************************************************************************")
    println("Benvingut al codi, escull alguna de les opcions que vols.")
    println("*************************************************************************************")

    // Menú principal
    while (true) {
        println("--- Menú ---")
        println("a. Mostrar taula")
        println("b. Mostrar personatges")
        println("c. Mostrar categories")
        println("d. Mostrar personatges segons...")
        println("e. Cercar personatge")
        println("f. Sortir")
        print("Escull una opció: ")

        when (readlnOrNull()?.trim()?.lowercase()) {
            "a" -> mostrarTaula(personatges)
            "b" -> mostrarPersonatges(personatges)
            "c" -> mostrarCategories(personatges)
            "d" -> mostrarPersonatgesPer(personatges)
            "e" -> cercarPersonatge(personatges)
            "f" -> {
                println("Sortint del programa.")
                break
            }
            else -> println("Opció no vàlida. Torna-ho a intentar.")
        }
    }
}

// Mostrar taula con toda la información
fun mostrarTaula(personatges: Array<Character>) {
    // Encabezado con un formato bonito (uso de mayúsculas para destacar)
    println(String.format("| %-10s | %-15s | %-12s | %-15s | %-10s | %-10s | %-10s |",
        "Categoria", "Personatges", "Velocitat", "Acceleració", "Pes", "Maneig", "Adherència"))

    // Imprimir una línea de separación después del encabezado
    println("---------------------------------------------------------------------------------------------------------")

    // Imprimir los datos con el mismo formato
    personatges.forEach {
        println(String.format("| %-10s | %-15s | %-12s | %-15s | %-10s | %-10s | %-10s |",
            it.Categoria,
            it.Personatge,
            it.Velocitat,
            it.Acceleracio,
            it.Pes,
            it.Maneig,
            it.Adherencia))
    }
}


// Mostrar los personajes de cada categoría
fun mostrarPersonatges(personatges: Array<Character>) {
    personatges.forEach {
        println(it.Personatge.uppercase())
    }
}

// Mostrar las categorías disponibles
fun mostrarCategories(personatges: Array<Character>) {
    // Utilizamos `distinct()` para evitar mostrar categorías repetidas
    val categories = personatges.map { it.Categoria }.distinct()

    // Mostramos las categorías sin duplicados
    categories.forEach {
        println(it)
    }
}

// Mostrar personajes según una característica
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
                println("Quina velocitat vols (Alta, Mitjana, Baixa)?")
                val velocitat = readlnOrNull()?.trim()
                if (velocitat in listOf("Alta", "Mitjana", "Baixa")) {
                    val personatgesFiltrats = personatges.filter { it.Velocitat == velocitat }
                    if (personatgesFiltrats.isNotEmpty()) {
                        println("Personatges amb velocitat $velocitat:")
                        personatgesFiltrats.forEach {
                            println(it.Personatge)
                        }
                    } else {
                        println("No hi ha personatges amb velocitat $velocitat.")
                    }
                } else {
                    println("Valor de velocitat no vàlid.")
                }
            }

            "ii" -> {
                println("Quina acceleració vols (Alta, Mitjana, Baixa)?")
                val acceleracio = readlnOrNull()?.trim()
                if (acceleracio in listOf("Alta", "Mitjana", "Baixa")) {
                    val personatgesFiltrats = personatges.filter { it.Acceleracio == acceleracio }
                    if (personatgesFiltrats.isNotEmpty()) {
                        println("Personatges amb acceleració $acceleracio:")
                        personatgesFiltrats.forEach {
                            println(it.Personatge)
                        }
                    } else {
                        println("No hi ha personatges amb acceleració $acceleracio.")
                    }
                } else {
                    println("Valor d'acceleració no vàlid.")
                }
            }

            "iii" -> {
                println("Quin pes vols (Alt, Mitjà, Baix)?")
                val pes = readlnOrNull()?.trim()
                if (pes in listOf("Alt", "Mitjà", "Baix")) {
                    val personatgesFiltrats = personatges.filter { it.Pes == pes }
                    if (personatgesFiltrats.isNotEmpty()) {
                        println("Personatges amb pes $pes:")
                        personatgesFiltrats.forEach {
                            println(it.Personatge)
                        }
                    } else {
                        println("No hi ha personatges amb pes $pes.")
                    }
                } else {
                    println("Valor de pes no vàlid.")
                }
            }

            "iv" -> {
                println("Quin maneig vols (Alt, Mitjà, Baix)?")
                val maneig = readlnOrNull()?.trim()
                if (maneig in listOf("Alt", "Mitjà", "Baix")) {
                    val personatgesFiltrats = personatges.filter { it.Maneig == maneig }
                    if (personatgesFiltrats.isNotEmpty()) {
                        println("Personatges amb maneig $maneig:")
                        personatgesFiltrats.forEach {
                            println(it.Personatge)
                        }
                    } else {
                        println("No hi ha personatges amb maneig $maneig.")
                    }
                } else {
                    println("Valor de maneig no vàlid.")
                }
            }

            "v" -> {
                println("Quina adherència vols (Alta, Mitjana, Baixa)?")
                val adherencia = readlnOrNull()?.trim()
                if (adherencia in listOf("Alta", "Mitjana", "Baixa")) {
                    val personatgesFiltrats = personatges.filter { it.Adherencia == adherencia }
                    if (personatgesFiltrats.isNotEmpty()) {
                        println("Personatges amb adherència $adherencia:")
                        personatgesFiltrats.forEach {
                            println(it.Personatge)
                        }
                    } else {
                        println("No hi ha personatges amb adherència $adherencia.")
                    }
                } else {
                    println("Valor d'adherència no vàlid.")
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


// Función para buscar un personaje por nombre
fun cercarPersonatge(personatges: Array<Character>) {
    print("Escriu el nom del personatge: ")
    val nom = readlnOrNull()?.trim()?.lowercase()

    // Filtrar el personaje por nombre
    val resultat = personatges.filter {
        it.Personatge.lowercase().contains(nom ?: "")
    }

    if (resultat.isNotEmpty()) {
        println("Personatge trobat:")
        resultat.forEach {
            println("${it.Personatge} - Categoria: ${it.Categoria}")
            println("Velocitat: ${it.Velocitat}, Acceleració: ${it.Acceleracio}, Pes: ${it.Pes}, Maneig: ${it.Maneig}, Adherència: ${it.Adherencia}")
        }
    } else {
        println("No s'ha trobat cap personatge amb aquest nom.")
    }
}