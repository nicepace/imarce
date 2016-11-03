package com.imarce.core.db;

import java.security.SecureRandom;
import java.util.UUID;

/**
 * 2016年6月20日 下午1:42:04
 * 
 * @kriss 说明：主键生成类 版本：
 */
public final class IDGenerator {

	/**
	 * 封装JDK自带的UUID, 通过Random数字生成, 中间无-分割
	 * @return 不带-分割的32位字符串
	 */
	public synchronized static String uuid() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}


	public static void main(String[] args) {
		System.out.println(IDGenerator.uuid());
	}

}
