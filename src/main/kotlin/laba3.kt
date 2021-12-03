import kotlin.math.*

interface Shape {
    fun calcArea(): Double
    fun calcPerimeter(): Double
}

class Circle(private val radius: Double) : Shape {
    init {
        if (radius <= 0)
            throw IllegalArgumentException("radius cannot be less than or equal to 0")
    }

    override fun calcArea(): Double {
        return PI * radius.pow(2)
    }

    override fun calcPerimeter(): Double {
        return 2 * PI * radius
    }

}

class Square(private val side: Double) : Shape {
    init {
        if (side <= 0)
            throw IllegalArgumentException("side of square cannot be less than or equal to 0")
    }

    override fun calcArea(): Double {
        return side.pow(2)
    }

    override fun calcPerimeter(): Double {
        return side * 4
    }

}

class Rectangle(private val sideA: Double, private val sideB: Double) : Shape {
    init {
        if (sideA <= 0 || sideB <= 0)
            throw IllegalArgumentException("side of rectangle cannot be less than or equal to 0")
    }

    override fun calcArea(): Double {
        return sideA * sideB
    }

    override fun calcPerimeter(): Double {
        return sideB * 2 + sideA * 2
    }

}

class Triangle(private val sideA: Double, private val sideB: Double, private val sideC: Double) : Shape {
    init {
        if (sideA <= 0 || sideB <= 0 || sideC <= 0)
            throw IllegalArgumentException("side of triangle cannot be less than or equal to 0")
        if (sideA + sideB <= sideC || sideB + sideC <= sideA || sideC + sideA <= sideB) {
            throw IllegalArgumentException("one side is greater than or equal to the sum of the remaining")
        }
    }

    override fun calcArea(): Double {
        return sqrt(calcPerimeter() / 2 * (calcPerimeter() / 2 - sideA) * (calcPerimeter() / 2 - sideB) * (calcPerimeter() / 2 - sideC))
    }

    override fun calcPerimeter(): Double {
        return sideA + sideB + sideC
    }

}

interface ShapeFactory {
    fun createCircle(radius: Double): Circle
    fun createSquare(side: Double): Square
    fun createRectangle(sideA: Double, sideB: Double): Rectangle
    fun createTriangle(sideA: Double, sideB: Double, sideC: Double): Triangle

    fun createRandomCircle(): Circle
    fun createRandomSquare(): Square
    fun createRandomRectangle(): Rectangle
    fun createRandomTriangle(): Triangle

    fun createRandomShape(): Shape
}

class ShapeFactoryImpl : ShapeFactory {
    override fun createCircle(radius: Double): Circle {
        return Circle(radius)
    }

    override fun createSquare(side: Double): Square {
        return Square(side)
    }

    override fun createRectangle(sideA: Double, sideB: Double): Rectangle {
        return Rectangle(sideA, sideB)
    }

    override fun createTriangle(sideA: Double, sideB: Double, sideC: Double): Triangle {
        return Triangle(sideA, sideB, sideC)
    }

    override fun createRandomCircle(): Circle {
        return Circle((1..50).random().toDouble())
    }

    override fun createRandomSquare(): Square {
        return Square((1..50).random().toDouble())
    }

    override fun createRandomRectangle(): Rectangle {
        return Rectangle((1..50).random().toDouble(), (1..50).random().toDouble())
    }

    override fun createRandomTriangle(): Triangle {
        val sideA = (1..50).random().toDouble()
        val sideB = (1..50).random().toDouble()
        val sideC = (abs(sideA - sideB).toInt() + 1..(sideA + sideB).toInt()).random().toDouble()
        return Triangle(sideA, sideB, sideC)
    }

    override fun createRandomShape(): Shape {
        return when ((1..4).random()) {
            1 -> createRandomCircle()
            2 -> createRandomSquare()
            3 -> createRandomRectangle()
            4 -> createRandomTriangle()
            else -> throw Exception("Hmm.....")
        }
    }
}

class FigureOperations {
    fun sumArea(listShape: MutableList<Shape>): Double {
        var sum = 0.0
        for (it in listShape)
            sum += it.calcArea()
        return sum
    }

    fun sumPerimeter(listShape: MutableList<Shape>): Double {
        var sum = 0.0
        for (it in listShape)
            sum += it.calcPerimeter()
        return sum
    }

    fun maxPerimetr(listShape: MutableList<Shape>): Shape {
        var max = 0.0
        var shape: Shape = listShape.first()
        for (it in listShape)
            if (it.calcPerimeter() > max) {
                max = it.calcPerimeter()
                shape = it
            }
        return shape
    }

    fun minPerimetr(listShape: MutableList<Shape>): Shape {
        var min = 350.0//больше 300 не может быть
        var shape: Shape = listShape.first()
        for (it in listShape)
            if (it.calcPerimeter() < min) {
                min = it.calcPerimeter()
                shape = it
            }
        return shape
    }

    fun maxArea(listShape: MutableList<Shape>): Shape {
        var max = 0.0
        var shape: Shape = listShape.first()
        for (it in listShape)
            if (it.calcArea() > max) {
                max = it.calcArea()
                shape = it
            }
        return shape
    }

    fun minArea(listShape: MutableList<Shape>): Shape {
        var min = 8000.0
        var shape: Shape = listShape.first()
        for (it in listShape)
            if (it.calcArea() < min) {
                min = it.calcArea()
                shape = it
            }
        return shape
    }
}