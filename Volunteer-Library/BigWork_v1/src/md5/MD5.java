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
	        MessageDigest md5=MessageDigest.getInstance("md5");//����ʵ��ָ��ժҪ�㷨�� MessageDigest ����
	        md5.update(str.getBytes());//�Ƚ��ַ���ת����byte���飬����byte �������ժҪ
	        byte[] nStr = md5.digest();//��ϣ���㣬������
	        return bytes2Hex(nStr);//���ܵĽ����byte���飬��byte����ת�����ַ���
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
