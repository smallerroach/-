package com.yszt.base.util;
import java.io.UnsupportedEncodingException;
import java.util.Random;

/**
 * 随机生成常见的汉字
 * 
 * @author qiaolin
 * @date 2017-01-06
 */
public class GeneChar {
	private static Random random = new Random();
    
    public static String getChar(){
    	StringBuffer sb = new StringBuffer();
    	int sum = random.nextInt(30)+1;
        for (int i = 1; i < sum; i++) {
        	sb.append(getRandomChar());
        }
        return sb.toString();
    }
        	
    private static char getRandomChar() {
        String str = "";
        int hightPos; //
        int lowPos;
        hightPos = (176 + Math.abs(random.nextInt(39)));
        lowPos = (161 + Math.abs(random.nextInt(93)));

        byte[] b = new byte[2];
        b[0] = (Integer.valueOf(hightPos)).byteValue();
        b[1] = (Integer.valueOf(lowPos)).byteValue();

        try {
            str = new String(b, "GBK");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            System.out.println("错误");
        }

        return str.charAt(0);
    }
}
