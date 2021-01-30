import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.SystemColor;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.border.LineBorder;


public class Ex9 {
	private JFrame frame;
	private JTextField txtA;
	private JScrollPane scrollPane1;
	private JTextArea txtrA;
	private ImagePanel imagePanel;
	private GrayImage image;
	Graphics g;
	private JButton btnBinary;
	private JButton btnNegative;
	


	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ex9 window = new Ex9();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the application.
	 */
	public Ex9() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.controlHighlight);
		frame.setBounds(100, 100, 600, 400);
		frame.setTitle("EX09");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		scrollPane1 = new JScrollPane();
		frame.getContentPane().add(scrollPane1, BorderLayout.CENTER);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		frame.getContentPane().add(scrollPane_2, BorderLayout.SOUTH);
		

		
		txtrA = new JTextArea();
		txtrA.setEditable(false);
		txtrA.setRows(3);
		txtrA.setForeground(Color.BLACK);
		scrollPane_2.setViewportView(txtrA);
		txtrA.setText("“®‚¢‚Ä");
		
		imagePanel = new ImagePanel();
		scrollPane1.setViewportView(imagePanel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.BLUE));
		panel.setPreferredSize(new Dimension(120,10));
		frame.getContentPane().add(panel, BorderLayout.WEST);
		
		JLabel labelfilename = new JLabel("File Name");
		panel.add(labelfilename);
		
		txtA = new JTextField();
		panel.add(txtA);
		txtA.setColumns(8);
		
		JButton btnload = new JButton("Load");
		btnload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Filename =txtA.getText();
				try {
					BufferedImage img = ImageIO.read(new File(Filename));
					if(img!=null) {
						image = new GrayImage(img);
						txtrA.append("\nLoad '"+ Filename + "'");
					} else {
						image = null;
						txtrA.append("\nUnknown file format '" + Filename + "'");		
					}	
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					image=null;
					txtrA.append("\nCan't load '" + Filename + "'");
				} finally {
					imagePanel.setImage(image);
					scrollPane1.setViewportView(imagePanel);
				}
			}
		});
		panel.add(btnload);
		
		btnBinary = new JButton("Binary Filter");
		btnBinary.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(image!=null) {
					image.applyFilter(new BinaryImageFilter());
					imagePanel.repaint();
				}
			}
		});
		panel.add(btnBinary);
		
		btnNegative = new JButton("Negative Filter");
		btnNegative.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(image!=null) {
					image.applyFilter(new NegativeImageFilter());
					imagePanel.repaint();
				}
			}
		});
		panel.add(btnNegative);
		
		
		
		
		
		
		
	}
}