#!/bin/bash
clear
echo "This is information provided by mysystem.sh. Program starts now."

echo "Hello, $USER"
echo

echo "Today's date is `date`, this is week `date + "%V"`."
echo


echo "These users are currently connected:"
w | cut -d " " -f 1 - | grep -v USER | sort -u
echo

echo "This is `uname -s` running on `uname -m` processor."
echo

set -v

echo "Thsi is the uptime information"
utime

set +v


echo "the dbuggin is now over"

echo "bas ho gya"

