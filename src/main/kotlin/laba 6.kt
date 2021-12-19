class ShapeCollector<T : Shape> {
    private val allShapes = mutableListOf<T>()

    fun add(new: T) {
        allShapes.add(new)
    }

    fun addAll(new: MutableList<T>) {
        allShapes.addAll(new)
    }

    fun getAll(): List<T> {
        return allShapes
    }

    fun getAllSorted(comparator: Comparator<in T>): List<T> {
        return allShapes.sortedWith(comparator)
    }
}

object ShapeComparators {
    val sortAreaIncrease = compareBy<Shape> { it.calcArea() }
    val sortPerimeterIncrease = compareBy<Shape> { it.calcPerimeter() }
    val sortAreaDecreasing = compareBy<Shape> { -it.calcArea() }
    val sortPerimeterDecreasing = compareBy<Shape> { -it.calcPerimeter() }
    val sortRadiusDecreasing = compareBy<Circle> { -it.radius }
    val sortRadiusIncrease = compareBy<Circle> { it.radius }
}