import java.time.LocalDate
import java.time.Month
import java.time.temporal.ChronoUnit
import kotlin.math.abs

class Reader(
    var name:String,
    var birthDate:LocalDate
) {
    var license_expires: LocalDate

    init {
        license_expires = LocalDate.now().minusDays(1)
        println("Reader added, name:${this.name}, age:${abs(ChronoUnit.YEARS.between(LocalDate.now(), birthDate))}, license expires: ${this.license_expires}")
    }

    fun extend_license_with_months(mon_val: Int): Unit{
        //license_expires = LocalDate.from(license_expires).plusMonths(mon_val.toLong())
        license_expires = LocalDate.now().plusMonths(mon_val.toLong())
        println("license of reader ${this.name} has been extended by $mon_val months...")
    }

    fun is_license_expired(): Boolean {
        val now: LocalDate = LocalDate.now();
        return now > license_expires
    }
}

