public class King extends ChessPiece{
    public King(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {

        if (!chessBoard.checkPos(toLine) || !chessBoard.checkPos(toColumn)) return false;
        if (line==toLine && column==toColumn) return false;
        if (chessBoard.board[toLine][toColumn] != null && chessBoard.board[toLine][toColumn].getColor().equals(color)) return false;

        if (isUnderAttack(chessBoard, toLine, toColumn)) return false;
        if (Math.abs(line-toLine) > 1 || Math.abs(column-toColumn) > 1) return false;

        return true;
    }

    @Override
    public String getSymbol() {
        return "K";
    }

    public boolean isUnderAttack(ChessBoard board, int line, int column){
        boolean result = false;
        for (int l = 0; l < 8; l++){
            for(int c = 0; c < 8; c++){
                ChessPiece chessPiece = board.board[l][c];
                if(chessPiece != null && !chessPiece.getColor().equals(this.color)){

                    if (chessPiece.getSymbol() == "P" && l+1 == line && c+1==column){
                        result = true;
                        break;
                    }
                    if(chessPiece.canMoveToPosition(board, l, c, line, column)){
                        result = true;
                        break;
                    }
                }
            }
        }

        return result;
    }
}
