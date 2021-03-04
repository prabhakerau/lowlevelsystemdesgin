package com.lld.questions;

public class Main {

    public static void main(String[] args) {
	    TextEditorManager textEditorManager = new TextEditorManager();
	    textEditorManager.addText("Below are steps to solve LLSD questions in interview.! ");
	    textEditorManager.addText("Step 1 : Detail out the requirement");
	    textEditorManager.addText("Step 2 : Identify the objects");
		textEditorManager.addText("Step 3 : Identify the relationships between the objects");
		textEditorManager.addText("Step 4 : Derive class diagram");
		textEditorManager.addText("Step 5 : Implement the classes with actual code");
		textEditorManager.display();


		textEditorManager.editText(2, "Step 1 : Detail out / clarify the requirement");
		System.out.println("After edit operation :");
		textEditorManager.display();

		textEditorManager.copyText(6);
		textEditorManager.deleteText(6);
		System.out.println("After delete operation :");
		textEditorManager.display();

		textEditorManager.undo();
		System.out.println("After undo operation :");
		textEditorManager.display();

		textEditorManager.redo();
		System.out.println("After redo operation :");
		textEditorManager.display();

		textEditorManager.pasteText(6);
		System.out.println("After paste operation :");
		textEditorManager.display();
    }
}
