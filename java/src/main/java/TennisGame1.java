
public class TennisGame1 implements TennisGame {

    private int m_score1 = 0;
    private int m_score2 = 0;
    private String player1Name;
    private String player2Name;
    private int countDuece = 0;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1")
            m_score1 += 1;
        else
            m_score2 += 1;
    }

    public String getScore() {
        String score = "";
        int tempScore = 0;
        int minusResult = m_score1 - m_score2;
        if (m_score1 == 0 && m_score2 == 0) {
            return "Love-All";
        } else if (isDuece()) {
            score = "Deuce";
        } else if (isAdvantage()) {
            if (minusResult == 1) {
                score = "Advantage " + this.player1Name;
            } else if (minusResult == -1) {
                score = "Advantage " + this.player2Name;
            }
        } else if (isWinner()) {
            if (minusResult >= 2) {
                score = "Win for " + this.player1Name;
            } else {
                score = "Win for " + this.player2Name;
            }
        } else if (normal()) {
            if (m_score1 == m_score2) {
                switch (m_score1) {
                    case 1:
                        score = "Fifteen-All";
                        break;
                    case 2:
                        score = "Thirty-All";
                        break;
                }
            } else {
                for (int i = 1; i < 3; i++) {
                    if (i == 1) tempScore = m_score1;
                    else {
                        score += "-";
                        tempScore = m_score2;
                    }
                    switch (tempScore) {
                        case 0:
                            score += "Love";
                            break;
                        case 1:
                            score += "Fifteen";
                            break;
                        case 2:
                            score += "Thirty";
                            break;
                        case 3:
                            score += "Forty";
                            break;
                    }
                }
            }
        }
        return score;
    }

    public boolean isDuece() {
        if (m_score1 == m_score2 && m_score1 >= 3 && m_score2 >= 3) {
            countDuece++;
            return true;
        }
        return false;
    }

    public boolean isAdvantage() {
        if (m_score1 >= 4 || m_score2 >= 4) {
            int minusResult = m_score1 - m_score2;
            if (minusResult == 1 || minusResult == -1) {
                return true;
            }
        }
        return false;
    }

    public boolean isWinner() {
        int minusResult = m_score1 - m_score2;
        if (m_score1 >= 4 || m_score2 >= 4 && ((minusResult >= 2) || (minusResult <= -2))) {
            return true;
        }
        return false;
    }

    public boolean normal() {
        if (countDuece <= 0) {
            return true;
        }
        return false;
    }
}
