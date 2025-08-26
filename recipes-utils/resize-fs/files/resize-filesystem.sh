#!/bin/sh
# Resize rootfs partition on first boot (dynamic SD card detection)

FLAG_FILE="/.resized"
[ -f "$FLAG_FILE" ] && exit 0

# Detect the root partition device (e.g., /dev/mmcblk1p9)
ROOT_DEV=$(findmnt -n -o SOURCE /)

# Detect the parent disk
DISK=$(lsblk -no pkname "$ROOT_DEV")
DISK="/dev/$DISK"

# Extract the partition number
PART_NUM=$(echo "$ROOT_DEV" | grep -o '[0-9]\+$')
PARTITION="$ROOT_DEV"

echo "Detected root partition: $PARTITION on disk: $DISK (partition number $PART_NUM)"

#Updating partition info
parted -s "$DISK" print || true

# Resize the partition to use full disk
echo "Resizing partition $PART_NUM on $DISK to full disk..."
parted -s "$DISK" resizepart "$PART_NUM" 100%

# Resize filesystem
echo "Resizing filesystem on $PARTITION..."
resize2fs "$PARTITION"

# Mark as done
touch "$FLAG_FILE"
echo "Rootfs resize complete."
