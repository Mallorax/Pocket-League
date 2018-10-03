package pl.patrykzygo.pocketleague.pojo;

import com.google.gson.annotations.SerializedName;

public class ItemStats {

	@SerializedName("FlatMovementSpeedMod")
	private double flatMovementSpeedMod;

	public void setFlatMovementSpeedMod(double flatMovementSpeedMod){
		this.flatMovementSpeedMod = flatMovementSpeedMod;
	}

	public double getFlatMovementSpeedMod(){
		return flatMovementSpeedMod;
	}

	@Override
 	public String toString(){
		return 
			"ItemStats{" +
			"flatMovementSpeedMod = '" + flatMovementSpeedMod + '\'' + 
			"}";
		}
}