import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.*;

@SuppressWarnings("serial")
public class SudokuGUI extends JFrame {

	private JPanel contentPane;
	private JFormattedTextField[] position = new JFormattedTextField [81];
	private JRadioButton rdbtnDansCode, rdbtnBriansCode, rdbtnStuartsCode;
	private ButtonGroup buttonGroup = new ButtonGroup(); 
	private JButton btnClear, btnSolve;
	private JLabel lblError, lblTimeSolving, lblTime;
	private SolverADT sudoku;


	/**
	 * Create the frame.
	 */
	public SudokuGUI() {
		setResizable(false);
		setTitle("Sudoku Solver");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 440, 375);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{30, 30, 30, 15, 30, 30, 30, 15, 30, 30, 30, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 15, 0, 0, 0, 15, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);

		NumberFormat f = NumberFormat.getInstance();
		f.setMaximumIntegerDigits(1);

		position[0] = new JFormattedTextField(f);
		GridBagConstraints gbc_0 = new GridBagConstraints();
		gbc_0.insets = new Insets(0, 0, 5, 5);
		gbc_0.fill = GridBagConstraints.HORIZONTAL;
		gbc_0.gridx = 0;
		gbc_0.gridy = 0;
		contentPane.add(position[0], gbc_0);
		position[0].setColumns(10);

		position[1] = new JFormattedTextField(f);
		GridBagConstraints gbc_1 = new GridBagConstraints();
		gbc_1.insets = new Insets(0, 0, 5, 5);
		gbc_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_1.gridx = 1;
		gbc_1.gridy = 0;
		contentPane.add(position[1], gbc_1);
		position[1].setColumns(10);

		position[2] = new JFormattedTextField(f);
		GridBagConstraints gbc_2 = new GridBagConstraints();
		gbc_2.insets = new Insets(0, 0, 5, 5);
		gbc_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_2.gridx = 2;
		gbc_2.gridy = 0;
		contentPane.add(position[2], gbc_2);
		position[2].setColumns(10);

		position[3] = new JFormattedTextField(f);
		GridBagConstraints gbc_3 = new GridBagConstraints();
		gbc_3.insets = new Insets(0, 0, 5, 5);
		gbc_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_3.gridx = 4;
		gbc_3.gridy = 0;
		contentPane.add(position[3], gbc_3);
		position[3].setColumns(10);

		position[4] = new JFormattedTextField(f);
		GridBagConstraints gbc_4 = new GridBagConstraints();
		gbc_4.insets = new Insets(0, 0, 5, 5);
		gbc_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_4.gridx = 5;
		gbc_4.gridy = 0;
		contentPane.add(position[4], gbc_4);
		position[4].setColumns(10);

		position[5] = new JFormattedTextField(f);
		GridBagConstraints gbc_5 = new GridBagConstraints();
		gbc_5.insets = new Insets(0, 0, 5, 5);
		gbc_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_5.gridx = 6;
		gbc_5.gridy = 0;
		contentPane.add(position[5], gbc_5);
		position[5].setColumns(10);

		position[6] = new JFormattedTextField(f);
		GridBagConstraints gbc_6 = new GridBagConstraints();
		gbc_6.insets = new Insets(0, 0, 5, 5);
		gbc_6.fill = GridBagConstraints.HORIZONTAL;
		gbc_6.gridx = 8;
		gbc_6.gridy = 0;
		contentPane.add(position[6], gbc_6);
		position[6].setColumns(10);

		position[7] = new JFormattedTextField(f);
		GridBagConstraints gbc_7 = new GridBagConstraints();
		gbc_7.insets = new Insets(0, 0, 5, 5);
		gbc_7.fill = GridBagConstraints.HORIZONTAL;
		gbc_7.gridx = 9;
		gbc_7.gridy = 0;
		contentPane.add(position[7], gbc_7);
		position[7].setColumns(10);

		position[8] = new JFormattedTextField(f);
		GridBagConstraints gbc_8 = new GridBagConstraints();
		gbc_8.insets = new Insets(0, 0, 5, 5);
		gbc_8.fill = GridBagConstraints.HORIZONTAL;
		gbc_8.gridx = 10;
		gbc_8.gridy = 0;
		contentPane.add(position[8], gbc_8);
		position[8].setColumns(10);

		position[9] = new JFormattedTextField(f);
		GridBagConstraints gbc_9 = new GridBagConstraints();
		gbc_9.insets = new Insets(0, 0, 5, 5);
		gbc_9.fill = GridBagConstraints.HORIZONTAL;
		gbc_9.gridx = 0;
		gbc_9.gridy = 1;
		contentPane.add(position[9], gbc_9);
		position[9].setColumns(10);

		position[10] = new JFormattedTextField(f);
		GridBagConstraints gbc_10 = new GridBagConstraints();
		gbc_10.insets = new Insets(0, 0, 5, 5);
		gbc_10.fill = GridBagConstraints.HORIZONTAL;
		gbc_10.gridx = 1;
		gbc_10.gridy = 1;
		contentPane.add(position[10], gbc_10);
		position[10].setColumns(10);

		position[11] = new JFormattedTextField(f);
		GridBagConstraints gbc_11 = new GridBagConstraints();
		gbc_11.insets = new Insets(0, 0, 5, 5);
		gbc_11.fill = GridBagConstraints.HORIZONTAL;
		gbc_11.gridx = 2;
		gbc_11.gridy = 1;
		contentPane.add(position[11], gbc_11);
		position[11].setColumns(10);

		position[12] = new JFormattedTextField(f);
		GridBagConstraints gbc_12 = new GridBagConstraints();
		gbc_12.insets = new Insets(0, 0, 5, 5);
		gbc_12.fill = GridBagConstraints.HORIZONTAL;
		gbc_12.gridx = 4;
		gbc_12.gridy = 1;
		contentPane.add(position[12], gbc_12);
		position[12].setColumns(10);

		position[13] = new JFormattedTextField(f);
		GridBagConstraints gbc_13 = new GridBagConstraints();
		gbc_13.insets = new Insets(0, 0, 5, 5);
		gbc_13.fill = GridBagConstraints.HORIZONTAL;
		gbc_13.gridx = 5;
		gbc_13.gridy = 1;
		contentPane.add(position[13], gbc_13);
		position[13].setColumns(10);

		position[14] = new JFormattedTextField(f);
		GridBagConstraints gbc_14 = new GridBagConstraints();
		gbc_14.insets = new Insets(0, 0, 5, 5);
		gbc_14.fill = GridBagConstraints.HORIZONTAL;
		gbc_14.gridx = 6;
		gbc_14.gridy = 1;
		contentPane.add(position[14], gbc_14);
		position[14].setColumns(10);

		position[15] = new JFormattedTextField(f);
		GridBagConstraints gbc_15 = new GridBagConstraints();
		gbc_15.insets = new Insets(0, 0, 5, 5);
		gbc_15.fill = GridBagConstraints.HORIZONTAL;
		gbc_15.gridx = 8;
		gbc_15.gridy = 1;
		contentPane.add(position[15], gbc_15);
		position[15].setColumns(10);

		position[16] = new JFormattedTextField(f);
		GridBagConstraints gbc_16 = new GridBagConstraints();
		gbc_16.insets = new Insets(0, 0, 5, 5);
		gbc_16.fill = GridBagConstraints.HORIZONTAL;
		gbc_16.gridx = 9;
		gbc_16.gridy = 1;
		contentPane.add(position[16], gbc_16);
		position[16].setColumns(10);

		position[17] = new JFormattedTextField(f);
		GridBagConstraints gbc_17 = new GridBagConstraints();
		gbc_17.insets = new Insets(0, 0, 5, 5);
		gbc_17.fill = GridBagConstraints.HORIZONTAL;
		gbc_17.gridx = 10;
		gbc_17.gridy = 1;
		contentPane.add(position[17], gbc_17);
		position[17].setColumns(10);

		position[18] = new JFormattedTextField(f);
		GridBagConstraints gbc_18 = new GridBagConstraints();
		gbc_18.insets = new Insets(0, 0, 5, 5);
		gbc_18.fill = GridBagConstraints.HORIZONTAL;
		gbc_18.gridx = 0;
		gbc_18.gridy = 2;
		contentPane.add(position[18], gbc_18);
		position[18].setColumns(10);

		position[19] = new JFormattedTextField(f);
		GridBagConstraints gbc_19 = new GridBagConstraints();
		gbc_19.insets = new Insets(0, 0, 5, 5);
		gbc_19.fill = GridBagConstraints.HORIZONTAL;
		gbc_19.gridx = 1;
		gbc_19.gridy = 2;
		contentPane.add(position[19], gbc_19);
		position[19].setColumns(10);

		position[20] = new JFormattedTextField(f);
		GridBagConstraints gbc_20 = new GridBagConstraints();
		gbc_20.insets = new Insets(0, 0, 5, 5);
		gbc_20.fill = GridBagConstraints.HORIZONTAL;
		gbc_20.gridx = 2;
		gbc_20.gridy = 2;
		contentPane.add(position[20], gbc_20);
		position[20].setColumns(10);

		position[21] = new JFormattedTextField(f);
		GridBagConstraints gbc_21 = new GridBagConstraints();
		gbc_21.insets = new Insets(0, 0, 5, 5);
		gbc_21.fill = GridBagConstraints.HORIZONTAL;
		gbc_21.gridx = 4;
		gbc_21.gridy = 2;
		contentPane.add(position[21], gbc_21);
		position[21].setColumns(10);

		position[22] = new JFormattedTextField(f);
		GridBagConstraints gbc_22 = new GridBagConstraints();
		gbc_22.insets = new Insets(0, 0, 5, 5);
		gbc_22.fill = GridBagConstraints.HORIZONTAL;
		gbc_22.gridx = 5;
		gbc_22.gridy = 2;
		contentPane.add(position[22], gbc_22);
		position[22].setColumns(10);

		position[23] = new JFormattedTextField(f);
		GridBagConstraints gbc_23 = new GridBagConstraints();
		gbc_23.insets = new Insets(0, 0, 5, 5);
		gbc_23.fill = GridBagConstraints.HORIZONTAL;
		gbc_23.gridx = 6;
		gbc_23.gridy = 2;
		contentPane.add(position[23], gbc_23);
		position[23].setColumns(10);

		position[24] = new JFormattedTextField(f);
		GridBagConstraints gbc_24 = new GridBagConstraints();
		gbc_24.insets = new Insets(0, 0, 5, 5);
		gbc_24.fill = GridBagConstraints.HORIZONTAL;
		gbc_24.gridx = 8;
		gbc_24.gridy = 2;
		contentPane.add(position[24], gbc_24);
		position[24].setColumns(10);

		position[25] = new JFormattedTextField(f);
		GridBagConstraints gbc_25 = new GridBagConstraints();
		gbc_25.insets = new Insets(0, 0, 5, 5);
		gbc_25.fill = GridBagConstraints.HORIZONTAL;
		gbc_25.gridx = 9;
		gbc_25.gridy = 2;
		contentPane.add(position[25], gbc_25);
		position[25].setColumns(10);

		position[26] = new JFormattedTextField(f);
		GridBagConstraints gbc_26 = new GridBagConstraints();
		gbc_26.insets = new Insets(0, 0, 5, 5);
		gbc_26.fill = GridBagConstraints.HORIZONTAL;
		gbc_26.gridx = 10;
		gbc_26.gridy = 2;
		contentPane.add(position[26], gbc_26);
		position[26].setColumns(10);

		position[27] = new JFormattedTextField(f);
		GridBagConstraints gbc_27 = new GridBagConstraints();
		gbc_27.insets = new Insets(0, 0, 5, 5);
		gbc_27.fill = GridBagConstraints.HORIZONTAL;
		gbc_27.gridx = 0;
		gbc_27.gridy = 4;
		contentPane.add(position[27], gbc_27);
		position[27].setColumns(10);

		position[28] = new JFormattedTextField(f);
		GridBagConstraints gbc_28 = new GridBagConstraints();
		gbc_28.insets = new Insets(0, 0, 5, 5);
		gbc_28.fill = GridBagConstraints.HORIZONTAL;
		gbc_28.gridx = 1;
		gbc_28.gridy = 4;
		contentPane.add(position[28], gbc_28);
		position[28].setColumns(10);

		position[29] = new JFormattedTextField(f);
		GridBagConstraints gbc_29 = new GridBagConstraints();
		gbc_29.insets = new Insets(0, 0, 5, 5);
		gbc_29.fill = GridBagConstraints.HORIZONTAL;
		gbc_29.gridx = 2;
		gbc_29.gridy = 4;
		contentPane.add(position[29], gbc_29);
		position[29].setColumns(10);

		position[30] = new JFormattedTextField(f);
		GridBagConstraints gbc_30 = new GridBagConstraints();
		gbc_30.insets = new Insets(0, 0, 5, 5);
		gbc_30.fill = GridBagConstraints.HORIZONTAL;
		gbc_30.gridx = 4;
		gbc_30.gridy = 4;
		contentPane.add(position[30], gbc_30);
		position[30].setColumns(10);

		position[31] = new JFormattedTextField(f);
		GridBagConstraints gbc_31 = new GridBagConstraints();
		gbc_31.insets = new Insets(0, 0, 5, 5);
		gbc_31.fill = GridBagConstraints.HORIZONTAL;
		gbc_31.gridx = 5;
		gbc_31.gridy = 4;
		contentPane.add(position[31], gbc_31);
		position[31].setColumns(10);

		position[32] = new JFormattedTextField(f);
		GridBagConstraints gbc_32 = new GridBagConstraints();
		gbc_32.insets = new Insets(0, 0, 5, 5);
		gbc_32.fill = GridBagConstraints.HORIZONTAL;
		gbc_32.gridx = 6;
		gbc_32.gridy = 4;
		contentPane.add(position[32], gbc_32);
		position[32].setColumns(10);

		position[33] = new JFormattedTextField(f);
		GridBagConstraints gbc_33 = new GridBagConstraints();
		gbc_33.insets = new Insets(0, 0, 5, 5);
		gbc_33.fill = GridBagConstraints.HORIZONTAL;
		gbc_33.gridx = 8;
		gbc_33.gridy = 4;
		contentPane.add(position[33], gbc_33);
		position[33].setColumns(10);

		position[34] = new JFormattedTextField(f);
		GridBagConstraints gbc_34 = new GridBagConstraints();
		gbc_34.insets = new Insets(0, 0, 5, 5);
		gbc_34.fill = GridBagConstraints.HORIZONTAL;
		gbc_34.gridx = 9;
		gbc_34.gridy = 4;
		contentPane.add(position[34], gbc_34);
		position[34].setColumns(10);

		position[35] = new JFormattedTextField(f);
		GridBagConstraints gbc_35 = new GridBagConstraints();
		gbc_35.insets = new Insets(0, 0, 5, 5);
		gbc_35.fill = GridBagConstraints.HORIZONTAL;
		gbc_35.gridx = 10;
		gbc_35.gridy = 4;
		contentPane.add(position[35], gbc_35);
		position[35].setColumns(10);

		btnSolve = new JButton("Solve");
		GridBagConstraints gbc_btnSolve = new GridBagConstraints();
		gbc_btnSolve.insets = new Insets(0, 0, 5, 0);
		gbc_btnSolve.gridx = 11;
		gbc_btnSolve.gridy = 4;
		btnSolve.addActionListener(new solveButtonAL());
		
		lblTimeSolving = new JLabel("Time Solving:");
		GridBagConstraints gbc_lblTimeSolving = new GridBagConstraints();
		gbc_lblTimeSolving.insets = new Insets(0, 0, 5, 0);
		gbc_lblTimeSolving.gridx = 11;
		gbc_lblTimeSolving.gridy = 1;
		contentPane.add(lblTimeSolving, gbc_lblTimeSolving);
		
		lblTime = new JLabel("");
		GridBagConstraints gbc_lblTime = new GridBagConstraints();
		gbc_lblTime.insets = new Insets(0, 0, 5, 0);
		gbc_lblTime.gridx = 11;
		gbc_lblTime.gridy = 2;
		contentPane.add(lblTime, gbc_lblTime);
		contentPane.add(btnSolve, gbc_btnSolve);

		position[36] = new JFormattedTextField(f);
		GridBagConstraints gbc_36 = new GridBagConstraints();
		gbc_36.insets = new Insets(0, 0, 5, 5);
		gbc_36.fill = GridBagConstraints.HORIZONTAL;
		gbc_36.gridx = 0;
		gbc_36.gridy = 5;
		contentPane.add(position[36], gbc_36);
		position[36].setColumns(10);

		position[37] = new JFormattedTextField(f);
		GridBagConstraints gbc_37 = new GridBagConstraints();
		gbc_37.insets = new Insets(0, 0, 5, 5);
		gbc_37.fill = GridBagConstraints.HORIZONTAL;
		gbc_37.gridx = 1;
		gbc_37.gridy = 5;
		contentPane.add(position[37], gbc_37);
		position[37].setColumns(10);

		position[38] = new JFormattedTextField(f);
		GridBagConstraints gbc_38 = new GridBagConstraints();
		gbc_38.insets = new Insets(0, 0, 5, 5);
		gbc_38.fill = GridBagConstraints.HORIZONTAL;
		gbc_38.gridx = 2;
		gbc_38.gridy = 5;
		contentPane.add(position[38], gbc_38);
		position[38].setColumns(10);

		position[39] = new JFormattedTextField(f);
		GridBagConstraints gbc_39 = new GridBagConstraints();
		gbc_39.insets = new Insets(0, 0, 5, 5);
		gbc_39.fill = GridBagConstraints.HORIZONTAL;
		gbc_39.gridx = 4;
		gbc_39.gridy = 5;
		contentPane.add(position[39], gbc_39);
		position[39].setColumns(10);

		position[40] = new JFormattedTextField(f);
		GridBagConstraints gbc_40 = new GridBagConstraints();
		gbc_40.insets = new Insets(0, 0, 5, 5);
		gbc_40.fill = GridBagConstraints.HORIZONTAL;
		gbc_40.gridx = 5;
		gbc_40.gridy = 5;
		contentPane.add(position[40], gbc_40);
		position[40].setColumns(10);

		position[41] = new JFormattedTextField(f);
		GridBagConstraints gbc_41 = new GridBagConstraints();
		gbc_41.insets = new Insets(0, 0, 5, 5);
		gbc_41.fill = GridBagConstraints.HORIZONTAL;
		gbc_41.gridx = 6;
		gbc_41.gridy = 5;
		contentPane.add(position[41], gbc_41);
		position[41].setColumns(10);

		position[42] = new JFormattedTextField(f);
		GridBagConstraints gbc_42 = new GridBagConstraints();
		gbc_42.insets = new Insets(0, 0, 5, 5);
		gbc_42.fill = GridBagConstraints.HORIZONTAL;
		gbc_42.gridx = 8;
		gbc_42.gridy = 5;
		contentPane.add(position[42], gbc_42);
		position[42].setColumns(10);

		position[43] = new JFormattedTextField(f);
		GridBagConstraints gbc_43 = new GridBagConstraints();
		gbc_43.insets = new Insets(0, 0, 5, 5);
		gbc_43.fill = GridBagConstraints.HORIZONTAL;
		gbc_43.gridx = 9;
		gbc_43.gridy = 5;
		contentPane.add(position[43], gbc_43);
		position[43].setColumns(10);

		position[44] = new JFormattedTextField(f);
		GridBagConstraints gbc_44 = new GridBagConstraints();
		gbc_44.insets = new Insets(0, 0, 5, 5);
		gbc_44.fill = GridBagConstraints.HORIZONTAL;
		gbc_44.gridx = 10;
		gbc_44.gridy = 5;
		contentPane.add(position[44], gbc_44);
		position[44].setColumns(10);

		position[45] = new JFormattedTextField(f);
		GridBagConstraints gbc_45 = new GridBagConstraints();
		gbc_45.insets = new Insets(0, 0, 5, 5);
		gbc_45.fill = GridBagConstraints.HORIZONTAL;
		gbc_45.gridx = 0;
		gbc_45.gridy = 6;
		contentPane.add(position[45], gbc_45);
		position[45].setColumns(10);

		position[46] = new JFormattedTextField(f);
		GridBagConstraints gbc_46 = new GridBagConstraints();
		gbc_46.insets = new Insets(0, 0, 5, 5);
		gbc_46.fill = GridBagConstraints.HORIZONTAL;
		gbc_46.gridx = 1;
		gbc_46.gridy = 6;
		contentPane.add(position[46], gbc_46);
		position[46].setColumns(10);

		position[47] = new JFormattedTextField(f);
		GridBagConstraints gbc_47 = new GridBagConstraints();
		gbc_47.insets = new Insets(0, 0, 5, 5);
		gbc_47.fill = GridBagConstraints.HORIZONTAL;
		gbc_47.gridx = 2;
		gbc_47.gridy = 6;
		contentPane.add(position[47], gbc_47);
		position[47].setColumns(10);

		position[48] = new JFormattedTextField(f);
		GridBagConstraints gbc_48 = new GridBagConstraints();
		gbc_48.insets = new Insets(0, 0, 5, 5);
		gbc_48.fill = GridBagConstraints.HORIZONTAL;
		gbc_48.gridx = 4;
		gbc_48.gridy = 6;
		contentPane.add(position[48], gbc_48);
		position[48].setColumns(10);

		position[49] = new JFormattedTextField(f);
		GridBagConstraints gbc_49 = new GridBagConstraints();
		gbc_49.insets = new Insets(0, 0, 5, 5);
		gbc_49.fill = GridBagConstraints.HORIZONTAL;
		gbc_49.gridx = 5;
		gbc_49.gridy = 6;
		contentPane.add(position[49], gbc_49);
		position[49].setColumns(10);

		position[50] = new JFormattedTextField(f);
		GridBagConstraints gbc_50 = new GridBagConstraints();
		gbc_50.insets = new Insets(0, 0, 5, 5);
		gbc_50.fill = GridBagConstraints.HORIZONTAL;
		gbc_50.gridx = 6;
		gbc_50.gridy = 6;
		contentPane.add(position[50], gbc_50);
		position[50].setColumns(10);

		position[51] = new JFormattedTextField(f);
		GridBagConstraints gbc_51 = new GridBagConstraints();
		gbc_51.insets = new Insets(0, 0, 5, 5);
		gbc_51.fill = GridBagConstraints.HORIZONTAL;
		gbc_51.gridx = 8;
		gbc_51.gridy = 6;
		contentPane.add(position[51], gbc_51);
		position[51].setColumns(10);

		position[52] = new JFormattedTextField(f);
		GridBagConstraints gbc_52 = new GridBagConstraints();
		gbc_52.insets = new Insets(0, 0, 5, 5);
		gbc_52.fill = GridBagConstraints.HORIZONTAL;
		gbc_52.gridx = 9;
		gbc_52.gridy = 6;
		contentPane.add(position[52], gbc_52);
		position[52].setColumns(10);

		position[53] = new JFormattedTextField(f);
		GridBagConstraints gbc_53 = new GridBagConstraints();
		gbc_53.insets = new Insets(0, 0, 5, 5);
		gbc_53.fill = GridBagConstraints.HORIZONTAL;
		gbc_53.gridx = 10;
		gbc_53.gridy = 6;
		contentPane.add(position[53], gbc_53);
		position[53].setColumns(10);

		btnClear = new JButton("Clear");
		GridBagConstraints gbc_btnClear = new GridBagConstraints();
		gbc_btnClear.insets = new Insets(0, 0, 5, 0);
		gbc_btnClear.gridx = 11;
		gbc_btnClear.gridy = 6;
		btnClear.addActionListener(new clearButtonAL());
		contentPane.add(btnClear, gbc_btnClear);

		position[54] = new JFormattedTextField(f);
		GridBagConstraints gbc_54 = new GridBagConstraints();
		gbc_54.insets = new Insets(0, 0, 5, 5);
		gbc_54.fill = GridBagConstraints.HORIZONTAL;
		gbc_54.gridx = 0;
		gbc_54.gridy = 8;
		contentPane.add(position[54], gbc_54);
		position[54].setColumns(10);

		position[55] = new JFormattedTextField(f);
		GridBagConstraints gbc_55 = new GridBagConstraints();
		gbc_55.insets = new Insets(0, 0, 5, 5);
		gbc_55.fill = GridBagConstraints.HORIZONTAL;
		gbc_55.gridx = 1;
		gbc_55.gridy = 8;
		contentPane.add(position[55], gbc_55);
		position[55].setColumns(10);

		position[56] = new JFormattedTextField(f);
		GridBagConstraints gbc_56 = new GridBagConstraints();
		gbc_56.insets = new Insets(0, 0, 5, 5);
		gbc_56.fill = GridBagConstraints.HORIZONTAL;
		gbc_56.gridx = 2;
		gbc_56.gridy = 8;
		contentPane.add(position[56], gbc_56);
		position[56].setColumns(10);

		position[57] = new JFormattedTextField(f);
		GridBagConstraints gbc_57 = new GridBagConstraints();
		gbc_57.insets = new Insets(0, 0, 5, 5);
		gbc_57.fill = GridBagConstraints.HORIZONTAL;
		gbc_57.gridx = 4;
		gbc_57.gridy = 8;
		contentPane.add(position[57], gbc_57);
		position[57].setColumns(10);

		position[58] = new JFormattedTextField(f);
		GridBagConstraints gbc_58 = new GridBagConstraints();
		gbc_58.insets = new Insets(0, 0, 5, 5);
		gbc_58.fill = GridBagConstraints.HORIZONTAL;
		gbc_58.gridx = 5;
		gbc_58.gridy = 8;
		contentPane.add(position[58], gbc_58);
		position[58].setColumns(10);

		position[59] = new JFormattedTextField(f);
		GridBagConstraints gbc_59 = new GridBagConstraints();
		gbc_59.insets = new Insets(0, 0, 5, 5);
		gbc_59.fill = GridBagConstraints.HORIZONTAL;
		gbc_59.gridx = 6;
		gbc_59.gridy = 8;
		contentPane.add(position[59], gbc_59);
		position[59].setColumns(10);

		position[60] = new JFormattedTextField(f);
		GridBagConstraints gbc_60 = new GridBagConstraints();
		gbc_60.insets = new Insets(0, 0, 5, 5);
		gbc_60.fill = GridBagConstraints.HORIZONTAL;
		gbc_60.gridx = 8;
		gbc_60.gridy = 8;
		contentPane.add(position[60], gbc_60);
		position[60].setColumns(10);

		position[61] = new JFormattedTextField(f);
		GridBagConstraints gbc_61 = new GridBagConstraints();
		gbc_61.insets = new Insets(0, 0, 5, 5);
		gbc_61.fill = GridBagConstraints.HORIZONTAL;
		gbc_61.gridx = 9;
		gbc_61.gridy = 8;
		contentPane.add(position[61], gbc_61);
		position[61].setColumns(10);

		position[62] = new JFormattedTextField(f);
		GridBagConstraints gbc_62 = new GridBagConstraints();
		gbc_62.insets = new Insets(0, 0, 5, 5);
		gbc_62.fill = GridBagConstraints.HORIZONTAL;
		gbc_62.gridx = 10;
		gbc_62.gridy = 8;
		contentPane.add(position[62], gbc_62);
		position[62].setColumns(10);

		rdbtnDansCode = new JRadioButton("Dan's Code");
		buttonGroup.add(rdbtnDansCode);
		rdbtnDansCode.setSelected(true);
		GridBagConstraints gbc_rdbtnDansCode = new GridBagConstraints();
		gbc_rdbtnDansCode.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnDansCode.gridx = 11;
		gbc_rdbtnDansCode.gridy = 8;
		rdbtnDansCode.addActionListener(new danButtonAL());
		contentPane.add(rdbtnDansCode, gbc_rdbtnDansCode);

		position[63] = new JFormattedTextField(f);
		GridBagConstraints gbc_63 = new GridBagConstraints();
		gbc_63.insets = new Insets(0, 0, 5, 5);
		gbc_63.fill = GridBagConstraints.HORIZONTAL;
		gbc_63.gridx = 0;
		gbc_63.gridy = 9;
		contentPane.add(position[63], gbc_63);
		position[63].setColumns(10);

		position[64] = new JFormattedTextField(f);
		GridBagConstraints gbc_64 = new GridBagConstraints();
		gbc_64.insets = new Insets(0, 0, 5, 5);
		gbc_64.fill = GridBagConstraints.HORIZONTAL;
		gbc_64.gridx = 1;
		gbc_64.gridy = 9;
		contentPane.add(position[64], gbc_64);
		position[64].setColumns(10);

		position[65] = new JFormattedTextField(f);
		GridBagConstraints gbc_65 = new GridBagConstraints();
		gbc_65.insets = new Insets(0, 0, 5, 5);
		gbc_65.fill = GridBagConstraints.HORIZONTAL;
		gbc_65.gridx = 2;
		gbc_65.gridy = 9;
		contentPane.add(position[65], gbc_65);
		position[65].setColumns(10);

		position[66] = new JFormattedTextField(f);
		GridBagConstraints gbc_66 = new GridBagConstraints();
		gbc_66.insets = new Insets(0, 0, 5, 5);
		gbc_66.fill = GridBagConstraints.HORIZONTAL;
		gbc_66.gridx = 4;
		gbc_66.gridy = 9;
		contentPane.add(position[66], gbc_66);
		position[66].setColumns(10);

		position[67] = new JFormattedTextField(f);
		GridBagConstraints gbc_67 = new GridBagConstraints();
		gbc_67.insets = new Insets(0, 0, 5, 5);
		gbc_67.fill = GridBagConstraints.HORIZONTAL;
		gbc_67.gridx = 5;
		gbc_67.gridy = 9;
		contentPane.add(position[67], gbc_67);
		position[67].setColumns(10);

		position[68] = new JFormattedTextField(f);
		GridBagConstraints gbc_68 = new GridBagConstraints();
		gbc_68.insets = new Insets(0, 0, 5, 5);
		gbc_68.fill = GridBagConstraints.HORIZONTAL;
		gbc_68.gridx = 6;
		gbc_68.gridy = 9;
		contentPane.add(position[68], gbc_68);
		position[68].setColumns(10);

		position[69] = new JFormattedTextField(f);
		GridBagConstraints gbc_69 = new GridBagConstraints();
		gbc_69.insets = new Insets(0, 0, 5, 5);
		gbc_69.fill = GridBagConstraints.HORIZONTAL;
		gbc_69.gridx = 8;
		gbc_69.gridy = 9;
		contentPane.add(position[69], gbc_69);
		position[69].setColumns(10);

		position[70] = new JFormattedTextField(f);
		GridBagConstraints gbc_70 = new GridBagConstraints();
		gbc_70.insets = new Insets(0, 0, 5, 5);
		gbc_70.fill = GridBagConstraints.HORIZONTAL;
		gbc_70.gridx = 9;
		gbc_70.gridy = 9;
		contentPane.add(position[70], gbc_70);
		position[70].setColumns(10);

		position[71] = new JFormattedTextField(f);
		GridBagConstraints gbc_71 = new GridBagConstraints();
		gbc_71.insets = new Insets(0, 0, 5, 5);
		gbc_71.fill = GridBagConstraints.HORIZONTAL;
		gbc_71.gridx = 10;
		gbc_71.gridy = 9;
		contentPane.add(position[71], gbc_71);
		position[71].setColumns(10);

		rdbtnBriansCode = new JRadioButton("Brian's Code");
		buttonGroup.add(rdbtnBriansCode);
		GridBagConstraints gbc_rdbtnBriansCode = new GridBagConstraints();
		gbc_rdbtnBriansCode.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnBriansCode.gridx = 11;
		gbc_rdbtnBriansCode.gridy = 9;
		rdbtnBriansCode.addActionListener(new brianButtonAL());
		contentPane.add(rdbtnBriansCode, gbc_rdbtnBriansCode);

		position[72] = new JFormattedTextField(f);
		GridBagConstraints gbc_72 = new GridBagConstraints();
		gbc_72.insets = new Insets(0, 0, 0, 5);
		gbc_72.fill = GridBagConstraints.HORIZONTAL;
		gbc_72.gridx = 0;
		gbc_72.gridy = 10;
		contentPane.add(position[72], gbc_72);
		position[72].setColumns(10);

		position[73] = new JFormattedTextField(f);
		GridBagConstraints gbc_73 = new GridBagConstraints();
		gbc_73.insets = new Insets(0, 0, 0, 5);
		gbc_73.fill = GridBagConstraints.HORIZONTAL;
		gbc_73.gridx = 1;
		gbc_73.gridy = 10;
		contentPane.add(position[73], gbc_73);
		position[73].setColumns(10);

		position[74] = new JFormattedTextField(f);
		GridBagConstraints gbc_74 = new GridBagConstraints();
		gbc_74.insets = new Insets(0, 0, 0, 5);
		gbc_74.fill = GridBagConstraints.HORIZONTAL;
		gbc_74.gridx = 2;
		gbc_74.gridy = 10;
		contentPane.add(position[74], gbc_74);
		position[74].setColumns(10);

		position[75] = new JFormattedTextField(f);
		GridBagConstraints gbc_75 = new GridBagConstraints();
		gbc_75.insets = new Insets(0, 0, 0, 5);
		gbc_75.fill = GridBagConstraints.HORIZONTAL;
		gbc_75.gridx = 4;
		gbc_75.gridy = 10;
		contentPane.add(position[75], gbc_75);
		position[75].setColumns(10);

		position[76] = new JFormattedTextField(f);
		GridBagConstraints gbc_76 = new GridBagConstraints();
		gbc_76.insets = new Insets(0, 0, 0, 5);
		gbc_76.fill = GridBagConstraints.HORIZONTAL;
		gbc_76.gridx = 5;
		gbc_76.gridy = 10;
		contentPane.add(position[76], gbc_76);
		position[76].setColumns(10);

		position[77] = new JFormattedTextField(f);
		GridBagConstraints gbc_77 = new GridBagConstraints();
		gbc_77.insets = new Insets(0, 0, 0, 5);
		gbc_77.fill = GridBagConstraints.HORIZONTAL;
		gbc_77.gridx = 6;
		gbc_77.gridy = 10;
		contentPane.add(position[77], gbc_77);
		position[77].setColumns(10);

		position[78] = new JFormattedTextField(f);
		GridBagConstraints gbc_78 = new GridBagConstraints();
		gbc_78.insets = new Insets(0, 0, 0, 5);
		gbc_78.fill = GridBagConstraints.HORIZONTAL;
		gbc_78.gridx = 8;
		gbc_78.gridy = 10;
		contentPane.add(position[78], gbc_78);
		position[78].setColumns(10);

		position[79] = new JFormattedTextField(f);
		GridBagConstraints gbc_79 = new GridBagConstraints();
		gbc_79.insets = new Insets(0, 0, 0, 5);
		gbc_79.fill = GridBagConstraints.HORIZONTAL;
		gbc_79.gridx = 9;
		gbc_79.gridy = 10;
		contentPane.add(position[79], gbc_79);
		position[79].setColumns(10);

		position[80] = new JFormattedTextField(f);
		GridBagConstraints gbc_80 = new GridBagConstraints();
		gbc_80.insets = new Insets(0, 0, 0, 5);
		gbc_80.fill = GridBagConstraints.HORIZONTAL;
		gbc_80.gridx = 10;
		gbc_80.gridy = 10;
		contentPane.add(position[80], gbc_80);
		position[80].setColumns(10);

		rdbtnStuartsCode = new JRadioButton("Stuart's Code");
		buttonGroup.add(rdbtnStuartsCode);
		GridBagConstraints gbc_rdbtnStewartsCode = new GridBagConstraints();
		gbc_rdbtnStewartsCode.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnStewartsCode.gridx = 11;
		gbc_rdbtnStewartsCode.gridy = 10;
		rdbtnStuartsCode.addActionListener(new stuartButtonAL());
		contentPane.add(rdbtnStuartsCode, gbc_rdbtnStewartsCode);

		lblError = new JLabel("");
		GridBagConstraints gbc_lblError = new GridBagConstraints();
		gbc_lblError.gridwidth = 12;
		gbc_lblError.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblError.gridx = 0;
		gbc_lblError.gridy = 11;
		contentPane.add(lblError, gbc_lblError);

		//Default running actions.
		new danButtonAL().actionPerformed(null);
	}

	//Solve button action to validate and put the results on screen.
	private class solveButtonAL implements ActionListener {
		public void actionPerformed(ActionEvent arg0){
			lblError.setText("");
			lblTime.setText("");
			int[][] input = new int[9][9];
			int spot = 0;

			try {
				for (int i = 0; i < 9; i++)
					for (int j = 0; j < 9; j++){
						if (position[spot].getText().equals(""))
							input[i][j] = 0;
						else
							input[i][j] = Integer.parseInt(position[spot].getText());	
						spot++;
					}

				if (!validate(input)) {
					lblError.setText("Puzzle Invalid! Please make sure it follows the rules of Sudoku. :)");
					return;
				}

			    long startTime = System.nanoTime();
				sudoku.Solve(input);
			    long time = System.nanoTime() - startTime;

				int[][] output = sudoku.Solution();

				spot = 0;
				for (int i = 0; i < 9; i++)
					for (int j = 0; j < 9; j++){
						position[spot].setText("" + output[i][j]);
						spot++;
					}
				lblTime.setText(time + "");
			} catch (NoSolutionStored e) {
				lblError.setText("No solution is stored.");
			} catch (NumberFormatException e) {
				lblError.setText("Letters aren't numbers, put in single digit numbers please.");
				position[spot].requestFocus();
			}
		}
	}

	//Clears the input fields of all numbers
	private class clearButtonAL implements ActionListener {
		public void actionPerformed(ActionEvent arg0){
			for (int i = 0; i < 81; i++)
				position[i].setText("");
			lblError.setText("");
			lblTime.setText("");
		}
	}

	//Dan's Solver
	private class danButtonAL implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			sudoku = new SolverDan();
		}
	}

	//Brian's Solver
	private class brianButtonAL implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			sudoku = new SolverBrian();
		}
	}

	//Stuart's Solver
	private class stuartButtonAL implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			sudoku = new SolverStuart();
		}
	}

	/**
	 * Validates the input array is a valid puzzle
	 * 
	 * @ensure The puzzle passed it will be a solvable sudoku puzzle
	 * @param input array with no null positions.
	 * @return If the puzzle if valid will return true, false if invalid.
	 */
	private boolean validate(int input[][]){
		HashSet<Integer> hs = new HashSet<Integer>();

		//row validate
		for (int i = 0; i < 9; i++){
			hs = new HashSet<Integer>();
			for (int j = 0; j < 9; j++) {
				if (input[i][j] == 0) {
				} else if(!hs.add(input[i][j])) {
					int g = (i * 9) + j;
					position[g].requestFocus();
					return false;
				}
			}
		}

		//column validate
		for (int i = 0; i < 9; i++){
			hs = new HashSet<Integer>();
			for (int j = 0; j < 9; j++) {
				if(input[j][i] == 0){
				} else if (!hs.add(input[j][i])) {
					int g = (j * 9) + i;
					position[g].requestFocus();
					return false;
				}
			}
		}

		//square validate
		for (int i = 0; i < 3; i++){
			int row = i*3;
			for (int j = 0; j < 3; j++){
				hs = new HashSet<Integer>();
				int col = j*3;
				for (int k = 0; k < 3; k++)
					for (int m = 0; m < 3; m++)
						if(input[row+k][col+m] == 0){
						} else if (!hs.add(input[row+k][col+m])) {
							int g = (i * 9) + j;
							position[g].requestFocus();
							return false;
						}
			}
		}

		return true;
	}


}
