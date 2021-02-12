package NyetHack

fun main(args: Array<String>) {
    val name = "madrigal"
    var healthPoints = 89
    val isBlessed = true
    val isImmortal = false

    //Aura
    val auraColor = auraColor(isBlessed, healthPoints, isImmortal)
    val healthStatus = formatHealthStatus(healthPoints, isBlessed)

    // 플레이어 상태 출력
    printPlayerStatus(auraColor, isBlessed, name, healthStatus)

    castFireball()
}

fun shouldReturnAString() :String {
    TODO("We shoule return a String here.")
    println("We shoule return a String here.")
}

private fun printPlayerStatus(
    auraColor: String,
    isBlessed: Boolean,
    name: String,
    healthStatus: String
) {
    println(
        "(Aura : $auraColor)" +
                "(Blessed: ${if (isBlessed) "YES" else "NO"})"
    )
    println("$name$healthStatus")
}

private fun auraColor(isBlessed: Boolean, healthPoints: Int, isImmortal: Boolean): String {
    val auraVisible = isBlessed && healthPoints >= 50 || isImmortal
    val auraColor = if (auraVisible) "GREEN" else "NONE"
    return auraColor
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

private fun formatHealthStatus2(healthPoints: Int, isBlessed: Boolean) =
    when (healthPoints) {
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


private fun castFireball(numFireballs: Int = 2) {
    println("한 덩어리의 파이어볼이 나타난다. (x$numFireballs)")
}

private fun castFireball2(numFireballs: Int = 2) =
    println("한 덩어리의 파이어볼이 나타난다. (x$numFireballs)")