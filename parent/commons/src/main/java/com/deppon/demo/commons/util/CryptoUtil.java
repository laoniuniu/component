package com.deppon.demo.commons.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * OA MD5加密方式工具类
 * @author Administrator
 *
 */
public class CryptoUtil {


	public CryptoUtil() {
	}

	public static String base64Encode(byte bytes[]) {
		if (bytes == null)
			return "";
		else
			return (new BASE64Encoder()).encode(bytes);
	}

	public static String digestByMD5(String text) throws Exception {
		if (text == null)
			return null;
		byte digest[] = new byte[0];
		try {
			digest = md5(text.getBytes());
			return base64Encode(digest);
		} catch (NoSuchAlgorithmException e) {
			throw new Exception(e);
		}
	}

	private static byte[] md5(byte input[]) throws NoSuchAlgorithmException {
		MessageDigest alg = MessageDigest.getInstance("MD5");
		alg.update(input);
		byte digest[] = alg.digest();
		return digest;
	}
}
