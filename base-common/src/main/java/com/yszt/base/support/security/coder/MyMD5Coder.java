package com.yszt.base.support.security.coder;
/**
 * My Md5
 * @author liqiaolin
 * @version 1.0
 * @since 1.0
 */
public abstract class MyMD5Coder {
	
	/**
	 *  基于MDCoder类中的Md5加密方法封装。
	 * @param data 需要加密的字符串。
	 * @return 加密完成的字符串
	 */
	public static String Md5enCode(String data){
		char[] chars = "0123456789abcdef".toCharArray(); 
		byte[] byte1 = data.getBytes();
		byte[] byte2 =  null;
		StringBuffer sb = new StringBuffer();
		try {
			byte2 = MDCoder.encodeMD5(byte1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i < byte2.length; i++) {
			sb.append(chars[(byte2[i] & 0x0f0) >> 4]);			
			sb.append(chars[byte2[i] & 0x0f]);
		}
		return sb.toString();
	}
	
}
