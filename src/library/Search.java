package library;

import javax.swing.JFrame;

import java.sql.*;
import java.util.Vector;
import java.awt.Toolkit;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.Spring;

import java.awt.Color;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class Search extends JFrame {
	private JTextField txtSearch;
	
	String s;

	public Search() {
		setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
		setBounds(500,300,630,495);
		setTitle("\u56FE\u4E66\u68C0\u7D22");
		getContentPane().setBackground(Color.WHITE);
		setIconImage(Toolkit.getDefaultToolkit().getImage("icon.jpg"));
		
		final JComboBox cbbChoose=new JComboBox();
		cbbChoose.setBounds(50, 38, 114, 21);
	
		getContentPane().setLayout(null);
		cbbChoose.setModel(new DefaultComboBoxModel(new String[] {"ISBN���", "����", "����", "������"}));
		cbbChoose.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	s=(String)cbbChoose.getSelectedItem();
		    }
		});
			
		
		
		cbbChoose.setToolTipText("");
		getContentPane().add(cbbChoose);
		
		txtSearch = new JTextField();
		txtSearch.setBounds(234, 38, 272, 21);
		getContentPane().add(txtSearch);
		txtSearch.setColumns(10);
		

			
		
		
		JButton btnReturn = new JButton("\u8FD4\u56DE");
		btnReturn.setBounds(365, 434, 93, 23);
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new User().setVisible(true);
				dispose();
			}
		});
		getContentPane().add(btnReturn);
		
		JButton btnSearch = new JButton("\u68C0\u7D22");
		btnSearch.setBounds(158, 434, 93, 23);
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DefaultTableModel Model = new DefaultTableModel();
				
				Model.addColumn("ISBN���");
				Model.addColumn("����");
				Model.addColumn("����");
				Model.addColumn("������");
				Model.addColumn("������");
				Model.addColumn("����λ��");
				Model.addColumn("��������");
				try {
					      Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					} catch (Exception ex) {
						ex.printStackTrace();
						System.out.println("�����������ʧ�ܣ�");
					}
				try { 
						Connection con = DriverManager.getConnection("jdbc:odbc:MyODBC");
					    Statement st = con.createStatement();
					    String sid=txtSearch.getText(); 	   
					    ResultSet rs = st.executeQuery("select * from ͼ����Ϣ where "+s+"='"+sid+"'");  
					    while (rs.next())
					         {
					              Vector<String> Row = new Vector<String>();
					              Row.addElement(rs.getString(1));
					              Row.addElement(rs.getString(2));
					              Row.addElement(rs.getString(3));
					              Row.addElement(rs.getString(4));
					              Row.addElement(rs.getString(5));
					              Row.addElement(rs.getString(6));
					              Row.addElement(String.valueOf(rs.getDate(7)));
					              
					              Model.addRow(Row); 
					          }
					        rs.close();
					        st.close();
					        con.close();
					   } catch (Exception ex) {
					           ex.printStackTrace();
					           System.out.println("���ݿ�����ʧ�ܣ�");
					   }
				JScrollPane scro = new JScrollPane();
				JTable table = new JTable(Model);
				scro.setViewportView(table);
				scro.setBounds(32, 80, 561, 346);
				getContentPane().add(scro);
			}
		});
		
		getContentPane().add(btnSearch);
	}
}