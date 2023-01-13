package com.js.algorithm

import org.junit.Test
import java.util.*
import kotlin.math.sqrt

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class Level1 {


  /**
   * 문제 설명
   * 자연수 n을 뒤집어 각 자리 숫자를 원소로 가지는 배열 형태로 리턴해주세요. 예를들어 n이 12345이면 [5,4,3,2,1]을 리턴합니다.
   *
   * 제한 조건
   * n은 10,000,000,000이하인 자연수입니다.
   *
   * 입출력 예
   * n	return
   * 12345	[5,4,3,2,1]
   */

  @Test
  fun algorithm1() {
    fun solution(n: Long) = IntArray(n.toString().length) { n.toString().reversed()[it].digitToInt() }

    println(solution(12345))

  }

  /**
   * 서울에서 김서방 찾기
   * 문제 설명
   * String형 배열 seoul의 element중 "Kim"의 위치 x를 찾아, "김서방은 x에 있다"는 String을 반환하는 함수, solution을 완성하세요. seoul에 "Kim"은 오직 한 번만 나타나며 잘못된 값이 입력되는 경우는 없습니다.
   *
   * 제한 사항
   * seoul은 길이 1 이상, 1000 이하인 배열입니다.
   * seoul의 원소는 길이 1 이상, 20 이하인 문자열입니다.
   * "Kim"은 반드시 seoul 안에 포함되어 있습니다.
   * 입출력 예
   * seoul	return
   * ["Jane", "Kim"]	"김서방은 1에 있다"
   */

  @Test
  fun algorithm2() {
    fun solution(seoul: Array<String>) = "김서방은 ${seoul.indexOf("Kim")}에 있다"
    println(solution(arrayOf("Jane", "Kim")))

  }

  /**
   * 핸드폰 번호 가리기
   * 문제 설명
   * 프로그래머스 모바일은 개인정보 보호를 위해 고지서를 보낼 때 고객들의 전화번호의 일부를 가립니다.
   * 전화번호가 문자열 phone_number로 주어졌을 때, 전화번호의 뒷 4자리를 제외한 나머지 숫자를 전부 *으로 가린 문자열을 리턴하는 함수, solution을 완성해주세요.
   *
   * 제한 조건
   * phone_number는 길이 4 이상, 20이하인 문자열입니다.
   * 입출력 예
   * phone_number	return
   * "01033334444"	"*******4444"
   * "027778888"	"*****8888"
   */

  @Test
  fun algorithm3() {
    fun solution(phone_number: String) = String(CharArray(phone_number.length) { if (it > phone_number.length - 5) phone_number[it] else '*' })
//    fun solution2(phone_number: String) = "${"".padStart(phone_number.length - 4, '*')}${phone_number.takeLast(4)}"

    println(solution("01033334444"))
    println(solution("027778888"))
    println("".padStart(7, '7'))
    println("".padEnd(7, '7'))

  }

  /**
   * 가운데 글자 가져오기
   * 문제 설명
   * 단어 s의 가운데 글자를 반환하는 함수, solution을 만들어 보세요. 단어의 길이가 짝수라면 가운데 두글자를 반환하면 됩니다.
   *
   * 재한사항
   * s는 길이가 1 이상, 100이하인 스트링입니다.
   * 입출력 예
   * s	return
   * "abcde"	"c"
   * "qwer"	"we"
   */

  @Test
  fun algorithm4() {
    fun solution(s: String) = if (s.length % 2 == 1) "${s[s.length / 2]}" else "${s[s.length / 2 - 1]}${s[s.length / 2]}"
    println(solution("abcde"))
    println(solution("qwer"))
  }

  /**
   * 문자열 내림차순으로 배치하기
   * 문제 설명
   * 문자열 s에 나타나는 문자를 큰것부터 작은 순으로 정렬해 새로운 문자열을 리턴하는 함수, solution을 완성해주세요.
   * s는 영문 대소문자로만 구성되어 있으며, 대문자는 소문자보다 작은 것으로 간주합니다.
   *
   * 제한 사항
   * str은 길이 1 이상인 문자열입니다.
   * 입출력 예
   * s	return
   * "Zbcdefg"	"gfedcbZ"
   */

  @Test
  fun algorithm5() {
    fun solution(s: String) = String(CharArray(s.length) { s[it] }.sortedByDescending { it }.toCharArray())
//    fun solution2(s: String) = String(s.toCharArray().sortedArrayDescending())
    println(solution("Zbcdefg"))
  }

  /**
   * 정수 제곱근 판별
   *
   * 문제 설명
   * 임의의 양의 정수 n에 대해, n이 어떤 양의 정수 x의 제곱인지 아닌지 판단하려 합니다.
   * n이 양의 정수 x의 제곱이라면 x+1의 제곱을 리턴하고, n이 양의 정수 x의 제곱이 아니라면 -1을 리턴하는 함수를 완성하세요.
   *
   * 제한 사항
   * n은 1이상, 50000000000000 이하인 양의 정수입니다.
   *
   * 입출력 예
   * n	return
   * 121	144
   * 3	-1
   *
   * 입출력 예 설명
   * 입출력 예#1
   *
   * 121은 양의 정수 11의 제곱이므로, (11+1)를 제곱한 144를 리턴합니다.
   *
   * 입출력 예#2
   * 3은 양의 정수의 제곱이 아니므로, -1을 리턴합니다.
   */

  @Test
  fun algorithm6() {
    fun solution(n: Long) = if ((sqrt(n.toDouble()) == sqrt(n.toDouble()).toLong()
        .toDouble() && sqrt(n.toDouble()).toLong() != 1L) || n == 1L
    ) (sqrt(n.toDouble()).toLong() + 1) * (sqrt(n.toDouble()).toLong() + 1) else -1

//      var squareRoot = -1L
//      (1..n).forEach {
//        if((it * it) == n){
//          squareRoot = (it + 1) * (it + 1)
//          return@forEach
//        }
//      }
//      return squareRoot
    println(solution(121))
    println(solution(3))
    println(solution(50000000000000))
    println(solution(1))
    println(sqrt(50000000000000.toDouble()))
    println(sqrt(50000000000001.toDouble()))
  }


  /**
   * 하샤드 수
   *
   * 문제 설명
   * 양의 정수 x가 하샤드 수이려면 x의 자릿수의 합으로 x가 나누어져야 합니다. 예를 들어 18의 자릿수 합은 1+8=9이고, 18은 9로 나누어 떨어지므로 18은 하샤드 수입니다. 자연수 x를 입력받아 x가 하샤드 수인지 아닌지 검사하는 함수, solution을 완성해주세요.
   *
   * 제한 조건
   * x는 1 이상, 10000 이하인 정수입니다.
   * 입출력 예
   * arr	return
   * 10	true
   * 12	true
   * 11	false
   * 13	false
   * 입출력 예 설명
   * 입출력 예 #1
   * 10의 모든 자릿수의 합은 1입니다. 10은 1로 나누어 떨어지므로 10은 하샤드 수입니다.
   *
   * 입출력 예 #2
   * 12의 모든 자릿수의 합은 3입니다. 12는 3으로 나누어 떨어지므로 12는 하샤드 수입니다.
   *
   * 입출력 예 #3
   * 11의 모든 자릿수의 합은 2입니다. 11은 2로 나누어 떨어지지 않으므로 11는 하샤드 수가 아닙니다.
   *
   * 입출력 예 #4
   * 13의 모든 자릿수의 합은 4입니다. 13은 4로 나누어 떨어지지 않으므로 13은 하샤드 수가 아닙니다.
   */

  @Test
  fun algorithm7() {
    fun solution(x: Int) = x % (x.toString().map { "$it" }.reduce { acc, s -> "${acc.toInt() + s.toInt()}" }).toInt() == 0
    fun solution2(x: Int) = x % x.toString().fold(0) { acc, c -> acc + c.code - 48 } == 0

    println(solution(10))
    println(solution(12))
    println(solution(11))
    println(solution(13))
  }

  /**
   * 문자열 다루기 기본
   *
   * 문제 설명
   * 문자열 s의 길이가 4 혹은 6이고, 숫자로만 구성돼있는지 확인해주는 함수, solution을 완성하세요. 예를 들어 s가 "a234"이면 False를 리턴하고 "1234"라면 True를 리턴하면 됩니다.
   *
   * 제한 사항
   * s는 길이 1 이상, 길이 8 이하인 문자열입니다.
   * s는 영문 알파벳 대소문자 또는 0부터 9까지 숫자로 이루어져 있습니다.
   * 입출력 예
   * s	return
   * "a234"	false
   * "1234"	true
   * 문제가 잘 안풀린다면😢
   * 힌트가 필요한가요? [코딩테스트 연습 힌트 모음집]으로 오세요! → 클릭
   *
   * 공지 - 2022년 7월 22일 테스트케이스가 추가되었습니다.
   * 공지 - 2022년 7월 22일 제한 사항이 추가되었습니다.
   */

  @Test
  fun algorithm8() {
    //    fun solution(s: String): Boolean {
//      s.forEach { if (it.code !in 49..57) return false }; return true
//    }
    fun solution(s: String) = s.all { it.code in 48..57 } && s.length == 4 && s.length == 6
//    fun solution2(s: String) = (s.length == 4 || s.length == 6) && s.toIntOrNull() != null

    println(solution("a234"))
    println(solution("1234"))
  }

  /**
   * 행렬의 덧셈
   *
   * 문제 설명
   * 행렬의 덧셈은 행과 열의 크기가 같은 두 행렬의 같은 행, 같은 열의 값을 서로 더한 결과가 됩니다. 2개의 행렬 arr1과 arr2를 입력받아, 행렬 덧셈의 결과를 반환하는 함수, solution을 완성해주세요.
   *
   * 제한 조건
   * 행렬 arr1, arr2의 행과 열의 길이는 500을 넘지 않습니다.
   * 입출력 예
   * arr1	arr2	return
   * [[1,2],[2,3]]	[[3,4],[5,6]]	[[4,6],[7,9]]
   * [[1],[2]]	[[3],[4]]	[[4],[6]]
   *
   * 공지 - 2022년 7월 22일 테스트케이스가 추가되었습니다.
   * 공지 - 2022년 7월 22일 제한 사항이 추가되었습니다.
   */

  @Test
  fun algorithm9() {

    fun solution(arr1: Array<IntArray>, arr2: Array<IntArray>): Array<IntArray> =
      Array(arr1.size) { row -> IntArray(arr1.first().size) { column -> arr1[row][column] + arr2[row][column] } }
    println(solution(arrayOf(intArrayOf(1, 2), intArrayOf(2, 3)), arrayOf(intArrayOf(3, 4), intArrayOf(5, 6))).toList())
    println(solution(arrayOf(intArrayOf(1), intArrayOf(2)), arrayOf(intArrayOf(3), intArrayOf(4))).toList())
  }

  /**
   * 직사각형 별찍기
   * 문제 설명
   * 이 문제에는 표준 입력으로 두 개의 정수 n과 m이 주어집니다.
   * 별(*) 문자를 이용해 가로의 길이가 n, 세로의 길이가 m인 직사각형 형태를 출력해보세요.
   *
   * 제한 조건
   * n과 m은 각각 1000 이하인 자연수입니다.
   * 예시
   * 입력
   *
   * 5 3
   * 출력
   *
   *  *****
   *  *****
   *  *****
   */

  @Test
  fun algorithm10() {
    val (a, b) = readLine()!!.split(' ').map(String::toInt)
    (0 until b).forEach { _ -> (0 until a).forEach { _ -> print("*") }; println() }
  }

  /**
   * 최대공약수와 최소공배수
   *
   * 문제 설명
   * 두 수를 입력받아 두 수의 최대공약수와 최소공배수를 반환하는 함수, solution을 완성해 보세요. 배열의 맨 앞에 최대공약수, 그다음 최소공배수를 넣어 반환하면 됩니다. 예를 들어 두 수 3, 12의 최대공약수는 3, 최소공배수는 12이므로 solution(3, 12)는 [3, 12]를 반환해야 합니다.
   *
   * 제한 사항
   * 두 수는 1이상 1000000이하의 자연수입니다.
   * 입출력 예
   * n	m	return
   * 3	12	[3, 12]
   * 2	5	[1, 10]
   * 입출력 예 설명
   * 입출력 예 #1
   * 위의 설명과 같습니다.
   *
   * 입출력 예 #2
   * 자연수 2와 5의 최대공약수는 1, 최소공배수는 10이므로 [1, 10]을 리턴해야 합니다.
   */

  @Test
  fun algorithm11() {

//    // 다른 사람 풀이
//    tailrec fun gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
//    fun solution2(n: Int, m: Int): IntArray {
//      val gcd = gcd(n, m)
//
//      return intArrayOf(gcd, n * m / gcd)
//    }

    fun solution(n: Int, m: Int): IntArray {

      var low = if (n <= m) n else m
      var high = if (n <= m) m else n

      var greatestCommonFactor = 1 // 최대 공약수
      var leastCommonMultiple = 1 // 최소 공배수

      while ((low downTo 2).any { low % it == 0 && high % it == 0 }) {
        (low downTo 2).forEach {
          if (low % it == 0 && high % it == 0) {
            low /= it
            high /= it
            greatestCommonFactor *= it
            return@forEach
          }
        }
      }
      leastCommonMultiple *= low * high * greatestCommonFactor
      return intArrayOf(greatestCommonFactor, leastCommonMultiple)
    }

    val result = solution(3, 12)
    println(result[0])
    println(result[1])

    val result2 = solution(2, 5)
    println(result2[0])
    println(result2[1])
  }


  /**
   * 이상한 문자 만들기
   *
   * 문제 설명
   * 문자열 s는 한 개 이상의 단어로 구성되어 있습니다. 각 단어는 하나 이상의 공백문자로 구분되어 있습니다. 각 단어의 짝수번째 알파벳은 대문자로, 홀수번째 알파벳은 소문자로 바꾼 문자열을 리턴하는 함수, solution을 완성하세요.
   *
   * 제한 사항
   * 문자열 전체의 짝/홀수 인덱스가 아니라, 단어(공백을 기준)별로 짝/홀수 인덱스를 판단해야합니다.
   * 첫 번째 글자는 0번째 인덱스로 보아 짝수번째 알파벳으로 처리해야 합니다.
   * 입출력 예
   * s	return
   * "try hello world"
   * 입출력 예 설명
   * "try hello world"는 세 단어 "try", "hello", "world"로 구성되어 있습니다. 각 단어의 짝수번째 문자를 대문자로, 홀수번째 문자를 소문자로 바꾸면 "TrY", "HeLlO", "WoRlD"입니다. 따라서 "TrY HeLlO WoRlD" 를 리턴합니다.
   *
   * 문제가 잘 안풀린다면😢
   * 힌트가 필요한가요? [코딩테스트 연습 힌트 모음집]으로 오세요! → 클릭
   */

//  단어 사이 공백이 여러개
//  문자의 시작과 끝에 공백
//  단어에 대문자가 섞여있는 경우 위 세가지 고려해서 테스트 해보시면 될거 같습니다.
//  "  tRy hello  WORLD    " 로 넣어서 테스트 해보시면 될거같습니다.

  @Test
  fun algorithm12() {
    fun solution(s: String) = s.split(' ').joinToString(separator = " ") {
      it.foldIndexed("") { index, acc, c ->
        "$acc${
          if (index % 2 == 0) {
            if ((65..90).contains(c.code)) c else c - 32
          } else {
            if ((65..90).contains(c.code)) c + 32 else c
          }
        }"
      }
    }

//    println("try hello world".split(' '))
    println(solution("try   hello     world"))
    println(solution(" try   hello     world "))
    println(solution(" try   hello     world "))
    println(solution(" Try   HelLo     world "))
    println(solution("abc abcd abcde"))
  }

  /**
   * 3진법 뒤집기
   *
   * 문제 설명
   * 자연수 n이 매개변수로 주어집니다. n을 3진법 상에서 앞뒤로 뒤집은 후, 이를 다시 10진법으로 표현한 수를 return 하도록 solution 함수를 완성해주세요.
   *
   * 제한사항
   * n은 1 이상 100,000,000 이하인 자연수입니다.
   * 입출력 예
   * n	result
   * 45	7
   * 125	229
   * 입출력 예 설명
   * 입출력 예 #1
   *
   * 답을 도출하는 과정은 다음과 같습니다.
   * n (10진법)	n (3진법)	앞뒤 반전(3진법)	10진법으로 표현
   * 45	1200	0021	7
   * 따라서 7을 return 해야 합니다.
   * 입출력 예 #2
   *
   * 답을 도출하는 과정은 다음과 같습니다.
   * n (10진법)	n (3진법)	앞뒤 반전(3진법)	10진법으로 표현
   * 125	11122	22111	229
   * 따라서 229를 return 해야 합니다.
   */

  @Test
  fun algorithm13() {

    fun solution2(n: Int): Int {
      return n.toString(3).reversed().toInt(3)
    }

    fun solution(n: Int): Int {

      val text = StringBuilder()

      var number = n

      while (true) {

        text.insert(0, number % 3)
        number -= number % 3
        number /= 3

        if (number == 0) break
      }

      var result = 0

      text.toString().reversed().forEachIndexed { index, c ->
        result += c.digitToInt() * (text.length - 2 downTo index).fold(1) { acc, _ -> acc * 3 }
      }

      return result

    }

    println(solution(45))
    println(solution(125))

  }


  /**
   * 2016년
   * 문제 설명
   * 2016년 1월 1일은 금요일입니다. 2016년 a월 b일은 무슨 요일일까요? 두 수 a ,b를 입력받아 2016년 a월 b일이 무슨 요일인지 리턴하는 함수, solution을 완성하세요. 요일의 이름은 일요일부터 토요일까지 각각 SUN,MON,TUE,WED,THU,FRI,SAT
   *
   * 입니다. 예를 들어 a=5, b=24라면 5월 24일은 화요일이므로 문자열 "TUE"를 반환하세요.
   *
   * 제한 조건
   * 2016년은 윤년입니다.
   * 2016년 a월 b일은 실제로 있는 날입니다. (13월 26일이나 2월 45일같은 날짜는 주어지지 않습니다)
   * 입출력 예
   * a	b	result
   * 5	24	"TUE"
   */

  @Test
  fun algorithm14() {

    fun solution(a: Int, b: Int) = Calendar.getInstance().apply { set(2016, a - 1, b) }.get(Calendar.DAY_OF_WEEK).let {
      when (it) {
        1 -> "SUN"
        2 -> "MON"
        3 -> "TUE"
        4 -> "WED"
        5 -> "THU"
        6 -> "FRI"
        else -> "SAT"
      }
    }
    println(solution(1, 1))
    println(solution(5, 24))
  }

  /**
   * 문자열 내 마음대로 정렬하기
   * 문제 설명
   * 문자열로 구성된 리스트 strings와, 정수 n이 주어졌을 때, 각 문자열의 인덱스 n번째 글자를 기준으로 오름차순 정렬하려 합니다. 예를 들어 strings가 ["sun", "bed", "car"]이고 n이 1이면 각 단어의 인덱스 1의 문자 "u", "e", "a"로 strings를 정렬합니다.
   *
   * 제한 조건
   * strings는 길이 1 이상, 50이하인 배열입니다.
   * strings의 원소는 소문자 알파벳으로 이루어져 있습니다.
   * strings의 원소는 길이 1 이상, 100이하인 문자열입니다.
   * 모든 strings의 원소의 길이는 n보다 큽니다.
   * 인덱스 1의 문자가 같은 문자열이 여럿 일 경우, 사전순으로 앞선 문자열이 앞쪽에 위치합니다.
   * 입출력 예
   * strings	n	return
   * ["sun", "bed", "car"]	1	["car", "bed", "sun"]
   * ["abce", "abcd", "cdx"]	2	["abcd", "abce", "cdx"]
   * 입출력 예 설명
   * 입출력 예 1
   * "sun", "bed", "car"의 1번째 인덱스 값은 각각 "u", "e", "a" 입니다. 이를 기준으로 strings를 정렬하면 ["car", "bed", "sun"] 입니다.
   *
   * 입출력 예 2
   * "abce"와 "abcd", "cdx"의 2번째 인덱스 값은 "c", "c", "x"입니다. 따라서 정렬 후에는 "cdx"가 가장 뒤에 위치합니다. "abce"와 "abcd"는 사전순으로 정렬하면 "abcd"가 우선하므로, 답은 ["abcd", "abce", "cdx"] 입니다.
   */

  @Test
  fun algorithm15() {
    fun solution(strings: Array<String>, n: Int) = strings.sorted().sortedBy { it[n] }.toTypedArray()

    println(solution(arrayOf("sun", "bed", "car"), 2).toList())
    println(solution(arrayOf("abce", "abcd", "cdx"), 2).toList())
  }

  /**
   * 시저 암호
   * 문제 설명
   * 어떤 문장의 각 알파벳을 일정한 거리만큼 밀어서 다른 알파벳으로 바꾸는 암호화 방식을 시저 암호라고 합니다. 예를 들어 "AB"는 1만큼 밀면 "BC"가 되고, 3만큼 밀면 "DE"가 됩니다. "z"는 1만큼 밀면 "a"가 됩니다. 문자열 s와 거리 n을 입력받아 s를 n만큼 민 암호문을 만드는 함수, solution을 완성해 보세요.
   *
   * 제한 조건
   * 공백은 아무리 밀어도 공백입니다.
   * s는 알파벳 소문자, 대문자, 공백으로만 이루어져 있습니다.
   * s의 길이는 8000이하입니다.
   * n은 1 이상, 25이하인 자연수입니다.
   * 입출력 예
   * s	n	result
   * "AB"	1	"BC"
   * "z"	1	"a"
   * "a B z"	4	"e F d"
   */

  @Test
  fun algorithm16() {
    fun solution(s: String, n: Int) = StringBuilder(s).apply {
      forEachIndexed { index, c ->
        if (c.code in 65..90) {
          this[index] = (this[index].code + n).toChar()
          while (this[index].code > 90) this[index] = (this[index].code - 26).toChar()
        } else if (c.code in 97..122) {
          this[index] = (this[index].code + n).toChar()
          while (this[index].code > 122) this[index] = (this[index].code - 26).toChar()
        }
      }
    }

    println(solution("AB", 1))
    println(solution("abce", 1))
    println(solution("a B z", 4))
  }


  /**
   * 모의고사
   * 문제 설명
   * 수포자는 수학을 포기한 사람의 준말입니다. 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다. 수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.
   *
   * 1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
   * 2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
   * 3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...
   *
   * 3,1,2,4,5
   * 1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때, 가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.
   *
   * 제한 조건
   * 시험은 최대 10,000 문제로 구성되어있습니다.
   * 문제의 정답은 1, 2, 3, 4, 5중 하나입니다.
   * 가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요.
   * 입출력 예
   * answers	return
   * [1,2,3,4,5]	[1]
   * [1,3,2,4,2]	[1,2,3]
   * 입출력 예 설명
   * 입출력 예 #1
   *
   * 수포자 1은 모든 문제를 맞혔습니다.
   * 수포자 2는 모든 문제를 틀렸습니다.
   * 수포자 3은 모든 문제를 틀렸습니다.
   * 따라서 가장 문제를 많이 맞힌 사람은 수포자 1입니다.
   *
   * 입출력 예 #2
   *
   * 모든 사람이 2문제씩을 맞췄습니다.
   */

  @Test
    /**
     * TODO: 풀어야함
     * @author KimJungSik
     * @since 2022/11/1
     */
  fun algorithm17() {
    fun solution(answers: IntArray) = answers.let {
      val users = listOf(intArrayOf(1, 2, 3, 4, 5), intArrayOf(1, 3, 4, 5), intArrayOf(3, 1, 2, 4, 5))
      val userAnswers = listOf(intArrayOf(1, 0), intArrayOf(2, 0), intArrayOf(3, 0))
      it.forEachIndexed { iIndex, i ->
        userAnswers.forEachIndexed { jIndex, _ ->
          when (jIndex) {
            0 -> if (users[0][iIndex % 5] == i) {
              userAnswers[jIndex][1]++
            }
            1 -> {
              if (iIndex % 2 == 0) {
                if (i == 2) userAnswers[jIndex][1]++
              } else {
                if (users[1][(iIndex % 8) / 2] == i) userAnswers[jIndex][1]++
              }
            }
            else -> {
              if (users[2][(iIndex % 10) / 2] == i) {
                userAnswers[jIndex][1]++
              }
            }
          }
        }
      }
      val max = userAnswers.maxOfOrNull { maxData -> maxData[1] }
      IntArray(userAnswers.sortedBy { sortData -> sortData[1] }.filter { data -> data[1] == max }.size) { index -> userAnswers.filter { data -> data[1] == max }[index][0] }
    }

    println(solution(intArrayOf(1, 2, 3, 4, 5)).toList()) // 1
    println(solution(intArrayOf(1, 3, 2, 4, 2)).toList()) // 1, 2, 3
    println(solution(intArrayOf(3, 3, 2, 1, 5)).toList()) // 3
    println(solution(intArrayOf(5, 5, 4, 2, 3)).toList()) // 1, 2, 3

  }


  /**
   * 삼총사
   * 문제 설명
   * 한국중학교에 다니는 학생들은 각자 정수 번호를 갖고 있습니다. 이 학교 학생 3명의 정수 번호를 더했을 때 0이 되면 3명의 학생은 삼총사라고 합니다. 예를 들어, 5명의 학생이 있고, 각각의 정수 번호가 순서대로 -2, 3, 0, 2, -5일 때, 첫 번째, 세 번째, 네 번째 학생의 정수 번호를 더하면 0이므로 세 학생은 삼총사입니다. 또한, 두 번째, 네 번째, 다섯 번째 학생의 정수 번호를 더해도 0이므로 세 학생도 삼총사입니다. 따라서 이 경우 한국중학교에서는 두 가지 방법으로 삼총사를 만들 수 있습니다.
   *
   * 한국중학교 학생들의 번호를 나타내는 정수 배열 number가 매개변수로 주어질 때, 학생들 중 삼총사를 만들 수 있는 방법의 수를 return 하도록 solution 함수를 완성하세요.
   *
   * 제한사항
   * 3 ≤ number의 길이 ≤ 13
   * -1,000 ≤ number의 각 원소 ≤ 1,000
   * 서로 다른 학생의 정수 번호가 같을 수 있습니다.
   * 입출력 예
   * number	result
   * [-2, 3, 0, 2, -5]	2
   * [-3, -2, -1, 0, 1, 2, 3]	5
   * [-1, 1, -1, 1]	0
   * 입출력 예 설명
   * 입출력 예 #1
   *
   * 문제 예시와 같습니다.
   * 입출력 예 #2
   *
   * 학생들의 정수 번호 쌍 (-3, 0, 3), (-2, 0, 2), (-1, 0, 1), (-2, -1, 3), (-3, 1, 2) 이 삼총사가 될 수 있으므로, 5를 return 합니다.
   * 입출력 예 #3
   *
   * 삼총사가 될 수 있는 방법이 없습니다.
   */

  @Test
  fun algorithm18() {
    fun solution(number: IntArray): Int {
      var count = 0
      for (i in 0 until number.size - 2)
        for (j in i + 1 until number.size - 1)
          for (k in j + 1 until number.size) {
            if ((number[i] + number[j] + number[k]) == 0) count++
          }
      return count
    }
    println(solution(intArrayOf(-2, 3, 0, 2, -5)))
    println(solution(intArrayOf(-3, -2, -1, 0, 1, 2, 3)))
    println(solution(intArrayOf(-1, 1, -1, 1)))
  }

  /**
   * 최소직사각형
   *
   * 문제 설명
   * 명함 지갑을 만드는 회사에서 지갑의 크기를 정하려고 합니다. 다양한 모양과 크기의 명함들을 모두 수납할 수 있으면서, 작아서 들고 다니기 편한 지갑을 만들어야 합니다. 이러한 요건을 만족하는 지갑을 만들기 위해 디자인팀은 모든 명함의 가로 길이와 세로 길이를 조사했습니다.
   *
   * 아래 표는 4가지 명함의 가로 길이와 세로 길이를 나타냅니다.
   *
   * 명함 번호	가로 길이	세로 길이
   * 1	60	50
   * 2	30	70
   * 3	60	30
   * 4	80	40
   * 가장 긴 가로 길이와 세로 길이가 각각 80, 70이기 때문에 80(가로) x 70(세로) 크기의 지갑을 만들면 모든 명함들을 수납할 수 있습니다. 하지만 2번 명함을 가로로 눕혀 수납한다면 80(가로) x 50(세로) 크기의 지갑으로 모든 명함들을 수납할 수 있습니다. 이때의 지갑 크기는 4000(=80 x 50)입니다.
   *
   * 모든 명함의 가로 길이와 세로 길이를 나타내는 2차원 배열 sizes가 매개변수로 주어집니다. 모든 명함을 수납할 수 있는 가장 작은 지갑을 만들 때, 지갑의 크기를 return 하도록 solution 함수를 완성해주세요.
   *
   * 제한사항
   * sizes의 길이는 1 이상 10,000 이하입니다.
   * sizes의 원소는 [w, h] 형식입니다.
   * w는 명함의 가로 길이를 나타냅니다.
   * h는 명함의 세로 길이를 나타냅니다.
   * w와 h는 1 이상 1,000 이하인 자연수입니다.
   * 입출력 예
   * sizes	result
   * [[60, 50], [30, 70], [60, 30], [80, 40]]	4000
   * [[10, 7], [12, 3], [8, 15], [14, 7], [5, 15]]	120
   * [[14, 4], [19, 6], [6, 16], [18, 7], [7, 11]]	133
   * 입출력 예 설명
   * 입출력 예 #1
   * 문제 예시와 같습니다.
   *
   * 입출력 예 #2
   * 명함들을 적절히 회전시켜 겹쳤을 때, 3번째 명함(가로: 8, 세로: 15)이 다른 모든 명함보다 크기가 큽니다. 따라서 지갑의 크기는 3번째 명함의 크기와 같으며, 120(=8 x 15)을 return 합니다.
   *
   * 입출력 예 #3
   * 명함들을 적절히 회전시켜 겹쳤을 때, 모든 명함을 포함하는 가장 작은 지갑의 크기는 133(=19 x 7)입니다.
   */

  @Test
  fun algorithm19() {
    fun solution(sizes: Array<IntArray>) = sizes.run {
      var maxWidth = 0
      var maxHeight = 0
      this.forEach {
        maxWidth = maxOf(maxWidth, it[0], it[1])
        maxHeight = maxOf(maxHeight, if (it[0] > it[1]) it[1] else it[0])
      }
      maxWidth * maxHeight
    }
    println(solution(arrayOf(intArrayOf(60, 50), intArrayOf(30, 70), intArrayOf(60, 30), intArrayOf(80, 40)))) // 4000
    println(solution(arrayOf(intArrayOf(10, 7), intArrayOf(12, 3), intArrayOf(8, 15), intArrayOf(14, 7), intArrayOf(5, 15)))) // 120
    println(solution(arrayOf(intArrayOf(14, 4), intArrayOf(19, 6), intArrayOf(6, 16), intArrayOf(18, 7), intArrayOf(7, 11)))) // 133
  }

  /**
   * 옹알이 (2)
   * 문제 설명
   * 머쓱이는 태어난 지 11개월 된 조카를 돌보고 있습니다. 조카는 아직 "aya", "ye", "woo", "ma" 네 가지 발음과 네 가지 발음을 조합해서 만들 수 있는 발음밖에 하지 못하고 연속해서 같은 발음을 하는 것을 어려워합니다. 문자열 배열 babbling이 매개변수로 주어질 때, 머쓱이의 조카가 발음할 수 있는 단어의 개수를 return하도록 solution 함수를 완성해주세요.
   *
   * 제한사항
   * 1 ≤ babbling의 길이 ≤ 100
   * 1 ≤ babbling[i]의 길이 ≤ 30
   * 문자열은 알파벳 소문자로만 이루어져 있습니다.
   * 입출력 예
   * babbling	result
   * ["aya", "yee", "u", "maa"]	1
   * ["ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"]	2
   * 입출력 예 설명
   * 입출력 예 #1
   *
   * ["aya", "yee", "u", "maa"]에서 발음할 수 있는 것은 "aya"뿐입니다. 따라서 1을 return합니다.
   * 입출력 예 #2
   *
   * ["ayaye", "uuuma", "yeye", "yemawoo", "ayaayaa"]에서 발음할 수 있는 것은 "aya" + "ye" = "ayaye", "ye" + "ma" + "woo" = "yemawoo"로 2개입니다. "yeye"는 같은 발음이 연속되므로 발음할 수 없습니다. 따라서 2를 return합니다.
   * 유의사항
   * 네 가지를 붙여 만들 수 있는 발음 이외에는 어떤 발음도 할 수 없는 것으로 규정합니다. 예를 들어 "woowo"는 "woo"는 발음할 수 있지만 "wo"를 발음할 수 없기 때문에 할 수 없는 발음입니다.
   */

  @Test
  fun algorithm20() {
    //    fun solution2(babbling: Array<String>) = babbling.count { it.matches("^(aya(?!aya)|ye(?!ye)|woo(?!woo)|ma(?!ma))+$".toRegex()) }
    fun solution(babbling: Array<String>) = babbling.filter { babblingData ->
      val filterPairList = listOf("1" to "aya", "2" to "ye", "3" to "woo", "4" to "ma")
      val result = filterPairList.fold(babblingData) { acc, c -> acc.replace(c.second, c.first) }
      !result.contains("11") && !result.contains("22") && !result.contains("33") && !result.contains("44") && result.all { it.code in 49..52 }
    }.size

    println(solution(arrayOf("aya", "yee", "u", "maa"))) // 1
    println(solution(arrayOf("ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"))) // 2
  }

  /**
   * 햄버거 만들기
   * 문제 설명
   * 햄버거 가게에서 일을 하는 상수는 햄버거를 포장하는 일을 합니다. 함께 일을 하는 다른 직원들이 햄버거에 들어갈 재료를 조리해 주면 조리된 순서대로 상수의 앞에 아래서부터 위로 쌓이게 되고, 상수는 순서에 맞게 쌓여서 완성된 햄버거를 따로 옮겨 포장을 하게 됩니다. 상수가 일하는 가게는 정해진 순서(아래서부터, 빵 – 야채 – 고기 - 빵)로 쌓인 햄버거만 포장을 합니다. 상수는 손이 굉장히 빠르기 때문에 상수가 포장하는 동안 속 재료가 추가적으로 들어오는 일은 없으며, 재료의 높이는 무시하여 재료가 높이 쌓여서 일이 힘들어지는 경우는 없습니다.
   *
   * 예를 들어, 상수의 앞에 쌓이는 재료의 순서가 [야채, 빵, 빵, 야채, 고기, 빵, 야채, 고기, 빵]일 때, 상수는 여섯 번째 재료가 쌓였을 때, 세 번째 재료부터 여섯 번째 재료를 이용하여 햄버거를 포장하고, 아홉 번째 재료가 쌓였을 때, 두 번째 재료와 일곱 번째 재료부터 아홉 번째 재료를 이용하여 햄버거를 포장합니다. 즉, 2개의 햄버거를 포장하게 됩니다.
   *
   * 상수에게 전해지는 재료의 정보를 나타내는 정수 배열 ingredient가 주어졌을 때, 상수가 포장하는 햄버거의 개수를 return 하도록 solution 함수를 완성하시오.
   *
   * 제한사항
   * 1 ≤ ingredient의 길이 ≤ 1,000,000
   * ingredient의 원소는 1, 2, 3 중 하나의 값이며, 순서대로 빵, 야채, 고기를 의미합니다.
   * 입출력 예
   * ingredient	result
   * [2, 1, 1, 2, 3, 1, 2, 3, 1]	2
   * [1, 3, 2, 1, 2, 1, 3, 1, 2]	0
   * 입출력 예 설명
   * 입출력 예 #1
   *
   * 문제 예시와 같습니다.
   * 입출력 예 #2
   *
   * 상수가 포장할 수 있는 햄버거가 없습니다.
   */

  @Test
  @Deprecated("시간초과")
  fun algorithm21_1() {
    fun solution(ingredient: IntArray): Int {
      val ingredientList = ingredient.toMutableList()
      while (true) {
        var isBreak = false
        val removeList = mutableListOf<Int>()
        run loop@{
          ingredientList.forEachIndexed { index, i ->
            if (ingredientList.size == index + 1) isBreak = true

            if (index > 2 && i == 1 && ingredientList[index - 1] == 3 && ingredientList[index - 2] == 2 && ingredientList[index - 3] == 1) {
              removeList.add(index - 3)
              return@loop
            }
          }
        }
        if (removeList.isNotEmpty()) (0 until 4).forEach { _ -> ingredientList.removeAt(removeList[0]) }
        if (isBreak) break
      }
      return (ingredient.size - ingredientList.size) / 4
    }

    println(solution(intArrayOf(2, 1, 1, 2, 3, 1, 2, 3, 1))) // 2
    println(solution(intArrayOf(1, 3, 2, 1, 2, 1, 3, 1, 2))) // 0
    println(solution(intArrayOf(1, 2, 3, 1))) // 1
    println(solution(intArrayOf(1, 2, 3, 1, 2, 3, 1))) // 1
    println(solution(intArrayOf(1, 2, 1, 2, 3, 1, 3, 1, 2, 3, 1, 2, 3, 1))) // 3
    println(solution(intArrayOf(1, 2, 1, 2, 3, 1, 3, 1, 2, 3, 1, 2, 3, 1))) // 3
    println(solution(intArrayOf(1, 2, 2, 3, 1))) // 0

  }

  @Test
  fun algorithm21_2() {
    fun solution(ingredient: IntArray): Int {

      var count = 0
      val stack = Stack<Int>()
      ingredient.forEachIndexed { index, i ->
        stack.add(i)
        if (stack.size > 3 && stack[index - (count * 4)] == 1 && stack[index - 1 - (count * 4)] == 3 && stack[index - 2 - (count * 4)] == 2 && stack[index - 3 - (count * 4)] == 1) {
          (1..4).forEach { _ -> stack.pop() }
          count++
        }
      }
      return count
    }

    println(solution(intArrayOf(2, 1, 1, 2, 3, 1, 2, 3, 1))) // 2
    println(solution(intArrayOf(1, 3, 2, 1, 2, 1, 3, 1, 2))) // 0
    println(solution(intArrayOf(1, 2, 3, 1))) // 1
    println(solution(intArrayOf(1, 2, 3, 1, 2, 3, 1))) // 1
    println(solution(intArrayOf(1, 2, 1, 2, 3, 1, 3, 1, 2, 3, 1, 2, 3, 1))) // 3
    println(solution(intArrayOf(1, 2, 1, 2, 3, 1, 3, 1, 2, 3, 1, 2, 3, 1))) // 3
    println(solution(intArrayOf(1, 2, 2, 3, 1))) // 0

  }


  /**
   * 콜라 문제
   *
   * 문제 설명
   * 오래전 유행했던 콜라 문제가 있습니다. 콜라 문제의 지문은 다음과 같습니다.
   *
   * 정답은 아무에게도 말하지 마세요.
   *
   * 콜라 빈 병 2개를 가져다주면 콜라 1병을 주는 마트가 있다. 빈 병 20개를 가져다주면 몇 병을 받을 수 있는가?
   *
   * 단, 보유 중인 빈 병이 2개 미만이면, 콜라를 받을 수 없다.
   *
   * 문제를 풀던 상빈이는 콜라 문제의 완벽한 해답을 찾았습니다. 상빈이가 푼 방법은 아래 그림과 같습니다. 우선 콜라 빈 병 20병을 가져가서 10병을 받습니다. 받은 10병을 모두 마신 뒤, 가져가서 5병을 받습니다. 5병 중 4병을 모두 마신 뒤 가져가서 2병을 받고, 또 2병을 모두 마신 뒤 가져가서 1병을 받습니다. 받은 1병과 5병을 받았을 때 남은 1병을 모두 마신 뒤 가져가면 1병을 또 받을 수 있습니다. 이 경우 상빈이는 총 10 + 5 + 2 + 1 + 1 = 19병의 콜라를 받을 수 있습니다.
   *
   * image6.PNG
   *
   * 문제를 열심히 풀던 상빈이는 일반화된 콜라 문제를 생각했습니다. 이 문제는 빈 병 a개를 가져다주면 콜라 b병을 주는 마트가 있을 때, 빈 병 n개를 가져다주면 몇 병을 받을 수 있는지 계산하는 문제입니다. 기존 콜라 문제와 마찬가지로, 보유 중인 빈 병이 a개 미만이면, 추가적으로 빈 병을 받을 순 없습니다. 상빈이는 열심히 고심했지만, 일반화된 콜라 문제의 답을 찾을 수 없었습니다. 상빈이를 도와, 일반화된 콜라 문제를 해결하는 프로그램을 만들어 주세요.
   *
   * 콜라를 받기 위해 마트에 주어야 하는 병 수 a, 빈 병 a개를 가져다 주면 마트가 주는 콜라 병 수 b, 상빈이가 가지고 있는 빈 병의 개수 n이 매개변수로 주어집니다. 상빈이가 받을 수 있는 콜라의 병 수를 return 하도록 solution 함수를 작성해주세요.
   *
   * 제한사항
   * 1 ≤ b < a ≤ n ≤ 1,000,000
   * 정답은 항상 int 범위를 넘지 않게 주어집니다.
   * 입출력 예
   * a	b	n	result
   * 2	1	20	19
   * 3	1	20	9
   * 입출력 예 설명
   * 입출력 예 #1
   *
   * 본문에서 설명한 예시입니다.
   * 입출력 예 #2
   *
   * 빈 병 20개 중 18개를 마트에 가져가서, 6병의 콜라를 받습니다. 이때 상빈이가 가지고 있는 콜라 병의 수는 8(20 – 18 + 6 = 8)개 입니다.
   * 빈 병 8개 중 6개를 마트에 가져가서, 2병의 콜라를 받습니다. 이때 상빈이가 가지고 있는 콜라 병의 수는 4(8 – 6 + 2 = 4)개 입니다.
   * 빈 병 4 개중 3개를 마트에 가져가서, 1병의 콜라를 받습니다. 이때 상빈이가 가지고 있는 콜라 병의 수는 2(4 – 3 + 1 = 2)개 입니다.
   * 3번의 교환 동안 상빈이는 9(6 + 2 + 1 = 9)병의 콜라를 받았습니다.
   */

  @Test
  fun algorithm22_1() {
    fun solution(a: Int, b: Int, n: Int): Int {
      var bottleCount = n
      var changeCount = 0
      while (bottleCount > 1 && bottleCount / a != 0) {
        changeCount += (bottleCount / a) * b
        bottleCount = ((bottleCount / a) * b + (bottleCount % a))
      }
      return changeCount
    }

    println(solution(2, 1, 20)) // 19
    println(solution(3, 1, 20)) // 9
    println(solution(3, 2, 20)) // 36

  }

  @Test
  fun algorithm22_2() {
    fun solution(a: Int, b: Int, n: Int): Int {
      return (if (n > b) n - b else 0) / (a - b) * b
    }

    println(solution(2, 1, 20)) // 19
    println(solution(3, 1, 20)) // 9
    println(solution(3, 2, 20)) // 36

  }


  /**
   * 숫자 짝꿍
   *
   * 문제 설명
   *
   * 두 정수 X, Y의 임의의 자리에서 공통으로 나타나는 정수 k(0 ≤ k ≤ 9)들을 이용하여 만들 수 있는 가장 큰 정수를 두 수의 짝꿍이라 합니다(단, 공통으로 나타나는 정수 중 서로 짝지을 수 있는 숫자만 사용합니다). X, Y의 짝꿍이 존재하지 않으면, 짝꿍은 -1입니다. X, Y의 짝꿍이 0으로만 구성되어 있다면, 짝꿍은 0입니다.
   *
   * 예를 들어, X = 3403이고 Y = 13203이라면, X와 Y의 짝꿍은 X와 Y에서 공통으로 나타나는 3, 0, 3으로 만들 수 있는 가장 큰 정수인 330입니다. 다른 예시로 X = 5525이고 Y = 1255이면 X와 Y의 짝꿍은 X와 Y에서 공통으로 나타나는 2, 5, 5로 만들 수 있는 가장 큰 정수인 552입니다(X에는 5가 3개, Y에는 5가 2개 나타나므로 남는 5 한 개는 짝 지을 수 없습니다.)
   * 두 정수 X, Y가 주어졌을 때, X, Y의 짝꿍을 return하는 solution 함수를 완성해주세요.
   *
   * 제한사항
   * 3 ≤ X, Y의 길이(자릿수) ≤ 3,000,000입니다.
   * X, Y는 0으로 시작하지 않습니다.
   * X, Y의 짝꿍은 상당히 큰 정수일 수 있으므로, 문자열로 반환합니다.
   * 입출력 예
   * X	Y	result
   * "100"	"2345"	"-1"
   * "100"	"203045"	"0"
   * "100"	"123450"	"10"
   * "12321"	"42531"	"321"
   * "5525"	"1255"	"552"
   * 입출력 예 설명
   * 입출력 예 #1
   *
   * X, Y의 짝꿍은 존재하지 않습니다. 따라서 "-1"을 return합니다.
   * 입출력 예 #2
   *
   * X, Y의 공통된 숫자는 0으로만 구성되어 있기 때문에, 두 수의 짝꿍은 정수 0입니다. 따라서 "0"을 return합니다.
   * 입출력 예 #3
   *
   * X, Y의 짝꿍은 10이므로, "10"을 return합니다.
   * 입출력 예 #4
   *
   * X, Y의 짝꿍은 321입니다. 따라서 "321"을 return합니다.
   * 입출력 예 #5
   *
   * 지문에 설명된 예시와 같습니다.
   */
  // TODO
  @Test
  fun algorithm23() {
    fun solution(X: String, Y: String): String {

      val xCount = (9 downTo 0).map { number -> X.count { it.code == number } }
      val yCount = (9 downTo 0).map { number -> Y.count { it.code == number } }

      val result = StringBuilder().apply {
        xCount
      }


      return (result.toList().sortedByDescending { it.code }.joinToString("").toIntOrNull() ?: -1).toString()
    }

    println(solution("100", "2345")) // -1
    println(solution("100", "203045")) // 0
    println(solution("100", "123450")) // 10
    println(solution("12321", "42531")) // 321
    println(solution("5525", "1255")) // 552
    println(solution("10000", "1000")) // 1000
    println(solution("10000", "1010010")) // 10000
    println(solution("1010010", "10000")) // 10000

  }

  /**
   * 실패율
   * 문제 설명
   * 실패율
   * failture_rate1.png
   *
   * 슈퍼 게임 개발자 오렐리는 큰 고민에 빠졌다. 그녀가 만든 프랜즈 오천성이 대성공을 거뒀지만, 요즘 신규 사용자의 수가 급감한 것이다. 원인은 신규 사용자와 기존 사용자 사이에 스테이지 차이가 너무 큰 것이 문제였다.
   *
   * 이 문제를 어떻게 할까 고민 한 그녀는 동적으로 게임 시간을 늘려서 난이도를 조절하기로 했다. 역시 슈퍼 개발자라 대부분의 로직은 쉽게 구현했지만, 실패율을 구하는 부분에서 위기에 빠지고 말았다. 오렐리를 위해 실패율을 구하는 코드를 완성하라.
   *
   * 실패율은 다음과 같이 정의한다.
   * 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수
   * 전체 스테이지의 개수 N, 게임을 이용하는 사용자가 현재 멈춰있는 스테이지의 번호가 담긴 배열 stages가 매개변수로 주어질 때, 실패율이 높은 스테이지부터 내림차순으로 스테이지의 번호가 담겨있는 배열을 return 하도록 solution 함수를 완성하라.
   *
   * 제한사항
   * 스테이지의 개수 N은 1 이상 500 이하의 자연수이다.
   * stages의 길이는 1 이상 200,000 이하이다.
   * stages에는 1 이상 N + 1 이하의 자연수가 담겨있다.
   * 각 자연수는 사용자가 현재 도전 중인 스테이지의 번호를 나타낸다.
   * 단, N + 1 은 마지막 스테이지(N 번째 스테이지) 까지 클리어 한 사용자를 나타낸다.
   * 만약 실패율이 같은 스테이지가 있다면 작은 번호의 스테이지가 먼저 오도록 하면 된다.
   * 스테이지에 도달한 유저가 없는 경우 해당 스테이지의 실패율은 0 으로 정의한다.
   * 입출력 예
   * N	stages	result
   * 5	[2, 1, 2, 6, 2, 4, 3, 3]	[3,4,2,1,5]
   * 4	[4,4,4,4,4]	[4,1,2,3]
   * 입출력 예 설명
   * 입출력 예 #1
   * 1번 스테이지에는 총 8명의 사용자가 도전했으며, 이 중 1명의 사용자가 아직 클리어하지 못했다. 따라서 1번 스테이지의 실패율은 다음과 같다.
   *
   * 1 번 스테이지 실패율 : 1/8
   * 2번 스테이지에는 총 7명의 사용자가 도전했으며, 이 중 3명의 사용자가 아직 클리어하지 못했다. 따라서 2번 스테이지의 실패율은 다음과 같다.
   *
   * 2 번 스테이지 실패율 : 3/7
   * 마찬가지로 나머지 스테이지의 실패율은 다음과 같다.
   *
   * 3 번 스테이지 실패율 : 2/4
   * 4번 스테이지 실패율 : 1/2
   * 5번 스테이지 실패율 : 0/1
   * 각 스테이지의 번호를 실패율의 내림차순으로 정렬하면 다음과 같다.
   *
   * [3,4,2,1,5]
   * 입출력 예 #2
   *
   * 모든 사용자가 마지막 스테이지에 있으므로 4번 스테이지의 실패율은 1이며 나머지 스테이지의 실패율은 0이다.
   *
   * [4,1,2,3]
   */

  @Test
  fun algorithm24() {
    fun solution(N: Int, stages: IntArray): IntArray {
      val list = List(N) { index ->
        Pair(index + 1, if ((stages.count { index + 1 == it }.toDouble() / stages.count { index < it }.toDouble()).isNaN()) 0.0 else stages.count { index + 1 == it }.toDouble() / stages.count { index < it }.toDouble())
      }.sortedByDescending { it.second }
      return IntArray(N) { list[it].first }
    }
    println(solution(5, intArrayOf(2, 1, 2, 6, 2, 4, 3, 3)).toList()) // 3,4,2,1,5
    println(solution(4, intArrayOf(4, 4, 4, 4, 4)).toList()) // 4,1,2,3
    println(solution(8, intArrayOf(1, 2, 3, 4, 5, 6, 7)).toList()) // 7, 6, 5, 4, 3, 2, 1, 8
  }

  /**
   * 성격 유형 검사하기
   *
   * 문제 설명
   *
   * 나만의 카카오 성격 유형 검사지를 만들려고 합니다.
   * 성격 유형 검사는 다음과 같은 4개 지표로 성격 유형을 구분합니다. 성격은 각 지표에서 두 유형 중 하나로 결정됩니다.
 *
   * 지표 번호	성격 유형
   * 1번 지표	라이언형(R), 튜브형(T)
   * 2번 지표	콘형(C), 프로도형(F)
   * 3번 지표	제이지형(J), 무지형(M)
   * 4번 지표	어피치형(A), 네오형(N)
   * 4개의 지표가 있으므로 성격 유형은 총 16(=2 x 2 x 2 x 2)가지가 나올 수 있습니다. 예를 들어, "RFMN"이나 "TCMA"와 같은 성격 유형이 있습니다.
 *
   * 검사지에는 총 n개의 질문이 있고, 각 질문에는 아래와 같은 7개의 선택지가 있습니다.
 *
   * 매우 비동의
   * 비동의
   * 약간 비동의
   * 모르겠음
   * 약간 동의
   * 동의
   * 매우 동의
   * 각 질문은 1가지 지표로 성격 유형 점수를 판단합니다.
 *
   * 예를 들어, 어떤 한 질문에서 4번 지표로 아래 표처럼 점수를 매길 수 있습니다.
 *
   * 선택지	성격 유형 점수
   * 매우 비동의	네오형 3점
   * 비동의	네오형 2점
   * 약간 비동의	네오형 1점
   * 모르겠음	어떤 성격 유형도 점수를 얻지 않습니다
   * 약간 동의	어피치형 1점
   * 동의	어피치형 2점
   * 매우 동의	어피치형 3점
   * 이때 검사자가 질문에서 약간 동의 선택지를 선택할 경우 어피치형(A) 성격 유형 1점을 받게 됩니다. 만약 검사자가 매우 비동의 선택지를 선택할 경우 네오형(N) 성격 유형 3점을 받게 됩니다.
 *
   * 위 예시처럼 네오형이 비동의, 어피치형이 동의인 경우만 주어지지 않고, 질문에 따라 네오형이 동의, 어피치형이 비동의인 경우도 주어질 수 있습니다.
   * 하지만 각 선택지는 고정적인 크기의 점수를 가지고 있습니다.
 *
   * 매우 동의나 매우 비동의 선택지를 선택하면 3점을 얻습니다.
   * 동의나 비동의 선택지를 선택하면 2점을 얻습니다.
   * 약간 동의나 약간 비동의 선택지를 선택하면 1점을 얻습니다.
   * 모르겠음 선택지를 선택하면 점수를 얻지 않습니다.
   * 검사 결과는 모든 질문의 성격 유형 점수를 더하여 각 지표에서 더 높은 점수를 받은 성격 유형이 검사자의 성격 유형이라고 판단합니다. 단, 하나의 지표에서 각 성격 유형 점수가 같으면, 두 성격 유형 중 사전 순으로 빠른 성격 유형을 검사자의 성격 유형이라고 판단합니다.
 *
   * 질문마다 판단하는 지표를 담은 1차원 문자열 배열 survey와 검사자가 각 질문마다 선택한 선택지를 담은 1차원 정수 배열 choices가 매개변수로 주어집니다. 이때, 검사자의 성격 유형 검사 결과를 지표 번호 순서대로 return 하도록 solution 함수를 완성해주세요.
 *
   * 제한사항
   * 1 ≤ survey의 길이 ( = n) ≤ 1,000
   * survey의 원소는 "RT", "TR", "FC", "CF", "MJ", "JM", "AN", "NA" 중 하나입니다.
   * survey[i]의 첫 번째 캐릭터는 i+1번 질문의 비동의 관련 선택지를 선택하면 받는 성격 유형을 의미합니다.
   * survey[i]의 두 번째 캐릭터는 i+1번 질문의 동의 관련 선택지를 선택하면 받는 성격 유형을 의미합니다.
   * choices의 길이 = survey의 길이
 *
   * choices[i]는 검사자가 선택한 i+1번째 질문의 선택지를 의미합니다.
   * 1 ≤ choices의 원소 ≤ 7
   * choices	뜻
   * 1	매우 비동의
   * 2	비동의
   * 3	약간 비동의
   * 4	모르겠음
   * 5	약간 동의
   * 6	동의
   * 7	매우 동의
   * 입출력 예
   * survey	choices	result
   * ["AN", "CF", "MJ", "RT", "NA"]	[5, 3, 2, 7, 5]	"TCMA"
   * ["TR", "RT", "TR"]	[7, 1, 3]	"RCJA"
   * 입출력 예 설명
   * 입출력 예 #1
 *
   * 1번 질문의 점수 배치는 아래 표와 같습니다.
 *
   * 선택지	성격 유형 점수
   * 매우 비동의	어피치형 3점
   * 비동의	어피치형 2점
   * 약간 비동의	어피치형 1점
   * 모르겠음	어떤 성격 유형도 점수를 얻지 않습니다
   * 약간 동의	네오형 1점
   * 동의	네오형 2점
   * 매우 동의	네오형 3점
   * 1번 질문에서는 지문의 예시와 다르게 비동의 관련 선택지를 선택하면 어피치형(A) 성격 유형의 점수를 얻고, 동의 관련 선택지를 선택하면 네오형(N) 성격 유형의 점수를 얻습니다.
   * 1번 질문에서 검사자는 약간 동의 선택지를 선택했으므로 네오형(N) 성격 유형 점수 1점을 얻게 됩니다.
 *
   * 2번 질문의 점수 배치는 아래 표와 같습니다.
 *
   * 선택지	성격 유형 점수
   * 매우 비동의	콘형 3점
   * 비동의	콘형 2점
   * 약간 비동의	콘형 1점
   * 모르겠음	어떤 성격 유형도 점수를 얻지 않습니다
   * 약간 동의	프로도형 1점
   * 동의	프로도형 2점
   * 매우 동의	프로도형 3점
   * 2번 질문에서 검사자는 약간 비동의 선택지를 선택했으므로 콘형(C) 성격 유형 점수 1점을 얻게 됩니다.
 *
   * 3번 질문의 점수 배치는 아래 표와 같습니다.
 *
   * 선택지	성격 유형 점수
   * 매우 비동의	무지형 3점
   * 비동의	무지형 2점
   * 약간 비동의	무지형 1점
   * 모르겠음	어떤 성격 유형도 점수를 얻지 않습니다
   * 약간 동의	제이지형 1점
   * 동의	제이지형 2점
   * 매우 동의	제이지형 3점
   * 3번 질문에서 검사자는 비동의 선택지를 선택했으므로 무지형(M) 성격 유형 점수 2점을 얻게 됩니다.
 *
   * 4번 질문의 점수 배치는 아래 표와 같습니다.
 *
   * 선택지	성격 유형 점수
   * 매우 비동의	라이언형 3점
   * 비동의	라이언형 2점
   * 약간 비동의	라이언형 1점
   * 모르겠음	어떤 성격 유형도 점수를 얻지 않습니다
   * 약간 동의	튜브형 1점
   * 동의	튜브형 2점
   * 매우 동의	튜브형 3점
   * 4번 질문에서 검사자는 매우 동의 선택지를 선택했으므로 튜브형(T) 성격 유형 점수 3점을 얻게 됩니다.
 *
   * 5번 질문의 점수 배치는 아래 표와 같습니다.
 *
   * 선택지	성격 유형 점수
   * 매우 비동의	네오형 3점
   * 비동의	네오형 2점
   * 약간 비동의	네오형 1점
   * 모르겠음	어떤 성격 유형도 점수를 얻지 않습니다
   * 약간 동의	어피치형 1점
   * 동의	어피치형 2점
   * 매우 동의	어피치형 3점
   * 5번 질문에서 검사자는 약간 동의 선택지를 선택했으므로 어피치형(A) 성격 유형 점수 1점을 얻게 됩니다.
 *
   * 1번부터 5번까지 질문의 성격 유형 점수를 합치면 아래 표와 같습니다.
 *
   * 지표 번호	성격 유형	점수	성격 유형	점수
   * 1번 지표	라이언형(R)	0	튜브형(T)	3
   * 2번 지표	콘형(C)	1	프로도형(F)	0
   * 3번 지표	제이지형(J)	0	무지형(M)	2
   * 4번 지표	어피치형(A)	1	네오형(N)	1
   * 각 지표에서 더 점수가 높은 T,C,M이 성격 유형입니다.
   * 하지만, 4번 지표는 1점으로 동일한 점수입니다. 따라서, 4번 지표의 성격 유형은 사전순으로 빠른 A입니다.
 *
   * 따라서 "TCMA"를 return 해야 합니다.
 *
   * 입출력 예 #2
 *
   * 1번부터 3번까지 질문의 성격 유형 점수를 합치면 아래 표와 같습니다.
 *
   * 지표 번호	성격 유형	점수	성격 유형	점수
   * 1번 지표	라이언형(R)	6	튜브형(T)	1
   * 2번 지표	콘형(C)	0	프로도형(F)	0
   * 3번 지표	제이지형(J)	0	무지형(M)	0
   * 4번 지표	어피치형(A)	0	네오형(N)	0
   * 1번 지표는 튜브형(T)보다 라이언형(R)의 점수가 더 높습니다. 따라서 첫 번째 지표의 성격 유형은 R입니다.
   * 하지만, 2, 3, 4번 지표는 모두 0점으로 동일한 점수입니다. 따라서 2, 3, 4번 지표의 성격 유형은 사전순으로 빠른 C, J, A입니다.
 *
   * 따라서 "RCJA"를 return 해야 합니다.
   */

  @Test
  fun algorithm25() {
    fun solution(survey: Array<String>, choices: IntArray): String {

      val personalityTypeModels = mutableListOf<PersonalityTypeModel>().apply {
        "RCJA".forEachIndexed { index, c ->
          add(PersonalityTypeModel("$c${"TFMN"[index]}", 0))
        }
      }

      survey.forEachIndexed { index, surveyType ->
        personalityTypeModels.forEach { personalityTypeModel ->
          if (surveyType == personalityTypeModel.personalityType) {
            personalityTypeModel.score -= choices[index] - 4
          } else if (surveyType.reversed() == personalityTypeModel.personalityType) {
            personalityTypeModel.score += choices[index] - 4
          }
        }
      }
      return personalityTypeModels.fold("") { acc, model -> "$acc${ if (model.score >= 0) model.personalityType[0] else model.personalityType[1] }" }
    }

    println(solution(arrayOf("AN", "CF", "MJ", "RT", "NA"), intArrayOf(5, 3, 2, 7, 5))) // "TCMA"
    println(solution(arrayOf("TR", "RT", "TR"), intArrayOf(7, 1, 3))) // "RCJA"
  }

  data class PersonalityTypeModel(val personalityType: String, var score: Int)

}