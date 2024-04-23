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
    var sections = mutableListOf<Section>()
    init {

    }
    fun add_section(section: Section): Boolean{
        return true
    }
    fun remove_section(section: Section): Boolean{
        return true
    }

    fun list_sections(section: Section): Unit{
        val mutListIterator = sections.listIterator()

        while(mutListIterator.hasNext()){
            print(mutListIterator.next())
        }

    }

}