#!/bin/sh
set -e

WIFI_IF="wlan0"
WPA_CONF="/etc/wifi/wpa_supplicant.conf"

# Check if Wi-Fi interface exists
if ! ip link show "$WIFI_IF" > /dev/null 2>&1; then
    echo "Wi-Fi interface $WIFI_IF not found."
    exit 1
fi

# Load driver if not already loaded
if ! lsmod | grep -q '^aic8800'; then
    echo "Loading AIC8800 driver..."
    modprobe aic8800_fdrv || {
        echo "Failed to load AIC8800 driver!"
        exit 1
    }
    sleep 2
fi

# Kill any existing wpa_supplicant instance
if pidof wpa_supplicant > /dev/null; then
    echo "Killing old wpa_supplicant..."
    killall wpa_supplicant || true
    sleep 1
fi

# Bring interface up
ip link set "$WIFI_IF" up

# Start WPA supplicant
echo "Starting WPA supplicant..."
wpa_supplicant -B -i "$WIFI_IF" -c "$WPA_CONF" || {
    echo "Failed to start wpa_supplicant"
    exit 1
}

# Wait for connection
sleep 3

# Run DHCP client (kill old one if stuck)
if pidof udhcpc > /dev/null; then
    killall udhcpc || true
    sleep 1
fi

echo "Requesting IP via DHCP..."
udhcpc -i "$WIFI_IF" -q -s /usr/share/udhcpc/default.script

# Show obtained IP
IP=$(ip addr show "$WIFI_IF" | awk '/inet /{print $2}' | head -n1)
if [ -n "$IP" ]; then
    echo "Wi-Fi connected with IP: $IP"
else
    echo "Failed to obtain IP!"
    exit 1
fi
