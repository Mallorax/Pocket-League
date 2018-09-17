package pl.patrykzygo.pocketleague.logic;


import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import pl.patrykzygo.pocketleague.pojo.Champion;
import pl.patrykzygo.pocketleague.pojo.SpellsItem;


public class ChampionDataParser {



    public Champion parseThroughAll(Champion championDto){
        Champion champion = parseTips(parseAbilitiesString(parseLoreString(setChampionAttackSpeed(championDto))));
        return champion;
    }

    public Champion setChampionAttackSpeed(Champion champion){
        double as = 0.625 / (1 + champion.getStats().getAttackspeedoffset());
        DecimalFormat format = new DecimalFormat("#.###");
        double attackSpeed = Double.valueOf(format.format(as));
        champion.getStats().setAttackspeed(attackSpeed);
        return champion;
    }

    public Champion parseLoreString(Champion champion){
        String lore = champion.getLore().replace("<br>", "\n");
        champion.setLore(lore);
        return champion;
    }

    public Champion parseAbilitiesString(Champion champion){
        String passive = champion.getPassive().getDescription().replace("<br>", "\n");
        String q = champion.getSpells().get(0).getDescription().replace("<br>", "\n");
        String w = champion.getSpells().get(1).getDescription().replace("<br>", "\n");
        String e = champion.getSpells().get(2).getDescription().replace("<br>", "\n");
        String r = champion.getSpells().get(3).getDescription().replace("<br>", "\n");
        champion.getPassive().setDescription(passive);
        champion.getSpells().get(0).setDescription(q);
        champion.getSpells().get(1).setDescription(w);
        champion.getSpells().get(2).setDescription(e);
        champion.getSpells().get(3).setDescription(r);
        return champion;
    }

    public Champion parseTips(Champion champion){
        StringBuilder tips = new StringBuilder();
        List<String> tipsList = champion.getAllytips();
        tipsList.addAll(champion.getEnemytips());
        for (String tip : tipsList){
            tips.append(tip + "\n\n");
        }
        champion.setAllTips(tips.toString());
        return champion;
    }
}
