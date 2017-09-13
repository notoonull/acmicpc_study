package acmicpc_10828;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StackManager stackManager = new StackManager();
		for (int i = 0; i < N; i++) {
			String command = br.readLine();
			stackManager.execute(command);
		}
	}
}

final class Stack {
	ArrayList<Integer> storage;

	Stack() {
		this.storage = new ArrayList<Integer>();
	}

	public void push(int item) {
		this.storage.add(item);
	}

	public int pop() {
		if (this.storage.size() == 0) {
			return -1;
		} else {
			int data = this.storage.get(this.storage.size() - 1);
			this.storage.remove(this.storage.size() - 1);
			return data;
		}
	}

	public int size() {
		return this.storage.size();
	}

	public int empty() {
		return (this.storage.size() == 0) ? (1) : (0);
	}

	public int top() {
		if (this.storage.size() == 0) {
			return -1;
		} else {
			int data = this.storage.get(this.storage.size() - 1);
			return data;
		}
	}
}

final class StackManager {
	Stack stack;

	StackManager() {
		stack = new Stack();
	}

	public void execute(String command) throws Exception {
		String[] arguments = parseArguments(command);
		Method methods[] = stack.getClass().getDeclaredMethods();
		String methodName;
		int parameterCount = 0, i;
		for (i = 0; i < methods.length; i++) {
			methodName = methods[i].getName();
			parameterCount = methods[i].getParameterCount();

			if (methodName.equals(arguments[0]))
				break;
		}

		if (parameterCount == 1) {
			methods[i].invoke(stack, Integer.parseInt(arguments[1]));
		} else {
			int result = (int) methods[i].invoke(stack);
			System.out.println(result);
		}
	}

	private String[] parseArguments(String command) {
		StringTokenizer st = new StringTokenizer(command);
		int argc = st.countTokens();
		String[] arguments = new String[argc];
		for (int i = 0; i < argc; i++) {
			arguments[i] = st.nextToken();
		}
		return arguments;
	}
}
