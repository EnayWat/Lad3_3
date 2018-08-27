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

    public OX() {
        player = "X";
        countX = 0;
        countO = 0;
        countDraw = 0;

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
        if (row > 2 || col > 2) {
            return false;
        } else {
            if (!table[row + 1][col + 1].equals("-")) {
                return false;
            }
            else {
                table[row + 1][col + 1] = getCurrentPlayer();
                return true;
            }
        }
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

            for (int i= 0;i < 3; i++) {
                if (!table[i + 1][col + 1].equals(getCurrentPlayer())) {
                    return false;
                }
            }
        return true;

    }
}
