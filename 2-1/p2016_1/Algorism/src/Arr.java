class Arr{
	byte a=  0x41;
	byte b= 65;
	byte c= 0b01000001;
	public void print(){
	System.out.println("10 ���� : "+b);
	System.out.println("2 ���� : "+ c);
	System.out.println("16���� :"+a);
	}
	public void Abb(){ //2�� ����
		
		byte d = (byte) (0b10111110 + 1);//��� ����
		byte e = (byte) ((c ^ d)+1);//�� ����
		
		System.out.println("2�Ǻ����� ���� ������� :"+ d);
		System.out.println("2�� ������ ���� ������ :"+e);
		
	}
	public void ToString(byte d, byte e){
		System.out.println("��������� 2���� : "+d + "������ :" +e);
		
	}
	
	
}