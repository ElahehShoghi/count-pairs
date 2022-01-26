package com.algorithm.countpairs;

import com.algorithm.countpairs.service.CountPairService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CountPairServiceTest {

    @Autowired
    private CountPairService countPairService;

    @Test
    public void testCountPairsByTwoLoop() {
        int[] inputArray = new int[]{1, 1, 3, 0, 2};
        List<Integer> result = countPairService.getPairsEqualToSumByTwoLoop(inputArray, 2);
        assert Objects.equals(result, Arrays.asList(1, 1, 0, 2));
        result.forEach(System.out::println);
    }

    @Test
    public void testCountPairsByMap() {
        int[] inputArray = new int[]{1, 1, 3, 0, 2};
        List<Integer> result = countPairService.getPairsEqualToSumByMap(inputArray, 2);
        assert Objects.equals(result, Arrays.asList(1, 1, 2, 0));
        result.forEach(System.out::println);
    }

    @Test
    public void testCountPairsByTwoPointersInSortedArray() {
        int[] inputArray = new int[]{0, 1, 1, 2, 3};
        List<Integer> result = countPairService.getPairsEqualToSumByTwoPointersInSortedArray(inputArray, 2);
        assert Objects.equals(result, Arrays.asList(0, 2, 1, 1));
        result.forEach(System.out::println);
    }

}
