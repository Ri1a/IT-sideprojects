#!/bin/bash
#0x06armstrong-numbers

echo "Please enter a number:"

read input

inLength=${#input}

counter=0
solution=0

while [ $counter -lt $inLength ]

do

	char=${input:$counter:1}
	((counter++))
	let  "res1 = $char**$inLength"
	let "solution = solution + res1"

done


if [ $solution = $input ]
then
	echo "$input is an Armstrong number"
else
	echo "$input is not an Armstrong number"
fi
