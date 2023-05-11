fun sort(inputArray: IntArray): IntArray {
    val size = inputArray.size
    return if (size == 1 || size == 0) {
        inputArray
    } else {
        val firstHalfOfInputArraySorted = sort(inputArray.copyOfRange(0, size / 2))
        val secondHalfOfInputArraySorted = sort(inputArray.copyOfRange(size / 2, size))
        merge(firstHalfOfInputArraySorted, secondHalfOfInputArraySorted)
    }
}

private fun merge(firstArray: IntArray, secondArray: IntArray): IntArray {
    val resultingArray = IntArray(firstArray.size + secondArray.size)
    var firstArrayPointer = 0
    var secondArrayPointer = 0
    for (resultingArrayPointer in resultingArray.indices) {
        if (firstArrayPointer == firstArray.size) {
            secondArray.copyInto(
                resultingArray,
                destinationOffset = resultingArrayPointer,
                startIndex = secondArrayPointer
            )
            return resultingArray
        }
        if (secondArrayPointer == secondArray.size) {
            firstArray.copyInto(
                resultingArray,
                destinationOffset = resultingArrayPointer,
                startIndex = firstArrayPointer
            )
            return resultingArray
        }
        if (firstArray[firstArrayPointer] <= secondArray[secondArrayPointer]) {
            resultingArray[resultingArrayPointer] = firstArray[firstArrayPointer]
            firstArrayPointer++
        } else {
            resultingArray[resultingArrayPointer] = secondArray[secondArrayPointer]
            secondArrayPointer++
        }
    }
    return resultingArray
}

fun main() {
    println(sort(intArrayOf()).toList())
    println(sort(intArrayOf(3)).toList())
    println(sort(intArrayOf(3, -1)).toList())
    println(sort(intArrayOf(0, 5, 3, 4, 7)).toList())
    println(sort(intArrayOf(0, 5, 3, 4, 7, 6)).toList())
    println(sort(intArrayOf(6, 5, 4, 3, 2, 1)).toList())
    println(sort(intArrayOf(0, 0, 1, 1, 0, 0)).toList())
}