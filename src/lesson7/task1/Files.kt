@file:Suppress("UNUSED_PARAMETER", "ConvertCallChainIntoSequence")

package lesson7.task1

import lesson1.task1.accountInThreeYears
import lesson1.task1.numberRevert
import lesson1.task1.quadraticRootProduct
import lesson8.task1.lineByPoints
import java.io.File

/**
 * Пример
 *
 * Во входном файле с именем inputName содержится некоторый текст.
 * Вывести его в выходной файл с именем outputName, выровняв по левому краю,
 * чтобы длина каждой строки не превосходила lineLength.
 * Слова в слишком длинных строках следует переносить на следующую строку.
 * Слишком короткие строки следует дополнять словами из следующей строки.
 * Пустые строки во входном файле обозначают конец абзаца,
 * их следует сохранить и в выходном файле
 */
fun alignFile(inputName: String, lineLength: Int, outputName: String) {
    val outputStream = File(outputName).bufferedWriter()
    var currentLineLength = 0
    for (line in File(inputName).readLines()) {
        if (line.isEmpty()) {
            outputStream.newLine()
            if (currentLineLength > 0) {
                outputStream.newLine()
                currentLineLength = 0
            }
            continue
        }
        for (word in line.split(" ")) {
            if (currentLineLength > 0) {
                if (word.length + currentLineLength >= lineLength) {
                    outputStream.newLine()
                    currentLineLength = 0
                } else {
                    outputStream.write(" ")
                    currentLineLength++
                }
            }
            outputStream.write(word)
            currentLineLength += word.length
        }
    }
    outputStream.close()
}

/**
 * Средняя
 *
 * Во входном файле с именем inputName содержится некоторый текст.
 * На вход подаётся список строк substrings.
 * Вернуть ассоциативный массив с числом вхождений каждой из строк в текст.
 * Регистр букв игнорировать, то есть буквы е и Е считать одинаковыми.
 *
 */
fun countSubstrings(inputName: String, substrings: List<String>): Map<String, Int> = TODO()


/**
 * Средняя
 *
 * В русском языке, как правило, после букв Ж, Ч, Ш, Щ пишется И, А, У, а не Ы, Я, Ю.
 * Во входном файле с именем inputName содержится некоторый текст на русском языке.
 * Проверить текст во входном файле на соблюдение данного правила и вывести в выходной
 * файл outputName текст с исправленными ошибками.
 *
 * Регистр заменённых букв следует сохранять.
 *
 * Исключения (жюри, брошюра, парашют) в рамках данного задания обрабатывать не нужно
 *
 */
fun sibilants(inputName: String, outputName: String) {
    val outputStream = File(outputName).bufferedWriter()

    for (line in File(inputName).readLines()) {
        var i: Int = 0
        while (i < line.length) {
            if ((line[i] != 'Ж' && line[i] != 'ж') && (line[i] != 'Ч' && line[i] != 'ч') && (line[i] != 'Ш' && line[i] != 'ш') && (line[i] != 'Щ' && line[i] != 'щ'))
                outputStream.append(line[i])
            else if (i + 1 < line.length && line[i + 1] != 'ы' && line[i + 1] != 'я' && line[i + 1] != 'ю' && line[i + 1] != 'Ы' && line[i + 1] != 'Я' && line[i + 1] != 'Ю')
                outputStream.append(line[i])
            else {
                if (i + 1 == line.length) {
                    outputStream.append(line[i])
                    break;
                }
                outputStream.append(line[i])
                when (line[i + 1]) {
                    'ы' -> outputStream.append('и')
                    'ю' -> outputStream.append('у')
                    'я' -> outputStream.append('а')
                    'Ы' -> outputStream.append('И')
                    'Ю' -> outputStream.append('У')
                    else -> outputStream.append('А')
                }
                i++
            }
            i++
        }
        outputStream.newLine()
    }

    outputStream.close()
}

/**
 * Средняя
 *
 * Во входном файле с именем inputName содержится некоторый текст (в том числе, и на русском языке).
 * Вывести его в выходной файл с именем outputName, выровняв по центру
 * относительно самой длинной строки.
 *
 * Выравнивание следует производить путём добавления пробелов в начало строки.
 *
 *
 * Следующие правила должны быть выполнены:
 * 1) Пробелы в начале и в конце всех строк не следует сохранять.
 * 2) В случае невозможности выравнивания строго по центру, строка должна быть сдвинута в ЛЕВУЮ сторону
 * 3) Пустые строки не являются особым случаем, их тоже следует выравнивать
 * 4) Число строк в выходном файле должно быть равно числу строк во входном (в т. ч. пустых)
 *
 */
fun centerFile(inputName: String, outputName: String) {
    TODO()
}

/**
 * Сложная
 *
 * Во входном файле с именем inputName содержится некоторый текст (в том числе, и на русском языке).
 * Вывести его в выходной файл с именем outputName, выровняв по левому и правому краю относительно
 * самой длинной строки.
 * Выравнивание производить, вставляя дополнительные пробелы между словами: равномерно по всей строке
 *
 * Слова внутри строки отделяются друг от друга одним или более пробелом.
 *
 * Следующие правила должны быть выполнены:
 * 1) Каждая строка входного и выходного файла не должна начинаться или заканчиваться пробелом.
 * 2) Пустые строки или строки из пробелов трансформируются в пустые строки без пробелов.
 * 3) Строки из одного слова выводятся без пробелов.
 * 4) Число строк в выходном файле должно быть равно числу строк во входном (в т. ч. пустых).
 *
 * Равномерность определяется следующими формальными правилами:
 * 5) Число пробелов между каждыми двумя парами соседних слов не должно отличаться более, чем на 1.
 * 6) Число пробелов между более левой парой соседних слов должно быть больше или равно числу пробелов
 *    между более правой парой соседних слов.
 *
 * Следует учесть, что входной файл может содержать последовательности из нескольких пробелов  между слвоами. Такие
 * последовательности следует учитывать при выравнивании и при необходимости избавляться от лишних пробелов.
 * Из этого следуют следующие правила:
 * 7) В самой длинной строке каждая пара соседних слов должна быть отделена В ТОЧНОСТИ одним пробелом
 * 8) Если входной файл удовлетворяет требованиям 1-7, то он должен быть в точности идентичен выходному файлу
 */
fun alignFileByWidth(inputName: String, outputName: String) {
    TODO()
}

/**
 * Средняя
 *
 * Во входном файле с именем inputName содержится некоторый текст (в том числе, и на русском языке).
 *
 * Вернуть ассоциативный массив, содержащий 20 наиболее часто встречающихся слов с их количеством.
 * Если в тексте менее 20 различных слов, вернуть все слова.
 *
 * Словом считается непрерывная последовательность из букв (кириллических,
 * либо латинских, без знаков препинания и цифр).
 * Цифры, пробелы, знаки препинания считаются разделителями слов:
 * Привет, привет42, привет!!! -привет?!
 * ^ В этой строчке слово привет встречается 4 раза.
 *
 * Регистр букв игнорировать, то есть буквы е и Е считать одинаковыми.
 * Ключи в ассоциативном массиве должны быть в нижнем регистре.
 *
 */
fun top20Words(inputName: String): Map<String, Int> = TODO()

/**
 * Средняя
 *
 * Реализовать транслитерацию текста из входного файла в выходной файл посредством динамически задаваемых правил.

 * Во входном файле с именем inputName содержится некоторый текст (в том числе, и на русском языке).
 *
 * В ассоциативном массиве dictionary содержится словарь, в котором некоторым символам
 * ставится в соответствие строчка из символов, например
 * mapOf('з' to "zz", 'р' to "r", 'д' to "d", 'й' to "y", 'М' to "m", 'и' to "yy", '!' to "!!!")
 *
 * Необходимо вывести в итоговый файл с именем outputName
 * содержимое текста с заменой всех символов из словаря на соответствующие им строки.
 *
 * При этом регистр символов в словаре должен игнорироваться,
 * но при выводе символ в верхнем регистре отображается в строку, начинающуюся с символа в верхнем регистре.
 *
 * Пример.
 * Входной текст: Здравствуй, мир!
 *
 * заменяется на
 *
 * Выходной текст: Zzdrавствуy, mир!!!
 *
 * Пример 2.
 *
 * Входной текст: Здравствуй, мир!
 * Словарь: mapOf('з' to "zZ", 'р' to "r", 'д' to "d", 'й' to "y", 'М' to "m", 'и' to "YY", '!' to "!!!")
 *
 * заменяется на
 *
 * Выходной текст: Zzdrавствуy, mир!!!
 *
 * Обратите внимание: данная функция не имеет возвращаемого значения
 */
fun transliterate(inputName: String, dictionary: Map<Char, String>, outputName: String) {
    TODO()
}

/**
 * Средняя
 *
 * Во входном файле с именем inputName имеется словарь с одним словом в каждой строчке.
 * Выбрать из данного словаря наиболее длинное слово,
 * в котором все буквы разные, например: Неряшливость, Четырёхдюймовка.
 * Вывести его в выходной файл с именем outputName.
 * Если во входном файле имеется несколько слов с одинаковой длиной, в которых все буквы разные,
 * в выходной файл следует вывести их все через запятую.
 * Регистр букв игнорировать, то есть буквы е и Е считать одинаковыми.
 *
 * Пример входного файла:
 * Карминовый
 * Боязливый
 * Некрасивый
 * Остроумный
 * БелогЛазый
 * ФиолетОвый

 * Соответствующий выходной файл:
 * Карминовый, Некрасивый
 *
 * Обратите внимание: данная функция не имеет возвращаемого значения
 */
fun chooseLongestChaoticWord(inputName: String, outputName: String) {
    TODO()
}

/**
 * Сложная
 *
 * Реализовать транслитерацию текста в заданном формате разметки в формат разметки HTML.
 *
 * Во входном файле с именем inputName содержится текст, содержащий в себе элементы текстовой разметки следующих типов:
 * - *текст в курсивном начертании* -- курсив
 * - **текст в полужирном начертании** -- полужирный
 * - ~~зачёркнутый текст~~ -- зачёркивание
 *
 * Следует вывести в выходной файл этот же текст в формате HTML:
 * - <i>текст в курсивном начертании</i>
 * - <b>текст в полужирном начертании</b>
 * - <s>зачёркнутый текст</s>
 *
 * Кроме того, все абзацы исходного текста, отделённые друг от друга пустыми строками, следует обернуть в теги <p>...</p>,
 * а весь текст целиком в теги <html><body>...</body></html>.
 *
 * Все остальные части исходного текста должны остаться неизменными с точностью до наборов пробелов и переносов строк.
 * Отдельно следует заметить, что открывающая последовательность из трёх звёздочек (***) должна трактоваться как "<b><i>"
 * и никак иначе.
 *
 * При решении этой и двух следующих задач полезно прочитать статью Википедии "Стек".
 *
 * Пример входного файла:
Lorem ipsum *dolor sit amet*, consectetur **adipiscing** elit.
Vestibulum lobortis, ~~Est vehicula rutrum *suscipit*~~, ipsum ~~lib~~ero *placerat **tortor***,

Suspendisse ~~et elit in enim tempus iaculis~~.
 *
 * Соответствующий выходной файл:
<html>
<body>
<p>
Lorem ipsum <i>dolor sit amet</i>, consectetur <b>adipiscing</b> elit.
Vestibulum lobortis. <s>Est vehicula rutrum <i>suscipit</i></s>, ipsum <s>lib</s>ero <i>placerat <b>tortor</b></i>.
</p>
<p>
Suspendisse <s>et elit in enim tempus iaculis</s>.
</p>
</body>
</html>
 *
 * (Отступы и переносы строк в примере добавлены для наглядности, при решении задачи их реализовывать не обязательно)
 */
fun markdownToHtmlSimple(inputName: String, outputName: String) {
    TODO()
}

/**
 * Сложная
 *
 * Реализовать транслитерацию текста в заданном формате разметки в формат разметки HTML.
 *
 * Во входном файле с именем inputName содержится текст, содержащий в себе набор вложенных друг в друга списков.
 * Списки бывают двух типов: нумерованные и ненумерованные.
 *
 * Каждый элемент ненумерованного списка начинается с новой строки и символа '*', каждый элемент нумерованного списка --
 * с новой строки, числа и точки. Каждый элемент вложенного списка начинается с отступа из пробелов, на 4 пробела большего,
 * чем список-родитель. Максимально глубина вложенности списков может достигать 6. "Верхние" списки файла начинются
 * прямо с начала строки.
 *
 * Следует вывести этот же текст в выходной файл в формате HTML:
 * Нумерованный список:
 * <ol>
 *     <li>Раз</li>
 *     <li>Два</li>
 *     <li>Три</li>
 * </ol>
 *
 * Ненумерованный список:
 * <ul>
 *     <li>Раз</li>
 *     <li>Два</li>
 *     <li>Три</li>
 * </ul>
 *
 * Кроме того, весь текст целиком следует обернуть в теги <html><body>...</body></html>
 *
 * Все остальные части исходного текста должны остаться неизменными с точностью до наборов пробелов и переносов строк.
 *
 * Пример входного файла:
///////////////////////////////начало файла/////////////////////////////////////////////////////////////////////////////
 * Утка по-пекински
 * Утка
 * Соус
 * Салат Оливье
1. Мясо
 * Или колбаса
2. Майонез
3. Картофель
4. Что-то там ещё
 * Помидоры
 * Фрукты
1. Бананы
23. Яблоки
1. Красные
2. Зелёные
///////////////////////////////конец файла//////////////////////////////////////////////////////////////////////////////
 *
 *
 * Соответствующий выходной файл:
///////////////////////////////начало файла/////////////////////////////////////////////////////////////////////////////
<html>
<body>
<ul>
<li>
Утка по-пекински
<ul>
<li>Утка</li>
<li>Соус</li>
</ul>
</li>
<li>
Салат Оливье
<ol>
<li>Мясо
<ul>
<li>
Или колбаса
</li>
</ul>
</li>
<li>Майонез</li>
<li>Картофель</li>
<li>Что-то там ещё</li>
</ol>
</li>
<li>Помидоры</li>
<li>
Фрукты
<ol>
<li>Бананы</li>
<li>
Яблоки
<ol>
<li>Красные</li>
<li>Зелёные</li>
</ol>
</li>
</ol>
</li>
</ul>
</body>
</html>
///////////////////////////////конец файла//////////////////////////////////////////////////////////////////////////////
 * (Отступы и переносы строк в примере добавлены для наглядности, при решении задачи их реализовывать не обязательно)
 */
fun markdownToHtmlLists(inputName: String, outputName: String) {
    TODO()
}

/**
 * Очень сложная
 *
 * Реализовать преобразования из двух предыдущих задач одновременно над одним и тем же файлом.
 * Следует помнить, что:
 * - Списки, отделённые друг от друга пустой строкой, являются разными и должны оказаться в разных параграфах выходного файла.
 *
 */
fun markdownToHtml(inputName: String, outputName: String) {
    TODO()
}

fun main() {
    val lhv: Int = 2678
    val rhv: Int = 38648
    val lenRhv: Int = numCounter(rhv)
    val lenLhv: Int = numCounter(lhv)
    var lenStr: Int = lenRhv + lenLhv
    var h: Int = 0

    while (h < lenRhv) {
        if (numCounter(pow( 10, h) * numGetter(rhv, lenRhv - h) * lhv) + 1 > lenStr)
            lenStr = numCounter(pow(10, h) * numGetter(rhv, lenRhv - h) * lhv) + 1
        h++
    }

    if (numCounter(lhv * rhv) + 1 > lenStr)
        lenStr = numCounter(lhv * rhv) + 1

    // первая строка
    for (i in 0 until lenStr - lenLhv)
        print(" ")
    println("$lhv")

    // вторая стока
    print("*")
    for (i in 0 until lenStr - lenRhv - 1)
        print(" ")
    println("$rhv")

    // третья строка
    for (i in 0 until lenStr)
        print("-")
    println()

    // четвертая (первое слагаемое)
    var step: Int = numGetter(rhv, lenRhv) * lhv
    var lenStep: Int = numCounter(step)

    for (i in 0 until lenStr - lenStep)
        print(" ")
    println("$step")

    if (lenRhv == 1) {
        for (i in 0 until lenStr)
            print("-")
        println()

        for (i in 0 until lenStr - lenStep)
            print(" ")
        println("$step")
    } else {
        var sum: Int = step
        h = 1

        while (h < lenRhv) {
            step = numGetter(rhv, lenRhv - h) * lhv
            lenStep = numCounter(step)
            sum += step * pow(10, h)

            print("+")
            for (i in 0 until lenStr - lenStep - h - 1)
                print(" ")
            println("$step")
            h++
        }

        for (i in 0 until lenStr)
            print("-")
        println()

        for (i in 0 until lenStr - numCounter(sum))
            print(" ")
        println("$sum")
    }
}

fun pow(footing: Int, degree: Int): Int {
    var ans: Int = 1

    for (i in 1..degree)
        ans *= footing

    return ans
}

/**
 * Средняя
 *
 * Вывести в выходной файл процесс умножения столбиком числа lhv (> 0) на число rhv (> 0).
 *
 * Пример (для lhv == 19935, rhv == 111):
19935
 *    111
--------
19935
+ 19935
+19935
--------
2212785
 * Используемые пробелы, отступы и дефисы должны в точности соответствовать примеру.
 * Нули в множителе обрабатывать так же, как и остальные цифры:
235
 *  10
-----
0
+235
-----
2350
 *
 */
fun printMultiplicationProcess(lhv: Int, rhv: Int, outputName: String) {
    val lenRhv: Int = numCounter(rhv)
    val lenLhv: Int = numCounter(lhv)
    var lenStr: Int = lenRhv + lenLhv
    var h: Int = 0
    val outputStream = File(outputName).bufferedWriter()

    while (h < lenRhv) {
        if (numCounter(pow( 10, h) * numGetter(rhv, lenRhv - h) * lhv) + 1 > lenStr)
            lenStr = numCounter(pow(10, h) * numGetter(rhv, lenRhv - h) * lhv) + 1
        h++
    }

    if (numCounter(lhv * rhv) + 1 > lenStr)
        lenStr = numCounter(lhv * rhv) + 1

    // первая строка
    for (i in 0 until lenStr - lenLhv)
        outputStream.write(" ")
    outputStream.write("$lhv")
    outputStream.newLine()

    // вторая стока
    outputStream.write("*")
    for (i in 0 until lenStr - lenRhv - 1)
        outputStream.write(" ")
    outputStream.write("$rhv")
    outputStream.newLine()

    // третья строка
    for (i in 0 until lenStr)
        outputStream.write("-")
    outputStream.newLine()

    // четвертая (первое слагаемое)
    var step: Int = numGetter(rhv, lenRhv) * lhv
    var lenStep: Int = numCounter(step)

    for (i in 0 until lenStr - lenStep)
        outputStream.write(" ")
    outputStream.write("$step")
    outputStream.newLine()

    if (lenRhv == 1) {
        for (i in 0 until lenStr)
            outputStream.write("-")
        outputStream.newLine()

        for (i in 0 until lenStr - lenStep)
            outputStream.write(" ")
        outputStream.write("$step")
        outputStream.close()
    } else {
        var sum: Int = step
        h = 1

        while (h < lenRhv) {
            step = numGetter(rhv, lenRhv - h) * lhv
            lenStep = numCounter(step)
            sum += step * pow(10, h)

            outputStream.write("+")
            for (i in 0 until lenStr - lenStep - h - 1)
                outputStream.write(" ")
            outputStream.write("$step")
            outputStream.newLine()
            h++
        }

        for (i in 0 until lenStr)
            outputStream.write("-")
        outputStream.newLine()

        for (i in 0 until lenStr - numCounter(sum))
            outputStream.write(" ")
        outputStream.write("$sum")
        outputStream.newLine()

        outputStream.close()
    }
}

/**
 * Вспомогательная
 *
 * Считает количество цифр в числе.
 */
fun numCounter(n: Int): Int {
    var count: Int = 0;
    var num: Int = n;

    if (num == 0)
        return 1

    while (num > 0) {
        num /= 10;
        count++;
    }
    return count;
}

/**
 * Вспомогательная
 *
 * Возвращает конкретную цифру с позиции pos, считая от начала числа.
 */
fun numGetter(n: Int, pos: Int): Int {
    var count: Int = numCounter(n);
    var num: Int = n;

    while (count > pos) {
        num /= 10;
        count--;
    }
    return num % 10;
}

/**
 * Вспомогательная
 *
 * Возвращает кусок числа от начала.
 */
fun numExtract(n: Int, len: Int, N: Int): Int {
    var num: Int = n;
    var lenn: Int = len

    while (lenn > N) { // <=
        num /= 10;
        lenn--;
    }
    return num;
}

/**
 * Сложная
 *
 * Вывести в выходной файл процесс деления столбиком числа lhv (> 0) на число rhv (> 0).
 *
 * Пример (для lhv == 19935, rhv == 22):
19935 | 22
-198     906
----
13
-0
--
135
-132
----
3

 * Используемые пробелы, отступы и дефисы должны в точности соответствовать примеру.
 *
 */
fun printDivisionProcess(lhv: Int, rhv: Int, outputName: String) {
    TODO()
    /*   val outputStream = File(outputName).bufferedWriter()
    var answer: Int = lhv / rhv
    var remain: Int = 0
    var lenL: Int = numCounter(lhv)
    var step : Int = 0
    var lenStep : Int = 0
    var shift = 2

    // первая строка
    outputStream.write("  $lhv | $rhv")
    outputStream.newLine()

    step = rhv * numGetter(answer, 0)
    lenStep = numCounter(step)
    remain = numExtract(lhv, lenL, lenStep) - step
    if (remain >= 0)
        outputStream.write(" -$step")
    else {
        var ss = 1

        outputStream.write("-$step")
    }

    for (i in 0..lenL - numCounter(step)) // mb 1
        outputStream.write(" ")
    outputStream.write("  $answer")
    outputStream.newLine()
    outputStream.write(" ")
    for (i in 0..lenStep) // mb +-1
        outputStream.write("-")
    outputStream.newLine()
    remain = numExtract(lhv, lenL, lenStep) - step
    

    outputStream.close()*/
}

