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

    val res = this.trips.map{numToRange(it.duration)}.groupingBy{it}.eachCount().maxByOrNull{it.value}

    return res?.key
}

/*
 * Task #6.
 * Check whether 20% of the drivers contribute 80% of the income.
 */
fun TaxiPark.checkParetoPrinciple(): Boolean {
    if(trips.size == 0) return false

    val totalIncome = this.trips.sumByDouble{it.cost}
    val drvTrip = this.trips.map{it.driver to it.cost}.groupingBy { it.first }.eachCount()
    val sortedTrips = trips.sortedByDescending { it.cost*it.passengers.size}
    val len = this.allDrivers.size
    val top20Percent = 0.2 * len
    var sumCost:Double=0.0

    drvTrip.forEach { t, u -> println("$t $u") }
    sortedTrips.filterIndexed{idx,value -> idx < top20Percent }.forEach { println("${it.cost*it.passengers.size}") }//.forEach{sumCost+=(it.cost*it.passengers.size)}
    println("Total $totalIncome Total drivers $len 20%Driver $top20Percent 20%Cost $sumCost")

    return sumCost >= 0.8*totalIncome

}

fun numToRange(num:Int):IntRange?{
    val numStr = num.toString()
    val len = numStr.length
    var leftRange = 0
    var rightRange = 9

    if(len > 1) {
        leftRange = (numStr.substring(0 until len-1) + "0").toInt()
        rightRange += leftRange
    }
    return leftRange..rightRange
}