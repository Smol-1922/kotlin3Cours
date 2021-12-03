fun main() {
    //first lab
    //val lineWidth = -50
    //val text =
    //   "Есть над чем задуматься: предприниматели в сети интернет лишь добавляют фракционных разногласий и своевременно верифицированы! В своём стремлении улучшить пользовательский опыт мы упускаем, что реплицированные с зарубежных источников, современные исследования набирают популярность среди определенных слоев населения, а значит, должны быть объективно рассмотрены соответствующими инстанциями. Ясность нашей позиции очевидна: социально-экономическое развитие однозначно определяет каждого участника как способного принимать собственные решения касаемо дальнейших направлений развития."
    //print(alignText(text, lineWidth, Alignment.LEFT))
    //second lab
    //calculator("*2+3")
    //calculator("-2--3")
    // calculator("2+3)")
    // calculator("(2+3")
    //calculator("(-3^(-2+5)*4 + -2+3) * 2")
    //third lab
    val shapeFactory = ShapeFactoryImpl()
    val shapeList: MutableList<Shape> = arrayListOf()
    val figureOperations = FigureOperations()
    shapeList.add(shapeFactory.createCircle(9.0))
    shapeList.add(shapeFactory.createRandomCircle())
    shapeList.add(shapeFactory.createSquare(25.0))
    shapeList.add(shapeFactory.createRandomSquare())
    shapeList.add(shapeFactory.createRectangle(18.0,20.0))
    shapeList.add(shapeFactory.createRandomRectangle())
    shapeList.add(shapeFactory.createTriangle(14.0,8.0,11.0))
    shapeList.add(shapeFactory.createRandomTriangle())
    shapeList.add(shapeFactory.createRandomShape())
    println("The sum of all areas: ${figureOperations.sumArea(shapeList)}")
    println("The sum of all Perimeter: ${figureOperations.sumPerimeter(shapeList)}")
    println("Maximum area: ${figureOperations.maxPerimetr(shapeList)}")
    println("Minimum area: ${figureOperations.minPerimetr(shapeList)}")
    println("Maximum perimeter: ${figureOperations.maxArea(shapeList)}")
    println("Minimum perimeter: ${figureOperations.minArea(shapeList)}")
}