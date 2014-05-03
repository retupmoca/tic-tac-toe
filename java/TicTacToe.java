import java.io.*;

public class TicTacToe
{
    public static void main(String[] argv)
    {
        // create board and player objects
        Board board = new Board();
        Player players[] = new Player[2];
        players[0] = new Player("X");
        players[1] = new Player("O");

        // draw
        board.draw();

        // main loop
        int alt = 0;
        while (true) {
            // player alternator
            if (alt==0) {
                alt=1;
            } else if (alt == 1) {
                alt=0;
            }

            // take a turn, draw the board
            players[alt].takeTurn(board);
            board.draw();

            // win detection
            if (board.check_status(players[alt].getIdString())) {
                System.out.println("Player "+players[alt].getIdString()+" wins!");
                break;
            }
        }
    }
}

class Player
{
    private InputHandler input = new InputHandler();
    private String idString;

    public Player(String idString) {
        this.idString = idString;
    }

    public String getIdString() {
        return this.idString;
    }

    public void takeTurn(Board board) {
        System.out.print("Player "+idString+":");
        int in = Integer.parseInt(input.string_input());
        board.add_entry(idString,in-1);
    }
}

class Board
{
    private String v[] = {" "," "," "," "," "," "," "," "," "};

    public int draw()
    {
        System.out.println("\033[2J\n"); // clear screen

        String[] line = {
            "_____________",
            "|1  |2  |3  |",
            "| "+v[0]+" | "+v[1]+" | "+v[2]+" |",
            "|___|___|___|",
            "|4  |5  |6  |",
            "| "+v[3]+" | "+v[4]+" | "+v[5]+" |",
            "|___|___|___|",
            "|7  |8  |9  |",
            "| "+v[6]+" | "+v[7]+" | "+v[8]+" |",
            "|___|___|___|"

        };

        for (String entry : line) {
            System.out.println(entry);
        }
        return 1;
    }

    public boolean check_status(String player) {
        boolean result = false;

        // check columns
        int column = 1;
        while (column <= 3) {
            if (v[column-1] == player &&
                v[column+2] == player &&
                v[column+5] == player) {

                result = true;
            }
            column +=1;
        }

        // check rows
        int increment[] = {0,1,2};
        while (increment[2] <= 8) {
            if (v[increment[0]] == player &&
                v[increment[1]] == player &&
                v[increment[2]] == player) {

                result = true;
            }

            for (int i = 0; i<=2; i++) {
                increment[i] += 3;
            }
        }

        // check diagnals
        if (v[0]==player && v[4]==player && v[8]==player) {result = true;}
        if (v[2]==player && v[4]==player && v[6]==player) {result = true;}

        return result;
    }

    public void add_entry(String letter, int location) {
        if (v[location].equals(" ")) {
            v[location] = letter;
        }
    }
}

class InputHandler {
    public String string_input() {
        String userInput;
        userInput = new String();

        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            userInput = in.readLine();
        }catch(IOException e){} // TODO

        return userInput;
    }
}
