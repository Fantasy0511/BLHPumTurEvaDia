package bll.diagnosis.tree.model;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;


@SuppressWarnings("serial")
public class ModifyTree extends JPanel{
	
	private JTree edibleTree;
	private JScrollPane treeScrollPane;
	private DefaultMutableTreeNode root;
	private JPopupMenu pop;
	private DefaultTreeModel faultTree;
	private DefaultMutableTreeNode selectedNode;
	private DefaultMutableTreeNode tempNode;
	private JMenuItem cutNode;
	private JMenuItem pasteNode;
	
	private ArrayList<Node> nodes;
	private ArrayList<String> equations = new ArrayList<String>();
	
	public ModifyTree(ArrayList<Node> treeNodes){

		super();
		
		nodes = treeNodes;
		
		root = makeSampleTree();
		faultTree = new DefaultTreeModel(root);
		edibleTree = new JTree(faultTree);
		edibleTree.setEditable(true);
	    pop = new JPopupMenu();
	    edibleTree.addMouseListener(new MouseAdapter(){
	    	public void mousePressed(MouseEvent e) {
	    		if (e.getButton() == MouseEvent.BUTTON3)
	    			pop.show(edibleTree, e.getX(), e.getY());
        	}	
        });
	    
	    treeScrollPane = new JScrollPane(edibleTree);
	    treeScrollPane.setPreferredSize(new Dimension(100,600));

	    cutNode = new JMenuItem("what1");
	    cutNode.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent event){
	    		tempNode = (DefaultMutableTreeNode)edibleTree.getLastSelectedPathComponent();
	    		if(tempNode != null && tempNode.getParent() != null){
	    			DefaultMutableTreeNode parent = (DefaultMutableTreeNode)tempNode.getParent();
	    			deleteNode(parent,tempNode);
	    			faultTree.removeNodeFromParent(tempNode);
	    			cutNode.setEnabled(false);
	    			pasteNode.setEnabled(true);
	    			//View.application.setOperation(false);
	    			//View.application.setNodes(nodes);
	    			//View.application.refresh();
	    		}
	    	}
	    });
	    
	    pasteNode = new JMenuItem("what2");
	    pasteNode.setEnabled(false);
	    pasteNode.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent event) {
	    		selectedNode = (DefaultMutableTreeNode)edibleTree.getLastSelectedPathComponent();
	    		if(selectedNode == null)
	    			return;
	    		addNode(selectedNode,tempNode);
	    		faultTree.insertNodeInto(tempNode, selectedNode, selectedNode.getChildCount());
	    		TreeNode[] treeNodes = faultTree.getPathToRoot(tempNode);
	    		TreePath path = new TreePath(treeNodes);
	    		edibleTree.scrollPathToVisible(path);
	    		cutNode.setEnabled(true);
		        pasteNode.setEnabled(false);
		        //View.application.setOperation(true);
		        //View.application.setNodes(nodes);
		        //View.application.setEquations();
		        //View.application.refresh();
	    	}
	    });
	    
	    pop.add(cutNode);
	    pop.add(pasteNode);
	    
	    setLayout(new BorderLayout());
	    add(treeScrollPane,BorderLayout.CENTER);
	}
	
	public DefaultTreeModel getModel(){
		return faultTree;
	}
	
	public ArrayList<Node> getNodes(){
		return nodes;
	}
	
	public void setNodes(ArrayList<Node> treeNodes){
		nodes = treeNodes;
	}
	
	public ArrayList<String> getEquations(){
		return equations;
	}
	
	public void deleteNode(DefaultMutableTreeNode parent, DefaultMutableTreeNode child){
		String pname = (String)parent.getUserObject();
		String cname = (String)child.getUserObject();
		for(int i = 0; i < nodes.size(); i++){
			Node dest = nodes.get(i);
			if(dest.name.equals(pname)){
				ArrayList<String> array = dest.children;
				for(int j = 0; j < array.size(); j++){
					if(array.get(j).equals(cname)){
						array.remove(j);
						dest.children = array;
						return;
					}
				}
			}
		}
	}
	
	public void addNode(DefaultMutableTreeNode parent, DefaultMutableTreeNode child){
		String pname = (String)parent.getUserObject();
		String cname = (String)child.getUserObject();
		for(int i = 0; i < nodes.size(); i++){
			Node dest = nodes.get(i);
			if(dest.name.equals(pname)){
				ArrayList<String> array = dest.children;
				array.add(cname);
				dest.children = array;
			}
		}
	}
	
	public void setModel(DefaultTreeModel tree){
		faultTree = tree;
		root = (DefaultMutableTreeNode)faultTree.getRoot();
		edibleTree.setModel(tree);
	}
	
	public DefaultMutableTreeNode makeSampleTree(){
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("JTree");
		return root;
	}
}
