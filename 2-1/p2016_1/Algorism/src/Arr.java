class Arr{
	byte a=  0x41;
	byte b= 65;
	byte c= 0b01000001;
	public void print(){
	System.out.println("10 진수 : "+b);
	System.out.println("2 진수 : "+ c);
	System.out.println("16진수 :"+a);
	}
	public void Abb(){ //2의 보수
		
		byte d = (byte) (0b10111110 + 1);//산술 연산
		byte e = (byte) ((c ^ d)+1);//논리 연산
		
		System.out.println("2의보수에 대한 산술연산 :"+ d);
		System.out.println("2의 보수에 대한 논리연산 :"+e);
		
	}
	public void ToString(byte d, byte e){
		System.out.println("산술연산의 2진수 : "+d + "논리연산 :" +e);
		
	}
	
	
}