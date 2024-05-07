
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class OrderFrame extends JFrame {
	Container container = getContentPane();
	JPanel panel_north = new JPanel();

	// panel_center
	JPanel panel_center = new JPanel();

	// panel_label
	JPanel panel_label = new JPanel();
	JLabel label = new JLabel("주문내역", JLabel.CENTER);

	JPanel panel_center2 = new JPanel();
	JPanel panel_orderadate = new JPanel();
	JLabel label_orderadate = new JLabel("    2024.03.07");
	JPanel panel_orderstauts = new JPanel();
	JLabel label_orderstatus = new JLabel("  배송완료");

	// panel_lb
	JPanel panel_lb = new JPanel();
	ImageIcon imageIcon = new ImageIcon("img/test.png");
	JLabel lb = new JLabel(new ImageIcon("img/test.png"));

	// panel_info
	JPanel panel_info = new JPanel();

	JTextArea textArea = new JTextArea();
	JScrollPane scrollPane = new JScrollPane(textArea);
	Order order = new OrderImpl();

	public OrderFrame() {

		// Frame 기본 설정
		setSize(400, 700);
		setTitle("OrderForm");
		setLocation(400, 700);
		init();
		start();
		setVisible(true);
	}

	private void init() {

		container.setLayout(new GridLayout(3, 1, 0, 0));
		container.add(panel_north);
		container.add(panel_center);
		container.add(panel_center2);

		panel_north.setLayout(new BorderLayout());
		panel_north.add("South", panel_label);
		panel_north.setBackground(Color.white);

		panel_label.setBackground(new Color(154, 205, 50));
		panel_label.add(label);

		Font font = new Font("HY견고딕 보통", Font.BOLD, 20);
		label.setFont(font);

		panel_center.setLayout(new BorderLayout());
		panel_center.add("North", panel_orderadate);
		panel_center.add("West", panel_lb);
		String str = order.read("Y230998");
		//String str = order.readAll();
		System.out.println(str);
		textArea.setText(str);
		panel_center.add("Center", scrollPane);

		panel_orderadate.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel_orderadate.add(label_orderadate);
		panel_orderadate.setBackground(Color.white);
		label_orderadate.setFont(new Font("HY견고딕 보통", Font.BOLD, 15));

		panel_lb.add(lb);
		panel_lb.setBackground(Color.white);

		// panel_info
//	      panel_info.setLayout(new FlowLayout());
//	      panel_info.add(textArea);

//	      

		// panel_info.add(label_name);
		// panel_info.add(label_orderno);
		// panel_info.add(label_itemno);
		// panel_info.add(label_qty);
		// panel_info.add(label_price);
		// panel_info.add(button_orderstatus);

		panel_info.setBackground(Color.white);

		// label_name.setFont(new Font("HY견고딕 보통", Font.BOLD, 15));
		// label_orderno.setFont(new Font("HY견고딕 보통", Font.BOLD, 13));
		// label_itemno.setFont(new Font("HY견고딕 보통", Font.BOLD, 13));
		// label_qty.setFont(new Font("HY견고딕 보통", Font.BOLD, 13));
		// label_price.setFont(new Font("HY견고딕 보통",Font.BOLD, 15));

		panel_center2.setBackground(Color.white);
		// JSeparator separator = new JSeparator(SwingConstants.HORIZONTAL);
		// panel_center2.add(separator, BorderLayout.LINE_START);

	}

	private void start() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

//   String result = order.read(orderno);
//   textArea.setText(result);

}
