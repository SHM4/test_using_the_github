package com.APP.FoodSearch.UploadFoodInfo;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

import com.APP.ConnectionManager;
import com.APP.Common.JPanelSize;
import com.APP.NavBar.bottomMenuPane;

import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UploadFoodInfo extends JFrame{
	
	// 변수 선언
	int food_pk = 0;
	int highest_food_pk = 1;
	String food_name;
	String food_category;
	String food_metricname;
	String food_metricgrams;
	String food_calorie;
	String food_carb;
	String food_protein;
	String food_fat;
	String food_sodium;
	String food_sugar;
	
	// 콤보박스 구현
	JComboBox<String> food_category_combo;
	String food_category_list[] = {"김치류", "곡류 및 서류", "과자류", "구이류", "국 및 탕류", "면 및 만두류", "밥류", "볶음류", "빵류", "생채및 무침류", "숙채류", "음료 및 차류", "장아찌 및 절임류", "전.적 및 부침류", "조림류", "죽 및 스프류", "찌개 및 전골류", "찜류", "튀김류", "포류", "회류","기타"};
	JComboBox<String> food_metricname_combo;
	String food_metricname_list[] = {"개", "인분", "조각", "줄", "컵"};
	
	// 100번째 줄 이하 코드 구현을 위한 선언
	String[] inputTitle =
	{"1. 음식 이름을 입력해주세요.", 
	"2. 음식의 카테고리(분류)를 선택해주세요.", 
	"3. 음식의 1회 제공량을 선택해주세요.", 
	"4. 1회 제공량의 분량(g)을 입력해주세요.", 
	"5. 1회 제공량의 칼로리 양(kcal)를 입력해주세요.", 
	"6. 1회 제공량의 탄수화물 양(g)을 입력해주세요.", 
	"7. 1회 제공량의 단백질 양(g)을 입력해주세요.",
	"8. 1회 제공량의 지방 양(g)을 입력해주세요.",
	"9. 1회 제공량의 나트륨 양(mg)을 입력해주세요.",
	"10. 1회 제공량의 당류의 양(g)을 입력해주세요."};
	JPanel[] Title;
	JTextField[] foodInputField;
    // JTextField[] foodInputField = new JTextField[0];
	
	// 폰트 설정
	public void setUIFont (javax.swing.plaf.FontUIResource f){
		java.util.Enumeration keys = UIManager.getDefaults().keys();
		while (keys.hasMoreElements()) {
			Object key = keys.nextElement();
			Object value = UIManager.get (key);
			if (value instanceof javax.swing.plaf.FontUIResource)
			UIManager.put (key, f);
		}
	}

	// DB 연결
	public static Connection get() {
		Connection conn=null;
		
		try {
			ConnectionManager cm = new ConnectionManager();
			conn = cm.get();
			
			System.out.println("데이터베이스 정상 연결");
		}
		catch(Exception e) {
			System.out.println("로딩 실패");
		}
		
		return conn;
	}

	// GUI
	UploadFoodInfo() throws SQLException {
		setTitle("음식 정보 입력");
		Container c = getContentPane();
		c.setBackground(new Color(255, 247, 225));
		// c.setLayout(new GridLayout()); 그리드레이아웃 없어야 모양이 맞음
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		

		// 화면 사이즈
		JPanelSize jPanelSize = new JPanelSize();
        int BasicWidth = jPanelSize.getWidth();
		int BasicHeight = jPanelSize.getHeight();
		setSize(BasicWidth, BasicHeight);

		// 기본 폰트
		setUIFont (new javax.swing.plaf.FontUIResource("굴림",Font.BOLD,12));
		
		// 메인 색상 HEX 코드 #03c75a, RGB 코드 3, 199, 90
		Color MainColor = new Color(3, 199, 90);

		// 메인 패널
		JPanel mainpanel = new JPanel();
		mainpanel.setLayout(new GridBagLayout());
		c.add(mainpanel, BorderLayout.CENTER);

		// 바텀 메뉴바
		JPanel bottomMenuPane= new bottomMenuPane(BasicWidth, BasicHeight/8);
		c.add(bottomMenuPane, BorderLayout.SOUTH);
	
		// 아래쪽 코드 AppUserInfo 90~116번째 줄 참고
		GridBagConstraints gridBagConstraints = new GridBagConstraints();

		// 상단 메뉴바
		JPanel topPanel = new JPanel();
		gridBagConstraints.ipadx = 400;
		gridBagConstraints.ipady = 20;
		gridBagConstraints.insets = new Insets(10,0,10,0);
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		mainpanel.add(topPanel, gridBagConstraints);
		topPanel.setBackground(MainColor);
		
		Title = new JPanel[inputTitle.length];
		foodInputField = new JTextField[inputTitle.length];
		//for (int i=0; i<Title.length; i++) {
		// TODO : 스크롤바 구현 후 위 코드로 전환!
		for (int i=0; i<5; i++) {
			Title[i] = new JPanel(new GridBagLayout());
            Title[i].setOpaque(false);
            Title[i].setBorder(BorderFactory.createTitledBorder(inputTitle[i]));
            gridBagConstraints.ipadx = 400;
            gridBagConstraints.ipady = 20;
            gridBagConstraints.insets = new Insets(10,100,10,100);
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = i+1;
            if (i == 2) {
                food_category_combo = new JComboBox<>(food_category_list);
                food_category_combo.setPreferredSize(new Dimension(300,20));
                gridBagConstraints.ipadx = 310;
				food_category_combo.setBackground(Color.white);
                //foodInputField[2].add(food_category_combo);
				// TODO : null값 뜬다고 함.
				// 위에 선언한 것으로부터 값을 못 받아오는 것 같음.
            } 
			else if(i == 3){
				food_metricname_combo = new JComboBox<String>(food_metricname_list);
                food_metricname_combo.setPreferredSize(new Dimension(300,20));
                gridBagConstraints.ipadx = 310;
				food_metricname_combo.setBackground(Color.white);
                //foodInputField[i].add(food_metricname_combo);
			}
			else {
                foodInputField[i] = new JTextField();
                foodInputField[i].setPreferredSize(new Dimension(400,40));
                Title[i].add(foodInputField[i]);
                // foodInputField[i].setText(UserInputTxt.getUserInputTxtItem(i)); 일단 필요 없는 코드
            }
            mainpanel.add(Title[i], gridBagConstraints);
		}

		// JButton jb1 = new JButton("확인");
		// jb1.setBorder(new LineBorder(MainColor, 2));
		// c.add(jb1);
		
		/////////////////////////////////////////////////////////////

		// food 테이블에서 마지막 food_pk 값 추출
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		try {
			ConnectionManager cm = new ConnectionManager();
			conn = cm.get();

			String que = "select food_pk from food";

			psmt = conn.prepareStatement(que);

			rs = psmt.executeQuery();

			while (rs.next()) {
				highest_food_pk = rs.getInt(1);
			}
			System.out.println("기존 가장 높은 food_pk: "+highest_food_pk);

		} catch (Exception e) {
			e.printStackTrace();
		}

		rs.close();
		psmt.close();
		conn.close();
		
		/////////////////////////////////////////////////////////////		
		/*
		// '확인' 버튼 누르면 입력한 값을 가져와서 DB에 입력		
		jb1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				food_pk = highest_food_pk+1;
				// food_name = jt1.getText();
				// food_category =  (String)food_category_combo.getSelectedItem();
				// food_metricname = (String)food_metricname_combo.getSelectedItem();
				// food_metricgrams = jt4.getText();
				// food_calorie = jt5.getText();
				// food_carb = jt6.getText();
				// food_fat = jt7.getText();
				// food_protein = jt8.getText();
				// food_sodium = jt9.getText();
				// food_sugar = jt10.getText();
				
				/////////////////////////////////////////////////////////////	
				
				// Food 테이블에 값 입력

				String que = "insert into food(food_pk,food_name,food_category,food_metricname,food_metricgrams,food_calorie,food_carb,food_protein,food_fat,food_sodium,food_sugar)"
				+ "values(?,?,?,?,?,?,?,?,?,?,?)";
				
				Connection con = null;
				PreparedStatement pstmt = null;

				try {

					ConnectionManager cm = new ConnectionManager();
					con = cm.get();

					pstmt = con.prepareStatement(que);

					pstmt.setInt(1, food_pk);
					pstmt.setString(2, food_name);
					pstmt.setString(3, food_category);
					pstmt.setString(4, food_metricname);
					pstmt.setInt(5, Integer.parseInt(food_metricgrams));
					pstmt.setDouble(6, Double.parseDouble(food_calorie));
					pstmt.setDouble(7, Double.parseDouble(food_carb));
					pstmt.setDouble(8, Double.parseDouble(food_protein));
					pstmt.setDouble(9, Double.parseDouble(food_fat));
					pstmt.setDouble(10, Double.parseDouble(food_sodium));
					pstmt.setDouble(11, Double.parseDouble(food_sugar));

					pstmt.executeUpdate();

				}
				catch (Exception ex) {}
				////////////////////////////////////////////////////////////////
				
				// 정보 확인용
				System.out.println(food_pk);
				System.out.println(food_name);
				System.out.println(food_category);
				System.out.println(food_metricname);
				System.out.println(food_metricgrams);
				System.out.println(food_calorie);
				System.out.println(food_carb);
				System.out.println(food_fat);
				System.out.println(food_protein);
				System.out.println(food_sodium);
				System.out.println(food_sugar);
				System.out.println("DB 정보 입력 완료");

			}
		});
		*/
		
		setVisible(true);
		
	}

	public static void main(String[] args) throws SQLException {
		
		new UploadFoodInfo();

	}
}

// 양식 통일하기
// TODO : 확인 버튼 누르면 신요 씨 화면으로 이동하는 기능 구현
	// bottomMenuPane.java 참고해보자
	// 변수를 받는 생성자와 그렇지 않은 생성자를 이용해보자
	// 입력한 값이 맞는지 확인하는 팝업창이 뜨면 좋을 것 같아

		// 아래는 비활성화한 코드 임시 보관용

		// JLabel jl1 = new JLabel("1. 음식 이름을 입력해주세요.");
		// JLabel jl2 = new JLabel("2. 음식의 카테고리(분류)를 선택해주세요.");		
		// JLabel jl3 = new JLabel("3. 음식의 1회 제공량을 선택해주세요.");
		// JLabel jl4 = new JLabel("4. 1회 제공량의 분량(g)을 입력해주세요.");
		// JLabel jl5 = new JLabel("5. 1회 제공량의 칼로리 양(kcal)를 입력해주세요.");
		// JLabel jl6 = new JLabel("6. 1회 제공량의 탄수화물 양(g)을 입력해주세요.");
		// JLabel jl7 = new JLabel("7. 1회 제공량의 단백질 양(g)을 입력해주세요.");
		// JLabel jl8 = new JLabel("8. 1회 제공량의 지방 양(g)을 입력해주세요.");
		// JLabel jl9 = new JLabel("9. 1회 제공량의 나트륨 양(mg)을 입력해주세요.");
		// JLabel jl10 = new JLabel("10. 1회 제공량의 당류의 양(g)을 입력해주세요.");	
		
		// JTextArea jt1 = new JTextArea();
		// food_category_combo = new JComboBox(food_category_list);
		// food_metricname_combo = new JComboBox(food_metricname_list);
		// JTextArea jt4 = new JTextArea();
		// JTextArea jt5 = new JTextArea();
		// JTextArea jt6 = new JTextArea();
		// JTextArea jt7 = new JTextArea();
		// JTextArea jt8 = new JTextArea();
		// JTextArea jt9 = new JTextArea();
		// JTextArea jt10 = new JTextArea();

		// Font font = new Font("궁서 보통", Font.BOLD, 18);
		
		// jl1.setFont(font);
		// jl2.setFont(font);
		// jl3.setFont(font);
		// jl4.setFont(font);
		// jl5.setFont(font);
		// jl6.setFont(font);
		// jl7.setFont(font);
		// jl8.setFont(font);
		// jl9.setFont(font);
		// jl10.setFont(font);
		
		// jt1.setFont(font);
		// food_category_combo.setFont(font);
		// food_metricname_combo.setFont(font);
		// jt4.setFont(font);
		// jt5.setFont(font);
		// jt6.setFont(font);
		// jt7.setFont(font);
		// jt8.setFont(font);
		// jt9.setFont(font);
		// jt10.setFont(font);
		
		// jb1.setFont(font);

		// jl1.setOpaque(true);
		// JLabel에 색을 넣기 위한 코드. 일단 비활성화.

		// 테두리 색과 두께 설정
		// jt1.setBorder(new LineBorder(MainColor, 2));
		// food_category_combo.setBorder(new LineBorder(MainColor, 2));
		// food_metricname_combo.setBorder(new LineBorder(MainColor, 2));
		// jt4.setBorder(new LineBorder(MainColor, 2));
		// jt5.setBorder(new LineBorder(MainColor, 2));
		// jt6.setBorder(new LineBorder(MainColor, 2));
		// jt7.setBorder(new LineBorder(MainColor, 2));
		// jt8.setBorder(new LineBorder(MainColor, 2));
		// jt9.setBorder(new LineBorder(MainColor, 2));
		// jt10.setBorder(new LineBorder(MainColor, 2));

		// 위치 설정
		// top.setBounds(0, 0, 560, 30);

		// jl1.setBounds(45, 0, 500, 40);
		// jl2.setBounds(45, 70, 500, 40);
		// jl3.setBounds(45, 140, 500, 40);
		// jl4.setBounds(45, 210, 500, 40);
		// jl5.setBounds(45, 280, 500, 40);
		// jl6.setBounds(45, 350, 500, 40);
		// jl7.setBounds(45, 420, 500, 40);
		// jl8.setBounds(45, 490, 500, 40);
		// jl9.setBounds(45, 560, 500, 40);
		// jl10.setBounds(45, 630, 500, 40);
		
		// jt1.setBounds(45, 40, 450, 30);
		// food_category_combo.setBounds(45, 110, 450, 30);
		// food_metricname_combo.setBounds(45, 180, 450, 30);
		// jt4.setBounds(45, 250, 450, 30);
		// jt5.setBounds(45, 320, 450, 30);
		// jt6.setBounds(45, 390, 450, 30);
		// jt7.setBounds(45, 460, 450, 30);
		// jt8.setBounds(45, 530, 450, 30);
		// jt9.setBounds(45, 600, 450, 30);
		// jt10.setBounds(45, 670, 450, 30);

		// jb1.setBounds(415, 705, 80, 30);

		// c.add(jl1);
		// c.add(jl2);
		// c.add(jl3);
		// c.add(jl4);
		// c.add(jl5);
		// c.add(jl6);
		// c.add(jl7);
		// c.add(jl8);
		// c.add(jl9);
		// c.add(jl10);
		
		// c.add(jt1);
		// c.add(food_category_combo);		
		// c.add(food_metricname_combo);
		// c.add(jt4);
		// c.add(jt5);
		// c.add(jt6);
		// c.add(jt7);
		// c.add(jt8);
		// c.add(jt9);
		// c.add(jt10);