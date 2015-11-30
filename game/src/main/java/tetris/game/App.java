package tetris.game;

/**
 * naomijub 
 * 
 */

import java.awt.*;

import javax.swing.*;

public class App {
	
    JLabel label;
    JFrame frame;
    
    public App(){
    	
    	frame = new JFrame();
    	label = new JLabel(" 0");
    	label.setSize(220, 440);
    	label.setOpaque(false);
    	label.setBackground(Color.BLACK);
    	frame.add(label, BorderLayout.SOUTH);
    	Board board = new Board(this);
    	frame.getContentPane().setBackground(Color.WHITE);
    	frame.add(board);
    	board.start();
    	frame.setSize(221, 441);
    	frame.setTitle("Tetris Power");
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	
    }
    
    public JLabel getStatusBar(){
    	return label;
    }
	
    public JFrame getFrame(){
    	return frame;
    }

	public static void main( String[] args )
    {
        App gameApp = new App();
        gameApp.getFrame().setLocationRelativeTo(null);
        gameApp.getFrame().setVisible(true);
    }
}
