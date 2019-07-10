package site.yanyan.learn.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;

public class MD5Utils {
	/** 
	 * 文件获取MD5大写 
	 * @param file 
	 * @return 
	 * @throws FileNotFoundException 
	 */
	public static String getMD5MakeLower(File file) throws FileNotFoundException {
		String value = null;
		FileInputStream in = new FileInputStream(file);
		try {
			MappedByteBuffer byteBuffer = in.getChannel().map(FileChannel.MapMode.READ_ONLY, 0, file.length());
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			md5.update(byteBuffer);
			BigInteger bi = new BigInteger(1, md5.digest());
			value = bi.toString(16); 

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != in) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return value;
	}

	/**

	 * 文件获取MD5小写  
	 * @param upload 
	 * @return 
	 * @throws Exception 
	 */
	public static String getMD5LowerStr(MultipartFile upload) throws Exception {
		byte[] uploadBytes = upload.getBytes();
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		byte[] digest = md5.digest(uploadBytes);
		String hashString = new BigInteger(1, digest).toString(16);
		return hashString.toUpperCase();
	}

	private static char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e',
			'f' };

	public final static String getMD5(byte[] source) {
		String s = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(source);
			byte tmp[] = md.digest(); // MD5 的计算结果是一个 128 位的长整数， 
			// 用字节表示就是 16 个字节 
			char str[] = new char[16 * 2]; // 每个字节用 16 进制表示的话，使用两个字符， 
			// 所以表示成 16 进制需要 32 个字符 
			int k = 0; // 表示转换结果中对应的字符位置 
			for (int i = 0; i < 16; i++) { // 从第一个字节开始，对 MD5 的每一个字节 
				// 转换成 16 进制字符的转换 
				byte byte0 = tmp[i]; // 取第 i 个字节 
				str[k++] = hexDigits[byte0 >>> 4 & 0xf]; // 取字节中高 4 位的数字转换, 
				// >>> 为逻辑右移，将符号位一起右移 
				str[k++] = hexDigits[byte0 & 0xf]; // 取字节中低 4 位的数字转换 
			}
			s = new String(str); // 换后的结果转换为字符串 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}

	public static String getMD5(String str) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(str.getBytes());
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
		} catch (Exception e) {
			e.printStackTrace(); 
		}
		return str;
	}

	public static void main(String[] args) {
		System.out.println(getMD5("31119@qq.com" + "123456"));
		System.out.println(getMD5("mj1"));
	}
}

