fun main() {
    //first lab
    //val lineWidth = -50
    //val text =
    //   "Есть над чем задуматься: предприниматели в сети интернет лишь добавляют фракционных разногласий и своевременно верифицированы! В своём стремлении улучшить пользовательский опыт мы упускаем, что реплицированные с зарубежных источников, современные исследования набирают популярность среди определенных слоев населения, а значит, должны быть объективно рассмотрены соответствующими инстанциями. Ясность нашей позиции очевидна: социально-экономическое развитие однозначно определяет каждого участника как способного принимать собственные решения касаемо дальнейших направлений развития."
    //print(alignText(text, lineWidth, Alignment.LEFT))
    //second lab
    //println(calculator("*2+3"))
    //println(calculator("-2--3"))
    //println( calculator("2+3)"))
    //println( calculator("(2+3"))
    //println(calculator("(-3^(-2+5)*4 + -2+3) * 2"))
    //third lab
    /*val shapeFactoryIMpl = ShapeFactoryImpl()
    val shapeList: MutableList<Shape> = arrayListOf()
    val figureOperations = FigureOperations()
    shapeList.add(shapeFactoryIMpl.createCircle(9.0))
    shapeList.add(shapeFactoryIMpl.createRandomCircle())
    shapeList.add(shapeFactoryIMpl.createSquare(25.0))
    shapeList.add(shapeFactoryIMpl.createRandomSquare())
    shapeList.add(shapeFactoryIMpl.createRectangle(18.0, 20.0))
    shapeList.add(shapeFactoryIMpl.createRandomRectangle())
    shapeList.add(shapeFactoryIMpl.createTriangle(14.0, 8.0, 11.0))
    shapeList.add(shapeFactoryIMpl.createRandomTriangle())
    shapeList.add(shapeFactoryIMpl.createRandomShape())
    println("The sum of all areas: ${figureOperations.sumArea(shapeList)}")
    println("The sum of all Perimeter: ${figureOperations.sumPerimeter(shapeList)}")
    println("Maximum area: ${figureOperations.maxPerimeter(shapeList)}")
    println("Minimum area: ${figureOperations.minPerimeter(shapeList)}")
    println("Maximum perimeter: ${figureOperations.maxArea(shapeList)}")
    println("Minimum perimeter: ${figureOperations.minArea(shapeList)}")*/
    // fourth lab
     val array1: Array<Array<Double>> =
         arrayOf(arrayOf(1.0, 6.0), arrayOf(2.0, 12.0))
     val array2: Array<Array<Double>> =
         arrayOf(arrayOf(1.0, 0.0), arrayOf(3.0, 2.0))
     val matrix1 = Matrix(array1)
     val matrix2 = Matrix(array2)
     val matrix3 = Matrix(array1)

     println((matrix1 + matrix2).toString())
     matrix3 += matrix2
     println(matrix3.toString())
     println((matrix1 - matrix2).toString())
     matrix3 -= matrix2
     println(matrix3.toString())
     println((matrix1 * matrix2).toString())
     matrix3 *= matrix2
     println(matrix3.toString())
     println((matrix1 * 3.0).toString())
     matrix3 *= 2.0
     println(matrix3.toString())
     println((matrix1 / 2.0).toString())
     matrix3 /= 2.0
     println(matrix3.toString())
     println(matrix3[0, 1])
     matrix3[0, 1] = 50.0
     println(matrix3[0, 1])

}