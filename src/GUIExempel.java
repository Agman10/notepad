import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;

public class GUIExempel {
    private JPanel panel1;
    private JTextArea textArea1;
    private JButton savebutton;
    private JButton openbutton;
    private JButton newbutton;

    public static void main(String[] args) {
        JFrame frame = new JFrame("GUIExempel");
        frame.setContentPane(new GUIExempel().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }

    public GUIExempel() {
        savebutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            JFileChooser fc = new JFileChooser();
                String path = fc.getSelectedFile().getAbsolutePath();

                try{

                    PrintWriter writer = new PrintWriter
                                    (new BufferedWriter
                                    (new OutputStreamWriter
                                    (new FileOutputStream(path), "UTF-8")));
                    writer.println(textArea1.getText());
                    writer .close();
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                } catch (UnsupportedEncodingException e1) {
                    e1.printStackTrace();
                }


                //System.out.println(textArea1.getText());

            }
        });
        openbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fc = new JFileChooser();
                int result = fc.showOpenDialog(null);
                String filename = fc.getSelectedFile().getAbsolutePath();
                try {

                    StringBuilder sb = new StringBuilder();
                    Scanner in = new Scanner(filename);
                    BufferedReader instream = new BufferedReader
                            (new InputStreamReader
                                    (new FileInputStream(filename), "UTF-8"));
                    String nextLine = instream.readLine();
                    while (nextLine != null){

                        sb.append(nextLine);
                        sb.append("\n");
                        nextLine = instream.readLine();
                    }

                    //System.out.print(instream.readLine());
                    textArea1.setText(sb.toString());


                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                } catch (UnsupportedEncodingException e1) {
                    e1.printStackTrace();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

            }
        });
        newbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea1.setText("");
            }
        });
    }
}
