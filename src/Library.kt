enum class LIBRARY_ID {
    MAIN_LIBRARY,
    DISTRICT_01,
    DISTRICT_02,
    DISTRICT_03,
    DISTRICT_04,
    DISTRICT_05,
    DISTRICT_06,
    OTHER
}


class Library(
    var libraryId: LIBRARY_ID,
    var address : String,
) {
    //var sections = mutableListOf<Section>()
    var sections = arrayListOf<Section>()

    init {

    }

    fun add_section(sectionToAdd: Section): Boolean{
        val mutListIterator = sections.listIterator()
        var alreadyHave: Boolean = false

        while(mutListIterator.hasNext()){
            if (mutListIterator.next().equals(sectionToAdd)){
                alreadyHave = true
            }
        }
        if(!alreadyHave){
            sections.add(sectionToAdd)
            println("Section ${sectionToAdd.category} added to library ${libraryId}.")
            return true
        }
        else{
            println("Library ${libraryId} already has section ${sectionToAdd.category}!")
            return false
        }

    }

    fun remove_section(section: Section): Boolean{
        return true
    }

    fun list_sections(): Unit{
        for (s in sections) {
            println("Sections in library ${this.libraryId}:")
            println(s.category)
        }
    }

    fun list_books(): Unit{
        println("Books in library ${this.libraryId}:")
        if (sections.size != 0){
            for (s in sections) {
                if (s.getSize() != 0){
                    println("${s.category}:")
                    s.printBooks()
                }
            }
        }
    }

    fun addBook(book: Book): Boolean {
        for (s in sections) {
            if (s.category == book.category) {
                return s.add_book(book)
            }
            else{
                println("No section ${book.category} in library ${this.libraryId}")
            }
        }
        return false
    }

    fun removeBook(book: Book): Boolean {
        for (s in sections) {
            if (s.category == book.category) {
                return s.remove_book(book)
            }
            else{
                println("No section ${book.category} in library ${this.libraryId}")
            }
        }
        return false
    }

    fun borrow(bookId: Int, reader: Reader, months: Int): Boolean{
        for (s in sections) {
            val success = s.borrow(bookId, reader, months)
            if (success){
                //println("Borrowing successful in library ${this.libraryId}")
                return true
            }
        }
        //println("Borrowing UNsuccessful in library ${this.libraryId}")
        return false
    }

    fun back(bookId: Int){
        for (s in sections) {
            s.back(bookId)
        }
    }

}