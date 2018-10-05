# Hello World C breakdown

```c
/*hello_world.c
 *
 *Um das Programm kompilieren zu können: Terminal öffnen; gcc -o PROGRAM;./PROGAM
 *
 * */
#include <stdio.h>

int main (void) {
	printf("Hallo Welt\n");
	return 0;
}
```
#include <stdio.h> -> kein Bestandteil der Sprache C; stdio = Standard Input / Output

int main (void)    -> Damit der Compiler weiss wo beginnen

printf("");	   -> Standardfunktion in C die in <stdio.h> deklariert ist.

return 0;	   -> Das Programm wurde ordnungsgemäss beendet.
