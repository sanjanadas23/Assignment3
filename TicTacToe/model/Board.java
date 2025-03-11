package TicTacToe.model;

public class Board {
	private Cell[] cells = new Cell[9];

    public Board() {
        for (int i = 0; i < 9; i++) {
            cells[i] = new Cell();
        }
    }

    public boolean isBoardFull() {
        for (Cell cell : cells) {
            if (cell.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public void setCellMark(int loc, MarkType mark) throws Exception {
        if (loc < 0 || loc >= 9) {
            throw new Exception("Invalid location!");
        }
        cells[loc].setMark(mark);
    }

    public MarkType getCellMark(int loc) {
        return cells[loc].getMark();
    }

    public void displayBoard() {
        for (int i = 0; i < 9; i++) {
            System.out.print(cells[i].getMark() + " ");
            if ((i + 1) % 3 == 0) System.out.println(); //printing new line to move to the next row after every third cell
        }
    }

}
