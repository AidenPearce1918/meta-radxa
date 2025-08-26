# Enable package management
PACKAGE_CLASSES ?= "package_deb"
EXTRA_IMAGE_FEATURES += "package-management"

# Install core packages
IMAGE_INSTALL:append = " \
    apt \
    dpkg \
    gnupg \
    bash \
    busybox \
    coreutils \
    util-linux \
    e2fsprogs-resize2fs \
    dosfstools \
    parted \
    procps \
    findutils \
    grep \
    sed \
    tar \
    gzip \
    bzip2 \
    file \
    lsb-release \
    iproute2 \
    net-tools \
    wget \
    curl \
    iptables \
    wifi-firmware \
    wifi-init \
    wpa-supplicant \
    i2c-tools \
    pciutils \
    usbutils \
    ethtool \
    rsync \
    strace \
    lsof \
    bc \
    less \
    vim \
    zstd \
    man-db \
    vim-tiny \
    python3 \
    python3-pip \
    python3-setuptools \
    python3-wheel \
    libxcrypt \
    perl \
    pre-configs \
    ar \
"

# Optional: add any target-specific kernel modules here
# IMAGE_INSTALL:append = " kernel-module-aic8800-btlpm kernel-module-aic8800-bsp kernel-module-aic8800-fdrv"
