package zad_07_08_applets_calc;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Sumator extends JApplet implements ActionListener
{
    private JTextField[] liczby;
    private JTextField wynik;
    //------------------------
    public void init()
    {
        setLayout(new GridLayout(9,3)); //manager rozkladu
        JLabel l = null;
        liczby = new JTextField[7];
        for (int i=0;i<9;i++)
        {
            l = new JLabel();
            add(l);
            switch (i)
            {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                 liczby[i] = new JTextField(12);
                 liczby[i].addActionListener(this);
                 add(liczby[i]);
                 break;
                case 7:
                 JButton b = new JButton("=");
                 b.addActionListener(this);
                 add(b);
                 break;
                case 8:
                 wynik = new JTextField(12);
                 add(wynik);
                 break;
            }
            l = new JLabel();
            add(l);
        }
    }
    //------------------------
    public void actionPerformed(ActionEvent e)
    {
        long suma = 0;
        String s;
        for (int i=0;i<7;i++)
        {
            try
            {
                s = liczby[i].getText().trim();
                if (!s.equals(""))
                {
                    suma+=Integer.parseInt(s);
                }
            }
            catch (Exception ex)
            {
                JOptionPane.showMessageDialog(this,"Niew�a�ciwy format lub przekroczony dopuszczalny zakres: \n"+
                        Integer.MIN_VALUE+"  -  "+Integer.MAX_VALUE,"",JOptionPane.INFORMATION_MESSAGE);
                liczby[i].requestFocus();
                break;
            }
        }
        wynik.setText(""+suma);
    }
}
