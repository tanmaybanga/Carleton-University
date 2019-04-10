/**
 * Created by Imran Juma on 2017-03-06.
 */


public class SliderPuzzleGame {
    private static final int  NUM_BOARDS = 5;
    private static final byte WAITING_TO_START = 0;
    private static final byte BOARD_IN_PROGRESS = 1;
    private static final byte BOARD_JUST_COMPLETED = 2;

    private GameBoard[]     boards;
    private int             boardNumber;
    private int             numMovesMade;
    private byte            gameMode;

    public SliderPuzzleGame() {
        resetBoards();
    }

    public GameBoard getCurrentBoard() { return boards[boardNumber]; }
    public int getNumberOfMovesMade() { return numMovesMade; }

    public boolean isBoardInProgress() { return gameMode == BOARD_IN_PROGRESS; }
    public boolean areWeWaitingToStartABoard() { return gameMode == WAITING_TO_START; }

    // Set up the boards to the 5 example boards
    private void resetBoards() {
        boards = new GameBoard[NUM_BOARDS + 1];
        boards[0] = new GameBoard(0);
        boards[1] = GameBoard.board1();
        boards[2] = GameBoard.board2();
        boards[3] = GameBoard.board3();
        boards[4] = GameBoard.board4();
        boards[5] = GameBoard.board5();
        boardNumber = 1;
        gameMode = WAITING_TO_START;
        numMovesMade = 0;
    }

    // Record that a move was made
    public void makeAMove() {
        numMovesMade++;
    }

    // Allow the user to start playing the current board
    public void startBoard() {
        gameMode = BOARD_IN_PROGRESS;
    }

    // Simulate the completion of the current board
    public void completeBoard() {
        gameMode = BOARD_JUST_COMPLETED;
    }

    // Go to the next board in the game
    public void moveToNextBoard() {
        boardNumber++;
        gameMode = WAITING_TO_START;
        numMovesMade = 0;

        // Reset all the boards if we completed them all
        if (boardNumber > NUM_BOARDS)
            resetBoards();
    }
}
