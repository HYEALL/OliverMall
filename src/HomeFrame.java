import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class HomeFrame extends JFrame implements ActionListener {
	Container container = getContentPane();
	JLabel logo = new JLabel(new ImageIcon("img/logo.png"));
	JButton btn_search = new JButton(new ImageIcon("img/search.png"));
	JButton btn_cart = new JButton(new ImageIcon("img/cart.png"));
	JPanel panel_all = new JPanel();
	JScrollPane scrollPane = new JScrollPane();

	JPanel panel_top = new JPanel();
	JPanel panel_top_title = new JPanel();
	JPanel panel_top_btn = new JPanel();
	JPanel panel_menu = new JPanel();
	JPanel panel_item = new JPanel();
	JPanel panel_item_image = new JPanel();
	JPanel panel_item_content = new JPanel();
	JButton[] categoryButtons = new JButton[4];
	JButton btn_home = new JButton("Home");
	String[] categoryStr = { "Skin", "Point", "Base", "Sun" };
	JTextField tf_search = new JTextField();


	Item controller = new ItemController();
	
	// 상품 read
	String str = controller.read();
	String[] item_str = str.split("\n");

	JButton[] item_btns = new JButton[item_str.length];
	JLabel [] item_labels = new JLabel[item_str.length];
	
	public HomeFrame() {
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
		panel_all.setLayout(new BorderLayout());
		panel_all.setBackground(Color.WHITE);
		panel_all.add("North", panel_top);
		panel_all.add("Center", panel_item);

		panel_top.setLayout(new GridLayout(2, 1, 0, 5));
		panel_top.setBackground(Color.WHITE);
		panel_top.add(panel_top_title);
		panel_top.add(panel_menu);
		panel_top_title.setLayout(new BorderLayout(10, 10));
		panel_top_title.setBackground(Color.WHITE);
		panel_top_title.add("West", logo);
		panel_top_title.add("Center", tf_search);
		panel_top_title.add("East", panel_top_btn);
		panel_top_btn.setLayout(new GridLayout());
		panel_top_btn.setBackground(Color.WHITE);
		panel_top_btn.add(btn_search);
		panel_top_btn.add(btn_cart);
		btn_search.setBorderPainted(false);
		btn_search.setContentAreaFilled(false);
		btn_cart.setBorderPainted(false);
		btn_cart.setContentAreaFilled(false);

		panel_menu.setLayout(new FlowLayout());
		panel_menu.add(btn_home);
		panel_menu.setBackground(Color.WHITE);
		btn_home.setBorderPainted(false);
		btn_home.setContentAreaFilled(false);
		btn_home.setFont(new Font("Arial", Font.BOLD, 14));
		btn_home.setPreferredSize(new Dimension(75, 40));
		for (int i = 0; i < 4; i++) {
			categoryButtons[i] = new JButton(categoryStr[i]);
			categoryButtons[i].setPreferredSize(new Dimension(70, 40));
			categoryButtons[i].setFont(new Font("Arial", Font.BOLD, 14));
			categoryButtons[i].setBorderPainted(false);
			categoryButtons[i].setContentAreaFilled(false);
			panel_menu.add(categoryButtons[i]);
		}
		panel_item.setLayout(new BorderLayout());
		panel_item.add("West", panel_item_image);
		panel_item.add("Center", panel_item_content);

		panel_item_image.setLayout(new GridLayout(item_str.length, 1));
		panel_item_image.setBackground(Color.WHITE);

		for (int i = 0; i < item_str.length; i++) {
			item_btns[i] = new JButton(new ImageIcon("img/"+(i+1)+".png"));;
			item_btns[i].setBorderPainted(false);
			item_btns[i].setContentAreaFilled(false);
			panel_item_image.add(item_btns[i]);
		}
		panel_item_content.setLayout(new GridLayout(item_str.length, 1));
		panel_item_content.setBackground(Color.WHITE);
		for (int i = 0; i < item_str.length; i++) {
			item_labels[i] = new JLabel(item_str[i]);
			item_labels[i].setFont(new Font("굴림", Font.PLAIN, 12));
			panel_item_content.add(item_labels[i]);
		}



	}

	private void start() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

}
