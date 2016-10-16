package Utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by clark on 2016/10/16.
 */


public class Md5Utils {
    /**
     * 给指定字符串按照md5的算法加密
     *
     * @param psd 需要加密的密码
     * @return 返回的经过加密的32位字符串
     */
    public static String encoder(String psd) {
        //对传入的密码进行加盐
        psd = psd +"ClarkRao";
        //1.指定加密算法的类型

        StringBuffer buffer =new StringBuffer();
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            //2.将需要加密的字符创转换成byte类型的数组，然后进行随机哈希过程
            byte[] bytes = digest.digest(psd.getBytes());
            //3.循环遍历bytes，让其生成32位字符串，固定写法
            //4.拼接字符串
            for (byte b : bytes) {
                //int类型i要转换成十六进制的字符
                int i = b & 0xff;
                String hexString = Integer.toHexString(i);
                if (hexString.length() < 2) {
                    hexString = "0" + hexString;
                }
                buffer.append(hexString);
            }
            return buffer.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }
    }
}
