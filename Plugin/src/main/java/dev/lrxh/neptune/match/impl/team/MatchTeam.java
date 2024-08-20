package dev.lrxh.neptune.match.impl.team;


import dev.lrxh.neptune.configs.impl.MessagesLocale;
import dev.lrxh.neptune.match.impl.participant.Participant;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class MatchTeam {
    private final List<Participant> participants;
    private final List<Participant> deadParticipants;
    private boolean loser;

    public MatchTeam(List<Participant> participants) {
        this.participants = participants;
        this.deadParticipants = new ArrayList<>();
        this.loser = false;
    }

    public boolean isLoser() {
        return deadParticipants.size() >= participants.size();
    }

    public int getAliveParticipants() {
        return participants.size() - deadParticipants.size();
    }

    public void sendTitle(String header, String footer, int duration) {
        for (Participant participant : participants) {
            participant.sendTitle(header, footer, duration);
        }
    }

    public String getTeamNames() {
        StringBuilder playerNames = new StringBuilder();
        for (Participant participant : participants) {
            if (!playerNames.isEmpty()) {
                playerNames.append(MessagesLocale.MATCH_COMMA.getString());
            }
            playerNames.append(participant.getNameUnColored());
        }
        return playerNames.toString();
    }

}
