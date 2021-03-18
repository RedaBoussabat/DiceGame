package model;

public class Player {

    private int playerNr, turn, playerScore, d1, d2, turnScore;

    public Player(int playerNr) {
        this.playerNr = playerNr;
        this.turn = 0;
    }

    // Player throws dice and both turnScore and totalScore will be calculated
    public void calculateScore() {
        // throw the dices
        this.d1 = Dobbelsteen.dobbel();
        this.d2 = Dobbelsteen.dobbel();

        // calculate score of the turn without conditions
        int score = d1 + d2;

        // with conditions
        if (d1 == d2) {
            score *= 2;
        }

        if (this.turnScore == score) {
            playerScore += 5;
        }

        this.turnScore = score;

        // The turn which the player was and his total score are updated
        this.turn += 1;
        this.playerScore += this.turnScore;
    }


    // Print the last turn of this player
    public String printLastTurn() {
        return "Turn " + this.turn + ", Player " + this.playerNr + " threw " + this.d1 + " & " + this.d2 + " - " + this.turnScore + " points";
    }

    // Getters

    public int getPlayerNr() {
        return playerNr;
    }

    public int getTurn() {
        return turn;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public int getD1() {
        return d1;
    }

    public int getD2() {
        return d2;
    }

    public int getTurnScore() {
        return turnScore;
    }
}
