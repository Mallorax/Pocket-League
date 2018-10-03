package pl.patrykzygo.pocketleague.logic;


import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import pl.patrykzygo.pocketleague.pojo.Item;

public class ItemsListSorter {


    public ItemsListSorter(){}


    public List<Item> getListByNameAsc(List<Item> list){
        Collections.sort(list, Comparator.comparing(Item::getName));
        return list;
    }


    public List<Item> getListByNameDesc(List<Item> list){
        Collections.sort(list, (o1, o2) -> o2.getName().compareTo(o1.getName()));
        return list;
    }


    public List<Item> getListByPriceAsc(List<Item> list){
        Collections.sort(list, Comparator.comparingInt(o -> o.getGold().getTotal()));
        return list;
    }


    public List<Item> getListByPriceDesc(List<Item> list){
        Collections.sort(list, (o1, o2) -> Integer.compare(o2.getGold().getTotal(), o1.getGold().getTotal()));
        return list;
    }
}
