/* implizites und explizites Typecasting */

#include <stdio.h>

int main(void) {
	int x = 5, y = 2;
	float z;
	//Implizite Datenumwandlung
	z = x / y;
	printf("Implizites Typecasting\n\n");
	printf("%f\n\n", z);

	//Explizite Datenumwandlung
	z = (float) x / (float) y;
	printf("Explizites Typecasting\n\n");
	printf("%f\n", z);
	return 0;
}
