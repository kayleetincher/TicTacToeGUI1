import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class TicTacToeFrame extends JFrame implements ActionListener
{


    JPanel mainPnl, displayPnl, controlPnl, boardPnl;
    JTextArea displayTA;
    JScrollPane scroller;

    JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, quit, score, playAgain;
    String letter = "";
    int count = 0;
    int XWins, OWins, Tie = 0;
    private boolean win = false;

    public TicTacToeFrame()
    {
        mainPnl = new JPanel();
        mainPnl.setLayout(new BorderLayout());

        createDisplayPanel();

        createControlPanel();
        mainPnl.add(controlPnl, BorderLayout.SOUTH);

        createBoardPanel();
        mainPnl.add(boardPnl, BorderLayout.CENTER);

        add(mainPnl);

        setSize(400, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Tic Tac Toe");
        setVisible(true);
    }


    private void createDisplayPanel() {

    }
    private void createControlPanel()
    {
        controlPnl = new JPanel();
        quit = new JButton("Quit");
        quit.addActionListener((ActionEvent ae) -> {
            int reply = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Exiting Tic Tac Toe", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION)
            {
                System.exit(0);
            }
        });
        controlPnl.add(quit);

        score = new JButton("Score!");
        score.addActionListener((ActionEvent ae) -> {
            JOptionPane.showMessageDialog(null, "Player X's number of Wins" + " " + XWins + " \nPlayer O's number of Wins" + " " + OWins + "\nTies" + " " + Tie);
        });
        controlPnl.add(score);

        playAgain = new JButton("Play Again?");
        playAgain.addActionListener((ActionEvent ae) -> {
            int reply = JOptionPane.showConfirmDialog(null, "Do you want to play again?", "Clearing Board", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION)
            {
                b1.setText("");
                b1.setEnabled(true);
                b2.setText("");
                b2.setEnabled(true);
                b3.setText("");
                b3.setEnabled(true);
                b4.setText("");
                b4.setEnabled(true);
                b5.setText("");
                b5.setEnabled(true);
                b6.setText("");
                b6.setEnabled(true);
                b7.setText("");
                b7.setEnabled(true);
                b8.setText("");
                b8.setEnabled(true);
                b9.setText("");
                b9.setEnabled(true);
                win = false;
                count = 0;
            }
        });
        controlPnl.add(playAgain);


    }
        private void createBoardPanel()
        {
            boardPnl = new JPanel();
            boardPnl.setLayout(new GridLayout(3,3));

            b1 = new JButton("");
            b2 = new JButton("");
            b3 = new JButton("");
            b4 = new JButton("");
            b5 = new JButton("");
            b6 = new JButton("");
            b7 = new JButton("");
            b8 = new JButton("");
            b9 = new JButton("");

        boardPnl.add(b1);
        boardPnl.add(b2);
        boardPnl.add(b3);
        boardPnl.add(b4);
        boardPnl.add(b5);
        boardPnl.add(b6);
        boardPnl.add(b7);
        boardPnl.add(b8);
        boardPnl.add(b9);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);

    }


    @Override
    public void actionPerformed(ActionEvent z) {
        count++;
        if (count == 1 || count == 3 || count == 5 || count == 7 || count == 9)
        {
            letter = "X";
        }
        else if (count == 2 || count == 4 || count == 6 || count == 8 || count == 10)
        {
            letter = "O";
        }

        if (z.getSource() == b1)
        {
            b1.setText(letter);
            b1.setEnabled(false);
            CheckForWin();
        }
        else if (z.getSource() == b2)
        {
            b2.setText(letter);
            b2.setEnabled(false);
            CheckForWin();
        }
        else if (z.getSource() == b3)
        {
            b3.setText(letter);
            b3.setEnabled(false);
            CheckForWin();
        }
        else if (z.getSource() == b4)
        {
            b4.setText(letter);
            b4.setEnabled(false);
            CheckForWin();
        }
        else if (z.getSource() == b5)
        {
            b5.setText(letter);
            b5.setEnabled(false);
            CheckForWin();
        }
        else if (z.getSource() == b6)
        {
            b6.setText(letter);
            b6.setEnabled(false);
            CheckForWin();
        }
        else if (z.getSource() == b7)
        {
            b7.setText(letter);
            b7.setEnabled(false);
            CheckForWin();
        }
        else if (z.getSource() == b8)
        {
            b8.setText(letter);
            b8.setEnabled(false);
            CheckForWin();
        }
        else if (z.getSource() == b9)
        {
            b9.setText(letter);
            b9.setEnabled(false);
            CheckForWin();
        }

    }
    public void CheckForWin()
    {

        if (b1.getText() == b2.getText() && b2.getText() == b3.getText() && b1.getText() != "")
        {
            win = true;
            Win();
        }
        else if (b4.getText() == b5.getText() && b5.getText() == b6.getText() && b4.getText() != "")
        {
            win = true;
            Win();
        }
        else if (b7.getText() == b8.getText() && b8.getText() == b9.getText() && b7.getText() != "")
        {
            win = true;
            Win();
        }

        else if (b1.getText() == b4.getText() && b4.getText() == b7.getText() && b1.getText() != "")
        {
            win = true;
            Win();
        }
        else if (b2.getText() == b5.getText() && b5.getText() == b8.getText() && b2.getText() != "")
        {
            win = true;
            Win();
        }
        else if (b3.getText() == b6.getText() && b6.getText() == b9.getText() && b3.getText() != "")
        {
            win = true;
            Win();
        }

        else if (b1.getText() == b5.getText() && b5.getText() == b9.getText() && b1.getText() != "")
        {
            win = true;
            Win();
        }
        else if (b3.getText() == b5.getText() && b5.getText() == b7.getText() && b3.getText() != "")
        {
            win = true;
            Win();
        }
        else
        {
            win = false;
            Win();
        }
    }

    public void Win()
    {
        if (win == true)
        {
            JOptionPane.showMessageDialog(null, "Player " + letter + " Won!");
            if(letter.equalsIgnoreCase("X"))
            {
                XWins++;
            }
            else
            {
                OWins++;
            }
        }
        else if (count == 9 && win == false)
        {
            JOptionPane.showMessageDialog(null, "It's a Tie!");
            Tie++;
        }
    }

    }

