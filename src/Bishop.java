public class Bishop extends ChessPiece{

    public Bishop(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {

        if(!chessBoard.checkPos(toLine) || !chessBoard.checkPos(toColumn)) return false;
        if (line == toLine && column == toColumn) return false;
        if (chessBoard.board[toLine][toColumn] != null && chessBoard.board[toLine][toColumn].getColor().equals(color)) return false;

        if (Math.abs(line-toLine) == Math.abs(column-toColumn)) {
            int l = line;
            int c = column;
            while(l != toLine && c != toColumn){
                l = line < toLine ? l+1 : l-1;
                c = column < toColumn ? c+1: c-1;
                if (chessBoard.board[l][c] != null) return false;
            }
            return true;
        }
        return false;
    }


    @Override
    public String getSymbol() {
        return "B";
    }
}
