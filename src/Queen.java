public class Queen extends ChessPiece{
    public Queen(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
    /* этот алгоритм аналогичен проверке ладьи и слона*/
        if ((new Bishop(color).canMoveToPosition(chessBoard, line, column, toLine, toColumn)) ||
                new Rook(color).canMoveToPosition(chessBoard, line, column, toLine, toColumn)) return true;

        return false;
    }

    @Override
    public String getSymbol() {
        return "Q";
    }
}
