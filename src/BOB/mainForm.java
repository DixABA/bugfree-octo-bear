/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BOB;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Администратор
 */
public class mainForm extends javax.swing.JFrame {

    BufferedImage before, after;
    private final int width;
    private final int height;
    Point plBefore, pl = new Point();
    JFileChooser fc = new JFileChooser();
    int[] mask = new int[8];
    Dimension size;

    int processInt(int x) {
        int tmp, res = 0xff000000;

        String edtit = Integer.toHexString(x);
        for (int offset = 0; offset < 3; offset++) {
            tmp = 0;
            for (int bit = 0; bit < 8; bit++) {
                int aaa = 0;

                switch (mask[bit]) {
                    case 1: {
                        aaa = (x >> (offset * 8 + 7)) & 1;
                        break;
                    }
                    case 2: {
                        aaa = (x >> (offset * 8 + 6)) & 1;
                        break;
                    }
                    case 3: {
                        aaa = (x >> (offset * 8 + 5)) & 1;
                        break;
                    }
                    case 4: {
                        aaa = (x >> (offset * 8 + 4)) & 1;
                        break;
                    }
                    case 5: {
                        aaa = (x >> (offset * 8 + 3)) & 1;
                        break;
                    }
                    case 6: {
                        aaa = (x >> (offset * 8 + 2)) & 1;
                        break;
                    }
                    case 7: {
                        aaa = (x >> (offset * 8 + 1)) & 1;
                        break;
                    }
                    case 8: {
                        aaa = (x >> (offset * 8)) & 1;
                        break;
                    }
                    case -1: {
                        aaa = 1 ^ ((x >> (offset * 8 + 7)) & 1);
                        break;
                    }
                    case -2: {
                        aaa = 1 ^ ((x >> (offset * 8 + 6)) & 1);
                        break;
                    }
                    case -3: {
                        aaa = 1 ^ ((x >> (offset * 8 + 5)) & 1);
                        break;
                    }
                    case -4: {
                        aaa = 1 ^ ((x >> (offset * 8 + 4)) & 1);
                        break;
                    }
                    case -5: {
                        aaa = 1 ^ ((x >> (offset * 8 + 3)) & 1);
                        break;
                    }
                    case -6: {
                        aaa = 1 ^ ((x >> (offset * 8 + 2)) & 1);
                        break;
                    }
                    case -7: {
                        aaa = 1 ^ ((x >> (offset * 8 + 1)) & 1);
                        break;
                    }
                    case -8: {
                        aaa = 1 ^ ((x >> (offset * 8)) & 1);
                        break;
                    }
                    case 9: {
                        aaa = 1;
                        break;
                    }
                    default: {
                        aaa = 0;
                    }
                }

                tmp = tmp | (aaa << (7 - bit));
            }
            res = res | (tmp << (offset * 8));
        }
        return res;
    }

    void processImage() {
        try {

//            for (int i = 0; i < 8; i++) {
//                mask[i] = -(i+1);
//            }

            int[] argb = new int[before.getWidth() * before.getHeight()];
            before.getRGB(0, 0, before.getWidth(), before.getHeight(), argb, 0, before.getWidth());

            for (int i = 0; i < argb.length; i++) {
                argb[i] = processInt(argb[i]);
            }

            after.setRGB(0, 0, before.getWidth(), before.getHeight(), argb, 0, before.getWidth());

            picPanel.setPreferredSize(size);
            picPanel.setMaximumSize(size);
            picPanel.setMinimumSize(size);
            this.picPanel.setSize(size);
            this.picPanel.setLocation(pl);

            this.picPanel.setImg(after);
            this.picPanel.repaint();

            argb = null;
        } catch (Exception ex) {
        }
    }

    /**
     * Creates new form mainForm
     */
    public mainForm() {
        initComponents();
        width = this.picPanel.getSize().width;
        height = this.picPanel.getSize().height;
        plBefore = picPanel.getLocation();
        fc.setDialogTitle("Выберите картинку");
        fc.setFileFilter(new FileNameExtensionFilter("Картинки", "jpg", "png", "gif", "bmp", "jpeg"));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        openBtn = new javax.swing.JButton();
        saveBtn = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        favBtn = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        jLabel11 = new javax.swing.JLabel();
        presets = new javax.swing.JComboBox();
        setupPanel = new javax.swing.JPanel();
        bit5Panel = new javax.swing.JPanel();
        bit5Slider = new javax.swing.JSlider();
        bit5Label = new javax.swing.JLabel();
        bit4Panel = new javax.swing.JPanel();
        bit4Slider = new javax.swing.JSlider();
        bit4Label = new javax.swing.JLabel();
        bit8Panel = new javax.swing.JPanel();
        bit8Slider = new javax.swing.JSlider();
        bit8Label = new javax.swing.JLabel();
        bit3Panel = new javax.swing.JPanel();
        bit3Slider = new javax.swing.JSlider();
        bit3Label = new javax.swing.JLabel();
        bit6Panel = new javax.swing.JPanel();
        bit6Slider = new javax.swing.JSlider();
        bit6Label = new javax.swing.JLabel();
        bit1Panel = new javax.swing.JPanel();
        bit1Slider = new javax.swing.JSlider();
        bit1Label = new javax.swing.JLabel();
        bit7Panel = new javax.swing.JPanel();
        bit7Slider = new javax.swing.JSlider();
        bit7Label = new javax.swing.JLabel();
        bit2Panel = new javax.swing.JPanel();
        bit2Slider = new javax.swing.JSlider();
        bit2Label = new javax.swing.JLabel();
        picPanel = new dixaba.JImagePanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        openBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/OpenPic.png"))); // NOI18N
        openBtn.setToolTipText("");
        openBtn.setFocusable(false);
        openBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        openBtn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        openBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openBtnActionPerformed(evt);
            }
        });
        jToolBar1.add(openBtn);

        saveBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/SavePic.png"))); // NOI18N
        saveBtn.setToolTipText("");
        saveBtn.setFocusable(false);
        saveBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        saveBtn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(saveBtn);
        jToolBar1.add(jSeparator1);

        favBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/SavePreset.png"))); // NOI18N
        favBtn.setFocusable(false);
        favBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        favBtn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(favBtn);
        jToolBar1.add(jSeparator2);

        jLabel11.setText("Presets ");
        jToolBar1.add(jLabel11);

        presets.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jToolBar1.add(presets);

        bit5Slider.setMaximum(17);
        bit5Slider.setOrientation(javax.swing.JSlider.VERTICAL);
        bit5Slider.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bit5Slider.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                bit5SliderMouseDragged(evt);
            }
        });
        bit5Slider.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                bit5SliderKeyReleased(evt);
            }
        });

        bit5Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bit5Label.setText("00");

        javax.swing.GroupLayout bit5PanelLayout = new javax.swing.GroupLayout(bit5Panel);
        bit5Panel.setLayout(bit5PanelLayout);
        bit5PanelLayout.setHorizontalGroup(
            bit5PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bit5PanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(bit5PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bit5Label, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bit5PanelLayout.createSequentialGroup()
                        .addComponent(bit5Slider, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        bit5PanelLayout.setVerticalGroup(
            bit5PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bit5PanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bit5Slider, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bit5Label))
        );

        bit4Slider.setMaximum(17);
        bit4Slider.setOrientation(javax.swing.JSlider.VERTICAL);
        bit4Slider.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bit4Slider.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                bit4SliderMouseDragged(evt);
            }
        });
        bit4Slider.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                bit4SliderKeyReleased(evt);
            }
        });

        bit4Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bit4Label.setText("00");

        javax.swing.GroupLayout bit4PanelLayout = new javax.swing.GroupLayout(bit4Panel);
        bit4Panel.setLayout(bit4PanelLayout);
        bit4PanelLayout.setHorizontalGroup(
            bit4PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bit4PanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(bit4PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bit4Label, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bit4PanelLayout.createSequentialGroup()
                        .addComponent(bit4Slider, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        bit4PanelLayout.setVerticalGroup(
            bit4PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bit4PanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bit4Slider, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bit4Label))
        );

        bit8Slider.setMaximum(17);
        bit8Slider.setOrientation(javax.swing.JSlider.VERTICAL);
        bit8Slider.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bit8Slider.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                bit8SliderMouseDragged(evt);
            }
        });
        bit8Slider.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                bit8SliderKeyReleased(evt);
            }
        });

        bit8Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bit8Label.setText("00");

        javax.swing.GroupLayout bit8PanelLayout = new javax.swing.GroupLayout(bit8Panel);
        bit8Panel.setLayout(bit8PanelLayout);
        bit8PanelLayout.setHorizontalGroup(
            bit8PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bit8PanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(bit8PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bit8Label, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bit8PanelLayout.createSequentialGroup()
                        .addComponent(bit8Slider, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        bit8PanelLayout.setVerticalGroup(
            bit8PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bit8PanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bit8Slider, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bit8Label))
        );

        bit3Slider.setMaximum(17);
        bit3Slider.setOrientation(javax.swing.JSlider.VERTICAL);
        bit3Slider.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bit3Slider.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                bit3SliderMouseDragged(evt);
            }
        });
        bit3Slider.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                bit3SliderKeyReleased(evt);
            }
        });

        bit3Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bit3Label.setText("00");

        javax.swing.GroupLayout bit3PanelLayout = new javax.swing.GroupLayout(bit3Panel);
        bit3Panel.setLayout(bit3PanelLayout);
        bit3PanelLayout.setHorizontalGroup(
            bit3PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bit3PanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(bit3PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bit3Label, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bit3PanelLayout.createSequentialGroup()
                        .addComponent(bit3Slider, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        bit3PanelLayout.setVerticalGroup(
            bit3PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bit3PanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bit3Slider, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bit3Label))
        );

        bit6Slider.setMaximum(17);
        bit6Slider.setOrientation(javax.swing.JSlider.VERTICAL);
        bit6Slider.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bit6Slider.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                bit6SliderMouseDragged(evt);
            }
        });
        bit6Slider.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                bit6SliderKeyReleased(evt);
            }
        });

        bit6Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bit6Label.setText("00");

        javax.swing.GroupLayout bit6PanelLayout = new javax.swing.GroupLayout(bit6Panel);
        bit6Panel.setLayout(bit6PanelLayout);
        bit6PanelLayout.setHorizontalGroup(
            bit6PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bit6PanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(bit6PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bit6Label, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bit6PanelLayout.createSequentialGroup()
                        .addComponent(bit6Slider, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        bit6PanelLayout.setVerticalGroup(
            bit6PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bit6PanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bit6Slider, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bit6Label))
        );

        bit1Slider.setMaximum(17);
        bit1Slider.setOrientation(javax.swing.JSlider.VERTICAL);
        bit1Slider.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bit1Slider.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                bit1SliderMouseDragged(evt);
            }
        });
        bit1Slider.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                bit1SliderKeyReleased(evt);
            }
        });

        bit1Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bit1Label.setText("00");

        javax.swing.GroupLayout bit1PanelLayout = new javax.swing.GroupLayout(bit1Panel);
        bit1Panel.setLayout(bit1PanelLayout);
        bit1PanelLayout.setHorizontalGroup(
            bit1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(bit1PanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(bit1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bit1Label, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bit1PanelLayout.createSequentialGroup()
                        .addComponent(bit1Slider, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        bit1PanelLayout.setVerticalGroup(
            bit1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bit1PanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bit1Slider, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bit1Label))
        );

        bit7Slider.setMaximum(17);
        bit7Slider.setOrientation(javax.swing.JSlider.VERTICAL);
        bit7Slider.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bit7Slider.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                bit7SliderMouseDragged(evt);
            }
        });
        bit7Slider.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                bit7SliderKeyReleased(evt);
            }
        });

        bit7Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bit7Label.setText("00");

        javax.swing.GroupLayout bit7PanelLayout = new javax.swing.GroupLayout(bit7Panel);
        bit7Panel.setLayout(bit7PanelLayout);
        bit7PanelLayout.setHorizontalGroup(
            bit7PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bit7PanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(bit7PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bit7Label, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bit7PanelLayout.createSequentialGroup()
                        .addComponent(bit7Slider, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        bit7PanelLayout.setVerticalGroup(
            bit7PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bit7PanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bit7Slider, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bit7Label))
        );

        bit2Slider.setMaximum(17);
        bit2Slider.setOrientation(javax.swing.JSlider.VERTICAL);
        bit2Slider.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bit2Slider.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                bit2SliderMouseDragged(evt);
            }
        });
        bit2Slider.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                bit2SliderKeyReleased(evt);
            }
        });

        bit2Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bit2Label.setText("00");

        javax.swing.GroupLayout bit2PanelLayout = new javax.swing.GroupLayout(bit2Panel);
        bit2Panel.setLayout(bit2PanelLayout);
        bit2PanelLayout.setHorizontalGroup(
            bit2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bit2PanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(bit2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bit2Label, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bit2PanelLayout.createSequentialGroup()
                        .addComponent(bit2Slider, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        bit2PanelLayout.setVerticalGroup(
            bit2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bit2PanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bit2Slider, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bit2Label))
        );

        javax.swing.GroupLayout setupPanelLayout = new javax.swing.GroupLayout(setupPanel);
        setupPanel.setLayout(setupPanelLayout);
        setupPanelLayout.setHorizontalGroup(
            setupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(setupPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bit1Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bit2Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bit3Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bit4Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bit5Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bit6Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bit7Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bit8Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        setupPanelLayout.setVerticalGroup(
            setupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(setupPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(setupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bit1Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bit2Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bit3Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bit4Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bit5Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bit6Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bit7Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bit8Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        picPanel.setBackground(new java.awt.Color(255, 102, 0));

        javax.swing.GroupLayout picPanelLayout = new javax.swing.GroupLayout(picPanel);
        picPanel.setLayout(picPanelLayout);
        picPanelLayout.setHorizontalGroup(
            picPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 384, Short.MAX_VALUE)
        );
        picPanelLayout.setVerticalGroup(
            picPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 399, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(picPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(setupPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(picPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(setupPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void openBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openBtnActionPerformed

        if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            try {
                before = ImageIO.read(fc.getSelectedFile());
                after = ImageIO.read(fc.getSelectedFile());
                int pwidth = before.getWidth();
                int pheight = before.getHeight();

                if ((pheight * 1.0 / pwidth) > (this.height * 1.0 / this.height)) {
                    picPanel.setSize((int) Math.round(pwidth * this.height * 1.0 / pheight), this.height);
                } else {
                    picPanel.setSize(this.width, (int) Math.round(pheight * this.width * 1.0 / pwidth)
                    );
                }

                picPanel.setImg(before);

                pl.setLocation(plBefore);

                pl.x += (this.width - picPanel.getWidth()) / 2;
                pl.y += (this.height - picPanel.getHeight()) / 2;

                picPanel.setLocation(pl);

                picPanel.repaint();

                size = picPanel.getSize();
                picPanel.setPreferredSize(size);
                picPanel.setMaximumSize(size);
                picPanel.setMinimumSize(size);

                this.setTitle("ABACABA!!! " + picPanel.getSize().width + "*" + picPanel.getSize().height);
            } catch (IOException ex) {
            }
        }
    }//GEN-LAST:event_openBtnActionPerformed

    void bit1() {
        String res = "";
        switch (bit1Slider.getValue()) {
            case 17: {//0
                res = "0";
                mask[0] = 0;
                break;
            }
            case 16: {//1
                res = "1";
                mask[0] = 9;
                break;
            }
            case 15: {//a
                res = "a";
                mask[0] = 1;
                break;
            }
            case 14: {//b
                res = "b";
                mask[0] = 2;
                break;
            }
            case 13: {//c
                res = "c";
                mask[0] = 3;
                break;
            }
            case 12: {//d
                res = "d";
                mask[0] = 4;
                break;
            }
            case 11: {//e
                res = "e";
                mask[0] = 5;
                break;
            }
            case 10: {//f
                res = "f";
                mask[0] = 6;
                break;
            }
            case 9: {//g
                res = "g";
                mask[0] = 7;
                break;
            }
            case 8: {//h
                res = "h";
                mask[0] = 8;
                break;
            }
            case 7: {//-a
                res = "-a";
                mask[0] = -1;
                break;
            }
            case 6: {//-b
                res = "-b";
                mask[0] = -2;
                break;
            }
            case 5: {//-c
                res = "-c";
                mask[0] = -3;
                break;
            }
            case 4: {//-d
                res = "-d";
                mask[0] = -4;
                break;
            }
            case 3: {//-e
                res = "-e";
                mask[0] = -5;
                break;
            }
            case 2: {//-f
                res = "-f";
                mask[0] = -6;
                break;
            }
            case 1: {//-g
                res = "-g";
                mask[0] = -7;
                break;
            }
            case 0: {//-h
                res = "-h";
                mask[0] = -8;
                break;
            }
        }

        bit1Label.setText(res);
        processImage();
    }

    void bit2() {
        String res = "";
        switch (bit2Slider.getValue()) {
            case 17: {//0
                res = "0";
                mask[1] = 0;
                break;
            }
            case 16: {//1
                res = "1";
                mask[1] = 9;
                break;
            }
            case 15: {//a
                res = "a";
                mask[1] = 1;
                break;
            }
            case 14: {//b
                res = "b";
                mask[1] = 2;
                break;
            }
            case 13: {//c
                res = "c";
                mask[1] = 3;
                break;
            }
            case 12: {//d
                res = "d";
                mask[1] = 4;
                break;
            }
            case 11: {//e
                res = "e";
                mask[1] = 5;
                break;
            }
            case 10: {//f
                res = "f";
                mask[1] = 6;
                break;
            }
            case 9: {//g
                res = "g";
                mask[1] = 7;
                break;
            }
            case 8: {//h
                res = "h";
                mask[1] = 8;
                break;
            }
            case 7: {//-a
                res = "-a";
                mask[1] = -1;
                break;
            }
            case 6: {//-b
                res = "-b";
                mask[1] = -2;
                break;
            }
            case 5: {//-c
                res = "-c";
                mask[1] = -3;
                break;
            }
            case 4: {//-d
                res = "-d";
                mask[1] = -4;
                break;
            }
            case 3: {//-e
                res = "-e";
                mask[1] = -5;
                break;
            }
            case 2: {//-f
                res = "-f";
                mask[1] = -6;
                break;
            }
            case 1: {//-g
                res = "-g";
                mask[1] = -7;
                break;
            }
            case 0: {//-h
                res = "-h";
                mask[1] = -8;
                break;
            }
        }

        bit2Label.setText(res);
        processImage();
    }

    void bit3() {
        String res = "";
        switch (bit3Slider.getValue()) {
            case 17: {//0
                res = "0";
                mask[2] = 0;
                break;
            }
            case 16: {//1
                res = "1";
                mask[2] = 9;
                break;
            }
            case 15: {//a
                res = "a";
                mask[2] = 1;
                break;
            }
            case 14: {//b
                res = "b";
                mask[2] = 2;
                break;
            }
            case 13: {//c
                res = "c";
                mask[2] = 3;
                break;
            }
            case 12: {//d
                res = "d";
                mask[2] = 4;
                break;
            }
            case 11: {//e
                res = "e";
                mask[2] = 5;
                break;
            }
            case 10: {//f
                res = "f";
                mask[2] = 6;
                break;
            }
            case 9: {//g
                res = "g";
                mask[2] = 7;
                break;
            }
            case 8: {//h
                res = "h";
                mask[2] = 8;
                break;
            }
            case 7: {//-a
                res = "-a";
                mask[2] = -1;
                break;
            }
            case 6: {//-b
                res = "-b";
                mask[2] = -2;
                break;
            }
            case 5: {//-c
                res = "-c";
                mask[2] = -3;
                break;
            }
            case 4: {//-d
                res = "-d";
                mask[2] = -4;
                break;
            }
            case 3: {//-e
                res = "-e";
                mask[2] = -5;
                break;
            }
            case 2: {//-f
                res = "-f";
                mask[2] = -6;
                break;
            }
            case 1: {//-g
                res = "-g";
                mask[2] = -7;
                break;
            }
            case 0: {//-h
                res = "-h";
                mask[2] = -8;
                break;
            }
        }

        bit3Label.setText(res);
        processImage();
    }

    void bit4() {
        String res = "";
        switch (bit4Slider.getValue()) {
            case 17: {//0
                res = "0";
                mask[3] = 0;
                break;
            }
            case 16: {//1
                res = "1";
                mask[3] = 9;
                break;
            }
            case 15: {//a
                res = "a";
                mask[3] = 1;
                break;
            }
            case 14: {//b
                res = "b";
                mask[3] = 2;
                break;
            }
            case 13: {//c
                res = "c";
                mask[3] = 3;
                break;
            }
            case 12: {//d
                res = "d";
                mask[3] = 4;
                break;
            }
            case 11: {//e
                res = "e";
                mask[3] = 5;
                break;
            }
            case 10: {//f
                res = "f";
                mask[3] = 6;
                break;
            }
            case 9: {//g
                res = "g";
                mask[3] = 7;
                break;
            }
            case 8: {//h
                res = "h";
                mask[3] = 8;
                break;
            }
            case 7: {//-a
                res = "-a";
                mask[3] = -1;
                break;
            }
            case 6: {//-b
                res = "-b";
                mask[3] = -2;
                break;
            }
            case 5: {//-c
                res = "-c";
                mask[3] = -3;
                break;
            }
            case 4: {//-d
                res = "-d";
                mask[3] = -4;
                break;
            }
            case 3: {//-e
                res = "-e";
                mask[3] = -5;
                break;
            }
            case 2: {//-f
                res = "-f";
                mask[3] = -6;
                break;
            }
            case 1: {//-g
                res = "-g";
                mask[3] = -7;
                break;
            }
            case 0: {//-h
                res = "-h";
                mask[3] = -8;
                break;
            }
        }

        bit4Label.setText(res);
        processImage();
    }

    void bit5() {
        String res = "";
        switch (bit5Slider.getValue()) {
            case 17: {//0
                res = "0";
                mask[4] = 0;
                break;
            }
            case 16: {//1
                res = "1";
                mask[4] = 9;
                break;
            }
            case 15: {//a
                res = "a";
                mask[4] = 1;
                break;
            }
            case 14: {//b
                res = "b";
                mask[4] = 2;
                break;
            }
            case 13: {//c
                res = "c";
                mask[4] = 3;
                break;
            }
            case 12: {//d
                res = "d";
                mask[4] = 4;
                break;
            }
            case 11: {//e
                res = "e";
                mask[4] = 5;
                break;
            }
            case 10: {//f
                res = "f";
                mask[4] = 6;
                break;
            }
            case 9: {//g
                res = "g";
                mask[4] = 7;
                break;
            }
            case 8: {//h
                res = "h";
                mask[4] = 8;
                break;
            }
            case 7: {//-a
                res = "-a";
                mask[4] = -1;
                break;
            }
            case 6: {//-b
                res = "-b";
                mask[4] = -2;
                break;
            }
            case 5: {//-c
                res = "-c";
                mask[4] = -3;
                break;
            }
            case 4: {//-d
                res = "-d";
                mask[4] = -4;
                break;
            }
            case 3: {//-e
                res = "-e";
                mask[4] = -5;
                break;
            }
            case 2: {//-f
                res = "-f";
                mask[4] = -6;
                break;
            }
            case 1: {//-g
                res = "-g";
                mask[4] = -7;
                break;
            }
            case 0: {//-h
                res = "-h";
                mask[4] = -8;
                break;
            }
        }

        bit5Label.setText(res);
        processImage();
    }

    void bit6() {
        String res = "";
        switch (bit6Slider.getValue()) {
            case 17: {//0
                res = "0";
                mask[5] = 0;
                break;
            }
            case 16: {//1
                res = "1";
                mask[5] = 9;
                break;
            }
            case 15: {//a
                res = "a";
                mask[5] = 1;
                break;
            }
            case 14: {//b
                res = "b";
                mask[5] = 2;
                break;
            }
            case 13: {//c
                res = "c";
                mask[5] = 3;
                break;
            }
            case 12: {//d
                res = "d";
                mask[5] = 4;
                break;
            }
            case 11: {//e
                res = "e";
                mask[5] = 5;
                break;
            }
            case 10: {//f
                res = "f";
                mask[5] = 6;
                break;
            }
            case 9: {//g
                res = "g";
                mask[5] = 7;
                break;
            }
            case 8: {//h
                res = "h";
                mask[5] = 8;
                break;
            }
            case 7: {//-a
                res = "-a";
                mask[5] = -1;
                break;
            }
            case 6: {//-b
                res = "-b";
                mask[5] = -2;
                break;
            }
            case 5: {//-c
                res = "-c";
                mask[5] = -3;
                break;
            }
            case 4: {//-d
                res = "-d";
                mask[5] = -4;
                break;
            }
            case 3: {//-e
                res = "-e";
                mask[5] = -5;
                break;
            }
            case 2: {//-f
                res = "-f";
                mask[5] = -6;
                break;
            }
            case 1: {//-g
                res = "-g";
                mask[5] = -7;
                break;
            }
            case 0: {//-h
                res = "-h";
                mask[5] = -8;
                break;
            }
        }

        bit6Label.setText(res);
        processImage();
    }

    void bit7() {
        String res = "";
        switch (bit7Slider.getValue()) {
            case 17: {//0
                res = "0";
                mask[6] = 0;
                break;
            }
            case 16: {//1
                res = "1";
                mask[6] = 9;
                break;
            }
            case 15: {//a
                res = "a";
                mask[6] = 1;
                break;
            }
            case 14: {//b
                res = "b";
                mask[6] = 2;
                break;
            }
            case 13: {//c
                res = "c";
                mask[6] = 3;
                break;
            }
            case 12: {//d
                res = "d";
                mask[6] = 4;
                break;
            }
            case 11: {//e
                res = "e";
                mask[6] = 5;
                break;
            }
            case 10: {//f
                res = "f";
                mask[6] = 6;
                break;
            }
            case 9: {//g
                res = "g";
                mask[6] = 7;
                break;
            }
            case 8: {//h
                res = "h";
                mask[6] = 8;
                break;
            }
            case 7: {//-a
                res = "-a";
                mask[6] = -1;
                break;
            }
            case 6: {//-b
                res = "-b";
                mask[6] = -2;
                break;
            }
            case 5: {//-c
                res = "-c";
                mask[6] = -3;
                break;
            }
            case 4: {//-d
                res = "-d";
                mask[6] = -4;
                break;
            }
            case 3: {//-e
                res = "-e";
                mask[6] = -5;
                break;
            }
            case 2: {//-f
                res = "-f";
                mask[6] = -6;
                break;
            }
            case 1: {//-g
                res = "-g";
                mask[6] = -7;
                break;
            }
            case 0: {//-h
                res = "-h";
                mask[6] = -8;
                break;
            }
        }

        bit7Label.setText(res);
        processImage();
    }

    void bit8() {
        String res = "";
        switch (bit8Slider.getValue()) {
            case 17: {//0
                res = "0";
                mask[7] = 0;
                break;
            }
            case 16: {//1
                res = "1";
                mask[7] = 9;
                break;
            }
            case 15: {//a
                res = "a";
                mask[7] = 1;
                break;
            }
            case 14: {//b
                res = "b";
                mask[7] = 2;
                break;
            }
            case 13: {//c
                res = "c";
                mask[7] = 3;
                break;
            }
            case 12: {//d
                res = "d";
                mask[7] = 4;
                break;
            }
            case 11: {//e
                res = "e";
                mask[7] = 5;
                break;
            }
            case 10: {//f
                res = "f";
                mask[7] = 6;
                break;
            }
            case 9: {//g
                res = "g";
                mask[7] = 7;
                break;
            }
            case 8: {//h
                res = "h";
                mask[7] = 8;
                break;
            }
            case 7: {//-a
                res = "-a";
                mask[7] = -1;
                break;
            }
            case 6: {//-b
                res = "-b";
                mask[7] = -2;
                break;
            }
            case 5: {//-c
                res = "-c";
                mask[7] = -3;
                break;
            }
            case 4: {//-d
                res = "-d";
                mask[7] = -4;
                break;
            }
            case 3: {//-e
                res = "-e";
                mask[7] = -5;
                break;
            }
            case 2: {//-f
                res = "-f";
                mask[7] = -6;
                break;
            }
            case 1: {//-g
                res = "-g";
                mask[7] = -7;
                break;
            }
            case 0: {//-h
                res = "-h";
                mask[7] = -8;
                break;
            }
        }

        bit8Label.setText(res);
        processImage();
    }

    private void bit1SliderKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bit1SliderKeyReleased
        bit1();
    }//GEN-LAST:event_bit1SliderKeyReleased

    private void bit1SliderMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bit1SliderMouseDragged
        bit1();
    }//GEN-LAST:event_bit1SliderMouseDragged

    private void bit2SliderKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bit2SliderKeyReleased
        bit2();
    }//GEN-LAST:event_bit2SliderKeyReleased

    private void bit2SliderMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bit2SliderMouseDragged
        bit2();
    }//GEN-LAST:event_bit2SliderMouseDragged

    private void bit3SliderKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bit3SliderKeyReleased
        bit3();
    }//GEN-LAST:event_bit3SliderKeyReleased

    private void bit3SliderMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bit3SliderMouseDragged
        bit3();
    }//GEN-LAST:event_bit3SliderMouseDragged

    private void bit4SliderMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bit4SliderMouseDragged
        bit4();
    }//GEN-LAST:event_bit4SliderMouseDragged

    private void bit4SliderKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bit4SliderKeyReleased
        bit4();
    }//GEN-LAST:event_bit4SliderKeyReleased

    private void bit5SliderMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bit5SliderMouseDragged
        bit5();
    }//GEN-LAST:event_bit5SliderMouseDragged

    private void bit5SliderKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bit5SliderKeyReleased
        bit5();
    }//GEN-LAST:event_bit5SliderKeyReleased

    private void bit6SliderMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bit6SliderMouseDragged
        bit6();
    }//GEN-LAST:event_bit6SliderMouseDragged

    private void bit6SliderKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bit6SliderKeyReleased
        bit6();
    }//GEN-LAST:event_bit6SliderKeyReleased

    private void bit7SliderKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bit7SliderKeyReleased
        bit7();
    }//GEN-LAST:event_bit7SliderKeyReleased

    private void bit7SliderMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bit7SliderMouseDragged
        bit7();
    }//GEN-LAST:event_bit7SliderMouseDragged

    private void bit8SliderKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bit8SliderKeyReleased
        bit8();
    }//GEN-LAST:event_bit8SliderKeyReleased

    private void bit8SliderMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bit8SliderMouseDragged
        bit8();
    }//GEN-LAST:event_bit8SliderMouseDragged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new mainForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bit1Label;
    private javax.swing.JPanel bit1Panel;
    private javax.swing.JSlider bit1Slider;
    private javax.swing.JLabel bit2Label;
    private javax.swing.JPanel bit2Panel;
    private javax.swing.JSlider bit2Slider;
    private javax.swing.JLabel bit3Label;
    private javax.swing.JPanel bit3Panel;
    private javax.swing.JSlider bit3Slider;
    private javax.swing.JLabel bit4Label;
    private javax.swing.JPanel bit4Panel;
    private javax.swing.JSlider bit4Slider;
    private javax.swing.JLabel bit5Label;
    private javax.swing.JPanel bit5Panel;
    private javax.swing.JSlider bit5Slider;
    private javax.swing.JLabel bit6Label;
    private javax.swing.JPanel bit6Panel;
    private javax.swing.JSlider bit6Slider;
    private javax.swing.JLabel bit7Label;
    private javax.swing.JPanel bit7Panel;
    private javax.swing.JSlider bit7Slider;
    private javax.swing.JLabel bit8Label;
    private javax.swing.JPanel bit8Panel;
    private javax.swing.JSlider bit8Slider;
    private javax.swing.JButton favBtn;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JButton openBtn;
    private dixaba.JImagePanel picPanel;
    private javax.swing.JComboBox presets;
    private javax.swing.JButton saveBtn;
    private javax.swing.JPanel setupPanel;
    // End of variables declaration//GEN-END:variables
}
