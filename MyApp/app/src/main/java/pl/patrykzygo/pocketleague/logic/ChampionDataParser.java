package pl.patrykzygo.pocketleague.logic;


import java.text.DecimalFormat;
import java.util.List;

import pl.patrykzygo.pocketleague.pojo.Champion;


public class ChampionDataParser {



    public Champion parseThroughAll(Champion championDto){
        Champion champion = parseTips(parseLoreString(setChampionAttackSpeed(championDto)));
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
