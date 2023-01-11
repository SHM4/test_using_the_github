package com.APP.FoodSearch.UploadFoodInfo;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

import com.APP.ConnectionManager;
import com.APP.Common.JPanelSize;
import com.APP.NavBar.bottomMenuPane;
import com.APP.FoodSearch.AppFoodSearch;

import java.awt.event.*;
import java.io.IOException;
import java.sql.Connection;
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

	JScrollPane scroll =null;
	
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
			e.printStackTrace();
			System.out.println("로딩 실패");
			System.out.println(e);
		}
		return conn;
	}

	// GUI
	UploadFoodInfo() throws SQLException {
		setTitle("음식 정보 입력");
		Container c = getContentPane();
		c.setBackground(new Color(255, 247, 225));
		// c.setLayout(new GridLayout()); 그리드레이아웃 없어야 레이아웃 정상
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
		mainpanel.setSize(BasicWidth, BasicHeight);
		mainpanel.setLayout(new GridBagLayout());
		// c.add(mainpanel, BorderLayout.CENTER);

		scroll = new JScrollPane();
		scroll = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setViewportView(mainpanel);
		// scroll.setPreferredSize(new Dimension(280, 840));
		scroll.setBorder(null);
		c.add(scroll, BorderLayout.CENTER);

		// 바텀 메뉴바
		JPanel bottomMenuPane= new bottomMenuPane(BasicWidth, BasicHeight/8);
		c.add(bottomMenuPane, BorderLayout.SOUTH);
	

		// 아래쪽 코드 AppUserInfo 90~116번째 줄 참고
		GridBagConstraints gridBagConstraints = new GridBagConstraints();


		// 상단 메뉴바 대신 버튼 추가
		JPanel firstBtnPanel=new JPanel(new GridLayout(1,2));
		gridBagConstraints.ipadx = 400;
		gridBagConstraints.ipady = 20;
		gridBagConstraints.insets = new Insets(10,0,10,0);
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		mainpanel.add(firstBtnPanel, gridBagConstraints);

		JButton firstPanelbtn1 = new JButton("검색");
		JButton firstPanelbtn2 = new JButton("추가");
		firstBtnPanel.add(firstPanelbtn1);
		firstBtnPanel.add(firstPanelbtn2);
		

		// Title = new JPanel[inputTitle.length];
		// foodInputField = new JTextField[inputTitle.length];
		// for (int i=0; i<inputTitle.length; i++) {
		// TODO : 스크롤바 구현 후 위 코드로 전환! 및 값 5개로 전환한 코드들 전부 복구하기
		Title = new JPanel[5];
		foodInputField = new JTextField[5];
		for (int i=0; i<5; i++) {
			Title[i] = new JPanel(new GridBagLayout());
            Title[i].setOpaque(false);
            Title[i].setBorder(BorderFactory.createTitledBorder(inputTitle[i]));
            gridBagConstraints.ipadx = 400;
            gridBagConstraints.ipady = 20;
            gridBagConstraints.insets = new Insets(10,100,10,100);
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = i+1;
            if (i == 1) {
                food_category_combo = new JComboBox<>(food_category_list);
                food_category_combo.setPreferredSize(new Dimension(300,20));
                gridBagConstraints.ipadx = 310;
				food_category_combo.setBackground(Color.white);
                Title[i].add(food_category_combo);
            } 
			else if(i == 2){
				food_metricname_combo = new JComboBox<String>(food_metricname_list);
                food_metricname_combo.setPreferredSize(new Dimension(300,20));
                gridBagConstraints.ipadx = 310;
				food_metricname_combo.setBackground(Color.white);
                Title[i].add(food_metricname_combo);
			}
			else {
                foodInputField[i] = new JTextField();
                // foodInputField[i].setPreferredSize(new Dimension(400,40)); setColumns 사용하기로 함
				foodInputField[i].setColumns(35);
                Title[i].add(foodInputField[i]);
            }
            mainpanel.add(Title[i], gridBagConstraints);
		}

		JButton jb1 = new JButton("확인");
		gridBagConstraints.ipadx = 400;
		gridBagConstraints.ipady = 20;
		gridBagConstraints.insets = new Insets(10,0,10,0);
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = inputTitle.length+1;
		mainpanel.add(jb1, gridBagConstraints);
		jb1.setBorder(new LineBorder(MainColor, 2));

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
		
		
		// '확인' 버튼 누르면 입력한 값을 가져와서 DB에 입력		
		jb1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				/* 임시 비활성화
				food_pk = highest_food_pk+1;
				food_name = foodInputField[0].getText();
				food_category =  (String)food_category_combo.getSelectedItem();
				food_metricname = (String)food_metricname_combo.getSelectedItem();
				food_metricgrams = foodInputField[3].getText();
				food_calorie = foodInputField[4].getText();
				// food_carb = foodInputField[5].getText();
				// food_fat = foodInputField[6].getText();
				// food_protein = foodInputField[7].getText();
				// food_sodium = foodInputField[8].getText();
				// food_sugar = foodInputField[9].getText();
				
				
				// Food 테이블에 값 입력
				// String que = "insert into food(food_pk,food_name,food_category,food_metricname,food_metricgrams,food_calorie,food_carb,food_protein,food_fat,food_sodium,food_sugar)"
				// + "values(?,?,?,?,?,?,?,?,?,?,?)";

				String que = "insert into food(food_pk,food_name,food_category,food_metricname,food_metricgrams,food_calorie)"
				+ "values(?,?,?,?,?,?)";
				
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
					// pstmt.setDouble(6, Double.parseDouble(food_calorie));
					// pstmt.setDouble(7, Double.parseDouble(food_carb));
					// pstmt.setDouble(8, Double.parseDouble(food_protein));
					// pstmt.setDouble(9, Double.parseDouble(food_fat));
					// pstmt.setDouble(10, Double.parseDouble(food_sodium));
					// pstmt.setDouble(11, Double.parseDouble(food_sugar));

					pstmt.executeUpdate();

				}
				catch (Exception ex) {
					ex.printStackTrace();
					System.out.println(ex);
				}
				
				
				// 정보 확인용
				System.out.println(food_pk);
				System.out.println(food_name);
				System.out.println(food_category);
				System.out.println(food_metricname);
				System.out.println(food_metricgrams);
				System.out.println(food_calorie);
				// System.out.println(food_carb);
				// System.out.println(food_fat);
				// System.out.println(food_protein);
				// System.out.println(food_sodium);
				// System.out.println(food_sugar);
				System.out.println("DB 정보 입력 완료");
				*/

				// TODO 기존 화면 없어지게 하는 방법 필요
					// 변수를 받는 생성자와 그렇지 않은 생성자 생각해보기
				// 정보 입력 후 음식 검색 화면으로 돌아가기
				
				try {
					AppFoodSearch appFoodSearch = new AppFoodSearch();
					appFoodSearch.setVisible(true);

				} catch (Exception e1) {
					e1.printStackTrace();
				}
                
			}
		});
		
		
		setVisible(true);
		
	}

	/* TODO : 입력 전에 정보 맞는지 확인창 띄우는 작업 만들 예정
	public int checkbox(){
		int answer = JOptionPane.showConfirmDialog(this, "종료하시겠습니까?", "confirm",JOptionPane.YES_NO_OPTION );
		if(answer==JOptionPane.YES_OPTION){  //사용자가 yes를 눌렀을 경우
			System.out.println("프로그램을 종료합니다.");
		} else{  //사용자가 Yes 이외의 값을 눌렀을 경우
			System.out.println("종료를 취소합니다.");
		}
		return 1;
	}
	 */

	public static void main(String[] args) throws SQLException {
		
		new UploadFoodInfo();
		
	}
}