public class Rook extends ChessPiece{
    public Rook(String color) {
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
        if (chessBoard.board[toLine][toColumn] != null
                && chessBoard.board[toLine][toColumn].getColor().equals(color)) return false;

        if(line == toLine && column != toColumn){
            for (int i = column; i == toColumn;){
               if (column<toColumn) {
                   if(chessBoard.board[line][++i] != null) return false;
               }
                if (column>toColumn) {
                    if(chessBoard.board[line][--i] != null) return false;
                }
            }
            return true;
        }

        if(line != toLine && column == toColumn){
            for (int i = column; i == toColumn;){
                if (line<toLine) {
                    if(chessBoard.board[++i][column] != null) return false;
                }
                if (line>toLine) {
                    if(chessBoard.board[--i][column] != null) return false;
                }
            }
            return true;
        }

        return false;
    }



    @Override
    public String getSymbol() {
        return "R";
    }
}
