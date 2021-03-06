public class OX {
    private String [][] table ={
            {" " ,"0" ,"1" ,"2"} ,
            {"0" ,"-" ,"-" ,"-"} ,
            {"1" ,"-" ,"-" ,"-"} ,
            {"2" ,"-" ,"-" ,"-"} ,
    };
    private String player;
    private int countX;
    private int countO;
    private int countDraw;
    private int turnCount;
    private int scoreX;
    private int scoreO;
    private int scoreDraw;

    public OX() {
        player = "X";
        countX = 0;
        countO = 0;
        countDraw = 0;
        turnCount = 0;
        scoreX = 0;
        scoreO = 0;
        scoreDraw = 0;

    }

    public String getTabeString() {
        String result="";
        for( int row=0; row<table.length;row++){
            for(int col =0; col<table[row].length; col++){
                result =result + table[row][col];
            }
            result = result + "\n";
        }
        return  result;
    }

    public String getCurrentPlayer() {
        return player;
    }

    public int getCountX() {
        return countX;
    }

    public int getCountO() {
        return countO;
    }

    public int getCountDraw() {
        return countDraw;
    }

    public boolean put(int col, int row) {
        try {
            if (!table[row + 1][col + 1].equals("-")) {
                return false;
            }

            table[row + 1][col + 1] = getCurrentPlayer();
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
        turnCount++;
        if(checkWin(col,row)){
            if(player.equals("X")){
                scoreX++;
            }else if(player.equals("O")){
                scoreO++;
            }
        }

        if(isDraw()){
            scoreDraw++;
        }
                return true;

        }


    public void SwitchPlayer() {
        if(player=="X"){
            player = "O";
        }
        else {
            player = "X";
        }
    }

    public boolean checkWin(int col, int row) {
        boolean checkWinCol = true;
        boolean checkWinRow = true;
        /*
        /check Col
         */
            for (int i= 0;i < 3; i++) {
                if (!table[i + 1][col + 1].equals(getCurrentPlayer())) {
                    checkWinCol = false;
                    break;
                }
            }
       if(checkWinCol){
           return true;
       }
            /*
        /check row
         */
        for (int i= 0;i < 3; i++) {
            if (!table[row + 1][i + 1].equals(getCurrentPlayer())) {
                checkWinRow = false;
                break;
            }
        }
        if(checkWinRow){
            return true;
        }

        boolean checkWinES = true;
        for (int i= 0;i < 3; i++) {
            if (!table[i + 1][i + 1].equals(getCurrentPlayer())) {
                checkWinES = false;
                break;
            }
        }
        if(checkWinES){
            return true;
        }
        boolean checkWinSS = true;
        for (int i= 0;i < 3; i++) {
            if (!table[i + 1][3-i].equals(getCurrentPlayer())) {
                checkWinSS = false;
                break;
            }
        }
        if(checkWinSS){
            return true;
        }
         return false;
    }

    public String get(int col, int row) {
        if(col >2 || col <0 || row >2 || row <0){
            return null;
        }
            return table[row + 1][col + 1];

    }

    public void reset() {
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                table[i+1][j+1] = "-";
            }
        }
        player = "X";
        turnCount = 0;
    }

    public int getTurnCount() {
        return turnCount;
    }

    public boolean isDraw() {
        if(turnCount < 9){
            return false;
        }
        return true;
    }

    public int getScoreX() {
        return scoreX;
    }

    public int getScoreO() {
        return scoreO;
    }

    public int getScoreDraw() {
        return scoreDraw;
    }
}
