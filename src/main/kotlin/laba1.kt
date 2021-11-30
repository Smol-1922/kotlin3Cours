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
        if (line.lastIndexOf(' ') == -1 || line.length == text.length) {
            if (indexOfLastSymbol > text.length) {
                line = text.substring(indexOfFirstSymbol, text.length)
                line = line.padStart(lineWidth, ' ')
            } else
                line = text.substring(indexOfFirstSymbol, indexOfLastSymbol)
        } else {
            if (text[indexOfLastSymbol] == ' ')
                indexOfLastSymbol++
            else {
                indexOfLastSymbol += line.lastIndexOf(' ') - (lineWidth - 1)
                line = text.substring(indexOfFirstSymbol, indexOfLastSymbol - 1)
                line = line.padStart(lineWidth, ' ')
            }
        }
        result += line + "\n"
        if (indexOfLastSymbol + lineWidth <= text.length)
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
        text
    var indexOfLastSymbol = 0
    var indexOfFirstSymbol: Int
    while (indexOfLastSymbol < text.length) {
        indexOfFirstSymbol = indexOfLastSymbol
        indexOfLastSymbol += lineWidth
        if (line.lastIndexOf(' ') == -1 || line.length == text.length) {
            if (indexOfLastSymbol > text.length) {
                line = text.substring(indexOfFirstSymbol, text.length)
                line = line.padEnd(text.length + (lineWidth - text.length) / 2, ' ')
                line = line.padStart(lineWidth, ' ')
            } else
                line = text.substring(indexOfFirstSymbol, indexOfLastSymbol)
        } else {// Если пробел есть
            if (text[indexOfLastSymbol] == ' ')
                indexOfLastSymbol++// не пишем пробел
            else {
                indexOfLastSymbol += line.lastIndexOf(' ') - (lineWidth - 1)
                line = text.substring(indexOfFirstSymbol, indexOfLastSymbol - 1)
                line = line.padEnd(
                    (indexOfLastSymbol - indexOfFirstSymbol) + (lineWidth - (indexOfLastSymbol - indexOfFirstSymbol)) / 2,
                    ' '
                )
                line = line.padStart(lineWidth, ' ')
            }
        }
        result += line + "\n"
        if (indexOfLastSymbol + lineWidth < text.length)
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
        text
    var indexOfLastSymbol = 0
    var indexOfFirstSymbol: Int
    while (indexOfLastSymbol < text.length) {
        indexOfFirstSymbol = indexOfLastSymbol
        indexOfLastSymbol += lineWidth
        if (line.lastIndexOf(' ') == -1 || line.length == text.length) {
            line = if (indexOfLastSymbol > text.length) {
                text.substring(indexOfFirstSymbol, text.length)
            } else
                text.substring(indexOfFirstSymbol, indexOfLastSymbol)
        } else {
            if (text[indexOfLastSymbol] == ' ')
                indexOfLastSymbol++
            else {
                indexOfLastSymbol += line.lastIndexOf(' ') - (lineWidth - 1)
                line = addSpace(
                    text.substring(indexOfFirstSymbol, indexOfLastSymbol - 1),
                    lineWidth,
                    indexOfLastSymbol - indexOfFirstSymbol - 1
                )
            }
        }
        line = line.trim()
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

private fun addSpace(line: String, lineWidth: Int, lengthOfString: Int): String {
    var amountOfSpaces = -1
    for (word in line.split(' ')) {
        amountOfSpaces++
    }
    if (amountOfSpaces == 0)
        return line
    var result = ""
    val amountOfCharactersMissing = lineWidth - lengthOfString + amountOfSpaces
    var extraSpaces = amountOfCharactersMissing % amountOfSpaces
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