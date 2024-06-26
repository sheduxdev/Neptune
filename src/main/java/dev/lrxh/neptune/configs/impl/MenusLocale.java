package dev.lrxh.neptune.configs.impl;

import dev.lrxh.neptune.utils.ConfigFile;
import lombok.Getter;

import org.jetbrains.annotations.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
public enum MenusLocale implements IDataAccessor {
    FILTER_MATERIAL("FILTER.MATERIAL", "Filter Item for menus.", DataType.STRING, "BLACK_STAINED_GLASS_PANE"),
    FILTER_NAME("FILTER.NAME", "Filter Item name.", DataType.STRING, ""),
    QUEUE_SELECT_KIT_NAME("QUEUE.SELECT.NAME", null, DataType.STRING, "&b<kit>"),
    QUEUE_SELECT_SIZE("QUEUE.SELECT.SIZE", null, DataType.INT, "36"),
    QUEUE_SELECT_STARTING_SLOT("QUEUE.SELECT.STARTING-SLOT", null, DataType.INT, "10"),
    QUEUE_SELECT_FILTER("QUEUE.SELECT.FILTER-TYPE", "FILL, BORDER, NONE", DataType.STRING, "FILL"),
    QUEUE_SELECT_TITLE("QUEUE.SELECT.TITLE", null, DataType.STRING, "&7Select Kit"),
    QUEUE_SELECT_LORE("QUEUE.SELECT.LORE", null, DataType.STRING_LIST
            , "",
            " &f&7* &fIn Fights: &b<playing>",
            " &f&7* &fQueued: &b<queue>",
            " ",
            "&a&lClick to play!"),
    KIT_EDITOR_SELECT_KIT_NAME("KIT_EDITOR.SELECT.NAME", null, DataType.STRING, "&b<kit>"),
    KIT_EDITOR_SELECT_SIZE("KIT_EDITOR.SELECT.SIZE", null, DataType.INT, "36"),
    KIT_EDITOR_SELECT_STARTING_SLOT("KIT_EDITOR.SELECT.STARTING-SLOT", null, DataType.INT, "10"),
    KIT_EDITOR_SELECT_FILTER("KIT_EDITOR.SELECT.FILTER-TYPE", "FILL, BORDER, NONE", DataType.STRING, "FILL"),
    KIT_EDITOR_SELECT_TITLE("KIT_EDITOR.SELECT.TITLE", null, DataType.STRING, "&7Kit Editor"),
    KIT_EDITOR_SELECT_LORE("KIT_EDITOR.SELECT.LORE", null, DataType.STRING_LIST, "", " &aClick to edit kit"),
    STAT_KIT_NAME("STAT.NAME", null, DataType.STRING, "&b<kit>"),
    STAT_SIZE("STAT.SIZE", null, DataType.INT, "36"),
    STAT_STARTING_SLOT("STAT.STARTING-SLOT", null, DataType.INT, "10"),
    STAT_FILTER("STAT.FILTER-TYPE", "FILL, BORDER, NONE", DataType.STRING, "FILL"),
    STAT_TITLE("STAT.TITLE", null, DataType.STRING, "&7<player> Statistics"),
    STAT_LORE("STAT.LORE", null, DataType.STRING_LIST,
            " &f&7* &fWins: &b<wins>",
            " &f&7* &fLosses: &b<losses>",
            " &f&7* &fCurrent Streak: &b<win_streak_current>",
            " &f&7* &fBest Streak: &b<win_streak_best>",
            " &f&7* K/D &b<kill_death_ratio>"),
    MATCH_LIST_TITLE("MATCH.LIST.TITLE", null, DataType.STRING, "&7Select Match"),
    MATCH_LIST_SIZE("MATCH_LIST.SIZE", null, DataType.INT, "36"),
    MATCH_LIST_STARTING_SLOT("MATCH_LIST.STARTING-SLOT", null, DataType.INT, "10"),
    MATCH_LIST_FILTER("MATCH_LIST.FILTER-TYPE", "FILL, BORDER, NONE", DataType.STRING, "FILL"),
    MATCH_LIST_ITEM_NAME("MATCH_LIST.ITEM.NAME", null, DataType.STRING,
            "&c<playerRed_name> &7vs &9<playerBlue_name>"),
    MATCH_LIST_ITEM_LORE("MATCH_LIST.ITEM.LORE", null, DataType.STRING_LIST,
            "&fArena: &b<arena>",
            "&fKit: &b<kit>",
            "",
            "&a&lClick to watch match!"),
    DUEL_TITLE("DUEL.TITLE", null, DataType.STRING, "&7Select Kit"),
    DUEL_SIZE("DUEL.SIZE", null, DataType.INT, "36"),
    DUEL_STARTING_SLOT("DUEL.STARTING-SLOT", null, DataType.INT, "10"),
    DUEL_FILTER("DUEL.FILTER-TYPE", "FILL, BORDER, NONE", DataType.STRING, "FILL"),
    DUEL_ITEM_NAME("DUEL.ITEM.NAME", null, DataType.STRING, "&b<kit>"),
    DUEL_LORE("DUEL.LORE", null, DataType.STRING_LIST,
            "",
            "&a&lClick to select kit!"),
    ROUNDS_TITLE("ROUNDS.TITLE", null, DataType.STRING, "&7Select Rounds amount"),
    ROUNDS_SIZE("ROUNDS.SIZE", null, DataType.INT, "27"),
    ROUNDS_STARTING_SLOT("DUEL.STARTING-SLOT", null, DataType.INT, "10"),
    ROUNDS_FILTER("ROUNDS.FILTER-TYPE", "FILL, BORDER, NONE", DataType.STRING, "FILL"),
    ROUNDS_ITEM_NAME("ROUNDS.ITEM.NAME", null, DataType.STRING, "&bFirst to &b&l<rounds>"),
    ROUNDS_LORE("ROUNDS.LORE", null, DataType.STRING_LIST,
            "",
            "&a&lClick to select rounds amount!"),
    MATCH_HISTORY_TITLE("MATCH_HISTORY.TITLE", null, DataType.STRING, "&7Match History"),
    MATCH_HISTORY_SIZE("MATCH_HISTORY.SIZE", null, DataType.INT, "27"),
    MATCH_HISTORY_STARTING_SLOT("MATCH_HISTORY.STARTING-SLOT", null, DataType.INT, "10"),
    MATCH_HISTORY_FILTER("MATCH_HISTORY.FILTER-TYPE", "FILL, BORDER, NONE", DataType.STRING, "FILL"),
    MATCH_HISTORY_ITEM_NAME("MATCH_HISTORY.ITEM.NAME", null, DataType.STRING, "&b<winner> &fvs &b<loser> <won>"),
    MATCH_HISTORY_LORE("MATCH_HISTORY.LORE", null, DataType.STRING_LIST,
            "&7&m-------------------",
            "&fWinner: &a<winner>",
            "&fLoser: &c<loser>",
            "&fDate: &b<date>",
            "&fArena: &b<arena>",
            "&7&m-------------------"),
    LEADERBOARD_TITLE("LEADERBOARD.TITLE", null, DataType.STRING, "&7<type> Leaderboards"),
    LEADERBOARD_SIZE("LEADERBOARD.SIZE", null, DataType.INT, "36"),
    LEADERBOARD_STARTING_SLOT("LEADERBOARD.STARTING-SLOT", null, DataType.INT, "10"),
    LEADERBOARD_FILTER("LEADERBOARD.FILTER-TYPE", "FILL, BORDER, NONE", DataType.STRING, "FILL"),
    LEADERBOARD_ITEM_NAME("LEADERBOARD.ITEM.NAME", null, DataType.STRING, "&b<kit> Top 10"),
    LEADERBOARD_LORE("LEADERBOARD.LORE", null, DataType.STRING_LIST,
            "&b#1. &f<player_1> &7- &b <value_1>",
            "&b#2. &f<player_2> &7- &b <value_2>",
            "&b#3. &f<player_3> &7- &b <value_3>",
            "&b#4. &f<player_4> &7- &b <value_4>",
            "&b#5. &f<player_5> &7- &b <value_5>",
            "&b#6. &f<player_6> &7- &b <value_6>",
            "&b#7. &f<player_7> &7- &b <value_7>",
            "&b#8. &f<player_8> &7- &b <value_8>",
            "&b#9. &f<player_9> &7- &b <value_9>",
            "&b#10. &f<player_10> &7- &b <value_10>"),
    LEADERBOARD_TYPES_KILLS_SLOT("LEADERBOARD.TYPES.KILLS.SLOT", null, DataType.INT, "29"),
    LEADERBOARD_TYPES_KILLS_ENABLED_TITLE("LEADERBOARD.TYPES.KILLS.ENABLED.TITLE", null, DataType.STRING,
            "&aKills Leaderboard"),
    LEADERBOARD_TYPES_KILLS_DISABLED_TITLE("LEADERBOARD.TYPES.KILLS.DISABLED.TITLE", null, DataType.STRING,
            "&cKills Leaderboard"),
    LEADERBOARD_TYPES_KILLS_ENABLED_LORE("LEADERBOARD.TYPES.KILLS.ENABLED.LORE", null, DataType.STRING_LIST,
            " ",
            "&7Click to view kills leaderboard"),
    LEADERBOARD_TYPES_KILLS_DISABLED_LORE("LEADERBOARD.TYPES.KILLS.DISABLED.LORE", null, DataType.STRING_LIST,
            " ",
            "&7Click to view kills leaderboard"),
    LEADERBOARD_TYPES_KILLS_ENABLED_MATERIAL("LEADERBOARD.TYPES.KILLS.ENABLED.MATERIAL", null, DataType.STRING,
            "LIME_DYE"),
    LEADERBOARD_TYPES_KILLS_DISABLED_MATERIAL("LEADERBOARD.TYPES.KILLS.DISABLED.MATERIAL", null, DataType.STRING,
            "GRAY_DYE"),
    LEADERBOARD_TYPES_WIN_STREAK_SLOT("LEADERBOARD.TYPES.BEST_STREAK.SLOT", null, DataType.INT, "31"),
    LEADERBOARD_TYPES_WIN_STREAK_ENABLED_TITLE("LEADERBOARD.TYPES.WIN_STREAK.ENABLED.TITLE", null, DataType.STRING,
            "&aBest Win Streaks Leaderboard"),
    LEADERBOARD_TYPES_WIN_STREAK_DISABLED_TITLE("LEADERBOARD.TYPES.WIN_STREAK.DISABLED.TITLE", null, DataType.STRING,
            "&cBest Win Streaks Leaderboard"),
    LEADERBOARD_TYPES_WIN_STREAK_ENABLED_LORE("LEADERBOARD.TYPES.WIN_STREAK.ENABLED.LORE", null, DataType.STRING_LIST,
            " ",
            "&7Click to view best win streak leaderboards"),
    LEADERBOARD_TYPES_WIN_STREAK_DISABLED_LORE("LEADERBOARD.TYPES.WIN_STREAK.DISABLED.LORE", null, DataType.STRING_LIST,
            " ",
            "&7Click to view best win streak leaderboards"),
    LEADERBOARD_TYPES_WIN_STREAK_ENABLED_MATERIAL("LEADERBOARD.TYPES.WIN_STREAK.ENABLED.MATERIAL", null, DataType.STRING,
            "LIME_DYE"),
    LEADERBOARD_TYPES_WIN_STREAK_DISABLED_MATERIAL("LEADERBOARD.TYPES.WIN_STREAK.DISABLED.MATERIAL", null, DataType.STRING,
            "GRAY_DYE"),
    LEADERBOARD_TYPES_DEATHS_SLOT("LEADERBOARD.TYPES.DEATHS.SLOT", null, DataType.INT, "33"),
    LEADERBOARD_TYPES_DEATHS_ENABLED_TITLE("LEADERBOARD.TYPES.DEATHS.ENABLED.TITLE", null, DataType.STRING,
            "&aDeaths Leaderboard"),
    LEADERBOARD_TYPES_DEATHS_DISABLED_TITLE("LEADERBOARD.TYPES.DEATHS.DISABLED.TITLE", null, DataType.STRING,
            "&cDeaths Leaderboard"),
    LEADERBOARD_TYPES_DEATHS_ENABLED_LORE("LEADERBOARD.TYPES.DEATHS.ENABLED.LORE", null, DataType.STRING_LIST,
            " ",
            "&7Click to view win streak leaderboards"),
    LEADERBOARD_TYPES_DEATHS_DISABLED_LORE("LEADERBOARD.TYPES.DEATHS.DISABLED.LORE", null, DataType.STRING_LIST,
            " ",
            "&7Click to view death leaderboards"),
    LEADERBOARD_TYPES_DEATHS_ENABLED_MATERIAL("LEADERBOARD.TYPES.DEATHS.ENABLED.MATERIAL", null, DataType.STRING,
            "LIME_DYE"),
    LEADERBOARD_TYPES_DEATHS_DISABLED_MATERIAL("LEADERBOARD.TYPES.DEATHS.DISABLED.MATERIAL", null, DataType.STRING,
            "GRAY_DYE"),
    PARTY_SETTINGS_TITLE("PARTY.SETTINGS.TITLE", null, DataType.STRING, "&7Party Settings"),
    PARTY_SETTINGS_SIZE("PARTY.SETTINGS.SIZE", null, DataType.INT, "27"),
    PARTY_SETTINGS_FILTER("PARTY.SETTINGS.FILTER-TYPE", "FILL, BORDER, NONE", DataType.STRING, "FILL"),
    PARTY_SETTINGS_PRIVACY_TITLE("PARTY.SETTINGS.PRIVACY.TITLE", null, DataType.STRING, "&ePublic Party"),
    PARTY_SETTINGS_PRIVACY_MATERIAL("PARTY.SETTINGS.PRIVACY.MATERIAL", null, DataType.STRING, "OAK_SIGN"),
    PARTY_SETTINGS_PRIVACY_SLOT("PARTY.SETTINGS.PRIVACY.SLOT", null, DataType.INT, "10"),
    PARTY_SETTINGS_PRIVACY_ENABLED_LORE("PARTY.SETTINGS.PRIVACY.ENABLED-LORE", null, DataType.STRING_LIST,
            "&7Would you like for players to",
            "&7join without inviting them?",
            "",
            " &a&l▶ &aEnabled",
            " &7&l▶ &7Disabled",
            " ",
            "&aClick to disable."),
    PARTY_SETTINGS_PRIVACY_DISABLED_LORE("PARTY.SETTINGS.PRIVACY.DISABLED-LORE", null, DataType.STRING_LIST,
            "&7Would you like for players to",
            "&7join without inviting them?",
            "",
            " &7&l▶ &7Enabled",
            " &c&l▶ &cDisabled",
            " ",
            "&aClick to enable."),
    PARTY_SETTINGS_MAX_SIZE_TITLE("PARTY.SETTINGS.MAX_SIZE.TITLE", null, DataType.STRING, "&ePlayer Limit"),
    PARTY_SETTINGS_MAX_SIZE_MATERIAL("PARTY.SETTINGS.MAX_SIZE.MATERIAL", null, DataType.STRING, "OAK_SIGN"),
    PARTY_SETTINGS_MAX_SIZE_SLOT("PARTY.SETTINGS.MAX_SIZE.SLOT", null, DataType.INT, "11"),
    PARTY_SETTINGS_MAX_SIZE_LORE("PARTY.SETTINGS.MAX_SIZE.ENABLED-LORE", null, DataType.STRING_LIST,
            "&7Set the maximum size of the party.",
            "",
            "&7Current Size: <size>",
            "",
            "&aClick to increase.",
            "&cRight Click to decrease."),
    PARTY_EVENTS_TITLE("PARTY.EVENTS.TITLE", null, DataType.STRING, "&7Party Events"),
    PARTY_EVENTS_SIZE("PARTY.EVENTS.SIZE", null, DataType.INT, "27"),
    PARTY_EVENTS_FILTER("PARTY.EVENTS.FILTER-TYPE", "FILL, BORDER, NONE", DataType.STRING, "FILL"),
    PARTY_EVENTS_SPLIT_MATERIAL("PARTY.EVENTS.SPLIT.MATERIAL", null, DataType.STRING, "DIAMOND_SWORD"),
    PARTY_EVENTS_SPLIT_SLOT("PARTY.EVENTS.SPLIT.SLOT", null, DataType.INT, "10"),
    PARTY_EVENTS_SPLIT_TITLE("PARTY.EVENTS.SPLIT.TITLE", null, DataType.STRING, "&eParty Split"),
    PARTY_EVENTS_SPLIT_LORE("PARTY.EVENTS.SPLIT.LORE", null, DataType.STRING_LIST,
            "&7Split the party into",
            "&7two teams and fight.",
            " ",
            "&a&lClick to start event!"),
    PARTY_EVENTS_FFA_MATERIAL("PARTY.EVENTS.FFA.MATERIAL", null, DataType.STRING, "GOLDEN_AXE"),
    PARTY_EVENTS_FFA_SLOT("PARTY.EVENTS.FFA.SLOT", null, DataType.INT, "12"),
    PARTY_EVENTS_FFA_TITLE("PARTY.EVENTS.FFA.TITLE", null, DataType.STRING, "&eParty FFA"),
    PARTY_EVENTS_FFA_LORE("PARTY.EVENTS.FFA.LORE", null, DataType.STRING_LIST,
            "&7Players fight each other",
            "&7till one is standing.",
            " ",
            "&a&lClick to start event!"),
    PARTY_EVENTS_KIT_SELECT_TITLE("PARTY.EVENTS.KIT.SELECT.TITLE", null, DataType.STRING, "&eKit Select"),
    PARTY_EVENTS_KIT_SELECT_SLOT("PARTY.EVENTS.KIT.SELECT.STARTING-SLOT", null, DataType.INT, "10"),
    PARTY_EVENTS_KIT_SELECT_NAME("PARTY.EVENTS.KIT.SELECT.ITEM-NAME", null, DataType.STRING, "&b<kit>"),
    PARTY_EVENTS_KIT_SELECT_LORE("PARTY.EVENTS.KIT.SELECT.LORE", null, DataType.STRING_LIST, " ", "&a&lClick to select kit"),
    PARTY_EVENTS_KIT_SELECT_SIZE("PARTY.EVENTS.KIT.SELECT.SIZE", null, DataType.INT, "27");


    private final String path;
    private final String comment;
    private final List<String> defaultValue = new ArrayList<>();
    private final DataType dataType;

    MenusLocale(String path, @Nullable String comment, DataType dataType, String... defaultValue) {
        this.path = path;
        this.comment = comment;
        this.defaultValue.addAll(Arrays.asList(defaultValue));
        this.dataType = dataType;
    }


    @Override
    public ConfigFile getConfigFile() {
        return plugin.getConfigManager().getMenusConfig();
    }
}
