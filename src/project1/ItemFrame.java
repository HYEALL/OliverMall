package project1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ItemFrame extends JFrame implements ActionListener {
	Container container = getContentPane();
	// 패널들
	JPanel panel = new JPanel();
	JPanel p_north = new JPanel();
	JPanel p_center = new JPanel();
	JPanel p_image = new JPanel();
	JPanel p_label = new JPanel();
	JPanel p_south = new JPanel();
	// 상단 이미지 버튼 선언
	JButton b_back, b_search, b_home, b_cart = new JButton();
	ImageIcon i_back = new ImageIcon("img/left.gif"); // 뒤로가기
	ImageIcon i_search = new ImageIcon("img/search.png"); // 검색
	ImageIcon i_home = new ImageIcon("img/logo.png"); // 홈
	ImageIcon i_cart = new ImageIcon("img/cart.png"); // 장바구니 들어가기
	// 검색창
	JTextField textField = new JTextField(10);
	// 상품 이미지, 상품명, 원가, 판매가, 할인혜택
	String imagePath = "img/01.png";
	ImageIcon productImage = new ImageIcon(imagePath);
	Image image = productImage.getImage();
	JLabel l_image = new JLabel(productImage);
	JLabel l_name = new JLabel("아누아 어성초70 데일리 로션 200ml");
	JLabel l_sale = new JLabel("21000원");
	JLabel l_discount = new JLabel();
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

    @SuppressWarnings("deprecation")
	public ItemFrame(ItemFrame itemFrame) {
        this.itemFrame = itemFrame;
        countComponents();
    }

	public ItemFrame() {
		setSize(400, 700);
		setTitle("올리버몰");
		setLocation(300, 200);
		init();
		start();
		setVisible(true);
	}

	private void init() {
		container.setLayout(new BorderLayout());
		container.add("North", p_north);
		container.add("Center", p_center);
		container.add("South", p_south);

		p_north.setLayout(new GridLayout(1, 4, 0, 5));
		b_back = new JButton(i_back);
		b_search = new JButton(i_search);
		b_home = new JButton(i_home);
		b_cart = new JButton(i_cart);
		p_north.add(b_back);
		p_north.add(b_search);
		p_north.add(b_home);
		p_north.add(b_cart);

		p_center.setLayout(new BorderLayout());
		p_center.add("North", p_image);
		p_center.add("South", p_label);

		p_image.setLayout(new FlowLayout(FlowLayout.CENTER));
		p_image.add(l_image); // 상품 사진

		p_label.setLayout(new GridLayout(3, 1, 5, 5)); // 3행 1열의 그리드 레이아웃 설정
		p_label.add(l_name); // 상품명 추가
		p_label.add(l_sale); // 판매가 추가
		p_label.add(b_discount); // 할인혜택 버튼 추가

		p_south.setLayout(new GridLayout(1, 2, 0, 5));
		p_south.add(buttonCart); // 장바구니로 보내기
		p_south.add(purchaseButton); // 구매창 열기
		
        // 상품 정보 표시
        JPanel infoPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        infoPanel.add(new JLabel("상품명:"));
        infoPanel.add(new JLabel(""));
        infoPanel.add(new JLabel("가격:"));
        infoPanel.add(new JLabel(""));
        infoPanel.add(new JLabel("할인율:"));
        infoPanel.add(new JLabel(""));

        // 결제 수단 선택
        JPanel paymentPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JComboBox<String> paymentComboBox = new JComboBox<>(new String[]{"신용카드", "계좌이체", "휴대폰 결제"});
        paymentPanel.add(new JLabel("결제 수단:"));
        paymentPanel.add(paymentComboBox);

        // 구매 버튼
        JButton purchaseButton = new JButton("구매하기");
        purchaseButton.addActionListener(this);

        // 레이아웃 구성
        JPanel contentPane = new JPanel(new BorderLayout(10, 10));
        contentPane.add("North", infoPanel);
        contentPane.add("Center", paymentPanel);
        contentPane.add("South", purchaseButton);
        setContentPane(contentPane);
	}

	private void start() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 버튼
		b_back.addActionListener(this);
		b_search.addActionListener(this);
		b_home.addActionListener(this);
		b_cart.addActionListener(this);
		buttonCart.addActionListener(this);
		b_discount.addActionListener(this);
		purchaseButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 이벤트 처리 코드 작성
		if (e.getSource() == b_back) { // 뒤로가기 이벤트처리
			dispose();
			// 전 단계로 가기
		} else if (e.getSource() == b_search) { // 검색창 이벤트처리
			// 여기에 검색 기능 추가
		} else if (e.getSource() == b_home) { // 홈 바로가기 이벤트처리
			dispose();
			// 홈으로 이동하는 기능 추가
		} else if (e.getSource() == b_cart) { // 장바구니 바로가기 이벤트처리
			dispose();
			new CartFrame();
		} else if (e.getSource() == buttonCart) { // 상품 장바구니로 보내기 이벤트처리
			ItemImpl itemImpl = new ItemImpl(imagePath, ERROR, ALLBITS, ABORT);
			// 장바구니에 상품 추가되었음을 사용자에게 알리는 기능 추가
			JOptionPane.showMessageDialog(this, "상품이 장바구니에 추가되었습니다.");
		} else if (e.getSource() == b_discount) { // 상품 할인혜택 이벤트처리
			// 할인 혜택 정보 보여주는 창 열기 등의 기능 추가
			l_discount.setText("현재 상품 할인율 : " + "%");
			JOptionPane.showMessageDialog(this, "30% 할인하고 있습니다.");
		} else if (e.getSource() == purchaseButton) { // 상품 구매하기 이벤트처리
			// 구매 관련 기능 추가
			
			JOptionPane.showMessageDialog(this, "구매가 완료되었습니다.");
		}
	}

	public static void main(String[] args) {
		new ItemFrame();
	}
}
