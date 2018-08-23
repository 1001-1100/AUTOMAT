
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
import javax.swing.JTextField;
import java.awt.Font;

public class Interface {

	JFrame frame;
	AutomatonInterface automatonInterface;
	SolutionInterface solutionInterface;
	Automaton automaton;
	
	State currentState;
	String input;
	JLabel s;
	JLabel h1;
	JLabel h2;
	JLabel l;
	JLabel c;
	JLabel g;
	
	JLabel playButton;
	JButton undoButton;
	
	boolean emptyInput;
	boolean turn;
	JLabel background;
	JLayeredPane graphics;
	private JTextField currentStateField;
	private JTextField currentInputField;
	
	/**
	 * Create the application.
	 */
	public Interface(Automaton automaton, AutomatonInterface automatonInterface, SolutionInterface solutionInterface) {
		this.automaton = automaton;
		this.automatonInterface = automatonInterface;
		this.solutionInterface = solutionInterface;
		//this.solFind = solFind;
		initialize();
		refreshGraphics();
	}
	
	private void refreshGraphics() {
		String content = currentState.getStateLabel();
		addScientist();
		for(int i = 0 ; i < content.length() ; i++) {
			if(content.charAt(i) == 'H') {
				addHumanOne();
				if(content.charAt(i+1) == 'H') {
					addHumanTwo();
					i++;
				}
			}else if(content.charAt(i) == 'L') {
				addLion();
			}else if(content.charAt(i) == 'C') {
				addCow();
			}else if(content.charAt(i) == 'G') {
				addGrain();
			}
		}
	}
	
	private void removeGraphics() {
		graphics.remove(s);
		graphics.remove(h1);
		graphics.remove(h2);
		graphics.remove(l);
		graphics.remove(c);
		graphics.remove(g);
	}
	
	private void addScientist() {
		Thread t = new Thread() {
			public void run() {
				s = new JLabel("");
				s.setIcon(new ImageIcon(Interface.class.getResource("/scientist96.png")));
				s.setBounds(385, 490, 32, 96);
				graphics.add(s);
				
				while(s.getX() > 137) {
					s.setLocation(s.getX()-1, s.getY());
					try {
						Thread.sleep(3);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}				
			}
		};
		t.start();	
	}
	
	private void addHumanOne() {
		Thread t = new Thread() {
			public void run() {
				h1 = new JLabel("");
				h1.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent arg0) {
						h1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
					}
					@Override
					public void mouseExited(MouseEvent e) {
						h1.setBorder(null);
					}
					@Override
					public void mousePressed(MouseEvent e) {
						graphics.remove(h1);
						if(emptyInput) {
							input = "";
							emptyInput = false;
						}
						addInput("H");
						undoButton.setVisible(true);
						graphics.repaint();
					}
				});
				
				for(int i = 0 ; i < input.length() ; i++) {
					if(input.charAt(i) == 'H') {
						h1.setIcon(new ImageIcon(Interface.class.getResource("/person96.png")));
						h1.setBounds(385, 490, 56, 96);
						graphics.add(h1);
						
						while(h1.getX() > 210) {
							h1.setLocation(h1.getX()-1, h1.getY());
							try {
								Thread.sleep(3);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}		
						return;
					}
				}	
				
				h1.setIcon(new ImageIcon(Interface.class.getResource("/person96.png")));
				h1.setBounds(-60, 490, 56, 96);
				graphics.add(h1);
				
				while(h1.getX() < 210) {
					h1.setLocation(h1.getX()+1, h1.getY());
					try {
						Thread.sleep(4);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}				
			}
		};
		t.start();
	}
	
	private void addHumanTwo() {
		Thread t = new Thread() {
			public void run() {
				h2 = new JLabel("");
				h2.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent arg0) {
						h2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
					}
					@Override
					public void mouseExited(MouseEvent e) {
						h2.setBorder(null);
					}
					@Override
					public void mousePressed(MouseEvent e) {
						graphics.remove(h2);
						if(emptyInput) {
							input = "";
							emptyInput = false;
						}
						addInput("H");
						undoButton.setVisible(true);
						graphics.repaint();
					}
				});
				
				for(int i = 0 ; i < input.length() ; i++) {
					if(input.charAt(i) == 'H') {
						h2.setIcon(new ImageIcon(Interface.class.getResource("/person96.png")));
						h2.setBounds(385, 490, 56, 96);
						graphics.add(h2);
						
						while(h2.getX() > 276) {
							h2.setLocation(h2.getX()-1, h2.getY());
							try {
								Thread.sleep(3);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}	
						return;
					}
				}		
				
				h2.setIcon(new ImageIcon(Interface.class.getResource("/person96.png")));
				h2.setBounds(-60, 490, 56, 96);
				graphics.add(h2);
				
				while(h2.getX() < 276) {
					h2.setLocation(h2.getX()+1, h2.getY());
					try {
						Thread.sleep(3);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}				
			}
		};
		t.start();
	}
	
	private void addLion() {
		Thread t = new Thread() {
			public void run() {
				l = new JLabel("");
				l.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent arg0) {
						l.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
					}
					@Override
					public void mouseExited(MouseEvent e) {
						l.setBorder(null);
					}
					@Override
					public void mousePressed(MouseEvent e) {
						graphics.remove(l);
						if(emptyInput) {
							input = "";
							emptyInput = false;
						}
						addInput("L");
						undoButton.setVisible(true);
						graphics.repaint();
					}
				});
				
				for(int i = 0 ; i < input.length() ; i++) {
					if(input.charAt(i) == 'L') {
						l.setIcon(new ImageIcon(Interface.class.getResource("/lion96.png")));
						l.setBounds(385, 490, 94, 96);
						graphics.add(l);
						
						while(l.getX() < 484) {
							l.setLocation(l.getX()+1, l.getY());
							try {
								Thread.sleep(3);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}	
						return;
					}
				}
				
				l.setIcon(new ImageIcon(Interface.class.getResource("/lion96.png")));
				l.setBounds(830, 490, 94, 96);
				graphics.add(l);
				
				while(l.getX() > 484) {
					l.setLocation(l.getX()-1, l.getY());
					try {
						Thread.sleep(3);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}				
			}
		};
		t.start();
	}
	
	private void addCow() {
		Thread t = new Thread() {
			public void run() {
				c = new JLabel("");
				c.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent arg0) {
						c.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
					}
					@Override
					public void mouseExited(MouseEvent e) {
						c.setBorder(null);
					}
					@Override
					public void mousePressed(MouseEvent e) {
						graphics.remove(c);
						if(emptyInput) {
							input = "";
							emptyInput = false;
						}
						addInput("C");
						undoButton.setVisible(true);
						graphics.repaint();
					}
				});
				
				for(int i = 0 ; i < input.length() ; i++) {
					if(input.charAt(i) == 'C') {
						c.setIcon(new ImageIcon(Interface.class.getResource("/cow96.png")));
						c.setBounds(385, 490, 96, 89);
						graphics.add(c);
						
						while(c.getX() < 588) {
							c.setLocation(c.getX()+1, c.getY());
							try {
								Thread.sleep(3);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}	
						return;
					}
				}

				c.setIcon(new ImageIcon(Interface.class.getResource("/cow96.png")));
				c.setBounds(830, 490, 96, 89);
				graphics.add(c);
				
				while(c.getX() > 588) {
					c.setLocation(c.getX()-1, c.getY());
					try {
						Thread.sleep(4);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}				
			}
		};
		t.start();
	}
	
	private void addGrain() {
		Thread t = new Thread() {
			public void run() {
				g = new JLabel("");
				g.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent arg0) {
						g.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
					}
					@Override
					public void mouseExited(MouseEvent e) {
						g.setBorder(null);
					}
					@Override
					public void mousePressed(MouseEvent e) {
						graphics.remove(g);
						if(emptyInput) {
							input = "";
							emptyInput = false;
						}
						addInput("G");
						undoButton.setVisible(true);
						graphics.repaint();
					}
				});
				
				for(int i = 0 ; i < input.length() ; i++) {
					if(input.charAt(i) == 'G') {
						g.setIcon(new ImageIcon(Interface.class.getResource("/grain96.png")));
						g.setBounds(385, 490, 96, 89);
						graphics.add(g);
						
						while(g.getX() < 697) {
							g.setLocation(g.getX()+1, g.getY());
							try {
								Thread.sleep(3);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}	
						return;
					}
				}		
				
				g.setIcon(new ImageIcon(Interface.class.getResource("/grain96.png")));
				g.setBounds(830, 490, 96, 71);
				graphics.add(g);
				
				while(g.getX() > 697) {
					g.setLocation(g.getX()-1, g.getY());
					try {
						Thread.sleep(5);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}				
			}
		};
		t.start();
	}
	
	public void addInput(String newInput) {
		input += newInput;
		input = reorder(input);
		currentInputField.setText(input);
	}
	
	public String reorder(String currentInput) {
		String orderedInput = "";
		if(currentInput.contains("H")) {
			if(currentInput.replaceFirst("H", "").contains("H"))
				orderedInput += "HH";
			else
				orderedInput += "H";
		}else if(currentInput.contains("HH")) {
			orderedInput += "HH";
		}
		if(currentInput.contains("L")) {
			orderedInput += "L";
		}
		if(currentInput.contains("C")) {
			orderedInput += "C";
		}
		if(currentInput.contains("G")) {
			orderedInput += "G";
		}
		return orderedInput;
	}
	
	private boolean checkTransitions() {
		for(int i = 0 ; i < currentState.getTransitions().size() ; i++) {
			if(currentState.getTransitions().get(i).getInput().equals(input)) {
				automatonInterface.removeCurrentState(currentState.getStateNumber());
				currentState = currentState.getTransitions().get(i).getDestination();
				automatonInterface.addCurrentState(currentState.getStateNumber());
				currentStateField.setText("q"+currentState.getStateNumber());
				return true;
			}
		}
		return false;
	}
	
	private void launch() {
		if(emptyInput) {
			input = "";
			emptyInput = false;
			currentInputField.setText(input);
		}
		if(checkTransitions()) {
			//JOptionPane.showMessageDialog(frame, "Accepted!");
			emptyInput = true;
			currentInputField.setText("");
			removeGraphics();
			graphics.repaint();
			playButton.setVisible(false);
			undoButton.setVisible(false);
			Thread t = new Thread() {
				public void run() {
					if(turn) {
						ImageIcon newIcon = new ImageIcon(Interface.class.getResource("/rocket-mars.gif"));
						newIcon.getImage().flush();
						background.setIcon(newIcon);
						turn = false;
						try {
							Thread.sleep(5500);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						background.setIcon(new ImageIcon(Interface.class.getResource("/rocket-end.png")));
						playButton.setVisible(true);
						graphics.repaint();
					}else {
						ImageIcon newIcon = new ImageIcon(Interface.class.getResource("/rocket-earth.gif"));
						newIcon.getImage().flush();
						background.setIcon(newIcon);
						turn = true;
						try {
							Thread.sleep(5500);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						background.setIcon(new ImageIcon(Interface.class.getResource("/rocket-start.png")));
						playButton.setVisible(true);
						graphics.repaint();
					}	
					refreshGraphics();
					if(currentState.equals(automaton.getStates().get(13))) {
						JOptionPane.showMessageDialog(frame, "Victory for mankind!");
					}
				}
			};
			t.start();
		}else {
			JOptionPane.showMessageDialog(frame, "Invalid input! Game Over!");
		}
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 814, 683);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		currentState = automaton.getStates().get(0);
		automatonInterface.addCurrentState(0);
		input = "";
		
		JPanel displayPanel = new JPanel();
		
		JButton btnShowAutomata = new JButton("Show Automaton");
		btnShowAutomata.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				automatonInterface.show();
			}
		});
		
		JButton btnShowSolutions = new JButton("Show Solutions");
		btnShowSolutions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				solutionInterface.show();
			}
		});
		
		JLabel lblCurrentState = new JLabel("Current State:");
		
		currentStateField = new JTextField();
		currentStateField.setEditable(false);
		currentStateField.setColumns(10);
		
		JLabel lblCurrentInput = new JLabel("Current Input:");
		
		currentInputField = new JTextField();
		currentInputField.setEditable(false);
		currentInputField.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(displayPanel, GroupLayout.PREFERRED_SIZE, 802, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblCurrentState)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(currentStateField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblCurrentInput)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(currentInputField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnShowAutomata)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(btnShowSolutions)
					.addGap(85))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(displayPanel, GroupLayout.PREFERRED_SIZE, 601, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnShowSolutions)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(currentStateField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblCurrentInput)
							.addComponent(currentInputField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnShowAutomata)
							.addComponent(lblCurrentState)))
					.addContainerGap(14, Short.MAX_VALUE))
		);
		
		JLayeredPane graphicalPanel = new JLayeredPane();
		
		graphics = new JLayeredPane();
		graphics.setForeground(Color.BLACK);
		graphics.setBackground(Color.BLACK);
		graphics.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		GroupLayout gl_graphicalPanel = new GroupLayout(graphicalPanel);
		gl_graphicalPanel.setHorizontalGroup(
			gl_graphicalPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_graphicalPanel.createSequentialGroup()
					.addComponent(graphics, GroupLayout.PREFERRED_SIZE, 800, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(253, Short.MAX_VALUE))
		);
		gl_graphicalPanel.setVerticalGroup(
			gl_graphicalPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_graphicalPanel.createSequentialGroup()
					.addComponent(graphics, GroupLayout.PREFERRED_SIZE, 600, GroupLayout.PREFERRED_SIZE)
					.addGap(1041))
		);
		
		background = new JLabel("");
		graphics.setLayer(background, -1);
		background.setIcon(new ImageIcon(Interface.class.getResource("/rocket-start.png")));
		background.setBounds(0, 0, 800, 600);
		graphics.add(background);
		
		undoButton = new JButton("UNDO");
		undoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				undoButton.setVisible(false);
				for(int i = 0 ; i < input.length() ; i++) {
					if(input.charAt(i) == 'H') {
						addHumanOne();
						if(input.charAt(i+1) == 'H') {
							addHumanTwo();
							i++;
						}
					}else if(input.charAt(i) == 'L') {
						addLion();
					}else if(input.charAt(i) == 'C') {
						addCow();
					}else if(input.charAt(i) == 'G') {
						addGrain();
					}
				}
				emptyInput = true;
				currentInputField.setText("");
			}
		});
		undoButton.setFont(new Font("Vrinda", Font.PLAIN, 11));
		undoButton.setBackground(Color.WHITE);
		undoButton.setForeground(Color.BLACK);
		undoButton.setBounds(362, 326, 77, 23);
		undoButton.setVisible(false);
		graphics.add(undoButton);
		
		playButton = new JLabel("");
		playButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				launch();
			}
		});
		playButton.setIcon(new ImageIcon(Interface.class.getResource("/play_button96.png")));
		playButton.setBounds(350, 205, 96, 96);
		graphics.add(playButton);
		graphicalPanel.setLayout(gl_graphicalPanel);
		GroupLayout gl_displayPanel = new GroupLayout(displayPanel);
		gl_displayPanel.setHorizontalGroup(
			gl_displayPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_displayPanel.createSequentialGroup()
					.addComponent(graphicalPanel, GroupLayout.PREFERRED_SIZE, 800, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(253, Short.MAX_VALUE))
		);
		gl_displayPanel.setVerticalGroup(
			gl_displayPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_displayPanel.createSequentialGroup()
					.addComponent(graphicalPanel, GroupLayout.PREFERRED_SIZE, 600, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		displayPanel.setLayout(gl_displayPanel);
		
		turn = true;
		emptyInput = true;
		
		currentInputField.setText(input);
		currentStateField.setText("q"+currentState.getStateNumber());
		
		frame.getContentPane().setLayout(groupLayout);
	}
}
