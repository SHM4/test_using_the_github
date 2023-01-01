package teampl;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.event.*;

public class UploadFoodInfo2 extends JFrame{
	
	String food_name;
	String food_category;
	String food_metricname;
	String food_metricgrams;
	String food_calorie;
	String food_carb;
	String food_fat;
	String food_protein;
	String food_sodium;
	
	JComboBox<String> food_category_combo;
	String food_category_list[] = {"구이류", "국 및 탕류"};
	JComboBox<String> food_metricname_combo;
	String food_metricname_list[] = {"1인분", "개", "컵", "판", "조각"};
	// 콤보박스 구현
	
	UploadFoodInfo2() {
		setTitle("음식 정보 입력");
		Container c = getContentPane();
		setVisible(true);
		c.setLayout(null);
		setSize(560, 735);

		JPanel topPane = new JPanel();
		
		JLabel jl1 = new JLabel("1. 음식 이름을 입력해주세요.");
		JLabel jl2 = new JLabel("2. 음식의 카테고리(분류)를 선택해주세요.");		
		JLabel jl3 = new JLabel("3. 음식의 1회 제공량을 선택해주세요.");
		JLabel jl4 = new JLabel("4. 1회 제공량의 분량(g)을 입력해주세요.");
		JLabel jl5 = new JLabel("5. 1회 제공량의 칼로리 양(kcal)를 입력해주세요.");
		JLabel jl6 = new JLabel("6. 1회 제공량의 탄수화물 양(g)을 입력해주세요.");
		JLabel jl7 = new JLabel("7. 1회 제공량의 지방 양(g)을 입력해주세요.");
		JLabel jl8 = new JLabel("8. 1회 제공량의 단백질 양(g)을 입력해주세요.");
		JLabel jl9 = new JLabel("9. 1회 제공량의 나트륨 양(mg)을 입력해주세요.");
		
		JTextArea jt1 = new JTextArea();
		food_category_combo = new JComboBox(food_category_list);
		food_metricname_combo = new JComboBox(food_metricname_list);
		JTextArea jt4 = new JTextArea();
		JTextArea jt5 = new JTextArea();
		JTextArea jt6 = new JTextArea();
		JTextArea jt7 = new JTextArea();
		JTextArea jt8 = new JTextArea();
		JTextArea jt9 = new JTextArea();
		
		JButton jb1 = new JButton("확인");
		
		Font font = new Font("궁서 보통", Font.BOLD, 20);
		
		jl1.setFont(font);
		jl2.setFont(font);
		jl3.setFont(font);
		jl4.setFont(font);
		jl5.setFont(font);
		jl6.setFont(font);
		jl7.setFont(font);
		jl8.setFont(font);
		jl9.setFont(font);
		
		jt1.setFont(font);
		food_category_combo.setFont(font);
		food_metricname_combo.setFont(font);
		jt4.setFont(font);
		jt5.setFont(font);
		jt6.setFont(font);
		jt7.setFont(font);
		jt8.setFont(font);
		jt9.setFont(font);
		
		jb1.setFont(font);
		
		Color MainColor = new Color(3, 199, 90);
		// HEX 코드 #03c75a, RGB 코드 3, 199, 90

		topPane.setBackground(MainColor);
		
		jt1.setBorder(new LineBorder(MainColor, 2));
		food_category_combo.setBorder(new LineBorder(MainColor, 2));
		food_metricname_combo.setBorder(new LineBorder(MainColor, 2));
		jt4.setBorder(new LineBorder(MainColor, 2));
		jt5.setBorder(new LineBorder(MainColor, 2));
		jt6.setBorder(new LineBorder(MainColor, 2));
		jt7.setBorder(new LineBorder(MainColor, 2));
		jt8.setBorder(new LineBorder(MainColor, 2));
		jt9.setBorder(new LineBorder(MainColor, 2));
		
		jb1.setBorder(new LineBorder(MainColor, 2));
		// 버튼 테두리 색과 두께 설정
		
		food_category_combo.setBackground(Color.white);
		food_metricname_combo.setBackground(Color.white);
		
		// jl1.setOpaque(true);
		// JLabel에 색을 넣기 위한 코드. 일단 비활성화.
		
		topPane.setBounds(0, 0, 560, 30);
		
		jl1.setBounds(45, 30, 500, 40);
		jl2.setBounds(45, 100, 500, 40);
		jl3.setBounds(45, 170, 500, 40);
		jl4.setBounds(45, 240, 500, 40);
		jl5.setBounds(45, 310, 500, 40);
		jl6.setBounds(45, 380, 500, 40);
		jl7.setBounds(45, 450, 500, 40);
		jl8.setBounds(45, 520, 500, 40);
		jl9.setBounds(45, 590, 500, 40);
		
		jt1.setBounds(45, 70, 450, 30);
		food_category_combo.setBounds(45, 140, 450, 30);
		food_metricname_combo.setBounds(45, 210, 450, 30);
		jt4.setBounds(45, 280, 450, 30);
		jt5.setBounds(45, 350, 450, 30);
		jt6.setBounds(45, 420, 450, 30);
		jt7.setBounds(45, 490, 450, 30);
		jt8.setBounds(45, 560, 450, 30);
		jt9.setBounds(45, 630, 450, 30);
		
		jb1.setBounds(415, 665, 80, 30);
		
		c.add(topPane);
		
		c.add(jl1);
		c.add(jl2);
		c.add(jl3);
		c.add(jl4);
		c.add(jl5);
		c.add(jl6);
		c.add(jl7);
		c.add(jl8);
		c.add(jl9);
		
		c.add(jt1);
		c.add(food_category_combo);		
		c.add(food_metricname_combo);
		c.add(jt4);
		c.add(jt5);
		c.add(jt6);
		c.add(jt7);
		c.add(jt8);
		c.add(jt9);
		
		c.add(jb1);
		
		jb1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// food_pk = DB에서 가장 마지막 food_pk 번호+1
				food_name = jt1.getText();
				food_category =  (String)food_category_combo.getSelectedItem();
				food_metricname = (String)food_metricname_combo.getSelectedItem();
				food_metricgrams = jt4.getText();
				food_calorie = jt5.getText();
				food_carb = jt6.getText();
				food_fat = jt7.getText();
				food_protein = jt8.getText();
				food_sodium = jt9.getText();
			}
		});
	}

	public static void main(String[] args) {
		
		new UploadFoodInfo2();
		
	}
}
// 더 구현해야 하는 것들
// 정보 전부 입력하면 food_pk 기존 마지막 번호 다음 번호 자동 생성 필요
// 입력 받은 값을 DB에 입력하는 코드 필요
// 내용 입력 안 하면 null 값으로 처리?

// 제안할 부분
// 당분 항목 추가

// 더 생각해 볼 부분
// 전부 빈 칸으로 입력할 수 없도록 음식 이름, 카테고리, 제공량은 필수 입력 사항 처리 필요
// 정보 삭제 기능 필요. 구현한다면 기존 입력값은 삭제할 수 없도록, 또는 수정 가능도록.