package dev.lrxh.neptune.party;

import dev.lrxh.neptune.Neptune;
import dev.lrxh.neptune.configs.impl.MessagesLocale;
import dev.lrxh.neptune.party.impl.PartyRequest;
import dev.lrxh.neptune.profile.Profile;
import dev.lrxh.neptune.profile.ProfileState;
import dev.lrxh.neptune.providers.clickable.Replacement;
import lombok.Getter;
import lombok.Setter;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.event.ClickEvent;
import net.kyori.adventure.text.event.HoverEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.UUID;

@Getter
@Setter
public class Party {
    private final UUID leader;
    private final HashSet<UUID> users;
    private final boolean duelRequest;
    private boolean open;
    private int maxUsers;

    public Party(UUID leader) {
        this.leader = leader;
        this.users = new HashSet<>();
        this.users.add(leader);
        this.open = false;
        this.maxUsers = 10;
        this.duelRequest = true;

        setupPlayer(leader);
    }

    public void invite(UUID playerUUID) {
        Player player = Bukkit.getPlayer(playerUUID);
        if(player == null) return;

        TextComponent accept = Component.text(MessagesLocale.DUEL_ACCEPT.getString().replace("<leader>", Bukkit.getPlayer(leader).getName()))
                .clickEvent(ClickEvent.runCommand("/party accept " + leader))
                .hoverEvent(HoverEvent.showText(Component.text(MessagesLocale.PARTY_ACCEPT_HOVER.getString())));

        MessagesLocale.PARTY_INVITATION.send(playerUUID,
                new Replacement("<accept>", accept),
                new Replacement("<leader>", Bukkit.getPlayer(leader).getName()));

        Profile profile = Neptune.get().getProfileManager().getByUUID(playerUUID);
        profile.getGameData().addRequest(new PartyRequest(leader, this), leader,
                sender -> MessagesLocale.PARTY_EXPIRED.send(sender.getUniqueId(), new Replacement("<player>", player.getName())));
    }

    public void accept(UUID playerUUID) {
        if (users.size() + 1 > maxUsers) return;
        setupPlayer(playerUUID);
    }

    private void setupPlayer(UUID playerUUID) {
        Player invitedPlayer = Bukkit.getPlayer(playerUUID);
        if (invitedPlayer == null) return;
        users.add(playerUUID);
        Profile profile = Neptune.get().getProfileManager().getByUUID(playerUUID);
        profile.getGameData().setParty(this);
        profile.setState(ProfileState.IN_PARTY);
        broadcast(MessagesLocale.PARTY_JOINED, new Replacement("<player>", invitedPlayer.getName()));
        Neptune.get().getProfileManager().getByUUID(playerUUID).getGameData().removeRequest(leader);
    }

    public void kick(UUID playerUUID) {
        broadcast(MessagesLocale.PARTY_KICK, new Replacement("<player>", Bukkit.getPlayer(playerUUID).getName()));
        remove(playerUUID);
    }

    public void remove(UUID playerUUID) {
        Profile profile = Neptune.get().getProfileManager().getByUUID(playerUUID);
        users.remove(playerUUID);
        profile.getGameData().setParty(null);
        profile.setState(ProfileState.LOBBY);
    }

    public void disband() {
        broadcast(MessagesLocale.PARTY_DISBANDED);
        for (UUID user : users) {
            Profile profile = Neptune.get().getProfileManager().getByUUID(user);
            profile.getGameData().setParty(null);
            profile.setState(ProfileState.LOBBY);
        }
    }

    public void broadcast(MessagesLocale messagesLocale, Replacement... replacements) {
        for (UUID user : users) {
            messagesLocale.send(user, replacements);
        }
    }
}
