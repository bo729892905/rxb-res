package com.rxb.res.main;

public class TestIndex {

	public static void main(String[] args) throws Exception {
		String originalFilename="Lauterbrunnen, Switzerland.jpg";
		if(!originalFilename.contains(".")){
			System.out.println("名称不合法");
			return;
		}
		String suffix=originalFilename.substring(originalFilename.lastIndexOf(".")+1);
		System.out.println(suffix);
	}

}
