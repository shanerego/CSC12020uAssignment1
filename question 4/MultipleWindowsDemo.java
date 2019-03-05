import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.swing.*;


public class MultipleWindowsDemo extends JFrame{
    private JTextArea jta;
    private Histogram histogram = new Histogram();
    private JButton jbtShowHistogram = new JButton("Show Histogram");
    private JFrame histogramFrame = new JFrame();


    public MultipleWindowsDemo (){
        JScrollPane scrollPane = new JScrollPane(jta = new JTextArea());
        scrollPane.setPreferredSize(new Dimension(300, 200));
        jta.setWrapStyleWorld(true);
        jta.setLineWrap(true);

        add(scrollPane, BorderLayout.CENTER)l;
        add(jbtShowHistogram, BorderLayout.SOUTH);
        
        jbtShowHistogram.addActionListener(new ActionListener(){
            @Override
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
        String text = jta.getText();


            for(int i=0; i < text.length(); i++){
                char character = text.charAt(i);
                if((character >= 'A') && (character <= 'Z')){
                    count[character - 'A']++;
                }
                else if((character >= 'a') && (character <= 'z')){
                    count[character - 'a']++;
                }
            }

        return count;
    }

    public static void main(String[] args){
        MultipleWindowsDemo frame = new MultipleWindowsDemo();
        frame.setTitle("Question 4");
        frame.setSize(500,250);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}