HL.class: HL.jjt HLEval.java
	jjtree HL.jjt
	javacc ./AST/HL.jj
	javac @options  AST/*.java
	javac @options  *.java
