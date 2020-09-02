import java.math.*;

public class TestPrimitiveDataType {
	public static void main(String[] args) {
		int a = 15;
		int b = 015;  //0��ͷ�˽���
		int c = 0x15;  //0x��ͷ16����
		int d = 0b1101;   //0b��ͷ2����
		
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		
		byte age = 30;
		short num = 3000;
		int num2 = 30000000;     //���ͳ���Ĭ����int����
		long num3 = 3000000000L;  //�����L����һ�������ͳ���	
		
		//float e = 3.14;
		float e = 3.14f;
		double f = 6.21d;
		double g = 621e-2;
		
		System.out.println(g);
		
		//����������ȷ�������ڱȽ�
		float h = 0.1f;
		double i = 1.0/10.0;
		System.out.println(h==i);
		
		float j =423423423f;
		float j2 = j + 1;
		if(j == j2) {
			System.out.println("j == j2");
		}else {
			System.out.println("j != j2");
		}
		
		
		//���㾫�ȱȽϿ���BigDecimal
		BigDecimal bd = BigDecimal.valueOf(1.0);
		bd = bd.subtract(BigDecimal.valueOf(0.1));
		bd = bd.subtract(BigDecimal.valueOf(0.1));
		bd = bd.subtract(BigDecimal.valueOf(0.1));
		bd = bd.subtract(BigDecimal.valueOf(0.1));
		bd = bd.subtract(BigDecimal.valueOf(0.1));
		
		System.out.println(bd);
		System.out.println(1.0-0.1-0.1-0.1-0.1-0.1);
		
		BigDecimal bd2 = BigDecimal.valueOf(0.1);
		BigDecimal bd3 = BigDecimal.valueOf(1.0/10.0);
		
		System.out.println(bd2.equals(bd3));
		
	}
}
