#!/bin/sh
# Stop Wi-Fi connection using udhcpc

# Release DHCP lease
if ip link show wlan0 > /dev/null 2>&1; then
    udhcpc -i wlan0 -x release
fi

# Kill wpa_supplicant for wlan0
pkill -f "wpa_supplicant.*wlan0"

# Optional: unload driver
if lsmod | grep -q "aic8800"; then
    modprobe -r aic8800_fdrv   # or aic8800_sdio
fi
