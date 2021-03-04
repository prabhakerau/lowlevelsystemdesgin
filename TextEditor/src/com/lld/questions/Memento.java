package com.lld.questions;
import java.util.List;

public class Memento {

    private List<StringBuilder> lineContents;

    public Memento(List<StringBuilder> lineContents) {
        this.lineContents = List.copyOf(lineContents);
    }

    public List<StringBuilder> getLineContents() {
        return this.lineContents;
    }
}
