; --- RISC COMPILER OUTPUT ---
ORG 0x0000

; --- Function: main ---
n0:
    ; int a = 0
    ADDI R3, R0, 0
    STW R3, R0, 16384
    ; int b = 0
    ADDI R3, R0, 0
    STW R3, R0, 16388
    ; int res = 0
    ADDI R3, R0, 0
    STW R3, R0, 16392
    ; int nothing = 0
    ADDI R3, R0, 0
    STW R3, R0, 16396
    ; char c
    ; scan(a)
    SCAN R1
    STW R1, R0, 16384
    ; scan(c)
    SCAN R1
    STW R1, R0, 16400
    ; scan(b)
    SCAN R1
    STW R1, R0, 16388
    ; scan(nothing)
    SCAN R1
    STW R1, R0, 16396
    JMP n1
n1:
    ; IF (c == '+')
    LDW R1, R0, 16400 ; Загрузка переменной c
    ADDI R2, R0, 43 ; ASCII-константа '+'
    SUB R3, R1, R2
    BNE R3, R0, n3
    JMP n2
n2:
    ; res = a+b
    LDW R1, R0, 16384 ; Загрузка переменной a
    LDW R2, R0, 16388 ; Загрузка переменной b
    ADD R3, R1, R2
    STW R3, R0, 16392
    JMP n3
n3:
    ; IF (c == '-')
    LDW R1, R0, 16400 ; Загрузка переменной c
    ADDI R2, R0, 45 ; ASCII-константа '-'
    SUB R3, R1, R2
    BNE R3, R0, n5
    JMP n4
n4:
    ; res = a-b
    LDW R1, R0, 16384 ; Загрузка переменной a
    LDW R2, R0, 16388 ; Загрузка переменной b
    SUB R3, R1, R2
    STW R3, R0, 16392
    JMP n5
n5:
    ; IF (c == '/')
    LDW R1, R0, 16400 ; Загрузка переменной c
    ADDI R2, R0, 47 ; ASCII-константа '/'
    SUB R3, R1, R2
    BNE R3, R0, n7
    JMP n6
n6:
    ; res = a/b
    LDW R1, R0, 16384 ; Загрузка переменной a
    LDW R2, R0, 16388 ; Загрузка переменной b
    DIV R3, R1, R2
    STW R3, R0, 16392
    JMP n7
n7:
    ; IF (c == '*')
    LDW R1, R0, 16400 ; Загрузка переменной c
    ADDI R2, R0, 42 ; ASCII-константа '*'
    SUB R3, R1, R2
    BNE R3, R0, n9
    JMP n8
n8:
    ; res = a*b
    LDW R1, R0, 16384 ; Загрузка переменной a
    LDW R2, R0, 16388 ; Загрузка переменной b
    MUL R3, R1, R2
    STW R3, R0, 16392
    JMP n9
n9:
    ; print(res)
    LDW R1, R0, 16392
    PRINT R1
    ; print(nothing)
    LDW R1, R0, 16396
    PRINT R1
    JMP n10
n10:
