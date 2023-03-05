import java.awt.*;
import java.awt.event.*;

public class MiVentana extends Frame implements ActionListener {
    TextField txt;
    TextArea txt_history;
    Button btn;
    Button btn_south; // primera opcion de declaracion de variable
    Button btn_east; // btnEast; segunda opcion de declaracion de variable
    Panel p_center;
    Panel p_sum;
    private int num_iks;
    private int num1;
    private int sum;
    Button btn_sum;

    public MiVentana() {
        btn_sum = new Button("+");
        num_iks = 0;
        num1 = 0;
        sum = 0;

        txt = new TextField();
        txt_history = new TextArea();
        btn = new Button("OK");
        btn_south = new Button("SALIR");
        btn_east = new Button("LIMPIAR");
        p_center = new Panel();
        p_center.setLayout(new BorderLayout());
        p_sum = new Panel();
        p_sum.setLayout(new BorderLayout());

        btn.addActionListener(this);
        btn_south.addActionListener(this);
        btn_east.addActionListener(this);
        btn_sum.addActionListener(this);

        this.setLayout(new BorderLayout());
        // this.add(txt, BorderLayout.NORTH);
        p_center.add(btn, BorderLayout.CENTER);
        p_center.add(btn_south, BorderLayout.WEST);
        p_center.add(btn_east, BorderLayout.EAST);
        p_sum.add(btn_sum, BorderLayout.EAST);
        p_sum.add(txt, BorderLayout.CENTER);

        this.add(p_center, BorderLayout.SOUTH);
        this.add(p_sum, BorderLayout.NORTH);
        this.add(txt_history, BorderLayout.CENTER);
        this.setSize(500, 400);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn) {
            num_iks++;
            btn.setLabel(num_iks + "OK");
            txt.setText("=" + sum);
        }

        if (e.getActionCommand().equals("LIMPIAR")) {
            num_iks = 0;
            btn.setLabel("OK");
            txt.setText("");
            txt_history.setText("");
            sum = 0;
        }

        // if (e.getSource() == btn_south) {
        System.out.println(e.getActionCommand());
        if (e.getActionCommand().equals("SALIR")) {
            System.exit(0);
        }
        // }
        if (e.getActionCommand().equals("+")) {
            if (!txt.getText().equals("")) {
                try {

                    num1 = Integer.parseInt(txt.getText());
                    txt_history.append(txt.getText() + "\n");
                    txt.setText("");
                    sum += num1;

                } catch (NumberFormatException ex) {
                    txt.setText("");
                }
            }
        }
    }

}
