package dev.lrxh.neptune.arena.impl;

import dev.lrxh.neptune.Neptune;
import dev.lrxh.neptune.arena.Arena;
import dev.lrxh.neptune.configs.impl.SettingsLocale;
import dev.lrxh.neptune.kit.Kit;
import dev.lrxh.neptune.utils.GenerationUtils;
import dev.lrxh.utils.ConcurrentLinkedHashMap;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;


@Getter
@Setter
@SuperBuilder
public class StandAloneArena extends Arena {
    private transient ConcurrentLinkedHashMap<Chunk, Object[]> chunkSnapshots;
    private Location min;
    private Location max;
    private double deathY;
    private double limit;
    private boolean used;
    private HashSet<StandAloneArena> copies;
    private boolean duplicate;

    public StandAloneArena(String name, String displayName, Location redSpawn, Location blueSpawn, Location min, Location max, HashSet<StandAloneArena> copies, double deathY, double limit, boolean enabled, boolean duplicate) {
        super(name, displayName, redSpawn, blueSpawn, enabled);
        this.min = min;
        this.max = max;
        this.copies = copies;
        this.limit = limit;
        this.deathY = deathY;
        this.used = false;
        this.duplicate = duplicate;
        this.chunkSnapshots = new ConcurrentLinkedHashMap<>();

        takeSnapshot();
    }

    public List<String> getCopiesAsString() {
        List<String> copiesString = null;
        if (copies != null && !copies.isEmpty()) {
            copiesString = new ArrayList<>();
            for (Arena arena : copies) {
                copiesString.add(arena.getName());
            }
        }
        return copiesString;
    }

    public void takeSnapshot() {
        if (min != null && max != null) {
            chunkSnapshots = Neptune.get().getVersionHandler().getChunk().takeSnapshot(getMin().getWorld(), min, max);
        }
    }

    public void restoreSnapshot() {
        if (min != null && max != null) {
            Neptune.get().getVersionHandler().getChunk().restoreSnapshot(chunkSnapshots, getMin().getWorld());
        }
    }

    public void createCopy(UUID playerUUID) {
        Player player = Bukkit.getPlayer(playerUUID);
        if (player == null) return;
        int space = SettingsLocale.ARENA_COPY_DISTANCE.getInt() * (copies.size() + 1);


        GenerationUtils.createRegion(playerUUID, min, max);
        GenerationUtils.pasteRegion(playerUUID, max.add(space, 0, 0));

        StandAloneArena copy
                = new StandAloneArena(getName() + "#" + (copies.size() + 1), getDisplayName(),
                getRedSpawn().add(space, 0, 0),
                getBlueSpawn().add(space, 0, 0),
                min.add(space, 0, 0),
                max.add(space, 0, 0), new HashSet<>(), getDeathY(), getLimit(), isEnabled(), true);

        Neptune.get().getArenaManager().arenas.add(copy);
        copies.add(copy);
        addCopyToKits(copy);

        Neptune.get().getArenaManager().saveArenas();
        Neptune.get().getKitManager().saveKits();
    }

    private void addCopyToKits(Arena copy) {
        for (Kit kit : Neptune.get().getKitManager().kits) {
            if (kit.getArenas().contains(this)) {
                kit.getArenas().add(copy);
            }
        }
    }
}