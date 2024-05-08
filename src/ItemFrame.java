

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


import service.Item;
import controller.ItemController;
import dto.ItemDTO;

public class ItemFrame extends JFrame implements ActionListener {
	Item controller = new ItemController();
	ItemDTO dto = new ItemDTO();
	Container container = getContentPane();
	// 패널들
	JPanel panel = new JPanel();
	JPanel p_north = new JPanel();
	JPanel p_center = new JPanel();
	JPanel p_image = new JPanel();
	JPanel p_label = new JPanel();
	JPanel p_south = new JPanel();
	// 상단 이미지 버튼 선언
	JButton btn_back = new JButton(new ImageIcon("img/left.gif"));
	JButton btn_search = new JButton(new ImageIcon("img/search.png"));
	JButton btn_cart = new JButton(new ImageIcon("img/cart.png"));
	JButton btn_order = new JButton(new ImageIcon("img/order.png"));
	JButton btn_home = new JButton(new ImageIcon("img/logo.png"));
	// 검색창
	JTextField textField = new JTextField(10);
	// 상품 이미지, 상품명, 원가, 판매가, 할인혜택

	JButton btn_image = new JButton();
	JLabel l_name = new JLabel("상품명");
	JLabel l_cost = new JLabel("상품가격");
	JLabel l_sale = new JLabel("상품할인가");
	//JLabel l_discount = new JLabel();
	// 할인 혜택 버튼
	JButton b_discount = new JButton("할인혜택");
	// 장바구니로 보내기 버튼
	JButton buttonCart = new JButton("장바구니");
	// 구매 버튼
    JButton purchaseButton = new JButton("구매하기");
	// 장바구니 관련
	DefaultListModel<String> model_cart = new DefaultListModel<>();
	JList<String> list_cart = new JList<>(model_cart);
	JScrollPane scrollPane_cart = new JScrollPane(list_cart);
	// 기타
	JTextPane textPane = new JTextPane();
	JScrollPane scrollPane = new JScrollPane(textPane);
	
	private ItemFrame itemFrame;
    private Item selectedItem;

	public ItemFrame(int itemno) {
		setSize(450, 700);
		setTitle("올리버몰");
		setLocation(400, 200);
		dto = controller.searchItemNo(itemno);
		init();
		start();
		setVisible(true);
	}

	private void init() {
		container.setLayout(new BorderLayout());
		container.add("North", p_north);
		container.add("Center", p_center);
		container.add("South", p_south);
		p_north.setBackground(Color.WHITE);
		p_center.setBackground(Color.WHITE);
		p_south.setBackground(Color.WHITE);
		p_north.setLayout(new GridLayout(1, 4, 0, 5));
		p_north.add(btn_home);
		p_north.add(btn_search);
		p_north.add(btn_order);
		p_north.add(btn_cart);
		btn_home.setBorderPainted(false);
		btn_home.setContentAreaFilled(false);
		btn_search.setBorderPainted(false);
		btn_search.setContentAreaFilled(false);
		btn_cart.setBorderPainted(false);
		btn_cart.setContentAreaFilled(false);
		btn_order.setBorderPainted(false);
		btn_order.setContentAreaFilled(false);
		p_center.setLayout(new BorderLayout());
		p_center.add("North", p_image);
		p_center.add("Center", p_label);
		
		p_image.setLayout(new FlowLayout(FlowLayout.CENTER));
		// 이미지가 안나타남.
		int itemno = dto.getItemno();
		if(itemno<10) {
			btn_image = new JButton(new ImageIcon("img/"+"0"+Integer.toString(dto.getItemno())+".png"));
		} else {
			btn_image = new JButton(new ImageIcon("img/"+dto.getItemno()+".png"));
		}
		btn_image.setBorderPainted(false);
		btn_image.setContentAreaFilled(false);
		p_image.add(btn_image); 
		p_image.setBackground(Color.WHITE);
		p_label.setLayout(new GridLayout(7, 1)); // 3행 1열의 그리드 레이아웃 설정
		p_label.add(l_name); // 상품명 추가
		l_name.setText(dto.getName());
		p_label.add(l_cost); // 판매가 추가
		l_cost.setText("판매가: "+Integer.toString(dto.getCost())+"원");
		p_label.add(l_sale); // 할인가 추가
		l_sale.setText("할인가: "+Integer.toString(dto.getSale())+"원");
		l_name.setFont(new Font("HY견고딕 보통", Font.BOLD,30));
		l_cost.setFont(new Font("HY견고딕 보통", Font.BOLD, 20));
		l_sale.setFont(new Font("HY견고딕 보통", Font.BOLD, 25));
		l_name.setHorizontalAlignment(JLabel.CENTER);
		l_cost.setHorizontalAlignment(JLabel.CENTER);
		l_sale.setHorizontalAlignment(JLabel.CENTER);
		l_sale.setForeground(Color.RED);
		p_label.setBackground(Color.WHITE);
		p_south.setLayout(new GridLayout(1, 2));
		p_south.add(buttonCart); // 장바구니로 보내기
		p_south.add(purchaseButton); // 구매창 열기
		buttonCart.setContentAreaFilled(false);
		purchaseButton.setContentAreaFilled(false);

        // 결제 수단 선택
        JPanel paymentPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JComboBox<String> paymentComboBox = new JComboBox<>(new String[]{"신용카드", "계좌이체", "휴대폰 결제"});
        paymentPanel.add(new JLabel("결제 수단:"));
        paymentPanel.add(paymentComboBox);

        // 구매 버튼
        JButton purchaseButton = new JButton("구매하기");
        purchaseButton.addActionListener(this);
//
//        // 레이아웃 구성
//        JPanel contentPane = new JPanel(new BorderLayout(10, 10));
//        contentPane.add("North", infoPanel);
//        contentPane.add("Center", paymentPanel);
//        contentPane.add("South", purchaseButton);
//        setContentPane(contentPane);
	}

	private void start() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 버튼
		btn_back.addActionListener(this);
		btn_search.addActionListener(this);
		btn_home.addActionListener(this);
		btn_cart.addActionListener(this);
		buttonCart.addActionListener(this);
		b_discount.addActionListener(this);
		purchaseButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 이벤트 처리 코드 작성
		if (e.getSource() == btn_home) { // 뒤로가기 이벤트처리
			new HomeFrame();
			setVisible(false);
			// 전 단계로 가기
		} else if (e.getSource() == btn_search) { // 검색창 이벤트처리
			// 여기에 검색 기능 추가
		} else if (e.getSource() == btn_cart) { // 장바구니 바로가기 이벤트처리
			
		} else if (e.getSource() == buttonCart) { // 상품 장바구니로 보내기 이벤트처리
			
		} else if (e.getSource() == b_discount) { // 상품 할인혜택 이벤트처리
			// 할인 혜택 정보 보여주는 창 열기 등의 기능 추가
			//l_discount.setText("현재 상품 할인율 : " + "%");
			//JOptionPane.showMessageDialog(this, "30% 할인하고 있습니다.");
		} else if (e.getSource() == purchaseButton) { // 상품 구매하기 이벤트처리
			// 구매 관련 기능 추가
			
			JOptionPane.showMessageDialog(this, "구매가 완료되었습니다.");
		}
	}


}
