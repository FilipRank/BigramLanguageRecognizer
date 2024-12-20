The Bigram Language recognizer tool uses character-level bigrams
such as `iu`, `ti`, `th`, and the like, to predict what language
a piece of text is. It also works on simple encryption algorithms
that rely on substition, such as the Caesar cipher, to determine
the language of the encrypted text. This tool does not work very well
on short texts, as it's rather simple in concept: it takes the ten
highest proportions of bigrams (also referred to as probabilities) of a given input text, and
compares them with the previously gathered data of the ten highest
proportions of bigrams for each available language. (To see a list of
available languages for recognition, run the `ls-languages` command
in the tool's CLI.) It does this by treating the top 10 proportions
as 10-dimensional vectors, and comparing the distance between them. The vector that
is closest to the vector generated by the input text will be picked,
and the language associated with it will be given as output.

Aside from its main functionality, this tool also has commands for
calculating the frequency and proportion of bigrams in a given
text. You can see all commands by running the `help` command once
inside the CLI.

## Install & Run
First, clone this repository in the destination directory of your
choice:
```
git clone "https://github.com/FilipRank/BigramLanguageRecognizer"
```
Alternatively, you can download the zip file.

From here on, there are two ways you may go about
running the tool:
### First way
You can run this tool in the IDE of your choice by running
the main method of the Main.java file found inside the CLI package.
### Second way
You can run this tool directly inside a terminal or command prompt.

1. Make sure you're inside the root directory of this repo.
2. From the root directory, run this command:
```
java -jar out/artifacts/BigramLanguageRecognizer_jar/BigramLanguageRecognizer.jar 
```
