package pl.patrykzygo.pocketleague.logic;


import java.util.Collection;
import java.util.Collections;
import java.util.List;

import pl.patrykzygo.pocketleague.pojo.ItemDto;

public class ItemsListSorter {

    private List<ItemDto> items;

    public ItemsListSorter(List<ItemDto> items){
        this.items = items;
    }

    public ItemsListSorter(){}

    public List<ItemDto> getListByNameAsc(){
        Collections.sort(items, (o1, o2) -> o1.getName().compareTo(o2.getName()));
        return items;
    }

    public List<ItemDto> getListByNameAsc(List<ItemDto> list){
        Collections.sort(list, (o1, o2) -> o1.getName().compareTo(o2.getName()));
        return list;
    }

    public List<ItemDto> getListByNameDesc(){
        Collections.sort(items, (o1, o2) -> o2.getName().compareTo(o1.getName()));
        return items;
    }

    public List<ItemDto> getListByNameDesc(List<ItemDto> list){
        Collections.sort(list, (o1, o2) -> o2.getName().compareTo(o1.getName()));
        return list;
    }

    public List<ItemDto> getListByPriceAsc(){
        Collections.sort(items, (o1, o2) -> Integer.compare(o1.getGold().getTotal(), o2.getGold().getTotal()));
        return items;
    }

    public List<ItemDto> getListByPriceAsc(List<ItemDto> list){
        Collections.sort(list, (o1, o2) -> Integer.compare(o1.getGold().getTotal(), o2.getGold().getTotal()));
        return list;
    }

    public List<ItemDto> getListByPriceDesc(){
        Collections.sort(items, (o1, o2) -> Integer.compare(o2.getGold().getTotal(), o1.getGold().getTotal()));
        return items;
    }

    public List<ItemDto> getListByPriceDesc(List<ItemDto> list){
        Collections.sort(list, (o1, o2) -> Integer.compare(o2.getGold().getTotal(), o1.getGold().getTotal()));
        return list;
    }
}
