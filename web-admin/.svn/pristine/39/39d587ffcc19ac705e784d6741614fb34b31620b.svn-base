package com.imarce.webadmin.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5 {

	 public String str;
	 public final static String SALT="[];qinshbd5k91xr";
	 public String md5s(String plainText) {
	  try {
	   MessageDigest md = MessageDigest.getInstance("MD5");
	   String md5Salt=plainText+SALT;
	   md.update(md5Salt.getBytes());
	   byte b[] = md.digest();
	   int i;

	   StringBuffer buf = new StringBuffer("");
	   for (int offset = 0; offset < b.length; offset++) {
	    i = b[offset];
	    if (i < 0)
	     i += 256;
	    if (i < 16)
	     buf.append("0");
	    buf.append(Integer.toHexString(i));
	    
	   }
	   str = buf.toString();
	  } catch (NoSuchAlgorithmException e) {
	   e.printStackTrace();

	  }
	  return str;
	 }
}
