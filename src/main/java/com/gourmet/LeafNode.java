package com.gourmet;

public class LeafNode extends Node {

    private String name;

    @Override
    public void showQuestion() {
        boolean result = Game.getInstance().showQuestion(name);
        if (result) {
            Game.getInstance().showResult();
            return;
        }
        createNewNode();
    }

    private void createNewNode() {
        Node newNode = new Node();
        setNewNodeDirection(newNode);

        String newName = Game.getInstance().showNewFoodDialog();
        String newCharacteristic = Game.getInstance().showNewCharacteristicDialog(newName, this.name);

        LeafNode newLeafNode = new LeafNode();
        newLeafNode.setName(newName);
        newNode.setParentNode(getParentNode());
        newNode.setCharacteristic(newCharacteristic);

        newNode.setRightNode(newLeafNode);
        newLeafNode.setNodeDirection(NodeDirection.RIGHT);
        newLeafNode.setParentNode(newNode);

        newNode.setLeftNode(this);
        this.setNodeDirection(NodeDirection.LEFT);
        this.setParentNode(newNode);
    }

    private void setNewNodeDirection(Node node) {
        if (getNodeDirection() == NodeDirection.RIGHT) {
            node.setNodeDirection(NodeDirection.RIGHT);
            getParentNode().setRightNode(node);
            return;
        }
        node.setNodeDirection(NodeDirection.LEFT);
        getParentNode().setLeftNode(node);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
