package com.algorithm.countpairs.controller;

import com.algorithm.countpairs.service.CountPairService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/count-pairs")
@AllArgsConstructor
@NoArgsConstructor
public class CountPairController {

    private CountPairService countPairService;

    @GetMapping("/by-two-loop")
    public List<Integer> getCountPairsByTwoLoop(
            @RequestParam(name = "inputArray") int[] inputArray,
            @RequestParam(name = "sum") int sum) {
        return countPairService.getPairsEqualToSumByTwoLoop(inputArray, sum);
    }

    @GetMapping("/by-map")
    public List<Integer> getCountPairsByMap(
            @RequestParam(name = "inputArray") int[] inputArray,
            @RequestParam(name = "sum") int sum) {
        return countPairService.getPairsEqualToSumByMap(inputArray, sum);
    }

    @GetMapping("/by-pointers")
    public List<Integer> getCountPairsByTwoPointersInSortedArray(
            @RequestParam(name = "inputSortedArray") int[] inputSortedArray,
            @RequestParam(name = "sum") int sum) {
        return countPairService.getPairsEqualToSumByTwoPointersInSortedArray(inputSortedArray, sum);
    }
}
