package pl.patrykzygo.pocketleague.pojo;


import java.util.List;
import java.util.Map;

public class ItemListDto {

    private Map<String, ItemDto> data;
    private String version;
    private List<ItemTreeDto> tree;
    private String type;

    public Map<String, ItemDto> getData() {
        return data;
    }

    public void setData(Map<String, ItemDto> data) {
        this.data = data;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public List<ItemTreeDto> getTree() {
        return tree;
    }

    public void setTree(List<ItemTreeDto> tree) {
        this.tree = tree;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
