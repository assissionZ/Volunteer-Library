package md5;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
public class MD5 {
	public static String generateCode(String str) throws NoSuchAlgorithmException{
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		byte[] srcBytes = str.getBytes();
		md5.update(srcBytes);
		byte[] resultBytes=md5.digest();
		String result=new String (resultBytes);
		return result;
	}
	
	 public static String EncoderByMd5(String str) throws Exception {
	        MessageDigest md5=MessageDigest.getInstance("md5");//返回实现指定摘要算法的 MessageDigest 对象。
	        md5.update(str.getBytes());//先将字符串转换成byte数组，再用byte 数组更新摘要
	        byte[] nStr = md5.digest();//哈希计算，即加密
	        return bytes2Hex(nStr);//加密的结果是byte数组，将byte数组转换成字符串
	    }
	 private static String bytes2Hex(byte[] bts) {
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
