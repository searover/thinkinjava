package com.searover.demo;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * Created by searover on 4/5/16.
 */
public class HMAC {

	/**
	 * 对字符串加密,加密算法使用MD5,SHA-1,SHA-256,默认使用SHA-256
	 *
	 * @param input
	 *            要加密的字符串 加密类型
	 * @return
	 */
	public static byte[] Encrypt(String secKey, String input) {
		return Encrypt("HMACSHA256", secKey, input);
	}

	public static byte[] Encrypt(String method, String secKey, String input) {
		try {
			Mac mac = Mac.getInstance(method);
			// get the bytes of the hmac key and data string
			SecretKey secret = new SecretKeySpec(secKey.getBytes("UTF-8"), method);
			mac.init(secret);
			byte[] doFinal = mac.doFinal(input.getBytes("UTF-8"));
			return doFinal;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		// MessageDigest md = null;
		// byte[] bt = strSrc.getBytes();
		// try {
		// if (encName == null || encName.equals("")) {
		// encName = "SHA-256";
		// }
		// md = MessageDigest.getInstance(encName);
		// md.update(bt);
		// return md.digest();
		// // strDes = bytes2Hex(md.digest()); // to HexString
		// } catch (NoSuchAlgorithmException e) {
		// return null;
		// }
	}

	public static String bytes2Hex(byte[] bts) {
		String des = "";
		String tmp = null;
		for (int i = 0; i < bts.length; i++) {
			tmp = (Integer.toHexString(bts[i] & 0xFF));
			if (tmp.length() == 1) {
				des += "0";
			}
			des += tmp;
		}
		return des;
	}

}
