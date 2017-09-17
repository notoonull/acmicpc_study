package acmicpc_1991;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char data[][] = new char[N][3];
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			data[i][0] = line.charAt(0);
			data[i][1] = line.charAt(2);
			data[i][2] = line.charAt(4);
		}
		Tree tree = new Tree(data);
		tree.printTree("preorder");
		tree.printTree("inorder");
		tree.printTree("postorder");
	}
}

class TreeNode {
	private char data;
	private TreeNode left;
	private TreeNode right;

	TreeNode(char data) {
		this.setData(data);
		this.left = null;
		this.right = null;
	}

	TreeNode(char data, TreeNode left, TreeNode right) {
		this.setData(data);
		this.setLeft(left);
		this.setRight(right);
	}

	public void setData(char data) {
		this.data = data;
	}

	public char getData() {
		return this.data;
	}

	public void setLeft(TreeNode left) {
		this.left = left;
	}

	public void setRight(TreeNode right) {
		this.right = right;
	}

	public TreeNode getLeft() {
		return this.left;
	}

	public TreeNode getRight() {
		return this.right;
	}
}

class Tree {
	private int nodeCount;
	private TreeNode root;
	private TreeNode nodes[];
	private StringBuilder printBuffer;

	Tree(char data[][]) {
		this.nodeCount = data.length;
		nodes = new TreeNode[this.nodeCount];
		this.initNode(data);
		this.setRoot(nodes[0]);
	}

	public void printTree(String options) {
		printBuffer = new StringBuilder();
		if (options.equals("preorder")) {
			preorder(this.root);
			System.out.println(printBuffer);
		}

		if (options.equals("inorder")) {
			inorder(this.root);
			System.out.println(printBuffer);
		}

		if (options.equals("postorder")) {
			postorder(this.root);
			System.out.println(printBuffer);
		}
	}

	private void preorder(TreeNode node) {
		if (node != null) {
			printBuffer.append(node.getData());
			preorder(node.getLeft());
			preorder(node.getRight());
		}
	}

	private void inorder(TreeNode node) {
		if (node != null) {
			inorder(node.getLeft());
			printBuffer.append(node.getData());
			inorder(node.getRight());
		}
	}

	private void postorder(TreeNode node) {
		if (node != null) {
			postorder(node.getLeft());
			postorder(node.getRight());
			printBuffer.append(node.getData());
		}
	}

	private void setRoot(TreeNode root) {
		this.root = root;
	}

	private void initNode(char data[][]) {
		for (int i = 0; i < this.nodeCount; i++) {
			TreeNode left = null;
			TreeNode right = null;
			if (data[i][1] != '.') {
				if (nodes[data[i][1] - 'A'] == null) {
					nodes[data[i][1] - 'A'] = new TreeNode(data[i][1]);
				}
				left = nodes[data[i][1] - 'A'];
			}

			if (data[i][2] != '.') {
				if (nodes[data[i][2] - 'A'] == null) {
					nodes[data[i][2] - 'A'] = new TreeNode(data[i][2]);
				}
				right = nodes[data[i][2] - 'A'];
			}

			if (nodes[data[i][0] - 'A'] == null) {
				nodes[data[i][0] - 'A'] = new TreeNode(data[i][0], left, right);
			} else {
				nodes[data[i][0] - 'A'].setLeft(left);
				nodes[data[i][0] - 'A'].setRight(right);
			}
		}
	}
}