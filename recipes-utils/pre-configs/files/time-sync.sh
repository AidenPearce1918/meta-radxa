#!/bin/sh
# Fetch UTC time from HTTP Date header and set system clock
DATE=$(curl -ksI https://google.com | grep -i '^date:' | cut -d' ' -f2-)
if [ -n "$DATE" ]; then
    date -s "$DATE"
fi
