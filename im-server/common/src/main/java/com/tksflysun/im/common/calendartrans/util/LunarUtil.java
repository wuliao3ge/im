package com.tksflysun.im.common.calendartrans.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.tksflysun.im.common.calendartrans.Lunar;

/**
 * 农历工具
 * 
 * @author 6tail
 *
 */
public class LunarUtil {
    /** 农历基准年 */
    public static final int BASE_YEAR = 1900;
    /** 农历基准月 */
    public static final int BASE_MONTH = 11;
    /** 农历基准日 */
    public static final int BASE_DAY = 11;
    /** 农历与阳历年偏移量 */
    public static final int BASE_INDEX = 0;
    public static final int[] LEAP_MONTH_YEAR =
        {6, 14, 19, 25, 33, 36, 38, 41, 44, 52, 55, 79, 117, 136, 147, 150, 155, 158, 185, 193};
    public static final int[] LUNAR_MONTH = {0x00, 0x04, 0xad, 0x08, 0x5a, 0x01, 0xd5, 0x54, 0xb4, 0x09, 0x64, 0x05,
        0x59, 0x45, 0x95, 0x0a, 0xa6, 0x04, 0x55, 0x24, 0xad, 0x08, 0x5a, 0x62, 0xda, 0x04, 0xb4, 0x05, 0xb4, 0x55,
        0x52, 0x0d, 0x94, 0x0a, 0x4a, 0x2a, 0x56, 0x02, 0x6d, 0x71, 0x6d, 0x01, 0xda, 0x02, 0xd2, 0x52, 0xa9, 0x05,
        0x49, 0x0d, 0x2a, 0x45, 0x2b, 0x09, 0x56, 0x01, 0xb5, 0x20, 0x6d, 0x01, 0x59, 0x69, 0xd4, 0x0a, 0xa8, 0x05,
        0xa9, 0x56, 0xa5, 0x04, 0x2b, 0x09, 0x9e, 0x38, 0xb6, 0x08, 0xec, 0x74, 0x6c, 0x05, 0xd4, 0x0a, 0xe4, 0x6a,
        0x52, 0x05, 0x95, 0x0a, 0x5a, 0x42, 0x5b, 0x04, 0xb6, 0x04, 0xb4, 0x22, 0x6a, 0x05, 0x52, 0x75, 0xc9, 0x0a,
        0x52, 0x05, 0x35, 0x55, 0x4d, 0x0a, 0x5a, 0x02, 0x5d, 0x31, 0xb5, 0x02, 0x6a, 0x8a, 0x68, 0x05, 0xa9, 0x0a,
        0x8a, 0x6a, 0x2a, 0x05, 0x2d, 0x09, 0xaa, 0x48, 0x5a, 0x01, 0xb5, 0x09, 0xb0, 0x39, 0x64, 0x05, 0x25, 0x75,
        0x95, 0x0a, 0x96, 0x04, 0x4d, 0x54, 0xad, 0x04, 0xda, 0x04, 0xd4, 0x44, 0xb4, 0x05, 0x54, 0x85, 0x52, 0x0d,
        0x92, 0x0a, 0x56, 0x6a, 0x56, 0x02, 0x6d, 0x02, 0x6a, 0x41, 0xda, 0x02, 0xb2, 0xa1, 0xa9, 0x05, 0x49, 0x0d,
        0x0a, 0x6d, 0x2a, 0x09, 0x56, 0x01, 0xad, 0x50, 0x6d, 0x01, 0xd9, 0x02, 0xd1, 0x3a, 0xa8, 0x05, 0x29, 0x85,
        0xa5, 0x0c, 0x2a, 0x09, 0x96, 0x54, 0xb6, 0x08, 0x6c, 0x09, 0x64, 0x45, 0xd4, 0x0a, 0xa4, 0x05, 0x51, 0x25,
        0x95, 0x0a, 0x2a, 0x72, 0x5b, 0x04, 0xb6, 0x04, 0xac, 0x52, 0x6a, 0x05, 0xd2, 0x0a, 0xa2, 0x4a, 0x4a, 0x05,
        0x55, 0x94, 0x2d, 0x0a, 0x5a, 0x02, 0x75, 0x61, 0xb5, 0x02, 0x6a, 0x03, 0x61, 0x45, 0xa9, 0x0a, 0x4a, 0x05,
        0x25, 0x25, 0x2d, 0x09, 0x9a, 0x68, 0xda, 0x08, 0xb4, 0x09, 0xa8, 0x59, 0x54, 0x03, 0xa5, 0x0a, 0x91, 0x3a,
        0x96, 0x04, 0xad, 0xb0, 0xad, 0x04, 0xda, 0x04, 0xf4, 0x62, 0xb4, 0x05, 0x54, 0x0b, 0x44, 0x5d, 0x52, 0x0a,
        0x95, 0x04, 0x55, 0x22, 0x6d, 0x02, 0x5a, 0x71, 0xda, 0x02, 0xaa, 0x05, 0xb2, 0x55, 0x49, 0x0b, 0x4a, 0x0a,
        0x2d, 0x39, 0x36, 0x01, 0x6d, 0x80, 0x6d, 0x01, 0xd9, 0x02, 0xe9, 0x6a, 0xa8, 0x05, 0x29, 0x0b, 0x9a, 0x4c,
        0xaa, 0x08, 0xb6, 0x08, 0xb4, 0x38, 0x6c, 0x09, 0x54, 0x75, 0xd4, 0x0a, 0xa4, 0x05, 0x45, 0x55, 0x95, 0x0a,
        0x9a, 0x04, 0x55, 0x44, 0xb5, 0x04, 0x6a, 0x82, 0x6a, 0x05, 0xd2, 0x0a, 0x92, 0x6a, 0x4a, 0x05, 0x55, 0x0a,
        0x2a, 0x4a, 0x5a, 0x02, 0xb5, 0x02, 0xb2, 0x31, 0x69, 0x03, 0x31, 0x73, 0xa9, 0x0a, 0x4a, 0x05, 0x2d, 0x55,
        0x2d, 0x09, 0x5a, 0x01, 0xd5, 0x48, 0xb4, 0x09, 0x68, 0x89, 0x54, 0x0b, 0xa4, 0x0a, 0xa5, 0x6a, 0x95, 0x04,
        0xad, 0x08, 0x6a, 0x44, 0xda, 0x04, 0x74, 0x05, 0xb0, 0x25, 0x54, 0x03};
    public static final int[][] JIE_YEAR =
        {{13, 49, 85, 117, 149, 185, 201, 250, 250}, {13, 45, 81, 117, 149, 185, 201, 250, 250},
            {13, 48, 84, 112, 148, 184, 200, 201, 250}, {13, 45, 76, 108, 140, 172, 200, 201, 250},
            {13, 44, 72, 104, 132, 168, 200, 201, 250}, {5, 33, 68, 96, 124, 152, 188, 200, 201},
            {29, 57, 85, 120, 148, 176, 200, 201, 250}, {13, 48, 76, 104, 132, 168, 196, 200, 201},
            {25, 60, 88, 120, 148, 184, 200, 201, 250}, {16, 44, 76, 108, 144, 172, 200, 201, 250},
            {28, 60, 92, 124, 160, 192, 200, 201, 250}, {17, 53, 85, 124, 156, 188, 200, 201, 250}};
    public static final int[][] JIE_MAP =
        {{7, 6, 6, 6, 6, 6, 6, 6, 6, 5, 6, 6, 6, 5, 5, 6, 6, 5, 5, 5, 5, 5, 5, 5, 5, 4, 5, 5},
            {5, 4, 5, 5, 5, 4, 4, 5, 5, 4, 4, 4, 4, 4, 4, 4, 4, 3, 4, 4, 4, 3, 3, 4, 4, 3, 3, 3},
            {6, 6, 6, 7, 6, 6, 6, 6, 5, 6, 6, 6, 5, 5, 6, 6, 5, 5, 5, 6, 5, 5, 5, 5, 4, 5, 5, 5, 5},
            {5, 5, 6, 6, 5, 5, 5, 6, 5, 5, 5, 5, 4, 5, 5, 5, 4, 4, 5, 5, 4, 4, 4, 5, 4, 4, 4, 4, 5},
            {6, 6, 6, 7, 6, 6, 6, 6, 5, 6, 6, 6, 5, 5, 6, 6, 5, 5, 5, 6, 5, 5, 5, 5, 4, 5, 5, 5, 5},
            {6, 6, 7, 7, 6, 6, 6, 7, 6, 6, 6, 6, 5, 6, 6, 6, 5, 5, 6, 6, 5, 5, 5, 6, 5, 5, 5, 5, 4, 5, 5, 5, 5},
            {7, 8, 8, 8, 7, 7, 8, 8, 7, 7, 7, 8, 7, 7, 7, 7, 6, 7, 7, 7, 6, 6, 7, 7, 6, 6, 6, 7, 7},
            {8, 8, 8, 9, 8, 8, 8, 8, 7, 8, 8, 8, 7, 7, 8, 8, 7, 7, 7, 8, 7, 7, 7, 7, 6, 7, 7, 7, 6, 6, 7, 7, 7},
            {8, 8, 8, 9, 8, 8, 8, 8, 7, 8, 8, 8, 7, 7, 8, 8, 7, 7, 7, 8, 7, 7, 7, 7, 6, 7, 7, 7, 7},
            {9, 9, 9, 9, 8, 9, 9, 9, 8, 8, 9, 9, 8, 8, 8, 9, 8, 8, 8, 8, 7, 8, 8, 8, 7, 7, 8, 8, 8},
            {8, 8, 8, 8, 7, 8, 8, 8, 7, 7, 8, 8, 7, 7, 7, 8, 7, 7, 7, 7, 6, 7, 7, 7, 6, 6, 7, 7, 7},
            {7, 8, 8, 8, 7, 7, 8, 8, 7, 7, 7, 8, 7, 7, 7, 7, 6, 7, 7, 7, 6, 6, 7, 7, 6, 6, 6, 7, 7}};
    public static final int[][] QI_YEAR = {{13, 45, 81, 113, 149, 185, 201}, {21, 57, 93, 125, 161, 193, 201},
        {21, 56, 88, 120, 152, 188, 200, 201}, {21, 49, 81, 116, 144, 176, 200, 201},
        {17, 49, 77, 112, 140, 168, 200, 201}, {28, 60, 88, 116, 148, 180, 200, 201},
        {25, 53, 84, 112, 144, 172, 200, 201}, {29, 57, 89, 120, 148, 180, 200, 201},
        {17, 45, 73, 108, 140, 168, 200, 201}, {28, 60, 92, 124, 160, 192, 200, 201},
        {16, 44, 80, 112, 148, 180, 200, 201}, {17, 53, 88, 120, 156, 188, 200, 201}};
    public static final int[][] QI_MAP = {
        {21, 21, 21, 21, 21, 20, 21, 21, 21, 20, 20, 21, 21, 20, 20, 20, 20, 20, 20, 20, 20, 19, 20, 20, 20, 19, 19,
            20},
        {20, 19, 19, 20, 20, 19, 19, 19, 19, 19, 19, 19, 19, 18, 19, 19, 19, 18, 18, 19, 19, 18, 18, 18, 18, 18, 18,
            18},
        {21, 21, 21, 22, 21, 21, 21, 21, 20, 21, 21, 21, 20, 20, 21, 21, 20, 20, 20, 21, 20, 20, 20, 20, 19, 20, 20, 20,
            20},
        {20, 21, 21, 21, 20, 20, 21, 21, 20, 20, 20, 21, 20, 20, 20, 20, 19, 20, 20, 20, 19, 19, 20, 20, 19, 19, 19, 20,
            20},
        {21, 22, 22, 22, 21, 21, 22, 22, 21, 21, 21, 22, 21, 21, 21, 21, 20, 21, 21, 21, 20, 20, 21, 21, 20, 20, 20, 21,
            21},
        {22, 22, 22, 22, 21, 22, 22, 22, 21, 21, 22, 22, 21, 21, 21, 22, 21, 21, 21, 21, 20, 21, 21, 21, 20, 20, 21, 21,
            21},
        {23, 23, 24, 24, 23, 23, 23, 24, 23, 23, 23, 23, 22, 23, 23, 23, 22, 22, 23, 23, 22, 22, 22, 23, 22, 22, 22, 22,
            23},
        {23, 24, 24, 24, 23, 23, 24, 24, 23, 23, 23, 24, 23, 23, 23, 23, 22, 23, 23, 23, 22, 22, 23, 23, 22, 22, 22, 23,
            23},
        {23, 24, 24, 24, 23, 23, 24, 24, 23, 23, 23, 24, 23, 23, 23, 23, 22, 23, 23, 23, 22, 22, 23, 23, 22, 22, 22, 23,
            23},
        {24, 24, 24, 24, 23, 24, 24, 24, 23, 23, 24, 24, 23, 23, 23, 24, 23, 23, 23, 23, 22, 23, 23, 23, 22, 22, 23, 23,
            23},
        {23, 23, 23, 23, 22, 23, 23, 23, 22, 22, 23, 23, 22, 22, 22, 23, 22, 22, 22, 22, 21, 22, 22, 22, 21, 21, 22, 22,
            22},
        {22, 22, 23, 23, 22, 22, 22, 23, 22, 22, 22, 22, 21, 22, 22, 22, 21, 21, 22, 22, 21, 21, 21, 22, 21, 21, 21, 21,
            22}};
    /** 干 */
    public static final String[] GAN = {"", "甲", "乙", "丙", "丁", "戊", "己", "庚", "辛", "壬", "癸"};
    /** 支 */
    public static final String[] ZHI = {"", "子", "丑", "寅", "卯", "辰", "巳", "午", "未", "申", "酉", "戌", "亥"};
    /** 月 */
    public static final String[] MONTH = {"", "正", "二", "三", "四", "五", "六", "七", "八", "九", "十", "十一", "腊"};
    /** 季节 */
    public static final String[] SEASON = {"", "孟春", "仲春", "季春", "孟夏", "仲夏", "季夏", "孟秋", "仲秋", "季秋", "孟冬", "仲冬", "季冬"};
    /** 生肖 */
    public static final String[] SHENGXIAO = {"", "鼠", "牛", "虎", "兔", "龙", "蛇", "马", "羊", "猴", "鸡", "狗", "猪"};
    /** 气 */
    public static final String[] QI = {"大寒", "雨水", "春分", "谷雨", "夏满", "夏至", "大暑", "处暑", "秋分", "霜降", "小雪", "冬至"};
    /** 节 */
    public static final String[] JIE = {"小寒", "立春", "惊蛰", "清明", "立夏", "芒种", "小暑", "立秋", "白露", "寒露", "立冬", "大雪"};
    /** 日 */
    public static final String[] DAY = {"", "初一", "初二", "初三", "初四", "初五", "初六", "初七", "初八", "初九", "初十", "十一", "十二",
        "十三", "十四", "十五", "十六", "十七", "十八", "十九", "二十", "廿一", "廿二", "廿三", "廿四", "廿五", "廿六", "廿七", "廿八", "廿九", "三十"};
    /** 本应用使用的月份 */
    public static final Map<String, Integer> MONTH_NEW = new HashMap<String, Integer>() {
        private static final long serialVersionUID = 1L;
        {
            put("正", 1);
            put("二", 2);
            put("三", 3);
            put("四", 4);
            put("五", 5);
            put("六", 6);
            put("七", 7);
            put("八", 8);
            put("九", 9);
            put("十", 10);
            put("十一", 11);
            put("腊", 12);
        }
    };
    /** 本应用使用的天 */
    public static final Map<String, Integer> DAY_NEW = new HashMap<String, Integer>() {
        private static final long serialVersionUID = 1L;
        {
            put("初一", 1);
            put("初二", 2);
            put("初三", 3);
            put("初四", 4);
            put("初五", 5);
            put("初六", 6);
            put("初七", 7);
            put("初八", 8);
            put("初九", 9);
            put("初十", 10);
            put("十一", 11);
            put("十二", 12);
            put("十三", 13);
            put("十四", 14);
            put("十五", 15);
            put("十六", 16);
            put("十七", 17);
            put("十八", 18);
            put("十九", 19);
            put("廿日", 20);
            put("廿一", 21);
            put("廿二", 22);
            put("廿三", 23);
            put("廿四", 24);
            put("廿五", 25);
            put("廿六", 26);
            put("廿七", 27);
            put("廿八", 28);
            put("廿九", 29);
            put("三十", 30);
        }
    };

    /** 星期：中文-数字 */
    public static final Map<String, Integer> WEEK = new HashMap<String, Integer>() {
        private static final long serialVersionUID = 1L;
        {
            put("周一", 1);
            put("周二", 2);
            put("周三", 3);
            put("周四", 4);
            put("周五", 5);
            put("周六", 6);
            put("周日", 0);
        }
    };

    /** 星期：数字-中文 */
    public static final Map<Integer, String> WEEK_REVERSE = new HashMap<Integer, String>() {
        private static final long serialVersionUID = 1L;
        {
            put(1, "周一");
            put(2, "周二");
            put(3, "周三");
            put(4, "周四");
            put(5, "周五");
            put(6, "周六");
            put(0, "周日");
        }
    };

    /** 星期循环:英文 */
    public static final Map<Integer, Integer> WEEK_NEXT_EN = new HashMap<Integer, Integer>() {
        private static final long serialVersionUID = 1L;
        {
            put(1, 2);
            put(2, 3);
            put(3, 4);
            put(4, 5);
            put(5, 6);
            put(6, 0);
            put(0, 1);
        }
    };

    /** 星期循环:中文 */
    public static final Map<String, String> WEEK_NEXT_ZH = new HashMap<String, String>() {
        private static final long serialVersionUID = 1L;
        {
            put("周一", "周二");
            put("周二", "周三");
            put("周三", "周四");
            put("周四", "周五");
            put("周五", "周六");
            put("周六", "周日");
            put("周日", "周一");
        }
    };

    /** 农历日期对应的节日 */
    public static final Map<String, String> FESTIVAL = new HashMap<String, String>() {
        private static final long serialVersionUID = -1;
        {
            put("1-1", "春节");
            put("1-15", "元宵节");
            put("2-2", "龙头节");
            put("5-5", "端午节");
            put("7-7", "七夕节");
            put("8-15", "中秋节");
            put("9-9", "重阳节");
            put("12-8", "腊八节");
        }
    };
    /** 宿 */
    public static final String[][] XIU = {{"室", "奎", "胃", "毕", "参", "鬼", "张", "角", "氐", "心", "斗", "虚"},
        {"壁", "娄", "昴", "觜", "井", "柳", "翼", "亢", "房", "尾", "女", "危"},
        {"奎", "胃", "毕", "参", "鬼", "星", "轸", "氐", "心", "箕", "虚", "室"},
        {"娄", "昴", "觜", "井", "柳", "张", "角", "房", "尾", "斗", "危", "壁"},
        {"胃", "毕", "参", "鬼", "星", "翼", "亢", "心", "箕", "女", "室", "奎"},
        {"昴", "觜", "井", "柳", "张", "轸", "氐", "尾", "斗", "虚", "壁", "娄"},
        {"毕", "参", "鬼", "星", "翼", "角", "房", "箕", "女", "危", "奎", "胃"},
        {"觜", "井", "柳", "张", "轸", "亢", "心", "斗", "虚", "室", "娄", "昴"},
        {"参", "鬼", "星", "翼", "角", "氐", "尾", "女", "危", "壁", "胃", "毕"},
        {"井", "柳", "张", "轸", "亢", "房", "箕", "虚", "室", "奎", "昴", "觜"},
        {"鬼", "星", "翼", "角", "氐", "心", "斗", "危", "壁", "娄", "毕", "参"},
        {"柳", "张", "轸", "亢", "房", "尾", "女", "室", "奎", "胃", "觜", "井"},
        {"星", "翼", "角", "氐", "心", "箕", "虚", "壁", "娄", "昴", "参", "鬼"},
        {"张", "轸", "亢", "房", "尾", "斗", "危", "奎", "胃", "毕", "井", "柳"},
        {"翼", "角", "氐", "心", "箕", "女", "室", "娄", "昴", "觜", "鬼", "星"},
        {"轸", "亢", "房", "尾", "斗", "虚", "壁", "胃", "毕", "参", "柳", "张"},
        {"角", "氐", "心", "箕", "女", "危", "奎", "昴", "觜", "井", "星", "翼"},
        {"亢", "房", "尾", "斗", "虚", "室", "娄", "毕", "参", "鬼", "张", "轸"},
        {"氐", "心", "箕", "女", "危", "壁", "胃", "觜", "井", "柳", "翼", "角"},
        {"房", "尾", "斗", "虚", "室", "奎", "昴", "参", "鬼", "星", "轸", "亢"},
        {"心", "箕", "女", "危", "壁", "娄", "毕", "井", "柳", "张", "角", "氐"},
        {"尾", "斗", "虚", "室", "奎", "胃", "觜", "鬼", "星", "翼", "亢", "房"},
        {"箕", "女", "危", "壁", "娄", "昴", "参", "柳", "张", "轸", "氐", "心"},
        {"斗", "虚", "室", "奎", "胃", "毕", "井", "星", "翼", "角", "房", "尾"},
        {"女", "危", "壁", "娄", "昴", "觜", "鬼", "张", "轸", "亢", "心", "箕"},
        {"虚", "室", "奎", "胃", "毕", "参", "柳", "翼", "角", "氐", "尾", "斗"},
        {"危", "壁", "娄", "昴", "觜", "井", "星", "轸", "亢", "房", "箕", "女"},
        {"室", "奎", "胃", "毕", "参", "鬼", "张", "角", "氐", "心", "斗", "虚"},
        {"壁", "娄", "昴", "觜", "井", "柳", "翼", "亢", "房", "尾", "女", "危"},
        {"胃", "鬼", "氐", "心", "虚", "星", "轸", "氐", "心", "箕", "虚", "室"}};
    /** 兽 */
    public static final Map<String, String> SHOU = new HashMap<String, String>() {
        private static final long serialVersionUID = -1;
        {
            put("东", "青龙");
            put("南", "朱雀");
            put("西", "白虎");
            put("北", "玄武");
        }
    };
    /** 宫 */
    public static final Map<String, String> GONG = new HashMap<String, String>() {
        private static final long serialVersionUID = -1;
        {
            put("角", "东");
            put("井", "南");
            put("奎", "西");
            put("斗", "北");
            put("亢", "东");
            put("鬼", "南");
            put("娄", "西");
            put("牛", "北");
            put("氐", "南");
            put("柳", "南");
            put("胃", "西");
            put("女", "北");
            put("房", "东");
            put("星", "南");
            put("昴", "西");
            put("虚", "北");
            put("心", "东");
            put("张", "南");
            put("毕", "西");
            put("危", "北");
            put("尾", "东");
            put("翼", "南");
            put("觜", "西");
            put("室", "北");
            put("箕", "东");
            put("轸", "南");
            put("参", "西");
            put("壁", "北");
        }
    };
    /** 政 */
    public static final Map<String, String> ZHENG = new HashMap<String, String>() {
        private static final long serialVersionUID = -1;
        {
            put("角", "木");
            put("井", "木");
            put("奎", "木");
            put("斗", "木");
            put("亢", "金");
            put("鬼", "金");
            put("娄", "金");
            put("牛", "金");
            put("氐", "土");
            put("柳", "土");
            put("胃", "土");
            put("女", "土");
            put("房", "日");
            put("星", "日");
            put("昴", "日");
            put("虚", "日");
            put("心", "月");
            put("张", "月");
            put("毕", "月");
            put("危", "月");
            put("尾", "火");
            put("翼", "火");
            put("觜", "火");
            put("室", "火");
            put("箕", "水");
            put("轸", "水");
            put("参", "水");
            put("壁", "水");
        }
    };
    /** 动物 */
    public static final Map<String, String> ANIMAL = new HashMap<String, String>() {
        private static final long serialVersionUID = -1;
        {
            put("角", "蛟");
            put("斗", "獬");
            put("奎", "狼");
            put("井", "犴");
            put("亢", "龙");
            put("牛", "牛");
            put("娄", "狗");
            put("鬼", "羊");
            put("女", "蝠");
            put("氐", "貉");
            put("胃", "彘");
            put("柳", "獐");
            put("房", "兔");
            put("虚", "鼠");
            put("昴", "鸡");
            put("星", "马");
            put("心", "狐");
            put("危", "燕");
            put("毕", "乌");
            put("张", "鹿");
            put("尾", "虎");
            put("室", "猪");
            put("觜", "猴");
            put("翼", "蛇");
            put("箕", "豹");
            put("壁", "獝");
            put("参", "猿");
            put("轸", "蚓");
        }
    };

    protected LunarUtil() {}

    /**
     * 获取指定年月的下一个月是第几月
     * 
     * @param y
     *            年
     * @param m
     *            月
     * @return 1到12，闰月为负
     */
    public static int nextMonth(int y, int m) {
        int n = Math.abs(m) + 1;
        if (m > 0) {
            int index = y - LunarUtil.BASE_YEAR + LunarUtil.BASE_INDEX;
            int v = LunarUtil.LUNAR_MONTH[2 * index + 1];
            v = (v >> 4) & 0x0F;
            if (v == m) {
                n = -m;
            }
        }
        if (n == 13)
            n = 1;
        return n;
    }

    /**
     * 获取某年某月有多少天
     * 
     * @param year
     *            年
     * @param month
     *            月
     * @return 天数
     */
    public static int getDaysOfMonth(int year, int month) {
        // 注意：闰月 lunarMonth < 0
        int index = year - BASE_YEAR + BASE_INDEX;
        int v, l, d = 30;
        if (1 <= month && month <= 8) {
            v = LUNAR_MONTH[2 * index];
            l = month - 1;
            if (((v >> l) & 0x01) == 1) {
                d = 29;
            }
        } else if (9 <= month && month <= 12) {
            v = LUNAR_MONTH[2 * index + 1];
            l = month - 9;
            if (((v >> l) & 0x01) == 1) {
                d = 29;
            }
        } else {
            v = LUNAR_MONTH[2 * index + 1];
            v = (v >> 4) & 0x0F;
            if (v != Math.abs(month)) {
                d = 0;
            } else {
                d = 29;
                for (int i : LEAP_MONTH_YEAR) {
                    if (i == index) {
                        d = 30;
                        break;
                    }
                }
            }
        }
        return d;
    }

    public static int diffOfWeekInEN(Integer curWeek, Integer targetWeek) {
        int diff = 0;
        if (WEEK_NEXT_EN.get(curWeek) == targetWeek) {
            return 1;
        }
        while (WEEK_NEXT_EN.get(curWeek) != targetWeek) {
            curWeek = WEEK_NEXT_EN.get(curWeek);
            diff++;
        }
        if (diff != 0) {
            diff = diff + 1;
        }
        return diff;
    }

    public static int diffOfWeekInZH(String curWeek, String targetWeek) {
        int diff = 0;
        if (WEEK_NEXT_ZH.get(curWeek).equals(targetWeek)) {
            return 1;
        }
        while (!WEEK_NEXT_ZH.get(curWeek).equals(targetWeek)) {
            curWeek = WEEK_NEXT_ZH.get(curWeek);
            diff++;
        }
        if (diff != 0) {
            diff = diff + 1;
        }
        return diff;
    }

    public static Lunar getLunar(Date date) {
        return new Lunar(date);
    }

    public static String getMonthDay(Date date) {
        Lunar lunar = getLunar(date);
        return lunar.getMonthInChinese() + "月" + lunar.getDayInChinese();
    }
}