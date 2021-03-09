/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.heart.servlet;

/**
 *
 * @author JAVA-SAN
 */
import java.io.InputStream;
import java.io.OutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.security.Key;
 
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
 
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.spec.SecretKeySpec;
 
public class AESEncrypter
{
	Cipher ecipher;
	Cipher dcipher;
	
	public AESEncrypter(SecretKey key)
	{
		// Create an 8-byte initialization vector
		byte[] iv = new byte[]
		{
			0x00, 0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07, 0x08, 0x09,0x0a, 0x0b, 0x0c, 0x0d, 0x0e, 0x0f
		};
		
		AlgorithmParameterSpec paramSpec = new IvParameterSpec(iv);
		try
		{
			ecipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			dcipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			
			// CBC requires an initialization vector
			ecipher.init(Cipher.ENCRYPT_MODE, key, paramSpec);
			dcipher.init(Cipher.DECRYPT_MODE, key, paramSpec);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	// Buffer used to transport the bytes from one stream to another
	byte[] buf = new byte[1024];
	
	public void encrypt(InputStream in, OutputStream out)
	{
		try
		{
			// Bytes written to out will be encrypted
			out = new CipherOutputStream(out, ecipher);
			
			// Read in the cleartext bytes and write to out to encrypt
			int numRead = 0;
			while ((numRead = in.read(buf)) >= 0)
			{
				out.write(buf, 0, numRead);
			}
			out.close();
		}
		catch (java.io.IOException e)
		{
		}
	}
	
	public void decrypt(InputStream in, OutputStream out)
	{
		try
		{
			// Bytes read from in will be decrypted
			in = new CipherInputStream(in, dcipher);
			
			// Read in the decrypted bytes and write the cleartext to out
			int numRead = 0;
			while ((numRead = in.read(buf)) >= 0)
			{
				out.write(buf, 0, numRead);
			}
			out.close();
		}
		catch (java.io.IOException e)
		{
		}
	}
	private static Key generateKey() {
        String keyValue="TheBestSecretKey";
        Key key = new SecretKeySpec(keyValue.getBytes(), "AES");        
        return key;
    }
	public static void main(String args[])
	{
		try
		{
			// Generate a temporary key. In practice, you would save this key.
			// See also e464 Encrypting with DES Using a Pass Phrase.
			   Key key1 = generateKey();
			KeyGenerator	kgen	=	KeyGenerator.getInstance("AES");
			kgen.init(128);
			SecretKey key			=	kgen.generateKey();
			System.out.println();
			// Create encrypter/decrypter class
			AESEncrypter encrypter = new AESEncrypter((SecretKey)key1);
			
			// Encrypt
			encrypter.encrypt(new FileInputStream("D:\\Documents and Settings\\JAVA-SAN\\My Documents\\My Pictures\\2.JPG"),new FileOutputStream("C:/Encrypted.jpg"));
			// Decrypt
			//encrypter.decrypt(new FileInputStream("C:/Encrypted.jpg"),new FileOutputStream("C:/Decrypted.jpg"));;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
