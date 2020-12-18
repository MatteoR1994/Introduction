import java.lang.IllegalArgumentException
import java.util.*
import kotlin.math.ceil

//import java.util.*
//import java.util.Scanner
//import java.util.Random

fun main() {
//    var myArray = intArrayOf(1,2,3,4,5)
//    println(myArray)
//    println("ORIGINAL ARRAY")
//    println(myArray.joinToString(" - "))
//
//    println("\nFunzione 1 - REVERSE ARRAY")
//    var resultArray = reverseArray(myArray)
//    println(resultArray.joinToString(" - "))
//
//    println("\nFunzione 2 - OVER22222WRITTEN ARRAY")
//    betterReverseArray(myArray)
//    println(myArray.joinToString(" - "))
//
//    println("\nFunzione 3 - TRAIN ARRAY")
//    println("Insert sub-elements number --> ")
//    var subElement = readLine()
//    if (subElement != null) {
//        var intSubElement = subElement!!.toInt()
//        //var trainArray: Array<IntArray>
//        //trainArray = divideArray(myArray,intSubElement)
//        //println(trainArray.joinToString(" - "))
//        println(intSubElement)
//        divideArray(myArray,intSubElement)
//    } else {
//        println("Input nullo, terminiamo il programma")
//        return
//    }
    var array = intArrayOf(1,2,3,4,5,6,7,8,9,10)
    val train = creaTrenino(array,3)
    for(w in train) {
        println(w.joinToString(" - "))
    }
}

fun reverseArray(arr: IntArray): IntArray {
    var temporaryArray = IntArray(arr.size)
    var dimensionArray = arr.size - 1
    for(a in 0 until arr.size) {
        temporaryArray[a] = arr[dimensionArray]
        dimensionArray--
    }
    return temporaryArray
}

fun reverseArrayReplace(arr: IntArray): IntArray {
    var temporaryArray = IntArray(arr.size)
    var dimensionArray = arr.size - 1
    for(a in 0 until arr.size) {
        temporaryArray[a] = arr[dimensionArray]
        dimensionArray--
    }
    for(b in 0 until temporaryArray.size) {
        arr[b]=temporaryArray[b]
    }
    return arr
}

fun betterReverseArray(arr: IntArray) {
    //var temp = 0
    for(i in 0 until arr.size/2) {
        /*temp = arr[i]
        arr[i] = arr[arr.size-1-i]
        arr[arr.size-1-i] = temp*/
        swap(arr,i,arr.size-1-i)
    }
}

fun swap(arr: IntArray, pos1: Int, pos2: Int) {
    var temp = arr[pos1]
    arr[pos1] = arr[pos2]
    arr[pos2] = temp
}

//fun divideArray(arr: IntArray, numberSubElement: Int): Array<IntArray> {
fun divideArray(arr: IntArray, sizeSubElement: Int) {
    var wagons = if((arr.size%sizeSubElement)==0) {
        arr.size/sizeSubElement
    } else {
        (arr.size/sizeSubElement)+1
    }

    var resultArray = arrayOf(intArrayOf(sizeSubElement))
    var temporaryArray = IntArray(sizeSubElement)
    //println("\nVAGONI: "+wagons)
    var ciclo = 0
    var i = 0
    do {
        while(i<wagons) {
            temporaryArray[i] = arr[i]
            //println(i)
            println(temporaryArray.joinToString(" - "))
            i++
        }
        resultArray[ciclo]=temporaryArray

        ciclo++
    } while(ciclo<wagons)
    //return resultArray
}

fun creaTrenino(arr: IntArray, sizeSubElement: Int): Array<IntArray> {
    var numWagons = if((arr.size%sizeSubElement)==0) {
        arr.size/sizeSubElement
    } else {
        (arr.size/sizeSubElement)+1
    }
    val train: Array<IntArray> = Array<IntArray>(numWagons, { i -> IntArray(sizeSubElement) })
    //val train: Array<IntArray> = Array<IntArray>(2, { i -> IntArray(i+1)})
    //train[0] - Primo vagone
    //train[0][0] - Primo elemento del primo vagone
    /*for(i in 0 until arr.size) {
        train[i/sizeSubElement][i%sizeSubElement] = arr[i]
    }*/
    for( (i,n) in arr.withIndex()) {
        val numVagone = i/sizeSubElement
        val posInVagone = i%sizeSubElement
        train[numVagone][posInVagone] = n
    }
    return train
}