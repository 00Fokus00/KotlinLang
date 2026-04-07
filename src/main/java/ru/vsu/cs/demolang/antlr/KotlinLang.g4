grammar KotlinLang;

VAL: 'val';
VAR: 'var';
FUN: 'fun';
IF: 'if';
ELSE: 'else';
WHILE: 'while';
FOR: 'for';
RETURN: 'return';
RANGE: '..';

NUMBER: [0-9]+ ('.' [0-9]+)?;
ID: [a-zA-Z_][a-zA-Z0-9_]*;
STRING: '"' .*? '"';

COMMENT: '/*' .*? '*/' -> skip;
LINE_COMMENT: '//' ~[\r\n]* -> skip;
WS: [ \t\r\n]+ -> skip;

prog: (declaration | stmt)* EOF;

declaration: propertyDecl
    | functionDecl
    ;

// Переменные
propertyDecl: (VAL | VAR) ID (':' type)? ('=' expr)? ';'?;

// fun name(p1: Type): ReturnType { ... }
functionDecl: FUN ID '(' (funcParam (',' funcParam)*)? ')' (':' type)? block;

funcParam: ID ':' type;

block: '{' (stmt | declaration)* '}';

type: ID; // Int, String и тд.

stmt: assignment ';'?
    | expr ';'?
    | ifStmt
    | whileStmt
    | forStmt
    | returnStmt
    | 'break' ';'?
    | 'continue' ';'?;

assignment: ID '=' expr;

returnStmt: RETURN expr? ';'? ;
ifStmt: IF '(' expr ')' (stmt | block) (ELSE (stmt | block))?;
whileStmt: WHILE '(' expr ')' (stmt | block);
forStmt: FOR '(' ID 'in' expr ')' (stmt | block);

// Приорететы от высшего к низшему
expr: primary
    | expr (MUL | DIV | REM) expr
    | expr (ADD | SUB) expr
    | expr RANGE expr
    | expr (GT | GE | LT | LE) expr
    | expr (EQ | NE) expr
    | expr '&&' expr
    | expr '||' expr;

primary: NUMBER
    | STRING
    | ID '(' (expr (',' expr)*)? ')' // Вызов функции
    | ID
    | '(' expr ')'
    | prefixOp primary
    | primary postfixOp;

prefixOp: '++' | '--' | '-' | '!';
postfixOp: '++' | '--';

MUL: '*'; DIV: '/'; REM: '%';
ADD: '+'; SUB: '-';
GT: '>'; GE: '>='; LT: '<'; LE: '<=';
EQ: '=='; NE: '!=';