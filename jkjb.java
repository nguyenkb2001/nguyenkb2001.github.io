package ff;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;


import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.awt.event.ActionEvent;

public class jkjb extends JFrame {
JFileChooser btn;
String adr;
File selectedFile;
String rong;
JButton rename;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					jkjb frame = new jkjb();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public jkjb() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 500, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);
		contentPane.setPreferredSize(new Dimension(500,300));
		contentPane.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 11, 414, 181);
		contentPane.add(textArea);
		
		JButton btnNewButton = new JButton("OPEN");
		btnNewButton.setActionCommand("OPEN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    try {
                    btn = new JFileChooser();
                    btn.setDialogTitle("OPEN FILE");
                    btn.setCurrentDirectory(new File("/D:\\"));
                    btn.addChoosableFileFilter(new FileNameExtensionFilter(
                            "Image (jpg, jpeg, png, bmp, gif)",
                            "jpg", "jpeg", "png", "bmp", "gif"
                    ));
                    btn.addChoosableFileFilter(new FileNameExtensionFilter(
                            "File (txt)",
                            "txt"
                    ));

                    int i = btn.showOpenDialog(null);
                    if (i == JFileChooser.APPROVE_OPTION) {
                        selectedFile = btn.getSelectedFile();
                        rong = null;
                        textArea.setText(rong);
                        try {
                            FileReader fis = new FileReader(selectedFile);
                            int data = fis.read();
                            while(data != -1) {
                                textArea.append(Character.toString((char)data));
                                data = fis.read();
                            }
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                    }else {
                        remove(btn);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                adr = selectedFile.getAbsolutePath()+".txt";
                System.out.println("File vá»«a má»Ÿ náº±m á»Ÿ: "+adr);
			}
		});
		btnNewButton.setBounds(37, 203, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("SAVE");
		btnNewButton_1.setActionCommand("SAVE");
		btnNewButton_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				 try {
                     try {
                         File myOo = new File(adr);
                         FileWriter fout = new FileWriter(myOo,false);

                         String data = textArea.getText();
                         fout.write(data);
                         fout.flush();
                         fout.close();
                     } catch (NullPointerException e5) {
                         System.out.println("Ä�Ă¢y lĂ  coppy ko thá»ƒ save");
                     }
             } catch (Exception e4) {
                 e4.printStackTrace();
             }
			}
		});
		btnNewButton_1.setBounds(171, 203, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("SAVE AS");
		btnNewButton_2.setActionCommand("SAVE AS");
		btnNewButton_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
                try {
                    btn = new JFileChooser();
                    btn.setDialogTitle("Save As File");
                    btn.setCurrentDirectory(new File("/D:\\"));
                    int i1 = btn.showSaveDialog(null);
                    if (i1 == JFileChooser.APPROVE_OPTION) {
                        selectedFile = btn.getSelectedFile();
                        try {
                            FileWriter fout = new FileWriter(selectedFile+".txt");
                            String data = textArea.getText();
                            fout.write(data);
                            fout.flush();
                            fout.close();
                        } catch (Exception e5) {
                            e5.printStackTrace();
                        }
                    }else {
                        remove(btn);
                    }
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
                adr = selectedFile.getAbsolutePath()+".txt";
                System.out.println("File vá»«a lÆ°u náº±m á»Ÿ: "+adr);
			}
		});
		btnNewButton_2.setBounds(303, 203, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("COPPY");
		btnNewButton_3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				btn = new JFileChooser();
                btn.setDialogTitle("Coppy");
                btn.setApproveButtonText("COPPY");
                btn.setCurrentDirectory(new File("D:\\"));

                btn.addChoosableFileFilter(new FileNameExtensionFilter(
                        "File (txt)",
                        "txt"
                ));

                int i = btn.showOpenDialog(null);
                if(i == JFileChooser.APPROVE_OPTION){
                    selectedFile = btn.getSelectedFile();
                    textArea.setText(null);
                    try {
                        FileReader fr1 = new FileReader(selectedFile);
                        int raed = fr1.read();
                        while (raed != -1){
                            textArea.append(Character.toString((char)raed));
                            raed = fr1.read();
                        }
                    }catch (Exception e1){
                        e1.printStackTrace();
                    }
                }
			}
		});
		btnNewButton_3.setBounds(102, 237, 89, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("PASTE");
		btnNewButton_4.setActionCommand("PASTE");
		btnNewButton_4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				 btn = new JFileChooser();
				 int i2 = btn.showOpenDialog(null);

	                if(i2 == JFileChooser.APPROVE_OPTION){
	                    selectedFile = btn.getSelectedFile();
	                    try{
	                        FileWriter fw = new FileWriter(selectedFile+".txt");
	                        String da = textArea.getText();
	                        fw.write(da);
	                        fw.flush();
	                        fw.close();
	                    }catch (Exception e1){
	                        e1.printStackTrace();
	                    }
	                }
			}
		});
		btnNewButton_4.setBounds(235, 237, 89, 23);
		contentPane.add(btnNewButton_4);
	}
}
