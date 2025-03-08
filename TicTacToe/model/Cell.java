package TicTacToe.model;

public class Cell {
	private MarkType mark;

    public Cell() {
        this.mark = MarkType.E;
    }

    public MarkType getMark() {
        return mark;
    }

    public void setMark(MarkType mark) throws Exception {
        if (this.mark != MarkType.E) {
            throw new Exception("Cell is already occupied!");
        }
        this.mark = mark;
    }

}
