import kotlin.system.exitProcess

// Definindo a classe Pet
class Pet(var name: String) {
    var hungerLevel: Int = 50
    var happinessLevel: Int = 100
    var tirednessLevel: Int = 0
    var age: Int = 0
    var bathroomNeed: Int = 0
    var dirtLevel: Int = 0

    // fun para alimentar o bichinho
    fun feed(amount: Int) {
        hungerLevel -= amount
        if (hungerLevel < 0) hungerLevel = 0
        bathroomNeed += 5 // Aumenta a vontade de ir ao banheiro
        println("$name foi alimentado! Nível de fome: $hungerLevel")
    }

    // fun para brincar com o bichinho
    fun play(amount: Int) {
        happinessLevel += amount
        tirednessLevel += 10 // Aumenta o cansaço
        dirtLevel += 5 // Aumenta a sujeira
        if (happinessLevel > 100) happinessLevel = 100
        println("$name brincou! Nível de felicidade: $happinessLevel")
    }

    // fun para descansar o bichinho
    fun rest(hours: Int) {
        tirednessLevel -= hours * 10
        if (tirednessLevel < 0) tirednessLevel = 0
        println("$name descansou por $hours horas. Nível de cansaço: $tirednessLevel")
    }

    // fun para verificar o status do bichinho
    fun checkStatus() {
        println("Status do $name:")
        println("Nível de fome: $hungerLevel")
        println("Nível de felicidade: $happinessLevel")
        println("Nível de cansaço: $tirednessLevel")
        println("Idade: $age")
        println("Vontade de ir ao banheiro: $bathroomNeed")
        println("Nível de sujeira: $dirtLevel")
    }

    // fun para passar o tempo
    fun passTime() {
        age += 1
        hungerLevel += 3
        happinessLevel -= 3
        tirednessLevel += 10
        bathroomNeed += 5
        dirtLevel += 5

        // Verifica se o bichinho "perdeu"
        if (hungerLevel >= 100 || tirednessLevel >= 100 || happinessLevel <= 0) {
            println("O $name não sobreviveu! Jogo encerrado.")
            exitProcess(0)
        }
    }
}

// Função principal
fun main() {
    println("Bem-vindo ao simulador de bichinho virtual!")
    print("Qual o nome do seu bichinho? ")
    val petName = readLine() ?: "Pet"
    val pet = Pet(petName)

    while (true) {
        println("\nMenu:")
        println("1. Alimentar o bichinho")
        println("2. Brincar com o bichinho")
        println("3. Descansar o bichinho")
        println("4. Verificar status do bichinho")
        println("5. Sair do jogo")

        print("Escolha uma opção: ")
        val choice = readLine()

        when (choice) {
            "1" -> {
                print("Quanto você deseja alimentar? ")
                val amount = readLine()?.toIntOrNull() ?: 0
                pet.feed(amount)
            }
            "2" -> {
                print("Quanto tempo você deseja brincar? ")
                val amount = readLine()?.toIntOrNull() ?: 0
                pet.play(amount)
            }
            "3" -> {
                print("Quantas horas o bichinho deve descansar? ")
                val hours = readLine()?.toIntOrNull() ?: 0
                pet.rest(hours)
            }
            "4" -> pet.checkStatus()
            "5" -> {
                println("Obrigado por brincar com $petName!")
                return
            }
            else -> println("Opção inválida, tente novamente.")
        }

        // Passa o tempo após cada ação
        pet.passTime()
    }
}
