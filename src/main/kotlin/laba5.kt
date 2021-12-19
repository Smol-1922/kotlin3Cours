class Book(val substring: String, val author: Author, val genre: Genre, val year: Years)
class Author(val Name: String)
class User(val firstName: String, val lastName: String)
class Years(val year: Int)

enum class Genre {
    Fantasy,
    Horror,
    Novel,
    Collector

}

sealed class Status {
    object Available : Status()
    data class UsedBy(val user: User) : Status()
    object ComingSoon : Status()
    object Restoration : Status()
}

interface LibraryService {
    fun findBooks(substring: String): List<Book>?
    fun findBooks(author: Author): List<Book>?
    fun findBooks(year: Years): List<Book>?
    fun findBooks(genre: Genre): List<Book>?

    fun getAllBooks(): List<Book>?
    fun getAllAvailableBooks(): List<Book>?

    fun getBookStatus(book: Book): Status?

    fun getAllBookStatuses(): Map<Book, Status>?

    fun setBookStatus(book: Book, status: Status)

    fun addBook(book: Book, status: Status = Status.Available)

    fun registerUser(user: User)
    fun unregisterUser(user: User)

    fun takeBook(user: User, book: Book)
    fun returnBook(book: Book)
    fun sendForRestoration(book: Book)
    fun bookWillBeAvailable(book: Book)
}

class Library : LibraryService {
    private val books: MutableMap<Book, Status> = mutableMapOf()
    private val users: MutableList<User> = mutableListOf()
    override fun findBooks(substring: String): List<Book>? {
        val listBooks: MutableList<Book> = mutableListOf()
        for (key in books.keys) {
            if (key.substring == substring) {
                listBooks.add(key)
            }
        }
        if (listBooks.isEmpty())
            return null
        return listBooks
    }

    override fun findBooks(author: Author): List<Book>? {
        val listBooks: MutableList<Book> = mutableListOf()
        for (key in books.keys) {
            if (key.author == author) {
                listBooks.add(key)
            }
        }
        if (listBooks.isEmpty())
            return null
        return listBooks
    }

    override fun findBooks(year: Years): List<Book>? {
        val listBooks: MutableList<Book> = mutableListOf()
        for (key in books.keys) {
            if (key.year == year) {
                listBooks.add(key)
            }
        }
        if (listBooks.isEmpty())
            return null
        return listBooks
    }

    override fun findBooks(genre: Genre): List<Book>? {
        val listBooks: MutableList<Book> = mutableListOf()
        for (key in books.keys) {
            if (key.genre == genre) {
                listBooks.add(key)
            }
        }
        if (listBooks.isEmpty())
            return null
        return listBooks
    }

    override fun getAllBooks(): List<Book>? {
        val listBooks: MutableList<Book> = mutableListOf()
        for (key in books.keys) {
            listBooks.add(key)
        }
        if (listBooks.isEmpty())
            return null
        return listBooks
    }

    override fun getAllAvailableBooks(): List<Book>? {
        val listBooks: MutableList<Book> = mutableListOf()
        for ((key, value) in books) {
            if (value == Status.Available) {
                listBooks.add(key)
            }
        }
        if (listBooks.isEmpty())
            return null
        return listBooks
    }

    override fun getBookStatus(book: Book): Status? {
        for ((key, value) in books) {
            if (key == book) {
                return value
            }
        }
        return null
    }

    override fun getAllBookStatuses(): Map<Book, Status>? {
        if (books.isEmpty())
            return null
        return books
    }

    override fun setBookStatus(book: Book, status: Status) {
        if (books[book] != null)
            books[book] = status
    }

    override fun addBook(book: Book, status: Status) {
        books += book to status
    }

    override fun registerUser(user: User) {
        users.add(user)
    }

    override fun unregisterUser(user: User) {
        if (users.contains(user))
            users.remove(user)
    }

    override fun takeBook(user: User, book: Book) {
        if (books[book] != null && users.contains(user) && books[book] == Status.Available) {
            if (amountBook(user) < 3)
                books[book] = Status.UsedBy(user)
        }
    }


    override fun returnBook(book: Book) {
        if (books[book] != null)
            books[book] = Status.Available
    }

    override fun sendForRestoration(book: Book) {
        if (books[book] != null)
            books[book] = Status.Restoration
    }

    override fun bookWillBeAvailable(book: Book) {
        if (books[book] != null)
            books[book] = Status.ComingSoon
    }

    private fun amountBook(user: User): Int {
        var amount = 0
        for (value in books.values)
            if (value == Status.UsedBy(user))
                amount++
        return amount
    }
}