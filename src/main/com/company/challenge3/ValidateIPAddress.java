package com.company.challenge3;

import java.util.regex.Pattern;

/**
 * Validate IP Address
 * https://leetcode.com/explore/featured/card/june-leetcoding-challenge/541/week-3-june-15th-june-21st/3362/
 *
 * Write a function to check whether an input string is a valid IPv4 address or IPv6 address or neither.
 * IPv4 addresses are canonically represented in dot-decimal notation, which consists of four decimal numbers, each ranging from 0 to 255, separated by dots ("."), e.g.,172.16.254.1;
 * Besides, leading zeros in the IPv4 is invalid. For example, the address 172.16.254.01 is invalid.
 * IPv6 addresses are represented as eight groups of four hexadecimal digits, each group representing 16 bits.
 * The groups are separated by colons (":"). For example, the address 2001:0db8:85a3:0000:0000:8a2e:0370:7334 is a valid one.
 * Also, we could omit some leading zeros among four hexadecimal digits and some low-case characters in the address to upper-case ones,
 * so 2001:db8:85a3:0:0:8A2E:0370:7334 is also a valid IPv6 address(Omit leading zeros and using upper cases).
 * However, we don't replace a consecutive group of zero value with a single empty group using two consecutive colons (::) to pursue simplicity.
 * For example, 2001:0db8:85a3::8A2E:0370:7334 is an invalid IPv6 address.
 * Besides, extra leading zeros in the IPv6 is also invalid. For example, the address 02001:0db8:85a3:0000:0000:8a2e:0370:7334 is invalid.
 *
 * Note: You may assume there is no extra space or special characters in the input string.
 *
 * Example 1:
 * Input: "172.16.254.1"
 * Output: "IPv4"
 * Explanation: This is a valid IPv4 address, return "IPv4".
 *
 * Example 2:
 * Input: "2001:0db8:85a3:0:0:8A2E:0370:7334"
 * Output: "IPv6"
 * Explanation: This is a valid IPv6 address, return "IPv6".
 *
 * Example 3:
 * Input: "256.256.256.256"
 * Output: "Neither"
 * Explanation: This is neither a IPv4 address nor a IPv6 address.
 *
 * Algorithm:
 * Check if string contains corresponding delimiters and perform single check.
 * Check leading zero for IPv4, regexp symbols and parts length.
 * Parse int and check its value.
 *
 * Time complexity : O(n).
 * Space complexity : O(1).
 */
public class ValidateIPAddress {

    public static void main(String[] args) {
        ValidateIPAddress app = new ValidateIPAddress();
        System.out.println(app.validIPAddress("172.16.254.1")); // IPv4
        System.out.println(app.validIPAddress("172.16.254.1.")); // Neither
        System.out.println(app.validIPAddress("172.16.254.")); // Neither
        System.out.println(app.validIPAddress("01.01.01.01")); // Neither
        System.out.println(app.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334")); // IPv6
        System.out.println(app.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334:")); // Neither
        System.out.println(app.validIPAddress("2001:0db8:85a3:00000:0:8A2E:0370:7334")); // Neither
        System.out.println(app.validIPAddress("1081:db8:85a3:01:-0:8A2E:0370:7334")); // Neither
        System.out.println(app.validIPAddress("256.256.256.256")); // Neither
        System.out.println(app.validIPAddress("111111111111111111111111111111111111111111")); // Neither
    }

    private String validIPAddress(String IP) {
        if (IP.split("\\.", -1).length == 4) {
            return validateIPV4(IP);
        } else if (IP.split(":", -1).length == 8) {
            return validateIPV6(IP);
        }
        return "Neither";
    }

    private String validateIPV4(String str) {
        for (String s : str.split("\\.", -1)) {
            if (s.startsWith("0") && s.length() != 1) return "Neither";
            if (!s.matches("[0-9]+") || s.length() > 3) return "Neither";
            int value = Integer.parseInt(s);
            if (value < 0 || value > 255) {
                return "Neither";
            }
        }
        return "IPv4";
    }

    private String validateIPV6(String str) {
        for (String s : str.split(":", -1)) {
            if (!s.matches("[0-9a-fA-F]+") || s.length() > 4) return "Neither";
            int value = Integer.parseInt(s, 16);
            if (value < 0 || value > 65535) {
                return "Neither";
            }
        }
        return "IPv6";
    }

    private String chunkIPv4 = "([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])";
    private Pattern pattenIPv4 = Pattern.compile("^(" + chunkIPv4 + "\\.){3}" + chunkIPv4 + "$");
    private String chunkIPv6 = "([0-9a-fA-F]{1,4})";
    private Pattern pattenIPv6 = Pattern.compile("^(" + chunkIPv6 + "\\:){7}" + chunkIPv6 + "$");

    public String validIPAddressRegexp(String IP) {
        if (pattenIPv4.matcher(IP).matches()) return "IPv4";
        return (pattenIPv6.matcher(IP).matches()) ? "IPv6" : "Neither";
    }
}
