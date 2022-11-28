import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class RectangleDemo2 extends JPanel implements ActionListener, KeyListener {
    public int punctaj = 0;
    int lives = 3;
    javax.swing.Timer t1;
    int nrsec = 60;
    RectangleArea2 ra1, ra2, ra3;
    Point catLocation;
    JLabel catLabel, label;
    ImageIcon catIcon = new ImageIcon("cat.png");
    ImageIcon background = new ImageIcon("space.png");
    ImageIcon heartIcon = new ImageIcon("heart.png");
    boolean hit;

    public RectangleDemo2() {

        JFrame f = new JFrame();
        f.setTitle("Vanatoare");
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        f.setContentPane(this);
        f.setSize(600, 800);

        t1 = new javax.swing.Timer(6000, this);
        t1.setInitialDelay(0);
        t1.start();

        setLayout(null);
        catLocation = new Point(250, 700);
        catLabel = new JLabel();
        catLabel.setBackground(Color.white);
        catLabel.setBounds(250, 700, 50, 50);
        catLabel.setOpaque(false);
        catLabel.setIcon(catIcon);
        //f.add(catLabel);
        label = new JLabel("Punctaj: " + punctaj);
        add(label);
        label.setBounds(10, 10, 100, 20);
        f.setLocationRelativeTo(null);
        f.setBackground(Color.white);
        f.addKeyListener(this);
        f.setVisible(true);
        int x1, y1;
        Random r = new Random();
        x1 = r.nextInt(550);
        y1 = r.nextInt(400);

        ra1 = new RectangleArea2(this, x1, y1);
        ra1.setBounds(x1, y1, 50, 50);
        add(ra1);

        x1 = r.nextInt(550);
        y1 = r.nextInt(400);
        ra2 = new RectangleArea2(this, x1, y1);
        ra2.setBounds(x1, y1, 50, 50);
        add(ra2);

        x1 = r.nextInt(550);
        y1 = r.nextInt(400);
        ra3 = new RectangleArea2(this, x1, y1);
        ra3.setBounds(x1, y1, 50, 50);
        add(ra3);
        //repaint();

    }

    public static void main(String[] args) {
        RectangleDemo2 joc = new RectangleDemo2();
    }

    public void actionPerformed(ActionEvent e) {
        if (nrsec > 0) {

            nrsec--;
            int x1, y1;
            Random r = new Random();
            if(ra1 != null){
            x1 = r.nextInt(550);
            y1 = r.nextInt(400);
            ra1.newLoc(x1,y1);}

            if(ra2 != null){
            x1 = r.nextInt(550);
            y1 = r.nextInt(400);
            ra2.newLoc(x1,y1);}

            if(ra3 != null){
            x1 = r.nextInt(550);
            y1 = r.nextInt(400);
            ra3.newLoc(x1,y1);}

            label.setText("Punctaj: " + punctaj);
            repaint();
            punctaj += 30;
            hit = false;

        } else {
            label.setText(punctaj + " ");
            System.out.println(punctaj);
            System.exit(0);
        }

        //hit = !hit;
    }

    @Override
    public void paintComponent(Graphics g) {
       /* g.drawRect(250,800,50,50);
        g.setColor(Color.white);
        g.fillRect(250,800,50,50);*/

        g.drawImage(background.getImage(), 0, 0, null);
        g.drawImage(catIcon.getImage(), catLocation.x, catLocation.y, null);
        //super.paint(g);
        //Graphics2D g2d = (Graphics2D)g;
        int livesLocation = 3;
        for (int i = 0; i < lives; i++) {
            g.drawImage(heartIcon.getImage(), heartIcon.getIconWidth() * livesLocation++, 0, null);
        }
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case 37 -> {
                if (catLocation.x - 10 > 0) {
                    catLocation.x -= 10;
                    ra1.catLocation(catLocation);
                    ra2.catLocation(catLocation);
                    ra3.catLocation(catLocation);

                    if (catLocation.x > ra1.point.x && catLocation.x < (ra1.point.x + 50)
                            && catLocation.y > ra1.point.y && catLocation.y < ra1.point.y + 50 && !hit) {
                        lives--;
                        punctaj -= 5;
                        hit = true;
                        //remove(ra1);
                    }
                    if (catLocation.x > ra2.point.x && catLocation.x < (ra2.point.x + 50)
                            && catLocation.y > ra2.point.y && catLocation.y < ra2.point.y + 50 && !hit) {
                        lives--;
                        System.out.println(lives);
                        punctaj -= 5;
                        hit = true;
                        //remove(ra2);
                    }
                    if (catLocation.x > ra3.point.x && catLocation.x < (ra3.point.x + 50)
                            && catLocation.y > ra3.point.y && catLocation.y < ra3.point.y + 50 && !hit) {
                        lives--;
                        punctaj -= 5;
                        hit = true;
                        //remove(ra3);
                    }
                    repaint();
                    if (lives <= 0) {
                        JOptionPane.showMessageDialog(null,
                                "Lives left: " + lives +"\n Points: " + punctaj,
                                "You were caught!",
                                JOptionPane.INFORMATION_MESSAGE);
                        t1.stop();
                        System.exit(0);
                    }
                }
            }
            case 39 -> {
                if (catLocation.x + 10 < 550) {
                    catLocation.x += 10;
                    ra1.catLocation(catLocation);
                    ra2.catLocation(catLocation);
                    ra3.catLocation(catLocation);

                    if (catLocation.x < ra1.point.x && catLocation.x > (ra1.point.x - 50)
                            && catLocation.y < ra1.point.y && catLocation.y > ra1.point.y - 50 && !hit ) {
                        lives--;
                        punctaj -= 5;
                        hit = true;
                        //remove(ra1);
                    }
                    if (catLocation.x < ra2.point.x && catLocation.x > (ra2.point.x - 50)
                            && catLocation.y < ra2.point.y && catLocation.y > ra2.point.y - 50 && !hit) {
                        lives--;
                        System.out.println(lives);
                        punctaj -= 5;
                        hit = true;
                        //remove(ra2);
                    }
                    if (catLocation.x < ra3.point.x && catLocation.x > (ra3.point.x - 50)
                            && catLocation.y < ra3.point.y && catLocation.y > ra3.point.y - 50 && !hit) {
                        lives--;
                        punctaj -= 5;
                        hit = true;
                        //remove(ra3);
                    }
                    repaint();
                    if (lives <= 0) {
                        JOptionPane.showMessageDialog(null,
                                "Lives left: " + lives +"\n Points: " + punctaj,
                                "You were caught!",
                                JOptionPane.INFORMATION_MESSAGE);
                        t1.stop();
                        System.exit(0);
                    }

                }

            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}

class RectangleArea2 extends JLabel implements ActionListener {
    public Point point;
    RectangleDemo2 controller;
    Point loc = null;
    int rectWidth = 35;
    int rectHeight = 35;
    javax.swing.Timer t;

    public RectangleArea2(RectangleDemo2 c, int x1, int y1) {
        point = new Point(x1, y1);
        controller = c;
        t = new javax.swing.Timer(5, this);
        t.start();

        //System.out.println("creare patrat"+x1+" "+y1);

        addMouseListener(new AscultMouse(this, controller));
    }
    public void newLoc(int x1, int y1){
        point = new Point(x1, y1);
    }
    public void catLocation(Point loc) {
        this.loc = loc;
    }

//final Container panou;

    public void actionPerformed(ActionEvent e) {
        if (point.y < 900) {
            point.y++;

            setLocation(point.x, point.y);
            controller.repaint();
        }
        //else{
            //t.stop();
       // }

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setOpaque(false);
        g.setColor(Color.white);
        //Paint a filled rectangle at user's chosen point.
        if (point != null) {
            //g.setColor(Color.black);
            g.drawRect(0, 0,
                    rectWidth - 1, rectHeight - 1);
            g.setColor(Color.yellow);
            g.fillRect(1, 1,
                    rectWidth - 2, rectHeight - 2);

        }

    }
}

class AscultMouse implements MouseListener {
    RectangleArea2 ra;
    RectangleDemo2 rc;

    public AscultMouse(RectangleArea2 ra, RectangleDemo2 rc) {
        this.ra = ra;
        this.rc = rc;
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();

        if (ra.contains(x, y)) {
            rc.remove(ra);
            rc.repaint();
            rc.punctaj++;
            ra.t.stop();
        }

    }

}
