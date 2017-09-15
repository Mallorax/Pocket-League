package pl.patrykzygo.pocketleague.logic;


import android.net.Uri;

import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;

import javax.inject.Inject;

import pl.patrykzygo.pocketleague.app.Constants;
import pl.patrykzygo.pocketleague.pojo.ChampionDto;
import pl.patrykzygo.pocketleague.pojo.ChampionSpellDto;

public class ChampionDataParser {

    private Picasso picasso;

    @Inject
    public ChampionDataParser(Picasso picasso){
        this.picasso = picasso;
    }

    public ChampionDto parseThroughAll(ChampionDto championDto)throws IOException{
        ChampionDto champion = parseTips(parseLoreString(setChampionSkillsIcons(setChampionIcon(setChampionAttackSpeed(championDto)))));
        return champion;
    }

    public ChampionDto setChampionIcon(ChampionDto champion)throws IOException{
        champion.getImage().setBitmap(picasso.load(Uri.parse("http://ddragon.leagueoflegends.com/cdn/"+ Constants.VERSION+"/img/champion/"+champion.getImage().getFull())).get());
        return champion;
    }

    public ChampionDto setChampionSkillsIcons(ChampionDto champion)throws IOException{
        List<ChampionSpellDto> spells = champion.getSpells();
            champion.getPassive().getImage().setBitmap(picasso.load(Uri.parse("http://ddragon.leagueoflegends.com/cdn/"+ Constants.VERSION+"/img/passive/" +champion.getPassive().getImage().getFull())).get());
            for (ChampionSpellDto spell : spells){
                spell.getImage().setBitmap(picasso.load(Uri.parse("http://ddragon.leagueoflegends.com/cdn/"+ Constants.VERSION+"/img/spell/" +spell.getImage().getFull())).get());
            }
        return champion;
    }

    public ChampionDto setChampionAttackSpeed(ChampionDto champion){
        double as = 0.625 / (1 + champion.getStats().getAttackspeedoffset());
        DecimalFormat format = new DecimalFormat("#.###");
        double attackSpeed = Double.valueOf(format.format(as));
        champion.getStats().setAttackspeed(attackSpeed);
        return champion;
    }

    public ChampionDto parseLoreString(ChampionDto champion){
        String lore = champion.getLore().replace("<br>", "\n");
        champion.setLore(lore);
        return champion;
    }

    public ChampionDto parseTips(ChampionDto champion){
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
