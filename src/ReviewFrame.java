import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class ReviewFrame extends JFrame implements ActionListener{
	
	Container container = getContentPane();
	JLabel logo = new JLabel(new ImageIcon("img/logo.png"));
	JButton btn_search = new JButton(new ImageIcon("img/search.png"));
	JButton btn_cart = new JButton(new ImageIcon("img/cart.png"));
	JPanel panel_all = new JPanel();
	JScrollPane scrollPane = new JScrollPane();
	JPanel panel_top = new JPanel();
	JPanel panel_top_title = new JPanel();
	JPanel panel_top_btn = new JPanel();
	JPanel panel_content = new JPanel();
	JPanel panel_content2 = new JPanel();
	JPanel panel_content3 = new JPanel();
	JPanel panel_center = new JPanel();
	JLabel label_writer = new JLabel("작성자이름가나다");
	JTextArea textArea = new JTextArea("test\ntest\ntest\ntest");
	JScrollPane textAreaScroll = new JScrollPane(textArea);
	JLabel label_regDate = new JLabel("2024.05.01");
	
	JLabel label_writer2 = new JLabel("작성자이름가나다");
	JTextArea textArea2 = new JTextArea();
	JScrollPane textAreaScroll2 = new JScrollPane(textArea2);
	JLabel label_regDate2 = new JLabel("2024.05.01");
	
	JLabel label_writer3 = new JLabel("작성자이름가나다");
	JTextArea textArea3 = new JTextArea();
	JScrollPane textAreaScroll3 = new JScrollPane(textArea3);
	JLabel label_regDate3 = new JLabel("2024.05.01");
	public ReviewFrame() {
		// Frame 기본설정
		setSize(400, 700);
		setTitle("올리버몰");
		setLocation(400, 200);
		init();
		start();
		setVisible(true);
	}
	private void init() {
		container.add(scrollPane);
		scrollPane.setViewportView(panel_all);
		scrollPane.getVerticalScrollBar().setUnitIncrement(10);
		panel_all.setLayout(new BorderLayout(0, 30));
		panel_all.setBackground(Color.WHITE);
		panel_all.add("North", panel_top_title);
		panel_all.add("Center" , panel_center);
		
		panel_top_title.setLayout(new BorderLayout(10, 10));
		panel_top_title.setBackground(Color.WHITE);
		panel_top_title.add("West", logo);
		panel_top_title.add("East", panel_top_btn);
		panel_top_btn.setLayout(new GridLayout());
		panel_top_btn.setBackground(Color.WHITE);
		panel_top_btn.add(btn_cart);
		btn_search.setBorderPainted(false);
		btn_search.setContentAreaFilled(false);
		btn_cart.setBorderPainted(false);
		btn_cart.setContentAreaFilled(false);
		
		panel_center.setLayout(new GridLayout(5, 1, 0, 30));
		panel_center.setBackground(Color.WHITE);
		panel_center.add(panel_content);
		panel_center.add(panel_content2);
		panel_center.add(panel_content3);
		
		panel_content.setBackground(Color.WHITE);
		panel_content.setLayout(new BorderLayout());
		panel_content.add("North", label_writer);
		label_writer.setFont(new Font("굴림", Font.BOLD, 16));
		panel_content.add("Center", textAreaScroll);
		textArea.setFont(new Font("굴림", Font.BOLD, 20));
		textArea.setEditable(false);
		panel_content.add("South", label_regDate);
		
		panel_content2.setBackground(Color.WHITE);
		panel_content2.setLayout(new BorderLayout());
		panel_content2.add("North", label_writer2);
		label_writer2.setFont(new Font("굴림", Font.BOLD, 16));
		panel_content2.add("Center", textAreaScroll2);
		textArea2.setFont(new Font("굴림", Font.BOLD, 20));
		textArea2.setEditable(false);
		panel_content2.add("South", label_regDate2);
		
		panel_content3.setBackground(Color.WHITE);
		panel_content3.setLayout(new BorderLayout());
		panel_content3.add("North", label_writer3);
		label_writer3.setFont(new Font("굴림", Font.BOLD, 16));
		panel_content3.add("Center", textAreaScroll3);
		textArea3.setFont(new Font("굴림", Font.BOLD, 20));
		textArea3.setEditable(false);
		panel_content3.add("South", label_regDate3);
		

		
	}
	private void start() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}
	
}
