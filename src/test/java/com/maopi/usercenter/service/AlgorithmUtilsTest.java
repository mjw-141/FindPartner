package com.maopi.usercenter.service;

import com.maopi.usercenter.utils.AlgorithmUtils;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @Author 毛嘉伟
 * @Date 2025/08/02 14:46 （可以根据需要修改）
 * 算法工具类测试
 * @Version 1.0 （版本号）
 */

public class AlgorithmUtilsTest {
    @Test
    public void test() {
        String word1 = "horse";
        String word2 = "ros";
        int distance = AlgorithmUtils.minDistance(word1, word2);
        System.out.println("The minimum distance between " + word1 + " and " + word2 + " is " + distance);
    }

    @Test
    void testCompareTags() {
        List<String> tagList1 = Arrays.asList("Java", "大一", "男");
        List<String> tagList2 = Arrays.asList("Java", "大二", "女");
        List<String> tagList3 = Arrays.asList("Python", "大二", "女");

        // 1
        int score1 = AlgorithmUtils.minDistance(tagList1, tagList2);
        // 3
        int score2 = AlgorithmUtils.minDistance(tagList1, tagList3);

        System.out.println(score1);
        System.out.println(score2);
    }
}