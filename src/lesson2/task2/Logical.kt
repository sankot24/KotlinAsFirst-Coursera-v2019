@file:Suppress("UNUSED_PARAMETER")

package lesson2.task2

import lesson1.task1.sqr
import kotlin.math.sqrt

/**
 * Пример
 *
 * Лежит ли точка (x, y) внутри окружности с центром в (x0, y0) и радиусом r?
 */
fun pointInsideCircle(x: Double, y: Double, x0: Double, y0: Double, r: Double) =
    sqr(x - x0) + sqr(y - y0) <= sqr(r)

/**
 * Простая
 *
 * Четырехзначное число назовем счастливым, если сумма первых двух ее цифр равна сумме двух последних.
 * Определить, счастливое ли заданное число, вернуть true, если это так.
 */
fun isNumberHappy(number: Int) = (number / 1000) + (number / 100 % 10) == (number / 10 % 10) + number % 10

/**
 * Простая
 *
 * На шахматной доске стоят два ферзя (ферзь бьет по вертикали, горизонтали и диагоналям).
 * Определить, угрожают ли они друг другу. Вернуть true, если угрожают.
 * Считать, что ферзи не могут загораживать друг друга.
 */
fun queenThreatens(x1: Int, y1: Int, x2: Int, y2: Int): Boolean = TODO()


/**
 * Простая
 *
 * Дан номер месяца (от 1 до 12 включительно) и год (положительный).
 * Вернуть число дней в этом месяце этого года по григорианскому календарю.
 */
fun daysInMonth(month: Int, year: Int): Int = TODO()

/**
 * Средняя
 *
 * Проверить, лежит ли окружность с центром в (x1, y1) и радиусом r1 целиком внутри
 * окружности с центром в (x2, y2) и радиусом r2.
 * Вернуть true, если утверждение верно
 */
fun circleInside(
    x1: Double, y1: Double, r1: Double,
    x2: Double, y2: Double, r2: Double
): Boolean {
    var len: Double = sqrt(sqr(x1 - x2) + sqr(y1 - y2))

    return when {
        len + r1 <= r2 -> true
        else -> false
    }
}

/**
 * Вспомогательная
 *
 * Возварщает минимальное значение из 2х целых чисел
 */
fun min2(a: Int, b: Int): Int {
    return when {
        (a < b) -> a
        else -> b
    }
}

/**
 * Вспомогательная
 *
 * Возварщает минимальное значение из 3х целых чисел
 */
fun min3(a: Int, b: Int, c: Int): Int = when {
    (a <= b && a <= c) -> a
    (b <= a && b <= c) -> b
    else -> c
}

/**
 * Вспомогательная
 *
 * Возварщает среднее значение из 3х целых чисел
 */
fun mid3(a: Int, b: Int, c: Int): Int {
    return when {
        ((a in b..c) || (a in c..b)) -> a
        ((b in a..c) || (b in c..a)) -> b
        else -> c
    }
}

/**
 * Средняя
 *
 * Определить, пройдет ли кирпич со сторонами а, b, c сквозь прямоугольное отверстие в стене со сторонами r и s.
 * Стороны отверстия должны быть параллельны граням кирпича.
 * Считать, что совпадения длин сторон достаточно для прохождения кирпича, т.е., например,
 * кирпич 4 х 4 х 4 пройдёт через отверстие 4 х 4.
 * Вернуть true, если кирпич пройдёт
 */
fun brickPasses(a: Int, b: Int, c: Int, r: Int, s: Int): Boolean {
    val wholeMin: Int = min2(r, s)
    val brickMin: Int = min3(a, b, c)

    return !(wholeMin < brickMin || mid3(a, b, c) > r + s - wholeMin)
}

