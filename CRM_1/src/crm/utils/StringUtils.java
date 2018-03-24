
package crm.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.UUID;

/**
 * @author: RookieWangZhiWei
 * @date:2018-3-22 下午8:37:08
 * @version :
 * 
 */
public class StringUtils {
	public static String getMD5Value(String value){
		
		try{
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			byte[] md5ValueByteArray = messageDigest.digest(value.getBytes());
			BigInteger  bigInteger = new BigInteger(1,md5ValueByteArray);
			return bigInteger.toString(16);
		}catch (Exception e) {
			// TODO: handle exception
			return value;
		}
	}
	/**
	 * 获得32长度UUID值
	 * @return
	 */
	public static String getUUID(){
		return UUID.randomUUID().toString().replace("-", "");
	}
}
