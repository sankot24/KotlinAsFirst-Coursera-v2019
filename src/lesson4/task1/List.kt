@file:Suppress("UNUSED_PARAMETER", "ConvertCallChainIntoSequence")

package lesson4.task1

import lesson1.task1.discriminant
import kotlin.math.sqrt

/**
 * Пример
 *
 * Найти все корни уравнения x^2 = y
 */
fun sqRoots(y: Double) =
    when {
        y < 0 -> listOf()
        y == 0.0 -> listOf(0.0)
        else -> {
            val root = sqrt(y)
            // Результат!
            listOf(-root, root)
        }
    }

/**
 * Пример
 *
 * Найти все корни биквадратного уравнения ax^4 + bx^2 + c = 0.
 * Вернуть список корней (пустой, если корней нет)
 */
fun biRoots(a: Double, b: Double, c: Double): List<Double> {
    if (a == 0.0) {
        return if (b == 0.0) listOf()
        else sqRoots(-c / b)
    }
    val d = discriminant(a, b, c)
    if (d < 0.0) return listOf()
    if (d == 0.0) return sqRoots(-b / (2 * a))
    val y1 = (-b + sqrt(d)) / (2 * a)
    val y2 = (-b - sqrt(d)) / (2 * a)
    return sqRoots(y1) + sqRoots(y2)
}

/**
 * Пример
 *
 * Выделить в список отрицательные элементы из заданного списка
 */
fun negativeList(list: List<Int>): List<Int> {
    val result = mutableListOf<Int>()
    for (element in list) {
        if (element < 0) {
            result.add(element)
        }
    }
    return result
}

/**
 * Пример
 *
 * Изменить знак для всех положительных элементов списка
 */
fun invertPositives(list: MutableList<Int>) {
    for (i in 0 until list.size) {
        val element = list[i]
        if (element > 0) {
            list[i] = -element
        }
    }
}

/**
 * Пример
 *
 * Из имеющегося списка целых чисел, сформировать список их квадратов
 */
fun squares(list: List<Int>) = list.map { it * it }

/**
 * Пример
 *
 * Из имеющихся целых чисел, заданного через vararg-параметр, сформировать массив их квадратов
 */
fun squares(vararg array: Int) = squares(array.toList()).toTypedArray()

/**
 * Пример
 *
 * По заданной строке str определить, является ли она палиндромом.
 * В палиндроме первый символ должен быть равен последнему, второй предпоследнему и т.д.
 * Одни и те же буквы в разном регистре следует считать равными с точки зрения данной задачи.
 * Пробелы не следует принимать во внимание при сравнении символов, например, строка
 * "А роза упала на лапу Азора" является палиндромом.
 */
fun isPalindrome(str: String): Boolean {
    val lowerCase = str.toLowerCase().filter { it != ' ' }
    for (i in 0..lowerCase.length / 2) {
        if (lowerCase[i] != lowerCase[lowerCase.length - i - 1]) return false
    }
    return true
}

/**
 * Пример
 *
 * По имеющемуся списку целых чисел, например [3, 6, 5, 4, 9], построить строку с примером их суммирования:
 * 3 + 6 + 5 + 4 + 9 = 27 в данном случае.
 */
fun buildSumExample(list: List<Int>) = list.joinToString(separator = " + ", postfix = " = ${list.sum()}")

/**
 * Простая
 *
 * Найти модуль заданного вектора, представленного в виде списка v,
 * по формуле abs = sqrt(a1^2 + a2^2 + ... + aN^2).
 * Модуль пустого вектора считать равным 0.0.
 */
fun abs(v: List<Double>): Double = TODO()

/**
 * Простая
 *
 * Рассчитать среднее арифметическое элементов списка list. Вернуть 0.0, если список пуст
 */
fun mean(list: List<Double>): Double = TODO()

/**
 * Средняя
 *
 * Центрировать заданный список list, уменьшив каждый элемент на среднее арифметическое всех элементов.
 * Если список пуст, не делать ничего. Вернуть изменённый список.
 *
 * Обратите внимание, что данная функция должна изменять содержание списка list, а не его копии.
 */
fun center(list: MutableList<Double>): MutableList<Double> = TODO()

/**
 * Средняя
 *
 * Найти скалярное произведение двух векторов равной размерности,
 * представленные в виде списков a и b. Скалярное произведение считать по формуле:
 * C = a1b1 + a2b2 + ... + aNbN. Произведение пустых векторов считать равным 0.
 */
fun times(a: List<Int>, b: List<Int>): Int = TODO()

/**
 * Средняя
 *
 * Рассчитать значение многочлена при заданном x:
 * p(x) = p0 + p1*x + p2*x^2 + p3*x^3 + ... + pN*x^N.
 * Коэффициенты многочлена заданы списком p: (p0, p1, p2, p3, ..., pN).
 * Значение пустого многочлена равно 0 при любом x.
 */
fun polynom(p: List<Int>, x: Int): Int = TODO()

/**
 * Средняя
 *
 * В заданном списке list каждый элемент, кроме первого, заменить
 * суммой данного элемента и всех предыдущих.
 * Например: 1, 2, 3, 4 -> 1, 3, 6, 10.
 * Пустой список не следует изменять. Вернуть изменённый список.
 *
 * Обратите внимание, что данная функция должна изменять содержание списка list, а не его копии.
 */
fun accumulate(list: MutableList<Int>): MutableList<Int> = TODO()

/**
 * Средняя
 *
 * Разложить заданное натуральное число n > 1 на простые множители.
 * Результат разложения вернуть в виде списка множителей, например 75 -> (3, 5, 5).
 * Множители в списке должны располагаться по возрастанию.
 */
fun factorize(n: Int): List<Int> = TODO()

/**
 * Сложная
 *
 * Разложить заданное натуральное число n > 1 на простые множители.
 * Результат разложения вернуть в виде строки, например 75 -> 3*5*5
 * Множители в результирующей строке должны располагаться по возрастанию.
 */
fun factorizeToString(n: Int): String = TODO()

/**
 * Средняя
 *
 * Перевести заданное целое число n >= 0 в систему счисления с основанием base > 1.
 * Результат перевода вернуть в виде списка цифр в base-ичной системе от старшей к младшей,
 * например: n = 100, base = 4 -> (1, 2, 1, 0) или n = 250, base = 14 -> (1, 3, 12)
 */
fun convert(n: Int, base: Int): List<Int> = TODO()

/**
 * Сложная
 *
 * Перевести заданное целое число n >= 0 в систему счисления с основанием 1 < base < 37.
 * Результат перевода вернуть в виде строки, цифры более 9 представлять латинскими
 * строчными буквами: 10 -> a, 11 -> b, 12 -> c и так далее.
 * Например: n = 100, base = 4 -> 1210, n = 250, base = 14 -> 13c
 *
 * Использовать функции стандартной библиотеки, напрямую и полностью решающие данную задачу
 * (например, n.toString(base) и подобные), запрещается.
 */
fun convertToString(n: Int, base: Int): String = TODO()

/**
 * Средняя
 *
 * Перевести число, представленное списком цифр digits от старшей к младшей,
 * из системы счисления с основанием base в десятичную.
 * Например: digits = (1, 3, 12), base = 14 -> 250
 */
fun decimal(digits: List<Int>, base: Int): Int = TODO()

/**
 * Сложная
 *
 * Перевести число, представленное цифровой строкой str,
 * из системы счисления с основанием base в десятичную.
 * Цифры более 9 представляются латинскими строчными буквами:
 * 10 -> a, 11 -> b, 12 -> c и так далее.
 * Например: str = "13c", base = 14 -> 250
 *
 * Использовать функции стандартной библиотеки, напрямую и полностью решающие данную задачу
 * (например, str.toInt(base)), запрещается.
 */
fun decimalFromString(str: String, base: Int): Int = TODO()

/**
 * Сложная
 *
 * Перевести натуральное число n > 0 в римскую систему.
 * Римские цифры: 1 = I, 4 = IV, 5 = V, 9 = IX, 10 = X, 40 = XL, 50 = L,
 * 90 = XC, 100 = C, 400 = CD, 500 = D, 900 = CM, 1000 = M.
 * Например: 23 = XXIII, 44 = XLIV, 100 = C
 */
fun roman(n: Int): String = TODO()

/**
 * Вспомогательная
 *
 * Функция записывающая единицы
 */
fun units(n: Int): String {
    return when (n % 10) {
        1 -> "один"
        2 -> "два"
        3 -> "три"
        4 -> "четыре"
        5 -> "пять"
        6 -> "шесть"
        7 -> "семь"
        8 -> "восемь"
        9 -> "девять"
        else -> ""
    }
}

/**
 * Вспомогательная
 *
 * Функция записывающая десятки и числа второго десятка(11, 12, ... 19)
 */

fun decades(n: Int): String {
    return when (n / 10 % 10) {
        1 -> when (n % 10) {
            1 -> "одиннадцать"
            2 -> "двенадцать"
            3 -> "тринадцать"
            4 -> "четырнадцать"
            5 -> "пятнадцать"
            6 -> "шестнадцать"
            7 -> "семнадцать"
            8 -> "восемнадцать"
            9 -> "девятнадцать"
            else -> "десять"
        }
        2 -> "двадцать " + units(n)
        3 -> "тридцать " + units(n)
        4 -> "сорок " + units(n)
        5 -> "пятьдесят " + units(n)
        6 -> "шестьдесят " + units(n)
        7 -> "семьдесят " + units(n)
        8 -> "восемьдесят " + units(n)
        9 -> "девяносто " + units(n)
        else -> "" + units(n)
    }
}

/**
 * Вспомогательная
 *
 * Функция записывающая сотни
 */

fun hundreds(n: Int): String {
    return when (n / 100 % 10) {
        1 -> "сто " + decades(n)
        2 -> "двести " + decades(n)
        3 -> "триста " + decades(n)
        4 -> "четыреста " + decades(n)
        5 -> "пятьсот " + decades(n)
        6 -> "шестьсот " + decades(n)
        7 -> "семьсот " + decades(n)
        8 -> "восемьсот " + decades(n)
        9 -> "девятьсот " + decades(n)
        else -> "" + decades(n)
    }
}

/**
 * Вспомогательная
 *
 * Функция записывающая тысячи
 */

fun thousands(n: Int): String {
    return when (n / 1000 % 10) {
        1 -> "одна тысяча " + hundreds(n)
        2 -> "две тысячи " + hundreds(n)
        3 -> "три тысячи " + hundreds(n)
        4 -> "четыре тысячи " + hundreds(n)
        5 -> "пять тысяч " + hundreds(n)
        6 -> "шесть тысяч " + hundreds(n)
        7 -> "семь тысяч " + hundreds(n)
        8 -> "восемь тысяч " + hundreds(n)
        9 -> "девять тысяч " + hundreds(n)
        else -> "тысяч " + hundreds(n)
    }
}

/**
 * Вспомогательная
 *
 * Функция записывающая десятки тысяч
 */
fun tensThousands(n: Int): String {
    return when (n / 10000 % 10) {
        1 -> decades(n / 1000) + " тысяч " + hundreds(n)
        2 -> "двадцать " + thousands(n)
        3 -> "тридцать " + thousands(n)
        4 -> "сорок " + thousands(n)
        5 -> "пятьдесят " + thousands(n)
        6 -> "шестьдесят " + thousands(n)
        7 -> "семьдесят " + thousands(n)
        8 -> "восемьдесят " + thousands(n)
        9 -> "девяносто " + thousands(n)
        else -> "" + thousands(n)
    }
}

/**
 * Вспомогательная
 *
 * Функция записывающая сотни тысяч
 */
fun hundredsThousands(n: Int): String {
    return when (n / 100000 % 10) {
        1 -> "сто " + tensThousands(n)
        2 -> "двести " + tensThousands(n)
        3 -> "триста " + tensThousands(n)
        4 -> "четыреста " + tensThousands(n)
        5 -> "пятьсот " + tensThousands(n)
        6 -> "шестьсот " + tensThousands(n)
        7 -> "семьсот " + tensThousands(n)
        8 -> "восемьсот " + tensThousands(n)
        9 -> "девятьсот " + tensThousands(n)
        else -> "" + tensThousands(n)
    }
}

fun numCounter(n: Int): Int {
    var count: Int = 0;
    var num: Int = n;

    while (num > 0) {
        num /= 10;
        count++;
    }
    return count;
}
/**
 * Очень сложная
 *
 * Записать заданное натуральное число 1..999999 прописью по-русски.
 * Например, 375 = "триста семьдесят пять",
 * 23964 = "двадцать три тысячи девятьсот шестьдесят четыре"
 */
fun russian(n: Int): String {
    var str: String = when (numCounter(n)) {
        2 -> decades(n)
        3 -> hundreds(n)
        4 -> thousands(n)
        5 -> tensThousands(n)
        6 -> hundredsThousands(n)
        else -> units(n)
    }
    if (str[str.length - 1] == ' ')
        str = str.dropLast(1)

    return str
}