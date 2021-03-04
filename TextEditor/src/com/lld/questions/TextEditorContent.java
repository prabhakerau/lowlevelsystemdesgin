package com.lld.questions;

import java.util.ArrayList;
import java.util.List;

public class TextEditorContent {

    private List<StringBuilder> lineContents = new ArrayList<>();
    private StringBuilder copiedText = null;
    private Memento currentMemento = null;


    public Memento addText(String text) {
        initializeMemento();
        lineContents.add(new StringBuilder(text));
        return currentMemento;
    }

    public Memento editText(int lineNumber, String newText) {
        initializeMemento();
        lineContents.set(lineNumber - 1, new StringBuilder(newText));
        return currentMemento;
    }

    public Memento deleteText(int lineNumber) {
        initializeMemento();
        lineContents.remove(lineNumber - 1);
        return currentMemento;
    }

    public void copyText(int lineNumber) {
        copiedText = lineContents.get(lineNumber - 1);
    }

    public Memento pastText(int lineNumber) {
        initializeMemento();
        if(lineNumber > lineContents.size()) {
            lineContents.add(new StringBuilder(copiedText));
        } else {
            lineContents.set(lineNumber - 1, new StringBuilder(copiedText));
        }
        return currentMemento;
    }

    public Memento restore(Memento memento) {
        initializeMemento();
        lineContents = new ArrayList<>(memento.getLineContents());
        return currentMemento;
    }

    private void initializeMemento() {
        currentMemento = new Memento(lineContents);
    }

    public String getContentAsString() {
        StringBuilder wholeContent = new StringBuilder();
        int lineNumber = 0;
        wholeContent.append("====================================");
        wholeContent.append("\n");
        for(StringBuilder sb : lineContents) {
            wholeContent.append(++lineNumber);
            wholeContent.append(". ");
            wholeContent.append(sb);
            wholeContent.append("\n");
        }
        wholeContent.append("====================================");
        wholeContent.append("\n");
        return wholeContent.toString();
    }

}
