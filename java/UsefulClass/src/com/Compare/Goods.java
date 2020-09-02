package com.Compare;

public class Goods implements Comparable{
	private int prices;
	private String name;
	
	public Goods() {
		
	}
	
	public Goods(int prices,String name) {
		this.name=name;
		this.prices=prices;
	}
	
	public int getPrices() {
		return prices;
	}
	public void setPrices(int prices) {
		this.prices = prices;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	//��д��˵���Ƚϴ�С��ϵ��ʽ�����۸��С
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		if(o instanceof Goods) {
			Goods goods=(Goods)o;
			if(this.prices>goods.prices) {
				return 1;
			}else if(this.prices<goods.prices) {
				return -1;
			}else {
				//return 0;
				//�ٰ����ִӵ͵���
				this.name.compareTo(goods.name);
			}
		}
		throw new RuntimeException("�������ʹ���");
		
	}

	@Override
	public String toString() {
		return "Goods [prices=" + prices + ", name=" + name + "]";
	}
	
	
}
