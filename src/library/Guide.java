package library;

import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;


import java.sql.*;
import java.util.Vector;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Guide extends JFrame {
    private JTable tableBorrow;
    private JTable tableNew;
    private JTable tableRecommend;
	public Guide() {
		setResizable(false);
        
		// �����ͷ
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
		
		setTitle("\u8BFB\u4E66\u6307\u5F15");
		setBounds(300,200,724,575);
		setIconImage(Toolkit.getDefaultToolkit().getImage("icon.jpg"));
		getContentPane().setLayout(null);
		JPanel panelBorrow=new JPanel();
		JPanel panelRecommend=new JPanel();
		JPanel panelNew=new JPanel();
		panelBorrow.setLayout(null);
		panelRecommend.setLayout(null);
		panelNew.setLayout(null);
		
		JTabbedPane tab = new JTabbedPane(JTabbedPane.TOP);
		tab.add("���Ž���",panelBorrow);
		
		JButton btnReturn1 = new JButton("\u8FD4\u56DE");
		btnReturn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new User().setVisible(true);
				dispose();
			}
		});
		btnReturn1.setBounds(318, 483, 93, 23);
		panelBorrow.add(btnReturn1);
		tab.add("�ݳ��Ƽ�",panelRecommend);
		
		JButton btnReturn2 = new JButton("\u8FD4\u56DE");
		btnReturn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new User().setVisible(true);
				dispose();
			}
		});
		btnReturn2.setBounds(318, 483, 93, 23);
		panelRecommend.add(btnReturn2);
		tab.add("����ͨ��",panelNew);
		panelNew.setLayout(null);
		
		JButton btnReturn3 = new JButton("\u8FD4\u56DE");
		btnReturn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new User().setVisible(true);
				dispose();
			}
		});
		btnReturn3.setBounds(318, 483, 93, 23);
		panelNew.add(btnReturn3);
		
		JScrollPane scroBorrow = new JScrollPane();
		scroBorrow.setBounds(10, 10, 693, 463);
		panelBorrow.add(scroBorrow);
		
		
		DefaultTableModel ModelBorrow = new DefaultTableModel();
		
		ModelBorrow.addColumn("ISBN���");
		ModelBorrow.addColumn("����");
		ModelBorrow.addColumn("����");
		ModelBorrow.addColumn("������");
		ModelBorrow.addColumn("������");
		ModelBorrow.addColumn("����λ��");
		
		try {
			      Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			} catch (Exception ex) {
				ex.printStackTrace();
				System.out.println("�����������ʧ�ܣ�");
			}
		try { 
				Connection con = DriverManager.getConnection("jdbc:odbc:MyODBC");
			    Statement st = con.createStatement();
			    ResultSet rsb = st.executeQuery("select * from ͼ����Ϣ order by ������ desc");
			    while (rsb.next())
			         {
			              Vector<String> RowB = new Vector<String>();
			              RowB.addElement(rsb.getString(1));
			              RowB.addElement(rsb.getString(2));
			              RowB.addElement(rsb.getString(3));
			              RowB.addElement(rsb.getString(4));
			              RowB.addElement(rsb.getString(5));
			              RowB.addElement(rsb.getString(6));
			                       
			              ModelBorrow.addRow(RowB); 
			          }
			        tableBorrow = new JTable();
			    	tableBorrow = new JTable(ModelBorrow);
			    	scroBorrow.setViewportView(tableBorrow);
			    	scroBorrow = new JScrollPane(); 
			        rsb.close();
			        st.close();
			        con.close();
			
			   } catch (Exception ex) {
			           ex.printStackTrace();
			           System.out.println("���ݿ�����ʧ�ܣ�");
			   }
			
		JScrollPane scroRecommend = new JScrollPane();
		scroRecommend.setBounds(10, 10, 693, 463);
		panelRecommend.add(scroRecommend);
		
		DefaultTableModel ModelRecommend = new DefaultTableModel();
		
		ModelRecommend.addColumn("ISBN���");
		ModelRecommend.addColumn("����");
		ModelRecommend.addColumn("����");
		ModelRecommend.addColumn("������");
		ModelRecommend.addColumn("����λ��");
		try {
			      Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			} catch (Exception ex) {
				ex.printStackTrace();
				System.out.println("�����������ʧ�ܣ�");
			}
		try { 
				Connection con = DriverManager.getConnection("jdbc:odbc:MyODBC");
			    Statement st = con.createStatement();
			    ResultSet rsr = st.executeQuery("select * from �ݳ��Ƽ�");
			    while (rsr.next())
			         {
			              Vector<String> RowR = new Vector<String>();
			              RowR.addElement(rsr.getString(1));
			              RowR.addElement(rsr.getString(2));
			              RowR.addElement(rsr.getString(3));
			              RowR.addElement(rsr.getString(4));
			              RowR.addElement(rsr.getString(5));
			  
			              
			              ModelRecommend.addRow(RowR); 
			          }
			        tableRecommend = new JTable();
			    	tableRecommend = new JTable(ModelRecommend);
			    	scroRecommend.setViewportView(tableRecommend);
			    	scroRecommend = new JScrollPane(); 
			        rsr.close();
			        st.close();
			        con.close();
			
			   } catch (Exception ex) {
			           ex.printStackTrace();
			           System.out.println("���ݿ�����ʧ�ܣ�");
			   } 
		 
		JScrollPane scroNew = new JScrollPane();
		scroNew.setBounds(10, 10, 693, 463);
		panelNew.add(scroNew);
		
		DefaultTableModel ModelNew = new DefaultTableModel();
		
		ModelNew.addColumn("ISBN���");
		ModelNew.addColumn("����");
		ModelNew.addColumn("����");
		ModelNew.addColumn("������");
		ModelNew.addColumn("����λ��");
		ModelNew.addColumn("��������");
		
		try {
			      Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			} catch (Exception ex) {
				ex.printStackTrace();
				System.out.println("�����������ʧ�ܣ�");
			}
		try { 
				Connection con = DriverManager.getConnection("jdbc:odbc:MyODBC");
			    Statement st = con.createStatement();
			    ResultSet rsn = st.executeQuery("select * from ����ͨ��");
			    while (rsn.next())
			         {
			              Vector<String> RowN= new Vector<String>();
			              RowN.addElement(rsn.getString(1));
			              RowN.addElement(rsn.getString(2));
			              RowN.addElement(rsn.getString(3));
			              RowN.addElement(rsn.getString(4));
			              RowN.addElement(rsn.getString(5));
			              RowN.addElement(rsn.getString(6));
			                  
			              ModelNew.addRow(RowN); 
			          }
			        tableNew = new JTable();
			    	tableNew = new JTable(ModelNew);
			    	scroNew.setViewportView(tableNew);
			    	scroNew = new JScrollPane(); 
			        rsn.close();
			        st.close();
			        con.close();
			
			   } catch (Exception ex) {
			           ex.printStackTrace();
			           System.out.println("���ݿ�����ʧ�ܣ�");
			   } 	
		tab.setBounds(0, 0, 718, 546);
		getContentPane().add(tab);
		
	}
}