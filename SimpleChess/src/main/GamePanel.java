package main;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.JPanel;

import piece.*;
public class GamePanel extends JPanel implements Runnable {

    public static final int WIDTH = 1100;
    public static final int HEIGHT = 800;
    final int FPS = 60;
    Thread gameThread;
    Board board = new Board();
    Mouse mouse = new Mouse();

    // pieces
    public static ArrayList<Piece> pieces = new ArrayList<>(); // the real pieces to real game
    public static ArrayList<Piece> simPieces = new ArrayList<>(); // pieces for the simulation
    public static ArrayList<Piece> promoPieces = new ArrayList<>();
    Piece activeP;
    public static Piece castlingP;

    // Colors of the pieces
    public static final int WHITE = 0;
    public static final int BLACK = 1;
    int currentColor = WHITE;

    boolean canMove;
    boolean validSquare;
    boolean promotion;

    public GamePanel() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.black);
        addMouseMotionListener(mouse);
        addMouseListener(mouse);

        setPieces();
        copyPieces(pieces, simPieces);
    }

    public void launchGame() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void setPieces() {
        // whites
        for (int i=0; i<8; i++) {
            pieces.add(new Pawn(WHITE, i, 6));
        }
        pieces.add(new Rook(WHITE, 0, 7));
        pieces.add(new Rook(WHITE, 7, 7));
        pieces.add(new Knight(WHITE, 1, 7));
        pieces.add(new Knight(WHITE, 6, 7));
        pieces.add(new Bishop(WHITE, 2, 7));
        pieces.add(new Bishop(WHITE, 5, 7));
        pieces.add(new Queen(WHITE, 3, 7));
        pieces.add(new King(WHITE, 4, 7));

        // blacks
        for (int i=0; i<8; i++) {
            pieces.add(new Pawn(BLACK, i, 1));
        }
        pieces.add(new Rook(BLACK, 0, 0));
        pieces.add(new Rook(BLACK, 7, 0));
        pieces.add(new Knight(BLACK, 1, 0));
        pieces.add(new Knight(BLACK, 6, 0));
        pieces.add(new Bishop(BLACK, 2, 0));
        pieces.add(new Bishop(BLACK, 5, 0));
        pieces.add(new Queen(BLACK, 3, 0));
        pieces.add(new King(BLACK, 4, 0));
    }

    private void copyPieces(ArrayList<Piece> source, ArrayList<Piece> target) {
        target.clear();
        target.addAll(source);
    }

    @Override
    public void run() {
        double drawInterval = 1_000_000_000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while(gameThread != null) {
            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;

            if (delta >= 1) {
                update();
                repaint();
                delta--;
            }
        }
    }

    private void update() {
        if (promotion) {
            promote();
        } else {
            if (mouse.pressed) {
                if (activeP == null) {
                    for (Piece piece : simPieces) {
                        if (piece.color == currentColor && piece.col == mouse.x / Board.SQUARE_SIZE && piece.row == mouse.y / Board.SQUARE_SIZE) {
                            activeP = piece;
                        }
                    }
                } else {
                    simulate();
                }
            }

            if (!mouse.pressed) {
                if (activeP != null) {
                    if (validSquare) {
                        copyPieces(simPieces, pieces);
                        activeP.updatePosition();

                        if (castlingP != null) {
                            castlingP.updatePosition();
                        }

                        if (canPromote()) {
                            promotion = true;
                        } else {
                            changePlayer();
                        }
                    } else {
                        copyPieces(pieces, simPieces);
                        activeP.resetPosition();
                    }
                    activeP = null;
                }
            }
        }
    }

    private void simulate() {
        canMove = false;
        validSquare = false;

        copyPieces(pieces, simPieces);

        if (castlingP != null) {
            castlingP.col = castlingP.preCol;
            castlingP.x = castlingP.getX(castlingP.col);
            castlingP = null;
        }

        activeP.x = mouse.x - Board.HALF_SQUARE_SIZE;
        activeP.y = mouse.y - Board.HALF_SQUARE_SIZE;
        activeP.col = activeP.getCol(activeP.x);
        activeP.row = activeP.getRow(activeP.y);

        if (activeP.canMove(activeP.col, activeP.row)) {
            canMove = true;

            if (activeP.hittingP != null) {
                simPieces.remove(activeP.hittingP.getIndex());
            }

            checkCastling();

            if (!isIllegal(activeP)) {
                validSquare = true;
            }
        }
    }

    private boolean isIllegal(Piece king) {
        if (king.type == Type.KING) {
            for (Piece piece : simPieces) {
                if (piece != king && piece.color != king.color && piece.canMove(king.col, king.row)) {
                    return true;
                }
            }
        }
        return false;
    }

    private void checkCastling() {
        if (castlingP != null) {
            if (castlingP.col == 0) {
                castlingP.col += 3;
            } else if (castlingP.col == 7) {
                castlingP.col -= 2;
            }
            castlingP.x = castlingP.getX(castlingP.col);
        }
    }

    public void changePlayer() {
        if (currentColor == WHITE) {
            currentColor = BLACK;
            for (Piece piece : pieces) {
                if (piece.color == BLACK) {
                    piece.twoStepped = false;
                }
            }
        } else {
            currentColor = WHITE;
            for (Piece piece : pieces) {
                if (piece.color == WHITE) {
                    piece.twoStepped = false;
                }
            }
        }
    }

    public boolean canPromote() {
        if (activeP.type == Type.PAWN) {
            if ((currentColor == WHITE && activeP.row == 0) || (currentColor == BLACK && activeP.row == 7)) {
                promoPieces.clear();
                promoPieces.add(new Rook(currentColor, 9, 2));
                promoPieces.add(new Knight(currentColor, 9, 3));
                promoPieces.add(new Bishop(currentColor, 9, 4));
                promoPieces.add(new Queen(currentColor, 9, 5));
                return true;
            }
        }

        return false;
    }

    public void promote() {
        if (mouse.pressed) {
            for (Piece piece : promoPieces) {
                if (piece.col == mouse.x/Board.SQUARE_SIZE && piece.row == mouse.y/Board.SQUARE_SIZE) {
                    switch (piece.type) {
                        case ROOK: simPieces.add(new Rook(currentColor, activeP.col, activeP.row)); break;
                        case KNIGHT: simPieces.add(new Knight(currentColor, activeP.col, activeP.row)); break;
                        case BISHOP: simPieces.add(new Bishop(currentColor, activeP.col, activeP.row)); break;
                        case QUEEN: simPieces.add(new Queen(currentColor, activeP.col, activeP.row)); break;
                        default: break;
                    }
                    simPieces.remove(activeP.getIndex());
                    copyPieces(simPieces, pieces);
                    activeP = null;
                    promotion = false;
                    changePlayer();
                }
            }
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;

        // board
        board.draw(g2);

        // pieces
        for (Piece p : simPieces) {
            p.draw(g2);
        }

        if (activeP != null ) {
            if (canMove) {
                g2.setColor(Color.white);
                g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.7f));
                g2.fillRect(activeP.col*Board.SQUARE_SIZE, activeP.row*Board.SQUARE_SIZE, Board.SQUARE_SIZE, Board.SQUARE_SIZE);
                g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
            }
            activeP.draw(g2);
        }

        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2.setFont(new Font("Book Antiqua", Font.PLAIN, 40));
        g2.setColor(Color.white);

        if (promotion) {
            g2.drawString("Promote to: ", 840, 150);
            for (Piece piece : promoPieces) {
                g2.drawImage(piece.image, piece.getX(piece.col), piece.getY(piece.row), Board.SQUARE_SIZE, Board.SQUARE_SIZE, null);
            }
        } else {
            if (currentColor == WHITE) {
                g2.drawString("White's turn!", 840, 550);
            } else {
                g2.drawString("Black's turn!", 840, 250);
            }
        }
    }
}
