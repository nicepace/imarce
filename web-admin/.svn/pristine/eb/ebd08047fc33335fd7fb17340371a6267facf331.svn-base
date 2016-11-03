package com.imarce.webadmin.util;

import java.io.File;
import java.util.Date;
import java.util.UUID;

import com.imarce.core.utils.DateUtils;

/**
 * 2016年7月8日 上午11:22:58
 * 
 * @kriss 说明： 版本：
 */
public class FileUtil {

	public static String mkFileName(String appPath, String originName) {
		// 确保目录存在
		String path = "uploadFiles/" + DateUtils.formatDate(new Date(), "yyyyMM");
		ensureDirectory(appPath, path);
		String ext = "";
		if (originName != null && originName.lastIndexOf(".") > 0)
			ext = originName.substring(originName.lastIndexOf("."));

		return path + "/" + UUID.randomUUID().toString() + ext;
	}

	public static void ensureDirectory(String appPath, String path) {
		File dir = new File(appPath + "/" + path);
		if (!dir.exists())
			dir.mkdirs();
	}

	public static String createPicName(String fileName) {

		int indexOfSlash = fileName.lastIndexOf("/");

		String shortName = indexOfSlash > 0 ? fileName.substring(indexOfSlash + 1) : fileName;
		int indexOfDoc = shortName.lastIndexOf(".");
		if (indexOfDoc > 0) {
			return shortName.substring(0, indexOfDoc) + "-snail" + shortName.substring(indexOfDoc);
		} else {
			return shortName + "";
		}
	}

}
