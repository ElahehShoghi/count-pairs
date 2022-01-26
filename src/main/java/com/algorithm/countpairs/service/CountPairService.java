package com.algorithm.countpairs.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class CountPairService {

    /**
     * This method get an array to find two elements which are equal to target sum number,
     * To do this goal, first iterate on the input array and then for each of the elements,
     * iterate on others to check if their sum is equal to target number or not
     * the time complexity is o(n2) and there is no need to extra memory
     *
     * @param inputArray
     * @param sum
     * @return
     */
    public List<Integer> getPairsEqualToSumByTwoLoop(int[] inputArray, int sum) {
        return IntStream.range(0, inputArray.length)
                .flatMap(i -> IntStream.range(i + 1, inputArray.length)
                        .filter(j -> inputArray[i] + inputArray[j] == sum)
                        .flatMap(j -> IntStream.of(inputArray[i], inputArray[j])))
                .boxed()
                .collect(Collectors.toList());
    }

    /**
     * This method get an array to find two elements which are equal to target sum number,
     * To do this goal, first iterate on the input array and put each of the elements
     * into a map, then check if sum minus that element exists int he map or not
     * Note that, the value of map entries is not important, like 1
     * the time complexity is o(n) and extra memory is needed for copy all elements of input array to a map
     * so, space complexity is o(n)
     *
     * @param inputArray
     * @param sum
     * @return
     */
    public List<Integer> getPairsEqualToSumByMap(int[] inputArray, int sum) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap();
        for (int i : inputArray) {
            if (map.containsKey(sum - i)) {
                result.add(i);
                result.add(sum - i);
            }
            map.put(i, 1);
        }
        return result;
    }

    /**
     * This method get a sorted array to find two elements which are equal to target sum number,
     * To do this goal, use of two pointers for iterating in the array until left pointer become greater than right pointer
     * the time complexity is o(n) and there is no need to extra memory
     *
     * @param inputSortedArray
     * @param sum
     * @return
     */
    public List<Integer> getPairsEqualToSumByTwoPointersInSortedArray(int[] inputSortedArray, int sum) {

        List<Integer> result = new ArrayList();
        int leftPointer = 0;
        int rightPointer = inputSortedArray.length - 1;

        while (leftPointer < rightPointer) {
            if (inputSortedArray[leftPointer] + inputSortedArray[rightPointer] == sum) {
                result.add(inputSortedArray[leftPointer]);
                result.add(inputSortedArray[rightPointer]);
                leftPointer++;
            } else if (inputSortedArray[leftPointer] + inputSortedArray[rightPointer] < sum) {
                leftPointer++;
            } else {
                rightPointer--;
            }
        }
        return result;
    }

}
