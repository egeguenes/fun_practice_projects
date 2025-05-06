#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>

typedef enum {
    SEMI,
    OPEN_PAREN,
    CLOSE_PAREN,
} TypeSeperator;

typedef enum {
    EXIT,
} TypeKeyword;

typedef enum {
    INT,
} TypeLiteral;

typedef struct {
    TypeKeyword type;
} TokenKeyword;

typedef struct {
    TypeSeperator tpye;
} TokenSeperator;

typedef struct {
    TypeLiteral type;
    int value;
} TokeLiteral;

void lexer(FILE *file) {
    char current = fgetc(file);

    while(current != EOF) {
        if (current == ';') {
            printf("FOUND SEMICOLON\n");
        } else if (current == '(') {
            printf("FOUND OPENING BRACKET\n");
        } else if (current == ')') {
            printf("FOUND CLOSING BRACKET\n");
        } else if (isdigit(current)) {
            printf("FOUND DIGIT: %d\n", (int)current - 48);
        } else if (isalpha(current)) {
            printf("FOUND CHARACTER: %c\n", current);
        }
        current = fgetc(file);
    }
}

void file_stuff() {
    FILE *file = fopen("denem.unl", "r");
    if (file == NULL) {
        return;
    }
    lexer(file);
    fclose(file);
}

int main(void) {
    file_stuff();
}
