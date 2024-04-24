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
    var category: BOOK_CATEGORY
) {
    var libraryId: LIBRARY_ID? = null
    var books = arrayListOf<Book>()
    init {

    }

    fun getSize(): Int{
        return books.size
    }

    fun printBooks(){
        for (b in books) {
            println("${b.book_id}: ${b.title} by ${b.author}, pages ${b.pages}, published: ${b.date_published}")
        }
    }

    fun add_book(book: Book): Boolean{
        if (!bookAlreadyPresent(book)){
            books.add(book)
            println("Book ${book.book_id} added to section ${this.category}")
            return true
        }
        else{
            println("Book ${book.book_id} already exists in section ${this.category}")
            return false
        }
    }

    fun remove_book(book: Book): Boolean {
        var removed: Boolean = false
        for (b in books) {
            if (b.book_id == book.book_id){
                books.remove(b)
                println("Book ${book.book_id} removed from section ${this.category}")
                return true
            }
        }
        println("Book ${book.book_id} not found in section ${this.category}")
        return false
    }

    private fun bookAlreadyPresent(book: Book): Boolean{
        for (b in books) {
            if (b.book_id == book.book_id){
                return true
            }
        }
        return false
    }

    fun borrow(bookId: Int, reader: Reader, months: Int):Boolean{
        for (b in books) {
            if (b.book_id == bookId){
                val success = b.borrow(reader, months)
                if (success){
                    //println("Borrowing successful in section ${this.category}")
                }
                else{
                    //println("Borrowing UNsuccessful in section ${this.category}!")
                }
                return success
            }
        }
        return false
    }

    fun back(bookId: Int){
        for (b in books) {
            if (b.book_id == bookId){
                val success = b.back()
                //println("Returning unconditionally in section ${this.category}")
            }
        }
    }

}