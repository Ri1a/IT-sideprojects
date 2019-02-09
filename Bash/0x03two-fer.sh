#!/bin/bash

echo "Bitte geben Sie einen Namen ein:"

read input

if [ -n "$input" ]
then
	echo "One for $input, one for me."

else
echo "One for X, one for me."

fi
