package NyetHack


fun main(args: Array<String>) {

    // ### 함수타입
    // count를 활용한 익명함수
    val numLetters = "Mississippi".count({ letter ->
        letter == 's'
    })

    println({
        val currentYear = 2021
        "SimVillage 방문을 환영합니다. 촌장님! (copyright $currentYear)"
    }())

    // 익명 함수를 변수에 지정하기
    val greetingFunction: () -> String = {
        val currentYear = 2021
        "SimVillage 방문을 환영합니다, 촌장님! (copyright $currentYear)"
    }


    // 함수 인자
    val greetingFunction2: (String) -> String = { playername ->
        val currentYear = 2021
        "SimVillage 방문을 환영합니다, $playername 님! (copyright $currentYear)"

    }
    println(greetingFunction2("김선달"))

    // it 키워드
    val greetingFunction3: (String) -> String = {
        val currentYear = 2021
        "SimVillage 방문을 환영합니다, $it 님! (copyright $currentYear)"
    }
    println(greetingFunction3("김김이"))

    // it의 좋은 사용예
    val letterCount = "Mississippi".count({ it == 's' })

    // 두 번째 인자 받기
    val greetingFunction4: (String, Int) -> String = { playerName, numBuildings ->
        val currentYear = 2021
        println("$numBuildings 채의 건물이 추가됨")
        "SimVillage 방문을 환영합니다, $playerName 님! (copyright $currentYear)"
    }

    println(greetingFunction4("김김이", 3))

    // 타입 추론 지원
    val greetingFunction5 = {
        val currentYear = 2021
        "SimVillage 방문을 환영합니다, 촌장님! (copyright $currentYear)"
    }

    runSimulation("김선달", ::printConstructionCost) { playerName, numBuildings ->
        val currentYear = 2021
        println("$numBuildings 채의 건물이 추가됨")
        "SimVillage 방문을 환영합니다, $playerName 님! (copyright $currentYear)"
    }


    // 단축 문법
    "Mississippi".count({ it == 's' })
    "Mississippi".count { it == 's' }

    // 단축 문법으로 람다 전달하기
    introduceMyself("Emily", ::printBooksCost) { myName, books ->
        "$myName 는 오늘 $books 만큼의 책을 읽었습니다."
    }
}

fun runSimulation(
    playerName: String,
    costPrinter: (Int) -> Unit,
    greetingFunction6: (String, Int) -> String
) {
    val numBuildings = (1..3).shuffled().last()
    costPrinter(numBuildings)
    println(greetingFunction6(playerName, numBuildings))
}

fun printConstructionCost(numBuilding: Int) {
    val cost = 500
    println("건축 비용 : ${cost * numBuilding}")
}

// booksCost 매개변수 추가하기
inline fun introduceMyself(myName: String, booksCost: (Int) -> Unit, speakMyHobby: (String, Int) -> String) {
    val books = (1..10).shuffled().last()
    booksCost(books)
    println(speakMyHobby(myName, books))
}

// 책의 값을 출력하는 함수 printBooksCost 정의
fun printBooksCost(books: Int) {
    val cost = 1000
    println("총 책의 비용은 ${cost * books}원 입니다.")
}
