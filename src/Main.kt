import java.time.LocalDate

fun main() {
    //add library
    val library = Library(LIBRARY_ID.MAIN_LIBRARY, "New York, whatever address")
    //add section
    val sectionSCIFI = Section(BOOK_CATEGORY.SCI_FI)
    //add section to library
    library.add_section(sectionSCIFI)
    library.add_section(sectionSCIFI)

    //add book
    val book = Book("Alien", "Alan Dean Foster", 100, LocalDate.of(2000, 1, 1), 123456, BOOK_CATEGORY.SCI_FI)

    //add, remove book to library
    library.addBook(book)
    library.addBook(book)
    library.removeBook(book)
    library.addBook(book)
    library.list_sections()
    library.list_books()

    //add reader
    val reader_joe = Reader("Joe", LocalDate.of(2001, 1, 1))
    val reader_jane = Reader("Jane", LocalDate.of(1984, 12, 20))

    library.borrow(123456, reader_joe, 0)

    //extend license of reader
    if(reader_joe.is_license_expired()) {
        val extension_period = 24
        reader_joe.extend_license_with_months(extension_period)
    }
    library.borrow(123456, reader_joe, 0)
    library.borrow(123456, reader_joe, 0)

    //extend license of reader
    if(reader_jane.is_license_expired()) {
        val extension_period = 1
        reader_jane.extend_license_with_months(extension_period)
    }
    library.borrow(123456, reader_jane, 1)
    library.back(123456)
    library.borrow(123456, reader_jane, 1)
    library.borrow(123456, reader_joe, 1)
    library.back(123456)
    library.back(123456)
/*
    book.borrow(reader_jane,1)
    book.back()
    book.borrow(reader_jane,1)
    book.borrow(reader_joe,1)
    book.back()
    book.back()

 */
}

