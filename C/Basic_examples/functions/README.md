Download the function_1.c file and compile it in the terminal with: gcc function_1.c -o function_1.

Now you can run the program with ./function_1 and you should see the following output:

0 1 1
1 2 -3
2 4 9
3 8 -27
4 16 81
5 32 -243
6 64 729
7 128 -2187
8 256 6561
9 512 -19683

## Breakdown

The ```int power(int m, int n);``` just before ```main()``` says that power is a function that expects two int arguments and returns an int.

```c
int main() {

	int i;

	for (i = 0; i < 10; ++i)
		printf("%d %d %d\n", i, power(2,i), power(-3,i));
	return 0;
}
```

In the main function we call the power function twice. Each call passes two arguments to power. The for-loop iterates until i is 9.

```c
int power(int base, int n) {
	int i, p;

	p = 1;
	for(i = 1; i <= n; ++i)
		p = p * base;
	return p;
}
```

This is the power function. Here we declare two variables and set the variable p equals 1. Then we loop through i and return p.


