package com.rxb.res.main;

public class Test {

	public static void main(String[] args) {
		String originalFilename="Lauterbrunnen, Switzerland.jpg";
		if(!originalFilename.contains(".")){
			System.out.println("名称不合法");
			return;
		}
		String suffix=originalFilename.substring(originalFilename.lastIndexOf(".")+1);
		System.out.println(suffix);
	}

}
