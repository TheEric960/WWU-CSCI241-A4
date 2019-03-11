#!/bin/bash

mkdir outputs

gradle -q run --args="basic data/Test00.txt A" > outputs/Test00_A.txt
printf "\n"
echo "####################################################################################"
echo "############################## Test00.txt A ########################################"
echo "####################################################################################"
printf "\n\n\n\n\n"
dif=$(diff outputs/Test00_A.txt targets/Test00_A.txt)
if [ -z "$dif" ]; then
    printf "Test 1 passed"
else
    printf "Test 1 failed\n"
    printf "=============\n< \"Your output\"\n---\n> \"Expected output\"\n=============\n"
    diff outputs/Test00_A.txt targets/Test00_A.txt
fi
printf "\n\n\n\n\n"
gradle -q run --args="basic data/Test00.txt A B" > outputs/Test00_AToB.txt
printf "\n"
echo "#########################################################################################"
echo "############################## Test00.txt A to B ########################################"
echo "#########################################################################################"
printf "\n\n\n\n\n"
dif=$(diff outputs/Test00_AToB.txt targets/Test00_AToB.txt)
if [ -z "$dif" ]; then
    printf "Test 2 passed"
else
    printf "Test 2 failed\n"
    printf "=============\n< \"Your output\"\n---\n> \"Expected output\"\n=============\n"
    diff outputs/Test00_AToB.txt targets/Test00_AToB.txt
fi
printf "\n\n\n\n\n"



gradle -q run --args="basic data/Test01.txt City2" > outputs/Test01_City2.txt
printf "\n"
echo "########################################################################################"
echo "############################## Test01.txt City2 ########################################"
echo "########################################################################################"
printf "\n\n\n\n\n"
dif=$(diff outputs/Test01_City2.txt targets/Test01_City2.txt)
if [ -z "$dif" ]; then
    printf "Test 3 passed"
else
    printf "Test 3 failed\n"
    printf "=============\n< \"Your output\"\n---\n> \"Expected output\"\n=============\n"
    diff outputs/Test01_City2.txt targets/Test01_City2.txt
fi
printf "\n\n\n\n\n"
gradle -q run --args="basic data/Test01.txt City2 City1" > outputs/Test01_City2ToCity1.txt
printf "\n"
echo "#################################################################################################"
echo "############################## Test01.txt City2 to City1 ########################################"
echo "#################################################################################################"
printf "\n\n\n\n\n"
dif=$(diff outputs/Test01_City2ToCity1.txt targets/Test01_City2ToCity1.txt)
if [ -z "$dif" ]; then
    printf "Test 4 passed"
else
    printf "Test 4 failed\n"
    printf "=============\n< \"Your output\"\n---\n> \"Expected output\"\n=============\n"
    diff outputs/Test01_City2ToCity1.txt targets/Test01_City2ToCity1.txt
fi
printf "\n\n\n\n\n"



gradle -q run --args="basic data/Test02.txt Cleveland" > outputs/Test02_Cleveland.txt
printf "\n"
echo "############################################################################################"
echo "############################## Test02.txt Cleveland ########################################"
echo "############################################################################################"
printf "\n\n\n\n\n"
dif=$(diff outputs/Test02_Cleveland.txt targets/Test02_Cleveland.txt)
if [ -z "$dif" ]; then
    printf "Test 5 passed"
else
    printf "Test 5 failed\n"
    printf "=============\n< \"Your output\"\n---\n> \"Expected output\"\n=============\n"
    diff outputs/Test02_Cleveland.txt targets/Test02_Cleveland.txt
fi
printf "\n\n\n\n\n"
gradle -q run --args="basic data/Test02.txt Cleveland Norfolk" > outputs/Test02_ClevelandToNorfolk.txt
printf "\n"
echo "#######################################################################################################"
echo "############################## Test02.txt Cleveland to Norfolk ########################################"
echo "#######################################################################################################"
printf "\n\n\n\n\n"
dif=$(diff outputs/Test02_ClevelandToNorfolk.txt targets/Test02_ClevelandToNorfolk.txt)
if [ -z "$dif" ]; then
    printf "Test 6 passed"
else
    printf "Test 6 failed\n"
    printf "=============\n< \"Your output\"\n---\n> \"Expected output\"\n=============\n"
    diff outputs/Test02_ClevelandToNorfolk.txt targets/Test02_ClevelandToNorfolk.txt
fi
printf "\n\n\n\n\n"



gradle -q run --args="basic data/Test03.txt KansasCity" > outputs/Test03_KansasCity.txt
printf "\n"
echo "#############################################################################################"
echo "############################## Test03.txt KansasCity ########################################"
echo "#############################################################################################"
printf "\n\n\n\n\n"
dif=$(diff outputs/Test03_KansasCity.txt targets/Test03_KansasCity.txt)
if [ -z "$dif" ]; then
    printf "Test 7 passed"
else
    printf "Test 7 failed\n"
    printf "=============\n< \"Your output\"\n---\n> \"Expected output\"\n=============\n"
    diff outputs/Test03_KansasCity.txt targets/Test03_KansasCity.txt
fi
printf "\n\n\n\n\n"
gradle -q run --args="basic data/Test03.txt KansasCity Melbourne" > outputs/Test03_KansasCityToMelbourne.txt
printf "\n"
echo "##########################################################################################################"
echo "############################## Test03.txt KansasCity to Melbourne ########################################"
echo "##########################################################################################################"
printf "\n\n\n\n\n"
dif=$(diff outputs/Test03_KansasCityToMelbourne.txt targets/Test03_KansasCityToMelbourne.txt)
if [ -z "$dif" ]; then
    printf "Test 8 passed"
else
    printf "Test 8 failed\n"
    printf "=============\n< \"Your output\"\n---\n> \"Expected output\"\n=============\n"
    diff outputs/Test03_KansasCityToMelbourne.txt targets/Test03_KansasCityToMelbourne.txt
fi
printf "\n\n\n\n\n"



gradle -q run --args="basic data/Test04.txt Louisville" > outputs/Test04_Louisville.txt
printf "\n"
echo "#############################################################################################"
echo "############################## Test04.txt Louisville ########################################"
echo "#############################################################################################"
printf "\n\n\n\n\n"
dif=$(diff outputs/Test04_Louisville.txt targets/Test04_Louisville.txt)
if [ -z "$dif" ]; then
    printf "Test 9 passed"
else
    printf "Test 9 failed\n"
    printf "=============\n< \"Your output\"\n---\n> \"Expected output\"\n=============\n"
    diff outputs/Test04_Louisville.txt targets/Test04_Louisville.txt
fi
printf "\n\n\n\n\n"
gradle -q run --args="basic data/Test04.txt Louisville Denver" > outputs/Test04_LouisvilleToDenver.txt
printf "\n"
echo "#######################################################################################################"
echo "############################## Test04.txt Louisville to Denver ########################################"
echo "#######################################################################################################"
printf "\n\n\n\n\n"
dif=$(diff outputs/Test04_LouisvilleToDenver.txt targets/Test04_LouisvilleToDenver.txt)
if [ -z "$dif" ]; then
    printf "Test 10 passed"
else
    printf "Test 10 failed\n"
    printf "=============\n< \"Your output\"\n---\n> \"Expected output\"\n=============\n"
    diff outputs/Test04_LouisvilleToDenver.txt targets/Test04_LouisvilleToDenver.txt
fi
printf "\n\n\n\n\n"
