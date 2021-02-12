package NyetHack

fun main(args: Array<String>) {
    val name:String
    name = "madrigal"
    var healthPoints:Int
    healthPoints= 89
    val isBlessed = true
    val isImmortal = false
    val auraVisible = isBlessed && healthPoints >= 50 || isImmortal
    val auraColor = if (auraVisible) "GREEN" else "NONE"

    val race = "gnome"

    val faction = when (race) {
        "dwarf" -> "Keepers of the Mines"
        "gnome" -> "Keepers of the MInes"
        "orc" -> "Free People of the Rolling Stones"
        "human" -> "Free People of the Rolling Stones"
        else -> "nothing"
    }


    val healthStatus = formatHealthStatus(healthPoints, isBlessed)

    // 플레이어 상태 출력
    println("$name$healthStatus")
    println(
        "(Aura : $auraColor)" +
                "(Blessed: ${if (isBlessed) "YES" else "NO"})"
    )
}

private fun formatHealthStatus(healthPoints: Int, isBlessed: Boolean): String {
    val healthStatus = when (healthPoints) {
        100 -> "는 최상의 상태이다."
        in 90..99 -> "는 약간의 철과상만 있음."
        in 75..89 -> if (isBlessed) {
            "는 경미한 상처가 있지만 빨리 치유된다."
        } else {
            "는 경미한 상처만 있음."
        }
        in 15..74 -> "는 많이 다친 것 같음."
        else -> "는 최악의 상태이다."
    }
    return healthStatus
}