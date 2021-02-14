package com.gourmet;

public class Node {

    private String characteristic;
    private Node parentNode;
    private Node rightNode;
    private Node leftNode;
    private NodeDirection nodeDirection;


    public void showQuestion() {
        boolean result = Game.getInstance().showQuestion(characteristic);
        if (result) {
            rightNode.showQuestion();
        } else {
            leftNode.showQuestion();
        }
    }

    public String getCharacteristic() {
        return characteristic;
    }

    public void setCharacteristic(String characteristic) {
        this.characteristic = characteristic;
    }

    public Node getParentNode() {
        return parentNode;
    }

    public void setParentNode(Node parentNode) {
        this.parentNode = parentNode;
    }

    public Node getRightNode() {
        return rightNode;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }

    public Node getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }

    public NodeDirection getNodeDirection() {
        return nodeDirection;
    }

    public void setNodeDirection(NodeDirection nodeDirection) {
        this.nodeDirection = nodeDirection;
    }

    public enum NodeDirection {
        RIGHT, LEFT
    }
}
