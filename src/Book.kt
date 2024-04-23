import java.time.LocalDate

enum class BOOK_STATUS {
    UNINITIALIZED,
    IN,
    OUT,
    OUT_LOCALLY,    //read locally
    MISSING
}


class Book(
    var title: String,
    var author: String,
    var pages: Int,
    var date_published: LocalDate,
    var book_id: Int,    //on the book
    var category: BOOK_CATEGORY,   //enum
    var libraryId: LIBRARY_ID,     //enum
) {
    //properties for borrowing
    private var status: BOOK_STATUS = BOOK_STATUS.UNINITIALIZED
    private var current_reader: Reader? = null
    var prev_readers = mutableListOf<Reader>()
    private var back_date: LocalDate? = LocalDate.of(2000, 1, 1)


    init {
        status = BOOK_STATUS.IN
        println("Book added, title: ${this.title}, author: ${this.author}, pages: ${this.pages}, released: ${this.date_published}, category: ${this.category}")

    }

    fun borrow(borrower: Reader, mon_add: Int): Boolean {
        if(borrower.is_license_expired()){
            println("Sorry ${borrower.name}, your license expired at ${borrower.license_expires}")
            return false
        }
        if (status == BOOK_STATUS.IN) {
            current_reader = borrower
            if (mon_add == 0) {
                status = BOOK_STATUS.OUT_LOCALLY
                println("$title by $author has been borrowed locally by reader ${borrower.name}")
            } else {
                status = BOOK_STATUS.OUT
                back_date = LocalDate.now().plusMonths(mon_add.toLong())
                println("$title by $author has been borrowed until $back_date by reader ${borrower.name}")
            }
            return true
        } else {
            println("Sorry ${borrower.name}, $title by $author is currently unavailable: status: $status")
            if (status == BOOK_STATUS.OUT) {
                println("Will be available from $back_date")
            }
            return false
        }
    }

    fun back(): Unit {
        if (status != BOOK_STATUS.IN) {
            println("$title by $author has been returned by reader ${current_reader?.name} at ${LocalDate.now()}")
            status = BOOK_STATUS.IN
            back_date = LocalDate.now()
            //same reader can be added multiple times
            current_reader?.let { prev_readers.add(it) }
            current_reader = null
        }
        else{
            println("We alredy have this book!")
        }
    }
}