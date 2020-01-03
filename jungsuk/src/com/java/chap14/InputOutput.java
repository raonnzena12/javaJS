package com.java.chap14;

import java.io.*;
import java.util.*;

public class InputOutput {
	public InputOutput() {}
	
	public void io1() {
		byte[] inSrc = {0,1,2,3,4,5,6,7,8,9};
		byte[] outSrc = null;
		
		ByteArrayInputStream input = null;
		ByteArrayOutputStream output = null;
		
		input = new ByteArrayInputStream(inSrc);
		output = new ByteArrayOutputStream();
		
		int data = 0;
		
		while((data = input.read()) != -1) {
			output.write(data);
		}
		
		outSrc = output.toByteArray();
		
		System.out.println("Input Source : " + Arrays.toString(inSrc));
		System.out.println("Output Source : " + Arrays.toString(outSrc));
	}
	
	public void io2() {
		byte[] inSrc = {0,1,2,3,4,5,6,7,8,9};
		byte[] outSrc = null;
		
		byte[] temp = new byte[10];
		
		ByteArrayInputStream input = null;
		ByteArrayOutputStream output = null;
		
		input = new ByteArrayInputStream(inSrc);
		output = new ByteArrayOutputStream();
		
		input.read(temp, 0, temp.length);
		output.write(temp, 5, 5);
		
		outSrc = output.toByteArray();
		
		System.out.println("Input Source : " + Arrays.toString(inSrc));
		System.out.println("temp : " + Arrays.toString(temp));
		System.out.println("Output Source : " + Arrays.toString(outSrc));
	}
	
	public void io3() {
		byte[] inSrc = {0,1,2,3,4,5,6,7,8,9};
		byte[] outSrc = null;
		byte[] temp = new byte[4];
		
		ByteArrayInputStream input = null;
		ByteArrayOutputStream output = null;
		
		input = new ByteArrayInputStream(inSrc);
		output = new ByteArrayOutputStream();
		
		try {
			while(input.available() > 0 ) {
				input.read(temp);
				output.write(temp);
			}
		} catch ( IOException e ) {}
		outSrc = output.toByteArray();
		
		System.out.println("Input Srouce : " + Arrays.toString(inSrc));
		System.out.println("temp : " + Arrays.toString(temp));
		System.out.println("Output Source : " + Arrays.toString(outSrc));
	}
	
	public void io4() {
		byte[] inSrc = {0,1,2,3,4,5,6,7,8,9};
		byte[] outSrc = null;
		
		byte[] temp = new byte[4];
		
		ByteArrayInputStream input = null;
		ByteArrayOutputStream output = null;
		
		input = new ByteArrayInputStream(inSrc);
		output = new ByteArrayOutputStream();
		
		try {
			while ( input.available() > 0 ) {
				int len = input.read(temp);
				output.write(temp, 0, len);
			}
		} catch( IOException e ) {}
		
		outSrc = output.toByteArray();
		
		System.out.println("input Source : " + Arrays.toString(inSrc));
		System.out.println("temp : " + Arrays.toString(temp));
		System.out.println("output Source : " + Arrays.toString(outSrc));
	}
	
	public void dataOutputStream1() {
		FileOutputStream fos = null;
		DataOutputStream dos = null;
		
		try {
			fos = new FileOutputStream("sample.dat");
			dos = new DataOutputStream(fos);
			dos.writeInt(10);
			dos.writeFloat(20.0f);
			dos.writeBoolean(true);
			
			dos.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void dataOutputStream2() {
		ByteArrayOutputStream bos = null;
		DataOutputStream dos = null;
		
		byte[] result = null;
		
		try {
			bos = new ByteArrayOutputStream();
			dos = new DataOutputStream(bos);
			dos.writeInt(10);
			dos.writeFloat(20.0f);
			dos.writeBoolean(true);
			
			result = bos.toByteArray();
			String[] hex = new String[result.length];
			
			for ( int i = 0 ; i < result.length ; i++ ) {
				if ( result[i] < 0 ) {
					hex[i] = Integer.toHexString(result[i] + 256);
				} else {
					hex[i] = Integer.toHexString(result[i]);
				}
			}
		} catch ( IOException e ) {
			e.printStackTrace();
		}
	}
}
