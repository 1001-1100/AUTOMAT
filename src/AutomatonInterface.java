
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;

public class AutomatonInterface {

	JFrame frame;
	SolutionFinder solFind;
	ArrayList<JLabel> visualStates;
	
	/**
	 * Create the application.
	 */
	public AutomatonInterface() {
		this.solFind = solFind;
		initialize();
	}

	public void removeCurrentState(int stateNumber) {
		visualStates.get(stateNumber).setVisible(false);
	}	
	
	public void addCurrentState(int stateNumber) {
		visualStates.get(stateNumber).setVisible(true);
	}	
	
	public void clearVisualStates() {
		for(int i = 0 ; i < visualStates.size() ; i++) {
			visualStates.get(i).setVisible(false);
		}
	}
	
	public void show() {
		frame.setVisible(true);
	}
	
	public void hide() {
		frame.setVisible(false);
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 644, 564);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		visualStates = new ArrayList<>();
		
		JPanel displayPanel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(displayPanel, GroupLayout.PREFERRED_SIZE, 627, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(637, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(displayPanel, GroupLayout.PREFERRED_SIZE, 526, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(156, Short.MAX_VALUE))
		);
		
		JPanel automatonPanel = new JPanel();
		
		JLayeredPane statesPanel = new JLayeredPane();
		statesPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		GroupLayout gl_automatonPanel = new GroupLayout(automatonPanel);
		gl_automatonPanel.setHorizontalGroup(
			gl_automatonPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_automatonPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(statesPanel, GroupLayout.PREFERRED_SIZE, 607, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(19, Short.MAX_VALUE))
		);
		gl_automatonPanel.setVerticalGroup(
			gl_automatonPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_automatonPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(statesPanel, GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JLabel stateMap = new JLabel("");
		statesPanel.setLayer(stateMap, 0);
		stateMap.setIcon(new ImageIcon(Interface.class.getResource("FA arranged better 600.png")));
		stateMap.setBounds(0, 0, 607, 505);
		statesPanel.add(stateMap);
		
		JLabel q0 = new JLabel("");
		statesPanel.setLayer(q0, 1);
		q0.setIcon(new ImageIcon(Interface.class.getResource("selector.png")));
		q0.setBounds(16, 59, 38, 33);
		q0.setVisible(false);
		statesPanel.add(q0);
		visualStates.add(q0);
		
		JLabel q1 = new JLabel("");
		q1.setIcon(new ImageIcon(Interface.class.getResource("selector.png")));
		statesPanel.setLayer(q1, 1);
		q1.setBounds(10, 207, 38, 33);
		q1.setVisible(false);
		statesPanel.add(q1);
		visualStates.add(q1);
		
		JLabel q2 = new JLabel("");
		statesPanel.setLayer(q2, 1);
		q2.setIcon(new ImageIcon(Interface.class.getResource("selector.png")));
		q2.setBounds(179, 271, 38, 33);
		q2.setVisible(false);
		statesPanel.add(q2);
		visualStates.add(q2);
		
		JLabel q3 = new JLabel("");
		statesPanel.setLayer(q3, 1);
		q3.setIcon(new ImageIcon(Interface.class.getResource("selector.png")));
		q3.setBounds(120, 69, 38, 33);
		q3.setVisible(false);
		statesPanel.add(q3);
		visualStates.add(q3);
		
		JLabel q4 = new JLabel("");
		statesPanel.setLayer(q4, 1);
		q4.setIcon(new ImageIcon(Interface.class.getResource("selector.png")));
		q4.setBounds(71, 338, 38, 33);
		q4.setVisible(false);
		statesPanel.add(q4);
		visualStates.add(q4);
		
		JLabel q5 = new JLabel("");
		statesPanel.setLayer(q5, 1);
		q5.setIcon(new ImageIcon(Interface.class.getResource("selector.png")));
		q5.setBounds(242, 106, 38, 33);
		q5.setVisible(false);
		statesPanel.add(q5);
		visualStates.add(q5);
		
		JLabel q6 = new JLabel("");
		q6.setIcon(new ImageIcon(Interface.class.getResource("selector.png")));
		statesPanel.setLayer(q6, 1);
		q6.setBounds(208, 377, 38, 33);
		q6.setVisible(false);
		statesPanel.add(q6);
		visualStates.add(q6);
		
		JLabel q7 = new JLabel("");
		q7.setIcon(new ImageIcon(Interface.class.getResource("selector.png")));
		statesPanel.setLayer(q7, 1);
		q7.setBounds(109, 448, 38, 33);
		q7.setVisible(false);
		statesPanel.add(q7);
		visualStates.add(q7);
		
		JLabel q8 = new JLabel("");
		q8.setIcon(new ImageIcon(Interface.class.getResource("selector.png")));
		statesPanel.setLayer(q8, 1);
		q8.setBounds(332, 363, 38, 33);
		q8.setVisible(false);
		statesPanel.add(q8);
		visualStates.add(q8);
		
		JLabel q9 = new JLabel("");
		q9.setIcon(new ImageIcon(Interface.class.getResource("selector.png")));
		statesPanel.setLayer(q9, 1);
		q9.setBounds(346, 78, 38, 33);
		q9.setVisible(false);
		statesPanel.add(q9);
		visualStates.add(q9);
		
		JLabel q10 = new JLabel("");
		q10.setEnabled(true);
		q10.setIcon(new ImageIcon(Interface.class.getResource("selector.png")));
		statesPanel.setLayer(q10, 1);
		q10.setBounds(229, 7, 38, 33);
		q10.setVisible(false);
		statesPanel.add(q10);
		visualStates.add(q10);
		
		JLabel q11 = new JLabel("");
		q11.setIcon(new ImageIcon(Interface.class.getResource("selector.png")));
		statesPanel.setLayer(q11, 1);
		q11.setBounds(487, 319, 38, 33);
		q11.setVisible(false);
		statesPanel.add(q11);
		visualStates.add(q11);
		
		JLabel q12 = new JLabel("");
		statesPanel.setLayer(q12, 1);
		q12.setIcon(new ImageIcon(Interface.class.getResource("selector.png")));
		q12.setBounds(553, 263, 38, 33);
		q12.setVisible(false);
		statesPanel.add(q12);
		visualStates.add(q12);
		
		JLabel q13 = new JLabel("");
		statesPanel.setLayer(q13, 1);
		q13.setIcon(new ImageIcon(Interface.class.getResource("selector.png")));
		q13.setBounds(522, 167, 38, 33);
		q13.setVisible(false);
		statesPanel.add(q13);
		visualStates.add(q13);
		
		JLabel q14 = new JLabel("");
		q14.setIcon(new ImageIcon(Interface.class.getResource("selector.png")));
		statesPanel.setLayer(q14, 1);
		q14.setBounds(283, 227, 38, 33);
		q14.setVisible(false);
		statesPanel.add(q14);
		visualStates.add(q14);
		
		JLabel q15 = new JLabel("");
		q15.setIcon(new ImageIcon(Interface.class.getResource("selector.png")));
		statesPanel.setLayer(q15, 1);
		q15.setBounds(450, 33, 38, 33);
		q15.setVisible(false);
		statesPanel.add(q15);
		visualStates.add(q15);
		
		JLabel q16 = new JLabel("");
		q16.setIcon(new ImageIcon(Interface.class.getResource("selector.png")));
		statesPanel.setLayer(q16, 1);
		q16.setBounds(471, 427, 38, 33);
		q16.setVisible(false);
		statesPanel.add(q16);
		visualStates.add(q16);
		
		JLabel q17 = new JLabel("");
		q17.setIcon(new ImageIcon(Interface.class.getResource("selector.png")));
		statesPanel.setLayer(q17, 1);
		q17.setBounds(414, 163, 38, 33);
		q17.setVisible(false);
		statesPanel.add(q17);
		visualStates.add(q17);
		
		automatonPanel.setLayout(gl_automatonPanel);
		GroupLayout gl_displayPanel = new GroupLayout(displayPanel);
		gl_displayPanel.setHorizontalGroup(
			gl_displayPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_displayPanel.createSequentialGroup()
					.addComponent(automatonPanel, GroupLayout.PREFERRED_SIZE, 626, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_displayPanel.setVerticalGroup(
			gl_displayPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_displayPanel.createSequentialGroup()
					.addComponent(automatonPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		displayPanel.setLayout(gl_displayPanel);
		frame.getContentPane().setLayout(groupLayout);
	}
}
