package com.ddy.wxServer.Utils.WeiXinInterface;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class WeiXInLoginVerify {
    static String tmpStr;
    static public boolean LoginVerify(String signature, String timestamp, String nonce, String echostr) {
        String token = GetWeiXinInterface.GetToken();
        String[] array = {token, timestamp, nonce};
        Arrays.sort(array);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(token);
        stringBuilder.append(timestamp);
        stringBuilder.append(nonce);
        MessageDigest messageDigest;

        try {
            messageDigest=MessageDigest.getInstance("SHA-1");
            byte[] digest = messageDigest.digest(stringBuilder.toString().getBytes());
            tmpStr = byteToStr(digest);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        // 将sha1加密后的字符串可与signature对比，标识该请求来源于微信
        return tmpStr != null ? tmpStr.equals(signature.toUpperCase()) : false;
    }
    /**
     * 将字节数组转换为十六进制字符串
     *
     * @param byteArray
     * @return
     */
    private static String byteToStr(byte[] byteArray) {
        String strDigest = "";
        for (int i = 0; i < byteArray.length; i++) {
            strDigest += byteToHexStr(byteArray[i]);
        }
        return strDigest;
    }
    /**
     * 将字节转换为十六进制字符串
     *
     * @param mByte
     * @return
     */
    private static String byteToHexStr(byte mByte) {
        char[] Digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
        char[] tempArr = new char[2];
        tempArr[0] = Digit[(mByte >>> 4) & 0X0F];
        tempArr[1] = Digit[mByte & 0X0F];

        String s = new String(tempArr);
        return s;
    }
}
