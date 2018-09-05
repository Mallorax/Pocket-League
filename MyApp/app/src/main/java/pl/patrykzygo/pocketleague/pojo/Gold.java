package pl.patrykzygo.pocketleague.pojo;

import com.google.gson.annotations.SerializedName;

public class Gold{

	@SerializedName("purchasable")
	private boolean purchasable;

	@SerializedName("total")
	private int total;

	@SerializedName("sell")
	private int sell;

	@SerializedName("base")
	private int base;

	public void setPurchasable(boolean purchasable){
		this.purchasable = purchasable;
	}

	public boolean isPurchasable(){
		return purchasable;
	}

	public void setTotal(int total){
		this.total = total;
	}

	public int getTotal(){
		return total;
	}

	public void setSell(int sell){
		this.sell = sell;
	}

	public int getSell(){
		return sell;
	}

	public void setBase(int base){
		this.base = base;
	}

	public int getBase(){
		return base;
	}

	@Override
 	public String toString(){
		return 
			"Gold{" + 
			"purchasable = '" + purchasable + '\'' + 
			",total = '" + total + '\'' + 
			",sell = '" + sell + '\'' + 
			",base = '" + base + '\'' + 
			"}";
		}
}