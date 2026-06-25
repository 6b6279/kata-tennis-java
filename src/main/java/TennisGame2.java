
public class TennisGame2 implements TennisGame {
    public int P1point = 0;
    public int P2point = 0;

    public String P1res = "";
    public String P2res = "";
    private String player1Name;
    private String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    private String evaluateIntermittentDraw(int p1Score, int p2Score) {
        if (p1Score == p2Score) {
            if (p1Score < 3) {
                return inWords(p1Score) + "-All";
            } else {
                return "Deuce";
            }
        }

        return "";
    }

    private String evaluateIntermittentNonDraw(int p1Score, int p2Score) {
        if ((p1Score < 4 && p2Score < 4) && p1Score != p2Score) {
            return inWords(p1Score) + "-" + inWords(p2Score);
        }

        return "";
    }

    private String evaluateAdvantage(int p1Score, int p2Score) {
        if (p1Score >= 3 && p2Score >= 3) {
            if (p1Score == p2Score + 1) {
                return "Advantage " + player1Name;
            } else if (p2Score == p1Score + 1) {
                return "Advantage " + player2Name;
            }
        }

        return "";
    }

    private String evaluateWin(int p1Score, int p2Score) {
        if (p1Score >= 4 || p2Score >= 4) {
            if (p1Score >= p2Score + 2) {
                return "Win for " + player1Name;
            } else if (p2Score >= p1Score + 2) {
                return "Win for " + player2Name;
            }
        }

        return "";
    }

    public String getScore() {
        String score = "";

        score += evaluateWin(P1point, P2point);
        score += evaluateIntermittentDraw(P1point, P2point);
        score += evaluateIntermittentNonDraw(P1point, P2point);
        score += evaluateAdvantage(P1point, P2point);

        return score;
    }

    private String inWords(int points) {
        return switch (points) {
            case 0 -> "Love";
            case 1 -> "Fifteen";
            case 2 -> "Thirty";
            case 3 -> "Forty";
            default -> throw new IllegalArgumentException("Nonesuch legal score");
        };
    }

    public void SetP1Score(int number) {

        for (int i = 0; i < number; i++) {
            P1Score();
        }

    }

    public void SetP2Score(int number) {

        for (int i = 0; i < number; i++) {
            P2Score();
        }

    }

    public void P1Score() {
        P1point++;
    }

    public void P2Score() {
        P2point++;
    }

    public void wonPoint(String player) {
        if (player == "player1")
            P1Score();
        else
            P2Score();
    }
}