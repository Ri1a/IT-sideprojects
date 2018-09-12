/*sizeof_int.c */
#include <stdio.h>
#include <limits.h> /*INT_MIN und INT_MAX*/

int main(void) {
	printf("int Grösse: %d Byte\n", sizeof( int ) );
	printf("Wertebereich von %d bis %d\n", INT_MIN, INT_MAX);
	return 0;
}
