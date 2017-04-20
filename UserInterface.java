import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextPane;

public class UserInterface {
	
	/*
	 * Semester - "FA" or "SP" 
	 * Year - "16"
	 * Department - full name
	 */

	public JFrame start_frame = new JFrame();
	public static int START_DIMEN_X = 400, START_DIMEN_Y = 400;
	public ArrayList<String> selected_classes = new ArrayList<String>();
	public String semester, year; //Semester is FA or SP, year is only last two digits i.e. 17
	
	public void startMenu(){
		semester = "FA";
		year = "17";
		start_frame.setSize(START_DIMEN_X, START_DIMEN_Y);
		start_frame.setVisible(true);
		start_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		start_frame.setLayout(new GridBagLayout());
		
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.fill = GridBagConstraints.HORIZONTAL;
		
		
		//--------------Department List------------------
		JPanel department_panel = new JPanel(new GridLayout(2,0));
		department_panel.setPreferredSize(new Dimension(START_DIMEN_X/2,START_DIMEN_Y));
		
		final DefaultListModel department_list_model = new DefaultListModel();
		JList department_list = new JList(department_list_model);
		
		JButton remove_button = new JButton("Remove Selected Item");
		remove_button.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//department_list.getSelectedIndex();
				int toRemove = department_list.getSelectedIndex();
				department_list_model.remove(toRemove);
			}
		});
		
		department_panel.add(department_list);
		department_panel.add(remove_button);
		department_panel.setVisible(true);
		

		constraints.fill = GridBagConstraints.VERTICAL;
		constraints.anchor = GridBagConstraints.EAST;
		constraints.weighty = 1.0;
		constraints.gridx = 1;
		constraints.gridy = 0;
		start_frame.add(department_panel, constraints);
		constraints.fill = GridBagConstraints.NONE;
		constraints.anchor = GridBagConstraints.NORTH;
		
		
		//--------------Semester ComboBox------------------
		String[] semester_strings = { "FALL", "SPRING" };

		JComboBox<String> semester_list = new JComboBox<String>(semester_strings);
		semester_list.setSelectedIndex(0);
		semester_list.setVisible(true);
		semester_list.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(semester_list.getSelectedItem() == "FALL") semester = "FA";
				else semester = "SP";
			}
	      });
		constraints.weighty = 0.0;
		constraints.weightx = 0.0;
		constraints.gridx = 0;
		constraints.gridy = 0;
		start_frame.add(semester_list, constraints);
		
		
		//---------------Year ComboBox--------------------
		String[] year_strings = { "2017", "2018", "2019", "2020" };
		
		JComboBox<String> year_list = new JComboBox<String>(year_strings);
		year_list.setSelectedIndex(0);
		year_list.setVisible(true);
		year_list.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String long_year = year_list.getSelectedItem().toString();
				year = long_year.substring(long_year.length() - 2);
				System.out.println(getSemesterYear());
			}
	      });
		constraints.weighty = 0.0;
		constraints.weightx = 0.0;
		constraints.gridx = 0;
		constraints.gridy = 1;
		start_frame.add(year_list, constraints);
		
		
		//--------------Department ComboBox----------------
		String[] department_strings = { "HONORS CLASSES", "AMERICAN STUDIES", "ANTHROPOLOGY", "ART/ART HISTORY", "BIOLOGY", "BLACK STUDIES", "BUSINESS MANAGEMENT", "CHEMISTRY", "CHINESE", "CHESAPEAKE REGIONAL STUDIES", "COMPUTER SCIENCE", "DANCE", "ECONOMICS", "EDUCATION", "ENGLISH LANGUAGE LEARNING", "ENGLISH", "ENVIRONMENTAL SCIENCE/STUDIES", "FRENCH STUDIES", "GENDER STUDIES", "GERMAN STUDIES", "GLOBAL PERSPECTIVES", "HISTORY", "HISPANIC STUDIES", "INT'L LITERATURE & CULTURE", "INTERNATIONAL STUDIES", "MATHEMATICS", "MUSIC", "PHYSICAL EDUCATION", "PHILOSOPHY", "PHYSICS", "POLITICAL SCIENCE", "PSYCHOLOGY", "SOCIOLOGY", "THEATRE"};
		
		JComboBox<String> department_combo_box = new JComboBox<String>(department_strings);
		department_combo_box.setSelectedIndex(0);
		department_combo_box.setVisible(true);
		department_combo_box.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				selected_classes.add((String) department_combo_box.getSelectedItem());
				department_list_model.addElement(department_combo_box.getSelectedItem());
				System.out.println(getDepartments());
			}
	      });
		constraints.weighty = 0.0;
		constraints.weightx = 0.0;
		constraints.gridx = 0;
		constraints.gridy = 2;
		start_frame.add(department_combo_box, constraints);
		
		
		
		start_frame.revalidate();
		//start_frame.pack();
		start_frame.repaint();
	}
	
	public String getSemesterYear(){
		return year + semester;
	}
	
	public ArrayList<String> getDepartments(){
		return selected_classes;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserInterface ui = new UserInterface();
		ui.startMenu();
	}

}
