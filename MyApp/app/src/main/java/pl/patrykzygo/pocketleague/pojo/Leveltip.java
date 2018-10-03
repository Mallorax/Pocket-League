package pl.patrykzygo.pocketleague.pojo;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Leveltip{

	@SerializedName("effect")
	private List<String> effect;

	@SerializedName("label")
	private List<String> label;

	public void setEffect(List<String> effect){
		this.effect = effect;
	}

	public List<String> getEffect(){
		return effect;
	}

	public void setLabel(List<String> label){
		this.label = label;
	}

	public List<String> getLabel(){
		return label;
	}

	@Override
 	public String toString(){
		return 
			"Leveltip{" + 
			"effect = '" + effect + '\'' + 
			",label = '" + label + '\'' + 
			"}";
		}
}