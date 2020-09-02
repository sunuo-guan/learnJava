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
	
	//重写，说明比较大小关系方式：按价格大小
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
				//再按名字从低到高
				this.name.compareTo(goods.name);
			}
		}
		throw new RuntimeException("数据类型错误");
		
	}

	@Override
	public String toString() {
		return "Goods [prices=" + prices + ", name=" + name + "]";
	}
	
	
}
