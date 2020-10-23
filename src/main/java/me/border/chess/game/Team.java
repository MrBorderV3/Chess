package me.border.chess.game;

public enum Team {
    BLACK, WHITE;

    /**
     * Revert the given the team
     *
     * @param team The team to revert
     * @return The reverted team
     */
    public Team revert(Team team){
        return team == BLACK ? WHITE : BLACK;
    }
}
