package taxipark

/*
 * Task #1. Find all the drivers who performed no trips.
 */
fun TaxiPark.findFakeDrivers(): Set<Driver> =
    this.allDrivers.filter {
            driver -> driver !in (this.trips.map { it.driver })
    }.toSet()

/*
 * Task #2. Find all the clients who completed at least the given number of trips.
 */
fun TaxiPark.findFaithfulPassengers(minTrips: Int): Set<Passenger> {
    val exp = {pass:Passenger -> trips.map { it.passengers }.filter{pass in it}.count()}
    println(exp(allPassengers.first()))
    return this.allPassengers.filter{exp(it)>=minTrips}.toSet()
}

/*
 * Task #3. Find all the passengers, who were taken by a given driver more than once.
 */
fun TaxiPark.findFrequentPassengers(driver: Driver): Set<Passenger> {
    val exp = {pass:Passenger, driv:Driver -> trips.map{it.driver to it.passengers}.filter{pass in it.second && it.first == driv }.count()}
    return this.allPassengers.filter{exp(it,driver) > 1}.toSet()
}

/*
 * Task #4. Find the passengers who had a discount for majority of their trips.
 */
fun TaxiPark.findSmartPassengers(): Set<Passenger> {
    val exp = {pass:Passenger -> trips.map{it.discount to it.passengers}.filter{pass in it.second && it.first != null}.count()}
    val exp2 = {pass:Passenger -> trips.map{it.discount to it.passengers}.filter{pass in it.second && it.first == null}.count()}

    return this.allPassengers.filter{exp(it) > exp2(it)}.toSet()
}
/*
 * Task #5. Find the most frequent trip duration among minute periods 0..9, 10..19, 20..29, and so on.
 * Return any period if many are the most frequent, return `null` if there're no trips.
 */
fun TaxiPark.findTheMostFrequentTripDurationPeriod(): IntRange? {
    this.trips.groupBy { it.duration }.forEach{println(it)}
    return 1..10
}

/*
 * Task #6.
 * Check whether 20% of the drivers contribute 80% of the income.
 */
fun TaxiPark.checkParetoPrinciple(): Boolean {
    TODO()
}