import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.swing.*;


public class PE5 extends JFrame{
    private JTextField jtf = new JTextField();
    private Histogram histogram = new Histogram();
    private JFrame histogramFrame = new JFrame();


    public PE5 (){
        add(jtf.BorderLayout.SOUTH);
        jtf.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                int[] count = CountLetters();
                histogram.showHistogram(count);
                histogramFrame.setVisible(true);
            }
        });

        histogramFrame.add(histogram);
        histogramFrame.pack();
        histogramFrame.setTitle("HistoGram");

    }

    public int[] countLetter()
    {
        int[] count = new int[26];
        String file = jtf.getText().trim();
        try{
            BufferedInputStream in = new BufferedInputStream(new FileInputStream(file));
            byte[] b = new byte[in.available()];
            in.read(b,0,b.length);
            String s = new String(b, 0, b.length);
            String text = s;
            in.close();

            for(int i=0; i < text.length(); i++){
                char character = text.charAt(i);
                if((character >= 'A') && (character <= 'Z')){
                    count[character - 'A']++;
                }
                else if((character >= 'a') && (character <= 'z')){
                    count[character - 'a']++;
                }
            }
        }

        catch(IOException ex){
            System.out.println(ex);
        }
        return count;
    }

    public static void main(String[] args){
        PE5 frame = new PE5();
        frame.setTitle("Question 4");
        frame.setSize(500,250);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}