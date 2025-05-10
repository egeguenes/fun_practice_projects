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
} TokenLiteral;

TokenLiteral generate_number(char current, FILE *file) {
    TokenLiteral token;
    token.type = INT;
    int value = 0;
    while (isdigit(current) && current != EOF) {
        if (!isdigit(current)) break;
        value += (int) current - '0';
        printf("%c", current);
        current = fgetc(file);
    }
    token.value = value;
    return token;
}

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
            TokenLiteral test_token = generate_number(current, file);
            test_token = generate_number(current, file);
            printf("Test token value %d", test_token.value);
            // printf("FOUND DIGIT: %d\n", (int)current - 48);
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
