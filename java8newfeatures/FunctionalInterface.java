package com.java8newfeatures;

@FunctionalInterface 
 interface FunctionalInterface1 {
	public int go();

}
 class FunctionalClassExample implements  FunctionalInterface1
{
	@Override
	public int go() {
		System.out.println(".....Example for Functional interface-----");
		//System.out.println(".....Example for Functional interface-----\"");
		return 0;
	}
	public static void main(String []args) 
	{
		FunctionalClassExample obj1 = new FunctionalClassExample();
		obj1.go();
		
	}
	
}
