#!/bin/bash
#0x05Scrabble-score

echo "Please enter a word:"

read input

inLength=${#input}

counter=0
solution=0

while [ $counter -lt $inLength ]

do

        char=${input:$counter:1}

	case $char in
	a|e|i|o|u|l|n|r|s|t)
	let "solution = solution + 1"
	;;
	d|g)
	let "solution = solution + 2"
	;;
	b|c|m|p)
	let "solution = solution + 3"
	;;
	f|h|v|w|y)
	let "solution = solution + 4"
	;;
        k)
        let "solution = solution + 5"
	;;
        j|x)
        let "solution = solution + 8"
	;;
        q|z)
        let "solution = solution + 10"
	esac

	((counter++))


done

echo $solution
