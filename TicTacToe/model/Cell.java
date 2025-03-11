package TicTacToe.model;

public class Cell {
	private MarkType mark;

    public Cell() {
        this.mark = MarkType.E;
    }

    public boolean isEmpty() {
        return mark == MarkType.E;
    }

    public MarkType getMark() {
        return mark;
    }

    public void setMark(MarkType mark) throws Exception {
        if (!isEmpty()) {
            throw new Exception("Cell is already marked!");
        }
        this.mark = mark;
    }

}
