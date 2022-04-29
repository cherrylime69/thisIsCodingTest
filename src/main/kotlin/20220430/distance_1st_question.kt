package `20220430`

// p258. 미래도시

fun main() {

    val (n, m) = readLine()!!.split(" ").map { it.toInt() }

    val graph = MutableList(n + 1) { MutableList(n + 1) { 1000 } }

    for (a in 1..m) {
        for (b in 1..m) {
            if (a == b) {
                graph[a][b] = 0
            }
        }
    }

    repeat(m) {
        val (a, b) = readLine()!!.split(" ").map { it.toInt() }
        graph[a][b] = 1
        graph[b][a] = 1
    }
    val (x, k) = readLine()!!.split(" ").map { it.toInt() }


    for (k in 1..m) {
        for (a in 1..m) {
            for (b in 1..m) {
                graph[a][b] = minOf(graph[a][b], graph[a][k] + graph[k][b])
            }
        }
    }

    val result = graph[1][k] + graph[k][x]

    if (result >= 1000)
        println(-1)
    else
        println(result)


}


/*
해설
데이터의 갯수가 100 밖에 안되므로 전형적인 플로이드 워셜 알고리즘 문제이다
양방향이기 때문에 서로 연결되어 있으면
graph[a][b] = 1
graph[b][a] = 1
처럼 각각 1씩 할당한다
시작점(1) -> 중간점 (k) -> 끝점(x) 의 의미는
1->k 가는 최단 경로 비용 + k->x 가는 최단 경로 비용이라는 뜻이다.
 */
