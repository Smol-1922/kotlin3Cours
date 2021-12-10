class Matrix(array: Array<Array<Double>>) {
    private var matrix: Array<Array<Double>> = emptyArray()
    private val row get() = matrix.size
    private val column get() = matrix[0].size

    init {
        if (array.isEmpty()) {
            throw IllegalArgumentException("Matrix is empty")
        }
        matrix = Array(array.size) { Array(array[0].size) { 0.0 } }
        for (row in array.indices) {
            for (column in array[0].indices)
                matrix[row][column] = array[row][column]
        }
    }

    operator fun plus(other: Matrix): Matrix {
        checkDimension(other)
        val result: Array<Array<Double>> = Array(other.row) { Array(other.column) { 0.0 } }
        for (row in result.indices)
            for (column in result[0].indices)
                result[row][column] = this[row, column] + other[row, column]
        return Matrix(result)
    }

    operator fun plusAssign(other: Matrix) {
        checkDimension(other)
        for (row in other.matrix.indices)
            for (column in other.matrix[0].indices)
                this[row, column] += other[row, column]
    }

    operator fun minus(other: Matrix): Matrix {
        checkDimension(other)
        val result: Array<Array<Double>> = Array(other.row) { Array(other.column) { 0.0 } }
        for (row in result.indices)
            for (column in result[0].indices)
                result[row][column] = this[row, column] - other[row, column]
        return Matrix(result)
    }

    operator fun minusAssign(other: Matrix) {
        checkDimension(other)
        for (row in other.matrix.indices)
            for (column in other.matrix[0].indices)
                this[row, column] -= other[row, column]
    }

    operator fun times(scalar: Double): Matrix {
        val result: Array<Array<Double>> = Array(row) { Array(column) { 0.0 } }
        for (row in matrix.indices)
            for (column in matrix[0].indices)
                result[row][column] = this[row, column] * scalar
        return Matrix(result)
    }

    operator fun times(other: Matrix): Matrix {
        checkDimension(other)
        val result: Array<Array<Double>> = Array(row) { Array(other.column) { 0.0 } }
        for (it in result.indices)
            for (column in result[0].indices)
                for (row in other.matrix.indices)
                    result[it][column] += this[it, row] * other[row, column]
        return Matrix(result)
    }

    operator fun timesAssign(scalar: Double) {
        for (row in matrix.indices)
            for (column in matrix[0].indices)
                this[row, column] *= scalar
    }

    operator fun timesAssign(other: Matrix) {
        checkDimension(other)
        val result: Array<Array<Double>> = Array(row) { Array(other.column) { 0.0 } }
        for (it in result.indices)
            for (column in result[0].indices)
                for (row in other.matrix.indices)
                    result[it][column] += this[it, row] * other[row, column]
        matrix = result
    }

    operator fun div(scalar: Double): Matrix {
        val result: Array<Array<Double>> = Array(row) { Array(column) { 0.0 } }
        for (row in matrix.indices)
            for (column in matrix[0].indices)
                result[row][column] = this[row, column] / scalar
        return Matrix(result)
    }

    operator fun divAssign(scalar: Double) {
        for (row in matrix.indices)
            for (column in matrix[0].indices)
                this[row, column] /= scalar
    }

    operator fun set(i: Int, j: Int, value: Double) {
        matrix[i][j] = value
    }

    operator fun get(i: Int, j: Int): Double {
        return matrix[i][j]
    }

    operator fun unaryMinus(): Matrix {
        val result: Array<Array<Double>> = Array(row) { Array(column) { 0.0 } }
        for (row in matrix.indices)
            for (column in matrix[0].indices)
                result[row][column] *= -1.0
        return Matrix(result)
    }

    operator fun unaryPlus(): Matrix {
        return this
    }

    override fun toString(): String {
        var string = ""
        for (row in matrix.indices) {
            for (column in matrix[0].indices)
                string += this[row, column].toString() + " "
            string += "\n"
        }
        return string
    }

    private fun checkDimension(other: Matrix) {
        if (column != other.row || (row != other.row && column != other.column))
            throw IllegalArgumentException("Wrong dimension of matrix")
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Matrix

        if (!matrix.contentDeepEquals(other.matrix)) return false

        return true
    }

    override fun hashCode(): Int {
        return matrix.contentDeepHashCode()
    }
}
