package library;

import java.awt.Toolkit;

import javax.swing.JFrame;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.util.Vector;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Remind extends JFrame {
	private JTable table;
	static String username;
	public Remind() {
		setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
		setTitle("\u8FD8\u4E66\u63D0\u9192");
		setBounds(500,300,662,519);
		setIconImage(Toolkit.getDefaultToolkit().getImage("icon.jpg"));
		
		JButton btnReturn = new JButton("\u8FD4\u56DE");
		btnReturn.setBounds(281, 458, 93, 23);
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new User().setVisible(true);
				dispose();
			}
		});
		getContentPane().setLayout(null);
		getContentPane().add(btnReturn);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(33, 44, 592, 404);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		

		DefaultTableModel Model = new DefaultTableModel();
		
		Model.addColumn("ISBN���");
		Model.addColumn("����");
		Model.addColumn("��������");
		Model.addColumn("��ǰ����");
		Model.addColumn("�ѽ�����");

		try {
			      Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			} catch (Exception ex) {
				ex.printStackTrace();
				System.out.println("�����������ʧ�ܣ�");
			}
		try { 
				Connection con = DriverManager.getConnection("jdbc:odbc:MyODBC");
			    Statement st = con.createStatement();
			    ResultSet rs = st.executeQuery("select ISBN���,����,��������,date(),date()-�������� from "+User.username+"");  
			    while (rs.next())
			         {
			              Vector<String> Row = new Vector<String>();
			              Row.addElement(rs.getString(1));
			              Row.addElement(rs.getString(2));
			              Row.addElement(String.valueOf(rs.getDate(3)));
			              Row.addElement(String.valueOf(rs.getDate(4)));
			              Row.addElement(String.valueOf(rs.getInt(5)));
			                  
			              Model.addRow(Row); 
			          }
		
			        rs.close();
			        st.close();
			        con.close();
			
			   } catch (Exception ex) {
			           ex.printStackTrace();
			           System.out.println("���ݿ�����ʧ�ܣ�");
			   }
		table = new JTable();
		table = new JTable(Model);
		scrollPane.setViewportView(table);
	}
}


