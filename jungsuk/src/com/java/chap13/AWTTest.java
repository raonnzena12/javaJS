package com.java.chap13;

import java.awt.*;
import java.awt.event.*;

public class AWTTest {
	public AWTTest() {}
	
	public void frame1() {
		Frame f = new Frame("Login");
		f.setSize(300, 200);
		f.setVisible(true);
	}
	
	public void frame2() {
		Frame f = new Frame("Login");
		f.setSize(300,200);
		
		Toolkit tk = Toolkit.getDefaultToolkit(); // 구현된 Toolkit객체를 얻는다.
		Dimension screenSize = tk.getScreenSize(); // 화면의 크기를 구한다.
		
		// 회면크기의 절반값에서 Frame크기의 절반값을 뺀 위치로 하면
		// Frame이 화면 가운데 위치하게 된다.
		
		f.setLocation(screenSize.width/2 - 150, screenSize.height/2 -100);
		f.setVisible(true);
	}
	
	public void button1() {
		Frame f = new Frame("Login");
		f.setSize(300,200);
		
		Button b = new Button("submit");
		b.setSize(100,50);
		
		f.add(b);
		f.setVisible(true);
	}
	
	public void button2() {
		Frame f = new Frame("Login");
		f.setSize(300,200);
		f.setLayout(null); // 레이아웃 매니저의 설정을 해제한다.
		
		Button b = new Button("확인");
		b.setSize(100,50);
		b.setLocation(100, 75); // Frame내에서의 Button 위치를 설정한다.
		
		f.add(b);
		f.setVisible(true);
	}
	
	public void choice1() {
		Frame f = new Frame("Choice-Select");
		f.setSize(300,200);
		f.setLayout(null);
		
		Choice day = new Choice(); // Choice객체를 생성한 다음
		day.add("SUN");
		day.add("MON");
		day.add("TUE");
		day.add("WED");
		day.add("THU");
		day.add("FRI");
		day.add("SAT");
		
		day.setSize(100,50);
		day.setLocation(100, 70);
		
		f.add(day);
		f.setVisible(true);
	}
	
	public void list1() {
		Frame f = new Frame("List-select");
		f.setSize(300,200);
		f.setLayout(null);
		
		List selectOne = new List(6);
		selectOne.setLocation(20,40);
		selectOne.setSize(100,120);
		selectOne.add("Student");
		selectOne.add("teacher");
		selectOne.add("Driver");
		selectOne.add("Computer Programmer");
		selectOne.add("Sales Man");
		selectOne.add("Musician");
		selectOne.add("Director");
		
		// 생성자의 두번쨰 인자값을 true로 설정해서 List의 목록에서 여러개를 선택할 수 있게 했다.
		List selectMany = new List(6, true);
		selectMany.setLocation(150,40);
		selectMany.setSize(100, 120);
		selectMany.add("Student");
		selectMany.add("teacher");
		selectMany.add("Driver");
		selectMany.add("Computer Programmer");
		selectMany.add("Sales Man");
		selectMany.add("Musician");
		selectMany.add("Director");
		
		f.add(selectOne);
		f.add(selectMany);
		f.setVisible(true);
	}
	
	public void label1() {
		Frame f = new Frame("test");
		f.setSize(300,200);
		f.setLayout(null);
		
		Label id = new Label("Id : "); // Label을 생성하고 크기와 위치를 지정한다.
		id.setBounds(50, 50, 30, 10); // 50,50 위치에 크기가 가로30 세로 10
		
		Label pwd = new Label("Pwd : ");
		pwd.setBounds(50,65,100,10);
		
		f.add(id);
		f.add(pwd);
		f.setVisible(true);
	}
	
	public void checkbox1() {
		Frame f = new Frame("Questions");
		f.setSize(305,250);
		// Frame의 LayoutManager를 FlowLayout으로 설정한다.
		f.setLayout(new FlowLayout());
		
		Label q1 = new Label("1. 당신의 관심 분야는?(여러개 선택 가능)");
		Checkbox news = new Checkbox("news", true);
		Checkbox sports = new Checkbox("sports");
		Checkbox movies = new Checkbox("movies");
		Checkbox music = new Checkbox("music");
		
		f.add(q1);
		f.add(news);
		f.add(sports);
		f.add(movies);
		f.add(music);
		
		Label q2 = new Label("2. 얼마나 자주 극장에 가십니까?");
		CheckboxGroup g1 = new CheckboxGroup();
		Checkbox movie1 = new Checkbox("한달에 한번", g1, true);
		Checkbox movie2 = new Checkbox("일주일에 한번", g1, false);
		Checkbox movie3 = new Checkbox("일주일에 두번", g1, false);
		
		f.add(q2);
		f.add(movie1);
		f.add(movie2);
		f.add(movie3);
		
		Label q3 = new Label("3. 하루에 얼마나 컴포터를 사용하십니까?");
		CheckboxGroup g2 = new CheckboxGroup();
		Checkbox com1 = new Checkbox("5시간 이하", g2, true);
		Checkbox com2 = new Checkbox("10시간 이하", g2, false);
		Checkbox com3 = new Checkbox("15시간 이상", g2, false);
		
		f.add(q3);
		f.add(com1);
		f.add(com2);
		f.add(com3);
		f.setVisible(true);
	}
	
	public void textField1() {
		Frame f = new Frame("textField");
		f.setSize(400,65);
		f.setLayout(new FlowLayout());
		
		Label lid = new Label("Id :", Label.RIGHT);
		Label lpwd = new Label("Password :" , Label.RIGHT);
		
		TextField id = new TextField(10);
		TextField pwd = new TextField(10);
		pwd.setEchoChar('*'); // 입력한 값 대신 '*'가 보이도록 한다.
		
		f.add(lid);
		f.add(id);
		f.add(lpwd);
		f.add(pwd);
		f.setVisible(true);
	}
	
	public void textArea1() {
		Frame f = new Frame("Comments");
		f.setSize(400,220);
		f.setLayout(new FlowLayout());
		
		TextArea comments = new TextArea("하고싶은 말을 적으세요", 10, 50);
		f.add(comments);
		comments.selectAll();
		f.setVisible(true);
	}
	
	public void scrollbar1() {
		Frame f = new Frame("Scrollbar");
		f.setSize(300,200);
		f.setLayout(null);
		
		Scrollbar hor = new Scrollbar(Scrollbar.HORIZONTAL, 0, 50, 0, 100);
		hor.setSize(100, 15);
		hor.setLocation(60, 30);
		Scrollbar ver = new Scrollbar(Scrollbar.VERTICAL, 50, 20, 0, 100 );
		ver.setSize(15, 100);
		ver.setLocation(30, 30);
		
		f.add(hor);
		f.add(ver);
		f.setVisible(true);
	}
	
	public void canvas1() {
		Frame f = new Frame("canvasTest");
		f.setSize(300,200);
		f.setLayout(null);
		
		Canvas c = new Canvas();
		c.setBackground(Color.pink);
		c.setBounds(50, 50, 150, 100);
		
		f.add(c);
		f.setVisible(true);
	}
	
	public void panel1() {
		Frame f = new Frame("panel");
		f.setSize(300,200);
		f.setLayout(null);
		
		Panel p = new Panel();
		p.setBackground(Color.green);
		p.setSize(100,100);
		p.setLocation(50,50);
		
		Button ok = new Button("OK");
		
		p.add(ok);
		f.add(p);
		f.setVisible(true);
	}
	
	public void scrollPane1() {
		Frame f = new Frame("scrollPane");
		f.setSize(300,200);
		
		ScrollPane sp = new ScrollPane();
		Panel p = new Panel();
		p.setBackground(Color.green);
		p.add(new Button("1st"));
		p.add(new Button("2nd"));
		p.add(new Button("3rd"));
		p.add(new Button("4th"));
		
		sp.add(p);
		f.add(sp);
		f.setVisible(true);
	}
	
	public void dialog1() {
		Frame f = new Frame("parent");
		f.setSize(300, 200);
		
		// parent frame 을 f로 하고, modal을 true로 해서 필수응답 dialog로 함
		Dialog info = new Dialog(f, "Information", true);
		info.setSize(140,90);
		info.setLocation(50,50); // parent frame이 아닌, 화면이 위치의 기준이 된다.
		info.setLayout(new FlowLayout());
		
		Label msg = new Label("This is modal Dialog", Label.CENTER);
		Button ok = new Button("OK");
		info.add(msg);
		info.add(ok);
		
		f.setVisible(true);
		info.setVisible(true);
	}
	
	public void dialog2() {
		Frame f = new Frame("parent");
		f.setSize(300,200);
		
		final Dialog info = new Dialog(f, "infomation", true);
		info.setSize(400,200);
		info.setLocation(50,50);
		info.setLayout(new FlowLayout());
		
		Label msg = new Label("This is modal Dialog", Label.CENTER);
		Button ok = new Button("OK");
		
		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				info.dispose();
			}
		});
		info.add(msg);
		info.add(ok);
		f.setVisible(true);
		info.setVisible(true);
	}
	
	public void fileDialog1() {
		Frame f = new Frame("parent");
		f.setSize(300,200);
		
		FileDialog fileOpen = new FileDialog(f, "파일열기", FileDialog.LOAD);
		
		f.setVisible(true);
		fileOpen.setDirectory("c:\\");
		fileOpen.setVisible(true);
		
		// 파일을 선택한 다음, FIleDialog의 열기버튼을 누르면,
		// getFile()과 getDirectory()를 이용해서 파일이름과 위치한 경로를 얻을 수 있다.
		
		System.out.println(fileOpen.getDirectory() + fileOpen.getFile());
	}
	
	public void fontList() {
		GraphicsEnvironment ge = null;
		ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		Font[] fonts = ge.getAllFonts();
		
		for ( int i = 0 ; i < fonts.length ; i++ ) {
			System.out.println(fonts[i].getFontName());
		}
	}
	
	public void fontTest() {
		Frame f = new Frame("font test");
		String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
		// A 부터 Z를 내용으로 갖는 Label들을 생성한다.
		Label abc1 = new Label(abc);
		Label abc2 = new Label(abc);
		Label abc3 = new Label(abc);
		Label abc4 = new Label(abc);
		Label abc5 = new Label(abc);
		
		// Serif체이며, 크기가 20인 Font
		Font f1 = new Font("Serif", Font.PLAIN, 20);
		Font f2 = new Font("Serif", Font.ITALIC, 20);
		Font f3 = new Font("Serif", Font.BOLD, 20);
		Font f4 = new Font("Serif", Font.BOLD+Font.ITALIC, 20);
		
		abc1.setFont(f1);
		abc2.setFont(f2);
		abc3.setFont(f3);
		abc4.setFont(f4);
		
		f.setLayout(new FlowLayout());
		f.add(abc1);
		f.add(abc2);
		f.add(abc3);
		f.add(abc4);
		f.add(abc5);
		
		f.setSize(400,200);
		f.setVisible(true);
	}
	
	public void color1() {
		Frame f = new Frame("color test");
		f.setLayout(new GridLayout(14, 2));
		Panel p1 = new Panel(); p1.setBackground(Color.black);
		Panel p2 = new Panel(); p2.setBackground(Color.blue);
		Panel p3 = new Panel(); p3.setBackground(Color.cyan);
		Panel p4 = new Panel(); p4.setBackground(Color.darkGray);
		Panel p5 = new Panel(); p5.setBackground(Color.gray);
		Panel p6 = new Panel(); p6.setBackground(Color.green);
		Panel p7 = new Panel(); p7.setBackground(Color.lightGray);
		Panel p8 = new Panel(); p8.setBackground(Color.magenta);
		Panel p9 = new Panel(); p9.setBackground(Color.orange);
		Panel p10 = new Panel(); p10.setBackground(Color.pink);
		Panel p11 = new Panel(); p11.setBackground(Color.red);
		Panel p12 = new Panel(); p12.setBackground(Color.white);
		Panel p13 = new Panel(); p13.setBackground(Color.yellow);
		Panel p14 = new Panel(); p14.setBackground(new Color(50,100,100));
		
		f.add(new Label("Color.black")); f.add(p1);
		f.add(new Label("Color.blue")); f.add(p2);
		f.add(new Label("Color.cyan")); f.add(p3);
		f.add(new Label("Color.darkGray")); f.add(p4);
		f.add(new Label("Color.gray")); f.add(p5);
		f.add(new Label("Color.green")); f.add(p6);
		f.add(new Label("Color.lightGray")); f.add(p7);
		f.add(new Label("Color.magenta")); f.add(p8);
		f.add(new Label("Color.orange")); f.add(p9);
		f.add(new Label("Color.pink")); f.add(p10);
		f.add(new Label("Color.red")); f.add(p11);
		f.add(new Label("Color.white")); f.add(p12);
		f.add(new Label("Color.yellow")); f.add(p13);
		f.add(new Label("Color(50,100,100)")); f.add(p14);
		f.setSize(250,300);
		f.setVisible(true);
	}
	
	public void menu1() {
		Frame f = new Frame("frame with Menu");
		f.setSize(300,200);
		
		MenuBar mb = new MenuBar();
		Menu mFile = new Menu("File");
		
		MenuItem miNew = new MenuItem("NEW");
		MenuItem miOpen = new MenuItem("OPEN");
		Menu mOthers = new Menu("OTHERS");
		MenuItem miExit = new MenuItem("EXIT");
		
		mFile.add(miNew);
		mFile.add(miOpen);
		mFile.add(mOthers);
		mFile.addSeparator();
		mFile.add(miExit);
		
		MenuItem miPrint = new MenuItem("PRINT . . .");
		MenuItem miPreview = new MenuItem("Print Preview");
		MenuItem miSetup = new MenuItem("Print Setup . . .");
		mOthers.add(miPrint);
		mOthers.add(miPreview);
		mOthers.add(miSetup);
		
		Menu mEdit = new Menu("EDIT");
		Menu mView = new Menu("View");
		Menu mHelp = new Menu("HELP");
		CheckboxMenuItem miStatusbar = new CheckboxMenuItem("StatusBar");
		mView.add(miStatusbar);
		
		mb.add(mFile);
		mb.add(mEdit);
		mb.add(mView);
		mb.setHelpMenu(mHelp);
		
		f.setMenuBar(mb);
		f.setVisible(true);
	}
	
	public void popupMenu1() {
		final Frame f = new Frame("popupMenu test");
		f.setSize(300,200);
		
		final PopupMenu pMenu = new PopupMenu("EDIT");
		MenuItem miCut = new MenuItem("CUT");
		MenuItem miCopy = new MenuItem("COPY");
		MenuItem miPaste = new MenuItem("PASTE");
		pMenu.add(miCut);
		pMenu.add(miCopy);
		pMenu.add(miPaste);
		
		f.add(pMenu);
		f.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent me) {
				if ( me.getModifiers() == me.BUTTON3_MASK) pMenu.show(f, me.getX(), me.getY());
			}
		});
		f.setVisible(true);
	}
	
	public void borderlayout1() {
		Frame f = new Frame("borderLayoutTest");
		f.setSize(200,200);
		f.setLayout(new BorderLayout());
		Button north = new Button("North");
		Button south = new Button("South");
		Button east = new Button("East");
		Button west = new Button("West");
		Button center = new Button("Center");
		
		// Frame의 각 5개의 영역에 Button을 하나씩 추가한다.
		f.add(north, "North");
		f.add(south, "South");
		f.add(east, "East");
		f.add(west, "West");
		f.add(center, "Center");
		f.setVisible(true);
	}
	
	public void flowLayout1() {
		Frame f = new Frame("FlowLayout");
		f.setSize(250,100);
		f.setLayout(new FlowLayout(FlowLayout.LEFT));
		f.add(new Button("1ST"));
		f.add(new Button("2ND"));
		f.add(new Button("3RD"));
		f.add(new Button("4TH"));
		f.add(new Button("5th"));
		f.setVisible(true);
	}
	
	public void gridLayout1() {
		Frame f = new Frame("GridLayoutTest");
		f.setSize(150,150);
		f.setLayout(new GridLayout(3,2));
		f.add(new Button("1"));
		f.add(new Button("2"));
		f.add(new Button("3"));
		f.add(new Button("4"));
		f.add(new Button("5"));
		f.add(new Button("6"));
		f.setVisible(true);
	}
	
	public void cardLayout1() {
		final Frame f = new Frame("CardLayout");
		final CardLayout card = new CardLayout(10,10);
		f.setLayout(card);
		
		Panel card1 = new Panel();
		card1.setBackground(Color.LIGHT_GRAY);
		card1.add(new Label("Card 1"));
		Panel card2 = new Panel();
		card2.add(new Label("Card 2"));
		card2.setBackground(Color.orange);
		Panel card3 = new Panel();
		card3.add(new Label("Card 3"));
		card3.setBackground(Color.cyan);
		f.add(card1, "1");
		f.add(card2, "2");
		f.add(card3, "3");
		
		class Handler extends MouseAdapter {
			public void mouseClicked(MouseEvent e) {
				if ( e.getModifiers() == e.BUTTON3_MASK) {
					card.previous(f);
				} else {
					card.next(f);
				}
			}
		}
		
		card1.addMouseListener(new Handler());
		card2.addMouseListener(new Handler());
		card3.addMouseListener(new Handler());
		f.setSize(200,200);
		f.setLocation(200,200);
		
		f.setVisible(true);
		card.show(f, "1");
	}
	
	public void calc() {
		Frame f = new Frame("계산기");
		TextField tf = new TextField("0");
		tf.setEditable(false);
		f.setSize(190,160);
		f.setLocation(300,300);
		
		f.add("North", tf);
		Panel numPanel = new Panel();
		Button[] numButtons = null;
		numPanel.setLayout(new GridLayout(4,5,4,4));
		numPanel.setBackground(Color.LIGHT_GRAY);
		f.add("Center", numPanel);
		
		String numStr[] = { "7", "8","9","/","CE", "4","5","6","*","BS", "1","2","3","-","1/x","0","+/-",".","+","="};
		numButtons = new Button[numStr.length];
		for ( int i = 0 ; i <numStr.length; i++ ) {
			numButtons[i] = new Button(numStr[i]);
			numButtons[i].setForeground(Color.blue);
			numPanel.add(numButtons[i]);
		}
		
		f.setResizable(false);
		f.setVisible(true);
	}
	
	public void frame3() {
		Frame f = new Frame("login");
		f.setSize(300,200);
		
		f.addWindowListener(new EventHandler3());
		f.setVisible(true);
	}
	
	class EventHandler3 implements WindowListener {
		public void windowOpened(WindowEvent e) {}
		public void windowClosing(WindowEvent e) {
			e.getWindow().setVisible(false);
			e.getWindow().dispose();
			System.exit(0);
		}
		public void windowIconified(WindowEvent e) {}
		public void windowActivated(WindowEvent e) {}
		public void windowDeactivated(WindowEvent e) {}
		public void windowClosed(WindowEvent arg0) {
		}
		public void windowDeiconified(WindowEvent e) {
		}
	}
}
