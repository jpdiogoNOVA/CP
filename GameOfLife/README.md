# CP/GameOfLife

## Notas da prática

`Commandos utilizados:`

```c

// Compiles the 4 files and generates the executable glife
make // (bash)

// Regra geral para correr 
./glife GENERATIONS INPUT_FILE // (bash)
//Exemplo
.glife 100 tests/9

// 70 percento 200 linhas 70 colunas: gera um board com estas características
python3 board.py 70 200 70


```

`Ficheiros:`

Main.c;

config.c;

game.c;



`Terminal ANSI Codes`:

printf("%c%d%dH", '\0x1b', 12, 54)

`Extra:`

Flags -p(tornar a simulação mais lenta) e -q (escrever apenas o board final)

`Comparar sequencial com paralela:`

Redirigir output da versão sequencial e paralela

seq > f1
par > f2

diff f1 f2 // Só diz alguma coisa se forem diferentes

