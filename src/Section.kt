enum class BOOK_CATEGORY {
    UNCATEGORIZED,
    EDUCATION,
    HISTORY,
    LITERATURE,
    SCI_FI,
    FANTASY,
    EZO_SPIRITUAL,
    ROMANTIC,
    OTHER
}

//section in library
class Section(
    var category: BOOK_CATEGORY,
    var libraryId: LIBRARY_ID
) {
    var books = mutableListOf<Book>()
    init {

    }

    fun add_book(book: Book): Boolean{

        return true
    }
    fun remove_book(book: Book): Boolean{

        return true
    }
}