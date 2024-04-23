import java.time.LocalDate

fun main() {
/*
    //add library
    val library = Library(LIBRARY_ID.DISTRICT_01, "New York, whatever address")
    //add section
    val section = Section(BOOK_CATEGORY.SCI_FI, LIBRARY_ID.DISTRICT_01)
*/
    //add book
    val book = Book("Alien", "Alan Dean Foster", 100, LocalDate.of(2000, 1, 1), 123456, BOOK_CATEGORY.SCI_FI, LIBRARY_ID.DISTRICT_01)

    //add reader
    val reader_joe = Reader("Joe", 21)
    val reader_jane = Reader("Jane", 42)

    book.borrow(reader_joe,0)

    //extend license of reader
    if(reader_joe.is_license_expired()) {
        val extension_period = 24
        reader_joe.extend_license_with_months(extension_period)
    }

    book.borrow(reader_joe,0)

    //extend license of reader
    if(reader_jane.is_license_expired()) {
        val extension_period = 1
        reader_jane.extend_license_with_months(extension_period)
    }

    book.borrow(reader_jane,1)
    book.back()
    book.borrow(reader_jane,1)
    book.borrow(reader_joe,1)
    book.back()
    book.back()
}

