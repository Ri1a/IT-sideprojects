#!/bin/bash

#0x04Grains

for fields in {1..64}

do

let solution="(2**$fields+1) - 1"

echo $solution

done
