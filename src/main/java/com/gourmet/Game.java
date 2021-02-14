package com.gourmet;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Game {

    private static Game instance;
    private Node node;
    private JFrame jFrame;

    private Game() {
    }

    public static synchronized Game getInstance() {
        if (instance == null) {
            instance = new Game();
        }
        return instance;
    }

    public void start() {
        if (jFrame != null) {
            return;
        }
        createFrame();
        createNode();
        createRightNode();
        createLeftNode();
    }

    private void createFrame() {
        jFrame = new JFrame();
        jFrame.setTitle("Jogo Gourmet");
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setContentPane(createContent());
        jFrame.pack();
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
    }

    private Box createContent() {
        Border padding = BorderFactory.createEmptyBorder(20, 50, 20, 50);
        JButton button = new JButton("OK");
        button.addActionListener(e -> node.showQuestion());
        button.setAlignmentX(0.5f);
        JLabel label = new JLabel("Pense em um prato que gosta");
        label.setAlignmentX(0.5f);

        Box verticalBox = Box.createVerticalBox();
        verticalBox.setBorder(padding);
        verticalBox.add(label);
        verticalBox.add(Box.createRigidArea(new Dimension(0, 10)));
        verticalBox.add(button);
        return verticalBox;
    }

    private void createNode() {
        node = new Node();
        node.setCharacteristic("massa");
        node.setNodeDirection(Node.NodeDirection.RIGHT);
    }

    private void createRightNode() {
        LeafNode rightNode = new LeafNode();
        rightNode.setName("Lasanha");
        rightNode.setNodeDirection(Node.NodeDirection.RIGHT);
        rightNode.setParentNode(node);
        node.setRightNode(rightNode);
    }

    private void createLeftNode() {
        LeafNode leftNode = new LeafNode();
        leftNode.setName("Bolo de chocolate");
        leftNode.setNodeDirection(Node.NodeDirection.LEFT);
        leftNode.setParentNode(node);
        node.setLeftNode(leftNode);
    }

    public boolean showQuestion(String feature) {
        String question = String.format("O prato que você pensou é %s?", feature);
        int result = JOptionPane.showConfirmDialog(jFrame, question, "Confirm", JOptionPane.YES_NO_OPTION);
        return result == JOptionPane.YES_OPTION;
    }

    public void showResult() {
        JOptionPane.showMessageDialog(jFrame, "Acertei de novo!", "Jogo Gourmet", JOptionPane.INFORMATION_MESSAGE);
    }

    public String showNewFoodDialog() {
        return JOptionPane.showInputDialog(jFrame, "Qual prato você pensou?", "Desisto", JOptionPane.QUESTION_MESSAGE);
    }

    public String showNewCharacteristicDialog(String oldFood, String lastFood) {
        return JOptionPane.showInputDialog(jFrame, oldFood + " é _______ mas " + lastFood + " não.", "Complete", JOptionPane.QUESTION_MESSAGE);
    }
}
