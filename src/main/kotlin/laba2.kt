import java.util.*
import kotlin.math.pow

fun calculator(infixString: String) {
    val list = stringInList(infixString)
    if (list.isEmpty())
        throw IllegalArgumentException("You entered nothing")
    val postfix = postfix(list)
    print(computation(postfix))
}

private fun stringInList(infixString: String): MutableList<String> {
    parentheses(infixString)
    val listValue: MutableList<String> = mutableListOf()
    var symbol = ""
    for (iter in infixString) {
        if (iter == '+' || iter == '-' || iter == '/' || iter == '*' || iter == '^' || iter == ')' || iter == '(') { // Если символ равен операции
            if (symbol.isNotEmpty()) {// If there is something in the symbol variable, add to List
                listValue.add(symbol)
                symbol = ""
            }
            symbol += iter
            listValue.add(symbol)// add operation to List
            symbol = ""
        } else if (iter != ' ')
            symbol += iter
        if (symbol.toDoubleOrNull() == null && iter != ' ' && symbol != "") // if there is no number or space in the variable symbol, an exception is made
            throw IllegalArgumentException("You entered unrecognized characters")
    }
    if (symbol.isNotEmpty())
        listValue.add(symbol)
    return listValue
}

private fun parentheses(infixString: String) {// counts the number of parentheses that open and close if not equal the exception
    val openCloseParentheses = infixString.filter { it == '(' || it == ')' }
    var open = 0
    var close = 0
    for (it in openCloseParentheses) {
        if (it == '(')
            open++
        else
            close++
    }
    if (close != open) {
        throw IllegalArgumentException("Not equal number of closing and opening parentheses")
    }
}

private fun postfix(listValue: MutableList<String>): MutableList<String> {
    var flag = false
    val stack = Stack<String>()
    var iter = 0
    val queue: MutableList<String> = mutableListOf()
    while (iter < listValue.size) {
        when (listValue[iter]) {
            "(" -> {//add to the stack
                stack.push(listValue[iter])
                flag = true
            }
            ")" -> {// unload all the stakes before the opening bracket
                unloading(queue, stack, priority(listValue[iter]))
            }
            "*", "/" -> {//if the top priority in the stack is greater than or equal to the priority of the operation unload after adding the operation to the stack
                if (flag || iter == 0) {
                    throw IllegalArgumentException("Incorrect input")
                }
                if (stack.isNotEmpty() && priority(stack.peek()) >= 2)
                    unloading(queue, stack, priority(listValue[iter]))
                stack.push(listValue[iter])
                flag = true
            }
            "^" -> {
                if (flag || iter == 0) {
                    throw IllegalArgumentException("Incorrect input")
                }
                stack.push(listValue[iter])
                flag = true
            }
            "+", "-" -> {// if binary operation is first, after bracket or after operation , then we check this with variable flag, if it is true, then before binary operation there is another operation, and we need to check that after this operation there is a number, if the number is not, then make an error
                if (iter == 0 || (listValue[iter - 1] == "(" && listValue[iter + 1].toDoubleOrNull() != null) || (flag && listValue[iter + 1].toDoubleOrNull() != null)) {
                    iter++
                    queue.add(listValue[iter - 1] + listValue[iter])
                    flag = false
                } else {
                    if (flag || iter == 0) {
                        throw IllegalArgumentException("Incorrect input")
                    }
                    if (stack.isEmpty() || stack.peek() == "(") stack.push(listValue[iter])
                    else if (priority(stack.peek()) >= 1) {//If the priority of the top operation is greater than the +- operation, the stack shall be unloaded
                        unloading(queue, stack, priority(listValue[iter]))
                        stack.push(listValue[iter])
                    } else
                        stack.push(listValue[iter])
                    flag = true
                }
            }
            else -> {// if the number is added to the queue
                flag = false
                queue.add(listValue[iter])
            }
        }
        iter++
    }
    if (stack.isNotEmpty()) {// if the stack is not empty then unload all
        while (stack.isNotEmpty())
            queue.add(stack.pop())
    }
    return queue
}

private fun priority(operation: String): Int {
    return when (operation) {
        "(", ")" -> 0
        "^" -> 3
        "*", "/" -> 2
        "+", "-" -> 1
        else -> 4
    }
}

private fun unloading(
    queue: MutableList<String>,
    stack: Stack<String>,
    prioritySymbol: Int
) {//unload all operations that are greater or equal to the priority of the operation to the queue
    while (priority(stack.peek()) >= prioritySymbol) {
        if (priority(stack.peek()) == 0) {
            stack.pop()
            break
        }
        queue.add(stack.pop())
        if (stack.isEmpty())
            break
    }
}

private fun computation(queue: MutableList<String>): String {
    val stack = Stack<String>()
    var firstNumber: Double
    var secondNumber: Double
    for (iter in queue) {
        when (iter) {
            "*" -> {
                secondNumber = stack.pop().toDouble()
                firstNumber = stack.pop().toDouble()
                stack.push((firstNumber * secondNumber).toString())
            }
            "/" -> {
                secondNumber = stack.pop().toDouble()
                if (secondNumber == 0.0) {
                    throw IllegalArgumentException("Cannot be divisible by 0")
                }
                firstNumber = stack.pop().toDouble()
                stack.push((firstNumber / secondNumber).toString())
            }
            "^" -> {
                secondNumber = stack.pop().toDouble()
                firstNumber = stack.pop().toDouble().pow(secondNumber)
                stack.push(firstNumber.toString())
            }
            "+" -> {
                secondNumber = stack.pop().toDouble()
                firstNumber = stack.pop().toDouble()
                stack.push((firstNumber + secondNumber).toString())
            }
            "-" -> {
                secondNumber = stack.pop().toDouble()
                firstNumber = stack.pop().toDouble()
                stack.push((firstNumber - secondNumber).toString())
            }
            else -> stack.push(iter)
        }
    }
    return stack.pop()
}