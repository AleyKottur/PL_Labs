grammar Variant1;

// ========= Parser Rules =========

source        : sourceItem* EOF ;
sourceItem    : funcDef ;

funcDef       : funcSignature (block | ';') ;

funcSignature : typeRef? Identifier '(' argDefList? ')' ;
argDefList    : argDef (',' argDef)* ;
argDef        : typeRef? Identifier ;

typeRef       : builtinType
              | Identifier
              | typeRef '[' ','* ']' ;

builtinType   : 'bool' | 'byte' | 'int' | 'uint' | 'long' | 'ulong' | 'char' | 'string' ;

block         : '{' statement* '}' ;

statement     : varDecl
              | ifStmt
              | whileStmt
              | doWhileStmt
              | breakStmt
              | exprStmt
              | block
              ;

varDecl       : typeRef varInitList ';' ;
varInitList   : varInit (',' varInit)* ;
varInit       : Identifier ('=' expr)? ;

varDeclAssign       : varInitListAssign ';' ;
varInitListAssign   : varInitAssign ;
varInitAssign       : Identifier ('=' expr)? ;

ifStmt        : 'if' '(' expr ')' statement ('else' statement)? ;
whileStmt     : 'while' '(' expr ')' statement ;
doWhileStmt   : 'do' block 'while' '(' expr ')' ';' ;
breakStmt     : 'break' ';' ;
exprStmt      : expr ';' ;

expr          : expr '=' expr*                    # Assign
              | expr binOp expr                   # Binary
              | unOp expr                         # Unary
              | '(' expr ')'                      # Paren
              | expr '(' exprList? ')'            # Call
              | expr '[' exprList? ']'            # Indexer
              | Identifier                        # Id
              | literal                           # Lit
              ;

exprList      : expr (',' expr)* ;

binOp         : '||' | '&&'
              | '==' | '!=' | '<=' | '>=' | '<' | '>'
              | '+' | '-' | '*' | '/' | '%'
              | '&' | '|' | '^' | '<<' | '>>' ;

unOp          : '!' | '~' | '-' | '+' ;

literal       : BoolLiteral
              | StringLiteral
              | CharLiteral
              | HexLiteral
              | BitLiteral
              | DecLiteral ;

// ========= Lexer Rules =========

BoolLiteral     : 'true' | 'false' ;
StringLiteral   : '"' (~["\\] | '\\' .)* '"' ;
CharLiteral     : '\'' (~['\\] | '\\' .) '\'' ;
HexLiteral      : '0' [xX] [0-9a-fA-F]+ ;
BitLiteral      : '0' [bB] [01]+ ;
DecLiteral      : [0-9]+ ;

Identifier      : [a-zA-Z_] [a-zA-Z_0-9]* ;

//Comment         : '//' ~[\r\n]* -> skip ;
//BlockComment    : '/*' .*? '*/' -> skip ;
Whitespace      : [ \t\r\n]+ -> skip ;