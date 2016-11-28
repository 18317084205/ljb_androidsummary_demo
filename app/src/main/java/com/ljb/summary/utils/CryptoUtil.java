package com.ljb.summary.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 作者：ljb
 * 时间：2016/11/27 17:00
 * 邮箱：563773219@qq.com
 * 描述：
 */
public class CryptoUtil {

    public static String toMd5(String string) {
        try {
            // Create MD5 Hash
            MessageDigest digest = java.security.MessageDigest
                    .getInstance("MD5");
            digest.update(string.getBytes());
            byte messageDigest[] = digest.digest();
            StringBuffer sb = new StringBuffer();

            for (int i = 0; i < messageDigest.length; i++) {
                int temp = 0xFF & messageDigest[i];
                String s = Integer.toHexString(temp);
                if (temp <= 0x0F) {
                    s = "0" + s;
                }
                sb.append(s);
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return "";
    }
}
