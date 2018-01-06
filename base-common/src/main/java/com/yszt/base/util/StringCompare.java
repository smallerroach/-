package com.yszt.base.util;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

import com.alibaba.dubbo.container.Main;

/**
 * 字符串相似度比较...
 * @author qiaolin
 * @date 2017-01-06
 */
public class StringCompare {
	 
	
	/**
	 *  比较两个字符串的相似度
	 * @param str1 
	 * @param str2
	 * @return
	 */
    public static Float Similarity(String str1,String str2){
    	double result = SimilarDegree(str1, str2)*100;
    	if(result==0){
    		
    	}
    	return Float.parseFloat(new DecimalFormat("#.00").format(result));
    }
    
    /**
     *  将double数值转换为百分比.
     * @param resule 
     * @return
     */
    public static String similarityResult(double resule){  
        return  NumberFormat.getPercentInstance(new Locale( "en ", "US ")).format(resule);  
    }  
  
    /** 
     * 相似度比较 
     * @param strA 
     * @param strB 
     * @return 
     */  
    private static double SimilarDegree(String strA, String strB){  
        String newStrA = removeSign(strA);  
        String newStrB = removeSign(strB);  
        int temp = Math.max(newStrA.length(), newStrB.length());  
        if(temp==0){
        	return 0;
        }
        int temp2 = longestCommonSubstring(newStrA, newStrB).length();  
        return temp2 * 1.0 / temp;  
    }  
  
    /**
     * 检查字符串的每一个字符是否是正确的字符。
     * @param str
     * @return 将正确的字符返回出去。
     */
    private static String removeSign(String str) {  
        StringBuffer sb = new StringBuffer();  
        for (char item : str.toCharArray())  
            if (charReg(item)){  
                sb.append(item);  
            }  
        return sb.toString();  
  
    }  
  
  
    /**
     *  判断传进来的字符是否为中文或者是大小写字母、数字。
     * @param charValue 待检查的字符
     * @return 非法字符返回fasle
     */
    private static boolean charReg(char charValue) {  
        return (charValue >= 0x4E00 && charValue <= 0X9FA5)  
                || (charValue >= 'a' && charValue <= 'z')  
                || (charValue >= 'A' && charValue <= 'Z')  
                || (charValue >= '0' && charValue <= '9');  
    }  
  
  
    /**
     * 
     * @param strA
     * @param strB
     * @return
     */
    private static String longestCommonSubstring(String strA, String strB) {  
        char[] chars_strA = strA.toCharArray();  
        char[] chars_strB = strB.toCharArray();  
        int m = chars_strA.length;  
        int n = chars_strB.length;  
        int[][] matrix = new int[m + 1][n + 1];  
        for (int i = 1; i <= m; i++) {  
            for (int j = 1; j <= n; j++) {  
                if (chars_strA[i - 1] == chars_strB[j - 1]){  
                    matrix[i][j] = matrix[i - 1][j - 1] + 1;  
                }else {
                    matrix[i][j] = Math.max(matrix[i][j - 1], matrix[i - 1][j]);  
                }
            }  
        }  
        char[] result = new char[matrix[m][n]];  
        int currentIndex = result.length - 1;  
        while (matrix[m][n] != 0) {  
            if (matrix[m][n] == matrix[m][n - 1]) { 
                n--;  
            }else if (matrix[m][n] == matrix[m - 1][n]){   
                m--;  
            }else {  
                result[currentIndex] = chars_strA[m - 1];  
                currentIndex--;  
                n--;  
                m--;  
            }  
        }  
        return new String(result);  
    }  
  
   
    
}  
