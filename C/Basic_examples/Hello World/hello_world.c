/*hello_world.c
 *
 *Um das Programm kompilieren zu können: Terminal öffnen; gcc -o PROGRAM;./PROGAM
 *
 * */
#include <stdio.h>

int main (void) {
	printf("Hallo Welt\n");
	/*Formartierte Ein-/Ausgabe*/
	int i;
	printf("Bitte geben Sie eine Zahl ein: ");
	scanf("%d",&i);
	printf("Die Zahl die Sie eingegeben haben war %d\n", i);
	return 0;
}

