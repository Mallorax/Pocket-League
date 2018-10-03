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
        DecimalFormat df = new DecimalFormat("#.###");
        double as = (0.625d) / (1.0d + champion.getStats().getAttackspeedoffset());

        champion.getStats().setAttackspeed(Double.parseDouble(df.format(as)));
        return champion;
    }

    public Champion parseLoreString(Champion champion){
        String lore = champion.getLore().replace("<br>", "\n");
        champion.setLore(lore);
        return champion;
    }

    public Champion parseAbilitiesString(Champion champion){
        String passive = champion.getPassive().getDescription().replace("<br>", "\n");
        champion.getPassive().setDescription(passive);
        for(int i = 0; i < 4; i++){
            champion.getSpells().get(i).setDescription( champion.getSpells().get(i).getDescription().replace("<br>", "\n"));
        }
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
