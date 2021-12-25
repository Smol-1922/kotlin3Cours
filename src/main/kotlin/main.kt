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
    /* val array1: Array<Array<Double>> =
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
     println(matrix3[0, 1])*/
    //fifth lab
    /*val library = Library()
    val book1 = Book("Financier", Author("Theodore Dreiser"), Genre.Novel, Years(1912))
    val book2 = Book("Gifts of the Magi", Author("O.Henry"), Genre.Collector, Years(1905))
    val book3 = Book("Nightmares and fantastic visions", Author("Stephen King"), Genre.Collector, Years(1993))
    val book4 = Book("Slimming", Author("Stephen King"), Genre.Horror, Years(1984))
    val book5 = Book("Barnyard", Author("George Orwell"), Genre.Fantasy, Years(1944))
    val book6 = Book("For whom the Bell Tolls", Author("Ernest Hemingway"), Genre.Fantasy, Years(1940))
    library.addBook(book1, Status.Available)
    library.addBook(book2, Status.Available)
    library.addBook(book3, Status.Available)
    library.addBook(book4, Status.Available)
    library.findBooks(Author("Stephen King"))
    library.findBooks("Financier")
    library.findBooks(Genre.Horror)
    library.findBooks("Barnyard")
    library.addBook(book5, Status.Available)
    library.bookWillBeAvailable(book5)
    val user1 = User("Dmitriy", "Kvitko")
    val user2 = User("Tom", "Maklaren")
    val user3 = User("Dave", "Nortin")
    library.registerUser(user1)
    library.registerUser(user2)
    library.registerUser(user3)
    library.takeBook(user1, book5)
    library.takeBook(user1, book2)
    library.takeBook(user1, book3)
    library.addBook(book6, Status.Available)
    library.sendForRestoration(book6)
    library.unregisterUser(user3)
    val list:List<Book>? = library.getAllAvailableBooks()
    if (list != null) {
        for (iter in list) {
            println(iter.substring)
        }
    }*/
        //sixth lab
      /*   val shapeFactoryIMpl = ShapeFactoryImpl()
     val shapeCollector = ShapeCollector<Shape>()
     val shapeComparator = ShapeComparators
     val listShape: MutableList<Shape> = mutableListOf(
         shapeFactoryIMpl.createRandomShape(),
         shapeFactoryIMpl.createRandomSquare(),
         shapeFactoryIMpl.createRandomRectangle(),
         shapeFactoryIMpl.createRandomRectangle()
     )
     shapeCollector.add(shapeFactoryIMpl.createRandomTriangle())
     shapeCollector.addAll(listShape)
     val listSortAreaIncrease: List<Shape> = shapeCollector.getAllSorted(shapeComparator.sortAreaIncrease)
     for (it in listSortAreaIncrease) {
         println(it.calcArea())
     }
     println()
     val listSortAreaDecreasing: List<Shape> = shapeCollector.getAllSorted(shapeComparator.sortAreaDecreasing)
     for (it in listSortAreaDecreasing) {
         println(it.calcArea())
     }
     println()
     val listSortPerimeterDecreasing: List<Shape> = shapeCollector.getAllSorted(shapeComparator.sortPerimeterDecreasing)
     for (it in listSortPerimeterDecreasing) {
         println(it.calcPerimeter())
     }
     println()
     val listSortPerimeterIncrease: List<Shape> = shapeCollector.getAllSorted(shapeComparator.sortPerimeterIncrease)
     for (it in listSortPerimeterIncrease) {
         println(it.calcPerimeter())
     }
    println()
     val listCircle = ShapeCollector<Circle>()
     listCircle.add(shapeFactoryIMpl.createRandomCircle())
     listCircle.add(shapeFactoryIMpl.createRandomCircle())
     listCircle.add(shapeFactoryIMpl.createRandomCircle())
     val listSortRadiusIncrease: List<Circle> = listCircle.getAllSorted(shapeComparator.sortRadiusIncrease)
     for (it in listSortRadiusIncrease) {
         println(it.radius)
     }
    println()
    val listSortRadiusDecreasing: List<Circle> = listCircle.getAllSorted(shapeComparator.sortRadiusDecreasing)
     for (it in listSortRadiusDecreasing) {
         println(it.radius)
     }
    val allShape:List<Shape> = shapeCollector.getAll()
    println(allShape)
*/
    // seventh lab
    val inputPath = "F:\\untitled5\\src\\main\\kotlin\\IN.json"
    val outputPath = "F:\\untitled5\\src\\main\\kotlin\\OUT.json"

    val shapeFactory = ShapeFactoryImpl()

    val shapeList: MutableList<Shape> = Serialization.deserialization(FileIO.readFromFile(inputPath)).toMutableList()
    shapeList.add(shapeFactory.createRandomShape())
    shapeList.add(shapeFactory.createRandomShape())
    shapeList.add(shapeFactory.createRandomShape())
    FileIO.writeToFile(Serialization.serialization(shapeList), outputPath)
}