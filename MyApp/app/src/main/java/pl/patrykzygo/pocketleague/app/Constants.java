package pl.patrykzygo.pocketleague.app;


public class Constants {

    public static final String BASE_URL = "https://eun1.api.riotgames.com";

    public static final String CHAMPIONS_WITH_IMAGES_REQUEST = "/champions?locale=en_US&tags=image&dataById=true";

    public static final String STATIC_DATA = "/lol/static-data/v3";

    public static final String VERSION = "7.19.1";

    public static final String [] STATIC_MENU_POSITIONS = {
            "Champions", "Items", "Masteries", "Runes", "Summoners spells", "Maps"
    };

    public static final String ITEMS_LIST_TAGS = "&tags=depth&tags=effect&tags=from&tags=gold&tags=groups&tags=image&tags=inStore&tags=into&tags=maps&tags=requiredChampion&tags=sanitizedDescription&tags=specialRecipe&tags=stacks&tags=tags&tags=tree";

}
