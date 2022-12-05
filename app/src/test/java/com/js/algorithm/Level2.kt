package com.js.algorithm

import android.os.Build.VERSION_CODES.N
import android.os.Build.VERSION_CODES.S
import kotlinx.coroutines.yield
import org.junit.Test
import java.math.BigInteger
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
    // TODO 

    // Top - Bottom
    fun topBottomSolution(n: Int): Long {
      tailrec fun topBottomTailRec(n: Int, result: Long = 1): Long = when (n) {
        1, 2 -> result
        else -> topBottomTailRec(n - 1, result + n)
      }

      return topBottomTailRec(n) + topBottomTailRec(n - 1)
    }

    // Bottom - Up
    fun bottomUpSolution(n: Int): Long = 0

    println(topBottomSolution(4)) // 5
    println(topBottomSolution(3)) // 3
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
        if (i % 2 == 0) prev += next else next += prev
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

  /**
   * 예상 대진표
   *
   * 문제 설명
   *
   * △△ 게임대회가 개최되었습니다. 이 대회는 N명이 참가하고, 토너먼트 형식으로 진행됩니다. N명의 참가자는 각각 1부터 N번을 차례대로 배정받습니다. 그리고, 1번↔2번, 3번↔4번, ... , N-1번↔N번의 참가자끼리 게임을 진행합니다. 각 게임에서 이긴 사람은 다음 라운드에 진출할 수 있습니다. 이때, 다음 라운드에 진출할 참가자의 번호는 다시 1번부터 N/2번을 차례대로 배정받습니다. 만약 1번↔2번 끼리 겨루는 게임에서 2번이 승리했다면 다음 라운드에서 1번을 부여받고, 3번↔4번에서 겨루는 게임에서 3번이 승리했다면 다음 라운드에서 2번을 부여받게 됩니다. 게임은 최종 한 명이 남을 때까지 진행됩니다.
   *
   * 이때, 처음 라운드에서 A번을 가진 참가자는 경쟁자로 생각하는 B번 참가자와 몇 번째 라운드에서 만나는지 궁금해졌습니다. 게임 참가자 수 N, 참가자 번호 A, 경쟁자 번호 B가 함수 solution의 매개변수로 주어질 때, 처음 라운드에서 A번을 가진 참가자는 경쟁자로 생각하는 B번 참가자와 몇 번째 라운드에서 만나는지 return 하는 solution 함수를 완성해 주세요. 단, A번 참가자와 B번 참가자는 서로 붙게 되기 전까지 항상 이긴다고 가정합니다.
   *
   * 제한사항
   * N : 21 이상 220 이하인 자연수 (2의 지수 승으로 주어지므로 부전승은 발생하지 않습니다.)
   * A, B : N 이하인 자연수 (단, A ≠ B 입니다.)
   * 입출력 예
   * N	A	B	answer
   * 8	4	7	3
   * 입출력 예 설명
   * 입출력 예 #1
   * 첫 번째 라운드에서 4번 참가자는 3번 참가자와 붙게 되고, 7번 참가자는 8번 참가자와 붙게 됩니다. 항상 이긴다고 가정했으므로 4번 참가자는 다음 라운드에서 2번이 되고, 7번 참가자는 4번이 됩니다. 두 번째 라운드에서 2번은 1번과 붙게 되고, 4번은 3번과 붙게 됩니다. 항상 이긴다고 가정했으므로 2번은 다음 라운드에서 1번이 되고, 4번은 2번이 됩니다. 세 번째 라운드에서 1번과 2번으로 두 참가자가 붙게 되므로 3을 return 하면 됩니다.
   */

  @Test
  fun algorithm5() {
    // TODO solution2 다른 사람이 푼건데 xor 연산으로 어떻게 답을 유추하는지 이해 불가...
    fun solution2(n: Int, a: Int, b: Int) = ((a - 1) xor (b - 1)).toString(2).length
    fun solution(n: Int, a: Int, b: Int): Int {

      var aNumber = a - 1
      var bNumber = b - 1
      var result = 0

      while (aNumber != bNumber) {
        result++
        aNumber /= 2
        bNumber /= 2
      }
      return result
    }
    println(solution(8, 4, 7)) // 3
  }

  /**
   * JadenCase 문자열 만들기
   *
   * 문제 설명
   *
   * JadenCase란 모든 단어의 첫 문자가 대문자이고, 그 외의 알파벳은 소문자인 문자열입니다. 단, 첫 문자가 알파벳이 아닐 때에는 이어지는 알파벳은 소문자로 쓰면 됩니다. (첫 번째 입출력 예 참고)
   * 문자열 s가 주어졌을 때, s를 JadenCase로 바꾼 문자열을 리턴하는 함수, solution을 완성해주세요.
   *
   * 제한 조건
   * s는 길이 1 이상 200 이하인 문자열입니다.
   * s는 알파벳과 숫자, 공백문자(" ")로 이루어져 있습니다.
   * 숫자는 단어의 첫 문자로만 나옵니다.
   * 숫자로만 이루어진 단어는 없습니다.
   * 공백문자가 연속해서 나올 수 있습니다.
   *
   * 입출력 예
   * s	return
   * "3people unFollowed me"	"3people Unfollowed Me"
   * "for the last week"	"For The Last Week"
   */

  @Test
  fun algorithm6() {
    fun solution(s: String) = s.split(" ").joinToString(" ") { if (it.isEmpty()) "" else "${(it[0].uppercase())}${it.substring(1).lowercase()}" }

    println(solution("3people unFollowed me")) // "3people Unfollowed Me"
    println(solution("for the last week")) // "For The Last Week"
    println(solution("   for    the   s last week   ")) // "   For    The   S Last Week   "

//    println("unFollowed".capitalize())
//    println("unFollowed".replaceFirstChar { "@${it.uppercase()}" })

  }

  /**
   * 행렬의 곱셈
   * 문제 설명
   * 2차원 행렬 arr1과 arr2를 입력받아, arr1에 arr2를 곱한 결과를 반환하는 함수, solution을 완성해주세요.
   *
   * 제한 조건
   * 행렬 arr1, arr2의 행과 열의 길이는 2 이상 100 이하입니다.
   * 행렬 arr1, arr2의 원소는 -10 이상 20 이하인 자연수입니다.
   * 곱할 수 있는 배열만 주어집니다.
   * 입출력 예
   * arr1	arr2	return
   * [[1, 4], [3, 2], [4, 1]]	[[3, 3], [3, 3]]	[[15, 15], [15, 15], [15, 15]]
   * [[2, 3, 2], [4, 2, 4], [3, 1, 4]]	[[5, 4, 3], [2, 4, 1], [3, 1, 1]]	[[22, 22, 11], [36, 28, 18], [29, 20, 14]]
   */

  /**
   * [1, 4]
   * [3, 2]   [3, 3]
   * [4, 1]	  [3, 3]	[[15, 15], [15, 15], [15, 15]]
   *
   */

  @Test
  fun algorithm7() {
    fun solution(arr1: Array<IntArray>, arr2: Array<IntArray>): Array<IntArray> {
      // TODO
      val array = Array(arr1.size) { iIndex -> IntArray(arr2[0].size) { jIndex -> arr1[iIndex][jIndex] * arr2[jIndex][iIndex] } }

//      val array = Array(arr1.size) { arr2[0].mapIndexed { iIndex, i -> arr2.mapIndexed { jIndex, j -> arr1[iIndex][jIndex] * arr2[jIndex][jIndex] } } }
      array.forEach {
        println(it.toList().toString())
      }

      return arrayOf(intArrayOf())
    }

    println(solution(arrayOf(intArrayOf(1, 4), intArrayOf(3, 2), intArrayOf(4, 1)), arrayOf(intArrayOf(3, 3), intArrayOf(3, 3)))) // [[15, 15], [15, 15], [15, 15]]
//    println(solution(arrayOf(intArrayOf(2, 3, 2), intArrayOf(4, 2, 4), intArrayOf(3, 1, 4)), arrayOf(intArrayOf(5, 4, 3), intArrayOf(2, 4, 1), intArrayOf(3, 1, 1)))) // [[22, 22, 11], [36, 28, 18], [29, 20, 14]]
  }
}