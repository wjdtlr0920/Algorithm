package com.js.algorithm

import android.os.Build.VERSION_CODES.N
import kotlinx.coroutines.yield
import org.junit.Test
import java.util.*
import kotlin.math.sqrt

class Level2 {

  /**
   * 멀리 뛰기
   * 문제 설명
   * 효진이는 멀리 뛰기를 연습하고 있습니다. 효진이는 한번에 1칸, 또는 2칸을 뛸 수 있습니다. 칸이 총 4개 있을 때, 효진이는
   * (1칸, 1칸, 1칸, 1칸)
   * (1칸, 2칸, 1칸)
   * (1칸, 1칸, 2칸)
   * (2칸, 1칸, 1칸)
   * (2칸, 2칸)
   * 의 5가지 방법으로 맨 끝 칸에 도달할 수 있습니다. 멀리뛰기에 사용될 칸의 수 n이 주어질 때, 효진이가 끝에 도달하는 방법이 몇 가지인지 알아내, 여기에 1234567를 나눈 나머지를 리턴하는 함수, solution을 완성하세요. 예를 들어 4가 입력된다면, 5를 return하면 됩니다.
   *
   * 제한 사항
   * n은 1 이상, 2000 이하인 정수입니다.
   * 입출력 예
   * n	result
   * 4	5
   * 3	3
   * 입출력 예 설명
   * 입출력 예 #1
   * 위에서 설명한 내용과 같습니다.
   *
   * 입출력 예 #2
   * (2칸, 1칸)
   * (1칸, 2칸)
   * (1칸, 1칸, 1칸)
   * 총 3가지 방법으로 멀리 뛸 수 있습니다.
   */

  @Test
  fun algorithm1() {
    // TODO 계산식이 있을 것 같은데 어떤 계산식으로 풀어야 할지 모르겠음
    fun solution(n: Int): Long {
      var answer: Long = 0
      return answer
    }
    println(solution(4)) // 5
    println(solution(3)) // 3
  }

  /**
   * 최댓값과 최솟값
   * 문제 설명
   * 문자열 s에는 공백으로 구분된 숫자들이 저장되어 있습니다. str에 나타나는 숫자 중 최소값과 최대값을 찾아 이를 "(최소값) (최대값)"형태의 문자열을 반환하는 함수, solution을 완성하세요.
   * 예를들어 s가 "1 2 3 4"라면 "1 4"를 리턴하고, "-1 -2 -3 -4"라면 "-4 -1"을 리턴하면 됩니다.
   *
   * 제한 조건
   * s에는 둘 이상의 정수가 공백으로 구분되어 있습니다.
   * 입출력 예
   * s	return
   * "1 2 3 4"	"1 4"
   * "-1 -2 -3 -4"	"-4 -1"
   * "-1 -1"	"-1 -1"
   */

  @Test
  fun algorithm2() {
    fun solution2(s: String): String = s.split(" ").map { it.toInt() }.let { "${it.min()} ${it.max()}" }
    fun solution(s: String) = s.let { ss -> "${ss.split(" ").map { it.toInt() }.minByOrNull { it }} ${ss.split(" ").map { it.toInt() }.maxByOrNull { it }}" }
    println(solution("1 2 3 4")) // "1 4"
    println(solution("-1 -2 -3 -4")) // "-4 -1"
    println(solution("-1 -1")) // "-1 -1"
  }

  /**
   * 피보나치 수
   * 문제 설명
   * 피보나치 수는 F(0) = 0, F(1) = 1일 때, 1 이상의 n에 대하여 F(n) = F(n-1) + F(n-2) 가 적용되는 수 입니다.
   *
   * 예를들어
   *
   * F(2) = F(0) + F(1) = 0 + 1 = 1
   * F(3) = F(1) + F(2) = 1 + 1 = 2
   * F(4) = F(2) + F(3) = 1 + 2 = 3
   * F(5) = F(3) + F(4) = 2 + 3 = 5
   * 와 같이 이어집니다.
   *
   * 2 이상의 n이 입력되었을 때, n번째 피보나치 수를 1234567으로 나눈 나머지를 리턴하는 함수, solution을 완성해 주세요.
   *
   * 제한 사항
   * n은 2 이상 100,000 이하인 자연수입니다.
   * 입출력 예
   * n	return
   * 3	2
   * 5	5
   * 입출력 예 설명
   * 피보나치수는 0번째부터 0, 1, 1, 2, 3, 5, ... 와 같이 이어집니다.
   *
   * 문제가 잘 안풀린다면😢
   * 힌트가 필요한가요? [코딩테스트 연습 힌트 모음집]으로 오세요! → 클릭
   */

  @Test
  fun algorithm3() {
    fun solution(n: Int): Int {
      var prev = 0L
      var next = 0L
      for (i in 0..n) {
        if (i % 2 == 0) prev += next  else next += prev
        if (i == 1) prev = 1
      }
      return ((prev + next) % 1234567L).toInt()
    }

    println(solution(3)) // 2
    println(solution(5)) // 5
    println(solution(20)) // 5
  }

  /**
   * 하노이의 탑
   * 문제 설명
   * 하노이 탑(Tower of Hanoi)은 퍼즐의 일종입니다. 세 개의 기둥과 이 기동에 꽂을 수 있는 크기가 다양한 원판들이 있고, 퍼즐을 시작하기 전에는 한 기둥에 원판들이 작은 것이 위에 있도록 순서대로 쌓여 있습니다. 게임의 목적은 다음 두 가지 조건을 만족시키면서, 한 기둥에 꽂힌 원판들을 그 순서 그대로 다른 기둥으로 옮겨서 다시 쌓는 것입니다.
 *
   * 한 번에 하나의 원판만 옮길 수 있습니다.
   * 큰 원판이 작은 원판 위에 있어서는 안됩니다.
   * 하노이 탑의 세 개의 기둥을 왼쪽 부터 1번, 2번, 3번이라고 하겠습니다. 1번에는 n개의 원판이 있고 이 n개의 원판을 3번 원판으로 최소 횟수로 옮기려고 합니다.
 *
   * 1번 기둥에 있는 원판의 개수 n이 매개변수로 주어질 때, n개의 원판을 3번 원판으로 최소로 옮기는 방법을 return하는 solution를 완성해주세요.
 *
   * 제한사항
   * n은 15이하의 자연수 입니다.
 *
   * 입출력 예
   * n	result
   * 2	[ [1,2], [1,3], [2,3] ]
   * 입출력 예 설명
   * 입출력 예 #1
   * 다음과 같이 옮길 수 있습니다.
   */

  @Test
  fun algorithm4() {
    // TODO 어케 짜야 할지 모르겠음..
    fun solution(n: Int): Array<IntArray> {
      var answer = arrayOf<IntArray>()
      return answer
    }

    println(solution(2)) // [1,2], [1,3], [2,3]
  }

}