package project1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CartFrame extends JFrame implements ActionListener {
	Container container = getContentPane();
	
	DefaultListModel<String> itemListModel = new DefaultListModel<String>();
    JList<String> itemList = new JList<String>();
    
    JPanel buttonPanel = new JPanel();
    
    JButton addButton = new JButton("상품");
    JButton removeButton = new JButton("제거");
    JButton checkoutButton = new JButton("결제");
    
    JScrollPane scrollPane = new JScrollPane(itemList);
    
	public CartFrame() {
		setSize(400, 700);
		setTitle("장바구니");
		setLocation(300, 200);
		init();
		start();
		setVisible(true);
	}

	private void init() {
		container.setLayout(new BorderLayout());
		container.add("Center", scrollPane);
		container.add("South", buttonPanel);
		
		buttonPanel.setLayout(new GridLayout(1, 3, 0, 5));
		buttonPanel.add(addButton);
		buttonPanel.add(removeButton);
		buttonPanel.add(checkoutButton);
	}

	private void start() {
		// x 버튼
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// 버튼 이벤트처리
		addButton.addActionListener(this);
		removeButton.addActionListener(this);
		checkoutButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == addButton) {
			String newItem = JOptionPane.showInputDialog(this, "항목 이름 입력 : ");
			if(newItem != null && !newItem.trim().isEmpty()) {
				itemListModel.addElement(newItem);
			}			
		} else if (e.getSource() == removeButton) {
			int selectedindex = itemList.getSelectedIndex();
			if(selectedindex != -1) {
				itemListModel.remove(selectedindex);
			} else {
				JOptionPane.showMessageDialog(this, "제거할 항목을 선택하세요.");
			}
		} else if (e.getSource() == checkoutButton) {
			JOptionPane.showMessageDialog(this, "결제 프로세스가 시작되었습니다. 구입 주셔서 감사합니다!");
		}
	}

	public static void main(String[] args) {
		new CartFrame();
	}
}
