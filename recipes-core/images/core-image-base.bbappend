# core-image-base.bbappend

# Ensure wifi driver package is included in rootfs
IMAGE_INSTALL:append = " aic8800"
