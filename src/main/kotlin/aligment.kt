enum class Alignment {
    LEFT,
    RIGHT,
    CENTER,
    JUSTIFY
}

fun alignText(
    text: String,
    lineWidth: Int = 120,
    alignment: Alignment = Alignment.LEFT
): String {
    if (lineWidth < 1)
        throw Exception("String size is zero or negative")
    var textNoSpace = text
    while (textNoSpace.contains("  "))
        textNoSpace = textNoSpace.replace("  ", " ")
    textNoSpace = textNoSpace.trim()
    return when (alignment) {
        Alignment.LEFT -> alignTextLeft(textNoSpace, lineWidth)
        Alignment.RIGHT -> alignTextRight(text, lineWidth)
        Alignment.CENTER -> alignTextCenter(text, lineWidth)
        Alignment.JUSTIFY -> alignTextJustify(text, lineWidth)
    }

}

private fun alignTextLeft(
    text: String,
    lineWidth: Int
): String {
    var result = ""
    var line: String
    line = if (text.length > lineWidth)
        text.substring(0, lineWidth)
    else
        text
    var indexOfLastSymbol = 0
    var indexOfFirstSymbol: Int
    while (indexOfLastSymbol < text.length) {
        indexOfFirstSymbol = indexOfLastSymbol
        indexOfLastSymbol += lineWidth
        if (line.lastIndexOf(' ') == -1 || line.length == text.length) {
            line = if (indexOfLastSymbol > text.length)
                text.substring(indexOfFirstSymbol, text.length)
            else
                text.substring(indexOfFirstSymbol, indexOfLastSymbol)
        } else {
            if (text[indexOfLastSymbol] == ' ')
                indexOfLastSymbol++
            else {
                indexOfLastSymbol += line.lastIndexOf(' ') - (lineWidth - 1)
                line = text.substring(indexOfFirstSymbol, indexOfLastSymbol)
            }
        }
        result += line + "\n"
        if (indexOfLastSymbol + lineWidth < text.length)
            line = text.substring(indexOfLastSymbol, indexOfLastSymbol + lineWidth)
        else {
            if (text.length - indexOfLastSymbol > 0) {
                line = text.substring(indexOfLastSymbol, text.length)
                result += line
            }
            break
        }
    }
    return result
}

private fun alignTextRight(
    text: String,
    lineWidth: Int
): String {
    var result = ""
    var line: String
    line = if (text.length > lineWidth)
        text.substring(0, lineWidth)
    else
        text// Добавить в начало вызывающей функции
    var indexOfLastSymbol = 0
    var indexOfFirstSymbol: Int
    while (indexOfLastSymbol < text.length + lineWidth) {
        indexOfFirstSymbol = indexOfLastSymbol
        indexOfLastSymbol += lineWidth
        if (line.lastIndexOf(' ') == -1 || line.length == text.length) { //Последний пробел в строке(если нет)
            if (indexOfLastSymbol > text.length) {
                line = text.substring(indexOfFirstSymbol, text.length)//Если текст состоит из одной строки
                line = line.padStart(lineWidth, ' ')
            } else
                line = text.substring(indexOfFirstSymbol, indexOfLastSymbol)
        } else {// Если пробел есть
            if (text[indexOfLastSymbol] == ' ')// Если следующий знак после конца строки пробел, значит ничего ровнять не нужно
                indexOfLastSymbol++// не пишем пробел
            else {
                indexOfLastSymbol += line.lastIndexOf(' ') - (lineWidth - 1)// берем индекс последнего пробела
                line = text.substring(indexOfFirstSymbol, indexOfLastSymbol - 1)// не берем пробел
                line = line.padStart(lineWidth, ' ')
            }
        }
        result += line + "\n"
        if (indexOfLastSymbol + lineWidth <= text.length)// Если текст на этом заканчивается
            line = text.substring(indexOfLastSymbol, indexOfLastSymbol + lineWidth)
        else {
            if (text.length - indexOfLastSymbol > 0) {
                line = text.substring(indexOfLastSymbol, text.length)
                line = line.padStart(lineWidth, ' ')
                result += line
            }
            break

        }
    }
    return result
}

private fun alignTextCenter(
    text: String,
    lineWidth: Int
): String {
    var result = ""
    var line: String
    line = if (text.length > lineWidth)
        text.substring(0, lineWidth)
    else
        text// Добавить в начало вызывающей функции
    var indexOfLastSymbol = 0
    var indexOfFirstSymbol: Int
    while (indexOfLastSymbol < text.length) {
        indexOfFirstSymbol = indexOfLastSymbol
        indexOfLastSymbol += lineWidth
        if (line.lastIndexOf(' ') == -1 || line.length == text.length) { //Последний пробел в строке(если нет)
            if (indexOfLastSymbol > text.length) {
                line = text.substring(indexOfFirstSymbol, text.length)//Если текст состоит из одной строки
                line = line.padEnd(text.length + (lineWidth - text.length) / 2, ' ')
                line = line.padStart(lineWidth, ' ')
            } else
                line = text.substring(indexOfFirstSymbol, indexOfLastSymbol)
        } else {// Если пробел есть
            if (text[indexOfLastSymbol] == ' ')// Если следующий знак после конца строки пробел, значит ничего ровнять не нужно
                indexOfLastSymbol++// не пишем пробел
            else {
                indexOfLastSymbol += line.lastIndexOf(' ') - (lineWidth - 1)// берем индекс последнего пробела
                line = text.substring(indexOfFirstSymbol, indexOfLastSymbol - 1)
                line = line.padEnd(
                    (indexOfLastSymbol - indexOfFirstSymbol) + (lineWidth - (indexOfLastSymbol - indexOfFirstSymbol)) / 2,
                    ' '
                )
                line = line.padStart(lineWidth, ' ')
            }
        }
        result += line + "\n"
        if (indexOfLastSymbol + lineWidth < text.length)// Если текст на этом заканчивается
            line = text.substring(indexOfLastSymbol, indexOfLastSymbol + lineWidth)
        else {
            if (text.length - indexOfLastSymbol > 0) {
                line = text.substring(indexOfLastSymbol, text.length)
                line = line.padEnd(
                    (text.length - indexOfLastSymbol) + (lineWidth - (text.length - indexOfLastSymbol)) / 2,
                    ' '
                )
                line = line.padStart(lineWidth, ' ')
                result += line
            }
            break
        }
    }
    return result
}

private fun alignTextJustify(
    text: String,
    lineWidth: Int
): String {
    var result = ""
    var line: String
    line = if (text.length > lineWidth)
        text.substring(0, lineWidth)
    else
        text// Добавить в начало вызывающей функции
    var indexOfLastSymbol = 0
    var s: Int
    while (indexOfLastSymbol < text.length) {
        s = indexOfLastSymbol
        indexOfLastSymbol += lineWidth
        if (line.lastIndexOf(' ') == -1 || line.length == text.length) { //Последний пробел в строке(если нет)
            line = if (indexOfLastSymbol > text.length) {
                text.substring(s, text.length)//Если текст состоит из одной строки
            } else
                text.substring(s, indexOfLastSymbol)
        } else {// Если пробел есть
            if (text[indexOfLastSymbol] == ' ')// Если следующий знак после конца строки пробел, значит ничего ровнять не нужно
                indexOfLastSymbol++// не пишем пробел
            else {
                indexOfLastSymbol += line.lastIndexOf(' ') - (lineWidth - 1)// берем индекс последнего пробела
                line = addSpace(text.substring(s, indexOfLastSymbol - 1), lineWidth, indexOfLastSymbol - s - 1)
            }
        }
        line = line.trim()
        result += line + "\n"
        if (indexOfLastSymbol + lineWidth < text.length)// Если текст на этом заканчивается
            line = text.substring(indexOfLastSymbol, indexOfLastSymbol + lineWidth)
        else {
            if (text.length - indexOfLastSymbol > 0) {
                line = text.substring(indexOfLastSymbol, text.length)
                result += line
            }
            break
        }
    }
    return result
}

private fun addSpace(line: String, lineWidth: Int, r: Int): String {
    var amountOfSpaces = -1
    for (word in line.split(' ')) {
        amountOfSpaces++//количество пробелов
    }
    if (amountOfSpaces == 0)
        return line
    var result = ""
    val amountOfCharactersMissing = lineWidth - r + amountOfSpaces// количество недостающих симмволов
    var extraSpaces = amountOfCharactersMissing % amountOfSpaces// количество строк с дополнительными пробелами
    for (word in line.split(' ')) {
        result += word
        if (result.length == lineWidth)
            break
        for (i in 1..(amountOfCharactersMissing / amountOfSpaces)) {
            result += " "
        }
        if (extraSpaces > 0) {
            result += " "
            extraSpaces--
        }

    }
    return result
}