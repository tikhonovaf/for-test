package ru.tikhonovaf.samples.patterns.behavioral.memento;

import java.util.Stack;

// --------- Memento ----------
class EditorState {
    private final String content;

    public EditorState(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}

// --------- Originator ----------
class Editor {
    private String content = "";

    public void type(String words) {
        content += words;
    }

    public String getContent() {
        return content;
    }

    public EditorState save() {
        return new EditorState(content);
    }

    public void restore(EditorState state) {
        content = state.getContent();
    }
}

// --------- Caretaker ----------
class History {
    private final Stack<EditorState> states = new Stack<>();

    public void push(EditorState state) {
        states.push(state);
    }

    public EditorState pop() {
        if (!states.isEmpty()) {
            return states.pop();
        }
        return null;
    }
}

// --------- Main ----------
public class MementoDemo {
    public static void main(String[] args) {
        Editor editor = new Editor();
        History history = new History();

        editor.type("Hello");
        history.push(editor.save());

        editor.type(", world!");
        history.push(editor.save());

        System.out.println("Current content: " + editor.getContent());

        System.out.println("Undo 1:");
        editor.restore(history.pop());
        System.out.println(editor.getContent());

        System.out.println("Undo 2:");
        editor.restore(history.pop());
        System.out.println(editor.getContent());
    }
}
