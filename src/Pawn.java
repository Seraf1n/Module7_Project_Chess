public class Pawn extends ChessPiece{

    public Pawn(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {

        if(!chessBoard.checkPos(toLine) || !chessBoard.checkPos(toColumn) ) return false;
        if (line == toLine && column == toColumn) return false;

        boolean isFirstMove;
        if(color.equals("White")){
            isFirstMove = line == 1;
            if (isFirstMove && (toLine == 2 || toLine == 3) && column == toColumn) return true;
            if(!isFirstMove && toLine-line == 1 && column == toColumn ) return true;
            if (toLine-line == 1 && Math.abs(column - toColumn) == 1 && chessBoard.board[toLine][toColumn] != null
                    && chessBoard.board[toLine][toColumn].getColor().equals("Black")) return true;
        }
        if(color.equals("Black")){
            isFirstMove = line == 6;
            if (isFirstMove && (toLine == 5 || toLine == 4) && column == toColumn ) return true;
            if (!isFirstMove && line-toLine == 1 && column == toColumn ) return true;
            if (line-toLine == 1 && Math.abs(column - toColumn) == 1 && chessBoard.board[toLine][toColumn] != null
                    && chessBoard.board[toLine][toColumn].getColor().equals("White")) return true;
        }

        return false;
    }

    @Override
    public String getSymbol() {
        return "P";
    }
}
