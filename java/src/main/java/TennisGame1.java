
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
        if ("player1".equals(playerName))
            m_score1 += 1;
        else
            m_score2 += 1;
    }

    public String getScore() {
        String score = "";
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
            String scoreA = convertScoreToString(m_score1);
            String scoreB = convertScoreToString(m_score2);
            if (m_score1 == m_score2) {
                return scoreA.concat("-All");
            } else {
                return scoreA.concat("-").concat(scoreB);
            }
        }
        return score;
    }

    private boolean isDuece() {
        if (m_score1 == m_score2 && m_score1 >= 3 && m_score2 >= 3) {
            countDuece++;
            return true;
        }
        return false;
    }

    private boolean isAdvantage() {
        if (m_score1 >= 4 || m_score2 >= 4) {
            int minusResult = m_score1 - m_score2;
            if (minusResult == 1 || minusResult == -1) {
                return true;
            }
        }
        return false;
    }

    private boolean isWinner() {
        int minusResult = m_score1 - m_score2;
        return (m_score1 >= 4 || m_score2 >= 4 && ((minusResult >= 2) || (minusResult <= -2)));
    }

    private boolean normal() {
        return (countDuece <= 0);
    }

    private String convertScoreToString(int score) {
        switch (score) {
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            case 3:
                return "Forty";
            default:
                return "";
        }
    }
}
