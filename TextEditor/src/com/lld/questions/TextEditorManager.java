package com.lld.questions;

import java.util.Stack;

public class TextEditorManager {

    private TextEditorContent textEditorContent = new TextEditorContent();

    private Stack<Memento> undoStack = new Stack<>();
    private Stack<Memento> redoStack = new Stack<>();


    public void addText(String text) {
        Memento memento = textEditorContent.addText(text);
        undoStack.push(memento);
    }

    public void deleteText(int lineNumber) {
        Memento memento = textEditorContent.deleteText(lineNumber);
        undoStack.push(memento);
    }

    public void editText(int lineNumber, String newText) {
        Memento memento = textEditorContent.editText(lineNumber, newText);
        undoStack.push(memento);
    }

    public void copyText(int lineNumber) {
        textEditorContent.copyText(lineNumber);
    }

    public void pasteText(int lineNumber) {
        Memento memento = textEditorContent.pastText(lineNumber);
        undoStack.push(memento);
    }

    public void undo() {
        if(!undoStack.isEmpty()) {
            Memento memento = textEditorContent.restore(undoStack.pop());
            redoStack.push(memento);
        }
    }

    public void redo() {
        if(!redoStack.isEmpty()) {
            Memento memento = textEditorContent.restore(redoStack.pop());
            undoStack.push(memento);
        }
    }

    public void display() {
        System.out.println(textEditorContent.getContentAsString());
    }
}
