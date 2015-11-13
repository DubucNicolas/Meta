package fr.bibop.commons;

import java.math.BigInteger;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;


/**
 * Contains security methods.
 * 
 * @author JCA
 */
public class Security {

	private static String algorithm = "Blowfish";
	private static String encoding = "UTF-8";

	/**
	 * Password encryption
	 * 
	 * @param password : textual value
	 * @return encoded password
	 * @throws Exception
	 */
	public static String encrypt(String password) throws SecurityException {
		
		try {
			
			byte[] psw = password.getBytes(encoding);
			Key key = new SecretKeySpec(getSecretKey(), algorithm);
			Cipher cipher = Cipher.getInstance(algorithm);
			cipher.init(Cipher.ENCRYPT_MODE, key);
			byte[] res = cipher.doFinal(psw);
			String r = "";
			String add;
			
			for (int i = 0 ; i < res.length ; i++) {
				
				add = Integer.toHexString(res[i] & 0xff);
				if (add.length() % 2 != 0)
					add = "0" + add;
				r += add;
			
			}

			return r;
			
		} catch (Exception e) {
			throw new SecurityException();
		}
	}
	
	/**
	 * Password decryption
	 * 
	 * @param encryptedPassword
	 * @return textual password
	 * @throws Exception
	 */
	public static String decrypt(String encryptedPassword) throws SecurityException {
		try {
			
			int size = encryptedPassword.length();
			BigInteger bi;
			int j = 0;
			byte[] psw = new byte[size / 2];
			
			for (int i = 0; i < size ; i += 2) {
				
				bi = new BigInteger(encryptedPassword.substring(i, i+2), 16);
				psw[j++] = bi.byteValue();
			}
			
			Key key = new SecretKeySpec(getSecretKey(), algorithm);
			Cipher cipher = Cipher.getInstance(algorithm);
			cipher.init(Cipher.DECRYPT_MODE, key);
			byte[] result = cipher.doFinal(psw);
			return new String(result, encoding);
			
		} catch (Exception e) {
			throw new SecurityException(e.getMessage(), e);
			
		}
	}

	/**
	 * Digest method to get secret.
	 * 
	 * @return
	 * @throws UnknownHostException
	 */
	private static byte[] getSecretKey() throws UnknownHostException {
		String baseKey = "GY}XGKwf5}jom[J]";
		String othrKey = ":M]!J6<q8Ka,8UhT";
		String pdngKey = "!JurJ=$)Y*H(xe~g";
		
		String altnKey = InetAddress.getLocalHost().getHostName() + pdngKey;
		
		byte[] result = new byte[16];
		
		for (int i=0 ; i < 16 ; i++) {
			result[i] = (byte) (baseKey.getBytes()[i] % othrKey.getBytes()[i] % altnKey.getBytes()[i]); 
		}
		
		return result;
	}
}
